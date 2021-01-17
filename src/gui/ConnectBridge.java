/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class ConnectBridge {
     String username;
    String password;
    String confirmpassword;
    String email;
    String telephone;
    
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
    
   
    public Connection getConnect() {
		Connection conn=null;
		String url="jdbc:derby://localhost:1527/TicketDB";
                String sql="insert into admin (username, password, email, telephone) values (?,?,?,?)";
		String username=null;
		String password=null;
                
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, username, password);
                        PreparedStatement ps = conn.prepareStatement(sql);
	                ps.setString(1, this.username);
                        ps.setString(2, this.password);
                        ps.setString(3, this.email);
                        ps.setString(4, this.telephone);
                        ps.executeUpdate();
                        ps.close();	
			return conn;
		}catch(ClassNotFoundException e){
		    System.out.println("Error");
		    e.printStackTrace();
		    return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
     
}
