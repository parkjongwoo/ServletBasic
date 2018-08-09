package member.membererror;

public class LoginError {
	private String memberidError;
	private String pwError;
	public String getMemberidError() {
		return memberidError;
	}
	public void setMemberidError(String memberidError) {
		this.memberidError = memberidError;
	}
	public String getPwError() {
		return pwError;
	}
	public void setPwError(String pwError) {
		this.pwError = pwError;
	}
	public boolean isResult() {
		return (memberidError != null && !memberidError.trim().isEmpty()) ||
				(pwError != null && !pwError.trim().isEmpty());
	}
}
