package gui;

import db.MovieDao;
import db.OrderDao;
import db.SeatDao;
import db.TimetableDao;
import entity.Movie;
import entity.Order;
import entity.Timetable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;

/**
 *
 * @author zk
 */
public class MyOrderPanel extends JFrame {

    private OrderDao orderDao;
    private String account;
    private List<Order> orderList;
    private MovieDao movieDao;
    private TimetableDao timetableDao;
    private JFrame frame;
    private SeatDao seatDao;

    public MyOrderPanel(String account) {
        frame = this;
        this.account = account;
        orderDao = new OrderDao();
        movieDao = new MovieDao();
        timetableDao = new TimetableDao();
        seatDao = new SeatDao();
        orderList = orderDao.getOrder(account);

        JScrollPane js = new JScrollPane(addOrderList(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setContentPane(js);
        this.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 300,
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 350, 500, 700);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    /**
     *
     * @return orderPanel
     */
    public JPanel addOrderList() {
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new GridLayout(0, 1));
        for (Order order : orderList) {
            orderPanel.add(addOrderItem(order));
        }
        if (orderList.size() < 6) {
            for (int i = 0; i < 6 - orderList.size(); i++) {
                orderPanel.add(new JPanel());
            }
        }
        return orderPanel;
    }

    /**
     *
     * @param order
     * @return orderItemPanel
     */
    public JPanel addOrderItem(Order order) {
        JPanel orderItemPanel = new JPanel();
        int seatId = order.getSeatId();

        orderItemPanel.setLayout(new BorderLayout());
        Border border = BorderFactory.createLineBorder(Color.GRAY);
        orderItemPanel.setBorder(border);
        orderItemPanel.setBackground(Color.ORANGE);
        Movie movie = movieDao.getMovieById(order.getMovieId());
        Timetable timetable = timetableDao.getTimetableById(order.getTimetableId());
        //image
        ImageIcon image = new ImageIcon(movie.getPicUrl());
        image.setImage(image.getImage().getScaledInstance(75, 90, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(image);
        orderItemPanel.add("West", imageLabel);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());
        //movie name
        JLabel nameLabel = new JLabel(movie.getName());
        infoPanel.add("North", nameLabel);
        //time
        JLabel timeLabel = new JLabel(timetable.getStartTime() + "-" + timetable.getEndTime());
        infoPanel.add("Center", timeLabel);
        //seat
        JLabel seatLabel = new JLabel("Room: " + timetable.getRoomId() + "    Seat: " + "Row " + (seatId / 10 + 1) + " Column " + (seatId % 10 + 1));
        infoPanel.add("South", seatLabel);
        //price
        DecimalFormat dcmFmt = new DecimalFormat("0.0");
        String priceStr = dcmFmt.format(timetable.getPrice());
        JLabel priceLabel = new JLabel("￥" + priceStr);

        orderItemPanel.add("South", priceLabel);

        orderItemPanel.add("Center", infoPanel);

        //button
        JButton button = new JButton("Refund");
        button.setBackground(Color.WHITE);
        button.addActionListener((ActionEvent e) -> {
            int flag = JOptionPane.showConfirmDialog(null, "Are you sure to refund the ticket?", "Refund", JOptionPane.YES_NO_OPTION);
            if (flag == 0) {
                //delete order
                orderDao.deleteOrderById(order.getId());
                //delete seat
                seatDao.deleteSeat(order.getSeatId(), order.getRoomId(), order.getTimetableId());
                frame.dispose();
                new MyOrderPanel(account).setVisible(true);
                
            } else {
                System.out.println("no");
            }
        });
        orderItemPanel.add("East", button);

        return orderItemPanel;
    }

}
