package gui;

import db.CustomerDao;
import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author dell
 */
public class LoginPanel extends JFrame {
    private JFrame frame;
    JLabel label1, label2, label3;
    JButton button1, button2, button3, button4, button5;
    JTextField account;
    TextField password;
    private CustomerDao customerDao;
    public LoginPanel() {
        frame=this;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 300,
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 300, 500, 340);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setTitle("Login Panel");

        label2 = new JLabel("account");
        label2.setBounds(125, 95, 64, 20);
        frame.add(label2);

        label3 = new JLabel("password");
        label3.setBounds(125, 165, 64, 20);
        frame.add(label3);

        button4 = new JButton("Login");
        button4.setBounds(286, 223, 106, 20);
        button4.addActionListener(new PanelLoginAction());
        frame.add(button4);

        button5 = new JButton("Register");
        button5.setBounds(141, 223, 106, 20);
        frame.add(button5);
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterPanel();
                frame.dispose();
            }
        });

        account = new JTextField(15);
        account.setBounds(239, 95, 166, 20);
        frame.add(account);

        password = new TextField(20);
        password.setBounds(239, 165, 166, 20);
        password.setEchoChar('*');
        password.addKeyListener(new KeyAdapter() {
            public void ketPressed(final KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    button4.doClick();
                }
            }
        });
        frame.add(password);
    }
    private class PanelLoginAction implements ActionListener {
        public void actionPerformed(final ActionEvent e) { 
              customerDao = new CustomerDao();
              ResultSet rs = customerDao.getPassword(account.getText(), String.valueOf(password.getText()));
            try {
                if (rs.next()) { 
                    frame.removeNotify();
                    new OrderPanel(account.getText()).setVisible(true);
                } else {
                    JOptionPane pane = new JOptionPane("用户或密码错误");
                    JDialog dialog = pane.createDialog("警告");
                    dialog.setVisible(true);
                }
            } catch (SQLException ex) {
            }
            }            
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPanel().setVisible(true);
            }
        });
    }
}
