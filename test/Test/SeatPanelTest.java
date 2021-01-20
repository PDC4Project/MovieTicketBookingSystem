package Test;

import db.OrderDao;
import db.SeatDao;
import entity.Order;
import entity.Seat;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test of seat panel
 * @author zk
 */
public class SeatPanelTest {

    Order order;
    Seat seat;
    String account;
    int movieId,roomId,timetableId,seatId;
    Map<Integer,Order> orderMap;
    Map<Integer,Seat> seatMap;
    OrderDao orderDao;
    SeatDao seatDao;
    
    @Before
    public void setUp() {
        order = new Order();
        account = "test";
        movieId =2;
        roomId =2;
        timetableId = 2;
        seatId =2;
        orderDao = new OrderDao();
        seatDao = new SeatDao();
        orderMap = new HashMap<>();
        seatMap = new HashMap<>();    
    }

    @Test
    public void testInsertOrder() {
        order.setAccount(account);
        order.setMovieId(movieId);
        order.setRoomId(roomId);
        order.setTimetableId(timetableId);
        order.setSeatId(seatId);
        orderMap.put(seatId, order);
        orderDao.insert(orderMap);
                     
    }
   @Test
    public void testInsertSeat() {
        seat = new Seat();
        seat.setId(seatId);
        seat.setRoomId(roomId);
        seat.setTimetableId(timetableId);
        seatMap.put(seatId, seat);
        seatDao.insertSeatId(seatMap);
    }

    @After
    public void tearDown() {
        seatDao.deleteSeat(seatId, roomId, timetableId);
    }
}
