package QnA;

import java.util.List;

public class qnaService {
	qnaDAO dao = new qnaDAO();
	public List<qnaVO> qnalists(){
		List<qnaVO> qnalist = dao.listqna();
		return qnalist;
	}
}
