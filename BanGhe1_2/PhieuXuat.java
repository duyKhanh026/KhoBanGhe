package BanGhe1_2;


import java.util.Date;

public class PhieuXuat {
	private String MaPN;
	private Date NgayLapPN;
	private String ID;
	public PhieuXuat() {
		super();
		MaPN = "";
		NgayLapPN = null;
		ID = null;
	}
	public PhieuXuat(String maPN, Date ngayLapPN, String iD) {
		super();
		MaPN = maPN;
		NgayLapPN = ngayLapPN;
		ID = iD;
	}
	public String getMaPN() {
		return MaPN;
	}
	public void setMaPN(String maPN) {
		MaPN = maPN;
	}
	public Date getNgayLapPN() {
		return NgayLapPN;
	}
	public void setNgayLapPN(Date ngayLapPN) {
		NgayLapPN = ngayLapPN;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	
}
