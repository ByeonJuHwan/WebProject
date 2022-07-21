package QnA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class qnaDAO {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/byeon_member?user=root";
	private static final String user = "root";
	private static final String pwd = "milk0147";
	
	private Connection con;
	private PreparedStatement pstmt;
	private void connDB() {
			try {
				Class.forName(driver);
				System.out.println("SQL 드라이버 로딩 성공");
				con = DriverManager.getConnection(url, user, pwd);
				System.out.println("Connection 생성 성공");
			} catch (Exception e) {
				e.printStackTrace();
			
		}
	}
	
	public List<qnaVO> listqna(){
		List<qnaVO> qnalist = new ArrayList();
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return qnalist;
	}

}
