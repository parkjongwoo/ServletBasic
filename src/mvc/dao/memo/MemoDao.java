package mvc.dao.memo;

import java.util.List;

import mvc.model.Memo;
import mvc.service.PageManager;

public interface MemoDao {
	List<Memo> selectAll();
	List<Memo> select(PageManager pm);
	Memo selectByMemoid(int memoid);
	boolean insert(Memo memo);
	boolean update(Memo memo);
	boolean delete(int memoid);
}
