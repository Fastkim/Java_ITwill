package edu.java.contact.ver06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;

import static edu.java.contact.ver06.Contact.Entity.*;

public class ContactMain06 {
    // 메인 화면에서 보여줄 JTable의 컬럼 이름들
    private static final String[] COLUMN_NAMES = {
            COL_CID, COL_NAME, COL_PHONE, COL_EMAIL
    };
    
    
    private DefaultTableModel model;
    private JFrame frame;
    private JTable table;
    
    private ContactDaoImpl dao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain06 window = new ContactMain06();
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
    public ContactMain06() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 775, 668);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        
        JButton btnContactReadAll = new JButton("전체 보기");
        btnContactReadAll.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnContactReadAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeTable();
            }
        });
        panel.add(btnContactReadAll);
        
        JButton btnContactAdd = new JButton("새 연락처추가");
        btnContactAdd.setFont(new Font("D2Coding", Font.PLAIN, 20));
        panel.add(btnContactAdd);
        
        JButton btnContactUpdate = new JButton("연락처 수정");
        btnContactUpdate.setFont(new Font("D2Coding", Font.PLAIN, 20));
        panel.add(btnContactUpdate);
        
        JButton btnContactDelete = new JButton("연락처 삭제");
        btnContactDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
        panel.add(btnContactDelete);
        
        JButton btnContactSearch = new JButton("연락처 검색");
        btnContactSearch.setFont(new Font("D2Coding", Font.PLAIN, 20));
        panel.add(btnContactSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "CID", "NAME", "PHONE", "EMAIL"
            }
        ));
        scrollPane.setViewportView(table);
    }

    protected void initializeTable() {
        // 데이터는 없는, 컬럼 이름들만 설정된 테이블 모델 객체를 생성. -> 데이터 초기화.
        model = new DefaultTableModel(null, COLUMN_NAMES);
        // 테이블에 모든 객체를 설정.
        table.setModel(model);
        
        // DB에서 데이터를 검색.
        List<Contact> list = dao.read();
        for (Contact c : list) {
            Object[] row = {
                    c.getCid(), c.getName(), c.getPhone(), c.getEmail()
            };
            model.addRow(row);
        }
        
    }

}
