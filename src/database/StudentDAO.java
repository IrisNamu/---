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

	// 출석번호 중복 확인 여부
	public boolean StuNumCheck(String stuNumber) {
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

	// [stunumber] 학생이 번호로 출석할 떄 등원정보넘기기
	public boolean Insert_attendance_Info(StudentVo s) {
		try {
			connDB();
			String query = "INSERT INTO attendance(stuNumber, attendance_info, today, attendance_time) " + "values('"
					+ s.getStuNumber() + "','" + s.getAttendance_info() + "','" + s.getToday() + "','"
					+ s.getAttendance_time() + "')";
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
			System.out.println("The data has been fetched");
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
	public String[][] attendance_table_all(String day, String date) {

		try {
			connDB();

			String query = "SELECT s.stunumber, s.stuname, s.age, a.attendance_info, a.attendance_time, a.TODAY,s.WHEN_DAY"
					+ " FROM STUDENT s" + " LEFT OUTER JOIN ATTENDANCE a" + " ON" + " s.STUNUMBER = a.STUNUMBER"
					+ " WHERE" + " WHEN_DAY LIKE '%" + day + "%'" + " AND today LIKE '%" + date + "%'" + " UNION"
					+ " SELECT s.stunumber, s.stuname, s.age, a.attendance_info, a.attendance_time, a.TODAY,s.WHEN_DAY"
					+ " FROM STUDENT s" + " LEFT OUTER JOIN ATTENDANCE a" + " ON" + " s.STUNUMBER = a.STUNUMBER"
					+ " WHERE" + " a.today IS NULL";

			PreparedStatement statement = con
					.prepareStatement("stuNumber, stuName, age, attendance_info, attendance_time");
			ResultSet results = statement.executeQuery(query);

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("stuname"),
						results.getString("age"), results.getString("attendance_info"),
						results.getString("attendance_time") });
			}
			System.out.println("메인화면 출석정보 테이블 잘나와요~");
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
			System.out.println("등원버튼 출석정보 테이블 잘나와요~");
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
			String sql = "SELECT * FROM STUDENT" + " WHERE" + "	STUNUMBER LIKE '%" + word + "%'"
					+ "	OR STUNAME LIKE '%" + word + "%'" + "	OR age LIKE '%" + word + "%'" + " ORDER BY STUNAME";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StudentVo vo = new StudentVo();
				vo.setStuNumber(rs.getString("stuNumber"));
				vo.setStuName(rs.getString("STUNAME"));
				vo.setAge(rs.getString("AGE"));

				list.add(vo);

//				System.out.println(list);
				vo.print();
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

//	// [출석화면][미등원버튼] 미등원한 친구들 테이블(이름순)
//	public String[][] will_come(String day) {
//
//		try {
//			connDB();
//
//			String query = " SELECT s.stunumber, s.stuname, s.age, a.attendance_info, a.attendance_time" + " FROM"
//					+ " STUDENT s" + " LEFT OUTER JOIN ATTENDANCE a" + " ON" + " s.STUNUMBER = a.STUNUMBER" + " WHERE"
//					+ " WHEN_DAY LIKE '%" + day + "%'" + " a.today IS NULL";
//
//			PreparedStatement statement = con
//					.prepareStatement("stuNumber, stuName, age, attendance_info, attendance_time");
//			ResultSet results = statement.executeQuery(query);
//
//			ArrayList<String[]> list = new ArrayList<String[]>();
//			while (results.next()) {
//				list.add(new String[] { results.getString("stuNumber"), results.getString("stuname"),
//						results.getString("age"), results.getString("attendance_info"),
//						results.getString("attendance_time") });
//			}
//			System.out.println("미등원 출석정보 테이블 잘나와요~");
//			String[][] arr = new String[list.size()][4];
//			// System.out.println(list.size());
//			return list.toArray(arr);
//
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			return null;
//		}
//	}

	// [결석버튼]결석친구들
	public String[][] absence_stu(String day, String date) {

		try {
			connDB();

			String query = "SELECT s.stunumber, s.stuname, s.age, a.attendance_info, a.Reason_for_absence " + " FROM"
					+ " STUDENT s" + " LEFT OUTER JOIN ATTENDANCE a" + " ON" + " s.STUNUMBER = a.STUNUMBER" + " WHERE"
					+ " WHEN_DAY LIKE '%" + day + "%'" + " AND TODAY LIKE '%" + date + "%'"
					+ " and attendance_info LIKE '%결석%'" + " order by stuname";

			PreparedStatement statement = con
					.prepareStatement("stuNumber, stuName, age, attendance_info, Reason_for_absence");
			ResultSet results = statement.executeQuery(query);

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("stuname"),
						results.getString("age"), results.getString("Reason_for_absence"),
						results.getString("attendance_time") });
			}
			System.out.println("결석버튼 출석정보 테이블 잘나와요~");
			String[][] arr = new String[list.size()][4];
			// System.out.println(list.size());
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// [attendanceMain] - 출석해야하는 아이들 이르스

	public ArrayList<StudentVo> who_come(String day) {
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		try {
			// 연결
			connDB();
			// SQL 문장 전송

			String sql = "SELECT s.stunumber, s.stuname, s.age, a.attendance_info, attendance_time" + " FROM STUDENT s"
					+ " LEFT OUTER" + " JOIN ATTENDANCE a" + " ON s.STUNUMBER =a.STUNUMBER" + " WHERE WHEN_DAY LIKE '%"
					+ day + "%'";

			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StudentVo vo = new StudentVo();
				vo.setStuNumber(rs.getString("stuNumber"));
				vo.setStuName(rs.getString("STUNAME"));
				vo.setAge(rs.getString("AGE"));
				vo.setAttendance_info(rs.getString("attendance_info"));
				vo.setAttendance_time(rs.getString("attendance_time"));

				list.add(vo);

//				System.out.println(list);
				vo.print();
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
			rs = stmt.executeQuery(sql);

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

//				System.out.println(list);
				vo.print();
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

	public void userSelectAll(DefaultTableModel t_model) {
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from TB_USERLIST order by id");

			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < t_model.getRowCount();) {
				t_model.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4) };

				t_model.addRow(data); // DefaultTableModel에 레코드 추가
			}

		} catch (SQLException e) {
			System.out.println(e + "=> userSelectAll fail");
		} finally {
			dbClose();
		}
	}// userSelectAll()

	// [원생관리] 원생 정보 삭제
	public int userDelete(String id) {
		int result = 0;
		try {
			ps = con.prepareStatement("delete TB_USERLIST where id = ? ");
			ps.setString(1, id.trim());
			result = ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e + "=> userDelete fail");
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