import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import database.MemberDAO;
import database.MemberVo;
import database.StudentDAO;
import database.StudentVo;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JScrollBar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import javax.swing.JList;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class addStudentPage extends JFrame {
	private StudentDAO dao;

	private JPanel contentPane;
	private JTextField s_name;
	private JTextField s_memo;
	private JTextField s_call_num;
	private JTextField s_guardian1;
	private JTextField s_guardian2;
	private JTextField address;
	private JTextField stu_num;
	private JTextField s_guardian1_call;
	private JTextField s_guardian2_call;
	private JTextField s_guardian2_call_1;
	private JTextField s_school;
	private JTextField s_grade;
	private JTextField s_class;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStudentPage frame = new addStudentPage();
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
	public addStudentPage() {
		dao = new StudentDAO();

		setTitle("\uC624!\uCD9C\uC11D - \uD559\uC0DD \uC815\uBCF4 \uB4F1\uB85D\uD558\uAE30");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
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
				attendance_Main attendance = new attendance_Main(); // 홈화면 호출
				attendance.setVisible(true);
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		backBtn.setBackground(new Color(128, 128, 128));
		backBtn.setBounds(385, 0, 65, 50);
		contentPane.add(backBtn);

		// 성별 체크
		JRadioButton s_boy_check = new JRadioButton("남");
		s_boy_check.setFont(new Font("굴림", Font.PLAIN, 16));
		s_boy_check.setBounds(361, 98, 45, 23);
		contentPane.add(s_boy_check);
		s_boy_check.setSelected(true); // 남자선택 기본값

		// s_boy_check.setActionCommand("남");
		s_boy_check.setActionCommand(s_boy_check.getText());

		// 학생이름
		s_name = new JTextField();
		s_name.setForeground(new Color(128, 0, 0));
		s_name.setFont(new Font("굴림", Font.PLAIN, 14));
		s_name.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_name.getText().equals(" * 이름을 입력해주세요.")) {
					s_name.setText("");
					s_name.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_name.getText().equals("")) {
					s_name.setText(" * 이름을 입력해주세요.");
					s_name.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_name.setText(" * 이름을 입력해주세요.");
		s_name.setBounds(189, 96, 164, 29);
		contentPane.add(s_name);
		s_name.setColumns(10);

		// 학생 성별선택
		JRadioButton s_girl_check = new JRadioButton("여");
		s_girl_check.setFont(new Font("굴림", Font.PLAIN, 16));
		s_girl_check.setBounds(405, 98, 45, 23);
		contentPane.add(s_girl_check);
		// s_girl_check.setActionCommand("여");
		s_girl_check.setActionCommand(s_girl_check.getText());

		ButtonGroup gender_group = new ButtonGroup();

		gender_group.add(s_boy_check);
		gender_group.add(s_girl_check);

//		// 남자인지 여자인지 값가져오기
//		JLabel gender = new JLabel();
//		if (s_boy_check.isSelected()) {
//			gender = new JLabel(s_boy_check.getText());
//		} else if (s_girl_check.isSelected()) {
//			gender = new JLabel(s_girl_check.getText());
//		}

		// 학교이름
		s_school = new JTextField();
		s_school.setForeground(new Color(112, 128, 144));
		s_school.setFont(new Font("굴림", Font.PLAIN, 14));
		s_school.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_school.getText().equals(" * 학교 입력란 예) OO초")) {
					s_school.setText("");
					s_school.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_school.getText().equals("")) {
					s_school.setText(" * 학교 입력란 예) OO초");
					s_school.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_school.setText(" * 학교 입력란 예) OO초");
		s_school.setBounds(189, 137, 217, 29);
		contentPane.add(s_school);
		s_school.setColumns(10);

		s_grade = new JTextField();
		s_grade.setFont(new Font("굴림", Font.PLAIN, 14));
		s_grade.setForeground(new Color(112, 128, 144));
		s_grade.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_grade.getText().equals(" * 학년 (숫자만 기입)")) {
					s_grade.setText("");
					s_grade.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_grade.getText().equals("")) {
					s_grade.setText(" * 학년 (숫자만 기입)");
					s_grade.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_grade.setText(" * 학년 (숫자만 기입)");
		s_grade.setColumns(10);
		s_grade.setBounds(189, 176, 104, 29);
		contentPane.add(s_grade);

		s_class = new JTextField();
		s_class.setForeground(new Color(112, 128, 144));
		s_class.setFont(new Font("굴림", Font.PLAIN, 14));
		s_class.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_class.getText().equals(" * 반 입력란 예) 잎새반, 1반 등..")) {
					s_class.setText("");
					s_class.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_class.getText().equals("")) {
					s_class.setText(" * 반 입력란 예) 잎새반, 1반 등..");
					s_class.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_class.setText(" * 반 입력란 예) 잎새반, 1반 등..");
		s_class.setColumns(10);
		s_class.setBounds(305, 176, 145, 29);
		contentPane.add(s_class);

		// 등원요일
		JCheckBox s_mon = new JCheckBox("월");
		s_mon.setFont(new Font("굴림", Font.PLAIN, 15));
		s_mon.setHorizontalAlignment(SwingConstants.TRAILING);
		s_mon.setBounds(93, 380, 45, 34);
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
		s_tue.setBounds(142, 379, 43, 37);
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
		s_wed.setBounds(189, 377, 43, 39);
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
		s_thur.setBounds(232, 382, 41, 29);
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
		s_fri.setBounds(277, 377, 43, 39);
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
		s_sat.setBounds(321, 382, 46, 29);
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
		s_sun.setBounds(371, 382, 43, 29);
		contentPane.add(s_sun);
		s_sun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.print(s_sun.getText());
			}
		});
//
		String days[] = new String[7];
		days[0] = s_mon.getText();
		days[1] = s_tue.getText();
		days[2] = s_wed.getText();
		days[3] = s_thur.getText();
		days[4] = s_fri.getText();
		days[5] = s_sat.getText();
		days[6] = s_sun.getText();

		// 학생 전화번호
		s_call_num = new JTextField();
		s_call_num.setForeground(new Color(112, 128, 144));
		s_call_num.setFont(new Font("굴림", Font.PLAIN, 14));
		s_call_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_call_num.getText().equals(" * 학생 전화번호를 입력해주세요. 예) 010-0000-0000")) {
					s_call_num.setText("");
					s_call_num.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_call_num.getText().equals("")) {
					s_call_num.setText(" * 학생 전화번호를 입력해주세요. 예) 010-0000-0000");
					s_call_num.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_call_num.setText(" * 학생 전화번호를 입력해주세요. 예) 010-0000-0000");
		s_call_num.setBounds(37, 519, 377, 34);
		contentPane.add(s_call_num);
		s_call_num.setColumns(10);

		// 보호자1 관계 콤보박스
		JComboBox<String> s_who_guardian1 = new JComboBox<String>();
		s_who_guardian1.setBounds(37, 563, 86, 23);
		contentPane.add(s_who_guardian1);
		s_who_guardian1.addItem(" (모)");
		s_who_guardian1.addItem(" (부)");
		s_who_guardian1.addItem(" (조모)");
		s_who_guardian1.addItem(" (조부)");
		s_who_guardian1.addItem(" (기타)");
		s_who_guardian1.getSelectedItem();

		// 보호자1 관계 콤보박스
		JComboBox<String> s_who_guardian2 = new JComboBox<String>();
		s_who_guardian2.setBounds(37, 605, 86, 23);
		contentPane.add(s_who_guardian2);
		s_who_guardian2.addItem(" (부)");
		s_who_guardian2.addItem(" (모)");
		s_who_guardian2.addItem(" (조모)");
		s_who_guardian2.addItem(" (조부)");
		s_who_guardian2.addItem(" (기타)");
		s_who_guardian2.getSelectedItem();

		// 보호자1 성함
		s_guardian1 = new JTextField();
		s_guardian1.setForeground(new Color(112, 128, 144));
		s_guardian1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_guardian1.getText().equals(" * 보호자1 성함")) {
					s_guardian1.setText("");
					s_guardian1.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_guardian1.getText().equals("")) {
					s_guardian1.setText(" * 보호자1 성함");
					s_guardian1.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_guardian1.setText(" * 보호자1 성함");
		s_guardian1.setColumns(10);
		s_guardian1.setBounds(135, 563, 93, 29);
		contentPane.add(s_guardian1);

		// 보호자 2 성함
		s_guardian2 = new JTextField();
		s_guardian2.setForeground(new Color(112, 128, 144));
		s_guardian2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_guardian2.getText().equals(" * 보호자2 성함")) {
					s_guardian2.setText("");
					s_guardian2.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_guardian2.getText().equals("")) {
					s_guardian2.setText(" * 보호자2 성함");
					s_guardian2.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_guardian2.setText(" * 보호자2 성함");
		s_guardian2.setColumns(10);
		s_guardian2.setBounds(135, 602, 93, 29);
		contentPane.add(s_guardian2);

		// 학생주소 입력필드
		address = new JTextField();
		address.setForeground(new Color(112, 128, 144));
		address.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (address.getText().equals(" * 주소를 입력해주세요. 예) 00아파트 000동 000호")) {
					address.setText("");
					address.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (address.getText().equals("")) {
					address.setText(" * 주소를 입력해주세요. 예) 00아파트 000동 000호");
					address.setForeground(new Color(153, 153, 153));
				}
			}
		});
		address.setText(" * 주소를 입력해주세요. 예) 00아파트 000동 000호");
		address.setFont(new Font("굴림", Font.PLAIN, 14));
		address.setColumns(10);
		address.setBounds(37, 261, 350, 29);
		contentPane.add(address);

		// 학생 출석번호 4자리 설정 필드
		stu_num = new JTextField();
		stu_num.setForeground(new Color(165, 42, 42));
		stu_num.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (stu_num.getText().equals(" *중복확인 필수* 출석번호 4자리(숫자)")) {
					stu_num.setText("");
					stu_num.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (stu_num.getText().equals("")) {
					stu_num.setText(" *중복확인 필수* 출석번호 4자리(숫자)");
					stu_num.setForeground(new Color(153, 153, 153));
				}
			}
		});
		stu_num.setText(" *중복확인 필수* 출석번호 4자리(숫자)");
		stu_num.setFont(new Font("굴림", Font.PLAIN, 14));
		stu_num.setColumns(10);
		stu_num.setBounds(37, 300, 280, 29);
		contentPane.add(stu_num);

		// 보호자1 전화번호
		s_guardian1_call = new JTextField();
		s_guardian1_call.setForeground(new Color(112, 128, 144));
		s_guardian1_call.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent e) {
				if (s_guardian1_call.getText().equals(" * phone 예)010-0000-0000")) {
					s_guardian1_call.setText("");
					s_guardian1_call.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_guardian1_call.getText().equals("")) {
					s_guardian1_call.setText(" * phone 예)010-0000-0000");
					s_guardian1_call.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_guardian1_call.setFont(new Font("굴림", Font.PLAIN, 13));
		s_guardian1_call.setText(" * phone 예)010-0000-0000");
		s_guardian1_call.setColumns(10);
		s_guardian1_call.setBounds(237, 564, 177, 29);
		contentPane.add(s_guardian1_call);

		// 보호자2 전화번호
		s_guardian2_call = new JTextField();
		s_guardian2_call_1 = new JTextField();
		s_guardian2_call_1.setForeground(new Color(112, 128, 144));
		s_guardian2_call_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_guardian2_call.getText().equals(" * phone 예)010-0000-0000")) {
					s_guardian2_call.setText("");
					s_guardian2_call.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_guardian2_call.getText().equals("")) {
					s_guardian2_call.setText(" * phone 예)010-0000-0000");
					s_guardian2_call.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_guardian2_call_1.setFont(new Font("굴림", Font.PLAIN, 13));
		s_guardian2_call_1.setText(" * phone 예)010-0000-0000");
		s_guardian2_call_1.setColumns(10);
		s_guardian2_call_1.setBounds(237, 602, 177, 29);
		contentPane.add(s_guardian2_call_1);

		// 맨 위 라벨
		JLabel copyright_SYG_Label = new JLabel("오! 출석 - 학생 정보 추가");
		copyright_SYG_Label.setForeground(Color.WHITE);
		copyright_SYG_Label.setFont(new Font("배달의민족 주아", Font.PLAIN, 23));
		copyright_SYG_Label.setOpaque(true);
		copyright_SYG_Label.setHorizontalAlignment(SwingConstants.CENTER);
		copyright_SYG_Label.setBackground(SystemColor.activeCaption);
		copyright_SYG_Label.setBounds(0, 0, 450, 50);
		contentPane.add(copyright_SYG_Label);

		// 사진을 따로 저장하지 않았을 때 나오는 이미지 불러오기
//		ImageIcon icon = new ImageIcon("/img/boy.png");
//		
//		//사이즈 맞춰주기
//		Image img = icon.getImage();
//		Image changeImg = img.getScaledInstance(151, 144, Image.SCALE_SMOOTH);
//		ImageIcon changeIcon = new ImageIcon(changeImg);

		JButton stu_pic = new JButton();
		stu_pic.setText("사진 +");
		stu_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, "사진을 등록하시겠습니까?", "오!출석 - 학생 정보 추가",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.CLOSED_OPTION) {

				} else if (result == JOptionPane.YES_OPTION) {

					JFrame window = new JFrame();

					JFileChooser fileChooser = new JFileChooser();

					// 기본 Path의 경로 설정 (바탕화면)
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home") + "//" + "Desktop"));

					// 필터링될 확장자
					FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg & png 파일", "png", "jpg");

					// 필터링될 확장자 추가
					fileChooser.addChoosableFileFilter(filter);

					// 파일오픈 다이얼로그 를 띄움
					int pic = fileChooser.showSaveDialog(window);
					System.out.println(pic);

					if (pic == JFileChooser.APPROVE_OPTION) {

						// 선택한 파일의 경로 반환

						File selectedFile = fileChooser.getSelectedFile();
						String filePath = fileChooser.getSelectedFile().getPath();
						// stu_pic.setIcon(new ImageIcon(filePath));

						// 가져온 사진 사이즈 맞춰주기
						ImageIcon pic2 = new ImageIcon(filePath);
						Image img = pic2.getImage();
						Image changeImg = img.getScaledInstance(160, 144, Image.SCALE_SMOOTH);
						ImageIcon changeIcon = new ImageIcon(changeImg);
						stu_pic.setIcon(changeIcon);

						// 경로 출력 - DB에 스트링타입으로 넣는 용도로 쓸 것이다.
						System.out.println(selectedFile);
					}

				}
			}
		});
		stu_pic.setFont(new Font("굴림", Font.PLAIN, 21));
		stu_pic.setBackground(new Color(255, 255, 255));
		stu_pic.setBounds(37, 96, 138, 155);
		contentPane.add(stu_pic);

		JLabel lblNewLabel = new JLabel("* 이름과 출석번호는 필수 입력사항입니다.");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(37, 60, 365, 26);
		contentPane.add(lblNewLabel);

		JLabel day_label = new JLabel("등원요일");
		day_label.setFont(new Font("굴림", Font.BOLD, 12));
		day_label.setBounds(37, 390, 57, 15);
		contentPane.add(day_label);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(397, 428, 17, 81);
		contentPane.add(scrollBar);

		JTextArea s_memo_1 = new JTextArea(); // 메모할 때는 텍스트에어리어 텍스트필드쓰면 엔터가 안된다.
		s_memo_1.setLineWrap(true); // 한줄이 너무 길면 자동으로 개행할지 설정
		// JScrollPane scrollPane = new JScrollPane(s_memo);
		// contentPane.add(scrollPane);
		s_memo_1.setForeground(new Color(112, 128, 144));
		s_memo_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (s_memo_1.getText().equals(" * 특이사항 메모")) {
					s_memo_1.setText("");
					s_memo_1.setForeground(new Color(153, 153, 153));
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (s_memo_1.getText().equals("")) {
					s_memo_1.setText(" * 특이사항 메모");
					s_memo_1.setForeground(new Color(153, 153, 153));
				}
			}
		});
		s_memo_1.setFont(new Font("굴림", Font.PLAIN, 16));
		s_memo_1.setText(" * 특이사항 메모");
		s_memo_1.setToolTipText("");
		s_memo_1.setBounds(37, 427, 377, 82);
		contentPane.add(s_memo_1);
		s_memo_1.setColumns(10);

		// 생일 날짜 달력
		JDateChooser birth_dateChooser = new JDateChooser();
		birth_dateChooser.setBounds(189, 215, 224, 29);
		contentPane.add(birth_dateChooser);

		// 생년월일 라벨
		JLabel lblNewLabel_1_1 = new JLabel("생년월일");
		birth_dateChooser.add(lblNewLabel_1_1, BorderLayout.WEST);
		lblNewLabel_1_1.setFont(new Font("함초롬돋움", Font.PLAIN, 16));

		// 등록날짜 달력
		JDateChooser enter_dateChooser = new JDateChooser();
		enter_dateChooser.setBounds(77, 339, 290, 29);
		contentPane.add(enter_dateChooser);

		JLabel enter_label = new JLabel("학원 등록일");
		enter_dateChooser.add(enter_label, BorderLayout.WEST);
		enter_label.setFont(new Font("함초롬돋움", Font.PLAIN, 16));

		JButton s_save_btn = new JButton("저장");
		s_save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		s_save_btn.setEnabled(false); // 출석번호 중복확인 해야지만 정보 저장할 수 있도록 하기
		s_save_btn.setFont(new Font("함초롬바탕", Font.PLAIN, 16));
		s_save_btn.setBounds(155, 645, 144, 46);
		contentPane.add(s_save_btn);

		// 출석번호 중복여부 버튼
		JButton StunumCheck = new JButton("중복 확인");
		StunumCheck.setBackground(new Color(255, 240, 245));
		StunumCheck.setBounds(320, 300, 104, 29);
		StunumCheck.setFont(new Font("굴림", Font.PLAIN, 14));
		StunumCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 트루이면 중복, false이면 새로 생성
				boolean user = new StudentDAO().StuNumCheck(stu_num.getText());

				// 입력받은 출석번호가 숫자가 아닐 경우 - 입력된 문자열이 숫자인지 문자가 섞여있는지 판단하는 코드를 작성
				char temp = 0;
				boolean flag = true;
				for (int i = 0; i < stu_num.getText().length(); i++) {
					temp = stu_num.getText().charAt(i); // 입력한 str을 문자로 쪼개서 temp로 받기
					if (temp < '0' || temp > '9') {// temp의 값이 '0'작거나 '9'보다 클 경우
						flag = false;
						break;
					}
				}
				if (flag == false) {
					JOptionPane.showMessageDialog(null, "번호는 '숫자' 4자리입니다.\r\n다시 입력해주세요.");
				} else if (stu_num.getText().length() != 4) {
					JOptionPane.showMessageDialog(null, "번호는 숫자 '4자리'입니다.\r\n다시 입력해주세요.");
				} else if (user == true) {
					JOptionPane.showMessageDialog(null, "이미 사용중인 번호입니다.\n다른번호를 입력해주세요.");
				} else if (user == false) {
					JOptionPane.showMessageDialog(null, "사용가능한 번호입니다.");
					s_save_btn.setEnabled(true);
				}

			}
		});

		contentPane.add(StunumCheck);

		s_save_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 학생 나이 구하기
				// 현재 날짜 구하기
				LocalDate current_date = LocalDate.now();
				int current_Year = current_date.getYear();
				// System.out.println("Current year: "+current_Year);
				// }

				if (s_name.getText().equals(" * 이름을 입력해주세요.")) {
					JOptionPane.showMessageDialog(null, "이름은 필수 항목입니다.\r\n이름을 입력해주세요.", "저장 실패!",
							JOptionPane.ERROR_MESSAGE);
				} else if (s_name.getText().length() > 12) {
					JOptionPane.showMessageDialog(null, "이름을 10글자 이하로 입력해주세요.", "저장 실패!", JOptionPane.ERROR_MESSAGE);
				
				} else {

					String age = "enter_dateChooser.getJCalendar().getYearChooser().getYear()-current_date.getYear()+1세";
					String birth = (birth_dateChooser.getJCalendar().getYearChooser().getYear() + "/"
							+ birth_dateChooser.getJCalendar().getMonthChooser().getMonth() + "/"
							+ birth_dateChooser.getJCalendar().getDayChooser().getDay());

					String enter_date = (enter_dateChooser.getJCalendar().getYearChooser().getYear() + "/"
							+ enter_dateChooser.getJCalendar().getMonthChooser().getMonth() + "/"
							+ enter_dateChooser.getJCalendar().getDayChooser().getDay());

					// 라디오 체크박스 남자인지 여자인지 값가져오기 위한 작업
					JLabel gender = new JLabel();
					if (s_boy_check.isSelected()) {
						gender = new JLabel(s_boy_check.getText());
					} else if (s_girl_check.isSelected()) {
						gender = new JLabel(s_girl_check.getText());
					}

					// 디비에 학생 정보 추가값넣기
					StudentVo vo = new StudentVo(stu_num.getText(), s_name.getText(), gender.getText(), age,
							s_school.getText(), s_grade.getText(), s_class.getText(), birth, days, address.getText(),
							enter_date, s_call_num.getText(),
							s_guardian1.getText() + s_who_guardian1.getSelectedItem().toString(),
							s_guardian1_call.getText(),
							s_guardian2.getText() + s_who_guardian2.getSelectedItem().toString(),
							s_guardian2_call.getText(), s_memo.getText(), s_memo.getText());

					boolean b = dao.add_stu_info(vo);

					// 회원가입 성공했다는 알림 띄우기
					if (b == false) {

						int result = JOptionPane.showConfirmDialog(null, "학생 정보를 추가하시겠습니까?", "오!출석 - 학생 추가하기",
								JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.CLOSED_OPTION) {

						} else if (result == JOptionPane.YES_OPTION) {
							addStudentPage addstudent = new addStudentPage(); // 홈화면 호출
							addstudent.setVisible(true);
						}

					}
				}
			}
		});

	}
}