package member.membererror;

public class MemberError {
	private String memberidError;
	private String pw1Error;
	private String nameError;
	private String emailError;
	public String getMemberidError() {
		return memberidError;
	}
	public void setMemberidError(String memberidError) {
		this.memberidError = memberidError;
	}
	public String getPw1Error() {
		return pw1Error;
	}
	public void setPw1Error(String pw1Error) {
		this.pw1Error = pw1Error;
	}
	public String getNameError() {
		return nameError;
	}
	public void setNameError(String nameError) {
		this.nameError = nameError;
	}
	public String getEmailError() {
		return emailError;
	}
	public void setEmailError(String emailError) {
		this.emailError = emailError;
	}
	public boolean isResult() {
		return (memberidError != null && !memberidError.trim().isEmpty()) ||
				(pw1Error != null && !pw1Error.trim().isEmpty()) ||
				(nameError != null && !nameError.trim().isEmpty()) ||
				(emailError != null && !emailError.trim().isEmpty());
	}
	@Override
	public String toString() {
		return "MemberError [memberidError=" + memberidError + ", pw1Error=" + pw1Error + ", nameError=" + nameError
				+ ", emailError=" + emailError + "]";
	}
	
}
