package mvc.model.page;

public class PageRowResult {
	/**
	 * 페이지의 첫 레코드 번호
	 */
	private int rowStartNumber;
	/**
	 * 페이지의 마지막 레코드 번호
	 */
	private int rowEndNumber;
	
	public int getRowStartNumber() {
		return rowStartNumber;
	}
	public void setRowStartNumber(int rowStartNumber) {
		this.rowStartNumber = rowStartNumber;
	}
	public int getRowEndNumber() {
		return rowEndNumber;
	}
	public void setRowEndNumber(int rowEndNumber) {
		this.rowEndNumber = rowEndNumber;
	}
	
}
