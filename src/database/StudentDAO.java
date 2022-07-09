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

	// [stunumber] 학생이 번호로 출석
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

	// 수강생 리스트 보여주는 테이블
	public String[][] getStudent() {

//		rs.last();
//		int rowCount = rs.getRow();
//		Connection con = getConnection();
		try {
			connDB();

			String query = "SELECT * FROM STUDENT";

			PreparedStatement statement = con
					.prepareStatement("stuNumber, age, stuName, school, grade, className, when_day FROM student");
			ResultSet results = statement.executeQuery(query); // 쿼리 실행 결과를 받아야하기때문에 데이터베이스에 접속, 그걸

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("age"),
						results.getString("stuName"), results.getString("school"), results.getString("grade"),
						results.getString("className"), results.getString("when_day"), });
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][7];
			return list.toArray(arr);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	// [출석화면] 아이들의 출석 정보를 보여주는 테이블
	public String[][] attendance() {

		try {
			connDB();

			String query = "SELECT * FROM STUDENT";

			PreparedStatement statement = con
					.prepareStatement("stuNumber, age, stuName,school,grade,className,when_day");
			ResultSet results = statement.executeQuery(query); // 쿼리 실행 결과를 받아야하기때문에 데이터베이스에 접속, 그걸

			ArrayList<String[]> list = new ArrayList<String[]>();
			while (results.next()) {
				list.add(new String[] { results.getString("stuNumber"), results.getString("age"),
						results.getString("stuName"), results.getString("school"), results.getString("grade"),
						results.getString("className"), results.getString("when_day"), });
			}
			System.out.println("The data has been fetched");
			String[][] arr = new String[list.size()][7];
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

			String sql = "SELECT s.stuNumber, s.STUNAME, s.AGE, a.ATTENDANCE_INFO FROM STUDENT s, ATTENDANCE a WHERE WHEN_DAY LIKE '%"
					+ day + "%'";

			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StudentVo vo = new StudentVo();
				vo.setStuNumber(rs.getString("stuNumber"));
				vo.setStuName(rs.getString("STUNAME"));
				vo.setAge(rs.getString("AGE"));
				vo.setAttendance_info(rs.getString("attendance_info"));

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

	// 전체검색
	public ArrayList<StudentVo> search_Info(String word) {
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		try {
			// 연결
			connDB();
			// SQL 문장 전송
			String sql = "SELECT * FROM STUDENT WHERE STUNAME LIKE '%" + word + "%'";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				StudentVo vo = new StudentVo();
				vo.setStuNumber(rs.getString("stuNumber"));
				vo.setAge(rs.getString("AGE"));
				vo.setStuName(rs.getString("STUNAME"));
				vo.setSchool(rs.getString("SCHOOL"));
				vo.setGrade(rs.getString("GRADE"));
				vo.setClassName(rs.getString("CLASSNAME"));
				vo.setWhen_day(rs.getString("WHEN_DAY"));

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

//	public ArrayList<String> search_Info(String word) {
//		ArrayList<String> list = new ArrayList<String>();
//		try {
//			// 연결
//			connDB();
//			// SQL 문장 전송
//			// String sql = "SELECT * FROM STUDENT LIKE '%'||?||'%'";
////			String sql = "SELECT * FROM STUDENT " + "WHERE stuName LIKE '%'||?||'%'";
//			String query = "SELECT * FROM STUDENT";
//			rs = stmt.executeQuery(query);
////			ps = con.prepareStatement(sql);
////			ps.setString(1, stuName);
////			ResultSet rs = ps.executeQuery();// 실행
//
//			while (rs.next()) {
//
////				StudentVo vo = new StudentVo();
////
////				vo.setStuNumber(rs.getString(1));
////				vo.setAge(rs.getString(2));
////				vo.setStuName(rs.getString(3));
////				vo.setSchool(rs.getString(4));
////				vo.setGrade(rs.getString(5));
////				vo.setWhen_day(rs.getString(6));
////				vo.setClassName(rs.getString(7));
////
////				list.add(vo);
//
//				list.add(rs.getString(2));
//
//				System.out.println(list);
//			}
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		} finally {
//			dbClose();
//		}
//		return list;
//	}

//	public boolean search_Info(String stuName) {
//		try {
//			connDB();
//			String query = "select * from student where like stuName '%'||?||'%'";
//
//			System.out.println("SQL : " + query);
//			rs = stmt.executeQuery(query);
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

	/**
	 * userlist의 모든 레코드 조회
	 */
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

	/**
	 * ID에 해당하는 레코드 삭제하기
	 */
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

	/**
	 * ID에 해당하는 레코드 수정하기
	 */
//	public int userUpdate() {
//		int result = 0;
//		String sql = "UPDATE TB_USERLIST SET NAME=?, age=? , addr=? WHERE id=?";
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

	/**
	 * 검색단어에 해당하는 레코드 검색하기 (like연산자를 사용하여 _, %를 사용할때는 PreparedStatemnet안된다. 반드시
	 * Statement객체를 이용함)
	 */
	public void getUserSearch(DefaultTableModel dt, String fieldName, String word) {
		String sql = "SELECT * FROM TB_USERLIST WHERE " + fieldName.trim() + " LIKE '%" + word.trim() + "%'";

		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);

			// DefaultTableModel에 있는 기존 데이터 지우기
			for (int i = 0; i < dt.getRowCount();) {
				dt.removeRow(0);
			}

			while (rs.next()) {
				Object data[] = { rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4) };

				dt.addRow(data);
			}

		} catch (SQLException e) {
			System.out.println(e + "=> getUserSearch fail");
		} finally {
			dbClose();
		}

	}// getUserSearch()

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