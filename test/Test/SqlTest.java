package Test;

import db.OrderDao;
import db.SeatDao;
import db.TimetableDao;
import entity.Order;
import entity.Timetable;
import java.util.List;

/**
 *
 * @author zk
 */
public class SqlTest {

    private TimetableDao tDao;

    public static void main(String[] args) {
//        TimetableDao tDao = new TimetableDao();
//        Timetable timetable =   tDao.getTimetableById(1);
//        System.out.println(timetable.getId());
//        System.out.println(timetable.getPrice());
//        System.out.println(timetable.getMovieId());
        SeatDao seatDao = new SeatDao();
        OrderDao orderDao = new OrderDao();
        //  List<Order> orderList = orderDao.getOrder("admin");
        //  System.out.println(orderList.get(0).getMovieId());
        //  System.out.println(orderList.get(0).getSeatId());
        //System.out.println(orderList.size());

//        boolean isOrderDelete = orderDao.deleteOrderById(1201);
//        System.out.println(isOrderDelete);
        //seatDao.deleteSeat(66, 2, 2);
        

    }
}
