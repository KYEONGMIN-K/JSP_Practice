package string;

public class strPractice {
	/**
	 * 입력된 문자열을 - 를 붙여 반환하는 함수
	 * @Parameter : String num
	 * @return : String
	 * 
	 */
	public static String str_trans_PhoneNum(String num) {
		String tmp = new String();
		if(num.length()==11) {	//010
			String num1 = num.substring(0, 3);
			String num2 = num.substring(3,7);
			String num3 = num.substring(7, 11);
			tmp = num1+"-"+num2+"-"+num3;
		}else {	//011, 016, 019 ... etc
			String num1 = num.substring(0, 3);
			String num2 = num.substring(3,6);
			String num3 = num.substring(6, 10);
			tmp = num1+"-"+num2+"-"+num3;
		}

		return tmp;
	}
	/** 
	 * @param String input
	 * @return String
	 */
//	public static String formatPhoneNumber(String input) {
//	    return input.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
//	}
	
	public static String formatPhoneNumber(String input) {
	    if (input.matches("\\d{10}")) { // 10자리 번호 (예: 0111234567)
	        return input.replaceAll("(\\d{2,3})(\\d{3,4})(\\d{4})", "$1-$2-$3");
	    } else if (input.matches("\\d{11}")) { // 11자리 번호 (예: 01012345678)
	        return input.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
	    } else {
	        return input; // 형식이 맞지 않는 경우 그대로 반환
	    }
	}
}
