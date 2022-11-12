package BanGhe1_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DataSQL {
	 private Connection conn;
	    
	    public DataSQL(){
	        try {
	        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;encrypt=true;trustServerCertificate=true;databaseName=KhoBanGhe;"
	                    + "username=sa;password=123456");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public boolean addBanGhe(BanGhe s){
	        
	        String sql = "INSERT INTO BanGhe(MaBG, Tensp, NoiSX, ChatLieu, KichThuoc, SoLuong) "
	                + "VALUES(?,?,?,?,?,?)";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, s.getMaBG());
	            ps.setString(2, s.getTensp());
	            ps.setString(3, s.getNoiSX());
	            ps.setString(4, s.getChatLieu());
	            ps.setString(5, s.getKichThuoc());
	            ps.setInt(6, s.getSoLuong());
	           // ps.setDate(3, new Date(s.getDob().getTime()));
	            
	            return ps.executeUpdate() > 0;
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return false;
	    }
	    public boolean addUser(User s) {
	    	String sql = "INSERT INTO TaiKhoan(ID, Username, Passwordd, HoTen, GioiTinh, DiaChi) "
	                + "VALUES(?,?,?,?,?,?)";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, s.getID());
	            ps.setString(2, s.getUsername());
	            ps.setString(3, s.getPassword());
	            ps.setString(4, s.getHoten());
	            ps.setBoolean(5, s.getGioiTinh());
	            ps.setString(6, s.getDiachi());
	           // ps.setDate(3, new Date(s.getDob().getTime()));
	            
	            return ps.executeUpdate() > 0;
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return false;
		}
	    public ArrayList<PhieuNhap> getListPhieuNhap(){
	        ArrayList<PhieuNhap> list = new ArrayList<>();
	        String sql = "SELECT * FROM PhieuNhap";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	            	PhieuNhap s = new PhieuNhap();
	                s.setMaPN(rs.getString("MaPN"));
	                s.setNgayLapPN(rs.getDate("NgayLapPN"));
	                s.setID(rs.getString("ID"));
	                
	                list.add(s);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return list;
	    }
	    public ArrayList<PhieuXuat> getListPhieuXuat(){
	        ArrayList<PhieuXuat> list = new ArrayList<>();
	        String sql = "SELECT * FROM PhieuXuat";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	            	PhieuXuat s = new PhieuXuat();
	                s.setMaPN(rs.getString("MaPN"));
	                s.setNgayLapPN(rs.getDate("NgayLapPN"));
	                s.setID(rs.getString("ID"));
	                
	                list.add(s);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return list;
	    }
	    public ArrayList<Phieu> getListLuuLS(){
	        ArrayList<Phieu> list = new ArrayList<>();
	        String sql = "SELECT * FROM LuuLS";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	            	Phieu s = new Phieu();
	                s.setMaPhieu(rs.getString("MaPhieu"));
	                s.setMaBG(rs.getString("MaBG"));
	                s.setSoluong(rs.getInt("soluong"));
	                
	                list.add(s);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return list;
	    }
	    public ArrayList<BanGhe> getListBanGhe(){
	        ArrayList<BanGhe> list = new ArrayList<>();
	        String sql = "SELECT * FROM BanGhe";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	            	BanGhe s = new BanGhe();
	                s.setMaBG(rs.getString("MaBG"));
	                s.setTensp(rs.getString("Tensp"));
	                s.setNoiSX(rs.getString("NoiSX"));
	                s.setChatLieu(rs.getString("ChatLieu"));
	                s.setKichThuoc(rs.getString("KichThuoc"));
	                s.setSoLuong(rs.getInt("SoLuong"));
	                
	                list.add(s);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return list;
	    }
	    public ArrayList<User> getListUser(){
	        ArrayList<User> list = new ArrayList<User>();
	        String sql = "SELECT * FROM TaiKhoan";
	        try {
	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	            while(rs.next()){
	            	User s = new User();
	                s.setID(rs.getString("ID"));
	                s.setUsername(rs.getString("Username"));
	                s.setPassword(rs.getString("Passwordd"));
	                s.setHoten(rs.getString("HoTen"));
	                s.setGioiTinh(rs.getBoolean("GioiTinh"));
	                s.setDiachi(rs.getString("DiaChi"));
	                list.add(s);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return list;
	    }
	    public ArrayList<BanGhe> XoaSanPham(ArrayList<BanGhe> l, int v) {
			String sql = "DELETE FROM BanGhe WHERE MaBG = '" + l.get(v).getMaBG() + "' ";
			l.remove(v);
			try {
				PreparedStatement ps =  conn.prepareStatement(sql);
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return l;
		}
	    public ArrayList<User> XoaUser(ArrayList<User> l, int v) {
			String sql = "DELETE FROM TaiKhoan WHERE ID = '" + l.get(v).getID() + "' ";
			l.remove(v);
			try {
				PreparedStatement ps =  conn.prepareStatement(sql);
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return l;
		}
	    public void UpdateBanGhe(BanGhe t) {
			String sql = "UPDATE BanGhe "
					+ "Set Tensp = N'" + t.getTensp() + "' "
					+ ", NoiSX = N'" + t.getNoiSX() + "' "
					+ ", ChatLieu = N'" + t.getChatLieu() + "' "
					+ ", KichThuoc = N'" + t.getKichThuoc() + "' "
					+ ", SoLuong = '" + t.getSoLuong() + "' "
					+ "WHERE MaBG = '" + t.getMaBG() + "' ";
			try {
				PreparedStatement ps =  conn.prepareStatement(sql);
				ps.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
