package edu.java.inheritance02;

// 학생은 사람이다. -> Person: Superclass, Student: Subclass
public class Student extends Person {
    // field
    private String school;
    
    public Student() {
//        super(); // superclass의 기본 생성자 호출 - 생략 가능.
        System.out.println("Student() 생성자 호출");
    }
    
    public Student(String school) {
        // super();
        // superclass의 생성자를 명시적으로 호출하지 않은 경우에는 기본 생성자가 자동으로 호출
        this.school = school;
        System.out.println("Student(school) 생성자 호출");
    }
    
    public Student(String name, String school) {
        // setName(name); person의 set메서드를 가져왔다.
        super(name);
        this.school = school;
        System.out.println("Student(name,school) 생성자 호출");
    }
    
    // getter/setter
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
    
  
}
