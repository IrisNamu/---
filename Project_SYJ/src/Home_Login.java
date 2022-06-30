import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.TextField;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;

//import Login.MemberDA;
import database.MemberDAO;
import database.MemberVo;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Home_Login extends JFrame {

	private MemberDAO dao;

	private JButton Login_btn;
	private JButton joinBtn;
	private JButton moreBtn;
	private JTextField textField;
	private JLabel backgroud;
	private JPasswordField password_Field;
	private JPanel more_Aboutme;
	private JLabel more_aboutMe_img;
	private JTextField ID_field;
	private JTextField tfMsg;

	private final String correct_id = "green";
	private final String correct_pwd = "green1234";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_Login frame = new Home_Login();
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
	public Home_Login() {

		dao = new MemberDAO();

		setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		setTitle("\uC624! \uCD9C\uC11D - \uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C ");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Home_Login.class.getResource("/img/\uC571\uC544\uC774\uCF58.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);

		JPanel Main_home = new JPanel();
		Main_home.setBounds(0, 0, 450, 709);
		getContentPane().add(Main_home);
		Main_home.setLayout(null);

		joinBtn = new JButton("\uD68C\uC6D0\uAC00\uC785 \uD558\uAE30");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				SignUp s = new SignUp();
				s.setVisible(true);
			}
		});

		joinBtn.setFont(new Font("배달의민족 주아", Font.PLAIN, 18));
		joinBtn.setBackground(new Color(204, 204, 255));
		joinBtn.setBounds(147, 623, 170, 42);
		Main_home.add(joinBtn);

		moreBtn = new JButton("\uC790\uC138\uD788...");
		moreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				more_Aboutme.setVisible(true); // 자세히 페이지 안보이게
				Main_home.setVisible(false);

			}
		});

		moreBtn.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 12));
		moreBtn.setBackground(new Color(204, 204, 255));
		moreBtn.setBounds(354, 682, 84, 23);
		Main_home.add(moreBtn);

		textField = new JTextField();
		textField.setText("  Copyright 2022.\uC1A1\uC720\uC9C4 All rights reserved.");
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);
		textField.setBackground(new Color(204, 204, 255));
		textField.setBounds(0, 678, 450, 31);
		Main_home.add(textField);

		// 아이디입력
		ID_field = new JTextField(10); // 10글자 제한
		ID_field.setForeground(Color.WHITE);
		ID_field.setBackground(Color.DARK_GRAY);
		ID_field.setBounds(77, 530, 214, 21);
		Main_home.add(ID_field);
		ID_field.setColumns(10);

		// 패스워드입력
		password_Field = new JPasswordField(10); // 10글자 제한
		password_Field.setForeground(Color.WHITE);
		password_Field.setBackground(Color.DARK_GRAY);
		password_Field.setBounds(77, 561, 214, 21);
		password_Field.setEchoChar('●');
		Main_home.add(password_Field);

		Login_btn = new JButton("\uB85C \uADF8 \uC778");

		Login_btn.addActionListener(new ActionListener() {

			// 아이디 입력했는지? 비밀번호 입력했는지? 확인하는 문구
			public void actionPerformed(ActionEvent e) {

				if (ID_field.getText().equals("")) {
					tfMsg.setText("ID를 입력하세요.");
				} else if (password_Field.equals("")) {
					tfMsg.setText("Password를 입력하세요.");
				} else {
					System.out.println(ID_field.getText());
					System.out.println(password_Field);

					MemberVo vo = new MemberVo(ID_field.getText(), password_Field.getText());
					
					//로그인에 성공하면 화면으로 넘어가고 아니라면 다시 입력하라고하기
					boolean b = dao.list(vo);
					if(b==true) {
						tfMsg.setText("로그인 성공");
						dispose();
						attendance_Main attendance = new attendance_Main(); //홈화면 호출
						attendance.setVisible(true);
						
					}else if(b==false) {
						tfMsg.setText("아이디/비밀번호가 틀렸습니다.");
						
					}
				}
			}
			
		});

		Login_btn.setForeground(Color.BLACK);
		Login_btn.setFont(new Font("배달의민족 주아", Font.PLAIN, 19));
		Login_btn.setBackground(new Color(216, 191, 216));
		Login_btn.setBounds(303, 530, 97, 52);
		Main_home.add(Login_btn);

		tfMsg = new JTextField(40);
		tfMsg.setForeground(new Color(255, 0, 0));
		tfMsg.setBackground(new Color(250, 250, 210));
		tfMsg.setHorizontalAlignment(SwingConstants.CENTER);
		tfMsg.setBounds(77, 592, 323, 21);
		Main_home.add(tfMsg);
		tfMsg.setColumns(10);
		tfMsg.setEditable(false);
		tfMsg.setFocusable(false);

		backgroud = new JLabel("");
		backgroud.setIcon(new ImageIcon(Home_Login.class.getResource("/img/\uB85C\uADF8\uC778\uD654\uBA74_.png")));
		backgroud.setBounds(0, 0, 450, 713);
		Main_home.add(backgroud);

		more_Aboutme = new JPanel();
		more_Aboutme.setBounds(0, 0, 450, 709);
		getContentPane().add(more_Aboutme);
		more_Aboutme.setLayout(null);
		more_Aboutme.setVisible(false); // 자세히 페이지 안보이게

		JButton backBtn = new JButton("\uB4A4\uB85C\uAC00\uAE30");

		backBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				more_Aboutme.setVisible(false); // 자세히 페이지 안보이게
				Main_home.setVisible(true);

			}
		});
		backBtn.setBackground(new Color(204, 204, 255));
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 13));
		backBtn.setBounds(350, 5, 97, 23);
		more_Aboutme.add(backBtn);

		more_aboutMe_img = new JLabel("");
		more_aboutMe_img.setIcon(new ImageIcon(Home_Login.class.getResource("/img/\uC790\uAE30\uC18C\uAC1C.png")));
		more_aboutMe_img.setBounds(0, 0, 450, 713);
		more_Aboutme.add(more_aboutMe_img);
	}
}
