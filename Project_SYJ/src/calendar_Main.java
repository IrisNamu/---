import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;

@SuppressWarnings("serial")
public class calendar_Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calendar_Main frame = new calendar_Main();
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
	public calendar_Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(calendar_Main.class.getResource("/img/\uC571\uC544\uC774\uCF58.png")));
		setTitle("\uC624! \uCD9C\uC11D \u2013 \uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel attendance_menu = new JPanel();
		attendance_menu.setBounds(0, 0, 466, 713);
		contentPane.add(attendance_menu);
		attendance_menu.setLayout(null);
		
		JPanel Menubar = new JPanel();
		Menubar.setBounds(0, 0, 454, 64);
		Menubar.setBackground(new Color(19, 25, 53));
		attendance_menu.add(Menubar);
		Menubar.setLayout(null);
		
		JButton attendanceMenu = new JButton("");
		attendanceMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 attendance_Main attendance = new attendance_Main(); //홈화면 호출
				 attendance.setVisible(true);
			}
		});
		attendanceMenu.setBounds(0, 0, 87, 64);
		Menubar.add(attendanceMenu);
		attendanceMenu.setBackground(new Color(19, 25, 53));
		attendanceMenu.setIcon(new ImageIcon(calendar_Main.class.getResource("/img/\uCD9C\uC11D\uBA54\uB274\uBC14.png")));

		JButton manageStudent_Menu = new JButton("");
		manageStudent_Menu.setIcon(new ImageIcon(calendar_Main.class.getResource("/img/\uC6D0\uC0DD\uAD00\uB9AC\uBA54\uB274\uBC14.png")));
		manageStudent_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				 management_Student manage = new management_Student(); //홈화면 호출
					manage.setVisible(true);
			}
		});
		manageStudent_Menu.setBackground(new Color(19, 25, 53));
		manageStudent_Menu.setBounds(85, 0, 87, 64);
		Menubar.add(manageStudent_Menu);
		
		JButton calendar_Menu = new JButton("");
		calendar_Menu.setIcon(new ImageIcon(calendar_Main.class.getResource("/img/\uB2EC\uB825\uC120\uD0DD.png")));
		calendar_Menu.setBackground(new Color(19, 25, 53));
		calendar_Menu.setBounds(171, 0, 87, 64);
		Menubar.add(calendar_Menu);
		
		JButton statistics_Menu = new JButton("");
		statistics_Menu.setIcon(new ImageIcon(calendar_Main.class.getResource("/img/\uD1B5\uACC4\uBA54\uB274\uBC14.png")));
		statistics_Menu.setBackground(new Color(19, 25, 53));
		statistics_Menu.setBounds(256, 0, 87, 64);
		Menubar.add(statistics_Menu);
		
		JButton birthday_Menu = new JButton("");
		birthday_Menu.setIcon(new ImageIcon(calendar_Main.class.getResource("/img/\uC0DD\uC77C\uBA54\uB274\uBC14.png")));
		birthday_Menu.setBackground(new Color(19, 25, 53));
		birthday_Menu.setBounds(340, 0, 87, 64);
		Menubar.add(birthday_Menu);
		
		JCalendar calendar = new JCalendar();
		calendar.getYearChooser().getSpinner().setBounds(0, 0, 111, 21);
		calendar.getDayChooser().setBackground(new Color(204, 204, 255));
		calendar.setBounds(0, 74, 454, 629);
		attendance_menu.add(calendar);
		calendar.getYearChooser().setLayout(null);
		
	}
}
