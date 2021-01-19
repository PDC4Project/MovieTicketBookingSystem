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
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

    public SeatPanel(String account, int roomId, int timetableId, int movieId) {
        this.roomId = roomId;
        this.account = account;
        this.movieId = movieId;
        this.timetableId = timetableId;
        seatDao = new SeatDao();
        seatIdList = seatDao.getSeatId(roomId, timetableId);
        orderMap = new HashMap<>();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add("Center", addSeat(seatIdList));
        jPanel.add("South", addConfirmButton());
        this.setContentPane(jPanel);
        this.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 150, ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 150, 350, 350);
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
            System.out.println(seatIdList.get(j));
        }
        for (int i = 0; i < 80; i++) {
           
            JToggleButton b = new JToggleButton(i + 1 + "");
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            b.setBorder(border);
            if (bucket[i] == 1) {
                b.setBackground(Color.red);
                b.setEnabled(false);
            }
            b.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                   
                    JToggleButton toggleBtn = (JToggleButton) e.getSource();
                     seatId = Integer.valueOf(toggleBtn.getText());
                    if (toggleBtn.isSelected() == true) {
                        Order order = new Order();
                        order.setAccount(account);
                        order.setMovieId(movieId);
                        order.setRoomId(roomId);
                        order.setTimetableId(timetableId);
                        order.setSeatId(seatId);
                        orderMap.put(seatId, order);
                    } else {
                        orderMap.remove(seatId);
                    }
                }
            });
            jPanel.add(b);
        }
        return jPanel;
    }

    public JPanel addConfirmButton() {
        JPanel jPanel = new JPanel();
        JButton button = new JButton("confirm");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderDao = new OrderDao();
                if (orderMap.size() == 0) {
                    System.out.println("null");
                } else {
                    orderDao.insert(orderMap);
                }
            }
        });
        jPanel.add(button);
        return jPanel;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int roomId = 2;
                int timetableId = 2;
                new SeatPanel("aaa", roomId, timetableId, 1).setVisible(true);
            }
        });
    }
}
