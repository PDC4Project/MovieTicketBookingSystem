package Test;

import gui.MyOrderPanel;

/**
 *
 * @author zk
 */
public class MyOrderPanelTest {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new MyOrderPanel("admin").setVisible(true);
        });
    }
}
