package Test;

import db.MovieDao;
import db.TimetableDao;
import entity.Movie;
import entity.Timetable;
import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * The test of order panel
 * @author zk
 */
public class OrderPanelTest {

    String account;
    MovieDao movieDao;
    List<Movie> movieList;
    TimetableDao td;
    List<Timetable> list;

    @Before
    public void setUp() {
        account = "test";
        movieDao = new MovieDao();
        td = new TimetableDao();
    }

    @Test
    public void testGetMovieList() {
        try {
            movieList = movieDao.getList();
            assertTrue(movieList.size() > 1);
        } catch (SQLException ex) {
        }
    }

    public void testGetTimetableListByMovieId() {
        try {
            list = td.getList(1);
            assertTrue(movieList.size() > 1);
        } catch (SQLException ex) {
        }
    }

    @After
    public void tearDown() {
        account = null;
    }
}
