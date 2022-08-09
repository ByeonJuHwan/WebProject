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
import javax.servlet.http.HttpSession;


@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	MemberService memberservice;
	MemberVO membervo;
	HttpSession session;
	
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
				
				if((id.equals("admin") && id.length() != 0) && (pw.equals("1234")&& pw.length()!=0)) {
					memberList = memberservice.listMember();        //멤버 리스트를 만든다
					request.setAttribute("memberList", memberList); //멤버 리스트를 바인딩 해놓은다음 보낸다
					nextPage="/Admin/adminList.jsp";                
					/* PrintWriter out = response.getWriter();
					   out.println("<script>"+"alert('관리자님 환영합니다');"
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
						session=request.getSession();
						session.setAttribute("id", id);
						nextPage="/MainPage/Main.jsp";           //아이디가 있을 경우 로그인 성공 메세지와 함께 메인페이지로이동
					}else {
						
						request.setAttribute("result", result);
						nextPage="/LoginPage/login.jsp";        //아이디가 없을 경우 아이디가 일치하지 않습니다 메세지와 함께 다시 로그인페이지로 이동
					}
				}
				
			}else if(action.equals("/loginpage.do")) {          //로그인창 이동
				nextPage="/LoginPage/login.jsp";
			}else if(action.equals("/memberform.do")) {
				nextPage="/MemberForm/modmemberform.jsp";       //회원 가입 누르면 회원가입 창으로 이동 
			}else if(action.equals("/modmember.do")) {          //수정하기 버튼 누르면 수정페이지로 이동
				String id = request.getParameter("id");
				MemberVO memInfo = memberservice.modmember(id);
				request.setAttribute("memInfo", memInfo);
				nextPage="/MemberForm/modmemberform.jsp";
			}else if(action.equals("/modMember.do")) {          //수정후 반영
				String id = request.getParameter("id");
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				MemberVO membervo = new MemberVO(id,pw,name,email);
				memberservice.modmember(membervo);
				request.setAttribute("msg", "modified");
				nextPage = "/member/login.do";
			}else if (action.equals("/memberin.do")) {                   //회원가입창 이동
				nextPage="/MemberForm/memberform.jsp";
			}else if(action.equals("/addmember.do")) {                 //회원가입후 로그인창으로 이동
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				MemberVO membervo = new MemberVO();
				membervo.setId(id);
				membervo.setPwd(pwd);
				membervo.setName(name);
				membervo.setEmail(email);
				memberservice.insertMember(membervo);
				PrintWriter out = response.getWriter();
			    out.println("<script>"+"alert('회원가입을 환영합니다');"
									  +"location.href='"
									  +request.getContextPath()
									  +"/LoginPage/login.jsp"
									  +"';"
									  +"</script>");
					return; 
				
			}else if(action.equals("/delmember.do")) {             //회원삭제기능 추가
				String id = request.getParameter("id");
				memberservice.delmember(id);
				request.setAttribute("msg", "deleted");
				//nextPage 넣을것
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
