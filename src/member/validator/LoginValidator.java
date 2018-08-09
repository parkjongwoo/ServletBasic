package member.validator;

import member.form.LoginForm;
import member.membererror.LoginError;

public class LoginValidator {
	public LoginError validate(LoginForm loginForm){
		LoginError errors = new LoginError();
		String Loginid = loginForm.getMemberid();
		if(Loginid==null || Loginid.trim().isEmpty()) {
			errors.setMemberidError("아이디를 입력하세요.");
		}
		
		String pw = loginForm.getPw();
		
		if(pw==null || pw.trim().isEmpty()) {
			errors.setPwError("비밀번호를 입력하세요.");
		}		
				
		return errors;
	}	
}
