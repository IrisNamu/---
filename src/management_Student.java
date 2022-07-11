import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import database.StudentDAO;
import database.StudentVo;

import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class management_Student extends JFrame {

	private JPanel contentPane;
	private JTextField search_field;
	private JTable table_stuList;
	private StudentDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		StudentDAO dao = new StudentDAO(); // 로드와 연결

		// 이름", "출석번호", "나이", "생년월일", "학교", "학년", "반"

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
		dao = new StudentDAO();

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
		attendance_menu.setBackground(SystemColor.inactiveCaption);
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
				attendance_Main attendance = new attendance_Main();
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

		// [총 수강생 몇 명인지 알려주는]
		new StudentDAO().getStudent();
		String[][] all = new StudentDAO().getStudent();
		System.out.println(all.length);

		search_field = new JTextField();
		search_field.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
		search_field.setForeground(Color.DARK_GRAY);
		search_field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (search_field.getText().equals(" 검색어를 입력하세요.")) {
					search_field.setText("");
					search_field.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (search_field.getText().equals("")) {
					search_field.setText(" 검색어를 입력하세요.");
					search_field.setForeground(new Color(153, 153, 153));
				}
			}
		});
		search_field.setText(" 검색어를 입력하세요.");
		search_field.setBounds(12, 194, 165, 34);
		attendance_menu.add(search_field);
		search_field.setColumns(10);

		// 전체 검색할 수 있는 기능
		JButton search = new JButton("검색");
		search.setFont(new Font("배달의민족 주아", Font.PLAIN, 16));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 검색하면 테이블에 해당 검색결과 나타내기
				DefaultTableModel model = (DefaultTableModel) table_stuList.getModel();
				model.setRowCount(0);

				String word = search_field.getText();
				System.out.println(word);
				if (word.length() < 1) {
					return;
				}
				StudentDAO dao = new StudentDAO();
				ArrayList<StudentVo> list = dao.search(word);

				for (StudentVo vo : list) {
					String[] data = { vo.getStuNumber(), vo.getStuName(), vo.getAge() };
					model.addRow(data);// 이걸 적어줘야 테이블에 추가가 된다.
				}

				table_stuList.setModel(model);

			}
		});
		search.setBounds(180, 194, 66, 34);
		search.setBackground(new Color(176, 196, 222));
		attendance_menu.add(search);

		JButton bigger_btn = new JButton("큰 화면 보기");
		bigger_btn.setForeground(new Color(255, 250, 250));
		bigger_btn.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
		bigger_btn.setBackground(new Color(25, 25, 112));
		bigger_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				big_manage big = new big_manage();
				big.setVisible(true);
				
			}
		});
		bigger_btn.setBounds(158, 668, 117, 35);
		attendance_menu.add(bigger_btn);

		// DB연동 수강생 리스트 불러오기
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 235, 429, 423);
		attendance_menu.add(scrollPane);

		String[] header = new String[] { "출석번호", "이름", "성별", "나이", "학교명", "학년", "반", "생년월일", "등원요일", "주소", "등록일",
				"학생 전화번호", "보호자1 성함", "보호자1 전화번호", "보호자2 성함", "보호자2 전화번호", "특이사항" };
		String[][] data = dao.getStudent();
		table_stuList = new JTable();
		table_stuList.setFont(new Font("굴림", Font.PLAIN, 13));
		table_stuList.setModel(new DefaultTableModel(data, header));
		scrollPane.setViewportView(table_stuList);
		table_stuList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// 테이블 높이 넓이 조정해주기
		table_stuList.setRowHeight(30);
		table_stuList.getColumn("출석번호").setPreferredWidth(60);
		table_stuList.getColumn("성별").setPreferredWidth(50);
		table_stuList.getColumn("나이").setPreferredWidth(50);
		table_stuList.getColumn("학년").setPreferredWidth(60);
		table_stuList.getColumn("반").setPreferredWidth(90);
		table_stuList.getColumn("생년월일").setPreferredWidth(100);
		table_stuList.getColumn("등원요일").setPreferredWidth(100);
		table_stuList.getColumn("주소").setPreferredWidth(180);
		table_stuList.getColumn("등록일").setPreferredWidth(100);
		table_stuList.getColumn("학생 전화번호").setPreferredWidth(150);
		table_stuList.getColumn("보호자1 성함").setPreferredWidth(90);
		table_stuList.getColumn("보호자1 전화번호").setPreferredWidth(150);
		table_stuList.getColumn("보호자2 성함").setPreferredWidth(90);
		table_stuList.getColumn("보호자2 전화번호").setPreferredWidth(150);
		table_stuList.getColumn("특이사항").setPreferredWidth(250);
		table_stuList.setEnabled(false);

		JButton bigger_btn_1 = new JButton("정보 수정");
		bigger_btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bigger_btn_1.setForeground(new Color(255, 250, 250));
		bigger_btn_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		bigger_btn_1.setBackground(new Color(119, 136, 153));
		bigger_btn_1.setBounds(251, 194, 94, 34);
		attendance_menu.add(bigger_btn_1);

		JButton bigger_btn_1_1 = new JButton("원생 삭제");
		bigger_btn_1_1.setForeground(new Color(255, 250, 250));
		bigger_btn_1_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		bigger_btn_1_1.setBackground(new Color(119, 136, 153));
		bigger_btn_1_1.setBounds(347, 194, 94, 34);
		attendance_menu.add(bigger_btn_1_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBounds(12, 84, 429, 98);
		attendance_menu.add(panel);
		panel.setLayout(null);

		JSeparator separator = new JSeparator();
		separator.setBounds(-13, 98, 456, 2);
		panel.add(separator);
		JLabel lblNewLabel = new JLabel("현재 수강생 총 : " + all.length + "명");
		lblNewLabel.setBounds(12, 0, 264, 100);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(255, 255, 255));

		lblNewLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 30));

		JButton add_student_btn = new JButton("+ 수강생 추가");
		add_student_btn.setBounds(275, 32, 142, 34);
		panel.add(add_student_btn);
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
		add_student_btn.setForeground(Color.WHITE);
		add_student_btn.setFont(new Font("배달의민족 주아", Font.BOLD, 16));
		add_student_btn.setBackground(new Color(102, 153, 204));
		table_stuList.getTableHeader().setReorderingAllowed(false); // 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수
																	// 있다.

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

		TableColumnModel tcm = table_stuList.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

		// 전체 열에 지정
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
			// 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여
			// 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		}

	}
}