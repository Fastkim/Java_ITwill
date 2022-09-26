package edu.java.swing03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain03 {

    private JFrame frame;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setBounds(12, 10, 114, 85);
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        frame.getContentPane().add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblPhone.setBounds(12, 105, 114, 85);
        frame.getContentPane().add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblEmail.setBounds(12, 200, 114, 85);
        frame.getContentPane().add(lblEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 30));
        textName.setHorizontalAlignment(SwingConstants.CENTER);
        textName.setBounds(138, 10, 560, 85);
        frame.getContentPane().add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setHorizontalAlignment(SwingConstants.CENTER);
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 30));
        textPhone.setColumns(10);
        textPhone.setBounds(138, 105, 560, 85);
        frame.getContentPane().add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setHorizontalAlignment(SwingConstants.CENTER);
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 30));
        textEmail.setColumns(10);
        textEmail.setBounds(138, 200, 560, 85);
        frame.getContentPane().add(textEmail);
        
        JButton btnInput = new JButton("입력");
        // 버튼의 이벤트 핸들러를 등록
        // 이벤트 핸들러: 이벤트가 발생됐을 때 자동으로 호출되는 메서드.
        btnInput.addActionListener((e) -> printInfo());
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 25));
        btnInput.setBounds(12, 295, 686, 85);
        frame.getContentPane().add(btnInput);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 30));
        textArea.setBounds(12, 390, 686, 261);
        frame.getContentPane().add(textArea);
    }
    
    // "입력" 버튼을 클릭했을 때 실행할 내용.
    private void printInfo() {
        // JTextField에 입력된 내용을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // JTextArea에 출력할 문자열 만들기
        StringBuilder buffer = new StringBuilder();
        buffer.append("이름: ").append(name).append("\n")
            .append("전화번호: ").append(phone).append("\n")
            .append("이메일: ").append(email);
        
        // 만들어진 문자열을 JTextArea에 출력
        textArea.setText(buffer.toString());
    }
    
}
