package mvc.memoerror;

public class MemoError {
	private String nameErr;
	private String ageErr;
//	private boolean result;
	public String getNameErr() {
		return nameErr;
	}
	public void setNameErr(String nameErr) {
		this.nameErr = nameErr;
	}
	public String getAgeErr() {
		return ageErr;
	}
	public void setAgeErr(String ageErr) {
		this.ageErr = ageErr;
	}
	public boolean isResult() {
		return (nameErr != null && !nameErr.trim().isEmpty()) ||
				(ageErr != null && !ageErr.trim().isEmpty());
	}
//	public void setResult(boolean result) {
//		this.result = result;
//	}	
}
