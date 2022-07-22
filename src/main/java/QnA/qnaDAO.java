package QnA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			connDB();
			String query = "select articleNO,answer,way,content,id,writeDate from byeon_QnA";
			pstmt=con.prepareStatement(query);
			System.out.println("query : "+ query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int articleNO = rs.getInt("articleNO");
				String answer = rs.getString("answer");
				String way = rs.getString("way");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				
				qnaVO qnavo = new qnaVO();
				qnavo.setArticleNO(articleNO);
				qnavo.setAnswer(answer);
				qnavo.setWay(way);
				qnavo.setContent(content);
				qnavo.setId(id);
				qnavo.setWriteDate(writeDate);
				qnalist.add(qnavo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return qnalist;
	}

}
