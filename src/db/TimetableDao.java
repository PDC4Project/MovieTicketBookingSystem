package db;

import entity.Timetable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zk
 */
public class TimetableDao {

    private final DB db;
    private final Connection conn;

    public TimetableDao(){
        db = new DB();
        conn = db.getConnection();
    }
    public int getMovieId(int timetableId, int roomId){
        return 0;
    }
    
    public List getList(int id) throws SQLException {
        String sql = "select * from timetable where movie_id ="+id;
        ResultSet rs = conn.createStatement().executeQuery(sql);
        List<Timetable> list = new ArrayList<>();
        while (rs.next()) {
            Timetable timetable = new Timetable();
            timetable.setId(rs.getInt("id"));
            timetable.setRoomId(rs.getInt("room_id"));
            timetable.setMovieId(rs.getInt("movie_id"));
            timetable.setPrice(rs.getDouble("price"));
            timetable.setStartTime(rs.getTime("start_time"));
            timetable.setEndTime(rs.getTime("end_time"));
            list.add(timetable);
        }
        return list;

    }

}
