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
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField; 
import javax.swing.table.DefaultTableModel;
public class CheckPanel {
    
    public static void main(String[] args) {    

        JFrame frame = new JFrame("订单界面");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();    
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
        
        
        
        
    }

    private static void placeComponents(JPanel panel) {

        panel.setLayout(null);


        JLabel userLabel = new JLabel("订票成功！");
        userLabel.setBounds(280,20,80,25);
        panel.add(userLabel);

        

        JLabel Label_11 = new JLabel("电影名称：");
        Label_11.setBounds(10,50,80,25);
        panel.add(Label_11);
 
        
        JLabel Label_21 = new JLabel("放映时间：");
        Label_21.setBounds(140,50,80,25);
        panel.add(Label_21);

        
         JLabel Label_31 = new JLabel("放映厅号：");
        Label_31.setBounds(270,50,80,25);
        panel.add(Label_31); 
        
 
        JLabel Label_41 = new JLabel("您的座位：");
        Label_41.setBounds(400,50,80,25);
        panel.add(Label_41);
        
        
//        JTextField Text = new JTextField(20);
//        Text.setBounds(10,80,500,400);
//        panel.add(Text);
        JTable table = new JTable(10, 4);
        table.setBounds(10,80,500,160);
        panel.add(table);

        JButton loginButton = new JButton("退票");
        loginButton.setBounds(10, 500, 80, 25);
        panel.add(loginButton);


    }

}
