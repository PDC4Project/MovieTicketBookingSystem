package Test;

import db.OrderDao;
import db.SeatDao;
import db.TimetableDao;
import entity.Order;
import entity.Timetable;
import java.util.List;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * The test of some sql statement during development
 * @author zk
 */
public class SqlTest {

    SeatDao seatDao;
    OrderDao orderDao;
    TimetableDao timetableDao;
    Timetable timetable;

    @Before
    public void setUp() {
        seatDao = new SeatDao();
        orderDao = new OrderDao();
        timetableDao = new TimetableDao();
    }

    @Test
    public void testSql() {

        Timetable timetable = timetableDao.getTimetableById(1);
        assertTrue(timetable.getId() != 0);
        assertTrue(timetable.getPrice() != 0);
        assertTrue(timetable.getMovieId() != 0);

        List<Order> orderList = orderDao.getOrder("admin");
        assertTrue(orderList.get(0).getMovieId() != 0);
        assertTrue(orderList.get(0).getSeatId() != 0);
        assertTrue(orderList.size() > 1);

        orderDao.deleteOrderById(1201);
        seatDao.deleteSeat(66, 2, 2);
    }
}
