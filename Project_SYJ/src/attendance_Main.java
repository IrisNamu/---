import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class attendance_Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					attendance_Main frame = new attendance_Main();
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
	public attendance_Main() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(attendance_Main.class.getResource("/img/\uC571\uC544\uC774\uCF58.png")));
		setTitle("\uC624! \uCD9C\uC11D \u2013 \uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel who_early_leave = new JPanel();
		who_early_leave.setBackground(Color.WHITE);
		who_early_leave.setBounds(0, 0, 466, 713);
		contentPane.add(who_early_leave);
		who_early_leave.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 204, 204));
		separator.setBackground(new Color(255, 204, 204));
		separator.setBounds(0, 200, 454, -5);
		who_early_leave.add(separator);

		JPanel Menubar = new JPanel();
		Menubar.setBackground(new Color(19, 25, 53));
		Menubar.setBounds(0, 0, 454, 64);
		who_early_leave.add(Menubar);
		Menubar.setLayout(null);

		JButton attendanceMenu = new JButton("");
		attendanceMenu.setBounds(0, 0, 87, 64);
		Menubar.add(attendanceMenu);
		attendanceMenu.setBackground(new Color(19, 25, 53));
		attendanceMenu.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/\uCD9C\uC11D\uC120\uD0DD.png")));

		JButton manageStudent_Menu = new JButton("");
		manageStudent_Menu.setIcon(new ImageIcon(
				attendance_Main.class.getResource("/img/\uC6D0\uC0DD\uAD00\uB9AC\uBA54\uB274\uBC14.png")));
		manageStudent_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				management_Student manage = new management_Student(); // »®»≠∏È »£√‚
				manage.setVisible(true);
			}
		});
		manageStudent_Menu.setBackground(new Color(19, 25, 53));
		manageStudent_Menu.setBounds(85, 0, 87, 64);
		Menubar.add(manageStudent_Menu);

		JButton calendar_Menu = new JButton("");
		calendar_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				calendar_Main cal = new calendar_Main();
				cal.setVisible(true);
				
			}
		});
		calendar_Menu
				.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/\uB2EC\uB825\uBA54\uB274\uBC14.png")));
		calendar_Menu.setBackground(new Color(19, 25, 53));
		calendar_Menu.setBounds(171, 0, 87, 64);
		Menubar.add(calendar_Menu);

		JButton statistics_Menu = new JButton("");
		statistics_Menu
				.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/\uD1B5\uACC4\uBA54\uB274\uBC14.png")));
		statistics_Menu.setBackground(new Color(19, 25, 53));
		statistics_Menu.setBounds(256, 0, 87, 64);
		Menubar.add(statistics_Menu);

		JButton birthday_Menu = new JButton("");
		birthday_Menu
				.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/\uC0DD\uC77C\uBA54\uB274\uBC14.png")));
		birthday_Menu.setBackground(new Color(19, 25, 53));
		birthday_Menu.setBounds(340, 0, 87, 64);
		Menubar.add(birthday_Menu);

		JPanel chooseDateCheck = new JPanel();
		chooseDateCheck.setBackground(new Color(255, 224, 172));
		chooseDateCheck.setBounds(0, 67, 454, 150);
		who_early_leave.add(chooseDateCheck);
		chooseDateCheck.setLayout(null);

		JButton all_student = new JButton("\uC804\uCCB4");
		all_student.setBackground(Color.DARK_GRAY);
		all_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		all_student.setForeground(Color.WHITE);
		all_student.setFont(new Font("πË¥ﬁ¿«πŒ¡∑ ¡÷æ∆", Font.PLAIN, 18));
		all_student.setBounds(37, 85, 65, 38);
		chooseDateCheck.add(all_student);

		JButton who_attendance = new JButton("\uB4F1\uC6D0");
		who_attendance.setBackground(new Color(51, 153, 204));
		who_attendance.setForeground(new Color(255, 255, 255));
		who_attendance.setFont(new Font("πË¥ﬁ¿«πŒ¡∑ ¡÷æ∆", Font.PLAIN, 18));
		who_attendance.setBounds(111, 85, 65, 38);
		chooseDateCheck.add(who_attendance);

		JButton who_absent = new JButton("\uACB0\uC11D");
		who_absent.setBackground(new Color(255, 0, 0));
		who_absent.setForeground(new Color(255, 255, 255));
		who_absent.setFont(new Font("πË¥ﬁ¿«πŒ¡∑ ¡÷æ∆", Font.PLAIN, 20));
		who_absent.setBounds(342, 84, 65, 38);
		chooseDateCheck.add(who_absent);

		JButton who_Did_Not_attend = new JButton("\uBBF8\uB4F1");
		who_Did_Not_attend.setBackground(new Color(51, 204, 204));
		who_Did_Not_attend.setForeground(new Color(255, 255, 255));
		who_Did_Not_attend.setFont(new Font("πË¥ﬁ¿«πŒ¡∑ ¡÷æ∆", Font.PLAIN, 18));
		who_Did_Not_attend.setBounds(188, 85, 65, 38);
		chooseDateCheck.add(who_Did_Not_attend);

		JButton btnNewButton_3_1 = new JButton("\uC870\uD1F4");
		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.setFont(new Font("πË¥ﬁ¿«πŒ¡∑ ¡÷æ∆", Font.PLAIN, 18));
		btnNewButton_3_1.setBackground(new Color(255, 102, 0));
		btnNewButton_3_1.setBounds(265, 85, 65, 38);
		chooseDateCheck.add(btnNewButton_3_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 145, 454, 33);
		chooseDateCheck.add(separator_1);
		separator_1.setBackground(new Color(255, 204, 204));
		
		JPanel cal_panel = new JPanel();
		cal_panel.setBackground(new Color(255, 224, 172));
		cal_panel.setBounds(12, 10, 430, 61);
		chooseDateCheck.add(cal_panel);
		cal_panel.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(255, 255, 204));
		dateChooser.getCalendarButton().setBackground(new Color(104, 134, 197));
		dateChooser.setDateFormatString("                  MM\uC6D4 dd\uC77C HH\uC2DC mm\uBD84 (Y\uB144)\r\n");
		dateChooser.setBounds(66, 10, 300, 51);
		cal_panel.add(dateChooser);

		JPanel panel = new JPanel();
		panel.setBounds(0, 219, 454, 39);
		who_early_leave.add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 478, 39);
		menuBar.setBackground(Color.WHITE);
		panel.add(menuBar);

		JMenu sort_nenubar = new JMenu("  \uC815\uB82C\uBC29\uBC95      \u2228  ");
		sort_nenubar.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		sort_nenubar.setBackground(new Color(255, 255, 204));
		sort_nenubar.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(sort_nenubar);

		JRadioButtonMenuItem name_order = new JRadioButtonMenuItem("\uC774\uB984\uC21C");
		name_order.setBackground(new Color(255, 255, 255));
		sort_nenubar.add(name_order);

		JRadioButtonMenuItem reverse_name = new JRadioButtonMenuItem("\uC774\uB984\uC5ED\uC21C");
		reverse_name.setBackground(new Color(255, 255, 255));
		sort_nenubar.add(reverse_name);

		JRadioButtonMenuItem lower_grade = new JRadioButtonMenuItem("\uC800\uD559\uB144\uC21C");
		lower_grade.setBackground(new Color(255, 255, 255));
		sort_nenubar.add(lower_grade);

		JRadioButtonMenuItem upper_grade = new JRadioButtonMenuItem("\uACE0\uD559\uB144\uC21C");
		upper_grade.setBackground(new Color(255, 255, 255));
		sort_nenubar.add(upper_grade);

		JMenu day_menubar = new JMenu("   \uC694\uC77C      \u2228  ");
		day_menubar.setHorizontalAlignment(SwingConstants.CENTER);
		day_menubar.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		day_menubar.setBackground(new Color(255, 255, 204));
		menuBar.add(day_menubar);

		JRadioButtonMenuItem mon = new JRadioButtonMenuItem("\uC6D4\uC694\uC77C");
		mon.setBackground(Color.WHITE);
		day_menubar.add(mon);

		JRadioButtonMenuItem tue = new JRadioButtonMenuItem("\uD654\uC694\uC77C");
		tue.setBackground(Color.WHITE);
		day_menubar.add(tue);

		JRadioButtonMenuItem wed = new JRadioButtonMenuItem("\uC218\uC694\uC77C");
		wed.setBackground(Color.WHITE);
		day_menubar.add(wed);

		JRadioButtonMenuItem thurs = new JRadioButtonMenuItem("\uBAA9\uC694\uC77C");
		thurs.setBackground(Color.WHITE);
		day_menubar.add(thurs);

		JRadioButtonMenuItem fri = new JRadioButtonMenuItem("\uAE08\uC694\uC77C");
		fri.setBackground(Color.WHITE);
		day_menubar.add(fri);

		JRadioButtonMenuItem sat = new JRadioButtonMenuItem("\uD1A0\uC694\uC77C");
		sat.setBackground(Color.WHITE);
		day_menubar.add(sat);

		JRadioButtonMenuItem special_lecture = new JRadioButtonMenuItem("\uD2B9\uAC15");
		special_lecture.setBackground(Color.WHITE);
		day_menubar.add(special_lecture);

		JMenu class_menubar = new JMenu("   \uBC18\uC804\uCCB4        \u2228  ");
		class_menubar.setHorizontalAlignment(SwingConstants.CENTER);
		class_menubar.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 16));
		class_menubar.setBackground(new Color(255, 255, 204));
		menuBar.add(class_menubar);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(new Color(255, 255, 255));
		scrollBar.setForeground(new Color(255, 204, 102));
		scrollBar.setBounds(427, 257, 23, 456);
		who_early_leave.add(scrollBar);
		
		JPanel panel_who_attendance = new JPanel();
		panel_who_attendance.setBounds(0, 257, 454, 456);
		who_early_leave.add(panel_who_attendance);


	}
}
