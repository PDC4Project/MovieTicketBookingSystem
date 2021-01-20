package db;

import entity.Seat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public void insertSeatId(Map<Integer, Seat> seatMap) {
        String sql = "insert into seat(room_id,id,timetable_id) values (?,?,?)";
        PreparedStatement ps = null;
        for (Map.Entry<Integer, Seat> entry : seatMap.entrySet()) {
            Seat seat = entry.getValue();
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, seat.getRoomId());
                ps.setInt(2, seat.getId());
                ps.setInt(3, seat.getTimetableId());
                ps.execute();
            } catch (SQLException ex) {
            }
        }
    }

    public List getSeatId(int roomId, int timetableId) {
        String sql = "select id from seat where room_id = " + roomId + "and timetable_id =" + timetableId;
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

    public void deleteSeat(int id, int roomId, int timetableId) {
        String sql = "delete from seat where id =? and room_id = ? and timetable_id= ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, roomId);
            ps.setInt(3, timetableId);
            ps.execute();
        } catch (SQLException ex) {
        }
    }
}
