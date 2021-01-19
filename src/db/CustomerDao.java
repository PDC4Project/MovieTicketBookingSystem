package db;

import entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public CustomerDao() {
        db = new DB();
        conn = db.getConnection();
    }

    public boolean insert(Customer c) {
        String sql = "insert into customer(name,account,password,email,telephone) ?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getName());
            ps.setString(2, c.getAccount());
            ps.setString(3, c.getPassword());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getTelephone());
            ps.execute();
        } catch (SQLException ex) {
        }
        return true;
    }

    public ResultSet getPassword(String account, String password) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("select * from customer where account=? and password=?");
            ps.setString(1, account);
            ps.setString(2, password);
            rs = ps.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return rs;
    }
    public boolean checkAccount(String account){      
        String sql  = "select * from customer where account = "+account;
        try {
           return conn.createStatement().execute(sql);
        } catch (SQLException ex) {
        }
        return false;
    }
    public List getList() throws SQLException {
        String sql = "select * from CUSTOMER";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        List<Customer> list = new ArrayList<>();
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setName(rs.getString("name"));
            customer.setAccount(rs.getString("account"));
            customer.setPassword(rs.getString("password"));
            customer.setEmail(rs.getString("email"));
            customer.setTelephone(rs.getString("telephone"));
            list.add(customer);
        }
        return list;
    }
}
