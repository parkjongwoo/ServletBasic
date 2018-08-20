package ajax.dao.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ajax.model.Comment;
import member.dao.BaseDao;

public class CommentDaoImpl extends BaseDao implements CommentDao {
	
	
	@Override
	public Comment selectByNum(int num) {
		Comment result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement("SELECT * FROM TEST_COMMENT WHERE num=?");
			ps.setInt(1, num);
			rs = ps.executeQuery();			
			while(rs.next()) {		
				result = new Comment();
				result.setNum(rs.getInt(1));
				result.setWriter(rs.getString(2));
				result.setContent(rs.getString(3));
				result.setDatetime(rs.getDate(4));							
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			 closeDBObject(rs, ps, con);
		}
		
		
		return result;
	}
			
	@Override
	public List<Comment> selectCommentAll() {
		List<Comment> result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement("SELECT * FROM TEST_COMMENT");
			rs = ps.executeQuery();
			result = new ArrayList<Comment>();
			while(rs.next()) {
				Comment comment = new Comment();
				comment.setNum(rs.getInt(1));
				comment.setWriter(rs.getString(2));
				comment.setContent(rs.getString(3));
				comment.setDatetime(rs.getDate(4));
				result.add(comment);			
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			 closeDBObject(rs, ps, con);
		}
		
		
		return result;
	}

	@Override
	public boolean insert(Comment comment) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement("INSERT INTO TEST_COMMENT VALUES(SEQ_TEST_COMMENT_NUM.NEXTVAL,?,?,SYSDATE)");
			ps.setString(1, comment.getWriter());
			ps.setString(2, comment.getContent());
			result = ps.executeUpdate();			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			 closeDBObject(rs, ps, con);
		}
		
		
		return result>0;
	}

	@Override
	public Comment insertAndResult(Comment comment) {
		Comment result = null;
		int updateResult = 0;
		int currval = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			con.setAutoCommit(false);
			ps = con.prepareStatement("INSERT INTO TEST_COMMENT VALUES(SEQ_TEST_COMMENT_NUM.NEXTVAL,?,?,SYSDATE)");
			ps.setString(1, comment.getWriter());
			ps.setString(2, comment.getContent());
			updateResult = ps.executeUpdate();
		
			if(updateResult>0) {
				ps.close();
				ps = con.prepareStatement("SELECT SEQ_TEST_COMMENT_NUM.CURRVAL FROM DUAL");
				rs = ps.executeQuery();			
				while(rs.next()) {
					currval = rs.getInt(1);							
				}
				
				if(currval>0) {
					rs.close();
					ps.close();
					ps = con.prepareStatement("SELECT * FROM TEST_COMMENT WHERE num=?");
					ps.setInt(1, currval);
					rs = ps.executeQuery();			
					while(rs.next()) {		
						result = new Comment();
						result.setNum(rs.getInt(1));
						result.setWriter(rs.getString(2));
						result.setContent(rs.getString(3));
						result.setDatetime(rs.getDate(4));							
					}					
				}
			}			
			con.commit();
		} catch (SQLException e) {			
			e.printStackTrace();
			try {
				if(con!=null) {
					con.rollback();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			 closeDBObject(rs, ps, con);
		}		
		
		return result;
	}
	
	@Override
	public boolean delete(int num) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		try {
			con = getConnection();
			ps = con.prepareStatement("DELETE FROM TEST_COMMENT WHERE NUM=?");
			ps.setInt(1, num);
			result = ps.executeUpdate();			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			 closeDBObject(rs, ps, con);
		}		
		
		return result>0;
	}
	
	
}
