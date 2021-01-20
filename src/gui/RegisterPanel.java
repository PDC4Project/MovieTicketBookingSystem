package gui;

import db.CustomerDao;
import entity.Customer;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author 寒暄
 */
public class RegisterPanel extends JFrame {

    private JFrame frame;
    private CustomerDao customerDao;
    private JOptionPane jop;

    public RegisterPanel() {
        init();
    }

    private void init() {
        frame = new JFrame();
        frame.setTitle("Register Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setBounds(((Toolkit.getDefaultToolkit().getScreenSize().width) / 2) - 300,
                ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2) - 290, 600, 580);
        jop = new JOptionPane();

        JLabel nameLabel = new JLabel("name:");
        nameLabel.setBounds(100, 61, 127, 20);
        frame.add(nameLabel);

        JLabel accountLabel = new JLabel("account:");
        accountLabel.setBounds(100, 116, 127, 20);
        frame.add(accountLabel);

        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setBounds(100, 171, 127, 20);
        frame.add(passwordLabel);

        JLabel confirmLabel = new JLabel("confirm password:");
        confirmLabel.setBounds(100, 226, 127, 20);
        frame.add(confirmLabel);

        JLabel emailStr = new JLabel("email:");
        emailStr.setBounds(100, 281, 127, 20);
        frame.add(emailStr);

        JLabel teleStr = new JLabel("telephone number:");
        teleStr.setBounds(100, 336, 127, 20);
        frame.add(teleStr);

        JTextField nameTF = new JTextField();
        nameTF.setBounds(257, 61, 200, 20);
        frame.add(nameTF);

        JTextField accountTF = new JTextField();
        accountTF.setBounds(257, 116, 200, 20);
        frame.add(accountTF);

        JPasswordField passwordTF = new JPasswordField();
        passwordTF.setBounds(257, 171, 200, 20);
        frame.add(passwordTF);

        JPasswordField confirmPasswordTF = new JPasswordField();
        confirmPasswordTF.setBounds(257, 226, 200, 20);
        frame.add(confirmPasswordTF);

        JTextField emailTF = new JTextField();
        emailTF.setBounds(257, 281, 200, 20);
        frame.add(emailTF);

        JTextField telephoneTF = new JTextField();
        telephoneTF.setBounds(257, 336, 200, 20);
        frame.add(telephoneTF);

        JButton buttonregister = new JButton("register");
        buttonregister.setBounds(233, 486, 120, 20);
        frame.add(buttonregister);

        buttonregister.addActionListener((ActionEvent e) -> {
            customerDao = new CustomerDao();
            Customer c = new Customer();
            c.setName(nameTF.getText());
            c.setAccount(accountTF.getText());
            c.setPassword(String.valueOf(passwordTF.getPassword()));
            c.setEmail(emailTF.getText());
            c.setTelephone(telephoneTF.getText());
            try {
                if (judgeRegister(accountTF.getText(), String.valueOf(passwordTF.getPassword()), String.valueOf(confirmPasswordTF.getPassword()))) {
                    if (!customerDao.checkAccount(accountTF.getText())) {
                        if (customerDao.insert(c)) {
                            new RegisterResultPanel();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, " The account has existed!",
                                " The account has existed! ", JOptionPane.ERROR_MESSAGE);
                        new RegisterPanel();
                    }
                } else {
                }
            } catch (SQLException | ClassNotFoundException ex) {
            }
            frame.removeNotify();
        });

        JCheckBox checkBox = new JCheckBox("I have read and accpeted the instructions");
        checkBox.setBounds(100, 438, 366, 20);
        frame.add(checkBox);
    }

    public boolean judgeRegister(String account, String password, String confirmPassword) throws SQLException, ClassNotFoundException {
        if (account.equals("")) {
            JOptionPane.showMessageDialog(null, " Account cannot be empty! ",
                    "Account", JOptionPane.ERROR_MESSAGE);
            new RegisterPanel();
            return false;
        }

        if (password.equals("")) {
            JOptionPane.showMessageDialog(null, "Password cannot be empty!",
                    "Password is empty", JOptionPane.ERROR_MESSAGE);
            new RegisterPanel();
            return false;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, " The two passwords are inconsistent! ",
                    " The password is inconsistent ", JOptionPane.ERROR_MESSAGE);
            new RegisterPanel();
            return false;
        }
        return true;
    }
}
