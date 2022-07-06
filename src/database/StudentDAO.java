package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;

	// 학생정보추가
	public boolean add_stu_info(StudentVo s) {
		try {
			connDB();

			String query = "INSERT INTO STUDENT(stuNumber, stuName, sex, age, school, grade, className, birth, when_day, address, enter_date, student_call, guardian1, guardian1_call, guardian2, guardian2_call, stu_memo, pic) "
					+ "values('" + s.getStuNumber() + "','" + s.getStuName() + "','" + s.getSex() + "','" + s.getAge()
					+ "','" + s.getSchool() + "','" + s.getGrade() + "','" + s.getClassName() + "','" + s.getBirth()
					+ "','" + s.getWhen_day() + "','" + s.getAddress() + "','" + s.getEnter_date() + "','"
					+ s.getStudent_call() + "','" + s.getGuardian1() + "','" + s.getGuardian1_call() + "','"
					+ s.getGuardian2() + "','" + s.getGuardian2_call() + "','" + s.getStu_memo() + "','" + s.getPic()
					+ "')";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected...");
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// 출석번호 중복
	public boolean StuNumCheck(String stuNumber) { // 회원정보 id를 받기
		try {
			connDB(); // 디비랑 연결을 해준다.

			// SELECT * FROM LOGIN
			// WHERE id='a';

			String query = "SELECT * FROM STUDENT WHERE stuNumber='" + stuNumber + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow()); // getRow 열과번호. a가 몇번재? 4번으로 출력
			// 검색안되면 0이된다. 번호가 1부터 시작 ....
			if (rs.getRow() == 0) {
				System.out.println("0 row selected..."); // 0이면 없는걸로 취급돼서
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// 출석버튼에 나타날 정보 String pic, String stuNumber, String stuName, String age, String
	// school, String grade,
	// String className, String when_day
//	public boolean attendance_Info_btn(StudentDAO p) {
//		try {
//			connDB();
//
//			String query = "SELECT * FROM login WHERE id='" + p.getId() + "' AND password='" + p.getPassword() + "'";
//			System.out.println("SQL : " + query);
//			rs = stmt.executeQuery(query);
//			rs.last();
//			System.out.println("rs.getRow() : " + rs.getRow());
//
//			if (rs.getRow() == 0) {
//				System.out.println("0 row selected...");
//			} else {
//				return true;
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return false;
//	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.\n");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}