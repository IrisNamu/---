import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.MemberDAO;
import database.MemberVo;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SignUp extends JFrame {
	private MemberDAO dao;

	private JPanel contentPane;
	private JButton backBtn;
	private JTextField mail;
	private JTextField id_SignUP;
	private JPasswordField password_SignUp;
	private JPasswordField check_password;
	private JLabel tf_pwd_double_check;
	private JLabel tf_mailInput;
	private JLabel ID_duplicate_Msg;
	private JLabel tf_pwd_Msg;
	private JButton SignUp_Btn;
	private JButton IDCheck_btn;
	private JTextField name_field;
	private JLabel tf_name_Msg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		dao = new MemberDAO();

		setIconImage(
				Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/img/\uC571\uC544\uC774\uCF58.png")));
		setTitle("\uC624! \uCD9C\uC11D - \uD559\uC0DD\uAD00\uB9AC\uC2DC\uC2A4\uD15C ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		backBtn = new JButton("<");
		backBtn.setForeground(new Color(255, 255, 255));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home_Login h = new Home_Login(); // 홈화면 호출
				h.setVisible(true);

			}
		});

		// 사용자가 입력할 정보들
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		backBtn.setBackground(new Color(204, 204, 255));
		backBtn.setBounds(394, 0, 56, 29);
		contentPane.add(backBtn);

		name_field = new JTextField(10);
		name_field.setColumns(10);
		name_field.setBounds(22, 43, 356, 38);
		contentPane.add(name_field);

		id_SignUP = new JTextField(10);
		id_SignUP.setColumns(10);
		id_SignUP.setBounds(12, 174, 356, 38);
		contentPane.add(id_SignUP);

		password_SignUp = new JPasswordField(10);
		password_SignUp.setBounds(12, 291, 356, 38);
		contentPane.add(password_SignUp);

		check_password = new JPasswordField(10);
		check_password.setBounds(12, 411, 356, 38);
		contentPane.add(check_password);

		mail = new JTextField(20);
		mail.setBounds(12, 528, 356, 38);
		contentPane.add(mail);
		mail.setColumns(10);

		// 알림 문구 띄우는 라벨
		tf_name_Msg = new JLabel("");
		tf_name_Msg.setForeground(Color.RED);
		tf_name_Msg.setBounds(22, 111, 356, 20);
		contentPane.add(tf_name_Msg);

		ID_duplicate_Msg = new JLabel("");
		ID_duplicate_Msg.setForeground(Color.RED);
		ID_duplicate_Msg.setBounds(12, 217, 356, 20);
		contentPane.add(ID_duplicate_Msg);

		tf_pwd_Msg = new JLabel("");
		tf_pwd_Msg.setForeground(Color.RED);
		tf_pwd_Msg.setBounds(12, 339, 356, 20);
		contentPane.add(tf_pwd_Msg);

		tf_pwd_double_check = new JLabel("");
		tf_pwd_double_check.setForeground(Color.RED);
		tf_pwd_double_check.setBounds(12, 459, 356, 20);
		contentPane.add(tf_pwd_double_check);

		tf_mailInput = new JLabel("");
		tf_mailInput.setForeground(Color.RED);
		tf_mailInput.setBounds(12, 576, 356, 20);
		contentPane.add(tf_mailInput);

		// 회원가입 버튼을 누르면 발생하는 모든 변수들 처리하기
		SignUp_Btn = new JButton("회원가입 하기");
		SignUp_Btn.setBackground(new Color(255, 240, 245));
		SignUp_Btn.setFont(new Font("배달의민족 주아", Font.BOLD, 18));

		SignUp_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 글자수제한 알림창 띄어주기
				String name_length = name_field.getText();
				String ID_length = id_SignUP.getText();
				String password_length = password_SignUp.getText();
				String mail_length = mail.getText();

				// 트루이면 중복, false이면 새로 생성
				boolean user = new MemberDAO().IDCheck(id_SignUP.getText());
				// 멤버다오에 있는 아이디체크메서드 사용하기위해 호출

				// 회원가입 실패사유 알려주기
				if (name_field.getText().equals("")) {
					tf_name_Msg.setText("이름을 입력하세요.");
					JOptionPane.showMessageDialog(null, "이름을 입력하세요..", "회원가입 실패!", JOptionPane.ERROR_MESSAGE);

					// 더블체크 틀렸다고 알려주기^^
				} else if (!password_SignUp.getText().equals(check_password.getText())) {
					tf_pwd_double_check.setText("비밀번호가 동일하지 않습니다.");
					JOptionPane.showMessageDialog(null, "비밀번호가 동일하지 않습니다.", "회원가입 실패!", JOptionPane.ERROR_MESSAGE);

				} else if (id_SignUP.getText().equals("")) {
					ID_duplicate_Msg.setText("아이디를 입력하세요.");
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요.", "회원가입 실패!", JOptionPane.ERROR_MESSAGE);

				} else if (user == true) {
					ID_duplicate_Msg.setText("중복된 아이디입니다.");
					JOptionPane.showMessageDialog(null, "중복된 아이디입니다.", "회원가입 실패!", JOptionPane.ERROR_MESSAGE);

				} else if (password_SignUp.getText().equals("")) {
					tf_pwd_Msg.setText("비밀번호를 입력하세요.");
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요.", "회원가입 실패!", JOptionPane.ERROR_MESSAGE);

				} else if (check_password.getText().equals("")) {
					tf_pwd_double_check.setText("비밀번호를 한번 더 입력하세요.");
					JOptionPane.showMessageDialog(null, "비밀번호를 한번 더 입력하세요.", "회원가입 실패!", JOptionPane.ERROR_MESSAGE);

				} else if (mail.getText().equals("")) {
					tf_mailInput.setText("메일주소를 입력하세요.");
					JOptionPane.showMessageDialog(null, "메일주소를 입력하세요.", "회원가입 실패!", JOptionPane.ERROR_MESSAGE);

				} else if (name_length.length() > 10) {
					tf_name_Msg.setText("이름을 10글자 이내로 입력해주세요.");
					JOptionPane.showMessageDialog(null, "이름을 10글자 이내로 입력해주세요.", "회원가입 실패!", JOptionPane.ERROR_MESSAGE);
				} else if (ID_length.length() > 10) {
					ID_duplicate_Msg.setText("ID를 10글자 이내로 입력해주세요.");
					JOptionPane.showMessageDialog(null, "ID를 10글자 이내로 입력해주세요.", "회원가입 실패!", JOptionPane.ERROR_MESSAGE);
				} else if (password_length.length() > 10) {
					tf_pwd_Msg.setText("비밀번호를 10글자 이내로 입력해주세요.");
					JOptionPane.showMessageDialog(null, "비밀번호를 10글자 이내로 입력해주세요.", "회원가입 실패!",
							JOptionPane.ERROR_MESSAGE);
				} else if (mail_length.length() > 30) {
					tf_mailInput.setText("메일주소를 30글자 이내로 입력해주세요.");
					JOptionPane.showMessageDialog(null, "메일주소를 30글자 이내로 입력해주세요.", "회원가입 실패!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// 디비값넣기
					MemberVo vo = new MemberVo(name_field.getText(), id_SignUP.getText(), password_SignUp.getText(),
							mail.getText());
					boolean b = dao.SignUp(vo);


					// 회원가입 성공했다는 알림 띄우기
					if (b == false) {

						JOptionPane alert = new JOptionPane();
						alert.showMessageDialog(null,
								name_field.getText() + "님!\n회원가입을 축하합니다. \n메인화면으로 돌아가 로그인을 해주세요.");
						dispose();
						Home_Login attendance = new Home_Login(); // 홈화면 호출
						attendance.setVisible(true);

					}
				}
			}
		});

		SignUp_Btn.setBounds(131, 637, 151, 47);
		contentPane.add(SignUp_Btn);

		// 중복확인 버튼 누르면 아이디가 중복되는지 알려준다.
		IDCheck_btn = new JButton("중복 확인");
		IDCheck_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// 트루이면 중복, false이면 새로 생성
				boolean user = new MemberDAO().IDCheck(id_SignUP.getText());
				// 멤버다오에 있는 아이디체크메서드 사용하기위해 호출

				if (user == true) {
					ID_duplicate_Msg.setText("중복된 아이디입니다.");
				} else {
					ID_duplicate_Msg.setText(id_SignUP.getText() + " 는 사용 가능한 아이디 입니다.");
				}

			}
		});
		IDCheck_btn.setBackground(new Color(255, 240, 245));
		IDCheck_btn.setBounds(131, 141, 97, 23);
		contentPane.add(IDCheck_btn);

		JLabel backgroud = new JLabel("");
		backgroud.setBounds(0, 0, 450, 713);
		backgroud.setIcon(new ImageIcon(SignUp.class.getResource("/img/\uD68C\uC6D0\uAC00\uC785\uCC3D.png")));
		contentPane.add(backgroud);
	}
}