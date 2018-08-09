package member.validator;

import member.form.MemberForm;
import member.membererror.MemberError;
import util.Util;

public class MemberValidator {
	public MemberError validate(MemberForm memberForm){
		MemberError errors = new MemberError();
		String memberid = memberForm.getMemberid();
		if(memberid==null || memberid.trim().isEmpty()) {
			errors.setMemberidError("아이디를 입력하세요.");
		}else if(!Util.isID(memberid)) {
			errors.setMemberidError("시작문자는 영문만, _ 및 영문, 숫자로만 이루어진 5~12자 이하의 단어만 사용할 수 있습니다. ");
		}
		
		String pw1 = memberForm.getPw1();
		String pw2 = memberForm.getPw2();
		if(pw1==null || pw1.trim().isEmpty()) {
			errors.setPw1Error("비밀번호를 입력하세요.");
		}else if(!Util.isPw(pw1)) {
			errors.setPw1Error("영문대소문자,숫자,특수문자를 각각 1자이상 포함하여 9~12자 이내로 입력하세요.");
		}else if(!pw1.equals(pw2)) {
			errors.setPw1Error("비밀번호가 동일하지 않습니다.");
		}
		
		String name = memberForm.getName();
		if(name==null || name.trim().isEmpty()) {
			errors.setNameError("이름을 입력하세요.");
		}else if(name.length()>15) {
			errors.setNameError("이름은 15자 이하로 작성해 주세요.");
		}
		
		String email = memberForm.getEmail();
		if(email==null || email.trim().isEmpty()) {
			errors.setEmailError("이메일 주소를 입력하세요.");
		}else if(!Util.isEmail(email)) {
			errors.setEmailError("형식에 맞는 이메일주소를 입력하세요.");
		}		
		return errors;
	}
	
	public MemberError updateValidate(MemberForm memberForm){
		MemberError errors = new MemberError();		
		
		String pw1 = memberForm.getPw1();
		String pw2 = memberForm.getPw2();
		if(pw1==null || pw1.trim().isEmpty()) {
//			errors.setPw1Error("비밀번호를 입력하세요.");//정보변경시 비밀번호 없는 경우는 무시. 비번 변경 안함.
		}else if(!Util.isPw(pw1)) {
			errors.setPw1Error("영문대소문자,숫자,특수문자를 각각 1자이상 포함하여 9~12자 이내로 입력하세요.");
		}else if(!pw1.equals(pw2)) {
			errors.setPw1Error("비밀번호가 동일하지 않습니다.");
		}
		
		String name = memberForm.getName();
		if(name==null || name.trim().isEmpty()) {
			errors.setNameError("이름을 입력하세요.");
		}else if(name.length()>15) {
			errors.setNameError("이름은 15자 이하로 작성해 주세요.");
		}
		
		String email = memberForm.getEmail();
		if(email==null || email.trim().isEmpty()) {
			errors.setEmailError("이메일 주소를 입력하세요.");
		}else if(!Util.isEmail(email)) {
			errors.setEmailError("형식에 맞는 이메일주소를 입력하세요.");
		}		
		return errors;
	}
}
