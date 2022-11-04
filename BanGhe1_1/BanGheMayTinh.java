package BanGhe1_1;

public class BanGheMayTinh extends BanGhe{
    private String Mausac;
    private String KieuChan;
    


    public BanGheMayTinh(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, String mausac, String kieuChan) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang);
        Mausac = mausac;
        KieuChan = kieuChan;
    }

    public String getMausac() {
        return Mausac;
    }

    public void setMausac(String mausac) {
        Mausac = mausac;
    }

    public String getKieuChan() {
        return KieuChan;
    }

    public void setKieuChan(String kieuChan) {
        KieuChan = kieuChan;
    }
    
}