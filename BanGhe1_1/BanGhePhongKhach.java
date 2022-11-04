package BanGhe1_1;

public class BanGhePhongKhach extends BanGhe{
    private int SoBan;
    private int SoGhe;
    private String Mausac;
    private String Trangtri;

    public BanGhePhongKhach(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, int soBan, int soGhe, String mausac, String trangtri) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang);
        SoBan = soBan;
        SoGhe = soGhe;
        Mausac = mausac;
        Trangtri = trangtri;
    }
    public int getSoBan() {
        return SoBan;
    }
    public void setSoBan(int soBan) {
        SoBan = soBan;
    }
    public int getSoGhe() {
        return SoGhe;
    }
    public void setSoGhe(int soGhe) {
        SoGhe = soGhe;
    }
    public String getMausac() {
        return Mausac;
    }
    public void setMausac(String mausac) {
        Mausac = mausac;
    }
    public String getTrangtri() {
        return Trangtri;
    }
    public void setTrangtri(String trangtri) {
        Trangtri = trangtri;
    }
    
}
