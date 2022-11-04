package BanGhe1_1;

public class BanGheNhaBep extends BanGhe{
    private String TrangTri;
    private int SoGhe;

    public BanGheNhaBep(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, String trangTri, int soGhe) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang);
        TrangTri = trangTri;
        SoGhe = soGhe;
    }
    public String getTrangTri() {
        return TrangTri;
    }
    public void setTrangTri(String trangTri) {
        TrangTri = trangTri;
    }
    public int getSoGhe() {
        return SoGhe;
    }
    public void setSoGhe(int soGhe) {
        SoGhe = soGhe;
    }
    
}
