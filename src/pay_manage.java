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
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.UIManager;

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
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel Menubar = new JPanel();
		Menubar.setLayout(null);
		Menubar.setBackground(new Color(19, 25, 53));
		Menubar.setBounds(0, 0, 454, 64);
		contentPane.add(Menubar);

		JButton attendanceMenu = new JButton("");
		attendanceMenu.setBackground(new Color(19, 25, 53));
		attendanceMenu.setBounds(0, 0, 87, 64);
		Menubar.add(attendanceMenu);

		JButton manageStudent_Menu = new JButton("");
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
		statistics_Menu_1.setBackground(new Color(19, 25, 53));
		statistics_Menu_1.setBounds(170, 0, 87, 64);
		Menubar.add(statistics_Menu_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 245, 379, 445);
		contentPane.add(scrollPane);

		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-M");
		JLabel dateLab = new JLabel();
		dateLab.setText(date.format(d));
		System.out.println(dateLab.getText());
		String day = dateLab.getText();

		String[] header = new String[] { "출석번호", "이름", "나이", "수납일", "수납액", "주소", "보호자1", "보호자1 전화번호" };
		String[][] data = dao.pay_stulList(day);
		table_stuList = new JTable();
		table_stuList.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
		table_stuList.setModel(new DefaultTableModel(data, header));
		table_stuList.repaint();
		scrollPane.setViewportView(table_stuList);
		table_stuList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table_stuList.getTableHeader().setFont(new Font("배달의민족 주아", Font.PLAIN, 17));

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

		JButton add_pay_info = new JButton("+ 수납 정보 추가하기 (Click!)");
		add_pay_info.setFont(new Font("배달의민족 주아", Font.PLAIN, 22));
		add_pay_info.setBackground(new Color(119, 136, 153));
		add_pay_info.setForeground(new Color(255, 255, 255));
		add_pay_info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payment pay = new payment();
				pay.setVisible(true);
			}
		});
		add_pay_info.setBounds(0, 63, 454, 55);
		contentPane.add(add_pay_info);

		SimpleDateFormat date_ = new SimpleDateFormat("yyyy년 MM월");
		JLabel date1 = new JLabel();
		date1.setText(date_.format(d));

		JLabel lblNewLabel = new JLabel(date1.getText() + " 수납관리");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("배달의민족 주아", Font.BOLD, 31));
		lblNewLabel.setBounds(0, 137, 454, 53);
		contentPane.add(lblNewLabel);

		new PayDAO().pay_stulList(day);
		String[][] pay_stulList = new PayDAO().pay_stulList(day);
		System.out.println(pay_stulList.length);

		JButton pay_O = new JButton("납부완료 " + pay_stulList.length);
		pay_O.setBackground(new Color(211, 211, 211));
		pay_O.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
		pay_O.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		
				String[] header = new String[] { "출석번호", "이름", "나이", "수납일", "수납액", "주소", "보호자1", "보호자1 전화번호" };
				String[][] data = dao.pay_stulList(day);

				contentPane.add(scrollPane);
				table_stuList = new JTable();
				table_stuList.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
				table_stuList.setModel(new DefaultTableModel(data, header));
				table_stuList.repaint();
				scrollPane.setViewportView(table_stuList);
				table_stuList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table_stuList.getTableHeader().setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
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
		pay_O.setBounds(99, 200, 117, 35);
		contentPane.add(pay_O);

		new PayDAO().did_not_pay(day);
		String[][] did_not_pay = new PayDAO().did_not_pay(day);
		System.out.println(did_not_pay.length);

		JButton Pay_X = new JButton("미납자 " + did_not_pay.length);
		Pay_X.setBackground(new Color(211, 211, 211));
		Pay_X.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
		Pay_X.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] header = new String[] { "출석번호", "이름", "나이", "마지막 수납일", "수납액", "주소", "보호자1", "보호자1 전화번호" };
				String[][] data = dao.did_not_pay(day);

				contentPane.add(scrollPane);
				table_stuList = new JTable();
				table_stuList.setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
				table_stuList.setModel(new DefaultTableModel(data, header));
				table_stuList.repaint();
				scrollPane.setViewportView(table_stuList);
				table_stuList.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table_stuList.getTableHeader().setFont(new Font("배달의민족 주아", Font.PLAIN, 17));
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
		Pay_X.setBounds(228, 200, 117, 35);
		contentPane.add(Pay_X);

	}
}
