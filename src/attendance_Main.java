import java.awt.EventQueue;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import database.StudentDAO;
import database.StudentVo;

import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class attendance_Main extends JFrame {
	private StudentDAO dao;
	private JPanel contentPane;
	private JTextField textField;
	private JTable table_stuList;
	private String day;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("sqlDate:" + sqlDate);
		System.out.println("utilDate:" + utilDate);

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
		dao = new StudentDAO();

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
		who_early_leave.setBounds(0, 0, 450, 257);
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
		attendanceMenu.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/click_atten_menu.png")));
		attendanceMenu.setBounds(0, 0, 75, 64);
		Menubar.add(attendanceMenu);
		attendanceMenu.setBackground(new Color(19, 25, 53));

		JButton manageStudent_Menu = new JButton("");
		manageStudent_Menu.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/stu_menu.png")));
		manageStudent_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				management_Student manage = new management_Student(); // 홈화면 호출
				manage.setVisible(true);
			}
		});
		manageStudent_Menu.setBackground(new Color(19, 25, 53));
		manageStudent_Menu.setBounds(76, 0, 75, 64);
		Menubar.add(manageStudent_Menu);

		JButton cak_Menu = new JButton("");
		cak_Menu.setIcon(new ImageIcon(attendance_Main.class.getResource("/img/cal_menu.png")));
		cak_Menu.setBackground(new Color(19, 25, 53));
		cak_Menu.setBounds(152, 0, 75, 64);
		Menubar.add(cak_Menu);

		JButton statistics_Menu_1 = new JButton("");
		statistics_Menu_1.setBackground(new Color(19, 25, 53));
		statistics_Menu_1.setBounds(227, 0, 75, 64);
		Menubar.add(statistics_Menu_1);

		JButton statistics_Menu_2 = new JButton("");
		statistics_Menu_2.setBackground(new Color(19, 25, 53));
		statistics_Menu_2.setBounds(303, 0, 75, 64);
		Menubar.add(statistics_Menu_2);

		JButton statistics_Menu_2_1 = new JButton("");
		statistics_Menu_2_1.setBackground(new Color(19, 25, 53));
		statistics_Menu_2_1.setBounds(379, 0, 75, 64);
		Menubar.add(statistics_Menu_2_1);

		JPanel chooseDateCheck = new JPanel();
		chooseDateCheck.setBackground(new Color(255, 224, 172));
		chooseDateCheck.setBounds(0, 67, 454, 150);
		who_early_leave.add(chooseDateCheck);
		chooseDateCheck.setLayout(null);

		// 요일구하기
		Calendar cal = Calendar.getInstance();
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		String day = "";
		switch (dayOfWeek) {
		case 1:
			day = "일";
			break;
		case 2:
			day = "월";
			break;
		case 3:
			day = "화";
			break;
		case 4:
			day = "수";
			break;
		case 5:
			day = "목";
			break;
		case 6:
			day = "금";
			break;
		case 7:
			day = "토";
			break;
		}

		// 패널에 부착될 시간.
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat time = new SimpleDateFormat("HH시 mm분");

		// 날짜 시간 요일
		JLabel dateLab = new JLabel("date");
		dateLab.setBackground(Color.ORANGE);
		dateLab.setFont(new Font("배달의민족 주아", Font.PLAIN, 30));
		dateLab.setBounds(0, 22, 454, 45);
		chooseDateCheck.add(dateLab);
		dateLab.setHorizontalAlignment(SwingConstants.CENTER);
		dateLab.setText(date.format(d) + " " + day + "   " + time.format(d));

		JButton all_student = new JButton("\uC804\uCCB4");
		all_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 검색하면 테이블에 해당 검색결과 나타내기
				DefaultTableModel model = (DefaultTableModel) table_stuList.getModel(); 
				model.setRowCount(0);

				// 요일구하기
				Calendar cal = Calendar.getInstance();
				int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
				String day = "";
				switch (dayOfWeek) {
				case 1:
					day = "일";
					break;
				case 2:
					day = "월";
					break;
				case 3:
					day = "화";
					break;
				case 4:
					day = "수";
					break;
				case 5:
					day = "목";
					break;
				case 6:
					day = "금";
					break;
				case 7:
					day = "토";
					break;
				}
				
				StudentDAO dao = new StudentDAO();
				ArrayList<StudentVo> list = dao.who_come(day);

				for (StudentVo vo : list) {
					String[] data = { vo.getStuNumber(), vo.getStuName(), vo.getAge(), vo.getAttendance_info() };
					
					model.addRow(data);// 이걸 적어줘야 테이블에 추가가 된다.
				}

				table_stuList.setModel(model);
			}
		});
		all_student.setBackground(Color.DARK_GRAY);
		all_student.setForeground(Color.WHITE);
		all_student.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		all_student.setBounds(62, 85, 65, 38);
		chooseDateCheck.add(all_student);

		JButton who_attendance = new JButton("\uB4F1\uC6D0");
		who_attendance.setBackground(new Color(51, 153, 204));
		who_attendance.setForeground(new Color(255, 255, 255));
		who_attendance.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		who_attendance.setBounds(139, 85, 65, 38);
		chooseDateCheck.add(who_attendance);

		JButton who_absent = new JButton("\uACB0\uC11D");
		who_absent.setBackground(new Color(255, 0, 0));
		who_absent.setForeground(new Color(255, 255, 255));
		who_absent.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		who_absent.setBounds(293, 84, 65, 38);
		chooseDateCheck.add(who_absent);

		JButton who_Did_Not_attend = new JButton("\uBBF8\uB4F1");
		who_Did_Not_attend.setBackground(new Color(51, 204, 204));
		who_Did_Not_attend.setForeground(new Color(255, 255, 255));
		who_Did_Not_attend.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		who_Did_Not_attend.setBounds(216, 85, 65, 38);
		chooseDateCheck.add(who_Did_Not_attend);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 145, 454, 33);
		chooseDateCheck.add(separator_1);
		separator_1.setBackground(new Color(255, 204, 204));
		JButton add_student_btn = new JButton("+");
		chooseDateCheck.add(add_student_btn);
		add_student_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "학생 정보를 추가하시겠습니까?", "오!출석 - 학생 추가하기",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_OPTION) {
					addStudentPage addstudent = new addStudentPage(); // 홈화면 호출
					addstudent.setVisible(true);
				}
			}
		});
		add_student_btn.setBounds(383, 77, 59, 55);
		add_student_btn.setBackground(new Color(102, 153, 204));
		add_student_btn.setForeground(Color.WHITE);
		add_student_btn.setFont(new Font("굴림", Font.BOLD, 40));

		JPanel date_panel = new JPanel();
		date_panel.setBackground(new Color(255, 224, 172));
		date_panel.setBounds(12, 10, 430, 61);

		JPanel panel = new JPanel();
		panel.setBounds(0, 219, 454, 39);
		who_early_leave.add(panel);
		panel.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 232, 39);
		menuBar.setBackground(Color.WHITE);
		panel.add(menuBar);

		JMenu sort_nenubar = new JMenu("  정렬방법   ∨  ");
		sort_nenubar.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
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

		JMenu day_menubar = new JMenu("  요일    ∨  ");
		day_menubar.setHorizontalAlignment(SwingConstants.CENTER);
		day_menubar.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
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

		JRadioButtonMenuItem special_lecture = new JRadioButtonMenuItem("일요일");
		special_lecture.setBackground(Color.WHITE);
		day_menubar.add(special_lecture);

		textField = new JTextField();
		textField.setBounds(232, 0, 167, 37);
		panel.add(textField);
		textField.setFont(new Font("굴림", Font.BOLD, 15));
		textField.setForeground(Color.WHITE);
		textField.setBackground(new Color(248, 248, 255));
		textField.setText("직접 검색");
		textField.setColumns(10);
		JButton btnNewButton = new JButton("검색");
		btnNewButton.setBounds(397, 0, 57, 39);
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 717, 450, -460);
		contentPane.add(scrollPane);

		table_stuList = new JTable();
		table_stuList.setBounds(0, 706, 450, -451);
		contentPane.add(table_stuList);

		// DB연동 수강생 리스트 불러오기
		String[] header = new String[] { "출석번호", "이름", "나이", "등원여부" };
		String[][] data = dao.getStudent();
//		table_stuList = new JTable(data, header); // 배열 이용해서 테이블
		table_stuList = new JTable();
		table_stuList.setModel(new DefaultTableModel(data, header));
		scrollPane.setViewportView(table_stuList);

	}
}