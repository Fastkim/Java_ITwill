package edu.java.mvc.view;

public enum Menu {
	QUIT, CREATE, SELECT_ALL, SELECT_BY_INDEX, UPDATE, UNKNOWN;
	
	// int  -> Menu 변환 메서드
	public static Menu getValue(int n) {
		Menu[] array = values(); //모든 enum 클래스에는 values()라는 메서드가 있고 enum의 멤버들을 return 한다.
		int lastIndex = array.length - 1;
		if (n >= 0 && n < lastIndex) { // 사용할 수 있는 메뉴 번호
			return array[n];
		} else { // 잘못된 메뉴 번호
			return array[lastIndex];
		}
	}
	
}
