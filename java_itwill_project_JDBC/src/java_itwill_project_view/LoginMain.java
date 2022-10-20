package java_itwill_project_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import static java_itwill_project_controller.jdbcSqlLogin.SQL_SELECT_LOGIN;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import java_itwill_project_controller.LoginDaoImpl;
import java_itwill_project_model.Login;
import java_itwill_project_view.AlteredMain.OnLoginListener;
import java_itwill_project_view.LoginCreateAccountFrame.OnLoginInsertListener;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class LoginMain implements OnLoginInsertListener, OnLoginListener {

    public JFrame frame;
    private JTextField textId;
    private JTextField textPassword;
    
    private LoginDaoImpl dao;
    
    public LoginMain login;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginMain window = new LoginMain();
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
    public LoginMain() {
        initialize();
        dao = LoginDaoImpl.getInstance();
    }


    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(204, 204, 255));
        frame.getContentPane().setForeground(new Color(0, 255, 64));
        frame.setBounds(100, 100, 368, 321);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        frame.setTitle("로그인");
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 153, 255));
        panel.setBounds(0, 25, 352, 40);
        frame.getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("로그인 화면");
        lblNewLabel.setFont(new Font("휴먼편지체", Font.BOLD, 25));
        lblNewLabel.setForeground(new Color(0, 0, 255));
        panel.add(lblNewLabel);
        
        JLabel lblId = new JLabel("아이디:");
        lblId.setFont(new Font("휴먼편지체", Font.BOLD, 20));
        lblId.setBounds(69, 105, 83, 24);
        frame.getContentPane().add(lblId);
        
        JLabel lblPassword = new JLabel("비밀번호:");
        lblPassword.setFont(new Font("휴먼편지체", Font.BOLD, 20));
        lblPassword.setBounds(69, 161, 83, 24);
        frame.getContentPane().add(lblPassword);
        
        textId = new JTextField();
        textId.setBounds(157, 105, 116, 26);
        frame.getContentPane().add(textId);
        textId.setColumns(10);
        
        textPassword = new JTextField();
        textPassword.setColumns(10);
        textPassword.setBounds(157, 159, 116, 26);
        frame.getContentPane().add(textPassword);
        
        JButton btnLogin = new JButton("로그인");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = dao.select(textId.getText(), textPassword.getText());
                if(result == 1) {
                    AlteredMain.AccountDataFrame(frame, LoginMain.this);
                } else {
                    JOptionPane.showMessageDialog(
                            frame,
                            "맞지않는 아이디 혹은 비밀번호입니다.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        btnLogin.setFont(new Font("한컴 고딕", Font.BOLD, 15));
        btnLogin.setBounds(55, 219, 97, 23);
        frame.getContentPane().add(btnLogin);
        
        JButton btnCreateAccount = new JButton("회원가입");
        btnCreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginCreateAccountFrame.newCreateAccountFrame(frame, LoginMain.this);
            }
        });
        btnCreateAccount.setFont(new Font("한컴 고딕", Font.BOLD, 15));
        btnCreateAccount.setBounds(176, 220, 97, 23);
        frame.getContentPane().add(btnCreateAccount);
    }
    

    @Override
    public void onLoginInserted() {

    }
    
    public void onLogin() {

    }
    
  
}
