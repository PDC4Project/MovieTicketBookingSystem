/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dell
 */
public class CustomerDao {
    private final DB db;
    private final Connection conn;
    public CustomerDao(){
        db=new DB();
        conn=db.getConnection();
    }
    
    public void insert() {
    }

    public void delete() {
    }

    public void update() {
    }
    
    public List getList()throws SQLException{
        String sql="select * from CUSTOMER";
        ResultSet rs=conn.createStatement().executeQuery(sql);
        List<Customer> list= new ArrayList<>();
        while(rs.next()){
            Customer customer=new Customer();
            customer.setName(rs.getString("name"));
            customer.setUserame(rs.getString("username"));
            customer.setPassword(rs.getString("password"));
            customer.setEmail(rs.getString("email"));
            customer.setTelephone(rs.getString("telephone"));
            list.add(customer);
        }
        return list;
    }
}
