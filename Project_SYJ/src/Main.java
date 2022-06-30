import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("\uC624! \uCD9C\uC11D - \uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C ");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/img/\uC571\uC544\uC774\uCF58.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 450, 66);
		menuBar.setBackground(new Color(19, 25, 53));
		contentPane.add(menuBar);

		JMenu attendanceMenu = new JMenu("");
		attendanceMenu.setForeground(new Color(255, 255, 255));
		attendanceMenu.setHorizontalAlignment(SwingConstants.CENTER);
		attendanceMenu.setIcon(new ImageIcon(Main.class.getResource("/img/\uCD9C\uC11D\uBA54\uB274\uBC14.png")));
		menuBar.add(attendanceMenu);

		JMenu studentMenu = new JMenu("");
		studentMenu.setIcon(new ImageIcon(Main.class.getResource("/img/\uC6D0\uC0DD\uAD00\uB9AC\uBA54\uB274\uBC14.png")));
		menuBar.add(studentMenu);

		JMenu calendarMenu = new JMenu("");
		calendarMenu.setIcon(new ImageIcon(Main.class.getResource("/img/\uB2EC\uB825\uBA54\uB274\uBC14.png")));
		menuBar.add(calendarMenu);

		JMenu statisticsMenu = new JMenu("");
		statisticsMenu.setIcon(new ImageIcon(Main.class.getResource("/img/\uD1B5\uACC4\uBA54\uB274\uBC14.png")));
		menuBar.add(statisticsMenu);

		JMenu birthdayMenu = new JMenu("");
		birthdayMenu.setIcon(new ImageIcon(Main.class.getResource("/img/\uC0DD\uC77C\uBA54\uB274\uBC14.png")));
		menuBar.add(birthdayMenu);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 65, 450, 128);
		contentPane.add(panel);
	}
}
