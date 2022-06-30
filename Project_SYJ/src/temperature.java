import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class temperature extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temperature frame = new temperature();
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
	public temperature() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(temperature.class.getResource("/img/\uC571\uC544\uC774\uCF58.png")));
		setTitle("\uC624! \uCD9C\uC11D - \uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNormal = new JButton("\uC815\uC0C1 \uCCB4\uC628");
		btnNormal.setForeground(new Color(255, 255, 255));
		btnNormal.setFont(new Font("배달의민족 주아", Font.BOLD, 45));
		btnNormal.setBackground(new Color(153, 204, 102));
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNormal.setBounds(43, 345, 368, 175);
		contentPane.add(btnNormal);
		
		JButton btnStandBy = new JButton("\uBC1C\uC5F4 \uB300\uAE30");
		btnStandBy.setForeground(new Color(255, 255, 255));
		btnStandBy.setFont(new Font("배달의민족 주아", Font.BOLD, 26));
		btnStandBy.setBackground(new Color(255, 228, 149));
		btnStandBy.setBounds(43, 530, 181, 148);
		contentPane.add(btnStandBy);
		
		JButton btnNewButton = new JButton("\uBC1C\uC5F4 \uADC0\uAC00");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.setFont(new Font("배달의민족 주아", Font.BOLD, 26));
		btnNewButton.setBounds(230, 530, 181, 148);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 103, 450, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(100, 149, 237));
		separator_1.setBounds(0, 195, 450, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("\uCCB4\uC628 \uCE21\uC815");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 45));
		lblNewLabel.setBounds(43, 127, 362, 56);
		contentPane.add(lblNewLabel);
		
		JLabel currentStatus = new JLabel("\uD64D\uAE38\uB3D9\uB2D8 \r\n\uC815\uC0C1\uCCB4\uC628\uC785\uB2C8\uB2E4.");
		currentStatus.setFont(new Font("배달의민족 주아", Font.PLAIN, 24));
		currentStatus.setHorizontalAlignment(SwingConstants.CENTER);
		currentStatus.setOpaque(true);
		currentStatus.setBackground(new Color(255, 255, 240));
		currentStatus.setBounds(0, 219, 450, 89);
		contentPane.add(currentStatus);
		
		JButton backBtn = new JButton("<");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 Main main =	new Main(); //메인화면 호출
					main.setVisible(true);
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		backBtn.setBackground(new Color(204, 204, 255));
		backBtn.setBounds(394, 0, 56, 36);
		contentPane.add(backBtn);
	}
}
