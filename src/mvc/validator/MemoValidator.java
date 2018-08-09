package mvc.validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mvc.form.MemoForm;
import mvc.memoerror.MemoError;

/**
 * 입력값 유효성 검사 Class
 * @author goott3-4
 *
 */
public class MemoValidator {
	
	public List<String> validate_v1(MemoForm memo){
		List<String> errors = new ArrayList<String>();
		String name = memo.getName();
		if(name==null || name.trim().isEmpty()) {
			errors.add("이름을 입력하세요.");
		}
		String age = memo.getAge();
		if(age==null || age.trim().isEmpty()) {
			errors.add("나이를 입력하세요.");
		}else if(!isNumeric(age)) {
			errors.add("숫자를 입력하세요.");
		}
		
		
		return errors;
	}
	
	public MemoError validate_v2(MemoForm memo){
		MemoError errors = new MemoError();
		String name = memo.getName();
		if(name==null || name.trim().isEmpty()) {
			errors.setNameErr("이름을 입력하세요.");
		}
		String age = memo.getAge();
		if(age==null || age.trim().isEmpty()) {
			errors.setAgeErr("나이를 입력하세요.");
		}else if(!isNumeric(age)) {
			errors.setAgeErr("숫자를 입력하세요.");
		}		
		return errors;
	}
	
	public static boolean isNumeric(String strNum) {
	    return strNum.matches("-?\\d+(\\.\\d+)?");
	}
}
