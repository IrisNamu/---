import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JLayeredPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Home extends JFrame {


	private JPasswordField idField;
	private JPasswordField passwordField;
	private JTextField copyright;
	private JButton btnlJoin, more;
	private JLabel checking_id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		setTitle("\uC624! \uCD9C\uC11D (\uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C - \uAD50\uC0AC\uC6A9) ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/img/\uC571\uC544\uC774\uCF58.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		getContentPane().setLayout(null);

		idField = new JPasswordField();
		idField.setBackground(new Color(64, 64, 64));
		idField.setHorizontalAlignment(SwingConstants.LEFT);
		idField.setForeground(Color.WHITE);
		idField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		idField.setBounds(78, 518, 207, 21);
		getContentPane().add(idField);

		JButton btnLogin = new JButton("\uB85C \uADF8 \uC778");
		btnLogin.setBackground(new Color(216, 191, 216));
		btnLogin.setForeground(Color.BLACK);
		btnLogin.setFont(new Font("배달의민족 주아", Font.PLAIN, 19));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(297, 518, 97, 52);
		getContentPane().add(btnLogin);

		passwordField = new JPasswordField();
		passwordField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setForeground(Color.WHITE);
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBounds(78, 549, 207, 21);
		getContentPane().add(passwordField);

		btnlJoin = new JButton("\uD68C\uC6D0\uAC00\uC785 \uD558\uAE30");
		btnlJoin.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		btnlJoin.setBackground(new Color(204, 204, 255));
		btnlJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnlJoin.setBounds(137, 628, 170, 31);
		getContentPane().add(btnlJoin);

		more = new JButton("\uC790\uC138\uD788...");
		more.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
		more.setBackground(new Color(204, 204, 255));
		more.setBounds(354, 686, 84, 23);
		getContentPane().add(more);

		copyright = new JTextField();
		copyright.setHorizontalAlignment(SwingConstants.CENTER);
		copyright.setBackground(new Color(204, 204, 255));
		copyright.setText("  Copyright 2022.\uC1A1\uC720\uC9C4 All rights reserved.");
		copyright.setBounds(0, 682, 450, 31);
		getContentPane().add(copyright);
		copyright.setColumns(10);
		
		checking_id = new JLabel("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638\uB97C \uB2E4\uC2DC \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		checking_id.setForeground(new Color(255, 69, 0));
		checking_id.setHorizontalAlignment(SwingConstants.CENTER);
		checking_id.setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		checking_id.setOpaque(true); 
		checking_id.setBackground(new Color(250, 250, 210));
		checking_id.setBounds(78, 580, 316, 23);
		getContentPane().add(checking_id);
		
				JLabel backgroud = new JLabel("");
				backgroud.setIcon(new ImageIcon(Home.class.getResource("/img/\uBA54\uC778\uB85C\uADF8\uC778.png")));
				backgroud.setBounds(0, 0, 450, 713);
				getContentPane().add(backgroud);
	}
}
