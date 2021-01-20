/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author DELL
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField; 
class RefundPanel extends JFrame{
    
    public static void main(String[] args) {    

        JFrame frame = new JFrame("退票界面");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();    
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);


        JLabel userLabel = new JLabel("退票成功！");

        userLabel.setBounds(280,20,80,25);
        panel.add(userLabel);

        JButton ReturnButton = new JButton("返回");
        ReturnButton.setBounds(10, 500, 80, 25);
        panel.add(ReturnButton);
        ReturnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                //delete the database
                
            }
        });

        
    }

}