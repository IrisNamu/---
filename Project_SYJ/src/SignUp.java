import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JList;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnSignUp;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/img/\uC571\uC544\uC774\uCF58.png")));
		setTitle("\uC624! \uCD9C\uC11D (\uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C - \uAD50\uC0AC\uC6A9) ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 713);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(12, 539, 356, 38);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(12, 202, 356, 38);
		contentPane.add(passwordField_1);
		
		textField = new JTextField();
		textField.setBounds(12, 317, 356, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 317, 356, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(12, 419, 356, 38);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		btnSignUp = new JButton("\uD68C\uC6D0\uAC00\uC785 \uD558\uAE30");
		btnSignUp.setFont(new Font("πË¥ﬁ¿«πŒ¡∑ ¡÷æ∆", Font.PLAIN, 19));
		btnSignUp.setBackground(new Color(255, 245, 238));
		btnSignUp.setForeground(new Color(0, 0, 0));
		btnSignUp.setBounds(137, 601, 138, 50);
		contentPane.add(btnSignUp);
		
		JLabel passwordCheck = new JLabel("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694.");
		passwordCheck.setFont(new Font("±º∏≤", Font.BOLD, 12));
		passwordCheck.setForeground(new Color(255, 69, 0));
		passwordCheck.setBackground(new Color(192, 192, 192));
		passwordCheck.setHorizontalAlignment(SwingConstants.LEFT);
		passwordCheck.setBounds(12, 467, 356, 15);
		contentPane.add(passwordCheck);
		
		separator = new JSeparator();
		separator.setForeground(new Color(160, 160, 160));
		separator.setBackground(new Color(255, 140, 0));
		separator.setBounds(0, 101, 434, 29);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-12, -7, 446, 684);
		lblNewLabel.setIcon(new ImageIcon(SignUp.class.getResource("/img/\uD68C\uC6D0\uAC00\uC785_\uB85C\uADF8\uC778.png")));
		contentPane.add(lblNewLabel);
	}
}
