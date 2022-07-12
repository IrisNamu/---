import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import database.StudentDAO;
import database.StudentVo;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class small_search extends JFrame {
	private StudentDAO dao;

	private JPanel contentPane;
	private JTextField search_field;
	private JTable table_stuList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					small_search frame = new small_search();
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
	public small_search() {
		dao = new StudentDAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
		search.setFont(new Font("배달의민족 주아", Font.PLAIN, 16));
		search.setBackground(new Color(176, 196, 222));
		search.setBounds(273, 60, 66, 34);
		contentPane.add(search);

		JScrollPane scrollPane = new JScrollPane();

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

		scrollPane.setBounds(27, 103, 377, 148);
		contentPane.add(scrollPane);

		table_stuList = new JTable();
		scrollPane.setViewportView(table_stuList);

		JLabel lblNewLabel = new JLabel(" * 동명이인의 문제로 수강생 고유 번호인 출석번호를 필수로 기입해주세요.");
		lblNewLabel.setBounds(12, 35, 399, 15);
		contentPane.add(lblNewLabel);

		search_field = new JTextField();
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
		search_field.setForeground(Color.GRAY);
		search_field.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
		search_field.setBounds(70, 60, 191, 34);
		contentPane.add(search_field);
		search_field.setColumns(10);
	}

}
