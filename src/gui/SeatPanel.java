package gui;

import java.awt.Toolkit;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
/**
 *
 * @author zk
 */
    public class SeatPanel extends JFrame {

    public SeatPanel() {
        this.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-300, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-300,600,600);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
                     
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeatPanel().setVisible(true);
            }
        });
    }
}
