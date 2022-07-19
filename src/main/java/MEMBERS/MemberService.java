package MEMBERS;

public class MemberService {
	MemberDAO dao = new MemberDAO();
	public boolean overlappedMember(String id) {
		return dao.findmember(id);
	}
}
