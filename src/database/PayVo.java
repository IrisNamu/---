package database;

public class PayVo {

	// 결제 수납관련 (달마다 보여줄 것임)

	private String stuNumber;// 학생번호
	private String stuName;// 학생이름

	private String Payment_TF; // 이번달에 결제를 했나요?
	private String payment_date;// 결제날짜
	private int payment_amount;// 결제액

// 결제관련 정보
	public PayVo(String stuNumber, String stuName, String Payment_TF, String payment_date, int payment_amount) {

		this.setStuNumber(stuNumber);
		this.setStuName(stuName);
		this.setPayment_amount(payment_amount);
		this.setPayment_date(payment_date);
		this.setPayment_TF(Payment_TF);
	}

	public int getPayment_amount() {
		return payment_amount;
	}

	public void setPayment_amount(int payment_amount2) {
		this.payment_amount = payment_amount2;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_TF() {
		return Payment_TF;
	}

	public void setPayment_TF(String payment_TF) {
		Payment_TF = payment_TF;
	}

	public String getStuNumber() {
		return stuNumber;
	}

	public void setStuNumber(String stuNumber) {
		this.stuNumber = stuNumber;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
}