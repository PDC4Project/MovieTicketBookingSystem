package gui;

import db.SeatDao;
import entity.Order;
import entity.Seat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;

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

    public SeatPanel(int roomId,int timetableId) {
        this.roomId = roomId;
        this.timetableId = timetableId;
        seatDao = new SeatDao();
        seatIdList = seatDao.getSeatId(roomId,timetableId);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add("Center",addSeat(seatIdList));
        jPanel.add("South",addConfirmButton());
        this.setContentPane(jPanel);
        this.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 150, ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 150, 350, 350);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public JPanel addSeat(List<Integer> seatId) {
        int id  = 0;
        JPanel jPanel = new JPanel();
        
        jPanel.setLayout(new GridLayout(8, 10));
        int[] bucket = new int[80];
        for (int i = 0; i < 80; i++) {
            bucket[i] = 0;
        }
        for (int j = 0; j < seatId.size(); j++) {
            bucket[seatId.get(j)] = 1;
            System.out.println(seatId.get(j));
        }
        for (int i = 0; i < 80; i++) {
            id =i;
            JToggleButton b = new JToggleButton(i + 1 + "");
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            b.setBorder(border);
            if (bucket[i] == 1) {
                b.setBackground(Color.red);
                b.setEnabled(false);
            }
             b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   Order order = new Order();                 
                   order.setAccount("1");
                   order.setMovieId(1);
                   order.setRoomId(roomId);
                   order.setTimetableId(timetableId);
                  // order.setSeatId(id);
                }
            });    
            jPanel.add(b);               
        }
        return jPanel;
    }
    
    public JPanel addConfirmButton(){
        JPanel jPanel = new JPanel();
        JButton button = new JButton("confirm");
        button.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                   
                }
            });
        jPanel.add(button);
        return jPanel;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int roomId = 2;
                int timetableId =2;
                new SeatPanel(roomId,timetableId).setVisible(true);
            }
        });
    }
}
