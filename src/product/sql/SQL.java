package product.sql;

public class SQL {
	public static final String PRODUCT_SEQ_NAME = "SEQ_PRODUCT";
	public static final String PRODUCT_TABLE_NAME = "product";
	
	public static final String PRODUCT_COLUMN_NAME_PRODUCTID = "productid";
	public static final String PRODUCT_COLUMN_NAME_PRODUCTNAME = "productname";
	public static final String PRODUCT_COLUMN_NAME_DESCRIPTION = "description";
	public static final String PRODUCT_COLUMN_NAME_PRODUCTPRICE = "productprice";
	
	public static final String QUERY_SELECTALL = "SELECT * FROM PRODUCT";
	public static final String QUERY_SELECTALL_ORDERBY_ID = "SELECT * FROM PRODUCT ORDER BY "+PRODUCT_COLUMN_NAME_PRODUCTID+" DESC";
	public static final String QUERY_SELECTBY_ID = QUERY_SELECTALL+" WHERE "+PRODUCT_COLUMN_NAME_PRODUCTID+"=?";
	
	public static final String QUERY_INSERT = "INSERT INTO "+PRODUCT_TABLE_NAME+" VALUES (" +
			PRODUCT_SEQ_NAME+".NEXTVAL, ?, ?, ? )";
	
	public static final String QUERY_UPDATE = "UPDATE "+PRODUCT_TABLE_NAME+" SET " + 
								PRODUCT_COLUMN_NAME_PRODUCTNAME + "=?, " + 
								PRODUCT_COLUMN_NAME_DESCRIPTION + "=?, " + 
								PRODUCT_COLUMN_NAME_PRODUCTPRICE + "=? " + 
								" WHERE "+PRODUCT_COLUMN_NAME_PRODUCTID+"=?";
	public static final String QUERY_DELETEBY_ID = "DELETE "+PRODUCT_TABLE_NAME+
								" WHERE "+PRODUCT_COLUMN_NAME_PRODUCTID+"=?";
	
	
}
