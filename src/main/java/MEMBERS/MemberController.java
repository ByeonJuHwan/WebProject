package MEMBERS;

import java.io.IOException;
import java.io.PrintWriter;

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String action = request.getPathInfo();      //action 설
		System.out.println("arction : "+action);
		
		String id = request.getParameter("id");     //관리자 아이디 판별을 위한 id 받기
		String pw = request.getParameter("pw");   //관리자 비밀번호 판별을 위한 pw 받기
		
		PrintWriter out = response.getWriter();
			
		if((id.equals("admin") && id.length() != 0) && (pw.equals("0147")&& pw.length()!=0)){
			out.print("관리자님 환영합니다");
		}
			
	}
}
