import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ddddd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	//
	                  File selectedFile = fileChooser.getSelectedFile(); // 지역변수 이프문안세만 클래스의 멤버변수로 바꾸기
	                  String filePath = fileChooser.getSelectedFile().getPath();
	                   stu_pic.setIcon(new ImageIcon(filePath));

	                  // 가져온 사진 사이즈 맞춰주기
	                  ImageIcon pic2 = new ImageIcon(filePath);
	                  Image img = pic2.getImage();
	                  Image changeImg = img.getScaledInstance(170, 180, Image.SCALE_SMOOTH);
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
	      stu_pic.setBounds(37, 96, 146, 175);
	      //contentPane.add(stu_pic);
	}

}
