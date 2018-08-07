package product.model;

public class Product {
	private int productid;
	private String productname;
	private String description;
	private int productprice;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	
	@Override
	public String toString() {
		return "productid: "+productid+" productname: "+productname+" description: "+description+" productprice:"+productprice;
	}
}
