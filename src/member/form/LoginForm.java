package member.form;

public class LoginForm {
	private String memberid;
	private String pw;
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "LoginForm [memberid=" + memberid + ", pw=" + pw + "]";
	}
	
}
