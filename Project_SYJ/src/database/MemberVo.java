package database;

public class MemberVo {

	// �α���
	private String id;
	private String password;

	// ȸ������
	private String user_name;
	private String mail;

	public MemberVo() {

	}

//�α���
	public MemberVo(String id, String password) {

		this.id = id;
		this.password = password;
	}

//ȸ������
	public MemberVo(String user_name, String id, String password, String mail) {
		this.user_name = user_name;
		this.id = id;
		this.password = password;
		this.mail = mail;

	}

	public String getUser_name() {
		return user_name;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getMail() {
		return mail;
	}

	//

}
