package product.dao.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import product.dao.BaseDao;
import product.model.Product;
import product.sql.SQL;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	@Override
	public List<Product> selectAll() {
		List<Product> result = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.QUERY_SELECTALL_ORDERBY_ID);
			rs = ps.executeQuery();
			while(rs.next()) {
				Product product = new Product();
				product.setProductid(rs.getInt(1));
				product.setProductname(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setProductprice(rs.getInt(4));
				result.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObject(rs, ps, con);
		}
		return result;
	}

	@Override
	public Product selectById(int productid) {
		Product result = new Product();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.QUERY_SELECTBY_ID);
			ps.setInt(1, productid);
			rs = ps.executeQuery();
			while(rs.next()) {
				result.setProductid(rs.getInt(1));
				result.setProductname(rs.getString(2));
				result.setDescription(rs.getString(3));
				result.setProductprice(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeDBObject(rs, ps, con);
		}
		return result;
	}

	@Override
	public boolean insert(Product product) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.QUERY_INSERT);
			ps.setString(1, product.getProductname());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getProductprice());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(null, ps, con);
		}
		return result>0;
	}

	@Override
	public boolean update(Product product) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.QUERY_UPDATE);
			ps.setString(1, product.getProductname());
			ps.setString(2, product.getDescription());
			ps.setInt(3, product.getProductprice());
			ps.setInt(4, product.getProductid());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(null, ps, con);
		}
		return result>0;
	}

	@Override
	public boolean delete(int productid) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			ps = con.prepareStatement(SQL.QUERY_DELETEBY_ID);
			ps.setInt(1, productid);			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDBObject(null, ps, con);
		}
		return result>0;
	}
	
}
