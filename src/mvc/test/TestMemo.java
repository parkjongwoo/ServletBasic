package mvc.test;

import java.util.List;

import mvc.dao.memo.MemoDaoImpl;
import mvc.model.Memo;

public class TestMemo {

	public static void main(String[] args) {
		MemoDaoImpl dao = new MemoDaoImpl();
		
		selectAll(dao);
		
		Memo memo = dao.selectByMemoid(15);
		System.out.println("dao.selectByMemoid(15)=========");
		System.out.println(memo);
		System.out.println("==============================");
		
		Memo memo_insert = new Memo();
		memo_insert.setName("길한용");
		memo_insert.setAge(111);
		dao.insert(memo_insert);
		
		selectAll(dao);
		
		memo_insert.setMemoid(22);
		memo_insert.setName("길한용_수정");
		memo_insert.setAge(222);
		dao.update(memo_insert);
		
		selectAll(dao);
		
		dao.delete(22);
		selectAll(dao);
	}
	
	public static void selectAll(MemoDaoImpl dao) {		
		List<Memo> list = dao.selectAll();
		
		System.out.println("select all=========");
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).toString());
		}
		System.out.println("==============================");
	}

}
