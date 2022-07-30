package QnA;

import java.util.List;



public class qnaService {
	qnaDAO qnadao;
	public qnaService() {
		qnadao  = new qnaDAO();
	}
	public int addArticle(qnaVO qnavo){
		return qnadao.addqna(qnavo);		
	}
	
	
	public List<qnaVO> qnalists(){
		List<qnaVO> qnalist = qnadao.listqna();
		return qnalist;
	}
	
	public qnaVO viewQnA(int articleNO) {
		qnaVO qnavo = null;
		qnavo = qnadao.selectQnA(articleNO);
		return qnavo;
		
	}
	public void modifyQnA(int articleNO) {
		qnadao.changeQnA(articleNO);
	}
	
}
