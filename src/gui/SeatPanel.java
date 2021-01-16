package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

    public SeatPanel() {
        this.setContentPane(setSeat());
        this.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width)/2)-150, ((Toolkit.getDefaultToolkit().getScreenSize().height)/2)-150,350,350);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public JPanel setSeat(){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(11,12));
        for(int i =0;i<132;i++){
            JButton b = new JButton();
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            b.setBorder(border);
            jPanel.add(b);
            b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
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
                new SeatPanel().setVisible(true);
            }
        });
    }
}
