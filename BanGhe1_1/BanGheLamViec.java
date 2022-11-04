package BanGhe1_1;

public class BanGheLamViec extends BanGhe{
	private String Mausac;
    private int KeSach;

    

    public BanGheLamViec(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, String mausac, int keSach) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang);
        Mausac = mausac;
        KeSach = keSach;
    }

    public String getMausac() {
        return Mausac;
    }

    public void setMausac(String mausac) {
        Mausac = mausac;
    }

    public int getKeSach() {
        return KeSach;
    }

    public void setKeSach(int keSach) {
        KeSach = keSach;
    }
}
