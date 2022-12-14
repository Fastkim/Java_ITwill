package java_itwill_project_view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java_itwill_project_controller.AlteredDaoImpl;
import java_itwill_project_model.Altered;
import java_itwill_project_view.AlteredCreateFrame.OnAlteredInsertListener;
import java_itwill_project_view.AlteredUpdateFrame.OnAlteredUpdateListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import static java_itwill_project_model.Altered.Entity.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AlteredMain extends JFrame implements OnAlteredInsertListener, OnAlteredUpdateListener {

    private static final String[] COLUMN_NAMES = { COL_ALTERED_NO, COL_TITLE, COL_AUTHOR, COL_MODIFIED_DATE };

    private OnLoginListener listener;
    private Component parent;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> comboBox;

    private AlteredDaoImpl dao;
    private JTextField textKeyword;

    public interface OnLoginListener {
        void onLogin();
    }
    
    /**
     * Launch the application.
     */
    public static void AccountDataFrame(Component parent, OnLoginListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AlteredMain frame = new AlteredMain(parent, listener);
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
    public AlteredMain(Component parent, OnLoginListener listener) {
        this.listener = listener;
        this.parent = parent;
        initialize(); // UI ???????????? ??????, ?????????
        this.dao = AlteredDaoImpl.getInstance();
        initializeTable(); // ?????? ??????????????? JTable ?????????
    }

    private void initializeTable() {
        // ???????????? ??????, ?????? ???????????? ????????? ????????? ?????? ????????? ??????. -> ????????? ?????????.
        model = new DefaultTableModel(null, COLUMN_NAMES);
        // ???????????? ?????? ????????? ??????.
        table.setModel(model);

        List<Altered> list = dao.select();
        for (Altered a : list) {
            Object[] row = { a.getAlteredNo(), a.getTitle(), a.getAuthor(), a.getModifiedDate() };
            model.addRow(row);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setBounds(100, 100, 985, 716);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 204));
        getContentPane().add(panel, BorderLayout.NORTH);

        JButton btnRequest_1 = new JButton("???????????? ??????");
        btnRequest_1.setBackground(new Color(204, 255, 153));
        btnRequest_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeTable();
            }
        });
        btnRequest_1.setFont(new Font("D2Coding", Font.PLAIN, 20));
        panel.add(btnRequest_1);

        JButton btnRequest = new JButton("?????? ????????????");
        btnRequest.setBackground(new Color(255, 153, 153));
        btnRequest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AlteredCreateFrame.newAlteredCreateFrame(AlteredMain.this, AlteredMain.this);
            }
        });
        btnRequest.setFont(new Font("D2Coding", Font.PLAIN, 20));
        panel.add(btnRequest);

        JButton btnDelete = new JButton("?????? ????????????");
        btnDelete.setBackground(new Color(255, 153, 204));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAltered();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
        panel.add(btnDelete);

        JButton btnUpdate = new JButton("????????????");
        btnUpdate.setBackground(new Color(255, 153, 255));
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showUpdateFrame();
            }
        });
        btnUpdate.setFont(new Font("D2Coding", Font.PLAIN, 20));
        panel.add(btnUpdate);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setForeground(new Color(204, 153, 255));
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][] {},
                new String[] { "ALTERED_NO", "TITLE", "AUTHOR", "MODIFIED_DATE" }));
        scrollPane.setViewportView(table);

        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(255, 255, 204));
        getContentPane().add(searchPanel, BorderLayout.SOUTH);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 15));
        comboBox.setModel(new DefaultComboBoxModel(new String[] { "??????", "????????????", "?????? + ????????????", "?????????" }));
        searchPanel.add(comboBox);

        textKeyword = new JTextField();
        searchPanel.add(textKeyword);
        textKeyword.setColumns(12);

        JButton btnSearch = new JButton("??????");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchAlteredByKeyword();
            }
        });
        btnSearch.setFont(new Font("D2Coding", Font.PLAIN, 20));
        searchPanel.add(btnSearch);
    }

    protected void showUpdateFrame() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(AlteredMain.this,
                    "???????????? ?????? ?????? ???????????????.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer alteredNo = (Integer) model.getValueAt(row, 0);
        System.out.println("alteredNo = " + alteredNo);
        
        AlteredUpdateFrame.newAlteredUpdateFrame(AlteredMain.this, alteredNo, AlteredMain.this);
    }

    protected void searchAlteredByKeyword() {
        String keyword = textKeyword.getText();
        if (keyword.equals("")) {
            JOptionPane.showMessageDialog(AlteredMain.this,
                    "???????????? ???????????????.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            
            return;
        }
        
        int type = comboBox.getSelectedIndex();
        System.out.println("type=" + type + ", keyword=" + keyword);
        
        List<Altered> list = dao.select(type, keyword);
        
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        for (Altered a : list) {
            Object[] row = {
                    a.getAlteredNo(), a.getTitle(), a.getAuthor(), a.getModifiedDate()
            };
            model.addRow(row);
        }
    }

    protected void deleteAltered() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(AlteredMain.this, "??????????????? ?????? ?????? ???????????????.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // ????????? ????????? ????????? 0??? ????????? ???(BLOG_NO)??? ??????.
        Integer alteredNo = (Integer) model.getValueAt(row, 0);
        System.out.println("alteredNo = " + alteredNo);

        int confirm = JOptionPane.showConfirmDialog(AlteredMain.this, alteredNo + "??? ?????? ?????? ?????? ????????????????", "?????? ??????",
                JOptionPane.YES_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            int result = dao.delete(alteredNo);
            if (result == 1) {
                JOptionPane.showMessageDialog(AlteredMain.this, alteredNo + "??? ?????? ??? ?????? ??????");
                initializeTable();
            } else {
                JOptionPane.showMessageDialog(AlteredMain.this, "?????? ?????? ??????", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    @Override
    public void onAlteredInserted() {
        initializeTable();
    }
    
    @Override
    public void onAlteredUpdated() {
        initializeTable();
    }
    
}
