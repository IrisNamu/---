package database;

public class StudentVo {

	// 학생 정보 추가
	// 학생이름만 필수이고, 나머지는 비워져도 괜찮게, null로 나오게하기
	private String stuNumber; // 학생번호
	private String stuName; // 이름
	private String sex; // 성별
	private String birth; // 생년월일
	private String address; // 주소
	private String enter_date; // 입원날짜
	private String student_call; // 학생전화번호
	private String guardian1; // 보호자1
	private String guardian1_call; // 보호자 1 이름, 전화번호
	private String guardian2; // 이름
	private String guardian2_call; // 보호자 1 이름, 전화번호
	private String stu_memo;// 학생 특이사항 메모

	// 학생추가
	public StudentVo(String stuNumber, String stuName, String sex, String birth, String address, String enter_date,
			String student_call, String guardian1, String guardian1_call, String guardian2, String guardian2_call,
			String stu_memo) {

		this.stuNumber = stuNumber;
		this.stuName = stuName;
		this.sex = sex;
		this.birth = birth;
		this.address = address;
		this.enter_date = enter_date;
		this.student_call = student_call;
		this.guardian1 = guardian1;
		this.guardian1_call = guardian1_call;
		this.guardian2 = guardian2;
		this.guardian2_call = guardian2_call;
		this.stu_memo = stu_memo;

	}

	// 학생정보

	public String getStuNumber() {
		return stuNumber;
	}

	public String getStuName() {
		return stuName;
	}

	public String getSex() {
		return sex;
	}

	public String getBirth() {
		return birth;
	}

	public String getAddress() {
		return address;
	}

	public String getEnter_date() {
		return enter_date;
	}

	public String getStudent_call() {
		return student_call;
	}

	public String getGuardian1() {
		return guardian1;
	}

	public String getGuardian1_call() {
		return guardian1_call;
	}

	public String getGuardian2() {
		return guardian2;
	}

	public String getGuardian2_call() {
		return guardian2_call;
	}

	public String getStu_memo() {
		return stu_memo;
	}

}