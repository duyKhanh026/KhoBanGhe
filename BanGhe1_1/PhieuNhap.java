package BanGhe1_1;

import java.util.Date;

public class PhieuNhap {
	private String maPhieu;
	private Date dob;
	private String name;
	private int SoBG;
	public PhieuNhap() {
		super();
		this.maPhieu = "";
		this.dob = null;
		this.name = "";
		this.SoBG = 0;
	}
	public PhieuNhap(String maPhieu, Date dob, String name, int soBG) {
		super();
		this.maPhieu = maPhieu;
		this.dob = dob;
		this.name = name;
		SoBG = soBG;
	}
	public String getMaPhieu() {
		return maPhieu;
	}
	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSoBG() {
		return SoBG;
	}
	public void setSoBG(int soBG) {
		SoBG = soBG;
	}
	
	
}
