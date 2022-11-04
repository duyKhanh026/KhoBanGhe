package BanGhe1_1;

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
	                s.setPassword(rs.getString("Password"));
	                
	                list.add(s);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return list;
	    }
}
