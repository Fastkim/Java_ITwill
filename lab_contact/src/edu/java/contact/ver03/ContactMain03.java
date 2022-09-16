package edu.java.contact.ver03;

import java.util.List;
import java.util.Scanner;

import edu.java.contact.menu.MainMenu;
import edu.java.contact.ver02.Contact;

public class ContactMain03 {

    Scanner scanner = new Scanner(System.in);

    ContactDaoImpl dao = new ContactDaoImpl();

    public static void main(String[] args) {

        ContactMain03 app = new ContactMain03();

        boolean run = true;

        while (run) {
            try {
                int n = app.showMainMenu();

                MainMenu menu = MainMenu.getValue(n);

                switch (menu) {
                case QUIT:
                    run = false;
                    break;
                case SELECT_ALL:
                    app.selectAll();
                    break;
                case SELECT_BY_INDEX:
                    app.selectIndex();
                    break;
                case CREATE:
                    app.create();
                    break;
                case UPDATE:
                    app.update();
                    break;
                case DELETE:
                    app.delete();
                    break;

                default:
                    System.out.println("지원하지 않는 메뉴 번호입니다. 다시 선택하세요.");
                }
            } catch (Exception e) {
                System.out.println("지원하지 않는 메뉴 번호입니다. 다시 선택하세요.");
            }
            System.out.println("프로그램 종료");
        }
    }

    private int showMainMenu() {
        System.out.println();
        System.out.println("-------------------- 연락처 프로그램 0.3 -----------------------");
        System.out.println("[1]전체리스트 [2]인덱스검색 [3]새연락처 [4]수정 [5] 삭제 [0]종료");
        System.out.println("----------------------------------------------------------------");
        System.out.print("메뉴 선택> ");

        int n = Integer.parseInt(scanner.nextLine());

        return n;
    }

    private void selectAll() {
        List<Contact> contact = dao.read();
        System.out.println("--- 연락처 리스트---");
        System.out.println(contact);
        System.out.println("--------------------");
    }

    private void selectIndex() {
        System.out.print("인덱스를 입력하세요>> ");
        int index = Integer.parseInt(scanner.nextLine());
        Contact m = dao.read(index);
        System.out.println(m);

    }

    private void create() {
        System.out.print("새로운 연락처의 이름을 입력하세요>> ");
        String name = scanner.nextLine();
        System.out.print("새로운 연락처의 전화번호를 입력하세요>> ");
        String phone = scanner.nextLine();
        System.out.print("새로운 연락처의 이메일을 입력하세요>> ");
        String email = scanner.nextLine();
        Contact contact = new Contact(name, phone, email);

        int result = dao.create(contact);

        System.out.println();

        if (result == 1) {
            System.out.println("새로운 연락처가 저장되었습니다.");
        } else {
            System.out.println("새로운 연락처 저장이 실패하였습니다");
        }

    }

    private void update() {
        System.out.print("변경할 연락처의 인덱스를 입력하세요>> ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println();
        System.out.print("변경할 연락처의 이름을 입력하세요>> ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.print("변경할 연락처의 전화번호를 입력하세요>> ");
        String phone = scanner.nextLine();
        System.out.println();
        System.out.print("변경할 연락처의 이메일을 입력하세요>> ");
        String email = scanner.nextLine();
        System.out.println();
        Contact contact = new Contact(name, phone, email);
        dao.update(index, contact);
    }

    private void delete() {
        System.out.print("삭제할 연락처의 인덱스를 입력하세요>> ");
        int index = Integer.parseInt(scanner.nextLine());
        System.out.println();
        int result = dao.delete(index);
        if (result == 1) {
            System.out.println("성공적으로 해당연락처가 삭제되었습니다.");
        } else {
            System.out.println("해당연락처가 삭제가 실패하였습니다.");
        }
    }

}
