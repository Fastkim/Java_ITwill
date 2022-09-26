package edu.java.swing01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AppMain01 {

    private JFrame frame;

    /**
     * Launch the application.
     */
    
    public static void main(String[] args) {
        // 쓰레드를 EventQueue에 등록 -> 자바 가상 머신이 쓰레드를 실행시킴 -> run() 실행.
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain01 window = new AppMain01(); //객체 생성
                    window.frame.setVisible(true); 
                    // static main method에서 frame 필드를 사용하기위해 객체 window 이용
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public AppMain01() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel lblText = new JLabel("안녕하세요. Swing!"); // JLabel 객체 생성
        lblText.setHorizontalAlignment(SwingConstants.CENTER);
        lblText.setFont(new Font("D2Coding", Font.BOLD, 40));
        frame.getContentPane().add(lblText, BorderLayout.CENTER); // JLabel 객체를 화면에 추가.
    }

}
