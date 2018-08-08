package mvc.model.page;

public class PageGroupResult {
	/**
	 * 페이지 네비의 첫 번호
	 */
	private int groupStartNumber;
	/**
	 * 페이지 네비의 마지막 번호
	 */
	private int groupEndNumber;
	
	/**
	 * 네비 이전 페이지가 있는지 여부
	 */
	private boolean beforePage = true;
	/**
	 * 네비 이후 페이지가 있는지 여부
	 */
	private boolean afterPage = true;
	/**
	 * 현재 페이지 번호
	 */
	private int selectPageNumber;
	
	public int getGroupStartNumber() {
		return groupStartNumber;
	}
	public void setGroupStartNumber(int groupStartNumber) {
		this.groupStartNumber = groupStartNumber;
	}
	public int getGroupEndNumber() {
		return groupEndNumber;
	}
	public void setGroupEndNumber(int groupEndNumber) {
		this.groupEndNumber = groupEndNumber;
	}
	public boolean isBeforePage() {
		return beforePage;
	}
	public void setBeforePage(boolean beforePage) {
		this.beforePage = beforePage;
	}
	public boolean isAfterPage() {
		return afterPage;
	}
	public void setAfterPage(boolean afterPage) {
		this.afterPage = afterPage;
	}
	public int getSelectPageNumber() {
		return selectPageNumber;
	}
	public void setSelectPageNumber(int selectPageNumber) {
		this.selectPageNumber = selectPageNumber;
	}
	
	
}
