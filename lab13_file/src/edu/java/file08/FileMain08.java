package edu.java.file08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileMain08 {

    public static void main(String[] args) {
        // Student를 저장하는 ArrayList를 선언, 생성.
        ArrayList<Student> studentList = new ArrayList<>();
        
        // ArrayList에 Student 객체 5개를 저장.
        
        for (int i = 0; i < 5; i++) {
            Student stu = new Student(i, "홍길동", new Score());
            studentList.add(stu);
        }
        
        Score sc0 = new Score(60,70,90);
        Score sc1 = new Score(65,79,70);
        Score sc2 = new Score(80,80,80);
        Score sc3 = new Score(95,45,53);
        Score sc4 = new Score(34,68,87);
        
        studentList.add(new Student(1111,"Kim Da Hun",sc0));
        studentList.add(new Student(2222,"Kim Da Hean",sc1));
        studentList.add(new Student(3333,"Kim Da Hon",sc2));
        studentList.add(new Student(4444,"Kim Da Han",sc3));
        studentList.add(new Student(5555,"Kim Da Sun",sc4));
        
        
        String fileName = "data/student_list.dat";
        
        // ArrayList를 파일에 write.
        try (
                FileOutputStream out = new FileOutputStream(fileName);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);
        ) {
            oout.writeObject(studentList);
            System.out.println("파일 작성 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // 파일에서 ArrayList 객체를 read.
        try (
                FileInputStream in = new FileInputStream(fileName);
                BufferedInputStream bin = new BufferedInputStream(in);
                ObjectInputStream oin = new ObjectInputStream(bin);
        ) {
           ArrayList<Student> list = ( ArrayList<Student>) oin.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // ArrayList의 원소들을 한 줄씩 출력.
        for(int i=0 ; i< studentList.size() ; i++) {
            System.out.println(studentList.get(i));
        }
    }

}
