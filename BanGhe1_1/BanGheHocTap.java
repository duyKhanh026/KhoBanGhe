package BanGhe1_1;

public class BanGheHocTap extends BanGheLamViec{
    private int SoNganSach;
    private int SoNganKeo;
    private String PhuKien;


    public BanGheHocTap(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, String mausac, int keSach, int soNganSach, int soNganKeo,
            String phuKien) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang, mausac, keSach);
        SoNganSach = soNganSach;
        SoNganKeo = soNganKeo;
        PhuKien = phuKien;
    }

    public int getSoNganSach() {
        return SoNganSach;
    }

    public void setSoNganSach(int soNganSach) {
        SoNganSach = soNganSach;
    }

    public int getSoNganKeo() {
        return SoNganKeo;
    }

    public void setSoNganKeo(int soNganKeo) {
        SoNganKeo = soNganKeo;
    }

    public String getPhuKien() {
        return PhuKien;
    }

    public void setPhuKien(String phuKien) {
        PhuKien = phuKien;
    }
}