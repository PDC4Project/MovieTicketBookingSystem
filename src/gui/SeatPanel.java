package gui;

import db.OrderDao;
import db.SeatDao;
import entity.Order;
import entity.Seat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author zk
 */
public class SeatPanel extends JFrame {

    private int roomId;
    private SeatDao seatDao;
    private List<Integer> seatIdList;
    private int timetableId;
    private int seatId;
    private String account;
    private int movieId;
    private OrderDao orderDao;
    private Map<Integer, Order> orderMap;
    private Map<Integer, Seat> seatMap;
    private JFrame frame;

    public SeatPanel(String account, int roomId, int timetableId, int movieId) {
        frame = this;
        this.roomId = roomId;
        this.account = account;
        this.movieId = movieId;
        this.timetableId = timetableId;
        seatDao = new SeatDao();
        seatIdList = seatDao.getSeatId(roomId, timetableId);
        orderMap = new HashMap<>();
        seatMap = new HashMap<>();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add("Center", addSeat(seatIdList));
        jPanel.add("South", addConfirmButton());
        this.setContentPane(jPanel);
        this.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 175, ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 175, 350, 350);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public JPanel addSeat(List<Integer> seatIdList) {
        JPanel jPanel = new JPanel();

        jPanel.setLayout(new GridLayout(8, 10));
        int[] bucket = new int[80];
        for (int i = 0; i < 80; i++) {
            bucket[i] = 0;
        }
        for (int j = 0; j < seatIdList.size(); j++) {
            bucket[seatIdList.get(j)] = 1;
        }
        for (int i = 0; i < 80; i++) {

            JToggleButton b = new JToggleButton(i + 1 + "");
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            b.setBorder(border);
            if (bucket[i] == 1) {
                b.setBackground(Color.red);
                b.setEnabled(false);
            }
            b.addChangeListener((ChangeEvent e) -> {
                JToggleButton toggleBtn = (JToggleButton) e.getSource();
                seatId = Integer.valueOf(toggleBtn.getText()) - 1;
                if (toggleBtn.isSelected() == true) {
                    Order order = new Order();
                    order.setAccount(account);
                    order.setMovieId(movieId);
                    order.setRoomId(roomId);
                    order.setTimetableId(timetableId);
                    order.setSeatId(seatId);
                    orderMap.put(seatId, order);
                    Seat seat = new Seat();
                    seat.setId(seatId);
                    seat.setRoomId(roomId);
                    seat.setTimetableId(timetableId);
                    seatMap.put(seatId, seat);
                } else {
                    orderMap.remove(seatId);
                    seatMap.remove(seatId);
                }
            });
            jPanel.add(b);
        }
        return jPanel;
    }

    public JPanel addConfirmButton() {
        JPanel jPanel = new JPanel();
        JButton button = new JButton("confirm");
        button.addActionListener((ActionEvent e) -> {
            orderDao = new OrderDao();
            if (orderMap.isEmpty()) {
                System.out.println("null");
                JOptionPane.showMessageDialog(null, "Please choose a seat!", "Have not chose!", JOptionPane.ERROR_MESSAGE);
            } else {
                orderDao.insert(orderMap);
                seatDao.insertSeatId(seatMap);
                frame.dispose();
            }
        });
        jPanel.add(button);
        return jPanel;
    }

}
