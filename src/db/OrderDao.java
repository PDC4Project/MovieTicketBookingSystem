package db;

import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderDao {

    private final DB db;
    private final Connection conn;

    public OrderDao() {
        db = new DB();
        conn = db.getConnection();
    }

    public void deleteOrderById(int id) {
        String sql = "delete from order_movie where id = " + id;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
        }

    }

    public List<Order> getOrder(String account) {
        String sql = "select * from order_movie where account = ?";
        PreparedStatement ps = null;
        List<Order> orderList = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt("id"));
                order.setAccount(account);
                order.setMovieId(rs.getInt("movie_id"));
                order.setRoomId(rs.getInt("room_id"));
                order.setSeatId(rs.getInt("seat_id"));
                order.setTimetableId(rs.getInt("timetable_id"));
                orderList.add(order);
            }
        } catch (SQLException ex) {
        }
        return orderList;
    }

    public void insert(Map<Integer, Order> orderMap) {

        String sql = "insert into order_movie(account, movie_id, room_id, seat_id, timetable_id) values (?,?,?,?,?) ";
        PreparedStatement ps = null;
        for (Map.Entry<Integer, Order> entry : orderMap.entrySet()) {
            Order order = entry.getValue();
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, order.getAccount());
                ps.setInt(2, order.getMovieId());
                ps.setInt(3, order.getRoomId());
                ps.setInt(4, order.getSeatId());
                ps.setInt(5, order.getTimetableId());
                ps.execute();
            } catch (SQLException ex) {
            }
        }
    }
}
