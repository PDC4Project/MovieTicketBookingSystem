package db;

import entity.Seat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zk
 */
public class SeatDao {

    private final DB db;
    private final Connection conn;

    public SeatDao() {
        db = new DB();
        conn = db.getConnection();
    }

    public List getSeatId(int roomId,int timetableId) {
        String sql = "select id from seat where room_id = " + roomId + "and timetable_id ="+ timetableId;
        ResultSet rs;
        List<Integer> list = new ArrayList<>();
        try {
            rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
             list.add(rs.getInt("id"));             
            }
        } catch (SQLException ex) {
        }
        return list;
    }
}
