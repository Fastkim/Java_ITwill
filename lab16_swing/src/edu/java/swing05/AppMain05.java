package edu.java.swing05;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;

public class AppMain05 {

    private JFrame frame;
    private JLabel lblImage;
   
    List<JLabel> images = Arrays.asList(
            new JLabel(new ImageIcon("images/chunsik1.jpg")),
            new JLabel(new ImageIcon("images/chunsik2.jpg")),
            new JLabel(new ImageIcon("images/chunsik3.jpg")),
            new JLabel(new ImageIcon("images/chunsik4.jpg")),
            new JLabel(new ImageIcon("images/chunsik5.jpg"))
);
                
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
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
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1300, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblImage = new JLabel(new ImageIcon("images/chunsik1.jpg"));
        lblImage.setBounds(12, 10, 1200, 800);
        frame.getContentPane().add(lblImage);
        
        JButton btnPrev = new JButton("Prev");
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prev();
            }
        });
        btnPrev.setFont(new Font("굴림", Font.PLAIN, 20));
        btnPrev.setBounds(12, 820, 154, 31);
        frame.getContentPane().add(btnPrev);
        
        JButton btnNext = new JButton("Next");
        btnNext.setFont(new Font("굴림", Font.PLAIN, 20));
        btnNext.setBounds(205, 820, 154, 31);
        frame.getContentPane().add(btnNext);
        
        
    }
    // 배열이나 리스트를 사용해도된다.
    
    private void prev() {
        if (lblImage.getIcon().equals(images.get(0)))  {
            System.out.println("바보");
        } lblImage.setIc
        System.out.println(lblImage.getIcon());
    }
}
