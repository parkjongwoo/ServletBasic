package mvc.test;

import java.util.List;

import mvc.dao.memo.MemoDaoImpl;
import mvc.model.Memo;
import mvc.model.page.PageGroupResult;
import mvc.service.PageManager;
import mvc.sql.SQL;

public class TestMemo {

	public static void main(String[] args) {
//		MemoDaoImpl dao = new MemoDaoImpl();
//		for(int i=1;i<20;i++) {
//			selectByPageNo(dao, i);			
//		}
//		selectAll(dao);
//		
//		Memo memo = dao.selectByMemoid(15);
//		System.out.println("dao.selectByMemoid(15)=========");
//		System.out.println(memo);
//		System.out.println("==============================");
//		
//		Memo memo_insert = new Memo();
//		memo_insert.setName("길한용");
//		memo_insert.setAge(111);
//		dao.insert(memo_insert);
//		
//		selectAll(dao);
//		
//		memo_insert.setMemoid(22);
//		memo_insert.setName("길한용_수정");
//		memo_insert.setAge(222);
//		dao.update(memo_insert);
//		
//		selectAll(dao);
//		
//		dao.delete(22);
//		selectAll(dao);
		
//		for(int i=0;i<200;i++) {
//			String uuid = "다승왕"+i;
//			System.out.println(uuid);
//			Memo memo = new Memo();
//			memo.setAge((int)Math.round(Math.random()*100));
//			memo.setName(uuid);
//			dao.insert(memo);
//		}
//		for(int i=1;i<10;i++) {
//			PageManager pm = new PageManager(i);
//			System.out.println("========================");
//			System.out.println("requestPage:"+i);
//			System.out.println("start:"+pm.getPageRowResult().getRowStartNumber());
//			System.out.println("end:"+pm.getPageRowResult().getRowEndNumber());
//			System.out.println("========================");
//			
//		}
		
//		for(int i=1;i<100;i++) {
//			PageManager pm = new PageManager(i);
//			PageGroupResult result = pm.getPageGroupResult(SQL.MEMO_ALL_COUNT);
//			System.out.println("========================");
//			System.out.println("requestPage:"+i);
//			System.out.println("requestPage:"+result.getSelectPageNumber());
//			System.out.println("start:"+result.getGroupStartNumber());
//			System.out.println("end:"+result.getGroupEndNumber());
//			System.out.println("isAfter:"+result.isAfterPage());
//			System.out.println("isBefore:"+result.isBeforePage());			
//			System.out.println("========================");
//			
//		}
	}
	
	public static void selectAll(MemoDaoImpl dao) {		
		List<Memo> list = dao.selectAll();
		
		System.out.println("select all=========");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("==============================");
	}
	
	public static void selectByPageNo(MemoDaoImpl dao, PageManager pm) {		
		List<Memo> list = dao.select(pm);
		PageGroupResult pgr = pm.getPageGroupResult();
		System.out.println("select "+pgr.getSelectPageNumber()+" page=========");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("==============================");
	}
}
