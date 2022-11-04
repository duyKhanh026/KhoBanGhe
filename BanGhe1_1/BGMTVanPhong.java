package BanGhe1_1;

public class BGMTVanPhong extends BanGheMayTinh{
    private int NgankeoBP;
    private int Tukeo;
  
    public BGMTVanPhong(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, String mausac, String kieuChan, int ngankeoBP, int tukeo) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang, mausac, kieuChan);
        NgankeoBP = ngankeoBP;
        Tukeo = tukeo;
    }
    public int getNgankeoBP() {
        return NgankeoBP;
    }
    public void setNgankeoBP(int ngankeoBP) {
        NgankeoBP = ngankeoBP;
    }
    public int getTukeo() {
        return Tukeo;
    }
    public void setTukeo(int tukeo) {
        Tukeo = tukeo;
    }
}