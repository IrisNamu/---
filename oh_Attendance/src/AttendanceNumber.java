import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class AttendanceNumber extends JFrame {

	private JPanel contentPane;
	private JTextField InputNumber;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AttendanceNumber frame = new AttendanceNumber();
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
	public AttendanceNumber() {
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		InputNumber = new JTextField();
		InputNumber.setHorizontalAlignment(SwingConstants.CENTER);
		InputNumber.setFont(new Font("배달의민족 주아", Font.PLAIN, 28));
		InputNumber.setBackground(new Color(255, 228, 149));
		InputNumber.setBounds(22, 222, 404, 72);
		contentPane.add(InputNumber);
		InputNumber.setColumns(20);

		JButton btn1 = new JButton("1");
		btn1.setBackground(new Color(255, 255, 240));
		btn1.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn1.setBounds(22, 353, 124, 80);
		contentPane.add(btn1);

		JButton btn2 = new JButton("2");
		btn2.setBackground(new Color(255, 255, 240));
		btn2.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn2.setBounds(163, 353, 124, 80);
		contentPane.add(btn2);

		JButton btn3 = new JButton("3");
		btn3.setBackground(new Color(255, 255, 240));
		btn3.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn3.setBounds(302, 353, 124, 80);
		contentPane.add(btn3);

		JButton btn4 = new JButton("4");
		btn4.setBackground(new Color(255, 255, 240));
		btn4.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn4.setBounds(22, 443, 124, 80);
		contentPane.add(btn4);

		JButton btn5 = new JButton("5");
		btn5.setBackground(new Color(255, 255, 240));
		btn5.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn5.setBounds(163, 443, 124, 80);
		contentPane.add(btn5);

		JButton btn6 = new JButton("6");
		btn6.setBackground(new Color(255, 255, 240));
		btn6.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn6.setBounds(302, 443, 124, 80);
		contentPane.add(btn6);

		JButton btn7 = new JButton("7");
		btn7.setBackground(new Color(255, 255, 240));
		btn7.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn7.setBounds(22, 533, 124, 80);
		contentPane.add(btn7);

		JButton btn8 = new JButton("8");
		btn8.setBackground(new Color(255, 255, 240));
		btn8.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn8.setBounds(163, 533, 124, 80);
		contentPane.add(btn8);

		JButton btn9 = new JButton("9");
		btn9.setBackground(new Color(255, 255, 240));
		btn9.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn9.setBounds(302, 533, 124, 80);
		contentPane.add(btn9);

		JButton btn0 = new JButton("0");
		btn0.setBackground(new Color(255, 255, 240));
		btn0.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btn0.setBounds(163, 623, 124, 80);
		contentPane.add(btn0);

		JButton btnC = new JButton("C");
		btnC.setBackground(new Color(255, 255, 240));
		btnC.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btnC.setBounds(22, 623, 124, 80);
		contentPane.add(btnC);

		JButton btnOk = new JButton("OK");
		btnOk.setBackground(new Color(255, 255, 240));
		btnOk.setFont(new Font("배달의민족 주아", Font.BOLD, 44));
		btnOk.setBounds(302, 623, 124, 80);
		contentPane.add(btnOk);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("");
		textField.setBackground(new Color(255, 239, 213));
		textField.setFont(new Font("배달의민족 주아", Font.PLAIN, 16));
		textField.setBounds(22, 305, 404, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel date_panel = new JPanel();
		date_panel.setBounds(22, 61, 404, 151);
		contentPane.add(date_panel);
		
		JButton backBtn = new JButton("<");
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		backBtn.setBackground(new Color(204, 204, 255));
		backBtn.setBounds(394, 0, 56, 34);
		contentPane.add(backBtn);
	}
}