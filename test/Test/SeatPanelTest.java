package Test;

import gui.SeatPanel;

/**
 *
 * @author zk
 */
public class SeatPanelTest {
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
