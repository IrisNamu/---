import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import database.StudentDAO;
import database.StudentVo;

@SuppressWarnings("serial")
public class Update_stuInfo extends JFrame {
	private StudentDAO dao;

	private JPanel contentPane;
	private JTextField s_name;
	private JTextField s_memo;
	private JTextField s_call_num;
	private JTextField s_guardian1;
	private JTextField s_guardian2;
	private JTextField address_;
	private JTextField stu_num;
	private JTextField s_guardian1_call_;
	private JTextField s_guardian2_call;
	private JTextField s_school;
	private JTextField s_grade;
	private JTextField s_class;
	private File selectedFile;
	private String age;
	private String birth;
	private String enter_date;
	private String grade;
	private String current_date;
	private String when_daycome = "";
	String filePath = "";
	private JLabel stunum;

	public Update_stuInfo(String num, String name, String sex, String age, String school, String grade, String class_,
			String birth, String when_come, String address, String enter_date, String stu_call, String G1,
			String G1_call, String G2, String G2_call, String memo) {

		dao = new StudentDAO();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home_Login.class.getResource("/img/app_icon.png")));

		setTitle("\uC624!\uCD9C\uC11D - \uD559\uC0DD \uC815\uBCF4 \uB4F1\uB85D\uD558\uAE30");
		setBounds(100, 100, 510, 820);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton backBtn = new JButton("<");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				management_Student manage = new management_Student();
				manage.setVisible(true);
			}
		});

		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		backBtn.setBackground(new Color(128, 128, 128));
		backBtn.setBounds(429, 0, 65, 58);
		contentPane.add(backBtn);

		// 학생이름
		s_name = new JTextField(name);
		s_name.setForeground(new Color(128, 0, 0));
		s_name.setFont(new Font("굴림", Font.PLAIN, 14));
		s_name.setBounds(204, 107, 155, 29);
		contentPane.add(s_name);
		s_name.setColumns(10);

		// 학생 성별선택
		JRadioButton s_boy_check = new JRadioButton("남");
		s_boy_check.setFont(new Font("굴림", Font.PLAIN, 16));
		s_boy_check.setBounds(367, 109, 45, 23);
		contentPane.add(s_boy_check);
		s_boy_check.setActionCommand(s_boy_check.getText());

		JRadioButton s_girl_check = new JRadioButton("여");
		s_girl_check.setFont(new Font("굴림", Font.PLAIN, 16));
		s_girl_check.setBounds(415, 109, 45, 23);
		contentPane.add(s_girl_check);
		s_girl_check.setActionCommand(s_girl_check.getText());

		ButtonGroup gender_group = new ButtonGroup();

		gender_group.add(s_boy_check);
		gender_group.add(s_girl_check);

		if (sex.equals("남")) {
			s_boy_check.setSelected(true);
		} else {
			s_girl_check.setSelected(true);
		}

		// 학교이름
		s_school = new JTextField(school);
		s_school.setForeground(new Color(112, 128, 144));
		s_school.setFont(new Font("굴림", Font.PLAIN, 14));
		s_school.setBounds(204, 194, 240, 29);
		contentPane.add(s_school);
		s_school.setColumns(10);

		s_grade = new JTextField(grade);
		s_grade.setFont(new Font("굴림", Font.PLAIN, 14));
		s_grade.setForeground(new Color(112, 128, 144));
		s_grade.setColumns(10);
		s_grade.setBounds(204, 242, 146, 29);
		contentPane.add(s_grade);

		s_class = new JTextField(class_);
		s_class.setForeground(new Color(112, 128, 144));
		s_class.setFont(new Font("굴림", Font.PLAIN, 14));
		s_class.setColumns(10);
		s_class.setBounds(358, 242, 86, 29);
		contentPane.add(s_class);

		// 등원요일
		JCheckBox s_mon = new JCheckBox("월");
		s_mon.setFont(new Font("굴림", Font.PLAIN, 15));
		s_mon.setHorizontalAlignment(SwingConstants.TRAILING);
		s_mon.setBounds(108, 380, 45, 34);
		contentPane.add(s_mon);
		s_mon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(s_mon.getText() + " ");

			}
		});

		JCheckBox s_tue = new JCheckBox("화");
		s_tue.setFont(new Font("굴림", Font.PLAIN, 15));
		s_tue.setHorizontalAlignment(SwingConstants.CENTER);
		s_tue.setBounds(157, 379, 43, 37);
		contentPane.add(s_tue);
		s_tue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(s_tue.getText() + " ");
			}
		});

		JCheckBox s_wed = new JCheckBox("수");
		s_wed.setFont(new Font("굴림", Font.PLAIN, 15));
		s_wed.setHorizontalAlignment(SwingConstants.CENTER);
		s_wed.setBounds(204, 378, 43, 39);
		contentPane.add(s_wed);
		s_wed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(s_wed.getText() + " ");
			}
		});

		JCheckBox s_thur = new JCheckBox("목");
		s_thur.setFont(new Font("굴림", Font.PLAIN, 15));
		s_thur.setHorizontalAlignment(SwingConstants.CENTER);
		s_thur.setBounds(251, 383, 41, 29);
		contentPane.add(s_thur);
		s_thur.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(s_thur.getText() + " ");
			}
		});

		JCheckBox s_fri = new JCheckBox("금");
		s_fri.setFont(new Font("굴림", Font.PLAIN, 15));
		s_fri.setHorizontalAlignment(SwingConstants.CENTER);
		s_fri.setBounds(296, 378, 43, 39);
		contentPane.add(s_fri);
		s_fri.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(s_fri.getText() + " ");
			}
		});

		JCheckBox s_sat = new JCheckBox("토");
		s_sat.setFont(new Font("굴림", Font.PLAIN, 15));
		s_sat.setHorizontalAlignment(SwingConstants.CENTER);
		s_sat.setBounds(341, 383, 46, 29);
		contentPane.add(s_sat);
		s_sat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(s_sat.getText() + " ");
			}
		});

		JCheckBox s_sun = new JCheckBox("일");
		s_sun.setFont(new Font("굴림", Font.PLAIN, 15));
		s_sun.setHorizontalAlignment(SwingConstants.LEFT);
		s_sun.setBounds(391, 383, 43, 29);
		contentPane.add(s_sun);
		s_sun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(s_sun.getText() + " ");
			}
		});

		if (when_come.contains("월") == true) {
			s_mon.setSelected(true);
		}
		if (when_come.contains("화") == true) {
			s_tue.setSelected(true);
		}
		if (when_come.contains("수") == true) {
			s_wed.setSelected(true);
		}
		if (when_come.contains("목") == true) {
			s_thur.setSelected(true);
		}
		if (when_come.contains("금") == true) {
			s_fri.setSelected(true);
		}
		if (when_come.contains("토") == true) {
			s_sat.setSelected(true);
		}
		if (when_come.contains("일") == true) {
			s_sun.setSelected(true);
		}

		// 학생 전화번호
		s_call_num = new JTextField(stu_call);
		s_call_num.setForeground(new Color(112, 128, 144));
		s_call_num.setFont(new Font("굴림", Font.PLAIN, 14));
		s_call_num.setBounds(52, 559, 382, 34);
		contentPane.add(s_call_num);
		s_call_num.setColumns(10);

		// 보호자1 관계 콤보박스
		JComboBox<String> s_who_guardian1 = new JComboBox<String>();
		s_who_guardian1.setBounds(52, 613, 86, 23);
		contentPane.add(s_who_guardian1);
		s_who_guardian1.addItem(" 미선택 ");
		s_who_guardian1.addItem(" (모)");
		s_who_guardian1.addItem(" (부)");
		s_who_guardian1.addItem(" (조모)");
		s_who_guardian1.addItem(" (조부)");
		s_who_guardian1.addItem(" (기타)");
		s_who_guardian1.getSelectedItem();

		// 보호자1 관계 콤보박스
		JComboBox<String> s_who_guardian2 = new JComboBox<String>();
		s_who_guardian2.setBounds(52, 652, 86, 23);
		contentPane.add(s_who_guardian2);
		s_who_guardian2.addItem(" 미선택 ");
		s_who_guardian2.addItem(" (모)");
		s_who_guardian2.addItem(" (부)");
		s_who_guardian2.addItem(" (조모)");
		s_who_guardian2.addItem(" (조부)");
		s_who_guardian2.addItem(" (기타)");
		s_who_guardian2.getSelectedItem();

		// 보호자1 성함
		s_guardian1 = new JTextField(G1);
		s_guardian1.setForeground(new Color(112, 128, 144));
		s_guardian1.setColumns(10);
		s_guardian1.setBounds(152, 610, 93, 29);
		contentPane.add(s_guardian1);

		// 보호자 2 성함
		s_guardian2 = new JTextField(G2);
		s_guardian2.setForeground(new Color(112, 128, 144));
		s_guardian2.setColumns(10);
		s_guardian2.setBounds(152, 649, 93, 29);
		contentPane.add(s_guardian2);

		// 학생주소 입력필드
		address_ = new JTextField(address);
		address_.setForeground(new Color(112, 128, 144));
		address_.setFont(new Font("굴림", Font.PLAIN, 14));
		address_.setColumns(10);
		address_.setBounds(40, 292, 350, 29);
		contentPane.add(address_);

		// 보호자1 전화번호
		s_guardian1_call_ = new JTextField(G1_call);
		s_guardian1_call_.setForeground(new Color(112, 128, 144));
		s_guardian1_call_.setFont(new Font("굴림", Font.PLAIN, 13));
		s_guardian1_call_.setColumns(10);
		s_guardian1_call_.setBounds(257, 610, 177, 29);
		contentPane.add(s_guardian1_call_);

		// 보호자2 전화번호
		s_guardian2_call = new JTextField(G2_call);
		s_guardian2_call.setForeground(new Color(112, 128, 144));
		s_guardian2_call.setFont(new Font("굴림", Font.PLAIN, 13));
		s_guardian2_call.setColumns(10);
		s_guardian2_call.setBounds(257, 649, 177, 29);
		contentPane.add(s_guardian2_call);

		// 맨 위 라벨
		JLabel copyright_SYG_Label = new JLabel("오! 출석 - 학생 정보 수정");
		copyright_SYG_Label.setForeground(Color.WHITE);
		copyright_SYG_Label.setFont(new Font("배달의민족 주아", Font.PLAIN, 23));
		copyright_SYG_Label.setOpaque(true);
		copyright_SYG_Label.setHorizontalAlignment(SwingConstants.CENTER);
		copyright_SYG_Label.setBackground(SystemColor.activeCaption);
		copyright_SYG_Label.setBounds(0, 0, 494, 58);
		contentPane.add(copyright_SYG_Label);

		JLabel pic_path = new JLabel("New label");
		JFileChooser fileChooser = new JFileChooser();
		JButton stu_pic = new JButton();
		stu_pic.setText("사진 +");
		stu_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "사진을 등록하시겠습니까?", "오!출석 - 학생 정보 추가",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_OPTION) {

					JFrame window = new JFrame();

					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));
					FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg & png 파일", "png", "jpg");
					fileChooser.addChoosableFileFilter(filter);
					int pic = fileChooser.showSaveDialog(window);

					if (pic == JFileChooser.APPROVE_OPTION) {
						selectedFile = fileChooser.getSelectedFile(); // 지역변수 이프문안세만 클래스의 멤버변수로 바꾸기
						String filePath = fileChooser.getSelectedFile().getPath();
						stu_pic.setIcon(new ImageIcon(filePath));
						ImageIcon pic2 = new ImageIcon(filePath);
						Image img = pic2.getImage();
						Image changeImg = img.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
						ImageIcon changeIcon = new ImageIcon(changeImg);
						stu_pic.setIcon(changeIcon);

						System.out.println(filePath.toString());
						pic_path.setText(filePath.toString());

					}
				}
			}
		});

		stu_pic.setFont(new Font("굴림", Font.PLAIN, 21));
		stu_pic.setBackground(new Color(255, 255, 255));
		stu_pic.setBounds(37, 96, 146, 175);
		contentPane.add(stu_pic);

		JLabel lblNewLabel = new JLabel("* 이름과 출석번호는 필수 입력사항입니다.");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(37, 62, 365, 26);
		contentPane.add(lblNewLabel);

		JLabel day_label = new JLabel("등원요일");
		day_label.setHorizontalAlignment(SwingConstants.CENTER);
		day_label.setFont(new Font("굴림", Font.BOLD, 14));
		day_label.setBounds(37, 380, 75, 35);
		contentPane.add(day_label);

		JTextArea s_memo = new JTextArea(memo); // 메모할 때는 텍스트에어리어 텍스트필드쓰면 엔터가 안된다.
		s_memo.setLineWrap(true); // 한줄이 너무 길면 자동으로 개행할지 설정
		s_memo.setForeground(new Color(112, 128, 144));
		s_memo.setFont(new Font("굴림", Font.PLAIN, 16));
		s_memo.setToolTipText("");
		s_memo.setBounds(52, 467, 377, 82);
		contentPane.add(s_memo);
		s_memo.setColumns(10);

		// 생일 날짜 달력
		JDateChooser birth_dateChooser = new JDateChooser();
		birth_dateChooser.setBounds(205, 146, 217, 29);
		contentPane.add(birth_dateChooser);

		// 생년월일 라벨
		JLabel lblNewLabel_1_1 = new JLabel("생년월일 ");
		birth_dateChooser.add(lblNewLabel_1_1, BorderLayout.WEST);
		lblNewLabel_1_1.setFont(new Font("함초롬돋움", Font.PLAIN, 16));

		// 등록날짜 달력
		JDateChooser enter_dateChooser = new JDateChooser();
		enter_dateChooser.setBounds(103, 420, 290, 29);
		contentPane.add(enter_dateChooser);

		JLabel enter_label = new JLabel("학원 등록일 ");
		enter_dateChooser.add(enter_label, BorderLayout.WEST);
		enter_label.setFont(new Font("함초롬돋움", Font.PLAIN, 16));

		// 저장버튼
		JButton s_save_btn = new JButton("저장");
		s_save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean b = true;
				if (b == true) {
					// dao.student_Delete(num.getText());
					dispose();
					management_Student manage = new management_Student();
					manage.setVisible(true);
				}
			}
		});
		s_save_btn.setFont(new Font("함초롬바탕", Font.PLAIN, 16));
		s_save_btn.setBounds(176, 700, 144, 46);
		contentPane.add(s_save_btn);

		stunum = new JLabel("출석번호 : " + num + " (수정 불가)");
		stunum.setHorizontalAlignment(SwingConstants.CENTER);
		stunum.setOpaque(true);
		stunum.setBackground(Color.white);
		stunum.setFont(new Font("굴림", Font.PLAIN, 15));
		stunum.setBounds(40, 341, 280, 29);
		contentPane.add(stunum);

	}
}