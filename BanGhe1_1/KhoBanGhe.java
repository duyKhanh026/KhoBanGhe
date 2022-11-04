package BanGhe1_1;

public class KhoBanGhe {
	private String MaKho;
    private String Tenkho;
    private String Diachi;
    
    public KhoBanGhe(String maKho, String tenkho, String diachi) {
        MaKho = maKho;
        Tenkho = tenkho;
        Diachi = diachi;
    }
    public KhoBanGhe() {
        MaKho = "";
        Tenkho = "";
        Diachi = "";
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String maKho) {
        MaKho = maKho;
    }

    public String getTenkho() {
        return Tenkho;
    }

    public void setTenkho(String tenkho) {
        Tenkho = tenkho;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }
    
}

