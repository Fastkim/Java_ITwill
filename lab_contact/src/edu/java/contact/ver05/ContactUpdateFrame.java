package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ContactUpdateFrame extends JFrame {

    private JPanel contentPane;
    private Component parent;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    ContactUpdateFrame frame = new ContactUpdateFrame(parent);
                    frame.setVisible(true);
            }
        });
    }
    
    public ContactUpdateFrame(Component parent) { // 생성자
        this.parent = parent; // 부모 컴포넌트를 초기화.
        initialize(); // UI 컴포넌트들을 생성, 초기화.
    }
    
    /**
     * Create the frame.
     */
    public void initialize() { // UI 메소드
        setTitle("연락처 보기/수정");
        // 닫기 버튼을 클릭했을 때의 기본 동작 설정 - 현재 창만 닫기
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX(); // 부모 컴포넌트의 x 좌표
        int y = parent.getY(); // 부모 컴포넌트의 y 좌표
        setBounds(x, y, 420, 384);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblName.setBounds(12, 10, 91, 55);
        contentPane.add(lblName);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblPhone.setBounds(12, 75, 91, 55);
        contentPane.add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblEmail.setBounds(12, 140, 91, 55);
        contentPane.add(lblEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textName.setHorizontalAlignment(SwingConstants.LEFT);
        textName.setBounds(115, 10, 275, 55);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setHorizontalAlignment(SwingConstants.LEFT);
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textPhone.setColumns(10);
        textPhone.setBounds(115, 75, 275, 55);
        contentPane.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setHorizontalAlignment(SwingConstants.LEFT);
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textEmail.setColumns(10);
        textEmail.setBounds(115, 140, 275, 55);
        contentPane.add(textEmail);
        
        JButton btnSave = new JButton("업데이트");
        btnSave.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnSave.setBounds(12, 205, 128, 69);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnCancel.setBounds(152, 205, 97, 69);
        contentPane.add(btnCancel);
    }

}
