package BanGhe1_1;

public class User {
	private String ID;
	private String username;
	private String password;
	
	public User() {
		super();
		ID = "";
		username = "";
		password = "";
 	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void inTT() {
		System.out.printf("----Thong Tin----\n");
		System.out.printf("ID: %s\n", ID);
		System.out.printf("UserName: %s\n", username);
		System.out.printf("Password: %s\n", password);
	}
	
}
