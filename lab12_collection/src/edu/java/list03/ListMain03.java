package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.security.auth.callback.LanguageCallback;

public class ListMain03 {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "SQL", "HTML", "CSS", "JavaScript", 
                "Servlet", "JSP", "Spring", "Python");

        System.out.println(languages);

        // 리스트 languages에서 5글자 이상인 문자열들만 저장하는 리스트를 생성, 출력

        List<String> fiveLanguages = new ArrayList<>(); // 다형성 List는 인터페이스이므로 생성자 호출이 안됨.

        for (int i = 0; i < languages.size(); i++) {
            int x = languages.get(i).length();
            if (x >= 5) {
                fiveLanguages.add(languages.get(i));
            }
        }
        
        System.out.println(fiveLanguages);
        
//         for (String s : languages) {
//             if (s.length() >= 5) {
//                 fiveLanguages.add(s);
//             }
//         }
        
        // Iterator<E> 사용 :
        List<String> longword2 = new ArrayList<>();
        Iterator<String> itr = languages.iterator();
        while (itr.hasNext()) {
            String s = itr.next();
            if (s.length() >= 5) {
                longword2.add(s);
            }
        }
        
        // 리스트 languages의 원소들의 글자수를 저장하는 리스트를 만들고 출력.

        List<Integer> LengthLanguages = new ArrayList<>();

        for (int i = 0; i < languages.size(); i++) {

            int x = languages.get(i).length();

            LengthLanguages.add(x);

        }
        System.out.println(LengthLanguages);

        // 정수(1, 2)들을 저장하는 리스트를 만들고 초기화.
        List<Integer> genderCodes = Arrays.asList(1, 1, 2, 2, 1, 2, 2);
        System.out.println(genderCodes);
        // 리스트 genderCodes의 원소가 1이면 "Male" , 2이면 "Female"을 저장하는 리스트를 만들고 출력.

        List<String> SeparateGender = new ArrayList<>();

        
        for (int i = 0; i < genderCodes.size(); i++) {

            if (genderCodes.get(i) == 1) {
                SeparateGender.add("Male");
            }
            else {
                SeparateGender.add("Female");
            }

            
//            SeparateGender.add(genderCodes.get(i) == 1 ? "Male" : "Female") ;
        }
        System.out.println(SeparateGender);
        
//        for (Integer code : genderCodes) {
//            String gender = "";
//            if (code == 1) {
//                gender = "Male";
//            } else {
//                gender = "Female";
//            }
//            SeparateGender.add(gender);
//        }
//        System.out.println(SeparateGender);

//        genders.add((code == 1) ? "Male" : "Female");
        
    }

}
