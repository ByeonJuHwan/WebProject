package MEMBERS;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	MemberService memberservice;
	MemberVO membervo;

	
	public void init(ServletConfig config) throws ServletException {
		memberservice = new MemberService();
		membervo = new MemberVO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String nextPage="";         //서블릿명령 수행후 다음 이동할 페이지 설정
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo();      //action 설
		System.out.println("arction : "+action);
		
		PrintWriter out = response.getWriter();
		
		try {
			if(action.equals("/login.do")){
				String id = request.getParameter("id");     //관리자 아이디 판별을 위한 id 받기
				String pw = request.getParameter("pw"); //관리자 비밀번호 판별을 위한 pw 받기
				
				
			}else if(action.equals("/memberform.do")) {
				nextPage="/MemberForm/memberform.jsp";
			}else {
				nextPage="/MainPage/Main.jsp";
			}
		
	
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
			
	}
}
