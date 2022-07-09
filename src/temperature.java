import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

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
		setTitle("\uC624! \uCD9C\uC11D - \uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 368);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNormal = new JButton("\uC815\uC0C1 \uCCB4\uC628");
		btnNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNormal.setForeground(new Color(255, 255, 255));
		btnNormal.setFont(new Font("배달의민족 주아", Font.BOLD, 33));
		btnNormal.setBackground(new Color(153, 204, 102));
		btnNormal.setBounds(22, 118, 184, 184);
		contentPane.add(btnNormal);

		JButton btnStandBy = new JButton("\uBC1C\uC5F4 \uB300\uAE30");
		btnStandBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnStandBy.setForeground(new Color(255, 255, 255));
		btnStandBy.setFont(new Font("배달의민족 주아", Font.BOLD, 32));
		btnStandBy.setBackground(new Color(255, 228, 149));
		btnStandBy.setBounds(228, 118, 199, 87);
		contentPane.add(btnStandBy);

		JButton btnNewButton = new JButton("\uBC1C\uC5F4 \uADC0\uAC00");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 204, 204));
		btnNewButton.setFont(new Font("배달의민족 주아", Font.BOLD, 32));
		btnNewButton.setBounds(228, 215, 199, 87);
		contentPane.add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 23, 450, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(100, 149, 237));
		separator_1.setBounds(0, 90, 450, 2);
		contentPane.add(separator_1);

		JLabel title_tem = new JLabel("\uCCB4\uC628 \uCE21\uC815");
		title_tem.setHorizontalAlignment(SwingConstants.CENTER);
		title_tem.setFont(new Font("배달의민족 주아", Font.BOLD, 36));
		title_tem.setBounds(0, 35, 450, 45);
		contentPane.add(title_tem);
	}
}