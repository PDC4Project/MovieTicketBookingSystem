/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc;

import gui.RegisterResult;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author 寒暄
 */

public class RegisterPanel extends JFrame{
   private JFrame frame;
   
    public RegisterPanel() {
        init();
    }
    private void init() {
            frame = new JFrame(); 
            frame.setSize(602,580);
            frame.setTitle("Register Panel");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    frame.setResizable(false);
	    frame.getContentPane().setLayout(null);
            
            
            JLabel name = new JLabel("name:");
            name.setBounds(100, 61, 127, 20);
            frame.add(name);
            
            JLabel username= new JLabel("username:");
            username.setBounds(100, 116, 127, 20);
            frame.add(username);

            JLabel Password = new JLabel("password:");
            Password.setBounds(100, 171, 127, 20);
            frame.add(Password);  
               
            JLabel confirm = new JLabel("confirm password:");
            confirm.setBounds(100, 226, 127, 20);
            frame.add(confirm);
            
            JLabel emailStr = new JLabel("email:");
            emailStr.setBounds(100, 281, 127, 20);
            frame.add(emailStr);
            
            JLabel teleStr = new JLabel("telephone number:");
            teleStr.setBounds(100, 336, 127, 20);
            frame.add(teleStr);
            
            JTextField Name= new JTextField();
            Name.setBounds(257, 61, 200, 20);
            frame.add(Name);
            
            JTextField userName = new JTextField();
            userName.setBounds(257, 116, 200, 20);
            frame.add(userName);

            JPasswordField password = new JPasswordField();
            password.setBounds(257, 171, 200, 20);
            frame.add(password);

            JPasswordField confirmPassword = new JPasswordField();
            confirmPassword.setBounds(257, 226, 200, 20);
            frame.add(confirmPassword);
            
            JTextField email = new JTextField();
            email.setBounds(257, 281, 200, 20);
            frame.add(email);
            
            JTextField telephone = new JTextField();
            telephone.setBounds(257, 336, 200, 20);
            frame.add(telephone);
            
            
            JButton buttonregister = new JButton("register");
            buttonregister.setBounds(233, 486, 120, 20);
            frame.add(buttonregister);
            buttonregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            
				ConnectBridge c = new ConnectBridge();

				Connection conn = c.getConnect();

				PreparedStatement ps = null;
				try {
					ps = conn.prepareStatement("insert into user values(default, ?,?,?,?,?,?)");

					ps.setString(1, Name.getText());
                                        ps.setString(2, userName.getText());
                                        ps.setString(3, password.getText());
					ps.setString(4, confirmPassword.getText());
                                        ps.setString(5, email.getText());
                                        ps.setString(6, telephone.getText());
                                         //String passwd = new String (password.getPassword());
                                         //String confrimpasswd = new String (confirmPassword.getPassword());
					ps.execute();

					new RegisterResult();
					frame.removeNotify();
                                        
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
            
            JCheckBox checkbox=new JCheckBox("I have read and accpeted the instructions");
            checkbox.setBounds(100, 438, 366, 20);
            frame.add(checkbox);
    }
        
        public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPanel window = new RegisterPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

