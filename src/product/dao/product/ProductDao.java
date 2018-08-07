package product.dao.product;

import java.util.List;

import product.model.Product;

public interface ProductDao {
	List<Product> selectAll();
	Product selectById(int productid);
	boolean insert(Product product);
	boolean update(Product product);
	boolean delete(int productid);
}
