import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class pay_manage extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pay_manage frame = new pay_manage();
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
	public pay_manage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("수납 정보 추가하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment pay = new payment();
				pay.setVisible(true);
			}
		});
		btnNewButton.setBounds(145, 636, 137, 67);
		contentPane.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(36, 173, 373, 453);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("2022년 7월 납부");
		lblNewLabel.setBounds(36, 52, 174, 53);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("전체");
		btnNewButton_1.setBounds(36, 140, 97, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("납부완료");
		btnNewButton_1_1.setBounds(171, 140, 97, 23);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("미납자");
		btnNewButton_1_1_1.setBounds(291, 140, 97, 23);
		contentPane.add(btnNewButton_1_1_1);
	}

}
