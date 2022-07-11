import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class attendance_alert_page extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendance_alert_page frame = new attendance_alert_page();
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
	public attendance_alert_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 347, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("등원");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(108, 55, 113, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("결석");
		btnNewButton_2.setBounds(199, 107, 97, 36);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setText("(선택사항) 결석사유");
		textField.setBounds(42, 108, 145, 35);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
