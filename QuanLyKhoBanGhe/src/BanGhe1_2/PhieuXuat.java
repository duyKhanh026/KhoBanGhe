package BanGhe1_2;


import java.sql.Date;

public class PhieuXuat {
	private String MaPX;
	private Date NgayLapPX;
	private String ID;
	public PhieuXuat() {
		super();
		MaPX = "";
		NgayLapPX = null;
		ID = null;
	}
	public PhieuXuat(String maPN, Date ngayLapPN, String iD) {
		super();
		MaPX = maPN;
		NgayLapPX = ngayLapPN;
		ID = iD;
	}
	public String getMaPX() {
		return MaPX;
	}
	public void setMaPX(String maPN) {
		MaPX = maPN;
	}
	public Date getNgayLapPX() {
		return NgayLapPX;
	}
	public void setNgayLapPX(Date ngayLapPN) {
		NgayLapPX = ngayLapPN;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	
}
