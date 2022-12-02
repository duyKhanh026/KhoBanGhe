package windowed;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import BanGhe1_2.BanGhe;
import BanGhe1_2.Phieu;
import BanGhe1_2.PhieuNhap;
import BanGhe1_2.PhieuXuat;
import BanGhe1_2.User;
import modulesL.DataSQL;
import modulesL.TimkiemGanDung;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;


public class winBG {
	private JFrame frame;
	static public ArrayList<BanGhe> A1; 
	static public ArrayList<Integer> BanThem = new ArrayList<Integer>(); 
	static public ArrayList<User> userList;
	static public ArrayList<PhieuNhap> PhieuNhapList;
	static public ArrayList<PhieuXuat> PhieuXuatList;
	private static JTextField PrName_text;
	private static JTextField NoiSX_text;
	private static JTextField ChatLieu_text;
	private static JTextField KichThuoc_test;
	private static JTextField Sluong_text;
	private static JTextField PrID_text;
	static DefaultTableModel model = new DefaultTableModel();
	static DefaultTableModel model1 = new DefaultTableModel();
	static DefaultTableModel model2 = new DefaultTableModel();
	static DefaultTableModel model4 = new DefaultTableModel();
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	static Object[] row = new Object[6];
	static Object[] row1 = new Object[2];
	static Object[] row2 = new Object[3];
	static Object[] row4 = new Object[3];
	private JLabel MaPhieu;
	private JLabel Ngay;
	private JTextField Maban;
	private JTextField SoluongB;
	private JTextField Username_text;
	private JPasswordField passwordField;
	static public DataSQL sql;
	static JMenuBar mb;
	static JMenuItem m1, m2, m3;
	private static JMenuItem m3_2;
	private static JMenuItem m2_4;
	private static JMenuItem m2_3;
	private static JMenuItem m1_4;
	private static JMenuItem m1_3;
	private static JMenuItem m3_1;
	private static JMenuItem m1_2; 
	private static JMenuItem m2_2;
	private static JMenuItem m2_1;
	private static JMenuItem m1_1;
	static JMenu menu; 
	static JMenu menu_1;
	int userNow;
	public static JPanel panel;
	public static JPanel panel_2;
	public static int combox_2;
	public static JPanel panel_3;
	public static JPanel panel_7;
	public static int combox_7;
	
	public static boolean adminP;
	private JTable table_4;
	private JTextField TimkiemPanel2;
	private JTextField TimkiemPanel7;
	public static void setAdminP(boolean ader) {
		adminP = ader;
	}
	public static void addRow2(PhieuNhap i) {
		row2[0] = i.getMaPN();
		row2[1] = i.getNgayLapPN();
		row2[2] = i.getID();
		model2.addRow(row2);
	}
	public static void addRowBanGhe(BanGhe i) {
		row[0] = i.getMaBG();
		row[1] = i.getTensp();
		row[2] = i.getChatLieu();
		row[3] = i.getSoLuong();
		row[4] = i.getNoiSX();
		row[5] = i.getKichThuoc();
		model.addRow(row);
	}
	public static void addRow4(PhieuXuat i) {
		row4[0] = i.getMaPX();
		row4[1] = i.getNgayLapPX();
		row4[2] = i.getID();
		model4.addRow(row4);
	}
	public static void ResetBanGheForm() {
		PrID_text.setText("");
		PrName_text.setText("");
		ChatLieu_text.setText("");
		NoiSX_text.setText("");
		Sluong_text.setText("");
		KichThuoc_test.setText("");
	}
	public static void setValueModel(int i) {
		model.setValueAt(PrName_text.getText(), i, 1);
		model.setValueAt(ChatLieu_text.getText(), i, 2);
		model.setValueAt(Sluong_text.getText(), i, 3);
		model.setValueAt(NoiSX_text.getText(), i, 4);
		model.setValueAt(KichThuoc_test.getText(), i, 5);
	}
	public static String chonMaPhieu(int c) {
		String mamoi = "";
		if (c == 1) {
			mamoi = "MPN";
			if (PhieuNhapList.size() == 0) mamoi += "000";
			else if (PhieuNhapList.size() < 10) mamoi += "00" + PhieuNhapList.size();
			else if (PhieuNhapList.size() < 100) mamoi += "0" + PhieuNhapList.size();
			else mamoi += + PhieuNhapList.size();
		}else {
			mamoi = "MPX";
			if (PhieuXuatList.size() == 0) mamoi += "000";
			else if (PhieuXuatList.size() < 10) mamoi += "00" + PhieuXuatList.size();
			else if (PhieuXuatList.size() < 100) mamoi += "0" + PhieuXuatList.size();
			else mamoi += + PhieuXuatList.size();
		}
		return mamoi;
	}
	public static String chonMaBan() {
		String mamoi = "KNV";
		if (A1.size() == 0) mamoi += "000";
		else if (A1.size() < 10) mamoi += "00" + A1.size();
		else if (A1.size() < 100) mamoi += "0" + A1.size();
		else mamoi += + A1.size();
		return mamoi;
	}
	public static String Phuongthuckhoitaomatkhautheophuongthucthemkhoangtrongphanduoi(String t) {
		String h = t;
		for (int i = 0;i < 16-t.length();i++) {
			h += ' ';
		}return h;
	}
	public static void Run() {
		try {
			sql = new DataSQL();
			if (A1 == null)A1 = sql.getListBanGhe();
			if (userList == null)userList = sql.getListUser();
			if (PhieuNhapList == null) PhieuNhapList = sql.getListPhieuNhap();
			if (PhieuXuatList == null) PhieuXuatList = sql.getListPhieuXuat();
			
			winBG window = new winBG();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				adminP = false;
				Run();
			}
		});
	}
	
	public winBG() {
		initialize();
	}
	private static ImageIcon createImageIcon(String path, String description) {
	      java.net.URL imgURL = DataSQL.class.getResource(path);
	      
	      if (imgURL != null) {
	         return new ImageIcon(imgURL, description);
	      } else {            
	         System.err.println("Couldn't find file: " + path);
	         return null;
	      } 
	}
	private void HoanViBG(int vt1,int vt2) {
		BanGhe tBanGhe = new BanGhe();
		tBanGhe = A1.get(vt1); 
		A1.set(vt1, A1.get(vt2));
		A1.set(vt2, tBanGhe);
	}
	public static boolean kiemTraKho(int vtr, int sl) {
		if (A1.get(vtr).getSoLuong() >= sl) {
			return true;
		}
		return false;
	}
	
	private void initialize() {
		if (DSBanGheTrongPhieu.PhieuSP == null)
			DSBanGheTrongPhieu.SetListDS();
		
		frame = new JFrame("Quản Lý Kho Bàn Ghế");
		frame.setBounds(100, 100, 924, 618);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(126, 162, 190));
		frame.getContentPane().setLayout(null);
		
		model = new DefaultTableModel();
		model1 = new DefaultTableModel();
		model2 = new DefaultTableModel();
		model4 = new DefaultTableModel();
		Object[] column = {"ID","Tên SP","Chất liệu", "Số lượng","Nơi SX","Kích thước"}; 
		Object[] column1 = {"Mã Bàn Ghế","Số Lượng"};
		Object[] column2 = {"Mã Phiếu", "Ngày", "Người Nhập"};

		model.setColumnIdentifiers(column);
		model1.setColumnIdentifiers(column1);
		model2.setColumnIdentifiers(column2);
		model4.setColumnIdentifiers(column2);
		//////////////////////
		
		if (A1 != null) {
			for (int i = 0; i < A1.size();i++) 
				addRowBanGhe(A1.get(i));
		}
		if (PhieuNhapList != null) {
			for (int i = 0;i < PhieuNhapList.size();i++) 
				addRow2(PhieuNhapList.get(i));
		}
		if (PhieuXuatList != null) {
			for (int i = 0;i < PhieuXuatList.size();i++) 
				addRow4(PhieuXuatList.get(i));
		}
		panel = new JPanel();
		panel.setBackground(new Color(64, 100, 128));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		panel.setVisible(false);
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(64, 100, 128));
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		panel_2.setVisible(false);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(64, 100, 128));
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		panel_7 = new JPanel();
		panel_7.setBackground(new Color(64, 100, 128));
		frame.getContentPane().add(panel_7);
		panel_7.setVisible(false);
		

		panel.setBounds(0, 28, 926, 552);
		panel_2.setBounds(0, 28, 926, 552);
		panel_3.setBounds(0, 27, 926, 552);
		panel_5.setBounds(0, 0, 908, 579);
		panel_7.setBounds(0, 28, 926, 552); // danh sách phieu xuất
		panel_7.setLayout(null);
		
		JButton btnNewButton = new JButton("Thêm SP");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trung = false;
				if (!PrID_text.getText().equals("")) {
					for (int i = 0;i < A1.size();i++) {
						if (PrID_text.getText().equals(A1.get(i).getMaBG())) {
							trung = true;
							JOptionPane.showMessageDialog(null, "Mã Sản Phẩm bị trùng với " + A1.get(1).getTensp() + "!");
							break;
						}
					}	
				}
				if (trung == false) {
					if (PrID_text.getText().equals("") || PrName_text.getText().equals("") || ChatLieu_text.getText().equals("") || NoiSX_text.getText().equals("") || Sluong_text.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin! ! ! ! !");
					} else {
						BanGhe t = new BanGhe();
						t.setMaBG(PrID_text.getText());
						t.setTensp( PrName_text.getText());
						t.setChatLieu(ChatLieu_text.getText());
						t.setSoLuong( Integer.parseInt(Sluong_text.getText()));
						t.setNoiSX(NoiSX_text.getText());
						t.setKichThuoc( KichThuoc_test.getText());
						sql.addBanGhe(t);
						A1.add(t);
						addRowBanGhe(t);
					
						
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
					}		
				}
			}
		});
		btnNewButton.setBounds(650, 13, 115, 35);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cập Nhật");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!PrID_text.getText().equals("") && !PrName_text.getText().equals("") && 
						!ChatLieu_text.getText().equals("") && !NoiSX_text.getText().equals("") && !Sluong_text.getText().equals("")) { 
					for (int i = 0;i < A1.size();i++) {
						if (PrID_text.getText().equals(A1.get(i).getMaBG())) { 
							A1.get(i).setTensp( PrName_text.getText());
							A1.get(i).setChatLieu(ChatLieu_text.getText());
							A1.get(i).setSoLuong( Integer.parseInt(Sluong_text.getText()));
							A1.get(i).setNoiSX(NoiSX_text.getText());
							A1.get(i).setKichThuoc( KichThuoc_test.getText());
							
							sql.UpdateBanGhe(A1.get(i));
							if (i < model.getRowCount() && model.getValueAt(i, 0).equals(PrID_text.getText())) {
								setValueModel(i);
							} else {
								for (int j = 0;j < model.getRowCount();j++) {
									if (model.getValueAt(j, 0).equals(PrID_text.getText())) {
										setValueModel(j);
										break;
									}
								}
							}
							ResetBanGheForm();
							JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");
							PrID_text.setText(chonMaBan());
							return;
						}
					}	
					JOptionPane.showMessageDialog(null, "Mã vừa nhập không tồn tại");
				} else { 
					JOptionPane.showMessageDialog(null, "Vui lòng điền đủ thông tin");
				}
			}
		});
		btnNewButton_1.setBounds(650, 53, 115, 35);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_2 = new JButton("Tim kiếm");
		JButton btnNewButton_1_2_1 = new JButton("Quay Lại");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int contRow = model.getRowCount();
				for (int i =0 ;i < contRow;i++) 
					model.removeRow(0);
				for (int i = 0;i < A1.size();i++) 
					addRowBanGhe(A1.get(i));
				btnNewButton_1_2.setVisible(true);
				btnNewButton_1_2_1.setVisible(false);
			}
		});
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2_1.setBackground(Color.WHITE);
		btnNewButton_1_2_1.setBounds(775, 13, 112, 35);
		panel.add(btnNewButton_1_2_1);
		btnNewButton_1_2_1.setVisible(false);
	
		btnNewButton_1_2.setBackground(new Color(255, 255, 255));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PrID_text.getText().equals("") && PrName_text.getText().equals("") && ChatLieu_text.getText().equals("") 
						&& NoiSX_text.getText().equals("") && Sluong_text.getText().equals("")  && KichThuoc_test.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Nhập Thông tin bất kì để tìm kiếm");
					return;
				} else {
					int contRow = model.getRowCount();
					for (int i =0 ;i < contRow;i++) {
						model.removeRow(0);
					}
				}
				if (!PrID_text.getText().equals("")) {
					for (int i = 0;i < A1.size();i++) {
						if (PrID_text.getText().equals(A1.get(i).getMaBG())) 
							addRowBanGhe(A1.get(i));
					}
				} else {
					boolean timThay = false;
					boolean datimthay = false;
					for (int i = 0;i < A1.size();i++) {
						timThay = false;
						if (!PrName_text.getText().equals("")) {
							if (PrName_text.getText().equalsIgnoreCase(A1.get(i).getTensp())) 
								timThay = true;
						}
						if (!ChatLieu_text.getText().equals("") && !timThay) {
							if (ChatLieu_text.getText().equalsIgnoreCase(A1.get(i).getChatLieu()))
								timThay = true;
						}
						if (!NoiSX_text.getText().equals("") && !timThay) {
							if (NoiSX_text.getText().equalsIgnoreCase(A1.get(i).getNoiSX()))
								timThay = true;
						}
						if (!Sluong_text.getText().equals("") && !timThay) {
							if (Integer.parseInt(Sluong_text.getText()) == A1.get(i).getSoLuong())
								timThay = true;
						}
						if (!KichThuoc_test.getText().equals("") && !timThay) {
							if (KichThuoc_test.getText().equalsIgnoreCase(A1.get(i).getKichThuoc()))
								timThay = true;
						}
						if (timThay) {
							addRowBanGhe(A1.get(i));
							datimthay = true;
						} 
					}
					if (!datimthay && !PrName_text.getText().equals("")) {
						ArrayList<BanGhe> A2 = TimkiemGanDung.TimGanDung(A1, PrName_text.getText());
						for (int i = 0;i < A2.size();i++) {
							addRowBanGhe(A2.get(i));
						}
					}
				}
				btnNewButton_1_2_1.setVisible(true);
				btnNewButton_1_2.setVisible(false);
				
			}
		});
		btnNewButton_1_2.setBounds(775, 13, 112, 35);
		panel.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1 = new JButton("Xóa SP");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(775, 53, 112, 35);
		panel.add(btnNewButton_1_1);
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					if (model.getValueAt(i, 0).equals(A1.get(i).getMaBG())) 
						A1 = sql.XoaSanPham(A1, i);
					else {
						for (int j = 0;j < A1.size();j++) {
							if (A1.get(j).getMaBG().equals(model.getValueAt(i, 0))) {
								A1 = sql.XoaSanPham(A1, j);
								break;
							}
						}
					}
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công");
					
				} else {
					JOptionPane.showMessageDialog(null, "Hãy Chọn 1 Hàng Để Xóa");
				}
			}
		});
		
		JButton btnNewButton_1_1_1 = new JButton("Dọn");
		btnNewButton_1_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResetBanGheForm();
			}
		});
		
		Sluong_text = new JTextField();//số lượng
		Sluong_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Sluong_text.setBounds(431, 128, 195, 35);
		panel.add(Sluong_text);
		Sluong_text.setColumns(10);
		
		JLabel Sluong = new JLabel("Số Lượng");
		Sluong.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Sluong.setBounds(329, 133, 92, 25);
		panel.add(Sluong);
		Sluong.setForeground(Color.WHITE);
		
		JLabel KichThuoc = new JLabel("Kích thước");
		KichThuoc.setFont(new Font("Tahoma", Font.PLAIN, 19));
		KichThuoc.setBounds(329, 75, 92, 26);
		panel.add(KichThuoc);
		KichThuoc.setForeground(new Color(255, 255, 255));
		
		KichThuoc_test = new JTextField();//Hình Dạng
		KichThuoc_test.setFont(new Font("Tahoma", Font.PLAIN, 19));
		KichThuoc_test.setBounds(431, 70, 195, 37);
		panel.add(KichThuoc_test);
		KichThuoc_test.setColumns(10);
		
		ChatLieu_text = new JTextField();  //chất liệu
		ChatLieu_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ChatLieu_text.setBounds(431, 13, 195, 35);
		panel.add(ChatLieu_text);
		ChatLieu_text.setColumns(10);
		
		JLabel ChatLieu = new JLabel("Chất liệu");
		ChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ChatLieu.setBounds(329, 18, 92, 25);
		panel.add(ChatLieu);
		ChatLieu.setForeground(new Color(255, 255, 255));
		
		JLabel NoiSX = new JLabel("Nơi SX");
		NoiSX.setFont(new Font("Tahoma", Font.PLAIN, 19));
		NoiSX.setBounds(10, 134, 108, 35);
		panel.add(NoiSX);
		NoiSX.setForeground(new Color(255, 255, 255));
		
		NoiSX_text = new JTextField(); // nguồn Gốc
		NoiSX_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		NoiSX_text.setBounds(143, 129, 176, 34);
		panel.add(NoiSX_text);
		NoiSX_text.setColumns(10);
		
		JLabel PrName = new JLabel("Tên Sản phẩm");
		PrName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PrName.setBounds(10, 72, 134, 35);
		panel.add(PrName);
		PrName.setForeground(new Color(255, 255, 255));
		
		PrName_text = new JTextField();
		PrName_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PrName_text.setBounds(143, 70, 176, 35);
		panel.add(PrName_text);
		PrName_text.setColumns(10);
		
		PrID_text = new JTextField(chonMaBan()); //ID
		PrID_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PrID_text.setBounds(143, 14, 176, 35);
		panel.add(PrID_text);
		PrID_text.setColumns(10);
		
		JLabel PrID = new JLabel("ID");
		PrID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PrID.setBounds(10, 14, 108, 37);
		panel.add(PrID);
		PrID.setForeground(Color.WHITE);
		
	
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(650, 99, 115, 23);
		panel.add(btnNewButton_1_1_1);
		
		String s1[] = { "ID", "Tên", "Chất liệu", "Nơi SX", "Số lượng", "Kích thước"};
		@SuppressWarnings("rawtypes")
		JComboBox comboBox = new JComboBox<Object>(s1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0;i < A1.size();i++) {
					model.removeRow(0);
				}
				switch(comboBox.getSelectedIndex()) {
				case 0:{
					for (int i = 0;i < A1.size()-1;i++) {
						for (int j = i+1;j < A1.size();j++) {
							if (A1.get(i).getMaBG().compareTo(A1.get(j).getMaBG()) > 0) {
								HoanViBG(i,j);
							}
						}
					}
					break;
				} case 1:{
					for (int i = 0;i < A1.size()-1;i++) {
						for (int j = i+1;j < A1.size();j++) {
							if (TimkiemGanDung.unAccent(A1.get(i).getTensp()).toUpperCase().compareTo(TimkiemGanDung.unAccent(A1.get(j).getTensp()).toUpperCase()) > 0) {
								HoanViBG(i,j);
							}
						}
					}
					break;
				}
				case 2: {
					for (int i = 0;i < A1.size()-1;i++) {
						for (int j = i+1;j < A1.size();j++) {
							if (TimkiemGanDung.unAccent(A1.get(i).getChatLieu()).toUpperCase().compareTo(TimkiemGanDung.unAccent(A1.get(j).getChatLieu()).toUpperCase()) > 0) {
								HoanViBG(i,j);
							}
						}
					}break;
				}
				case 3: {
					for (int i = 0;i < A1.size()-1;i++) {
						for (int j = i+1;j < A1.size();j++) {
							if (TimkiemGanDung.unAccent(A1.get(i).getNoiSX()).toUpperCase().compareTo(TimkiemGanDung.unAccent(A1.get(j).getNoiSX()).toUpperCase()) > 0) {
								HoanViBG(i,j);
							}
						}
					}break;
				}
				case 4: {
					for (int i = 0;i < A1.size()-1;i++) {
						for (int j = i+1;j < A1.size();j++) {
							if (A1.get(i).getSoLuong() > A1.get(j).getSoLuong()) {
								HoanViBG(i,j);
							}
						}
					}break;
				}
				case 5: {
					for (int i = 0;i < A1.size()-1;i++) {
						for (int j = i+1;j < A1.size();j++) {
							if (A1.get(i).getKichThuoc().compareTo(A1.get(j).getKichThuoc()) > 0) {
								HoanViBG(i,j);
							}
						}
					}break;
				}
				default: break;
				}
				for (int i = 0;i < A1.size();i++) 
					addRowBanGhe(A1.get(i));
			}
		});
		comboBox.setBounds(756, 141, 112, 22);
		panel.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Sắp xếp theo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(650, 141, 108, 22);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm Kiếm theo");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(10, 11, 124, 30);
		panel_2.add(lblNewLabel_5);
		
		String str[] = {"Mã Phiếu", "ID Nhân viên", "Ngày", "Mã Sản Phẩm"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_1 = new JComboBox(str);
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1.setBounds(132, 11, 147, 30);
		panel_2.add(comboBox_1);
		
		JLabel lblNewLabel_6 = new JLabel("Nhập:");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setBackground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(312, 11, 58, 30);
		panel_2.add(lblNewLabel_6);
		
		TimkiemPanel2 = new JTextField();
		TimkiemPanel2.setBounds(365, 11, 243, 30);
		panel_2.add(TimkiemPanel2);
		TimkiemPanel2.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Tìm kiếm");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int countRw = model2.getRowCount();
				for (int i = 0;i < countRw;i++) model2.removeRow(0);
				switch (comboBox_1.getSelectedIndex()) {
				case 0:{
					for (int i = 0;i < PhieuNhapList.size();i++) {
						if (TimkiemPanel2.getText().equalsIgnoreCase(PhieuNhapList.get(i).getMaPN())) {
							addRow2(PhieuNhapList.get(i));
							break;
						}
					}
					break;
				}
				case 1:{
					for (int i = 0;i < PhieuNhapList.size();i++) {
						if (TimkiemPanel2.getText().equalsIgnoreCase(PhieuNhapList.get(i).getID())) 
							addRow2(PhieuNhapList.get(i));
					}
					break;
				}
				case 2:{
					for (int i = 0;i < PhieuNhapList.size();i++) {
						System.out.println(PhieuNhapList.get(i).getNgayLapPN().toString());
						if (TimkiemPanel2.getText().equalsIgnoreCase(PhieuNhapList.get(i).getNgayLapPN().toString())) 
							addRow2(PhieuNhapList.get(i));
					}
					break;
				}
				case 3:{
					for (int i = 0;i < PhieuNhapList.size();i++) {
						for (int j = 0;j < DSBanGheTrongPhieu.PhieuSP.size();j++) {
							if (TimkiemPanel2.getText().equalsIgnoreCase(DSBanGheTrongPhieu.PhieuSP.get(j).getMaBG()) &&
									PhieuNhapList.get(i).getMaPN().equals(DSBanGheTrongPhieu.PhieuSP.get(j).getMaPhieu())) 
								addRow2(PhieuNhapList.get(i));
						}
					}
					break;
				}
				default : break;
				}
			}
		});
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5.setBounds(629, 11, 124, 30);
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_5_1 = new JButton("Quay lại");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int countRw = model2.getRowCount();
				for (int i = 0;i < countRw;i++) model2.removeRow(0);
				for (int i = 0;i < PhieuNhapList.size();i++) 
					addRow2(PhieuNhapList.get(i));
			}
		});
		btnNewButton_5_1.setBackground(new Color(255, 255, 255));
		btnNewButton_5_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5_1.setBounds(763, 11, 124, 30);
		panel_2.add(btnNewButton_5_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 52, 880, 489);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(model2);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phiếu:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 12, 118, 49);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("Ngày: ");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setBounds(10, 75, 118, 49);
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Mã bàn ghế:");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_5.setBounds(364, 11, 153, 51);
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Số lượng:");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_6.setBounds(393, 75, 124, 49);
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel_3.add(lblNewLabel_1_6);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 214, 880, 327);
		panel_3.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_1.getSelectedRow();
				Maban.setText(model1.getValueAt(i, 0).toString());
				SoluongB.setText(model1.getValueAt(i, 1).toString());
			}
		});
		table_1.setModel(model1);
		
		MaPhieu = new JLabel(chonMaPhieu(1));
		MaPhieu.setForeground(new Color(255, 255, 255));
		MaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MaPhieu.setBounds(127, 13, 213, 49);
		panel_3.add(MaPhieu);
		
		Ngay = new JLabel();
		Ngay.setForeground(new Color(255, 255, 255));
		Ngay.setBackground(new Color(255, 255, 255));
		Ngay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Ngay.setBounds(127, 77, 213, 49);
		panel_3.add(Ngay);
		
		Maban = new JTextField();
		Maban.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Maban.setBounds(527, 11, 200, 51);
		Maban.setColumns(10);
		panel_3.add(Maban);
		
		SoluongB = new JTextField();
		SoluongB.setFont(new Font("Tahoma", Font.PLAIN, 25));
		SoluongB.setBounds(527, 72, 200, 49);
		SoluongB.setColumns(10);
		panel_3.add(SoluongB);
		
		JRadioButton rdbtnPhieuNhap = new JRadioButton("Nhập Kho");
		rdbtnPhieuNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaPhieu.setText(chonMaPhieu(1));
			}
		});
		rdbtnPhieuNhap.setForeground(new Color(255, 255, 255));
		rdbtnPhieuNhap.setBackground(new Color(64, 100, 128));
		rdbtnPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnPhieuNhap.setBounds(127, 135, 92, 49);
		panel_3.add(rdbtnPhieuNhap);
		
		JRadioButton rdbtnXuatKho = new JRadioButton("Xuất Kho");
		rdbtnXuatKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MaPhieu.setText(chonMaPhieu(2));
			}
		});
		rdbtnXuatKho.setForeground(new Color(255, 255, 255));
		rdbtnXuatKho.setBackground(new Color(64, 100, 128));
		rdbtnXuatKho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnXuatKho.setBounds(221, 135, 98, 49);
		panel_3.add(rdbtnXuatKho);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnPhieuNhap);
		G.add(rdbtnXuatKho);
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(737, 11, 153, 42);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int vitri = -1; 
				if ( !Maban.getText().equals("")) { // nếu như mã nhập có ký tự 
					for (int i = 0;i < A1.size();i++) {
						if (Maban.getText().equals(A1.get(i).getMaBG())) { 
							vitri = i; // tức là có tồn tại mã vừa nhập trong danh sách sản phẩm 
							break;
						}
					}	
				}
				if (vitri >= 0) { // lấy giá trị từ đoạn trên 
					if (Maban.getText().equals("") || SoluongB.getText().equals("")) // kiểm tra các thông tin đã điền có đầy đủ ko
					{
						JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin! ! ! ! !"); 
					} else if (!rdbtnXuatKho.isSelected() && !rdbtnPhieuNhap.isSelected())
						JOptionPane.showMessageDialog(null, "Vui Lòng Chọn loại phiếu"); 
					else if (Integer.parseInt(SoluongB.getText().toString()) <= 0) {
						JOptionPane.showMessageDialog(null, "Số lượng xuất/nhập không hợp lệ!"); 
					}
					else if (rdbtnXuatKho.isSelected() && !kiemTraKho(vitri, Integer.parseInt(SoluongB.getText().toString())))
						JOptionPane.showMessageDialog(null, "Số lượng trong kho không đủ!\n" 
								+ A1.get(vitri).getTensp() + " hiện có " + A1.get(vitri).getSoLuong() + " cái" ); 
					else {
						row1[0] = Maban.getText();
						row1[1] = SoluongB.getText();
						model1.addRow(row1);
						BanThem.add(vitri);
					
						Maban.setText("");
						SoluongB.setText("");
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
					}		
				}else { // nhận không có sản phẩm trong DS hoặc chưa điền
					if (Maban.getText().equals("")) // nhận trường hợp chưa điền mã
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã cho sản phẩm!");
					else  // nhận trường hợp có mã 
						JOptionPane.showMessageDialog(null, "Mã vừa nhập không tồn tại"); 
				}
			}
		});
		panel_3.add(btnNewButton_2);
		panel_3.setVisible(false);
		
		JButton btnNewButton_2_1 = new JButton("Lưu");
		btnNewButton_2_1.setBackground(new Color(255, 255, 255));
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (BanThem.size() == 0) 
					JOptionPane.showMessageDialog(null, "Không có dữ liệu cho phiếu!");
				else {
					if (rdbtnPhieuNhap.isSelected()) {
						LocalDate localDate = LocalDate.now();
						PhieuNhap t567 = new PhieuNhap();
						t567.setMaPN(MaPhieu.getText());
						t567.setNgayLapPN(java.sql.Date.valueOf(localDate));
						t567.setID(userList.get(userNow).getID());
						sql.addPhieuNhap(t567);
						PhieuNhapList.add(t567);
						
						addRow2(t567);
						for (int i = 0;i < model1.getRowCount();i++) {
							Phieu t452 = new Phieu();
							t452.setMaPhieu(t567.getMaPN());
							t452.setMaBG(model1.getValueAt(i, 0).toString());
							t452.setSoluong(Integer.parseInt(model1.getValueAt(i, 1).toString()));
							sql.addPhieu(t452);
							DSBanGheTrongPhieu.PhieuSP.add(t452);
						}
						MaPhieu.setText(chonMaPhieu(1));
						Maban.setText("");
						SoluongB.setText("");
						
						for (int i = 0;i < BanThem.size();i++) {
							BanGhe tBanGhe = new BanGhe();
							tBanGhe = A1.get(BanThem.get(i));
							tBanGhe.setSoLuong(tBanGhe.getSoLuong() + Integer.parseInt(model1.getValueAt(i, 1).toString()));
							A1.set(BanThem.get(i), tBanGhe);
							sql.UpdateBanGhe(A1.get(BanThem.get(i)));
							model.setValueAt(tBanGhe.getSoLuong(), BanThem.get(i), 3);
						}
						
					} else if (rdbtnXuatKho.isSelected()) {
						LocalDate localDate = LocalDate.now();
						PhieuXuat t567 = new PhieuXuat();
						t567.setMaPX(MaPhieu.getText());
						t567.setNgayLapPX(java.sql.Date.valueOf(localDate));
						t567.setID(userList.get(userNow).getID());
						sql.addPhieuXuat(t567);
						PhieuXuatList.add(t567);
						
						addRow4(t567);
						for (int i = 0;i < model1.getRowCount();i++) {
							Phieu t452 = new Phieu();
							t452.setMaPhieu(t567.getMaPX());
							t452.setMaBG(model1.getValueAt(i, 0).toString());
							t452.setSoluong(Integer.parseInt(model1.getValueAt(i, 1).toString()));
							sql.addPhieu(t452);
							DSBanGheTrongPhieu.PhieuSP.add(t452);
						}
						MaPhieu.setText(chonMaPhieu(2));
						Maban.setText("");
						SoluongB.setText("");
						
						for (int i = 0;i < BanThem.size();i++) {
							BanGhe tBanGhe = new BanGhe();
							tBanGhe = A1.get(BanThem.get(i));
							tBanGhe.setSoLuong(tBanGhe.getSoLuong() - Integer.parseInt(model1.getValueAt(i, 1).toString()));
							A1.set(BanThem.get(i), tBanGhe);
							sql.UpdateBanGhe(A1.get(BanThem.get(i)));
							model.setValueAt(tBanGhe.getSoLuong(), BanThem.get(i), 3);
						}
					}
					for (int i = 0 ;i < BanThem.size();i++) {
						model1.removeRow(0);
					}
					BanThem = new ArrayList<Integer>(); 
					JOptionPane.showMessageDialog(null, "Lưu thành công");
				}
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_1.setBounds(737, 167, 153, 40);
		panel_3.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Xóa");
		btnNewButton_2_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_1.getSelectedRow();
				if (i >= 0) {
					model1.removeRow(i);
					SoluongB.setText("");
					Maban.setText("");
					BanThem.remove(i);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công");
				} else {
					JOptionPane.showMessageDialog(null, "Hãy Chọn 1 Hàng Để Xóa");
				}
				
			}
		});
		btnNewButton_2_2.setBounds(737, 115, 153, 42);
		panel_3.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Sửa");
		btnNewButton_2_3.setBackground(new Color(255, 255, 255));
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Maban.getText().equals("") && !SoluongB.getText().equals("")) {
					for (int i = 0;i < model1.getRowCount();i++) {
						if (Maban.getText().equals(model1.getValueAt(i, 0))) {
							model1.setValueAt(SoluongB.getText(), i, 1);
							SoluongB.setText("");
							Maban.setText("");
							break;
						}
					}
				}
			}
		});
		btnNewButton_2_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_3.setBounds(737, 63, 153, 42);
		panel_3.add(btnNewButton_2_3);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Loại:");
		lblNewLabel_1_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1_4_1.setBounds(36, 135, 82, 49);
		panel_3.add(lblNewLabel_1_4_1);
		
		JButton btnNewButton_2_3_1 = new JButton("Dọn");
		btnNewButton_2_3_1.setBackground(new Color(255, 255, 255));
		btnNewButton_2_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoluongB.setText("");
				Maban.setText("");
			}
		});
		btnNewButton_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_3_1.setBounds(527, 128, 98, 31);
		panel_3.add(btnNewButton_2_3_1);
		
		JButton btnNewButton_3 = new JButton("Đăng Nhập");
		btnNewButton_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				boolean trung = false;
				userNow = 0;
				if (!Username_text.getText().equals("")) {
					for (int i = 0;i < userList.size();i++) {
						if (Username_text.getText().equals(userList.get(i).getUsername())) {
							trung = true;
							userNow = i;
						}
					}
				}
				if (trung) {
					String mk = Phuongthuckhoitaomatkhautheophuongthucthemkhoangtrongphanduoi(passwordField.getText());
					if ( !mk.equals(userList.get(userNow).getPassword())) {
						JOptionPane.showMessageDialog(null, "Mật Khẩu không đúng");
						System.out.println(mk + "|");
						passwordField.setText("");
					}
					else if (userList.get(userNow).getID().equals("NNB002")) {
						admin.Run();
						frame.dispose();
					}
					else {
						ChangPage(1);
						panel_5.setVisible(false);
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công tài khoản " + userList.get(userNow).getUsername() );
						Username_text.setText("");
						passwordField.setText("");
					}
					
				} else 
					JOptionPane.showMessageDialog(null, "Thông tin đã điền chưa đúng");
				if (userList == null) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu");
					Username_text.setText("");
					passwordField.setText("");
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(347, 268, 258, 41);
		panel_5.add(btnNewButton_3);
		
		Username_text = new JTextField();
		Username_text.setBounds(347, 143, 265, 30);
		panel_5.add(Username_text);
		Username_text.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(273, 147, 69, 30);
		panel_5.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(273, 188, 69, 30);
		panel_5.add(lblNewLabel_2);
		
		passwordField = new JPasswordField(16);
		passwordField.setBounds(347, 189, 265, 30);
		panel_5.add(passwordField);
		
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 44, 888, 497);
		panel_7.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_4.getSelectedRow();
				DSBanGheTrongPhieu.setMaP(model4.getValueAt(i, 0).toString());
				DSBanGheTrongPhieu.Run();
			}
		});
		table_4.setModel(model4);
		scrollPane_4.setViewportView(table_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tìm Kiếm theo");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_1.setBounds(22, 6, 124, 30);
		panel_7.add(lblNewLabel_5_1);
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox_1_1 = new JComboBox(str);
		comboBox_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox_1_1.setBounds(144, 6, 147, 30);
		panel_7.add(comboBox_1_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Nhập:");
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_1.setBackground(Color.WHITE);
		lblNewLabel_6_1.setBounds(324, 6, 58, 30);
		panel_7.add(lblNewLabel_6_1);
		
		TimkiemPanel7 = new JTextField();
		TimkiemPanel7.setColumns(10);
		TimkiemPanel7.setBounds(377, 6, 243, 30);
		panel_7.add(TimkiemPanel7);
		
		JButton btnNewButton_5_2 = new JButton("Tìm kiếm");
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int countRw = model4.getRowCount();
				for (int i = 0;i < countRw;i++) model4.removeRow(0);
				switch (comboBox_1_1.getSelectedIndex()) {
				case 0:{
					for (int i = 0;i < PhieuXuatList.size();i++) {
						if (TimkiemPanel7.getText().equalsIgnoreCase(PhieuXuatList.get(i).getMaPX())) {
							addRow4(PhieuXuatList.get(i));
							break;
						}
					}
					break;
				}
				case 1:{
					for (int i = 0;i < PhieuXuatList.size();i++) {
						if (TimkiemPanel7.getText().equalsIgnoreCase(PhieuXuatList.get(i).getID())) 
							addRow4(PhieuXuatList.get(i));
					}
					break;
				}
				case 2:{
					for (int i = 0;i < PhieuXuatList.size();i++) {
						System.out.println(PhieuXuatList.get(i).getNgayLapPX().toString());
						if (TimkiemPanel7.getText().equalsIgnoreCase(PhieuXuatList.get(i).getNgayLapPX().toString())) 
							addRow4(PhieuXuatList.get(i));
					}
					break;
				}
				case 3:{
					for (int i = 0;i < PhieuXuatList.size();i++) {
						for (int j = 0;j < DSBanGheTrongPhieu.PhieuSP.size();j++) {
							if (TimkiemPanel7.getText().equalsIgnoreCase(DSBanGheTrongPhieu.PhieuSP.get(j).getMaBG()) &&
									PhieuXuatList.get(i).getMaPX().equals(DSBanGheTrongPhieu.PhieuSP.get(j).getMaPhieu())) 
								addRow4(PhieuXuatList.get(i));
						}
					}
					break;
				}
				default : break;
				}
			}
		});
		btnNewButton_5_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5_2.setBackground(Color.WHITE);
		btnNewButton_5_2.setBounds(641, 6, 124, 30);
		panel_7.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_1_1 = new JButton("Quay lại");
		btnNewButton_5_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int countRw = model4.getRowCount();
				for (int i = 0;i < countRw;i++) model4.removeRow(0);
				for (int i = 0; i < PhieuXuatList.size(); i++) {
					addRow4(PhieuXuatList.get(i));
				}
			}
		});
		btnNewButton_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_5_1_1.setBackground(Color.WHITE);
		btnNewButton_5_1_1.setBounds(775, 6, 124, 30);
		panel_7.add(btnNewButton_5_1_1);
		
		if (!adminP) {
			panel.remove(btnNewButton_1);
		}
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				PrID_text.setText(model.getValueAt(i, 0).toString());
				PrName_text.setText(model.getValueAt(i, 1).toString());
				ChatLieu_text.setText(model.getValueAt(i, 2).toString());
				Sluong_text.setText(model.getValueAt(i, 3).toString());
				NoiSX_text.setText(model.getValueAt(i, 4).toString());
				KichThuoc_test.setText(model.getValueAt(i, 5).toString());
			}
		});
		table.setModel(model);
		
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_2.getSelectedRow();
				DSBanGheTrongPhieu.setMaP(model2.getValueAt(i, 0).toString());
				DSBanGheTrongPhieu.Run();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 880, 367);
		panel.add(scrollPane);
		
		scrollPane.setViewportView(table);
	
		scrollPane_1.setViewportView(table_1);
		scrollPane_2.setViewportView(table_2);
		
		
		if (!adminP) 
			panel.remove(btnNewButton_1_1);
		
		
		if (adminP) {
			ChangPage(1);
			panel_5.setVisible(false);
		}
			
	    ImageIcon icon1 = createImageIcon("/import.png","Java");
	    ImageIcon icon2 = createImageIcon("/export.png","Java");
	    ImageIcon icon3 = createImageIcon("/exit.png","Java");
	    ImageIcon icon4 = createImageIcon("/logout.png","Java");
	    ImageIcon icon5 = createImageIcon("/aboutus.png","Java");
	    ImageIcon icon6 = createImageIcon("/red.png","Java");
	    ImageIcon icon7 = createImageIcon("/blue.png","Java");
	    ImageIcon icon8 = createImageIcon("/green.png","Java");
	    ImageIcon icon9 = createImageIcon("/textEdit.png","Java");
	    ImageIcon icon_1 = createImageIcon("/circle.png","Java");
		
		mb = new JMenuBar();
		mb.setBounds(0, 0, 908, 28);
		m1 = new JMenuItem("Phiếu xuất", icon_1);
		m1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangPage(4);
			}
		});
		m2 = new JMenuItem("Sản phẩm", icon_1);
		m2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangPage(1);
			}
		});
		m3 = new JMenuItem("Phiếu Nhập",icon_1);
		m3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangPage(2);
			}
		});
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M);
		menu.getAccessibleContext().setAccessibleDescription("File items");
		menu.add(m2);menu.add(m3);menu.add(m1);
		m1_2 = new JMenuItem("Đăng xuất", icon4); 
		m1_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangPage(-1);
				panel_5.setVisible(true);
			}
		});
		m2_2 = new JMenuItem("Nhập phiếu", icon_1);
		m2_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate localDate = LocalDate.now();
				Ngay.setText(localDate.toString());
				ChangPage(3);
			}
		});
		menu.add(m2_2);
		menu.add(m1_2);
		mb.add(menu);
		
		m2_4 = new JMenuItem("Import excel", icon1);
		m2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					File excelFile;
					FileInputStream excelFIS = null;
					BufferedInputStream excelBIS = null;
					XSSFWorkbook excelJTableImport = null;
					
					String defaultCurrentDirectionPath = "C:\\Users\\HP\\Documents";
					JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectionPath);
					int excelChooser = excelFileChooser.showOpenDialog(null);
					
					if (excelChooser == JFileChooser.APPROVE_OPTION) {
						try {
							excelFile = excelFileChooser.getSelectedFile();
							excelFIS = new FileInputStream(excelFile);
							excelBIS = new BufferedInputStream(excelFIS);
							
							excelJTableImport = new XSSFWorkbook(excelBIS);
							XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
						
							ArrayList<PhieuNhap> phieuTam = new ArrayList<PhieuNhap>(); 
							ArrayList<PhieuXuat> phieuTam2 = new ArrayList<PhieuXuat>(); 
							ArrayList<String> biTrung = new ArrayList<String>();
							for (int ro = 0;ro <= excelSheet.getLastRowNum();ro++) {
								XSSFRow excelRow = excelSheet.getRow(ro);
								XSSFCell excelCell = excelRow.getCell(0);
								System.out.print(excelCell.getStringCellValue() + " ");
								boolean trung = false;
								if (panel.isVisible()) {
									if (!excelCell.getStringCellValue().equals("")) {
										for (int i = 0;i < A1.size();i++) {
											if (excelCell.getStringCellValue().equals(A1.get(i).getMaBG())) {
												trung = true;
												break;
											}
										}	
									}
									if (!trung) {
										BanGhe t032 = new BanGhe();
										t032.setMaBG(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(1);
										t032.setTensp(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(2);
										t032.setChatLieu(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(3);
										t032.setSoLuong((int)excelCell.getNumericCellValue());
										excelCell = excelRow.getCell(4);
										t032.setNoiSX(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(5);
										t032.setKichThuoc(excelCell.getStringCellValue());
										System.out.println();
										
										addRowBanGhe(t032);
										
										sql.addBanGhe(t032);
										A1.add(t032);
									}
								} else if (panel_2.isVisible()) {
									if (!excelCell.getStringCellValue().equals("")) {
										for (int i = 0;i < PhieuNhapList.size();i++) {
											if (excelCell.getStringCellValue().equals(PhieuNhapList.get(i).getMaPN())) {
												trung = true;
												for (int j = 0;j < biTrung.size();j++) {
													if (PhieuNhapList.get(i).getMaPN().equals(biTrung.get(j))) {
														biTrung.add(PhieuNhapList.get(i).getMaPN()); break;
													}
												}
												break;
											}
										}	
									}
									if (!trung) {
										PhieuNhap t032 = new PhieuNhap();
										t032.setMaPN(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(1);
										t032.setNgayLapPN(new java.sql.Date(excelCell.getDateCellValue().getTime()));
										excelCell = excelRow.getCell(2);
										t032.setID(excelCell.getStringCellValue());
										
										Phieu t_34 = new Phieu();
										excelCell = excelRow.getCell(0);
										t_34.setMaPhieu(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(3);
										t_34.setMaBG(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(4);
										t_34.setSoluong((int)excelCell.getNumericCellValue());
										
										boolean trung_1 = false; 
										for (int i = 0;i < phieuTam.size();i++) {
											if (t032.getMaPN().equals(phieuTam.get(i).getMaPN())) {
												trung_1 = true;
												break;
											}
										}	
										if (!trung_1) {
											addRow2(t032);
											phieuTam.add(t032);
											sql.addPhieuNhap(t032);
										}
										DSBanGheTrongPhieu.PhieuSP.add(t_34);
										sql.addPhieu(t_34);
									}
								} else if (panel_7.isVisible()) {
									if (!excelCell.getStringCellValue().equals("")) {
										for (int i = 0;i < PhieuXuatList.size();i++) {
											if (excelCell.getStringCellValue().equals(PhieuXuatList.get(i).getMaPX())) {
												trung = true;
												for (int j = 0;j < biTrung.size();j++) {
													if (PhieuXuatList.get(i).getMaPX().equals(biTrung.get(j))) {
														biTrung.add(PhieuXuatList.get(i).getMaPX()); break;
													}
												}
												break;
											}
										}	
									}
									if (!trung) {
										PhieuXuat t032 = new PhieuXuat();
										t032.setMaPX(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(1);
										t032.setNgayLapPX(new java.sql.Date(excelCell.getDateCellValue().getTime()));
										excelCell = excelRow.getCell(2);
										t032.setID(excelCell.getStringCellValue());
										
										Phieu t_34 = new Phieu();
										excelCell = excelRow.getCell(0);
										t_34.setMaPhieu(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(3);
										t_34.setMaBG(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(4);
										t_34.setSoluong((int)excelCell.getNumericCellValue());
										
										for (int i = 0;i < phieuTam2.size();i++) {
											if (t032.getMaPX().equals(phieuTam2.get(i).getMaPX())) {
												addRow4(t032);
												phieuTam2.add(t032);
												sql.addPhieuXuat(t032);
												break;
											}
										}	
										DSBanGheTrongPhieu.PhieuSP.add(t_34);
										sql.addPhieu(t_34);
									}
								}
							}
							for (int i = 0;i < phieuTam.size();i++) 
								PhieuNhapList.add(phieuTam.get(i));
							for (int i = 0;i < phieuTam2.size();i++) 
								PhieuXuatList.add(phieuTam2.get(i));
							if (biTrung.size() > 0) {
								String trungStr = biTrung.get(0);
								for (int i = 1;i < biTrung.size();i++)
									trungStr += "\n" + biTrung.get(i);
								JOptionPane.showMessageDialog(null, "Mã phiếu sau đây đã tồn tại: \n"
										+ trungStr);
							} else 	
								JOptionPane.showMessageDialog(null, "Nhập file excel thành công");
						} catch (FileNotFoundException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
					}
			}
		});
		m3_2 = new JMenuItem("Export excel", icon2);
		m3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU = null;
				XSSFWorkbook excelJTableExporter = null;
				
				JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\HP\\Documents");
				excelFileChooser.setDialogTitle("Save As");
				
				FileNameExtensionFilter fneF = new FileNameExtensionFilter("EXCEL FILES", "xls","xlsx", "xlsm");
				excelFileChooser.setFileFilter(fneF);
				int excelChooer  = excelFileChooser.showSaveDialog(null);
				 
				if (excelChooer == JFileChooser.APPROVE_OPTION) {
					try {
						excelJTableExporter = new XSSFWorkbook();
						XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
						
						if (panel.isVisible()) {
							for (int i = 0;i < model.getRowCount();i++) {
								XSSFRow excelRow = excelSheet.createRow(i);
								for (int j = 0;j < model.getColumnCount();j++) {
									XSSFCell excelCell = excelRow.createCell(j);
									excelCell.setCellValue(model.getValueAt(i, j).toString());
								}
							}
						} else if (panel_2.isVisible()) {
							int d = 0;
							for (int k = 0;k < DSBanGheTrongPhieu.PhieuSP.size();k++) {
								for (int i = 0;i < PhieuNhapList.size();i++ ) {
									if (PhieuNhapList.get(i).getMaPN().equals(DSBanGheTrongPhieu.PhieuSP.get(k).getMaPhieu())) {
										XSSFRow excelRow = excelSheet.createRow(d);	d++;
										
										XSSFCell excelCell = excelRow.createCell(0);
										excelCell.setCellValue(PhieuNhapList.get(i).getMaPN());
										excelCell = excelRow.createCell(1);
										excelCell.setCellValue(PhieuNhapList.get(i).getNgayLapPN().toString());
										excelCell = excelRow.createCell(2);
										excelCell.setCellValue(PhieuNhapList.get(i).getID());
										excelCell = excelRow.createCell(3);
										excelCell.setCellValue(DSBanGheTrongPhieu.PhieuSP.get(k).getMaBG());
										excelCell = excelRow.createCell(4);
										excelCell.setCellValue(DSBanGheTrongPhieu.PhieuSP.get(k).getSoluong());
									}
								}
							}
						} else if (panel_7.isVisible()) {
							int d = 0;
							for (int k = 0;k < DSBanGheTrongPhieu.PhieuSP.size();k++) {
								for (int i = 0;i < PhieuXuatList.size();i++ ) {
									if (PhieuXuatList.get(i).getMaPX().equals(DSBanGheTrongPhieu.PhieuSP.get(k).getMaPhieu())) {
										XSSFRow excelRow = excelSheet.createRow(d);	d++;
										
										XSSFCell excelCell = excelRow.createCell(0);
										excelCell.setCellValue(PhieuXuatList.get(i).getMaPX());
										excelCell = excelRow.createCell(1);
										excelCell.setCellValue(PhieuXuatList.get(i).getNgayLapPX().toString());
										excelCell = excelRow.createCell(2);
										excelCell.setCellValue(PhieuXuatList.get(i).getID());
										excelCell = excelRow.createCell(3);
										excelCell.setCellValue(DSBanGheTrongPhieu.PhieuSP.get(k).getMaBG());
										excelCell = excelRow.createCell(4);
										excelCell.setCellValue(DSBanGheTrongPhieu.PhieuSP.get(k).getSoluong());
									}
								}
							}
						}
						excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+ ".xlsx");
						excelBOU = new BufferedOutputStream(excelFOU);
						excelJTableExporter.write(excelBOU);
						JOptionPane.showMessageDialog(null, "Xuất file excel thành công!");
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {
							if (excelBOU != null)
								excelBOU.close();
							if (excelFOU != null)
								excelFOU.close();
							if (excelJTableExporter != null)
								excelJTableExporter.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);
		menu.getAccessibleContext().setAccessibleDescription("File items");
		menu.add(m2_4);
		menu.add(m3_2);
		mb.add(menu);
		
		m1_1 = new JMenuItem("Red", icon6);
		m1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { doimau(255, 40, 40); }
		});
		m2_1 = new JMenuItem("Green", icon8);
		m2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { doimau(0, 204, 0); }
		});
		m3_1 = new JMenuItem("Blue", icon7);
		m3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { doimau(0, 0, 255); }
		});
		m1_3 = new JMenuItem("Default");
		m1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { doimau(64, 100, 128); }
		});
		menu_1 = new JMenu("Color");
		menu_1.setMnemonic(KeyEvent.VK_C);
		menu_1.getAccessibleContext().setAccessibleDescription("set color");
		menu_1.add(m1_1);
		menu_1.add(m2_1);
		menu_1.add(m3_1);
		menu_1.add(m1_3);
		
		JPanel panell = new JPanel();
		menu_1.add(panell);
		m1_4 = new JMenuItem("Text color", icon9);
		m1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textColor.Run();
			}
		});
		menu_1.add(m1_4);
		mb.add(menu_1);
		
		m1 = new JMenuItem("About us", icon5);
		m2_3 = new JMenuItem("Exit", icon3);	
		m2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		menu = new JMenu("System");
		menu.setMnemonic(KeyEvent.VK_S);
		menu.getAccessibleContext().setAccessibleDescription("do thing i dont know");
		frame.getContentPane().setLayout(null);
		menu.add(m1);
		menu.add(m2_3);
		mb.add(menu);
		frame.getContentPane().add(mb);
	}
	public static void ChangPage(int c) {
		if (c == 1) panel.setVisible(true); else panel.setVisible(false);
		if (c == 2) panel_2.setVisible(true); else panel_2.setVisible(false);
		if (c == 3) panel_3.setVisible(true); else panel_3.setVisible(false);
		if (c == 4) panel_7.setVisible(true); else panel_7.setVisible(false);
	}
	public static void doimau(int a,int b,int c) {
		panel.setBackground(new Color(a, b, c));
		panel_2.setBackground(new Color(a, b, c));
		panel_3.setBackground(new Color(a, b, c));
		panel_7.setBackground(new Color(a, b, c));
	}
	public static void changeC() {
		doimau(textColor.red, textColor.green, textColor.blue );
	}
}