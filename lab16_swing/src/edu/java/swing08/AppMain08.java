package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {

    private JFrame frame;
    private JTextField textField;
    private JList<String> list;
    private JScrollPane scrollPane;
    private  DefaultListModel<String> listModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 460, 584);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textField.setBounds(12, 10, 315, 109);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listAdd();
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnInput.setBounds(339, 10, 97, 109);
        frame.getContentPane().add(btnInput);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listDelete();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnDelete.setBounds(339, 129, 97, 109);
        frame.getContentPane().add(btnDelete);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 129, 315, 412);
        frame.getContentPane().add(scrollPane);
        
        list = new JList<>();
        listModel = new DefaultListModel<>();
        list.setModel(listModel);
        list.setFont(new Font("D2Coding", Font.PLAIN, 20));
        scrollPane.setViewportView(list);
    }

    
    protected void listDelete() {
        if (listModel.size() == 0) {
            textField.setText("삭제할 수 있는 목록이 없습니다.");
        } else {
        listModel.remove(0);
        }
    }

    private void listAdd() {
        listModel.add(0, textField.getText());
        
    }
    
   
    
    
}
