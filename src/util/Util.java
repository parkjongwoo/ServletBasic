package util;

public class Util {
	
	/**
	 * 정수 체크
	 * @param strInt
	 * @return
	 */
	public static boolean isInteger(String strInt) {
	    return strInt.matches("^[0-9]*$");
	}
	
	/**
	 * 실수,정수 등 숫자형 체크
	 * @param strNum
	 * @return
	 */
	public static boolean isNumeric(String strNum) {
	    return strNum.matches("-?\\d+(\\.\\d+)?");
	}
	/**
	 * 시작은 영문으로만, '_'를 제외한 특수문자 안되며 영문, 숫자, '_'으로만 이루어진 5 ~ 12자 이하
	 * @param strEmail
	 * @return
	 */
	public static boolean isID(String strID) {
	    return strID.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$");
	}
	
	/**
	 * email 형식 체크
	 * @param strEmail
	 * @return
	 */
	public static boolean isEmail(String strEmail) {
		return strEmail.matches("^[_a-zA-Z0-9-\\.]+@[\\.a-zA-Z0-9-]+\\.[a-zA-Z]+$");
	}
	/**
	 * 영문대소문자,숫자,특문조합 9~12자리. 각각 1자 이상.
	 * @param strPw
	 * @return
	 */
	public static boolean isPw(String strPw) {
		return strPw.matches("^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z])(?=.*[A-Z]).{9,12}$");
	}
}
