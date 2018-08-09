package member.test;

import java.util.List;

import member.dao.member.MemberDao;
import member.model.Member;

public class TestMember {

	public static void main(String[] args) {
		System.out.println("aaAbs*dfs2223".matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$"));
		System.out.println("abcde".matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$"));
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
