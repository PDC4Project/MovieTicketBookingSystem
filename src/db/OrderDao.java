package db;

import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class OrderDao {

    private final DB db;
    private final Connection conn;

    public OrderDao() {
        db = new DB();
        conn = db.getConnection();
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
