package BanGhe1_1;

public class BGMTGaming extends BanGheMayTinh{
    private int KhaNangChiuTai;

    public BGMTGaming(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, String mausac, String kieuChan, int khaNangChiuTai) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang, mausac, kieuChan);
        KhaNangChiuTai = khaNangChiuTai;
    }

    public int getKhaNangChiuTai() {
        return KhaNangChiuTai;
    }

    public void setKhaNangChiuTai(int khaNangChiuTai) {
        KhaNangChiuTai = khaNangChiuTai;
    }
    
}