package java_itwill_project_view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java_itwill_project_controller.LoginDaoImpl;
import java_itwill_project_model.Login;

public class LoginCreateAccountFrame extends JFrame {

    public interface OnLoginInsertListener{
        void onLoginInserted();
    }
    
    private OnLoginInsertListener listener;
    private Component parent;
    private LoginDaoImpl dao;
    
    private JPanel contentPane;
    private JTextField textId;
    private JTextField textPassword;
    private JTextField textName;
    private JTextField textPhone;

    /**
     * Launch the application.
     */
    public static void newCreateAccountFrame(Component parent, OnLoginInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginCreateAccountFrame frame = new LoginCreateAccountFrame(parent, listener);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public LoginCreateAccountFrame(Component parent, OnLoginInsertListener listener) {
        this.listener = listener;
        this.parent = parent;
        this.dao = LoginDaoImpl.getInstance(); 
                
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setTitle("회원가입");
        
        int x = parent.getX();
        int y = parent.getY();
        setBounds(x, y, 337, 352);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(204, 204, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        
        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(new Color(204, 204, 255));
        panelTitle.setBounds(0, 20, 308, 40);
        contentPane.add(panelTitle);
        
        JLabel lblTitle = new JLabel("회원 가입");
        lblTitle.setForeground(new Color(0, 0, 255));
        lblTitle.setFont(new Font("휴먼편지체", Font.BOLD, 30));
        panelTitle.add(lblTitle);
        
        JPanel panelId = new JPanel();
        panelId.setBackground(new Color(204, 204, 255));
        panelId.setBounds(0, 82, 308, 27);
        contentPane.add(panelId);
        panelId.setLayout(null);
        
        JLabel lblId = new JLabel("아이디:");
        lblId.setHorizontalAlignment(SwingConstants.RIGHT);
        lblId.setFont(new Font("한컴 고딕", Font.BOLD, 15));
        lblId.setBounds(48, 0, 63, 27);
        panelId.add(lblId);
        
        textId = new JTextField();
        textId.setBounds(123, 0, 126, 27);
        panelId.add(textId);
        textId.setColumns(10);
        
        JPanel panelPassword = new JPanel();
        panelPassword.setBackground(new Color(204, 204, 255));
        panelPassword.setLayout(null);
        panelPassword.setBounds(0, 119, 308, 27);
        contentPane.add(panelPassword);
        
        JLabel lblPassword = new JLabel("비밀번호:");
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword.setFont(new Font("한컴 고딕", Font.BOLD, 15));
        lblPassword.setBounds(48, 0, 63, 27);
        panelPassword.add(lblPassword);
        
        textPassword = new JTextField();
        textPassword.setColumns(10);
        textPassword.setBounds(123, 0, 126, 27);
        panelPassword.add(textPassword);
        
        JPanel panelName = new JPanel();
        panelName.setBackground(new Color(204, 204, 255));
        panelName.setLayout(null);
        panelName.setBounds(0, 156, 308, 27);
        contentPane.add(panelName);
        
        JLabel lblName = new JLabel("이름:");
        lblName.setHorizontalAlignment(SwingConstants.RIGHT);
        lblName.setFont(new Font("한컴 고딕", Font.BOLD, 15));
        lblName.setBounds(48, 0, 63, 27);
        panelName.add(lblName);
        
        textName = new JTextField();
        textName.setColumns(10);
        textName.setBounds(123, 0, 126, 27);
        panelName.add(textName);
        
        JPanel panelPhone = new JPanel();
        panelPhone.setBackground(new Color(204, 204, 255));
        panelPhone.setLayout(null);
        panelPhone.setBounds(0, 193, 308, 27);
        contentPane.add(panelPhone);
        
        JLabel lblPhone = new JLabel("전화번호:");
        lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPhone.setFont(new Font("한컴 고딕", Font.BOLD, 15));
        lblPhone.setBounds(48, 0, 63, 27);
        panelPhone.add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setColumns(10);
        textPhone.setBounds(123, 0, 126, 27);
        panelPhone.add(textPhone);
        
        JPanel panelbtn = new JPanel();
        panelbtn.setBackground(new Color(204, 204, 255));
        panelbtn.setBounds(0, 244, 308, 38);
        contentPane.add(panelbtn);
        panelbtn.setLayout(null);
        
        JButton btnNewAccount = new JButton("회원가입");
        btnNewAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewAccount();
            }
        });
        btnNewAccount.setFont(new Font("한컴 고딕", Font.BOLD, 15));
        btnNewAccount.setBounds(65, 10, 97, 23);
        panelbtn.add(btnNewAccount);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnCancel.setFont(new Font("한컴 고딕", Font.BOLD, 15));
        btnCancel.setBounds(174, 10, 68, 23);
        panelbtn.add(btnCancel);
    }

    protected void createNewAccount() {
        String Id = textId.getText();
        String passWord = textPassword.getText();
        String name = textName.getText();
        String phone = textPhone.getText();
        if (Id.equals("") || passWord.equals("") || name.equals("") || phone.equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "아이디, 비밀번호, 이름, 전화번호는 반드시 입력해야합니다!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Login login = new Login(null, Id, passWord, name, phone);
        
        int result = dao.create(login);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "새로운계정 생성 성공");
            dispose();
            
            listener.onLoginInserted();
        } else {
            JOptionPane.showMessageDialog(this,
                    "새로운 계정 생성 실패",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
