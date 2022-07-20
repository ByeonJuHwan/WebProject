package MEMBERS;

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
		System.out.println("action : "+action);
		
		
		
		try {
			List<MemberVO> memberList= new ArrayList();
			if(action.equals("/login.do")){
				String id = request.getParameter("id");     //관리자 아이디 판별을 위한 id 받기
				String pw = request.getParameter("pw"); //관리자 비밀번호 판별을 위한 pw 받기
				if((id.equals("admin") && id.length() != 0) && (pw.equals("0147")&& pw.length()!=0)){
					memberList = memberservice.listMember();        //멤버 리스트를 만든다
					request.setAttribute("memberList", memberList); //멤버 리스트를 바인딩 해놓은다음 보낸다
					
					nextPage="/Admin/adminList.jsp";                //
					/* PrintWriter out = response.getWriter();
					 * out.println("<script>"+"alert('관리자님 환영합니다');"
										  +"location.href='"
										  +request.getContextPath()
										  +"/Admin/adminList.jsp"
										  +"';"
										  +"</script>");
						return; 
						원래는 이렇게 "관리자님 환영합니다" 라는 메세지를 띄우고 싶었지만 계속 실행이 되지않아서 return문 때문이가해서 없앴더니 실행되었다.
						메세지는 adminList.jsp 에서 alert로 띄워야 할것같다.				  
					 */
				
					
				}else {
					boolean result = memberservice.overlappedMember(id);
					System.out.println(result);
					if(result == true) {
						nextPage="/MainPage/Main.jsp";           //아이디가 있을 경우 로그인 성공 메세지와 함께 메인페이지로이동
					}else {
						
						request.setAttribute("result", result);
						nextPage="/LoginPage/login.jsp";        //아이디가 없을 경우 아이디가 일치하지 않습니다 메세지와 함께 다시 로그인페이지로 이동
					}
				}
				
			}else if(action.equals("/memberform.do")) {
				nextPage="/MemberForm/modmemberform.jsp";
			}else if(action.equals("/modmember.do")) {
				String id = request.getParameter("id");
				MemberVO memInfo = memberservice.modmember(id);
				request.setAttribute("memInfo", memInfo);
				nextPage="/MemberForm/modmemberform.jsp";
			}else if(action.equals("/modMember.do")) {
				
			}
			else {
				nextPage="/MainPage/Main.jsp";
			}
		
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
			
	}
}
