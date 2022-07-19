package MEMBERS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}