package mvc.service;

import mvc.dao.page.PageDao;
import mvc.dao.page.PageDaoImpl;
import mvc.model.page.PageGroupResult;
import mvc.model.page.PageInfo;
import mvc.model.page.PageRowResult;
import mvc.sql.SQL;

public class PageManager2 {
	
	/**
	 * 보여줄 페이지
	 */
	private int requestPage;
	
	public PageManager2() {
		this(1);
	}
	public PageManager2(int requestPage) {
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		// 1부터 오름차순
		PageRowResult result = new PageRowResult();
		int start = (requestPage-1)*PageInfo.ROW_COUNT_PER_PAGE+1;
		result.setRowStartNumber(start);
		result.setRowEndNumber(start + PageInfo.ROW_COUNT_PER_PAGE-1);
		
//		int totalRow = 500;
//		// 마지막부터 내림차순
//		PageRowResult result = new PageRowResult();
//		int start = totalRow - (requestPage-1)*PageInfo.ROW_COUNT_PER_PAGE;
//		result.setRowStartNumber(start);
//		result.setRowEndNumber(start - PageInfo.ROW_COUNT_PER_PAGE+1);
		return result;
	}
	
	public PageGroupResult getPageGroupResult(String sql) {
		PageGroupResult result = new PageGroupResult();
//		PageInfo.SHOW_PAGE_COUNT;
		result.setSelectPageNumber(requestPage);
		
		PageDao dao = new PageDaoImpl();
		int start = 0;
		int end = 0;
		boolean isFirstGroup = false;
		boolean isLastGroup = false;
		int totalRecord = dao.getCount(SQL.MEMO_ALL_COUNT);
		int totalPages = (int)Math.ceil((double)totalRecord / PageInfo.ROW_COUNT_PER_PAGE);
		
		boolean isFind = false;
		for(int i=PageInfo.SHOW_PAGE_COUNT;i<=totalPages;i+=PageInfo.SHOW_PAGE_COUNT) {
			if(requestPage<=i) {
				isFind = true;
				result.setGroupStartNumber(i-PageInfo.SHOW_PAGE_COUNT+1);
				result.setGroupEndNumber(i);
				result.setBeforePage(isFirstGroup);
				result.setAfterPage(isLastGroup);
				break;
			}
		}
		if(!isFind) {//못찾은 경우 마지막 그룹
			
		}
		if(PageInfo.SHOW_PAGE_COUNT%2==0) {//짝수표시
			start = requestPage - PageInfo.SHOW_PAGE_COUNT/2+1;
			end = requestPage + PageInfo.SHOW_PAGE_COUNT/2;
			isFirstGroup = start<=1;
			isLastGroup = end>=totalPages;
			result.setGroupStartNumber(isFirstGroup?1:start);
			result.setGroupEndNumber(isLastGroup?totalPages:end);
			result.setBeforePage(isFirstGroup);
			result.setAfterPage(isLastGroup);
		}else {//홀수표시
			start = requestPage - PageInfo.SHOW_PAGE_COUNT/2;
			end = requestPage + PageInfo.SHOW_PAGE_COUNT/2;
			isFirstGroup = start<=1;
			isLastGroup = end>=totalPages;
			result.setGroupStartNumber(isFirstGroup?1:start);
			result.setGroupEndNumber(isLastGroup?totalPages:end);
			result.setBeforePage(isFirstGroup);
			result.setAfterPage(isLastGroup);
		}
		
		return result;
	}
}
