package edu.java.swing08;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain08 {

    private JFrame frame;
    private JTextField textField;
    private JScrollPane scrollPane;
    private JList<String> list;

    // JList의 원소들을 관리하는 객체
    // JList에 새로운 원소 추가, 원소 삭제, 선택된 원소에 대한 정보, ...
    private DefaultListModel<String> listModel;

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
            @Override
            public void actionPerformed(ActionEvent e) {
                addItemToList();
            }
        });
        btnInput.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnInput.setBounds(339, 10, 97, 109);
        frame.getContentPane().add(btnInput);

        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteItemFromList();
            }
        });
        btnDelete.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnDelete.setBounds(339, 129, 97, 109);
        frame.getContentPane().add(btnDelete);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 129, 315, 412);
        frame.getContentPane().add(scrollPane);

        list = new JList<>(); // JList 객체 생성
        listModel = new DefaultListModel<>(); // JList의 원소들을 관리하는 ListModel 객체를 생성.
        list.setModel(listModel); // JList에 ListModel을 설정.
        list.setFont(new Font("D2Coding", Font.PLAIN, 20));
        scrollPane.setViewportView(list);
    }

    private void deleteItemFromList() {
        // JList에서 선택된 원소의 인덱스를 찾음.
        int index = list.getSelectedIndex();
        
        if (index == -1) {
            JOptionPane.showMessageDialog(frame, 
                    "리스트에서 삭제할 원소를 반드시 선택해 주세요", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 사용자에게 삭제 여부를 확인
        int confirm = JOptionPane.showConfirmDialog(frame,
                index + "번 메세지를 정말 삭제할까요?",
                "삭제 확인",
                JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) { // 다이얼로그에서 Yes를 클릭했을 때
         // DefaultListModel에서 특정 인덱스의 원소를 삭제하면 JList에서 그 원소가 자동으로 삭제됨.
            listModel.remove(index);
        }

//        if (listModel.size() == 0) {
//            textField.setText("삭제할 수 있는 목록이 없습니다.");
//        } else {
//            listModel.remove(index);
//        }
    }

    private void addItemToList() {
        // JTextField에 입력된 내용을 읽음.
        String input = textField.getText();
        
        
//        listModel.add(0, textField.getText()); // 값이 첫번째줄로 계속해서 추가저장된다.
        
        // JTextField에 입력된 내용이 없는 경우 getText() 메서드는 빈 문자열("")을 리턴!
        if (input.equals("")) { /* equals(Null)이 안되는 이유 질문 */
            JOptionPane.showMessageDialog(frame, "입력된 내용이 없습니다.", "Warning", JOptionPane.WARNING_MESSAGE);
            return; // addItemToList() 메서드를 종료
        }
        // DefaultListModel에 원소를 추가하면 자동으로 JList에 원소가 추가.
        listModel.addElement(input); 
        JOptionPane.showMessageDialog(frame,
                "성공적으로 List에 저장되었습니다.",
                "저장 성공",
                JOptionPane.INFORMATION_MESSAGE);
        // 입력할 때마다 저장된 값 밑으로 새로운값이 추가된다.
        
        /* boolean = true/false로 if문 사용해서 성공적으로 
         * 생성되었으면 showMessageDialog 출력하도록 하는 방법 없을까?
         */
        

        // JTextField를 초기화 - 입력된 내용 지우기.
        textField.setText("");
        
    }

}
