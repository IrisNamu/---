import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Statistics_manage extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Statistics_manage frame = new Statistics_manage();
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
	public Statistics_manage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home_Login.class.getResource("/img/app_icon.png")));
		setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		setTitle("오! 출석 - 학생관리시스템 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel Menubar = new JPanel();
		Menubar.setBackground(new Color(19, 25, 53));
		Menubar.setBounds(0, 0, 450, 70);
		contentPane.add(Menubar);
		Menubar.setLayout(null);

		JButton attendanceMenu = new JButton("");
		attendanceMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				attendance_Main att = new attendance_Main();
				dispose();
				att.setVisible(true);
			}
		});
		attendanceMenu.setIcon(new ImageIcon(management_Student.class.getResource("/img/att_menu.png")));
		attendanceMenu.setBounds(0, 1, 90, 70);
		Menubar.add(attendanceMenu);
		attendanceMenu.setBackground(new Color(19, 25, 53));

		JButton manageStudent_Menu = new JButton("");
		manageStudent_Menu.setIcon(new ImageIcon(Statistics_manage.class.getResource("/img/manage_menu.png")));
		manageStudent_Menu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				dispose();
				management_Student manage = new management_Student(); // 홈화면 호출
				manage.setVisible(true);
			}
		});
		manageStudent_Menu.setBackground(new Color(19, 25, 53));
		manageStudent_Menu.setBounds(91, 0, 90, 70);
		Menubar.add(manageStudent_Menu);

		JButton directly_att = new JButton("");
		directly_att.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AttendanceNumber num = new AttendanceNumber();
				num.setVisible(true);
			}
		});
		directly_att.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/directly_att.png")));
		directly_att.setBackground(new Color(19, 25, 53));
		directly_att.setBounds(182, 0, 90, 70);
		Menubar.add(directly_att);

		JButton pay_menubar = new JButton("");
		pay_menubar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				pay_manage pay = new pay_manage();
				pay.setVisible(true);
			}
		});
		pay_menubar.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/pay_menu.png")));
		pay_menubar.setBackground(new Color(19, 25, 53));
		pay_menubar.setBounds(273, 0, 90, 70);
		Menubar.add(pay_menubar);

		JButton statistics_menubar = new JButton("");
		statistics_menubar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Statistics_manage sta = new Statistics_manage();
				dispose();
				sta.setVisible(true);
			}
		});
		statistics_menubar.setIcon(new ImageIcon(Statistics_manage.class.getResource("/img/click_statistics.png")));
		statistics_menubar.setBackground(new Color(19, 25, 53));
		statistics_menubar.setBounds(360, 0, 90, 70);
		Menubar.add(statistics_menubar);
		
		JLabel new_ = new JLabel("월별 신규생");
		new_.setBounds(37, 234, 87, 29);
		contentPane.add(new_);
		
		JButton new_btn = new JButton("자세히보기");
		new_btn.setBounds(198, 237, 97, 23);
		contentPane.add(new_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 298, 378, 78);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel att = new JLabel("출석관련");
		att.setBounds(37, 131, 87, 29);
		contentPane.add(att);
		
		JButton att_btn = new JButton("자세히보기");
		att_btn.setBounds(198, 134, 97, 23);
		contentPane.add(att_btn);
		
		JLabel income = new JLabel("월별 수입");
		income.setBounds(37, 450, 87, 29);
		contentPane.add(income);
		
		JButton income_btn = new JButton("자세히보기");
		income_btn.setBounds(198, 453, 97, 23);
		contentPane.add(income_btn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(37, 518, 379, 94);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);

	}
}
