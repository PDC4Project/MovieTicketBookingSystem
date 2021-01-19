package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public void insertSeatId(int roomId,int seatId,int timetableId){
      //  String sql = "insert into seat room_id,sea"
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
