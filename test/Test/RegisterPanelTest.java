package Test;

import gui.RegisterPanel;
import java.awt.EventQueue;

/**
 *
 * @author zk
 */
public class RegisterPanelTest {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   new RegisterPanel();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
