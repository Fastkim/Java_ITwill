package edu.java.contact.ver06;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {

    public interface OnContactInsertListener {
        void OnContactInserted();
    }
    
    private OnContactInsertListener listener;
    private Component parent; // 부모 컴포넌트를 저장하기 위한 필드.
    private ContactDaoImpl dao; // DB 테이블 insert 기능을 가지고 있는 객체.
    
    private JPanel getcontentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent, OnContactInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactUpdateFrame frame = new ContactUpdateFrame(parent, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ContactUpdateFrame(Component parent, OnContactInsertListener listener) {
        this.listener = listener;
        this.parent = parent;
        this.dao = ContactDaoImpl.getInstance();
        
        initialize(); // UI 컴포넌트들(JLabel, JTextField, JTextAreat, ...)이 생성, 초기화.
    }
    
    private void initialize() {

        setTitle("새 연락처 작성"); //JFrame의 타이틀
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // JFrame의 닫기 버튼 동작 - 현재 창 닫기
        
        int x = parent.getX(); // 부모 창의 x 좌표
        int y = parent.getY(); // 부모 창의 y 좌표
        setBounds(x, y, 400, 600);
        
        
        getcontentPane = new JPanel();
        getcontentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        
        setContentPane(getcontentPane);
        getContentPane().setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblName.setBounds(12, 10, 106, 96);
        getContentPane().add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textName.setBounds(130, 12, 375, 96);
        getContentPane().add(textName);
        textName.setColumns(10);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lblPhone.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblPhone.setBounds(12, 161, 106, 96);
        getContentPane().add(lblPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblEmail.setBounds(12, 331, 106, 96);
        getContentPane().add(lblEmail);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textPhone.setColumns(10);
        textPhone.setBounds(130, 161, 375, 96);
        getContentPane().add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textEmail.setColumns(10);
        textEmail.setBounds(130, 333, 375, 96);
        getContentPane().add(textEmail);
        
        JButton btnNewButton = new JButton("완료");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createNewContact();
            }
        });
        btnNewButton.setFont(new Font("D2Coding", Font.PLAIN, 25));
        btnNewButton.setBounds(130, 470, 375, 79);
        getContentPane().add(btnNewButton);
        initialize();
    }

    protected void createNewContact() {
        // 이름, 전화번호, 이메일 정보 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        if (name.equals("") || phone.equals("") || email.equals("")) {
            JOptionPane.showMessageDialog(
                    this, // parentComponent -> ContactCreateFrame의 인스턴스
                    "이름, 전화번호, 이메일은 반드시 입력되어야 합니다!", 
                    "Error", // title 
                    JOptionPane.ERROR_MESSAGE); 
            return; // insert하면 안 됨 -> 메서드 종료
        }
        
        // 제목, 내용, 작성자 -> Blog 객체 생성
        Contact contact = new Contact(null, name, phone, email);
        
        // dao의 insert 메서드를 호출 -> DB에 저장
        int result = dao.create(contact);
        if (result == 1) { // insert 성공
            JOptionPane.showMessageDialog(this, "새 연락처 저장 성공");
            dispose(); // 현재 창 닫기
            
            listener.OnContactInserted();
        
        } else { // insert 실패
            JOptionPane.showMessageDialog(this,
                    "새 연락처 저장 실패",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
