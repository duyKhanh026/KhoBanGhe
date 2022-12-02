package BanGhe1_2;


public class User {
	private String ID;
	private String username;
	private String password;
	private String hoten;
	private String diachi;
	private String Email;
	private String SDT;
	private boolean gioiTinh;
	private boolean admin;
	
	
	public User() {
		super();
		ID = "";
		this.username = "";
		this.password = "";
		this.hoten = "";
		this.diachi = "";
		Email = "";
		SDT = "";
	}
	public User(String iD, String username, String password, String hoten, String diachi, String email, String sDT,
			boolean gioiTinh, boolean admin) {
		super();
		ID = iD;
		this.username = username;
		this.password = password;
		this.hoten = hoten;
		this.diachi = diachi;
		Email = email;
		SDT = sDT;
		this.gioiTinh = gioiTinh;
		this.admin = admin;
	}
	

	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
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
	
	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public boolean getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	

	public void inTT() {
		System.out.printf("----Thong Tin----\n");
		System.out.printf("ID: %s\n", ID);
		System.out.printf("UserName: %s\n", username);
		System.out.printf("Password: %s\n", password);
		System.out.printf("Ho ten: %s\n", hoten);
		System.out.printf("Dia Chi: %s\n", diachi);
		System.out.printf("gioiTinh: ");
		if (gioiTinh)
			System.out.printf("Nam \n");
		else 
			System.out.printf("Nu \n ");
	}
	
}
