/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author 寒暄
 */
class registerpart {
    String username;
    String password;
    String confirmpassword;
    String email;
    String telephone;
    
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "";
    
    void setName(String username) {
        this.username = username;
    }
    void setPassword(String password) {
        this.password = password;
    }
    void setconfirmpasswd(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }
     void setemail(String email) {
        this.email = email;
    }
      void settelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
    //判断注册的账号是否符合规则
    boolean JudgeRegister() throws SQLException, ClassNotFoundException {
        
        if(this.username.equals("")) {
            JOptionPane.showMessageDialog(null, " Username cannot be empty! ", "username", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(this.password.equals("")) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty!", "password is empty", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if(!this.password.equals(this.confirmpassword)) {
            JOptionPane.showMessageDialog(null, " The two passwords are inconsistent! ", " The password is inconsistent ", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        //符合规则，弹出注册成功的窗口，并将账号添加数据库
        JOptionPane.showMessageDialog(null, "Register successfully!");
        
        return true;
    }
}


public class RegisterPanel extends JFrame{
   private JFrame frame;
   
    public RegisterPanel() {
        init();
    }
    private void init() {
                frame = new JFrame(); 
                frame.setSize(602,536);
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
