package database;

public class MemberVo {

	// �α���
	private String id;
	private String password;

	// ȸ������
	private String user_name;
	private String password_check;
	private String mail;

	public MemberVo() {

	}

//�α���
	public MemberVo(String id, String password) {

		this.id = id;
		this.password = password;
	}

//ȸ������
	public MemberVo(String id, String password, String password_check, String mail) {

		this.id = id;
		this.password = password;

		this.password_check = password_check;
		this.mail = mail;

	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getPassword_check() {
		return password_check;
	}

	public String getMail() {
		return mail;
	}
	
	//

}
