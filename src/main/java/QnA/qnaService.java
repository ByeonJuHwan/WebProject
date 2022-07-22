package QnA;

import java.util.List;

public class qnaService {
	qnaDAO qnadao;
	public qnaService() {
		qnadao  = new qnaDAO();
	}
	
	
	public List<qnaVO> qnalists(){
		List<qnaVO> qnalist = qnadao.listqna();
		return qnalist;
	}
}
