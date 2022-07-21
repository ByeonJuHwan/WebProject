package MEMBERS;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/byeon_member?user=root";
	private static final String user = "root";
	private static final String pwd = "milk0147";
	
	private Connection con;
	private PreparedStatement pstmt;
	private void conDB() {
			try {
				Class.forName(driver);
				System.out.println("SQL 드라이버 로딩 성공");
				con = DriverManager.getConnection(url, user, pwd);
				System.out.println("Connection 생성 성공");
			} catch (Exception e) {
				e.printStackTrace();
			
		}
	}
	public boolean findmember(String id){
		boolean result = false;
		try {
			conDB();
			String query = "select if(count(*)>0,'true','false') as result from byeon_member";
			query += " where id=?";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result =Boolean.parseBoolean(rs.getString("result"));
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<MemberVO> findAllmember(){
		List<MemberVO> memberList = new ArrayList();
		try {
			conDB();
			String query = "select id,pw,name,email,joinDate from byeon_member";
			pstmt=con.prepareStatement(query);
			System.out.println("query :" + query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO membervo = new MemberVO();
				membervo.setId(id);
				membervo.setPw(pw);
				membervo.setName(name);
				membervo.setEmail(email);
				membervo.setJoinDate(joinDate);
				memberList.add(membervo);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
	public MemberVO findidmember(String _id) {
		MemberVO memInfo=null;
		try {
			conDB();
			String query = "select * from byeon_member where id=?";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, _id);
			System.out.println(query);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String email = rs.getString("email");
			Date joinDate = rs.getDate("joinDate");
			
			memInfo = new MemberVO(id,pw,name,email,joinDate);
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return memInfo;
	}
	public void modmember(MemberVO membervo) {
		String id = membervo.getId();
		String pw = membervo.getPw();
		String name = membervo.getName();
		String email = membervo.getEmail();
		try {
			conDB();
			String query="update byeon_member set pw=?,name=?,email=? where id=? ";
			pstmt=con.prepareStatement(query);
			System.out.println("query :" + query);
			pstmt.setString(1, pw);
			pstmt.setString(2, name);
			pstmt.setString(3, email);
			pstmt.setString(4, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	public void addmember(MemberVO membervo) {
		try {
			conDB();
			String id = membervo.getId();
			String pw = membervo.getPw();
			String name = membervo.getName();
			String email = membervo.getEmail();
			String query = "insert into byeon_member(id,pw,name,email)" + "values(?,?,?,?)";
			System.out.println(query);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}
	public void removemember(String id) {
		try {
			conDB();
			String query = "delete from byeon_member where id = ?";
			System.out.println(query);
			pstmt=con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}