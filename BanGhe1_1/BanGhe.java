package BanGhe1_1;

public class BanGhe extends KhoBanGhe{
	private String MaBG;
    private String Tensp;
    private String NoiSX;
    private String ChatLieu;
    private String KichThuoc;
    private int SoLuong;
    
    
    public BanGhe() {
    	super();
		MaBG = "";
		Tensp = "";
		NoiSX = "";
		ChatLieu = "";
		KichThuoc = "";
		SoLuong = 0;
	}

	public BanGhe(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX, String chatLieu,
            String kichThuoc) {
        super(maKho, tenkho, diachi);
        MaBG = maBG;
        Tensp = tensp;
        NoiSX = noiSX;
        ChatLieu = chatLieu;
        KichThuoc = kichThuoc;
    }

    public String getMaBG() {
        return MaBG;
    }

    public void setMaBG(String maBG) {
        MaBG = maBG;
    }

    public String getTensp() {
        return Tensp;
    }

    public void setTensp(String tensp) {
        Tensp = tensp;
    }

    public String getNoiSX() {
        return NoiSX;
    }

    public void setNoiSX(String noiSX) {
        NoiSX = noiSX;
    }

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String chatLieu) {
        ChatLieu = chatLieu;
    }

    public String getKichThuoc() {
        return KichThuoc;
    }

    public void setKichThuoc(String hinhDang) {
    	KichThuoc = hinhDang;
    }

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
    
	public void InTT() {
		System.out.printf("----Thong Tin----\n");
		System.out.printf("ID: %s\n", MaBG);
		System.out.printf("Ten: %s\n", Tensp);
		System.out.printf("Noi SX: %s\n", NoiSX);
		System.out.printf("Chat lieu: %s\n", ChatLieu);
		System.out.printf("Kich Thuoc: %s\n", KichThuoc);
		System.out.printf("So Luong: %d\n", SoLuong);
	}
}
