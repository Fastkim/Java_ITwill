package edu.java.contact.ver02;

import java.util.Scanner;

import edu.java.contact.ver02.ContactDaoImpl;
import edu.java.contact.menu.MainMenu;
import edu.java.contact.ver02.Contact;


// MVC 아키텍쳐에서 view(UI)에 해당하는 클래스
public class ContactMain02 {
	
	// 상수
    private static final int MAX_LENGTH = 3; // 저장할 수 있는 연락처의 최대 개수(배열 길이).
	
	private Scanner scanner = new Scanner(System.in); // 입력 도구
    private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처들의 배열
    
    private ContactDaoImpl dao = ContactDaoImpl.getInstance(); // 컨트롤러(연락처 저장, 검색, 수정) 클래스.
	

	public static void main(String[] args) {
		System.out.println("***** 연락처 프로그램 Version 0.2 *****");
		
		// static이 아닌 메서드들을 호출하기 위해서 객체를 생성할 필요가 있음.
		
        ContactMain02 app = new ContactMain02();
        
        boolean run = true; // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        while(run) {
            try {
                // TODO 1. 메인 메뉴 보여 주기
                int n = app.showMainMenu();

                // TODO 2. 메뉴 입력
                MainMenu menu = MainMenu.getValue(n);

                // TODO 3. switch-case
                switch (menu) {
                case QUIT: // 종료
                    run = false;
                    break;
                case SELECT_ALL: // 전체리스트
                    app.selectAllContacts();
                    break;
                case SELECT_BY_INDEX: // 인덱스검색
                    app.selectContactByIndex();
                    break;
                case CREATE: // 새 연락처 추가
                    app.insertNewContact();
                    break;
                case UPDATE: // 연락처 정보 수정
                    app.updateContact();
                    break;

                default:
                    System.out.println("지원하지 않는 메뉴 번호입니다. 다시 선택하세요.");
                }
            } catch(Exception e) {
                System.out.println("지원하지 않는 메뉴 번호입니다. 다시 선택하세요.");
            }
        }
        
        System.out.println("프로그램 종료");
		
	}

	private void insertNewContact() {
		
		System.out.println("새로운 연락처를 입력하세요");
		System.out.print("연락처의 이름을 입력하세요 : ");
		String name = scanner.nextLine();
		
		System.out.print("연락처의 핸드폰 번호를 입력하세요 : ");
		String phone = scanner.nextLine();
		
		System.out.print("연락처의 이메일을 입력하세요 : ");
		String email = scanner.nextLine();
		
		Contact c = new Contact(name, phone, email);
		
		int result = dao.newContact(c);
		if(result == 1) {
			System.out.println("연락처가 성공적으로 생성되었습니다.");
		} else {
			System.out.println("연락처 생성이 실패했습니다.");
		}
		
	}

	private void selectAllContacts() {
		
		Contact[] contacts = dao.select(); // controller의 메서드를 호출.
		
		System.out.println("--- 연락처 리스트 ---");
		for (Contact c : contacts) {
			System.out.println(c);
		}
		System.out.println("-------------------");
		
	}
	
	private void selectContactByIndex() {
	    
		System.out.println("--- 인덱스 검색 ---");
		
		System.out.print("검색할 인덱스>> ");
		int index = Integer.parseInt(scanner.nextLine());
		
		
		// view(UI)에서 controller 기능을 사용
		Contact m = dao.select(index);
		System.out.println(m);
		System.out.println("-------------------");
		
	}

	
	private void updateContact() {
		System.out.println("--- 회원 정보 업데이트 ---");
    	System.out.print("업데이트 인덱스>> ");
    	int index = Integer.parseInt(scanner.nextLine());
    	System.out.print("업데이트 이름>> ");
    	String name = scanner.nextLine();
    	System.out.print("업데이트 핸드폰 번호>> ");
    	String phone = scanner.nextLine();
    	System.out.print("업데이트 이메일>> ");
    	String email = scanner.nextLine();
    	
    	// view(UI)에서 controller의 기능을 이용
    	int result = dao.update(index,name,phone,email);
    	if (result == 1) {
    		System.out.println("회원 정보 업데이트 성공");
    	} else {
    		System.out.println("회원 정보 업데이트 실패");
    	}
	}

	private int showMainMenu() {
        System.out.println();
        System.out.println("-------------------------------------------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [0]종료");
        System.out.println("-------------------------------------------------------");
        System.out.print("메뉴 선택> ");
        
        
            int n = Integer.parseInt(scanner.nextLine());
            
    	return n;
	    }
    	
}
