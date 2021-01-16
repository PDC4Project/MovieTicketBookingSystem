package db;


import entity.Movie;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author zk
 */
public class MovieDao {

    private final DB db;
    private final Connection conn;
    public MovieDao(){
        db = new DB();
        conn = db.getConnection();
    }

    public void insert() {
    }

    public void delete() {
    }

    public void update() {
    }

  
    public List getList() throws SQLException {
        String sql = "select * from movie";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        List<Movie> list = new ArrayList<>();
        while (rs.next()) {
            Movie movie = new Movie();
            movie.setId(rs.getInt("id"));
            movie.setName(rs.getString("name"));
            movie.setPicUrl(rs.getString("pic_url"));
            list.add(movie);
        }
        return list;
    }

}
