package MEMBERS;

import java.io.Reader;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDAO {
	private static SqlSessionFactory sqlMapper = null;
	public static SqlSessionFactory getInstance() {
		if(sqlMapper==null) {
			try {
				String resource = "mybatis/SqlMapConfig.xml";
				Reader reader = Resources.getResourceAsReader(resource);
				sqlMapper = new SqlSessionFactoryBuilder().build(reader);
				reader.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return sqlMapper;  //마이바티스 연결 설정 메소드 
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
		sqlMapper = getInstance();
		SqlSession session = sqlMapper.openSession();
		List<MemberVO> memberList =null;
		memberList = session.selectList("mapper.member.selectAllMemberList");
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
	public int addmember(MemberVO membervo) {
		sqlMapper=getInstance();
		SqlSession session = sqlMapper.openSession();
		int result=0;
		result=session.insert("mapper.member.insertMember",membervo);
		session.commit();
		return result;
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