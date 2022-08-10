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
	public List<MemberVO> modmember(String id){
		List<MemberVO>memInfo = dao.findidmember(id);
		return memInfo;
	}
	public void modmember(MemberVO membervo) {
		dao.modmember(membervo);
	}
	public void insertMember(MemberVO membervo) {
		dao.addmember(membervo);
		
	} 
	public void delmember(String id) {
		dao.removemember(id); 
	}
	
}
