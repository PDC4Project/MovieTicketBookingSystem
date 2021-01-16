/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
    
    public Connection getConnect() {
		Connection conn=null;
		String url="jdbc:derby://localhost:1527/TicketDB";
		String username=null;
		String password=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, username, password);
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
