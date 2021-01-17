/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc;

import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



/**
 *
 * @author dell
 */

public class LoginPanel extends JFrame  {
   private JFrame frame;
   JLabel label1,label2,label3;
   JButton button1,button2,button3,button4,button5;
   JTextField name;
   TextField passWord;
   
   public LoginPanel(){
     super();
     JFrame frame=new JFrame();
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setVisible(true);
     frame.setResizable(false);
     frame.getContentPane().setLayout(null);
     frame.setTitle("Login Panel");
     frame.setSize(500,340);
     
 
     label2=new JLabel("username");
     label2.setBounds(125, 95, 64, 20);
     frame.add(label2);
     
     label3=new JLabel("password");
     label3.setBounds(125, 165, 64, 20);
     frame.add(label3);
     
     
     button4=new JButton("Login");
     button4.setBounds(286, 223, 106, 20);
     frame.add(button4);
     
     button5=new JButton("register");
     button5.setBounds(141, 223, 106, 20);
     frame.add(button5);
     button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new RegisterPanel();
				frame.removeNotify();

			}
		});
     
     name= new JTextField(15);
     name.setBounds(239, 95, 166, 20);
     frame.add(name);
     
     passWord=new TextField(20);
     passWord.setBounds(239, 165, 166, 20);
     passWord.setEchoChar('*');
     passWord.addKeyListener(new KeyAdapter(){
         public void ketPressed(final KeyEvent e){
             if(e.getKeyCode()==10){
                 button4.doClick();
             }
         }
     });
     frame.add(passWord);
     
     init();
   }
  private void init(){
      
  }
  private class PanelLoginAction implements ActionListener {
    public void actionPerformed(final ActionEvent e){
        ConnectBridge c = new ConnectBridge();

				Connection conn = c.getConnect();

				PreparedStatement ps = null;
				ResultSet rs = null;

				try {
					ps = conn.prepareStatement("select *from user where name=? and username=? and password=?");

					ps.setString(1, name.getText());
					ps.setString(2, passWord.getText());

					rs = ps.executeQuery();
					if (rs.next()) {
                                            new LoginPanel();
                                            frame.removeNotify();
					} else {
						JOptionPane pane = new JOptionPane("用户或密码错误");
	                     JDialog dialog  = pane.createDialog("警告");
	                     dialog.show();
					}

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}}
 public static void main(String args[]) {
       EventQueue.invokeLater(new Runnable() {
           public void run() {
                new LoginPanel().setVisible(true);
           }
        });
    }
}
     
		
