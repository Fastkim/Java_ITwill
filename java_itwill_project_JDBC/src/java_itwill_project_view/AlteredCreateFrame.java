package java_itwill_project_view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java_itwill_project_controller.AlteredDaoImpl;
import java_itwill_project_model.Altered;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AlteredCreateFrame extends JFrame {

    public interface OnAlteredInsertListener {
        void onAlteredInserted();
    }
    
    private OnAlteredInsertListener listener;
    private Component parent;
    private AlteredDaoImpl dao;
    
    private JPanel contentPane;
    private JTextField textTitle;
    private JTextField textDetailAltered;
    private JTextField textClothesType;
    private JTextField textAuthor;

    /**
     * Launch the application.
     */
    public static void newAlteredCreateFrame(Component parent, OnAlteredInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AlteredCreateFrame frame = new AlteredCreateFrame(parent, listener);
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
    public AlteredCreateFrame(Component parent, OnAlteredInsertListener listener) {
        this.listener = listener;
        this.parent = parent;
        this.dao = AlteredDaoImpl.getInstance();
        
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setTitle("새 수선 요청글 작성");
    
        int x = parent.getX(); // 부모 창의 x 좌표
        int y = parent.getY(); // 부모 창의 y 좌표
        setBounds(x, y, 669, 607);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 245, 238));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitle = new JLabel("요청글 제목");
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(12, 10, 179, 41);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textTitle.setBounds(12, 61, 626, 50);
        contentPane.add(textTitle);
        textTitle.setColumns(10);
        
        JLabel lblDetailAltered = new JLabel("수선내용");
        lblDetailAltered.setHorizontalAlignment(SwingConstants.CENTER);
        lblDetailAltered.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblDetailAltered.setBounds(12, 141, 142, 41);
        contentPane.add(lblDetailAltered);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 192, 626, 195);
        contentPane.add(scrollPane);
        
        textDetailAltered = new JTextField();
        textDetailAltered.setFont(new Font("D2Coding", Font.PLAIN, 20));
        scrollPane.setViewportView(textDetailAltered);
        textDetailAltered.setColumns(10);
        
        JLabel lblType = new JLabel("옷 종류");
        lblType.setHorizontalAlignment(SwingConstants.CENTER);
        lblType.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblType.setBounds(211, 141, 122, 41);
        contentPane.add(lblType);
        
        textClothesType = new JTextField();
        textClothesType.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textClothesType.setBounds(342, 141, 169, 41);
        contentPane.add(textClothesType);
        textClothesType.setColumns(10);
        
        JLabel lblAuthor = new JLabel("작성자(닉네임)");
        lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lblAuthor.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblAuthor.setBounds(12, 409, 233, 41);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textAuthor.setBounds(257, 411, 381, 41);
        contentPane.add(textAuthor);
        textAuthor.setColumns(10);
        
        JButton btnCreate = new JButton("작성 완료");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewAlteredpost();
            }
        });
        btnCreate.setFont(new Font("D2Coding", Font.PLAIN, 25));
        btnCreate.setBounds(243, 496, 157, 50);
        contentPane.add(btnCreate);
        
        JLabel lblexample = new JLabel("바지,티셔츠 etc..");
        lblexample.setFont(new Font("굴림", Font.BOLD, 13));
        lblexample.setBounds(528, 141, 110, 41);
        contentPane.add(lblexample);
    }

    protected void createNewAlteredpost() {
        // 제목, 내용, 작성자 정보 읽음.
        String title = textTitle.getText();
        String detailAltered = textDetailAltered.getText();
        String author = textAuthor.getText();
        String clothesType = textClothesType.getText();
        if (title.equals("") || detailAltered.equals("") || author.equals("") || clothesType.equals("")) {
            JOptionPane.showMessageDialog(
                    this,
                    "제목, 내용, 작성자, 옷 종류는 반드시 입력되어야 합니다!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        
        Altered altered = new Altered(null, title, detailAltered, author, clothesType, null, null);
        
        int result = dao.request(altered);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "새 요청 글 작성 성공");
            dispose();
            
            listener.onAlteredInserted();
        } else {
            JOptionPane.showMessageDialog(this,
                    "새 요청 글 작성 실패",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
