package BanGhe1_1;

public class GheCongThaiHoc extends BanGheCongThaiHoc{
    private String Tuadau;
    private String betytay;
    private String Gacchan;

    public GheCongThaiHoc(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, String dCdocao, int sobanhxe, String tuadau, String betytay,
            String gacchan) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang, dCdocao, sobanhxe);
        Tuadau = tuadau;
        this.betytay = betytay;
        Gacchan = gacchan;
    }
    public String getTuadau() {
        return Tuadau;
    }
    public void setTuadau(String tuadau) {
        Tuadau = tuadau;
    }
    public String getBetytay() {
        return betytay;
    }
    public void setBetytay(String betytay) {
        this.betytay = betytay;
    }
    public String getGacchan() {
        return Gacchan;
    }
    public void setGacchan(String gacchan) {
        Gacchan = gacchan;
    }
    
}
