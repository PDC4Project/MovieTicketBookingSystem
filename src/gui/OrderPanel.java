package gui;

import db.MovieDao;
import db.TimetableDao;
import entity.Movie;
import entity.Timetable;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.Border;

/**
 * @author zk
 */
public class OrderPanel extends JFrame {

    private JTabbedPane tp;
    private String account;
    private MovieDao movieDao;

    public OrderPanel(String account) {
        this.account = account;
        this.setContentPane(addMoviePic());
        this.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 300,
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 350, 600, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     *
     * @return a tabbed pane of each movie
     */
    public JTabbedPane addMoviePic() {
        tp = new JTabbedPane();
        try {
            movieDao = new MovieDao();
            List<Movie> movieList = movieDao.getList();
            for (int i = 0; i < movieList.size(); i++) {
                Movie movie = movieList.get(i);
                JPanel jp = new JPanel();
                JScrollPane scrollPane = new JScrollPane(jp);
                GridBagLayout gb = new GridBagLayout();
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.weightx = 100;
                gbc.weighty = 100;
                gbc.anchor = GridBagConstraints.CENTER;
                jp.setLayout(gb);

                /*StartTime  RoomId  price  isBook*/
                gbc.gridx = 0;
                gbc.gridy = 0;
                gbc.gridwidth = 1;
                gbc.gridheight = 2;
                JLabel movieNameLabel = new JLabel(movie.getName());
                gb.setConstraints(movieNameLabel, gbc);
                jp.add(movieNameLabel);

                ImageIcon image = new ImageIcon(movie.getPicUrl());
                image.setImage(image.getImage().getScaledInstance(200, 240, Image.SCALE_DEFAULT));
                gbc.gridx = 0;
                gbc.gridy = 3;
                gbc.gridwidth = 1;
                gbc.gridheight = 1;

                JLabel jLabel = new JLabel(image);
                gb.setConstraints(jLabel, gbc);
                jp.add(jLabel);

                gbc.gridy = 5;
                gbc.gridx = 0;
                gbc.gridwidth = 2;
                gbc.gridheight = 1;
                JPanel jPanel = addTitle();
                gbc.fill = GridBagConstraints.BOTH;
                gb.setConstraints(jPanel, gbc);
                jp.add(jPanel);

                TimetableDao td = new TimetableDao();
                List<Timetable> list = td.getList(movie.getId());

                for (int j = 0; j < list.size(); j++) {
                    Timetable t = list.get(j);
                    gbc.gridy = j + 6;
                    gbc.gridx = 0;
                    gbc.gridwidth = 2;
                    gbc.gridheight = 1;
                    JPanel jPanel2 = addTimeTable(t.getId(), t.getStartTime(), t.getEndTime(), t.getRoomId(), t.getPrice(), t.getMovieId());
                    gbc.fill = GridBagConstraints.BOTH;
                    gb.setConstraints(jPanel2, gbc);
                    jp.add(jPanel2);
                }
                if (list.size() < 10) {
                    for (int k = 0; k < 10 - list.size(); k++) {
                        JPanel blank = new JPanel();
                        gbc.gridy = list.size() + 6 + k;
                        gbc.gridx = 0;
                        gbc.gridheight = 1;
                        gb.setConstraints(blank, gbc);
                        jp.add(blank);
                    }
                }
                JButton myOrderButton = new JButton("My Order");
                myOrderButton.setBackground(Color.ORANGE);
                myOrderButton.addActionListener((ActionEvent e) -> {
                    new MyOrderPanel(account).setVisible(true);
                });
                jp.add(myOrderButton);
                tp.addTab("Movie " + (i + 1), scrollPane);
            }
        } catch (SQLException ex) {
        }
        return tp;
    }

    public JPanel addTitle() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout());
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        titlePanel.setBorder(border);
        JLabel l1 = new JLabel("Time Table");
        JLabel l2 = new JLabel("Screening Room");
        JLabel l3 = new JLabel("Price");
        JLabel l4 = new JLabel("Choose Seat");
        titlePanel.add(l1);
        titlePanel.add(l2);
        titlePanel.add(l3);
        titlePanel.add(l4);
        return titlePanel;
    }

    /**
     *
     * @param timetableId
     * @param startTime
     * @param endTime
     * @param roomId
     * @param price
     * @param movieId
     * @return timetablePanel
     */
    public JPanel addTimeTable(int timetableId, Time startTime, Time endTime, int roomId, double price, int movieId) {
        JPanel timeTablePanel = new JPanel();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        timeTablePanel.setBorder(border);
        timeTablePanel.setLayout(new GridLayout());
        JLabel startTimeLabel = new JLabel(startTime + "-" + endTime);
        JLabel roomLabel = new JLabel("Room" + roomId);
        JLabel priceLabel = new JLabel("￥" + price);
        JButton b = new JButton("Choose Seat");
        b.setBackground(Color.ORANGE);

        b.addActionListener((ActionEvent e) -> {
            new SeatPanel(account, roomId, timetableId, movieId).setVisible(true);
        });
        timeTablePanel.add(startTimeLabel);
        timeTablePanel.add(roomLabel);
        timeTablePanel.add(priceLabel);
        timeTablePanel.add(b);

        return timeTablePanel;
    }
}
