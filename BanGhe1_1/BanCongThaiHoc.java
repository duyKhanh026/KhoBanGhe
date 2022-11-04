package BanGhe1_1;

public class BanCongThaiHoc extends BanGheCongThaiHoc{
    private int Chieucao;
    
    public BanCongThaiHoc(String maKho, String tenkho, String diachi, String maBG, String tensp, String noiSX,
            String chatLieu, String hinhDang, String dCdocao, int sobanhxe, int chieucao) {
        super(maKho, tenkho, diachi, maBG, tensp, noiSX, chatLieu, hinhDang, dCdocao, sobanhxe);
        Chieucao = chieucao;
    }

    public int getChieucao() {
        return Chieucao;
    }

    public void setChieucao(int chieucao) {
        Chieucao = chieucao;
    }
}
