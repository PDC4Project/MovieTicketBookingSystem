package Test;

import gui.OrderPanel;

/**
 *
 * @author syfhz
 */
public class OrderPanelTest {
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new OrderPanel("aaa").setVisible(true);
        });
    }
}
