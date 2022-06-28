import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JComboBox;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(68,85,143));
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
	}
}
