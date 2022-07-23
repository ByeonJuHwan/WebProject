package QnA;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/qna/*")
public class QnA extends HttpServlet {
	qnaService qnaservice;
	qnaDAO dao;
	qnaVO qnavo;
	HttpSession session;
	
	public void init(ServletConfig config) throws ServletException {
		qnaservice = new qnaService();
		dao = new qnaDAO();
		qnavo= new qnaVO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nextPage = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		try {
			List<qnaVO> qnalist = new ArrayList();			
			if(action==null){
				qnalist=qnaservice.qnalists();
				request.setAttribute("qnalist", qnalist);
				nextPage="/물건/렌고쿠.jsp";
			}else if(action.equals("/listqna.do")) {
				qnalist=qnaservice.qnalists();
				request.setAttribute("qnalist", qnalist);
				nextPage="/물건/렌고쿠.jsp";
			}else if(action.equals("/addQnA.do")) {
				int articleNO=0;
				
				
				
				String answer = request.getParameter("answer");
				String way = request.getParameter("way");
				String content = request.getParameter("content");
				
				System.out.println("answwer :" + answer);
				System.out.println("way :" + way);
				
				qnavo.setAnswer(answer);
				qnavo.setWay(way);
				qnavo.setContent(content);
				
				articleNO = qnaservice.addArticle(qnavo);
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + "  alert('새글을 추가했습니다.');" + " location.href='" + request.getContextPath()
						+ "/qna/listqna.do';" + "</script>");
				return;
			}else if(action.equals("/QnAform.do")) {
				nextPage="/물건/QnAfrom.jsp";
			}
			else {
				nextPage="/물건/렌고쿠.jsp";
			}
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
