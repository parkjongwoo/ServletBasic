package member.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.dao.BaseDao;
import member.model.Member;
import member.sql.SQL;

public class MemberDaoImpl extends BaseDao implements MemberDao {

	@Override
	public List<Member> selectAll() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Member> result = new ArrayList<Member>();
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMBER_SELECT_ALL);
			rs = ps.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.setMemberid(rs.getString(1));
				member.setPassword(rs.getString(2));
				member.setName(rs.getString(3));
				member.setGender(rs.getString(4));
				member.setEmail(rs.getString(5));
				result.add(member);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(rs, ps, con);
		}
		return result;
	}

	@Override
	public Member selecteById(String memberid) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member result = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMBER_SELECT_BY_ID);
			ps.setString(1, memberid);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = new Member();
				result.setMemberid(rs.getString(1));
				result.setPassword(rs.getString(2));
				result.setName(rs.getString(3));
				result.setGender(rs.getString(4));
				result.setEmail(rs.getString(5));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(rs, ps, con);
		}
		return result;
	}

	@Override
	public boolean insert(Member member) {
		Connection con = null;
		PreparedStatement ps = null;		
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMBER_INSERT);
			ps.setString(1, member.getMemberid());
			ps.setString(2, member.getPassword());
			ps.setString(3, member.getName());
			ps.setString(4, member.getGender());
			ps.setString(5, member.getEmail());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(null, ps, con);
		}
		return result>0;
	}

	@Override
	public boolean update(Member member) {
		Connection con = null;
		PreparedStatement ps = null;		
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMBER_UPDATE);
			ps.setString(1, member.getPassword());
			ps.setString(2, member.getName());
			ps.setString(3, member.getGender());
			ps.setString(4, member.getEmail());
			ps.setString(5, member.getMemberid());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(null, ps, con);
		}
		return result>0;
	}
	
	@Override
	public boolean delete(String memberid) {
		Connection con = null;
		PreparedStatement ps = null;		
		int result = 0;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMBER_DELETE_BY_ID);
			ps.setString(1, memberid);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(null, ps, con);
		}
		return result>0;
	}
	
	@Override
	public Member getUserInfo(String memberid, String pw) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member result = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.MEMBER_LOGIN);
			ps.setString(1, memberid);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = new Member();
				result.setMemberid(rs.getString(1));
				result.setName(rs.getString(3));
				result.setGender(rs.getString(4));
				result.setEmail(rs.getString(5));
				System.out.println(result);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(rs, ps, con);
		}
		return result;
	}	
}
