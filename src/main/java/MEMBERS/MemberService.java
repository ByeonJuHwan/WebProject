package MEMBERS;

import java.util.List;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	
	public boolean overlappedMember(String id) {
		return dao.findmember(id);
	}
	public List<MemberVO> listMember() {
		List<MemberVO> memberList= dao.findAllmember();
		return memberList;
	}
	public MemberVO modmember(String id){
		MemberVO memInfo = dao.findidmember(id);
		return memInfo;
	}
	public void modmember(MemberVO membervo) {
		dao.modmember(membervo);
	}
	
}
