package mvc.dao.memo;

import java.util.List;

import mvc.model.Memo;

public interface MemoDao {
	List<Memo> selectAll();
	Memo selectByMemoid(int memoid);
	boolean insert(Memo memo);
	boolean update(Memo memo);
	boolean delete(int memoid);
}
