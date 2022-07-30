package QnA;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class qnaDAO {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://127.0.0.1:3306/byeon_member?user=root";
	private static final String user = "root";
	private static final String pwd = "milk0147";
	
	private Connection con;
	private PreparedStatement pstmt;
	HttpSession session;
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
	public int addqna(qnaVO qnavo) {
		int articleNO = getNewQnANO();
		
		try {
			connDB();
			String answer = qnavo.getAnswer();
			String way = qnavo.getWay();
			String content = qnavo.getContent();
			String id = qnavo.getId();
			String details = qnavo.getDetails();
			String query = "insert into byeon_QnA(articleNO,answer,way,content,id,details)"+"values(?,?,?,?,?,?)";
			System.out.println(query);
			
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setString(2, answer);
			pstmt.setString(3, way);
			pstmt.setString(4, content);
			pstmt.setString(5, id);
			pstmt.setString(6, details);
			pstmt.executeUpdate();
			pstmt.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return articleNO;
	}
	public int getNewQnANO() {
		try {
			connDB();
			String query = "select max(articleNO) from byeon_QnA";
			System.out.println(query);
			pstmt=con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				return(rs.getInt(1)+1);
			}
			rs.close();
			pstmt.close();
			con.close();
				
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public qnaVO selectQnA(int articleNO) {
		qnaVO qnavo = new qnaVO();
		try {
			connDB();
			String query = "select articleNO, answer , way, content , details, id , writeDate from byeon_QnA " + "where articleNO=?";
			pstmt = con.prepareStatement(query);
			System.out.println(query);
			pstmt.setInt(1, articleNO);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int _articleNO = rs.getInt("articleNO");
				String answer = rs.getString("answer");
				String way = rs.getString("way");
				String content = rs.getString("content");
				String details = rs.getString("details");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				
				qnavo.setArticleNO(_articleNO);
				qnavo.setAnswer(answer);
				qnavo.setWay(way);
				qnavo.setContent(content);
				qnavo.setDetails(details);
				qnavo.setId(id);
				qnavo.setWriteDate(writeDate);
			}
				rs.close();
				con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return qnavo;
	}
	
	public void changeQnA(int articleNO) {
		int _articleNO = articleNO;
		try {
			connDB();
			String query = "update byeon_QnA set "
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
