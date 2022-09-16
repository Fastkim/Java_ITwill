package edu.java.contact.ver02;

// MVC 아키텍쳐에서 Controller (구현) 클래스 , DAO(Data Access Object).
public class ContactDaoImpl implements ContactDao {
	
		// Contact 객체를 저장할 배열의 최대 크기
		public static final int MAX_LENGTH = 3;

		// Contact 객체들을 저장할 배열
		private Contact[] contactList = new Contact[MAX_LENGTH];

		// 배열에 저장된 Contact 객체의 개수. Contact 객체가 배열에 저장될 때마다 1씩 증가.
		private int count = 0;

		// Controller 클래스는 Singleton으로 설계: 1) + 2) + 3)
		// 1) 자기자신 타입의 private static인 변수 선언
		private static ContactDaoImpl instance = null;

		// 2) private 생성자.
		private ContactDaoImpl() {
		}

		// 3) 자기자신 타입을 리턴하는 public static 메서드 정의.
		public static ContactDaoImpl getInstance() {
			if (instance == null) {
				instance = new ContactDaoImpl();
			}

			return instance;
		}

		@Override
		public int newContact(Contact c) {
			if (count >= MAX_LENGTH) { // 배열에 저장할 공간이 부족할 때
				return 0;
			}
			contactList[count] = c;
			count++;

			return 1;
		}

		@Override
		public Contact[] select() {
			// contactList를 그대로 리턴하지 말고,
			// 실제로 저장된 Contact 개수만큼만 배열을 새로 생성해서 리턴.
			
			
			
			Contact[] contacts = new Contact[count];
			for (int i = 0; i < count; i++) {
				contacts[i] = contactList[i];
			}

			return contacts;
		}
		
		@Override
		public Contact select(int index) {
			if (index >= 0 && index < MAX_LENGTH) {
				return contactList[index];
			} else { 
				return null;
			}
		}

		
		@Override
		public int update(int index, String name, String phone, String email) {
			if (index >= 0 && index < count) {
				contactList[index].setName(name);
				contactList[index].setPhone(phone);
				contactList[index].setEmail(email);
				return 1;
			} else { // NullPointerException이 발생되지 않도록 하기 위해서
				return 0;
			}
			
		
		}

}
