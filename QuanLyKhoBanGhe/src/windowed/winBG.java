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
import modulesL.SwingControlDemo;

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


public class winBG {

	private JFrame frame;
	static public ArrayList<BanGhe> A1; 
	static public ArrayList<User> userList;
	static public ArrayList<PhieuNhap> PhieuNhapList;
	static public ArrayList<PhieuXuat> PhieuXuatList;
	static public int SL;
	private JTextField PrName_text;
	private JTextField NoiSX_text;
	private JTextField ChatLieu_text;
	private JTextField KichThuoc_test;
	DefaultTableModel model;
	DefaultTableModel model1;
	DefaultTableModel model2;
	DefaultTableModel model3;
	DefaultTableModel model4;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField Sluong_text;
	private JTextField PrID_text;
	private JTextField MaPhieu;
	private JTextField Ngay;
	private JTextField Maban;
	private JTextField SoluongB;
	private JTextField Username_text;
	private JPasswordField passwordField;
	static public DataSQL sql;
	private JTable table_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
	public static JPanel panel_3;
	public static JPanel panel_7;
	
	public static boolean adminP;
	private JTable table_4;
	public static void setAdminP(boolean ader) {
		adminP = ader;
	}
	public void LuuList() {
		
	}
	public String Phuongthuckhoitaomatkhautheophuongthucthemkhoangtrongphanduoi(String t) {
		String h = t;
		for (int i = 0;i < 16-t.length();i++) {
			h += ' ';
		}
		return h;
	}
	public static void Run() {
		try {
			sql = new DataSQL();
			A1 = sql.getListBanGhe();
			userList = sql.getListUser();
			PhieuNhapList = sql.getListPhieuNhap();
			PhieuXuatList = sql.getListPhieuXuat();
			
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
	      java.net.URL imgURL = SwingControlDemo.class.getResource(path);
	      
	      if (imgURL != null) {
	         return new ImageIcon(imgURL, description);
	      } else {            
	         System.err.println("Couldn't find file: " + path);
	         return null;
	      }
	   }
	
	private void initialize() {

		if (DSBanGheTrongPhieu.PhieuSP == null)
			DSBanGheTrongPhieu.SetListDS();
		
		
		frame = new JFrame("Quản Lý Kho Bàn Ghế");
		frame.setBounds(100, 100, 924, 618);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(126, 162, 190));
		frame.getContentPane().setLayout(null);
		
		/////PHẦN DÀNH CHO CÁC BẢNG
		model = new DefaultTableModel();
		model1 = new DefaultTableModel();
		model2 = new DefaultTableModel();
		model3 = new DefaultTableModel();
		model4 = new DefaultTableModel();
		
		Object[] column = {"ID","Tên SP","Chất liệu", "Số lượng","Nơi SX","Kích thước"}; 
		Object[] column1 = {"Mã Bàn Ghế","Số Lượng"};
		Object[] column2 = {"Mã Phiếu", "Ngày", "Người Nhập"};
		Object[] column3 = {"ID" , "Tên Đăng Nhập", "Password"};
		Object[] column4 = {"Mã Phiếu", "Ngày", "Người Nhập"};
 		
		Object[] row = new Object[6];
		Object[] row1 = new Object[2];
		Object[] row2 = new Object[3];
		Object[] row3 = new Object[3];
		Object[] row4 = new Object[3];
 		

		model.setColumnIdentifiers(column);
		model1.setColumnIdentifiers(column1);
		model2.setColumnIdentifiers(column2);
		model3.setColumnIdentifiers(column3);
		model4.setColumnIdentifiers(column4);
		//////////////////////
		
		if (A1 != null) {
			for (int i = 0; i < A1.size();i++) {
				row[0] = A1.get(i).getMaBG();
				row[1] = A1.get(i).getTensp();
				row[2] = A1.get(i).getChatLieu();
				row[3] = A1.get(i).getSoLuong();
				row[4] = A1.get(i).getNoiSX();
				row[5] = A1.get(i).getKichThuoc();
				model.addRow(row);
			}
		}
		if (userList != null) {
			for (int i = 0;i < userList.size();i++) {
				row3[0] = userList.get(i).getID();
				row3[1] = userList.get(i).getUsername();
				row3[2] = userList.get(i).getPassword();
				model3.addRow(row3);
			}
		}
		if (PhieuNhapList != null) {
			for (int i = 0;i < PhieuNhapList.size();i++) {
				row2[0] = PhieuNhapList.get(i).getMaPN();
				row2[1] = PhieuNhapList.get(i).getNgayLapPN();
				row2[2] = PhieuNhapList.get(i).getID();
				model2.addRow(row2);
			}
		}
		if (PhieuXuatList != null) {
			for (int i = 0;i < PhieuXuatList.size();i++) {
				row4[0] = PhieuXuatList.get(i).getMaPX();
				row4[1] = PhieuXuatList.get(i).getNgayLapPX();
				row4[2] = PhieuXuatList.get(i).getID();
				model4.addRow(row4);
			}
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
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(209, 131, 252));
		frame.getContentPane().add(panel_6);
		panel_6.setLayout(null);
		panel_6.setVisible(false);
		
		panel_7 = new JPanel();
		panel_7.setBackground(new Color(64, 100, 128));
		frame.getContentPane().add(panel_7);
		panel_7.setVisible(false);
		

		panel.setBounds(0, 28, 926, 552);
		panel_2.setBounds(0, 28, 926, 552);
		panel_3.setBounds(0, 27, 926, 552);
		panel_5.setBounds(0, 0, 908, 579);   // phần đăng nhập
		panel_6.setBounds(0, 28, 1081, 552); // admin
		panel_7.setBounds(0, 28, 926, 552); // danh sách phieu xuất
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 11, 875, 530);
		panel_7.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table_4.getSelectedRow();
				DSBanGheTrongPhieu.setMaP(model4.getValueAt(i, 0).toString());
				DSBanGheTrongPhieu.Run();
				//KichThuoc_test.setText(model.getValueAt(i, 5).toString());
			}
		});
		table_4.setModel(model4);
		scrollPane_4.setViewportView(table_4);
		
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
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 880, 530);
		panel_2.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(model2);
		
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
		
		table_3 = new JTable();
		table_3.setModel(model3);
		table_3.setBackground(new Color(233, 194, 254));
		
		
		MaPhieu = new JTextField();
		MaPhieu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		MaPhieu.setBounds(127, 13, 213, 49);
		panel_3.add(MaPhieu);
		MaPhieu.setColumns(10);
		
		Ngay = new JTextField();
		Ngay.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Ngay.setBounds(127, 75, 213, 49);
		Ngay.setColumns(10);
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
		
		JButton btnNewButton_2 = new JButton("Thêm");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(737, 11, 153, 42);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trung = false; // kiểm tra trùng 
				if (!Maban.getText().equals("")) { // nếu như mã nhập có ký tự 
					for (int i = 0;i < A1.size();i++) {
						if (Maban.getText().equals(A1.get(i).getMaBG())) { 
							trung = true; // tức là có tồn tại mã vừa nhập trong danh sách sản phẩm 
							break;
						}
					}	
				}
				if (trung) { // lấy giá trị từ đoạn trên 
					if (Maban.getText().equals("") || SoluongB.getText().equals("") || MaPhieu.getText().equals("") || Ngay.getText().equals("")) // kiểm tra các thông tin đã điền có đầy đủ ko
					{
						JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin! ! ! ! !"); 
					} else {
						row1[0] = Maban.getText();
						row1[1] = SoluongB.getText();
						model1.addRow(row1);
					
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
		
		
		
		JButton btnNewButton_1 = new JButton("Cập Nhật");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trung = false; 
				int vitri = -1;
				if (!PrID_text.getText().equals("")) { 
					for (int i = 0;i < A1.size();i++) {
						if (PrID_text.getText().equals(A1.get(i).getMaBG())) { 
							trung = true; 
							vitri = i;
							break;
						}
					}	
				}
				if (trung) { 
					model.setValueAt(PrID_text.getText(), vitri, 0);
					model.setValueAt(PrName_text.getText(), vitri, 1);
					model.setValueAt(ChatLieu_text.getText(), vitri, 2);
					model.setValueAt(Sluong_text.getText(), vitri, 3);
					model.setValueAt(NoiSX_text.getText(), vitri, 4);
					model.setValueAt(KichThuoc_test.getText(), vitri, 5);
					
					
					A1.get(vitri).setMaBG(PrID_text.getText());
					A1.get(vitri).setTensp( PrName_text.getText());
					A1.get(vitri).setChatLieu(ChatLieu_text.getText());
					A1.get(vitri).setSoLuong( Integer.parseInt(Sluong_text.getText()));
					A1.get(vitri).setNoiSX(NoiSX_text.getText());
					A1.get(vitri).setKichThuoc( KichThuoc_test.getText());
					
					sql.UpdateBanGhe(A1.get(vitri));
				
					PrID_text.setText("");
					PrName_text.setText("");
					ChatLieu_text.setText("");
					NoiSX_text.setText("");
					Sluong_text.setText("");
					KichThuoc_test.setText("");
					JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");		
				}else { 
					if (PrID_text.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã cho sản phẩm!");
					else  
						JOptionPane.showMessageDialog(null, "Mã vừa nhập không tồn tại"); 
				}
			}
		});
		btnNewButton_1.setBounds(650, 72, 115, 48);
		panel.add(btnNewButton_1);
		if (!adminP) {
			panel.remove(btnNewButton_1);
		}
			
		//frame.getContentPane().remove(panel);
		
		JButton btnNewButton = new JButton("Thêm SP");
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
						row[0] = PrID_text.getText();
						row[1] = PrName_text.getText();
						row[2] = ChatLieu_text.getText();
						row[3] = Sluong_text.getText();
						row[4] = NoiSX_text.getText();
						row[5] = KichThuoc_test.getText();
						model.addRow(row);
						
						BanGhe t = new BanGhe();
						t.setMaBG(PrID_text.getText());
						t.setTensp( PrName_text.getText());
						t.setChatLieu(ChatLieu_text.getText());
						t.setSoLuong( Integer.parseInt(Sluong_text.getText()));
						t.setNoiSX(NoiSX_text.getText());
						t.setKichThuoc( KichThuoc_test.getText());
						sql.addBanGhe(t);
						A1.add(t);
					
						PrID_text.setText("");
						PrName_text.setText("");
						ChatLieu_text.setText("");
						NoiSX_text.setText("");
						Sluong_text.setText("");
						KichThuoc_test.setText("");
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
					}		
				}
			}
		});
		btnNewButton.setBounds(650, 13, 115, 48);
		panel.add(btnNewButton);
		
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
		scrollPane.setBounds(10, 208, 880, 333);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(194, 11, 548, 355);
		panel_6.add(scrollPane_3);
		
		

		//scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		scrollPane_1.setViewportView(table_1);
		scrollPane_2.setViewportView(table_2);
		scrollPane_3.setViewportView(table_3);
		
		JButton btnNewButton_4 = new JButton("Thêm");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(10, 187, 142, 23);
		panel_6.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Sửa");
		btnNewButton_4_1.setBounds(10, 221, 142, 23);
		panel_6.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_1_1 = new JButton("Xóa");
		btnNewButton_4_1_1.setBounds(10, 255, 142, 23);
		panel_6.add(btnNewButton_4_1_1);
		
		JButton btnNewButton_4_1_2 = new JButton("Khóa đăng nhập");
		btnNewButton_4_1_2.setBounds(10, 288, 142, 23);
		panel_6.add(btnNewButton_4_1_2);
		
		JButton btnNewButton_4_1_3 = new JButton("Đăng Xuất");
		btnNewButton_4_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panel_5.setVisible(true);
				panel_6.setVisible(false);
			}
		});
		btnNewButton_4_1_3.setBounds(10, 322, 142, 23);
		panel_6.add(btnNewButton_4_1_3);
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 12, 75, 23);
		panel_6.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(10, 32, 154, 20);
		panel_6.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Username");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(10, 57, 75, 23);
		panel_6.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 77, 154, 20);
		panel_6.add(textField_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Password");
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(10, 102, 75, 23);
		panel_6.add(lblNewLabel_3_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 122, 154, 20);
		panel_6.add(textField_2);
		
		JRadioButton rdbtnPhieuNhap = new JRadioButton("Nhập Kho");
		rdbtnPhieuNhap.setForeground(new Color(255, 255, 255));
		rdbtnPhieuNhap.setBackground(new Color(64, 100, 128));
		rdbtnPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnPhieuNhap.setBounds(127, 135, 92, 49);
		panel_3.add(rdbtnPhieuNhap);
		
		JRadioButton rdbtnXuatKho = new JRadioButton("Xuất Kho");
		rdbtnXuatKho.setForeground(new Color(255, 255, 255));
		rdbtnXuatKho.setBackground(new Color(64, 100, 128));
		rdbtnXuatKho.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnXuatKho.setBounds(221, 135, 98, 49);
		panel_3.add(rdbtnXuatKho);
		
		ButtonGroup G = new ButtonGroup();
		G.add(rdbtnPhieuNhap);
		G.add(rdbtnXuatKho);
		
		JButton btnNewButton_2_1 = new JButton("Lưu");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnPhieuNhap.isSelected()) {
					LocalDate localDate = LocalDate.now();
					PhieuNhap t567 = new PhieuNhap();
					t567.setMaPN(MaPhieu.getText());
					t567.setNgayLapPN(java.sql.Date.valueOf(localDate));
					t567.setID(userList.get(userNow).getID());
					sql.addPhieuNhap(t567);
					for (int i = 0;i < model1.getRowCount();i++) {
						Phieu t452 = new Phieu();
						t452.setMaPhieu(t567.getMaPN());
						t452.setMaBG(model1.getValueAt(i, 0).toString());
						t452.setSoluong(Integer.parseInt(model1.getValueAt(i, 1).toString()));
						sql.addPhieu(t452);
					}
					MaPhieu.setText("");
					Maban.setText("");
					SoluongB.setText("");
				} else if (rdbtnXuatKho.isSelected()) {
					LocalDate localDate = LocalDate.now();
					PhieuXuat t567 = new PhieuXuat();
					t567.setMaPX(MaPhieu.getText());
					t567.setNgayLapPX(java.sql.Date.valueOf(localDate));
					t567.setID(userList.get(userNow).getID());
					sql.addPhieuXuat(t567);
					for (int i = 0;i < model1.getRowCount();i++) {
						Phieu t452 = new Phieu();
						t452.setMaPhieu(t567.getMaPX());
						t452.setMaBG(model1.getValueAt(i, 0).toString());
						t452.setSoluong(Integer.parseInt(model1.getValueAt(i, 1).toString()));
						sql.addPhieu(t452);
					}
					MaPhieu.setText("");
					Maban.setText("");
					SoluongB.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Chưa chọn loại phiếu");
				}
				
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_1.setBounds(737, 167, 153, 40);
		panel_3.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_2 = new JButton("Xóa");
		btnNewButton_2_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table_1.getSelectedRow();
				if (i >= 0) {
					model1.removeRow(i);
					SoluongB.setText("");
					Maban.setText("");
					JOptionPane.showMessageDialog(null, "Xóa Thành Công");
					
				} else {
					JOptionPane.showMessageDialog(null, "Hãy Chọn 1 Hàng Để Xóa");
				}
				
			}
		});
		btnNewButton_2_2.setBounds(737, 115, 153, 42);
		panel_3.add(btnNewButton_2_2);
		
		JButton btnNewButton_2_3 = new JButton("Sửa");
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
		btnNewButton_2_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SoluongB.setText("");
				Maban.setText("");
			}
		});
		btnNewButton_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2_3_1.setBounds(527, 128, 98, 31);
		panel_3.add(btnNewButton_2_3_1);
		
		JButton btnNewButton_1_1 = new JButton("Xóa SP");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(775, 72, 112, 48);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Tim kiếm");
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (PrID_text.getText().equals("") && PrName_text.getText().equals("") && ChatLieu_text.getText().equals("") 
						&& NoiSX_text.getText().equals("") && Sluong_text.getText().equals("")  && KichThuoc_test.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Nhập Thông tin bất kì để tìm kiếm");
					if (model.getRowCount() < A1.size()) {
						int contRow = model.getRowCount();
						for (int i =0 ;i < contRow;i++) {
							model.removeRow(0);
						}
						for (int i = 0;i < A1.size();i++) {
							row[0] = A1.get(i).getMaBG();
							row[1] = A1.get(i).getTensp();
							row[2] = A1.get(i).getChatLieu();
							row[3] = A1.get(i).getSoLuong();
							row[4] = A1.get(i).getNoiSX();
							row[5] = A1.get(i).getKichThuoc();
							model.addRow(row);
						}
					}
				} else {
					int contRow = model.getRowCount();
					for (int i =0 ;i < contRow;i++) {
						model.removeRow(0);
					}
				}
				if (!PrID_text.getText().equals("")) {
					for (int i = 0;i < A1.size();i++) {
						if (PrID_text.getText().equals(A1.get(i).getMaBG())) {
							row[0] = A1.get(i).getMaBG();
							row[1] = A1.get(i).getTensp();
							row[2] = A1.get(i).getChatLieu();
							row[3] = A1.get(i).getSoLuong();
							row[4] = A1.get(i).getNoiSX();
							row[5] = A1.get(i).getKichThuoc();
							model.addRow(row);
						}
					}
				} else {
					boolean timThay = false;
					for (int i = 0;i < A1.size();i++) {
						timThay = false;
						if (!PrName_text.getText().equals("")) 
							if (PrName_text.getText().equalsIgnoreCase(A1.get(i).getTensp())) 
								timThay = true;
						if (!ChatLieu_text.getText().equals("")) {
							if (ChatLieu_text.getText().equalsIgnoreCase(A1.get(i).getChatLieu()))
								timThay = true;
							else 
								timThay = false;
						}
						if (!NoiSX_text.getText().equals("")) {
							if (NoiSX_text.getText().equalsIgnoreCase(A1.get(i).getNoiSX()))
								timThay = true;
							else 
								timThay = false;
						}
						if (!Sluong_text.getText().equals("")) {
							if (Integer.parseInt(Sluong_text.getText()) == A1.get(i).getSoLuong())
								timThay = true;
							else 
								timThay = false;
						}
						if (!KichThuoc_test.getText().equals("")) {
							if (KichThuoc_test.getText().equalsIgnoreCase(A1.get(i).getKichThuoc()))
								timThay = true;
							else 
								timThay = false;
						}
						if (timThay) {
							row[0] = A1.get(i).getMaBG();
							row[1] = A1.get(i).getTensp();
							row[2] = A1.get(i).getChatLieu();
							row[3] = A1.get(i).getSoLuong();
							row[4] = A1.get(i).getNoiSX();
							row[5] = A1.get(i).getKichThuoc();
							model.addRow(row);
						}
					}
				}
			}
		});
		btnNewButton_1_2.setBounds(775, 13, 112, 48);
		panel.add(btnNewButton_1_2);
		
		if (!adminP) {
			panel.remove(btnNewButton_1_1);
			btnNewButton_1_2.setBounds(650, 72, 115, 48);
		}
		
		Sluong_text = new JTextField();//số lượng
		Sluong_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Sluong_text.setBounds(448, 129, 195, 35);
		panel.add(Sluong_text);
		Sluong_text.setColumns(10);
		
		JLabel Sluong = new JLabel("Số Lượng");
		Sluong.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Sluong.setBounds(346, 139, 92, 25);
		panel.add(Sluong);
		Sluong.setForeground(Color.WHITE);
		
		JLabel KichThuoc = new JLabel("Kích thước");
		KichThuoc.setFont(new Font("Tahoma", Font.PLAIN, 19));
		KichThuoc.setBounds(346, 76, 92, 26);
		panel.add(KichThuoc);
		KichThuoc.setForeground(new Color(255, 255, 255));
		
		KichThuoc_test = new JTextField();//Hình Dạng
		KichThuoc_test.setFont(new Font("Tahoma", Font.PLAIN, 19));
		KichThuoc_test.setBounds(448, 71, 195, 37);
		panel.add(KichThuoc_test);
		KichThuoc_test.setColumns(10);
		
		ChatLieu_text = new JTextField();  //chất liệu
		ChatLieu_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ChatLieu_text.setBounds(448, 14, 195, 35);
		panel.add(ChatLieu_text);
		ChatLieu_text.setColumns(10);
		
		JLabel ChatLieu = new JLabel("Chất liệu");
		ChatLieu.setFont(new Font("Tahoma", Font.PLAIN, 19));
		ChatLieu.setBounds(346, 19, 92, 25);
		panel.add(ChatLieu);
		ChatLieu.setForeground(new Color(255, 255, 255));
		
		JLabel NoiSX = new JLabel("Nơi SX");
		NoiSX.setFont(new Font("Tahoma", Font.PLAIN, 19));
		NoiSX.setBounds(10, 134, 108, 35);
		panel.add(NoiSX);
		NoiSX.setForeground(new Color(255, 255, 255));
		
		NoiSX_text = new JTextField(); // nguồn Gốc
		NoiSX_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		NoiSX_text.setBounds(143, 132, 176, 34);
		panel.add(NoiSX_text);
		NoiSX_text.setColumns(10);
		
		JLabel PrName = new JLabel("Tên Sản phẩm");
		PrName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PrName.setBounds(10, 72, 123, 35);
		panel.add(PrName);
		PrName.setForeground(new Color(255, 255, 255));
		
		PrName_text = new JTextField();
		PrName_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PrName_text.setBounds(143, 70, 176, 35);
		panel.add(PrName_text);
		PrName_text.setColumns(10);
		
		PrID_text = new JTextField(); //ID
		PrID_text.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PrID_text.setBounds(143, 14, 176, 35);
		panel.add(PrID_text);
		PrID_text.setColumns(10);
		
		
		JLabel PrID = new JLabel("ID");
		PrID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		PrID.setBounds(10, 14, 108, 37);
		panel.add(PrID);
		PrID.setForeground(Color.WHITE);
		
		JButton btnNewButton_1_1_1 = new JButton("Dọn");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrID_text.setText("");
				PrName_text.setText("");
				ChatLieu_text.setText("");
				NoiSX_text.setText("");
				Sluong_text.setText("");
				KichThuoc_test.setText("");
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1_1.setBounds(650, 131, 115, 48);
		panel.add(btnNewButton_1_1_1);
		
		
		if (adminP) {
			panel.setVisible(true);
			panel_2.setVisible(false);
			panel_3.setVisible(false);
			panel_5.setVisible(false);
		}
		
		
		
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
						panel.setVisible(true);
						panel_2.setVisible(false);
						panel_3.setVisible(false);
						panel_5.setVisible(false);
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công tài khoản " + userList.get(userNow).getUsername() );
						Username_text.setText("");
						passwordField.setText("");
					}
					
				} else 
					JOptionPane.showMessageDialog(null, "Thông tin đã điền chưa đúng");
				if (userList == null) {
					panel.setVisible(true);
					panel_2.setVisible(false);
					panel_3.setVisible(false);
					panel_5.setVisible(false);
					JOptionPane.showMessageDialog(null, "Đăng Nhập Mới ");
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
		
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
					A1 = sql.XoaSanPham(A1, i);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công");
					
				} else {
					JOptionPane.showMessageDialog(null, "Hãy Chọn 1 Hàng Để Xóa");
				}
			}
		});
		

		//ImageIcon icon = createImageIcon("/folders.png","Java");
	    ImageIcon icon1 = createImageIcon("/import.png","Java");
	    ImageIcon icon2 = createImageIcon("/export.png","Java");
	    ImageIcon icon3 = createImageIcon("/exit.png","Java");
	   // ImageIcon icon4 = createImageIcon("/logout.png","Java");
	    ImageIcon icon5 = createImageIcon("/aboutus.png","Java");
	    ImageIcon icon6 = createImageIcon("/red.png","Java");
	    ImageIcon icon7 = createImageIcon("/blue.png","Java");
	    ImageIcon icon8 = createImageIcon("/green.png","Java");
	    ImageIcon icon9 = createImageIcon("/textEdit.png","Java");
	    //ImageIcon icon_1 = createImageIcon("/81411.png","Java");
		
		mb = new JMenuBar();
		mb.setBounds(0, 0, 908, 28);
		
		m1 = new JMenuItem("Phiếu xuất");
		m1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_7.setVisible(true);
			}
		});
		m2 = new JMenuItem("Sản phẩm");
		m2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_7.setVisible(false);
			}
		});
		m3 = new JMenuItem("Phiếu Nhập");
		m3.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_2.setVisible(true);
				panel_3.setVisible(false);
				panel_7.setVisible(false);
			}
		});
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_M);
		menu.getAccessibleContext().setAccessibleDescription("File items");
		menu.add(m2);menu.add(m3);menu.add(m1);
		m1_2 = new JMenuItem("Đăng xuất"); 
		m1_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(false);
				panel_7.setVisible(false);
				panel_5.setVisible(true);
			}
		});
		m2_2 = new JMenuItem("Nhập phiếu");
		m2_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		m2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate localDate = LocalDate.now();
				Ngay.setText(localDate.toString());
				panel.setVisible(false);
				panel_2.setVisible(false);
				panel_3.setVisible(true);
				panel_7.setVisible(false);
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
						
							//if (panel_2.isVisible())
							ArrayList<PhieuNhap> phieuTam = new ArrayList<PhieuNhap>(); 
							ArrayList<PhieuXuat> phieuTam2 = new ArrayList<PhieuXuat>(); 
							for (int ro = 0;ro <= excelSheet.getLastRowNum();ro++) {
								XSSFRow excelRow = excelSheet.getRow(ro);
								//for (int colm = 0;colm < excelRow.getLastCellNum();colm++) {
								//	XSSFCell excelCell = excelRow.getCell(colm);
								//	System.out.print(excelCell.getStringCellValue());
								//}
									
								XSSFCell excelCell = excelRow.getCell(0);
								System.out.print(excelCell.getStringCellValue() + " ");
								boolean trung = false;
								if (panel.isVisible()) {
									System.out.println("No dang chay dieeeennnn");
									if (!excelCell.getStringCellValue().equals("")) {
										for (int i = 0;i < A1.size();i++) {
											if (excelCell.getStringCellValue().equals(A1.get(i).getMaBG())) {
												trung = true;
												System.out.printf(" bi trung\n");
												break;
											}
										}	
									}
									if (!trung) {
										BanGhe t032 = new BanGhe();
										t032.setMaBG(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(1);
										System.out.print(excelCell.getStringCellValue() + " ");
										t032.setTensp(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(2);
										System.out.print(excelCell.getStringCellValue() + " ");
										t032.setChatLieu(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(3);
										System.out.print(excelCell.getNumericCellValue() + " ");
										t032.setSoLuong((int)excelCell.getNumericCellValue());
										excelCell = excelRow.getCell(4);
										System.out.print(excelCell.getStringCellValue() + " ");
										t032.setNoiSX(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(5);
										System.out.print(excelCell.getStringCellValue() + " ");
										t032.setKichThuoc(excelCell.getStringCellValue());
										System.out.println();
										
										row[0] = t032.getMaBG();
										row[1] = t032.getTensp();
										row[2] = t032.getChatLieu();
										row[3] = t032.getSoLuong();
										row[4] = t032.getNoiSX();
										row[5] = t032.getKichThuoc();
										model.addRow(row);
										
										sql.addBanGhe(t032);
										A1.add(t032);
									}
								} else if (panel_2.isVisible()) {
									if (!excelCell.getStringCellValue().equals("")) {
										for (int i = 0;i < PhieuNhapList.size();i++) {
											if (excelCell.getStringCellValue().equals(PhieuNhapList.get(i).getMaPN())) {
												trung = true;
												System.out.printf(" bi trung\n");
												break;
											}
										}	
									}
									if (!trung) {
										PhieuNhap t032 = new PhieuNhap();
										t032.setMaPN(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(1);
										System.out.print(excelCell.getDateCellValue() + " ");
										t032.setNgayLapPN(new java.sql.Date(excelCell.getDateCellValue().getTime()));
										excelCell = excelRow.getCell(2);
										System.out.print(excelCell.getStringCellValue() + " ");
										t032.setID(excelCell.getStringCellValue());
										
										Phieu t_34 = new Phieu();
										excelCell = excelRow.getCell(0);
										System.out.print(excelCell.getStringCellValue() + " ");
										t_34.setMaPhieu(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(3);
										System.out.print(excelCell.getStringCellValue() + " ");
										t_34.setMaBG(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(4);
										System.out.println(excelCell.getNumericCellValue() + " ");
										t_34.setSoluong((int)excelCell.getNumericCellValue());
										
										boolean trung_1 = false; 
										for (int i = 0;i < phieuTam.size();i++) {
											if (t032.getMaPN().equals(phieuTam.get(i).getMaPN())) {
												trung_1 = true;
												break;
											}
										}	
										if (!trung_1) {
											row2[0] = t032.getMaPN();
											row2[1] = t032.getNgayLapPN();
											row2[2] = t032.getID();
											model2.addRow(row2);
											phieuTam.add(t032);
										}
										
										
										DSBanGheTrongPhieu.PhieuSP.add(t_34);
									}
								} else if (panel_7.isVisible()) {
									if (!excelCell.getStringCellValue().equals("")) {
										for (int i = 0;i < PhieuXuatList.size();i++) {
											if (excelCell.getStringCellValue().equals(PhieuXuatList.get(i).getMaPX())) {
												trung = true;
												System.out.printf(" bi trung\n");
												break;
											}
										}	
									}
									if (!trung) {
										PhieuXuat t032 = new PhieuXuat();
										t032.setMaPX(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(1);
										System.out.print(excelCell.getDateCellValue() + " ");
										t032.setNgayLapPX(new java.sql.Date(excelCell.getDateCellValue().getTime()));
										excelCell = excelRow.getCell(2);
										System.out.print(excelCell.getStringCellValue() + " ");
										t032.setID(excelCell.getStringCellValue());
										
										Phieu t_34 = new Phieu();
										excelCell = excelRow.getCell(0);
										System.out.print(excelCell.getStringCellValue() + " ");
										t_34.setMaPhieu(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(3);
										System.out.print(excelCell.getStringCellValue() + " ");
										t_34.setMaBG(excelCell.getStringCellValue());
										excelCell = excelRow.getCell(4);
										System.out.println(excelCell.getNumericCellValue() + " ");
										t_34.setSoluong((int)excelCell.getNumericCellValue());
										
										boolean trung_1 = false; 
										for (int i = 0;i < phieuTam2.size();i++) {
											if (t032.getMaPX().equals(phieuTam2.get(i).getMaPX())) {
												trung_1 = true;
												break;
											}
										}	
										if (!trung_1) {
											row4[0] = t032.getMaPX();
											row4[1] = t032.getNgayLapPX();
											row4[2] = t032.getID();
											model4.addRow(row4);
											phieuTam2.add(t032);
										}
										
										
										DSBanGheTrongPhieu.PhieuSP.add(t_34);
									}
								}
							}
							for (int i = 0;i < phieuTam.size();i++) {
								PhieuNhapList.add(phieuTam.get(i));
							}
							for (int i = 0;i < phieuTam2.size();i++) {
								PhieuXuatList.add(phieuTam2.get(i));
							}
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
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(new Color(255, 40, 40));
				panel_2.setBackground(new Color(255, 40, 40));
				panel_3.setBackground(new Color(255, 40, 40));
				panel_7.setBackground(new Color(255, 40, 40));
			}
		});
		m2_1 = new JMenuItem("Green", icon8);
		m2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(new Color(0, 204, 0));
				panel_2.setBackground(new Color(0, 204, 0));
				panel_3.setBackground(new Color(0, 204, 0));
				panel_7.setBackground(new Color(0, 204, 0));
			}
		});
		m3_1 = new JMenuItem("Blue", icon7);
		m3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(new Color(0, 0, 255));
				panel_2.setBackground(new Color(0, 0, 255));
				panel_3.setBackground(new Color(0, 0, 255));
				panel_7.setBackground(new Color(0, 0, 255));
			}
		});
		m1_3 = new JMenuItem("Default");
		m1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(new Color(64, 100, 128));
				panel_2.setBackground(new Color(64, 100, 128));
				panel_3.setBackground(new Color(64, 100, 128));
				panel_7.setBackground(new Color(64, 100, 128));
			}
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
	public static void changeC() {
		panel.setBackground(new Color(textColor.red, textColor.green, textColor.blue ));
		panel_2.setBackground(new Color(textColor.red, textColor.green, textColor.blue ));
		panel_3.setBackground(new Color(textColor.red, textColor.green, textColor.blue ));
		panel_7.setBackground(new Color(textColor.red, textColor.green, textColor.blue ));
	}
}