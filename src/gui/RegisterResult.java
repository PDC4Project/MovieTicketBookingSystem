/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dell
 */
public class RegisterResult {
    private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterResult window = new RegisterResult();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

        
	public RegisterResult() {
		init();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void init() {
		frame = new JFrame();
		frame.setBounds(400, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		frame.getContentPane().setLayout(null);
		
		JLabel result = new JLabel("Register Successfully !");
		result.setFont(new Font("宋体", Font.PLAIN, 41));
		result.setBounds(77, 51, 215, 46);
		frame.getContentPane().add(result);
		
		JButton returnButton = new JButton("Return Login Panel!");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LoginPanel();
				frame.removeNotify();
				
				
			}
		});
		returnButton.setBounds(157, 153, 103, 33);
		frame.getContentPane().add(returnButton);
	}
}
