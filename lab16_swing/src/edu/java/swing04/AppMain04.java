package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicSliderUI.TrackListener;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class AppMain04 {

    private JFrame frame;
    private JTextField numText1;
    private JTextField numText2;
    private JTextArea textArea;
    private JButton sumButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;

    /**
     * Launch the application.
     */
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
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
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 484, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNum1 = new JLabel("num1");
        lblNum1.setOpaque(true);
        lblNum1.setForeground(new Color(0, 0, 0));
        lblNum1.setBackground(new Color(0, 255, 255));
        lblNum1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum1.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblNum1.setBounds(12, 10, 116, 67);
        frame.getContentPane().add(lblNum1);
        
        JLabel lblNum2 = new JLabel("num2");
        lblNum2.setOpaque(true);
        lblNum2.setForeground(new Color(0, 0, 0));
        lblNum2.setBackground(new Color(0, 255, 255));
        lblNum2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNum2.setFont(new Font("D2Coding", Font.PLAIN, 20));
        lblNum2.setBounds(12, 87, 116, 67);
        frame.getContentPane().add(lblNum2);
        
        numText1 = new JTextField();
        numText1.setHorizontalAlignment(SwingConstants.CENTER);
        numText1.setFont(new Font("D2Coding", Font.PLAIN, 20));
        numText1.setBounds(140, 11, 313, 67);
        frame.getContentPane().add(numText1);
        numText1.setColumns(10);
        
        numText2 = new JTextField();
        numText2.setHorizontalAlignment(SwingConstants.CENTER);
        numText2.setFont(new Font("D2Coding", Font.PLAIN, 20));
        numText2.setColumns(10);
        numText2.setBounds(140, 87, 313, 67);
        frame.getContentPane().add(numText2);
        
        sumButton = new JButton("+");
        sumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 파라미터 ActionEvent e: 이벤트가 발생한 컴포넌트, 이벤트의 종류 등에 대한 정보를 가지고 있는 객체.
                // ActionEvent.getSource(): 이벤트가 발생한 컴포넌트를 리턴.
                performCalculation(e);
            }
        
        });
       
//        sumButton.addActionListener(e -> plus());
        
        
        sumButton.setFont(new Font("D2Coding", Font.PLAIN, 30));
        sumButton.setBounds(12, 211, 78, 60);
        frame.getContentPane().add(sumButton);
        
        subButton = new JButton("-");
        subButton.addActionListener(e -> performCalculation(e));
        subButton.setFont(new Font("D2Coding", Font.PLAIN, 30));
        subButton.setBounds(138, 211, 78, 60);
        frame.getContentPane().add(subButton);
        
        mulButton = new JButton("x");
        mulButton.addActionListener(e -> performCalculation(e));
        mulButton.setFont(new Font("D2Coding", Font.PLAIN, 30));
        mulButton.setBounds(263, 211, 78, 60);
        frame.getContentPane().add(mulButton);
        
        divButton = new JButton("/");
        divButton.addActionListener(e -> performCalculation(e));
        divButton.setFont(new Font("D2Coding", Font.PLAIN, 30));
        divButton.setBounds(375, 211, 78, 60);
        frame.getContentPane().add(divButton);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("D2Coding", Font.PLAIN, 20));
        textArea.setBounds(12, 303, 441, 348);
        frame.getContentPane().add(textArea);
    }
    
    private void performCalculation(ActionEvent e) {
        // JTextFiled에 입력된 문자열을 읽고, double 타입으로 변환
        String s1 = numText1.getText();
        String s2 = numText2.getText();
        
        double number1 = 0;
        double number2 = 0;
        
        try {
            number1 = Double.parseDouble(s1);
            number2 = Double.parseDouble(s2);
        } catch (NumberFormatException ex) {
            textArea.setText("number1 또는 number2는 숫자 타입으로 입력하세요...");
            return; //메서드 종료
        }
        double result; // 산술 연산 결과를 저장하기 위한 변수.
        String op = " ";
        
        Object source = e.getSource(); // 이벤트가 발생한 컴포넌트.
        if(source == sumButton) {
            result = number1 + number2;
            op = " + ";
        } else if ( source == subButton) {
            result = number1 - number2;
            op = " - ";
        } else if ( source == mulButton) {
            result = number1 * number2;
            op = " * ";
        } else {
            result = number1 / number2;
            op = " / ";
        }
        
        String output = String.format("%f %s %f = %f", 
                number1,op,number2,result);
        textArea.setText(output);
    }

    private void plus() {
        double num1 = Double.parseDouble(numText1.getText());
        double num2 = Double.parseDouble(numText2.getText());
        
        double sum = num1 + num2;
        
        StringBuilder buffer = new StringBuilder();
        
        buffer.append(num1).append("x").append(num2)
        .append(" = ").append(sum);
        
        textArea.setText(buffer.toString());
 
    }
    
//    private void subTraction() {
//        double num1 = Double.parseDouble(numText1.getText());
//        double num2 = Double.parseDouble(numText2.getText());
//        
//        double sub = num1 - num2;
//        
//        StringBuilder buffer = new StringBuilder();
//        
//        buffer.append(num1).append("-").append(num2)
//        .append(" = ").append(sub);
//        
//        textArea.setText(buffer.toString());
//    }
//    
//    private void multiplication() {
//        double num1 = Double.parseDouble(numText1.getText());
//        double num2 = Double.parseDouble(numText2.getText());
//        
//        double mul = num1 * num2;
//        
//        StringBuilder buffer = new StringBuilder();
//        
//        buffer.append(num1).append("x").append(num2)
//        .append(" = ").append(mul);
//        
//        textArea.setText(buffer.toString());
// 
//    }
//    
//    private void division() {
//        
//        
//        try {
//            double num1 = Double.parseDouble(numText1.getText());
//            double num2 = Double.parseDouble(numText2.getText());
//            
//            double div = num1 / num2;
//            
//            StringBuilder buffer = new StringBuilder();
//            
//            buffer.append(num1).append("/").append(num2)
//            .append(" = ").append(div);
//            
//            textArea.setText(buffer.toString());
//            
//        } catch (Exception e) {
//            System.out.println("num2의 값이 0이므로 나눌 수 없습니다.");
//            e.printStackTrace();
//        }
//        
// 
//    }

}
