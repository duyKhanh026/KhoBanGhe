package BanGhe1_1;

public class BanGheCongThaiHoc extends BanGhe{
    private String DCdocao;
    private int Sobanhxe;

    public BanGheCongThaiHoc(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, String dCdocao, int sobanhxe) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang);
        DCdocao = dCdocao;
        Sobanhxe = sobanhxe;
    }
    public String getDCdocao() {
        return DCdocao;
    }
    public void setDCdocao(String dCdocao) {
        DCdocao = dCdocao;
    }
    public int getSobanhxe() {
        return Sobanhxe;
    }
    public void setSobanhxe(int sobanhxe) {
        Sobanhxe = sobanhxe;
    }
}
