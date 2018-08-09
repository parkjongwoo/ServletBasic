package member.test;

import java.util.List;

import member.dao.signin.MemberDao;
import member.dao.signin.MemberDaoImpl;
import member.model.Member;
import member.sql.SQL;
import mvc.model.page.PageGroupResult;
import mvc.service.PageManager;

public class TestMember {

	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImpl();
//		for(int i=1;i<20;i++) {
//			selectByPageNo(dao, i);			
//		}
		selectAll(dao);
		
//		Member memo = dao.selecteById("");
//		System.out.println("dao.selectByMemberid(15)=========");
//		System.out.println(memo);
//		System.out.println("==============================");
//		
//		Member member_insert = new Member();
//		member_insert.setMemberid("shoong");
//		member_insert.setPassword("ppppp");
//		member_insert.setName("박종우");
//		member_insert.setEmail("shoong1999@gmail.com");
//		dao.insert(member_insert);
//		
//		selectAll(dao);
//		
//		member_insert.setPassword("aaaaa");
//		member_insert.setName("박종우2");
//		member_insert.setEmail("shoong19992@gmail.com");
//		dao.update(member_insert);
//		
//		selectAll(dao);
//		
//		dao.delete("shoong");
//		selectAll(dao);
		
	}
	
	public static void selectAll(MemberDao dao) {		
		List<Member> list = dao.selectAll();
		
		System.out.println("select all=========");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("==============================");
	}
	
//	public static void selectByPageNo(MemberDao dao, PageManager pm) {		
//		List<Member> list = dao.select(pm);
//		PageGroupResult pgr = pm.getPageGroupResult(SQL.MEMO_ALL_COUNT);
//		System.out.println("select "+pgr.getSelectPageNumber()+" page=========");
//		for(int i=0;i<list.size();i++) {
//			System.out.println(list.get(i).toString());
//		}
//		System.out.println("==============================");
//	}
	
}
