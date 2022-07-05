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

@SuppressWarnings("serial")
public class management_Student extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					management_Student frame = new management_Student();
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
	public management_Student() {
		setTitle("오!출석");
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
		Menubar.setBackground(new Color(19, 25, 53));
		Menubar.setBounds(0, 0, 454, 64);
		attendance_menu.add(Menubar);
		Menubar.setLayout(null);
		
		JButton attendanceMenu = new JButton("");
		attendanceMenu.setIcon(new ImageIcon(management_Student.class.getResource("/img/attendance_menu.png")));
		attendanceMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				attendance_Main attendance = new attendance_Main(); //È¨È­¸é È£Ãâ
				attendance.setVisible(true);
			}
		});
		attendanceMenu.setBounds(0, 0, 87, 64);
		Menubar.add(attendanceMenu);
		attendanceMenu.setBackground(new Color(19, 25, 53));

		JButton manageStudent_Menu = new JButton("");
		manageStudent_Menu.setIcon(new ImageIcon(management_Student.class.getResource("/img/click_stu_menu.png")));
		manageStudent_Menu.setBackground(new Color(19, 25, 53));
		manageStudent_Menu.setBounds(85, 0, 87, 64);
		Menubar.add(manageStudent_Menu);
		
		
		JButton statistics_Menu = new JButton("");
		statistics_Menu.setBackground(new Color(19, 25, 53));
		statistics_Menu.setBounds(256, 0, 87, 64);
		Menubar.add(statistics_Menu);
		
		JButton birthday_Menu = new JButton("");
		birthday_Menu.setBackground(new Color(19, 25, 53));
		birthday_Menu.setBounds(340, 0, 87, 64);
		Menubar.add(birthday_Menu);
		
		JButton statistics_Menu_1 = new JButton("");
		statistics_Menu_1.setIcon(new ImageIcon(management_Student.class.getResource("/img/cal_menu.png")));
		statistics_Menu_1.setBackground(new Color(19, 25, 53));
		statistics_Menu_1.setBounds(170, 0, 87, 64);
		Menubar.add(statistics_Menu_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 74, 10, 10);
		attendance_menu.add(panel);
		
	}
}