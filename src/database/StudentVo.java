package database;

public class StudentVo {

	// 학생 정보 추가
	// 학생이름만 필수이고, 나머지는 비워져도 괜찮게, null로 나오게하기
	private String stuNumber; // 학생번호
	private String stuName; // 이름
	private String sex; // 성별
	private String age; // 나이
	private String school; // 학교이름
	private String grade; // 몇 학년
	private String className; // 반이름
	private String birth; // 생년월일
	private String[] when_day; // 등원하는 요일
	private String address; // 주소
	private String enter_date; // 학원 등록 날짜
	private String student_call; // 학생전화번호
	private String guardian1; // 보호자1
	private String guardian1_call; // 보호자 1 이름, 전화번호
	private String guardian2; // 이름
	private String guardian2_call; // 보호자 1 이름, 전화번호
	private String stu_memo;// 학생 특이사항 메모
	private String pic;// 사진 경로

	// 학생추가
	public StudentVo(String stuNumber, String stuName, String sex, String age, String school, String grade,
			String className, String birth, String[] days, String address, String enter_date, String student_call,
			String guardian1, String guardian1_call, String guardian2, String guardian2_call, String stu_memo,
			String pic) {

		this.stuNumber = stuNumber;
		this.stuName = stuName;
		this.sex = sex;
		this.age = age;
		this.school = school;
		this.grade = grade;
		this.className = className;
		this.birth = birth;
		this.when_day = days;
		this.address = address;
		this.enter_date = enter_date;
		this.student_call = student_call;
		this.guardian1 = guardian1;
		this.guardian1_call = guardian1_call;
		this.guardian2 = guardian2;
		this.guardian2_call = guardian2_call;
		this.stu_memo = stu_memo;
		this.pic = pic;

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

	public String getAge() {
		return age;
	}

	public String getSchool() {
		return school;
	}

	public String getGrade() {
		return grade;
	}

	public String getClassName() {
		return className;
	}

	public String getBirth() {
		return birth;
	}

	public String[] getWhen_day() {
		return when_day;
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

	public String getPic() {
		return pic;
	}

}