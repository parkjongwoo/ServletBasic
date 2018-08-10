package member.dao.member;

import java.util.List;

import member.model.Member;

public interface MemberDao {
	List<Member> selectAll();
	Member selecteById(String memberid);
	boolean insert(Member signin);
	boolean update(Member signin);
	boolean delete(String memberid);
	Member getUserInfo(String memberid, String pw);
}
