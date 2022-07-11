import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class payment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField pay_amount;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment();
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
	public payment() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setText("이름을 입력하세요.");
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
		textField.setColumns(10);
		textField.setBounds(24, 224, 165, 34);
		contentPane.add(textField);

		JButton search = new JButton("검색");
		search.setFont(new Font("배달의민족 주아", Font.PLAIN, 16));
		search.setBackground(new Color(176, 196, 222));
		search.setBounds(201, 224, 66, 34);
		contentPane.add(search);

		pay_amount = new JTextField();
		pay_amount.setText("수납금액");
		pay_amount.setBounds(90, 346, 224, 66);
		contentPane.add(pay_amount);
		pay_amount.setColumns(10);

		JButton btnNewButton = new JButton("1,000");
		btnNewButton.setBounds(348, 466, 97, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("10,000");
		btnNewButton_1.setBounds(239, 466, 97, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("100,000");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(24, 466, 97, 23);
		contentPane.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("50,000");
		btnNewButton_1_1_1.setBounds(138, 466, 97, 23);
		contentPane.add(btnNewButton_1_1_1);

		textField_2 = new JTextField();
		textField_2.setText("출석번호를 입력하세요.");
		textField_2.setForeground(Color.DARK_GRAY);
		textField_2.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBounds(149, 422, 165, 34);
		contentPane.add(textField_2);

		JButton btnNewButton_2 = new JButton("수납 정보 저장");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pay_amount.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "금액을 바르게 입력해주세요.", "수강 납부", JOptionPane.ERROR_MESSAGE);

				} else {
					int r = JOptionPane.showConfirmDialog(null, "님 20만원 납부처리 하시겠습니까?", "수강 납부 확인 메세지",
							JOptionPane.YES_NO_OPTION);

					if (r == JOptionPane.YES_OPTION) {
						JOptionPane.showMessageDialog(null, "님 수강납부 완료되었습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "취소되었습니다.");
					}
				}
			}
		});
		btnNewButton_2.setBounds(163, 501, 151, 39);
		contentPane.add(btnNewButton_2);

		JLabel lblNewLabel = new JLabel(" * 동명이인의 문제로 고유한 번호인 출석번호를 필수로 기입해주세요.");
		lblNewLabel.setBounds(24, 173, 399, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("* 출석번호를 검색하려면 학생 이름 혹은 보호자 이름을 입력해주세요!");
		lblNewLabel_1.setBounds(24, 199, 399, 15);
		contentPane.add(lblNewLabel_1);

		JButton backBtn = new JButton("<");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay_manage manage = new pay_manage();
				manage.setVisible(true);
				dispose();
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		backBtn.setBorderPainted(false);
		backBtn.setBackground(Color.GRAY);
		backBtn.setBounds(384, 0, 66, 58);
		contentPane.add(backBtn);

		JLabel title_bar = new JLabel("오! 출석 - 수강료 납부하기");
		title_bar.setOpaque(true);
		title_bar.setHorizontalAlignment(SwingConstants.CENTER);
		title_bar.setForeground(Color.WHITE);
		title_bar.setFont(new Font("배달의민족 주아", Font.PLAIN, 23));
		title_bar.setBackground(SystemColor.activeCaption);
		title_bar.setBounds(0, 0, 450, 58);
		contentPane.add(title_bar);
	}

}
