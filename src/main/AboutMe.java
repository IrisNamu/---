package main;

import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AboutMe extends JFrame {

	private JPanel contentPane;

	public AboutMe() {
		setTitle("안녕하세요? 송유진입니다.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomeLogin.class.getResource("/img/app_icon.png")));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 752);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// https://github.com/IrisNamu

		JButton backBtn = new JButton("<");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new HomeLogin();
				dispose();
			}
		});
		backBtn.setForeground(Color.WHITE);
		backBtn.setFont(new Font("배달의민족 주아", Font.BOLD, 34));
		backBtn.setBorderPainted(false);
		backBtn.setBackground(Color.GRAY);
		backBtn.setBounds(383, 0, 67, 58);
		contentPane.add(backBtn);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AboutMe.class.getResource("/img/about_me.png")));
		lblNewLabel.setBounds(-12, 0, 462, 713);
		contentPane.add(lblNewLabel);
	}

	private void jLabelWebpageMouseClicked(java.awt.event.MouseEvent evt) {
		if (Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				URI uri = new URI("https://github.com/IrisNamu");
				desktop.browse(uri);
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (URISyntaxException ex) {
				ex.printStackTrace();
			}
		}
	}
}