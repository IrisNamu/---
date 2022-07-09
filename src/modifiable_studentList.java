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
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;

public class modifiable_studentList extends JFrame {
	private StudentDAO dao;
	private JPanel contentPane;
	private JTextField search_field;
	private JTextField textField_1;
	private JTable table_stuList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifiable_studentList frame = new modifiable_studentList();
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
	public modifiable_studentList() {
		dao = new StudentDAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 817, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// DB연동 수강생 리스트 불러오기

		JButton btnNewButton = new JButton("수정사항 저장하기");
		btnNewButton.setBounds(674, 176, 115, 56);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("엑셀로 저장");
		btnNewButton_1.setBounds(661, 115, 109, 37);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.setBounds(692, 322, 97, 56);
		contentPane.add(btnNewButton_2);

		JMenu sort_nenubar = new JMenu("  정렬방법   ∨  ");
		sort_nenubar.setHorizontalAlignment(SwingConstants.CENTER);
		sort_nenubar.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		sort_nenubar.setBackground(new Color(255, 255, 204));
		sort_nenubar.setBounds(29, 42, 129, 37);
		contentPane.add(sort_nenubar);

		JRadioButtonMenuItem name_order = new JRadioButtonMenuItem("이름순");
		name_order.setBackground(Color.WHITE);
		sort_nenubar.add(name_order);

		JRadioButtonMenuItem reverse_name = new JRadioButtonMenuItem("이름역순");
		reverse_name.setBackground(Color.WHITE);
		sort_nenubar.add(reverse_name);

		JRadioButtonMenuItem lower_grade = new JRadioButtonMenuItem("저학년순");
		lower_grade.setBackground(Color.WHITE);
		sort_nenubar.add(lower_grade);

		JRadioButtonMenuItem upper_grade = new JRadioButtonMenuItem("고학년순");
		upper_grade.setBackground(Color.WHITE);
		sort_nenubar.add(upper_grade);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 98, 577, 473);
		contentPane.add(scrollPane);

		// DB연동 수강생 리스트 불러오기
		String[] header = new String[] { "출석번호", "나이", "이름", "학교명", "학년", "반", "등원요일" };
		String[][] data = dao.getStudent();
//		table_stuList = new JTable(data, header); // 배열 이용해서 테이블
		table_stuList = new JTable();
		table_stuList.setModel(new DefaultTableModel(data, header));
		scrollPane.setViewportView(table_stuList);

		search_field = new JTextField();
		search_field.setText("검색어를 입력해주세요.");
		search_field.setBounds(170, 48, 199, 31);
		contentPane.add(search_field);
		search_field.setColumns(10);

		//DefaultTableModel dt = new DefaultTableModel(data, header);

		JButton search = new JButton("검색");
		search.setVerticalAlignment(SwingConstants.BOTTOM);
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 검색하면 테이블에 해당 검색결과 나타내기
				DefaultTableModel model = (DefaultTableModel) table_stuList.getModel(); // 와 이걸로 7시간 고생함. 앞에 캐스팅 해줘야한다.
				model.setRowCount(0);

				String word = search_field.getText();
				System.out.println(word);
				if (word.length() < 1) {
					return;
				}
				StudentDAO dao = new StudentDAO();
				ArrayList<StudentVo> list = dao.search_Info(word);

				for (StudentVo vo : list) {
					String[] data = { vo.getStuNumber(), vo.getAge(), vo.getStuName(), vo.getSchool(), vo.getGrade(),
							vo.getWhen_day(), vo.getClassName() };
					model.addRow(data);// 이걸 적어줘야 테이블에 추가가 된다.
				}

				table_stuList.setModel(model);
			}
		});

		search.setBounds(381, 56, 97, 23);
		contentPane.add(search);

	}
}