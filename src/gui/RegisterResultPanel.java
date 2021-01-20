package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dell
 */
public class RegisterResultPanel {

    private JFrame frame;
    public RegisterResultPanel() {
        init();
    }
    private void init() {
        frame = new JFrame();
        frame.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2)-110,
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2)-100, 220, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        JLabel result = new JLabel("Register Successfully !");
        result.setFont(new Font("Arial", Font.PLAIN, 20));
        
        frame.getContentPane().add("Center",result);

        JButton returnButton = new JButton("Return Login Panel!");
        returnButton.addActionListener((ActionEvent e) -> {
            new LoginPanel();
            frame.removeNotify();
        });
        returnButton.setPreferredSize(new Dimension(50,50));
        frame.getContentPane().add("South",returnButton);
    }
}
