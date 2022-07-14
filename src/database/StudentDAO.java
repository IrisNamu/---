package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class StudentDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement ps;
	private Statement st;

	// [출석번호로 학생이름 찾기]
	public ArrayList<StudentVo> number_name(String num) {
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		try {
			// 연결
			connDB();
			// SQL 문장 전송
			String sql = "SELECT stuname FROM STUDENT WHERE STUNUMBER LIKE '%" + num + "%'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StudentVo vo = new StudentVo();
				vo.setStuName(rs.getString("STUNAME"));
				list.add(vo);

			}
			;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// [add_student]학생정보추가 페이지
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
			rs = stmt.executeQuery(query);

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

	// 출석번호 중복 확인 여부
	public boolean StuNumCheck(String stuNumber) {
		try {
			connDB(); // 디비랑 연결을 해준다.

			// SELECT * FROM LOGIN
			// WHERE id='a';

			String query = "SELECT * FROM STUDENT WHERE stuNumber='" + stuNumber + "'";
			rs = stmt.executeQuery(query);
			rs.last();
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

	// [stunumber] 학생이 번호로 출석할 떄 등원정보넘기기
	public boolean Insert_attendance_Info(StudentVo s) {
		try {
			connDB();
			String query = "INSERT INTO attendance(stuNumber, today, attendance_info,  attendance_time) " + "values('"
					+ s.getStuNumber() + "','" + s.getToday() + "','" + s.getAttendance_info() + "','"
					+ s.getAttendance_time() + "')";
			rs = stmt.executeQuery(query);

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

	// [출석 작은 화면] 선생님이 춠헉
	public boolean att_btn(StudentVo s) {
		try {
			connDB();
			String query = "INSERT INTO attendance(stuNumber, today, attendance_info, attendance_time, Reason_for_absence) "
					+ "values('" + s.getStuNumber() + "','" + s.getToday() + "','" + s.getAttendance_info() + "','"
					+ s.getAttendance_time() + "','" + s.getReason_for_absence() + "')";
			rs = stmt.executeQuery(query);

			if (rs.getRow() == 0) {
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	// [원생관리]수강생 리스트 보여주는 테이블(이름순)
	public String[][] getStudent() {

//		rs.last();
//		int rowCount = rs.getRow();
//		Connection con = getConnection();
		try {
			connDB();

			String query = "SELECT * FROM STUDENT ORDER BY stuname";

			PreparedStatement statement = con.prepareStatement(
					"stuNumber, stuName, sex, age, school, grade, className, Birth, when_day, ADDRESS, ENTER_DATE, student_call, "
							+ "guardian1, guardian1_call, guardian2, guardian2_call, stu_memo FROM student");
			ResultSet results = statement.executeQuery(query); // 쿼리 실행 결과를 받아야하기때문에 데이터베이스에 접속, 그걸

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("stuName"),
						results.getString("sex"), results.getString("age"), results.getString("school"),
						results.getString("grade"), results.getString("className"), results.getString("Birth"),
						results.getString("when_day"), results.getString("ADDRESS"), results.getString("ENTER_DATE"),
						results.getString("student_call"), results.getString("guardian1"),
						results.getString("guardian1_call"), results.getString("guardian1"),
						results.getString("guardian2"), results.getString("guardian2_call"),
						results.getString("stu_memo")

				});
			}
			String[][] arr = new String[list.size()][17];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// [출석화면] 출석할 수강생 리스트 보여주는 테이블(이름순)
	public String[][] att_stulList() {

		try {
			connDB();

			String query = "SELECT * FROM STUDENT ORDER BY stuname";

			PreparedStatement statement = con.prepareStatement(
					"s.stuNumber, s.stuName, a.attendance_info, a.attendance_time FROM student s, attendance a");
			ResultSet results = statement.executeQuery(query); // 쿼리 실행 결과를 받아야하기때문에 데이터베이스에 접속, 그걸

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("stuName"),
						results.getString("age"), results.getString("attendance_info"),
						results.getString("attendance_time") });
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("att_stulList 실패");
			return null;
		}
	}

	// [출석화면] [전체 버튼 ]아이들의 출석 정보를 보여주는 테이블(이름순)
	public String[][] attendance_table_all(String day) {

		try {
			connDB();

			String query = "SELECT STUNUMBER, stuname, age, WHEN_day" + "	FROM STUDENT" + "	WHERE WHEN_DAY LIKE '%"
					+ day + "%' ORDER BY stuname";

			PreparedStatement statement = con.prepareStatement(" STUNUMBER, stuname, age, WHEN_day");
			ResultSet results = statement.executeQuery(query);

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("stuname"),
						results.getString("age"), results.getString("WHEN_day") });
			}
			String[][] arr = new String[list.size()][4];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// [출석화면][등원버튼]등원한 친구들 테이블(이름순)
	public String[][] attendance_student(String day, String date) {

		try {
			connDB();

			String query = "SELECT s.stunumber, s.stuname, s.age, a.attendance_info, a.attendance_time"
					+ " FROM STUDENT s" + " LEFT OUTER" + " JOIN ATTENDANCE a" + " ON s.STUNUMBER =a.STUNUMBER"
					+ " WHERE WHEN_DAY LIKE '%" + day + "%' AND TODAY LIKE '%" + date
					+ "%' AND attendance_info LIKE '%출석%' ORDER BY stuname";

			PreparedStatement statement = con
					.prepareStatement("stuNumber, stuName, age, attendance_info, attendance_time");
			ResultSet results = statement.executeQuery(query);

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("stuname"),
						results.getString("age"), results.getString("attendance_info"),
						results.getString("attendance_time") });
			}
			String[][] arr = new String[list.size()][4];
			// System.out.println(list.size());
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// [출석화면] [검색버튼] 이름 찾기(이름순)
	public ArrayList<StudentVo> search(String word) {
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		try {
			// 연결
			connDB();
			// SQL 문장 전송
			String sql = "SELECT stunumber, stuname, age, when_day" + " FROM STUDENT" + " WHERE STUNUMBER LIKE '%" + word
					+ "%' OR STUNAME LIKE '%" + word + "%' OR age LIKE '%" + word + "%' OR when_day LIKE '%" + word
					+ "%' ORDER BY STUNAME";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StudentVo vo = new StudentVo();
				vo.setStuNumber(rs.getString("stuNumber"));
				vo.setStuName(rs.getString("STUNAME"));
				vo.setAge(rs.getString("AGE"));
				vo.setWhen_day(rs.getString("when_day"));

				list.add(vo);
			}
			;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// [출석화면][미등원버튼] 미등원한 친구들 테이블(이름순)
	public String[][] will_come(String day, String date) {

		try {
			connDB();

			String query = " SELECT stuNumber, stuname, AGE,when_day"
					+ " FROM STUDENT S LEFT OUTER JOIN ATTENDANCE USING(STUNUMBER) WHERE WHEN_DAY LIKE '%" + day + "%'"
					+ " MINUS" + " SELECT stuNumber, stuname, AGE, when_day" + " FROM STUDENT s"
					+ " LEFT OUTER JOIN  ATTENDANCE a" + " using(stuNumber)" + " WHERE" + " attendance_info LIKE '%출석%'"
					+ " and today LIKE '%" + date + "%'";

			PreparedStatement statement = con.prepareStatement("stuNumber, stuName, age, when_day");
			ResultSet results = statement.executeQuery(query);

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("stuname"),
						results.getString("age"), results.getString("when_day") });
			}
			String[][] arr = new String[list.size()][4];
			// System.out.println(list.size());
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// [결석버튼]결석친구들
	public String[][] absence_stu(String day, String date) {

		try {
			connDB();

			String query = "SELECT stunumber, stuname, age, today, Reason_for_absence"
					+ " FROM STUDENT s LEFT OUTER JOIN ATTENDANCE" + " USING (stunumber)" + " WHERE WHEN_DAY LIKE '%"
					+ day + "%'" + " AND TODAY LIKE '%" + date + "%'"
					+ " and attendance_info LIKE '%결석%' order by stuname";

			PreparedStatement statement = con.prepareStatement("stuNumber, stuName, age, today, Reason_for_absence");
			ResultSet results = statement.executeQuery(query);

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("stuname"),
						results.getString("age"), results.getString("today"),
						results.getString("Reason_for_absence") });
			}
			String[][] arr = new String[list.size()][5];
			System.out.println("결석" + list.size());
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("결석안됨");
			return null;
		}
	}

	// [원생관리]전체검색
	public ArrayList<StudentVo> search_Info(String word) {
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		try {
			// 연결
			connDB();
			// SQL 문장 전송
			String sql = "SELECT * FROM STUDENT WHERE stuNumber LIKE '%" + word + "%'" + " or stuName LIKE '%" + word
					+ "%'" + " or sex LIKE '%" + word + "%'" + " or age LIKE '%" + word + "%'" + " or school LIKE '%"
					+ word + "%'" + " or grade LIKE '%" + word + "%'" + " or className LIKE '%" + word + "%'"
					+ " or birth LIKE '%" + word + "%'" + " or when_day LIKE '%" + word + "%'" + " or address LIKE '%"
					+ word + "%'" + " or enter_date LIKE '%" + word + "%'" + " or student_call LIKE '%" + word + "%'"
					+ " or guardian1 LIKE '%" + word + "%'" + " or guardian1_call LIKE '%" + word + "%'"
					+ " or guardian2 LIKE '%" + word + "%'" + " or guardian2_call LIKE '%" + word + "%'"
					+ " or stu_memo LIKE '%" + word + "%'";

			System.out.println(sql);
			rs = stmt.executeQuery(sql); // 쿼리 실행하면 ResultSet타입으로 반환을 해주어 결과값을 저장할 수 있다.

			while (rs.next()) {
				StudentVo vo = new StudentVo();

				vo.setStuNumber(rs.getString("stuNumber"));
				vo.setStuName(rs.getString("stuName"));
				vo.setSex(rs.getString("sex"));
				vo.setAge(rs.getString("AGE"));
				vo.setSchool(rs.getString("school"));
				vo.setGrade(rs.getString("grade"));
				vo.setClassName(rs.getString("className"));
				vo.setBirth(rs.getString("birth"));
				vo.setWhen_day(rs.getString("when_day"));
				vo.setAddress(rs.getString("address"));
				vo.setEnter_date(rs.getString("enter_date"));
				vo.setStudent_call(rs.getString("student_call"));
				vo.setGuardian1(rs.getString("guardian1"));
				vo.setGuardian1_call(rs.getString("guardian1_call"));
				vo.setGuardian2(rs.getString("guardian2"));
				vo.setGuardian2_call(rs.getString("guardian2_call"));
				vo.setStu_memo(rs.getString("stu_memo"));

				list.add(vo);
			}
			;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// [결제관리] 출석번호 찾기위한 검색버튼
	public ArrayList<StudentVo> search_num(String word) {
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		try {
			// 연결
			connDB();
			// SQL 문장 전송
			String sql = "SELECT * FROM STUDENT WHERE STUNUMBER LIKE '%" + word + "%'" + "	OR STUNAME LIKE '%" + word
					+ "%'" + "	OR age LIKE '%" + word + "%'" + " ORDER BY STUNAME";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StudentVo vo = new StudentVo();
				vo.setStuNumber(rs.getString("stuNumber"));
				vo.setStuName(rs.getString("STUNAME"));
				vo.setAge(rs.getString("AGE"));

				list.add(vo);

			}
			;

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.getStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// [원생관리] 원생 정보 삭제
	public int student_Delete(String number) {
		int result = 0;
		try {
			ps = con.prepareStatement("delete student where stunumber ='" + number + "'");
			ps.setString(1, number.trim());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e + "=> student_Delete fail");
		} finally {
			dbClose();
		}

		return result;
	}// userDelete()

//	// [원생관리] 원생 정보 수정
//	public int userUpdate() {
//		int result = 0;
//		String sql = "UPDATE student SET NAME=?, age=? , addr=? WHERE id=?";
//
//		try {
//			ps = con.prepareStatement(sql);
//			// ?의 순서대로 값 넣기
//			ps.setString(1, user.name.getText());
//			ps.setString(2, user.age.getText());
//			ps.setString(3, user.addr.getText());
//			ps.setString(4, user.id.getText().trim());
//
//			// 실행하기
//			result = ps.executeUpdate();
//
//		} catch (SQLException e) {
//			System.out.println(e + "=> userUpdate fail");
//		} finally {
//			dbClose();
//		}
//
//		return result;
//	}// userUpdate()

	// 연결
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

	/**
	 * DB닫기 기능 메소드
	 */
	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
			System.out.println(e + "=> dbClose fail");
		}
	}// dbClose() ---

	public static void main(String[] args) {
		StudentDAO sdao = new StudentDAO();
		sdao.search_Info(null);
	}

}