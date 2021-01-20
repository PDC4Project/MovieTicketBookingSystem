package Test;

import gui.RegisterResultPanel;
import java.awt.EventQueue;

/**
 *
 * @author zk
 */
public class RegisterResultPanelTest {
        public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                   new RegisterResultPanel();
                } catch (Exception e) {
                }
            }
        });
    }
}
