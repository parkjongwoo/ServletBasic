package mvc.dao.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mvc.dao.BaseDao;
import mvc.model.Memo;
import mvc.sql.SQL;

public class MemoDaoImpl extends BaseDao implements MemoDao  {

	@Override
	public List<Memo> selectAll() {
		Connection con = null;
		List<Memo> result = new ArrayList<Memo>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMO_SELECT_ALL_ORDER_BY);
			rs = ps.executeQuery();
			while(rs.next()) {
				Memo memo = new Memo();
				memo.setMemoid(rs.getInt(SQL.MEMO_COLUMN_NAME_ID));
				memo.setName(rs.getString(SQL.MEMO_COLUMN_NAME_NAME));
				memo.setAge(rs.getInt(SQL.MEMO_COLUMN_NAME_AGE));
				
				result.add(memo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		
		return result;
	}

	@Override
	public Memo selectByMemoid(int memoid) {
		Connection con = null;
		Memo result = new Memo();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMO_SELECT_BY_ID);
			ps.setInt(1, memoid);
			rs = ps.executeQuery();
			while(rs.next()) {				
				result.setMemoid(rs.getInt(SQL.MEMO_COLUMN_NAME_ID));
				result.setName(rs.getString(SQL.MEMO_COLUMN_NAME_NAME));
				result.setAge(rs.getInt(SQL.MEMO_COLUMN_NAME_AGE));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(rs, ps, con);
		}
		
		return result;
	}
	
	@Override
	public boolean insert(Memo memo) {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMO_INSERT);
			ps.setString(1, memo.getName());
			ps.setInt(2, memo.getAge());			
			rs = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(null, ps, con);
		}
		
		return rs>0;
	}

	@Override
	public boolean update(Memo memo) {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMO_UPDATE);
			ps.setString(1, memo.getName());
			ps.setInt(2, memo.getAge());
			ps.setInt(3, memo.getMemoid());
			rs = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(null, ps, con);
		}
		return rs>0;
	}

	@Override
	public boolean delete(int memoid) {
		Connection con = null;
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMO_DELETE_BY_ID);
			ps.setInt(1, memoid);
			rs = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObjects(null, ps, con);
		}
		
		return rs>0;
	}
}
