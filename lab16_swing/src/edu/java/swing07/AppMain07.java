package edu.java.swing07;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AppMain07 {

    private JFrame frame;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbpublic;
    private JCheckBox cbAbstract;
    private JCheckBox cbFinal;
    private JCheckBox cbStatic;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JComboBox<String> comboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 528, 687);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("private");
        rbPrivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("D2Coding", Font.PLAIN, 25));
        rbPrivate.setBounds(8, 6, 123, 78);
        frame.getContentPane().add(rbPrivate);
        
        rbPackage = new JRadioButton("package");
        rbPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("D2Coding", Font.PLAIN, 25));
        rbPackage.setBounds(135, 6, 123, 78);
        frame.getContentPane().add(rbPackage);
        
        rbProtected = new JRadioButton("protected");
        rbProtected.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("D2Coding", Font.PLAIN, 25));
        rbProtected.setBounds(262, 6, 143, 78);
        frame.getContentPane().add(rbProtected);
        
        rbpublic = new JRadioButton("public");
        rbpublic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbpublic);
        rbpublic.setFont(new Font("D2Coding", Font.PLAIN, 25));
        rbpublic.setBounds(409, 6, 123, 78);
        frame.getContentPane().add(rbpublic);
        
        cbAbstract = new JCheckBox("abstract");
        cbAbstract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbAbstract.setFont(new Font("D2Coding", Font.PLAIN, 25));
        cbAbstract.setBounds(8, 86, 129, 53);
        frame.getContentPane().add(cbAbstract);
        
        cbFinal = new JCheckBox("final");
        cbFinal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbFinal.setFont(new Font("D2Coding", Font.PLAIN, 25));
        cbFinal.setBounds(145, 86, 129, 53);
        frame.getContentPane().add(cbFinal);
        
        cbStatic = new JCheckBox("static");
        cbStatic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbStatic.setFont(new Font("D2Coding", Font.PLAIN, 25));
        cbStatic.setBounds(278, 86, 129, 53);
        frame.getContentPane().add(cbStatic);
        
        comboBox = new JComboBox<>();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                textArea.setText(selected + " 선택");
            }
        });
        comboBox.setFont(new Font("D2Coding", Font.PLAIN, 20));
        
        final String[] items = {"naver.com", "kakao.com", "gmail.com","msn.com"};
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
        comboBox.setModel(model);
        
        comboBox.setBounds(8, 145, 217, 91);
        frame.getContentPane().add(comboBox);
        
        JButton btnShowInfo = new JButton("확인");
        btnShowInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printInfo();
            }
        });
        btnShowInfo.setFont(new Font("D2Coding", Font.PLAIN, 20));
        btnShowInfo.setBounds(8, 246, 217, 91);
        frame.getContentPane().add(btnShowInfo);
        
        scrollPane = new JScrollPane();
        scrollPane.setBounds(8, 347, 492, 291);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 20));
        scrollPane.setViewportView(textArea);
    }

    protected void printInfo() {
        // TODO RadioButton, CheckBox, ComboBox의 상태를 TextArea에 출력
        
        StringBuilder buffer = new StringBuilder(); // TextArea에 출력할 문자열을 만들기 위한 객체
        
        // 라디오버튼들 중에서 어떤 버튼이 선택됐는지
        if (rbPrivate.isSelected()) {
            buffer.append(rbPrivate.getText());
        } else if (rbPackage.isSelected()) {
            buffer.append(rbPackage.getText());
        } else if (rbProtected.isSelected()) {
            buffer.append(rbProtected.getText());
        } else if (rbpublic.isSelected()) {
            buffer.append(rbpublic.getText());
        }
        buffer.append(" 라디오버튼 선택\n");

        
        // 체크박스들 중에서 어떤 체크박스들이 선택됐는지
        if (cbAbstract.isSelected()) {
            buffer.append(cbAbstract.getText()).append(" ");
        }
        if (cbFinal.isSelected()) {
            buffer.append(cbFinal.getText()).append(" ");
        }
        if (cbStatic.isSelected()) {
            buffer.append(cbStatic.getText()).append(" ");
        }
        buffer.append(" 체크박스 선택\n");
        
        // ComboBox의 아이템들 중에서 어떤 아이템이 선택됐는 지
        String item = (String) comboBox.getSelectedItem();
        buffer.append(item).append(" 콤보박스 아이템 선택\n");
        
        // 버퍼의 내용을 TextArea에 출력
        textArea.setText(buffer.toString());
    }

    private void printCheckBoxStatus(ActionEvent e) {
        JCheckBox checkBox = (JCheckBox) e.getSource(); // 이벤트가 발생한 라디오 버튼
        String checkBoxText = checkBox.getText(); // 체크박스의 텍스트
        boolean selected = checkBox.isSelected(); // 체크박스의 선택/해제 여부
        textArea.setText(checkBoxText + " : " + selected);
    }

    private void printRadioButtonStatus(ActionEvent e) {
        JRadioButton radioBtn = (JRadioButton) e.getSource(); // 이벤트가 발생한 라디오 버튼
        String btnText = radioBtn.getText(); // 라디오 버튼의 텍스트
        boolean selected = radioBtn.isSelected(); // 라디오 버튼의 선택/해제 여부
        textArea.setText(btnText + " : " + selected);
    }
}
