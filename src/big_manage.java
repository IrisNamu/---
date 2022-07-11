import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Scrollbar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import database.MemberDAO;
import database.StudentDAO;
import database.StudentVo;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;

public class big_manage extends JFrame {
	private StudentDAO dao;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTable table_stuList;
	private JTextField search_field;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					big_manage frame = new big_manage();
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
	public big_manage() {
		dao = new StudentDAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 820);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 140, 1200, 600);
		contentPane.add(scrollPane);

		String[] header = new String[] { "출석번호", "이름", "성별", "나이", "학교명", "학년", "반", "생년월일", "등원요일", "주소", "등록일",
				"학생 전화번호", "보호자1 성함", "보호자1 전화번호", "보호자2 성함", "보호자2 전화번호", "특이사항" };
		String[][] data = dao.getStudent();
		table_stuList = new JTable();
		table_stuList.setFont(new Font("굴림", Font.PLAIN, 15));
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
		// 테이블 높이 넓이 조정해주기
		table_stuList.setRowHeight(40);
		table_stuList.getColumn("등원요일").setPreferredWidth(100);
		table_stuList.setEnabled(false); // 수정불가능

		search_field = new JTextField();
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
		search_field.setForeground(Color.DARK_GRAY);
		search_field.setFont(new Font("배달의민족 주아", Font.PLAIN, 19));
		search_field.setColumns(10);
		search_field.setBounds(411, 83, 237, 47);
		contentPane.add(search_field);

		JButton search = new JButton("검색");
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
		search.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		search.setBackground(new Color(176, 196, 222));
		search.setBounds(660, 84, 79, 46);
		contentPane.add(search);

		JButton bigger_btn_1 = new JButton("정보 수정");
		bigger_btn_1.setForeground(new Color(255, 250, 250));
		bigger_btn_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		bigger_btn_1.setBackground(new Color(119, 136, 153));
		bigger_btn_1.setBounds(961, 83, 108, 47);
		contentPane.add(bigger_btn_1);

		JLabel lblNewLabel = new JLabel("현재 수강생 총 : 17명");
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 40));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(38, 7, 364, 123);
		contentPane.add(lblNewLabel);

		JButton add_student_btn = new JButton("+ 수강생 추가");
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
		add_student_btn.setFont(new Font("배달의민족 주아", Font.BOLD, 20));
		add_student_btn.setBackground(new Color(102, 153, 204));
		add_student_btn.setBounds(781, 84, 153, 46);
		contentPane.add(add_student_btn);

		JButton bigger_btn_1_1 = new JButton("원생 삭제");
		bigger_btn_1_1.setForeground(new Color(255, 250, 250));
		bigger_btn_1_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 20));
		bigger_btn_1_1.setBackground(new Color(119, 136, 153));
		bigger_btn_1_1.setBounds(1076, 83, 114, 47);
		contentPane.add(bigger_btn_1_1);

		JButton backBtn = new JButton("<");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				management_Student manage = new management_Student(); // 홈화면 호출
				manage.setVisible(true);
				dispose();
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 34));
		backBtn.setBorderPainted(false);
		backBtn.setBackground(Color.GRAY);
		backBtn.setBounds(1217, 0, 67, 47);
		contentPane.add(backBtn);
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