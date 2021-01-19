package db;

import java.sql.Connection;

public class OrderDao {
     private final DB db;
    private final Connection conn;
    public OrderDao(){
        db = new DB();
        conn = db.getConnection();
    }
    public void insert(){
        String sql = "INSERT account, movie_id, room_id, seat_id, timetable_id into ";
    }
}
