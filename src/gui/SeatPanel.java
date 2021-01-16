package gui;

import db.SeatDao;
import entity.Seat;
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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.Border;

/**
 *
 * @author zk
 */
public class SeatPanel extends JFrame {

    private int roomId;
    private SeatDao seatDao;
    private List<Integer> seatId;

    public SeatPanel(int roomId,int timetableId) {
        this.roomId = roomId;
        seatDao = new SeatDao();
        seatId = seatDao.getSeatId(roomId,timetableId);
        this.setContentPane(setSeat(seatId));
        this.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 150, ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 150, 350, 350);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public JPanel setSeat(List<Integer> seatId) {
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
            JButton b = new JButton(i + 1 + "");
            if (bucket[i] == 1) {
                b.setBackground(Color.red);
                b.setEnabled(false);
            }
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            b.setBorder(border);
            jPanel.add(b);
            b.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    /**
                     *
                     */
                }
            });
        }
        return jPanel;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int roomId = 2;
                int timetableId =1;
                new SeatPanel(roomId,timetableId).setVisible(true);
            }
        });
    }
}
