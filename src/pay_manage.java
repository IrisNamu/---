import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import database.MemberDAO;
import database.PayDAO;
import database.StudentDAO;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

public class pay_manage extends JFrame {
	private PayDAO dao;

	private JPanel contentPane;
	private JTable table_stuList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pay_manage frame = new pay_manage();
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
	public pay_manage() {
		dao = new PayDAO();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// 날짜

		JYearChooser yearChooser = new JYearChooser();
		yearChooser.setBounds(206, 130, 76, 31);
		contentPane.add(yearChooser);

		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.setBounds(283, 130, 106, 31);
		contentPane.add(monthChooser);

		String day = yearChooser.getYear() + "-" + (monthChooser.getMonth() + 1);

		JScrollPane default_scroll = new JScrollPane();
		default_scroll.setBounds(36, 210, 379, 424);
		contentPane.add(default_scroll);

		String[] header = new String[] { "출석번호", "이름", "나이", "수납일", "수납액", "주소", "보호자1", "보호자1 전화번호" };
		String[][] data = dao.pay_stulList(day);
		table_stuList = new JTable();
		table_stuList.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
		table_stuList.setModel(new DefaultTableModel(data, header));
		table_stuList.repaint();
		default_scroll.setViewportView(table_stuList);
		table_stuList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		// 테이블 높이 넓이 조정해주기
		table_stuList.setRowHeight(35);
		table_stuList.getColumn("수납일").setPreferredWidth(130);
		table_stuList.getColumn("수납액").setPreferredWidth(130);
		table_stuList.getColumn("주소").setPreferredWidth(200);
		table_stuList.getColumn("보호자1").setPreferredWidth(100);
		table_stuList.getColumn("보호자1 전화번호").setPreferredWidth(120);
		table_stuList.getTableHeader().setReorderingAllowed(false);

		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

		TableColumnModel tcm = table_stuList.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

		// 전체 열에 지정
		for (int i = 0; i < tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
			// 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여
			// 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		}

		JButton add_pay_info = new JButton("수납 정보 추가하기");
		add_pay_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment pay = new payment();
				pay.setVisible(true);
			}
		});
		add_pay_info.setBounds(145, 650, 137, 53);
		contentPane.add(add_pay_info);

		JButton select = new JButton("New button");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String day = yearChooser.getYear() + "-" + (monthChooser.getMonth() + 1);
			}
		});
		select.setBounds(257, 97, 97, 23);
		contentPane.add(select);

		JLabel lblNewLabel = new JLabel("2022년 7월 납부");
		lblNewLabel.setBounds(12, 83, 137, 53);
		contentPane.add(lblNewLabel);

		JButton all = new JButton("전체");
		all.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				default_scroll.setVisible(false);
				scrollPane.setBounds(36, 210, 379, 424);
				contentPane.add(scrollPane);

				String[] header = new String[] { "출석번호", "이름", "나이", "수납일", "수납액", "주소", "보호자1", "보호자1 전화번호" };
				String[][] data = dao.pay_stulList(day);

				table_stuList = new JTable();
				table_stuList.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
				table_stuList.setModel(new DefaultTableModel(data, header));
				table_stuList.repaint();
				scrollPane.setViewportView(table_stuList);
				table_stuList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				// 테이블 높이 넓이 조정해주기
				table_stuList.setRowHeight(35);
				table_stuList.getColumn("수납일").setPreferredWidth(130);
				table_stuList.getColumn("수납액").setPreferredWidth(130);
				table_stuList.getColumn("주소").setPreferredWidth(200);
				table_stuList.getColumn("보호자1").setPreferredWidth(100);
				table_stuList.getColumn("보호자1 전화번호").setPreferredWidth(120);
				table_stuList.getTableHeader().setReorderingAllowed(false);

				DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
				dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

				TableColumnModel tcm = table_stuList.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

				for (int i = 0; i < tcm.getColumnCount(); i++) {
					tcm.getColumn(i).setCellRenderer(dtcr);
				}
			}
		});
		all.setBounds(36, 177, 97, 23);
		contentPane.add(all);

		new PayDAO().pay_stulList(day);
		String[][] pay_stulList = new PayDAO().pay_stulList(day);
		System.out.println(pay_stulList.length);

		JButton pay_O = new JButton("납부완료 " + pay_stulList.length);
		pay_O.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				default_scroll.setVisible(false);
				scrollPane.setBounds(36, 210, 379, 424);
				contentPane.add(scrollPane);

				String[] header = new String[] { "출석번호", "이름", "나이", "수납일", "수납액", "주소", "보호자1", "보호자1 전화번호" };
				String[][] data = dao.pay_stulList(day);

				table_stuList = new JTable();
				table_stuList.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
				table_stuList.setModel(new DefaultTableModel(data, header));
				table_stuList.repaint();
				scrollPane.setViewportView(table_stuList);
				table_stuList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				// 테이블 높이 넓이 조정해주기
				table_stuList.setRowHeight(35);
				table_stuList.getColumn("수납일").setPreferredWidth(130);
				table_stuList.getColumn("수납액").setPreferredWidth(130);
				table_stuList.getColumn("주소").setPreferredWidth(200);
				table_stuList.getColumn("보호자1").setPreferredWidth(100);
				table_stuList.getColumn("보호자1 전화번호").setPreferredWidth(120);
				table_stuList.getTableHeader().setReorderingAllowed(false);

				DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
				dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

				TableColumnModel tcm = table_stuList.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

				for (int i = 0; i < tcm.getColumnCount(); i++) {
					tcm.getColumn(i).setCellRenderer(dtcr);
				}
			}
		});
		pay_O.setBounds(162, 177, 106, 23);
		contentPane.add(pay_O);

		new PayDAO().did_not_pay(day);
		String[][] did_not_pay = new PayDAO().did_not_pay(day);
		System.out.println(did_not_pay.length);

		JButton Pay_X = new JButton("미납자 " + did_not_pay.length);
		Pay_X.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				default_scroll.setVisible(false);
				scrollPane.setBounds(36, 210, 379, 424);
				contentPane.add(scrollPane);

				String[] header = new String[] { "출석번호", "이름", "나이", "마지막 수납일", "수납액", "주소", "보호자1", "보호자1 전화번호" };
				String[][] data = dao.did_not_pay(day);

				table_stuList = new JTable();
				table_stuList.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
				table_stuList.setModel(new DefaultTableModel(data, header));
				table_stuList.repaint();
				scrollPane.setViewportView(table_stuList);
				table_stuList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

				// 테이블 높이 넓이 조정해주기
				table_stuList.setRowHeight(35);
				table_stuList.getColumn("마지막 수납일").setPreferredWidth(130);
				table_stuList.getColumn("수납액").setPreferredWidth(130);
				table_stuList.getColumn("주소").setPreferredWidth(200);
				table_stuList.getColumn("보호자1").setPreferredWidth(100);
				table_stuList.getColumn("보호자1 전화번호").setPreferredWidth(120);
				table_stuList.getTableHeader().setReorderingAllowed(false);

				DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
				dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

				TableColumnModel tcm = table_stuList.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴

				for (int i = 0; i < tcm.getColumnCount(); i++) {
					tcm.getColumn(i).setCellRenderer(dtcr);
				}
			}
		});
		Pay_X.setBounds(283, 177, 106, 23);
		contentPane.add(Pay_X);

	}
}
