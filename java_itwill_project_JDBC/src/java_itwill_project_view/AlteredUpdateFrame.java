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

public class AlteredUpdateFrame extends JFrame {

    public interface OnAlteredUpdateListener {
        void onAlteredUpdated();
    }
    
    private OnAlteredUpdateListener listener;
    
    private Component parent;
    private Integer alteredNo;
    private AlteredDaoImpl dao;
    
    private JPanel contentPane;
    
    private JTextField textTitle;
    private JTextField textDetailAltered;
    private JTextField textClothesType;
    private JTextField textAuthor;
    private JTextField textCreated;
    private JTextField textModified;
    private JTextField textAlteredNo;
    

    /**
     * Launch the application.
     */
    public static void newAlteredUpdateFrame(Component parent, Integer alteredNo, OnAlteredUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AlteredUpdateFrame frame = new AlteredUpdateFrame(parent, alteredNo, listener);
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
    public AlteredUpdateFrame(Component parent, Integer alteredNo, OnAlteredUpdateListener listener) {
        this.listener = listener;
        
        this.parent = parent;
        this.alteredNo = alteredNo;
        this.dao = AlteredDaoImpl.getInstance();
        
        initialize();
        
        initializeAlteredData();
    }

    private void initializeAlteredData() {
        Altered altered = dao.select(alteredNo);
        if (altered != null) {
            textAlteredNo.setText(altered.getAlteredNo().toString());
            textTitle.setText(altered.getTitle());
            textDetailAltered.setText(altered.getDetailAltered());
            textAuthor.setText(altered.getAuthor());
            textClothesType.setText(altered.getClothesType());
            textCreated.setText(altered.getCreatedDate().toString());
            textModified.setText(altered.getModifiedDate().toString());
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setTitle("????????? ??????");
    
        int x = parent.getX(); // ?????? ?????? x ??????
        int y = parent.getY(); // ?????? ?????? y ??????
        setBounds(x, y, 676, 908);
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 250, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitle = new JLabel("??????");
        lblTitle.setForeground(new Color(255, 51, 204));
        lblTitle.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(12, 62, 87, 49);
        contentPane.add(lblTitle);
        
        textTitle = new JTextField();
        textTitle.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textTitle.setBounds(114, 61, 524, 50);
        contentPane.add(textTitle);
        textTitle.setColumns(10);
        
        JLabel lblDetailAltered = new JLabel("????????????");
        lblDetailAltered.setForeground(new Color(255, 51, 204));
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
        
        JLabel lblType = new JLabel("??? ??????");
        lblType.setForeground(new Color(255, 51, 204));
        lblType.setHorizontalAlignment(SwingConstants.CENTER);
        lblType.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblType.setBounds(223, 141, 124, 41);
        contentPane.add(lblType);
        
        textClothesType = new JTextField();
        textClothesType.setFont(new Font("D2Coding", Font.PLAIN, 15));
        textClothesType.setBounds(359, 141, 142, 41);
        contentPane.add(textClothesType);
        textClothesType.setColumns(10);
        
        JLabel lblAuthor = new JLabel("?????????(?????????)");
        lblAuthor.setForeground(new Color(204, 0, 0));
        lblAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lblAuthor.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblAuthor.setBounds(12, 414, 233, 41);
        contentPane.add(lblAuthor);
        
        textAuthor = new JTextField();
        textAuthor.setEditable(false);
        textAuthor.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textAuthor.setBounds(12, 465, 233, 41);
        contentPane.add(textAuthor);
        textAuthor.setColumns(10);
        
        JButton btnUpdate = new JButton("?????? ??????");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateAltered();
            }
        });
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 25));
        btnUpdate.setBounds(234, 792, 157, 50);
        contentPane.add(btnUpdate);
        
        JLabel lblAlteredNo = new JLabel("??????");
        lblAlteredNo.setForeground(new Color(204, 0, 0));
        lblAlteredNo.setHorizontalAlignment(SwingConstants.CENTER);
        lblAlteredNo.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblAlteredNo.setBounds(12, 7, 87, 41);
        contentPane.add(lblAlteredNo);
        
        JLabel lblCreated = new JLabel("????????????");
        lblCreated.setForeground(new Color(204, 0, 0));
        lblCreated.setHorizontalAlignment(SwingConstants.CENTER);
        lblCreated.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblCreated.setBounds(12, 535, 233, 41);
        contentPane.add(lblCreated);
        
        textCreated = new JTextField();
        textCreated.setEditable(false);
        textCreated.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textCreated.setColumns(10);
        textCreated.setBounds(12, 586, 626, 41);
        contentPane.add(textCreated);
        
        JLabel lblModified = new JLabel("?????? ???????????? ??????");
        lblModified.setForeground(new Color(204, 0, 0));
        lblModified.setHorizontalAlignment(SwingConstants.CENTER);
        lblModified.setFont(new Font("D2Coding", Font.PLAIN, 25));
        lblModified.setBounds(12, 651, 233, 41);
        contentPane.add(lblModified);
        
        textModified = new JTextField();
        textModified.setEditable(false);
        textModified.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textModified.setColumns(10);
        textModified.setBounds(12, 702, 626, 41);
        contentPane.add(textModified);
        
        textAlteredNo = new JTextField();
        textAlteredNo.setEditable(false);
        textAlteredNo.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textAlteredNo.setColumns(10);
        textAlteredNo.setBounds(114, 9, 106, 41);
        contentPane.add(textAlteredNo);
        
        JLabel lblexample = new JLabel("??????,????????? etc..");
        lblexample.setFont(new Font("??????", Font.BOLD, 13));
        lblexample.setBounds(513, 141, 125, 41);
        contentPane.add(lblexample);
    }
    
    private void updateAltered() {
        // ????????? title, content ??????.
        String title = textTitle.getText();
        String detailAltered = textDetailAltered.getText();
        String clothesType = textClothesType.getText();
        if (title.equals("") || detailAltered.equals("") || clothesType.equals("")) {
            JOptionPane.showMessageDialog(this, 
                    "????????? ????????? ????????? ??????????????? ?????????.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // dao.update() ??????.
        Altered altered = new Altered(alteredNo, title, detailAltered, null, clothesType, null, null);
        int result = dao.update(altered);
        
        if (result == 1) {
            JOptionPane.showMessageDialog(this, 
                    alteredNo + "??? ?????? ??? ???????????? ??????");
            // DetailFrame??? ??????.
            dispose();
            // BlogMain?????? ???????????? ????????? ?????????.
            listener.onAlteredUpdated();
        } else {
            JOptionPane.showMessageDialog(this, 
                    alteredNo + "??? ?????? ??? ???????????? ??????");
        }
        
    } 
}
