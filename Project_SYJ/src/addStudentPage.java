import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JList;

public class addStudentPage extends JFrame {

	private JPanel contentPane;
	private JTextField s_name;
	private JTextField s_memo;
	private JTextField s_roll_num;
	private JTextField s_guardian1_call;
	private JTextField s_guardian2_call;
	private JTextField s_guardian3_call;

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
				 attendance_Main attendance = new attendance_Main(); //홈화면 호출
				 attendance.setVisible(true);
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 17));
		backBtn.setBackground(new Color(204, 204, 255));
		backBtn.setBounds(394, 0, 56, 29);
		contentPane.add(backBtn);
		
		s_name = new JTextField();
		s_name.setBounds(74, 177, 224, 29);
		contentPane.add(s_name);
		s_name.setColumns(10);
		
		JComboBox s_year = new JComboBox();
		s_year.setBounds(74, 244, 90, 23);
		contentPane.add(s_year);
		
		JComboBox s_month = new JComboBox();
		s_month.setBounds(176, 244, 73, 23);
		contentPane.add(s_month);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(261, 244, 73, 23);
		contentPane.add(comboBox_2);
		
		JCheckBox s_boy_check = new JCheckBox("\uB0A8");
		s_boy_check.setBounds(306, 180, 43, 23);
		contentPane.add(s_boy_check);
		
		JCheckBox s_girl_check = new JCheckBox("\uC5EC");
		s_girl_check.setBounds(360, 180, 43, 23);
		contentPane.add(s_girl_check);
		
		JCheckBox s_mon = new JCheckBox("");
		s_mon.setHorizontalAlignment(SwingConstants.TRAILING);
		s_mon.setBounds(74, 309, 29, 29);
		contentPane.add(s_mon);
		
		JCheckBox s_tue = new JCheckBox("");
		s_tue.setHorizontalAlignment(SwingConstants.CENTER);
		s_tue.setBounds(107, 309, 29, 29);
		contentPane.add(s_tue);
		
		JCheckBox s_wed = new JCheckBox("");
		s_wed.setHorizontalAlignment(SwingConstants.CENTER);
		s_wed.setBounds(140, 309, 29, 29);
		contentPane.add(s_wed);
		
		JCheckBox s_thur = new JCheckBox("");
		s_thur.setHorizontalAlignment(SwingConstants.CENTER);
		s_thur.setBounds(171, 309, 29, 29);
		contentPane.add(s_thur);
		
		JCheckBox s_fri = new JCheckBox("");
		s_fri.setHorizontalAlignment(SwingConstants.CENTER);
		s_fri.setBounds(204, 309, 29, 29);
		contentPane.add(s_fri);
		
		JCheckBox s_sat = new JCheckBox("");
		s_sat.setHorizontalAlignment(SwingConstants.CENTER);
		s_sat.setBounds(237, 309, 29, 29);
		contentPane.add(s_sat);
		
		JCheckBox s_sun = new JCheckBox("");
		s_sun.setHorizontalAlignment(SwingConstants.CENTER);
		s_sun.setBounds(269, 309, 29, 29);
		contentPane.add(s_sun);
		
		JLabel lblNewLabel = new JLabel("\uC6D4\t\uD654\t\uC218\t\uBAA9\t\uAE08\t\uD1A0\t\uC77C\t");
		lblNewLabel.setBounds(74, 289, 266, 15);
		contentPane.add(lblNewLabel);
		
		s_memo = new JTextField();
		s_memo.setToolTipText("\uBA54\uBAA8\uB97C \uC785\uB825\uD558\uC138\uC694.");
		s_memo.setBounds(74, 355, 300, 40);
		contentPane.add(s_memo);
		s_memo.setColumns(10);
		
		s_roll_num = new JTextField();
		s_roll_num.setBounds(150, 422, 116, 21);
		contentPane.add(s_roll_num);
		s_roll_num.setColumns(10);
		
		JComboBox s_who_guardian1 = new JComboBox();
		s_who_guardian1.setBounds(50, 488, 73, 23);
		contentPane.add(s_who_guardian1);
		
		JComboBox s_who_guardian2 = new JComboBox();
		s_who_guardian2.setBounds(50, 538, 73, 23);
		contentPane.add(s_who_guardian2);
		
		JComboBox s_who_guardian3 = new JComboBox();
		s_who_guardian3.setBounds(50, 591, 73, 23);
		contentPane.add(s_who_guardian3);
		
		s_guardian1_call = new JTextField();
		s_guardian1_call.setColumns(10);
		s_guardian1_call.setBounds(140, 489, 116, 21);
		contentPane.add(s_guardian1_call);
		
		s_guardian2_call = new JTextField();
		s_guardian2_call.setColumns(10);
		s_guardian2_call.setBounds(140, 539, 116, 21);
		contentPane.add(s_guardian2_call);
		
		s_guardian3_call = new JTextField();
		s_guardian3_call.setColumns(10);
		s_guardian3_call.setBounds(140, 592, 116, 21);
		contentPane.add(s_guardian3_call);
		
		JButton s_save_btn = new JButton("\uC800\uC7A5");
		s_save_btn.setBounds(74, 680, 116, 23);
		contentPane.add(s_save_btn);
		
		JButton s_addMore_btn = new JButton("\uD559\uC0DD \uC815\uBCF4 \uCD94\uAC00");
		s_addMore_btn.setBounds(237, 680, 116, 23);
		contentPane.add(s_addMore_btn);
		
		JDateChooser s_dateChooser = new JDateChooser();
		s_dateChooser.setBounds(365, 244, 73, 21);
		contentPane.add(s_dateChooser);
		
		JLabel label = new JLabel("New label");
		label.setBounds(66, 492, 57, 15);
		contentPane.add(label);
		
		
	}
}
