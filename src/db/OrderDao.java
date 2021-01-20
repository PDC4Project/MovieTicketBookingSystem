package db;

import entity.Movie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

