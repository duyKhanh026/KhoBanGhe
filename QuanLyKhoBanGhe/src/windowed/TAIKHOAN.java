package windowed;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import BanGhe1_2.User;
import modulesL.DataSQL;
import modulesL.TimkiemGanDung;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class TAIKHOAN {

	private JFrame frame;
	private JTextField ID_text;
	private JTextField UserName_text;
	private JTextField pass_text;
	private JTextField Hoten_text;
	private JTextArea DiaChi_text;
	private JTable table;
	static DefaultTableModel model;
	public static  ArrayList<User> userList;
	private static  DataSQL sql;
	public static JRadioButton rdbtnNewRadioButton;
	public static JRadioButton rdbtnN;
	private JTextField SDT_text;
	private JTextField Email_text;
	private static Object[] row;

	/**
	 * Launch the application.
	 */
	public static void Run() {
		try {
			sql = new DataSQL();
			userList = sql.getListUser();
			TAIKHOAN window = new TAIKHOAN();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Run();
			}
		});
	}
	public static String GioiTinh() {
		if (rdbtnNewRadioButton.isSelected()) 
        	return "Nam"; 
        else if (rdbtnN.isSelected())
            return "Nữ";
        return "error";
	}

	/**
	 * Create the application.
	 */
	public TAIKHOAN() {
		initialize();
	}
	public static void HoanViUser(int i,int j) {
		User t = new User();
		t = userList.get(i);
		userList.set(i,userList.get(j));
		userList.set(j,t);
	}
	public static void addRowUser(User i) {
		row[0] = i.getID();
		row[1] = i.getUsername();
		row[2] = i.getPassword();
		row[3] = i.getHoten();
		row[4] = i.getDiachi();
		if (i.getGioiTinh())
			row[5] = "Nam";
		else row[5] = "Nữ";
		row[6] = i.getEmail();
		row[7] = i.getSDT();
		if (i.isAdmin())
			row[8] = "Admin";
		else row[8] = "Nhân viên";
		model.addRow(row);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("TAIKHOAN");
		frame.getContentPane().setBackground(new Color(0, 128, 255));
		frame.setBounds(100, 100, 904, 574);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(10, 11, 74, 33);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 55, 100, 30);
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 95, 100, 31);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblPassword);
		
		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setBounds(396, 11, 100, 33);
		lblHVTn.setForeground(new Color(255, 255, 255));
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblHVTn);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setBounds(396, 123, 100, 39);
		lblGiiTnh.setForeground(new Color(255, 255, 255));
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblGiiTnh);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(396, 55, 100, 30);
		lblaCh.setForeground(new Color(255, 255, 255));
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblaCh);
		
		ID_text = new JTextField();
		ID_text.setBounds(103, 11, 255, 33);
		ID_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(ID_text);
		ID_text.setColumns(10);
		
		UserName_text = new JTextField();
		UserName_text.setBounds(103, 55, 255, 30);
		UserName_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserName_text.setColumns(10);
		frame.getContentPane().add(UserName_text);
		
		pass_text = new JTextField();
		pass_text.setBounds(103, 95, 255, 31);
		pass_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass_text.setColumns(10);
		frame.getContentPane().add(pass_text);
		
		Hoten_text = new JTextField();
		Hoten_text.setBounds(490, 11, 250, 33);
		Hoten_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Hoten_text.setColumns(10);
		frame.getContentPane().add(Hoten_text);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"ID" , "Tên Đăng Nhập", "Password","Họ và tên", "Địa Chỉ", "Giới Tính", "Email", "SDT", "Cấp"};
 		
		row = new Object[9];

		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		if (userList != null) {
			for (int i = 0;i < userList.size();i++) {
				row[0] = userList.get(i).getID();
				row[1] = userList.get(i).getUsername();
				row[2] = userList.get(i).getPassword();
				row[3] = userList.get(i).getHoten();
				row[4] = userList.get(i).getDiachi();
				if (userList.get(i).getGioiTinh())
					row[5] = "Nam";
				else row[5] = "Nữ";
				row[6] = userList.get(i).getEmail();
				row[7] = userList.get(i).getSDT();
				if (userList.get(i).isAdmin())
					row[8] = "Admin";
				else row[8] = "Nhân viên";
				model.addRow(row);
			}
		}


		rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBounds(490, 123, 74, 39);
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(15, 135, 255));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNewRadioButton.setSelected(true);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setBounds(563, 123, 63, 39);
		rdbtnN.setForeground(new Color(255, 255, 255));
		rdbtnN.setBackground(new Color(15, 135, 255));
		rdbtnN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(rdbtnN);
		
		ButtonGroup B1 = new ButtonGroup();
		B1.add(rdbtnN);
		B1.add(rdbtnNewRadioButton);
		
		JCheckBox checkAd = new JCheckBox("");
		checkAd.setHorizontalAlignment(SwingConstants.RIGHT);
		checkAd.setBackground(new Color(0, 128, 255));
		checkAd.setForeground(new Color(255, 255, 255));
		checkAd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		checkAd.setBounds(545, 165, 21, 39);
		frame.getContentPane().add(checkAd);
		
		DiaChi_text = new JTextArea();
		DiaChi_text.setFont(new Font("Tahoma", Font.PLAIN, 18));
		DiaChi_text.setBounds(491, 55, 250, 68);
		frame.getContentPane().add(DiaChi_text);
		
		SDT_text = new JTextField();
		SDT_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SDT_text.setColumns(10);
		SDT_text.setBounds(103, 175, 255, 30);
		frame.getContentPane().add(SDT_text);
		
		Email_text = new JTextField();
		Email_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Email_text.setColumns(10);
		Email_text.setBounds(103, 134, 255, 31);
		frame.getContentPane().add(Email_text);
		

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				ID_text.setText(model.getValueAt(i, 0).toString());
				UserName_text.setText(model.getValueAt(i, 1).toString());
				pass_text.setText(model.getValueAt(i, 2).toString());
				Hoten_text.setText(model.getValueAt(i, 3).toString());
				DiaChi_text.setText(model.getValueAt(i, 4).toString());
				if (model.getValueAt(i, 5).toString().equals("Nam")) {
					rdbtnNewRadioButton.setSelected(true);
					rdbtnN.setSelected(false);
				}else {
					rdbtnNewRadioButton.setSelected(false);
					rdbtnN.setSelected(true);
				}
				Email_text.setText(model.getValueAt(i, 6).toString());
				SDT_text.setText(model.getValueAt(i, 7).toString());
				if (model.getValueAt(i, 8).toString().equals("Admin")) {
					checkAd.setSelected(true);
				}else {
					checkAd.setSelected(false);
				}	
			}
		});
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBackground(new Color(223, 239, 255));
		btnNewButton.setBounds(750, 11, 130, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trung = false;
				if (!ID_text.getText().equals("")) {
					for (int i = 0;i < userList.size();i++) {
						if (ID_text.getText().equals(userList.get(i).getID())) {
							trung = true;
							JOptionPane.showMessageDialog(null, "Mã bị trùng với " + userList.get(i).getUsername() + "!");
							break;
						}
					}	
				}
				if (trung == false) {
					if (ID_text.getText().equals("") || UserName_text.getText().equals("") || 
							DiaChi_text.getText().equals("") || pass_text.getText().equals("") || 
							Hoten_text.getText().equals("") || Email_text.getText().equals("")
							|| SDT_text.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin! ! ! ! !");
					} else {
						row[0] = ID_text.getText();
						row[1] = UserName_text.getText();
						row[2] = pass_text.getText();
						row[3] = Hoten_text.getText();
						row[4] = DiaChi_text.getText();
						row[5] = GioiTinh();
						row[6] = Email_text.getText();
						row[7] = SDT_text.getText();
						if (checkAd.isSelected()) {
							row[8] = "Admin";
						}else {
							row[8] = "Nhân viên";
						}	
				        
						model.addRow(row);
						
						User t = new User();
						t.setID(ID_text.getText());
						t.setUsername(UserName_text.getText());
						t.setPassword(pass_text.getText());
						t.setDiachi(DiaChi_text.getText());
						t.setHoten(Hoten_text.getText());
						t.setEmail(Email_text.getText());
						t.setSDT(SDT_text.getText());
						if (GioiTinh() == "Nam")
							t.setGioiTinh(true);
						else  t.setGioiTinh(false);
						if (checkAd.isSelected()) {
							t.setAdmin(true);
						}else {
							t.setAdmin(false);
						}	
						sql.addUser(t);
						userList.add(t);
					
						ID_text.setText("");
						UserName_text.setText("");
						pass_text.setText("");
						Hoten_text.setText("");
						DiaChi_text.setText("");
						Email_text.setText("");
						SDT_text.setText("");
						rdbtnNewRadioButton.setSelected(false);
						rdbtnN.setSelected(false);
						checkAd.setSelected(false);
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
					}		
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setBackground(new Color(223, 239, 255));
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean trung = false; 
				int vitri = -1;
				if (!ID_text.getText().equals("")) { 
					for (int i = 0;i < userList.size();i++) {
						if (ID_text.getText().equals(userList.get(i).getID())) { 
							trung = true; 
							vitri = i;
							break;
						}
					}	
				}
				if (trung) { 
					userList.get(vitri).setUsername(UserName_text.getText());
					userList.get(vitri).setPassword(pass_text.getText());
					userList.get(vitri).setHoten(Hoten_text.getText());
					userList.get(vitri).setDiachi(DiaChi_text.getText());
					userList.get(vitri).setGioiTinh(rdbtnNewRadioButton.isSelected());
					userList.get(vitri).setEmail(Email_text.getText());
					userList.get(vitri).setSDT(SDT_text.getText());
					userList.get(vitri).setAdmin(checkAd.isSelected());
					
					sql.UpdateUser(userList.get(vitri));
					if (vitri < model.getRowCount() && model.getValueAt(vitri, 0).equals(ID_text.getText())) {
						model.setValueAt(ID_text.getText(), vitri, 0);
						model.setValueAt(UserName_text.getText(), vitri, 1);
						model.setValueAt(pass_text.getText(), vitri, 2);
						model.setValueAt(Hoten_text.getText(), vitri, 3);
						model.setValueAt(DiaChi_text.getText(), vitri, 4);
						model.setValueAt(GioiTinh(), vitri, 5);
						model.setValueAt(Email_text.getText(), vitri, 6);
						model.setValueAt(SDT_text.getText(), vitri, 7);
						if (checkAd.isSelected()) {
							model.setValueAt("Admin", vitri, 8);
						}else {
							model.setValueAt("Nhân viên", vitri, 8);
						}	
					} else {
						for (int i = 0;i < model.getRowCount();i++) {
							if (model.getValueAt(i, 0).equals(ID_text.getText())) {
								model.setValueAt(ID_text.getText(), i, 0);
								model.setValueAt(UserName_text.getText(), i, 1);
								model.setValueAt(pass_text.getText(), i, 2);
								model.setValueAt(Hoten_text.getText(), i, 3);
								model.setValueAt(DiaChi_text.getText(), i, 4);
								model.setValueAt(GioiTinh(), i, 5);
								model.setValueAt(Email_text.getText(), i, 6);
								model.setValueAt(SDT_text.getText(), i, 7);
								if (checkAd.isSelected()) {
									model.setValueAt("Admin", i, 8);
								}else {
									model.setValueAt("Nhân viên", i, 8);
								}	
								break;
							}
						}
					}
					ID_text.setText("");
					UserName_text.setText("");
					pass_text.setText("");
					Hoten_text.setText("");
					DiaChi_text.setText("");
					Email_text.setText("");
					SDT_text.setText("");
					rdbtnNewRadioButton.setSelected(false);
					rdbtnN.setSelected(false);
					checkAd.setSelected(false);
					JOptionPane.showMessageDialog(null, "Sửa Thành Công");		
				}else { 
					if (ID_text.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Bạn chưa nhập mã!");
					else  
						JOptionPane.showMessageDialog(null, "Mã vừa nhập không tồn tại"); 
				}
			}
			
		});
		btnSa.setBounds(750, 52, 130, 33);
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnSa);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.setBackground(new Color(223, 239, 255));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i >= 0) {
					model.removeRow(i);
					userList = sql.XoaUser(userList, i);
					JOptionPane.showMessageDialog(null, "Xóa Thành Công");
					
				} else {
					JOptionPane.showMessageDialog(null, "Hãy Chọn 1 Hàng Để Xóa");
				}
			}
		});
		btnXa.setBounds(750, 92, 130, 33);
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnXa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 214, 868, 310);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnDn = new JButton("Dọn");
		btnDn.setBackground(new Color(223, 239, 255));
		btnDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID_text.setText("");
				UserName_text.setText("");
				pass_text.setText("");
				Hoten_text.setText("");
				DiaChi_text.setText("");
				Email_text.setText("");
				SDT_text.setText("");
				rdbtnNewRadioButton.setSelected(false);
				rdbtnN.setSelected(false);
				checkAd.setSelected(false);
			}
		});
		btnDn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDn.setBounds(632, 130, 108, 33);
		frame.getContentPane().add(btnDn);
		
		String str[] = {"Mã", "Username", "Tên"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox comboBox = new JComboBox(str);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0;i < userList.size();i++) {
					model.removeRow(0);
				}
				switch(comboBox.getSelectedIndex()) {
				case 0:{
					for (int i = 0;i < userList.size()-1;i++) {
						for (int j = i+1;j < userList.size();j++) {
							if (userList.get(i).getID().compareTo(userList.get(j).getID()) > 0) {
								HoanViUser(i,j);
							}
						}
					}
					break;
				}
				case 1:{
					for (int i = 0;i < userList.size()-1;i++) {
						for (int j = i+1;j < userList.size();j++) {
							if (TimkiemGanDung.unAccent(userList.get(i).getUsername()).toUpperCase().compareTo(TimkiemGanDung.unAccent(userList.get(j).getUsername()).toUpperCase()) > 0) {
								HoanViUser(i,j);
							}
						}
					}
					break;
				}
				case 2:{
					for (int i = 0;i < userList.size()-1;i++) {
						for (int j = i+1;j < userList.size();j++) {
							if (TimkiemGanDung.unAccent(userList.get(i).getHoten()).toUpperCase().compareTo(TimkiemGanDung.unAccent(userList.get(j).getHoten()).toUpperCase()) > 0) {
								HoanViUser(i,j);
							}
						}
					}
					break;
				}
				default: break;
				}
				for (int i = 0;i < userList.size();i++) {
					addRowUser(userList.get(i));
				}
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setBounds(742, 175, 116, 29);
		frame.getContentPane().add(comboBox);
		
		JLabel lblSdt = new JLabel("SDT");
		lblSdt.setForeground(Color.WHITE);
		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSdt.setBounds(10, 175, 85, 30);
		frame.getContentPane().add(lblSdt);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(10, 134, 100, 31);
		frame.getContentPane().add(lblEmail);
		
		
		JLabel lblQuynQunTr = new JLabel("Quyền quản trị");
		lblQuynQunTr.setForeground(Color.WHITE);
		lblQuynQunTr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuynQunTr.setBounds(396, 167, 149, 31);
		frame.getContentPane().add(lblQuynQunTr);
		
		JButton btnTmKim = new JButton("Tìm kiếm");
		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int rowcount = model.getRowCount();
				for (int i = 0;i < rowcount;i++)
					model.removeRow(0);
				for (int i = 0;i < userList.size();i++)
					addRowUser(userList.get(i));
				btnTmKim.setVisible(true);
				btnQuayLi.setVisible(false);
			}
		});
		btnQuayLi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnQuayLi.setBackground(new Color(223, 239, 255));
		btnQuayLi.setBounds(750, 130, 130, 33);
		frame.getContentPane().add(btnQuayLi);
		btnQuayLi.setVisible(false);
		
		
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ID_text.getText().equals("") && UserName_text.getText().equals("") &&
						DiaChi_text.getText().equals("") && pass_text.getText().equals("")&& 
						Hoten_text.getText().equals("") && Email_text.getText().equals("")
						&& SDT_text.getText().equals("") ) {
					JOptionPane.showMessageDialog(null, "Nhập Thông tin bất kì để tìm kiếm");
					return;
				} else {
					int contRow = model.getRowCount();
					for (int i =0 ;i < contRow;i++) {
						model.removeRow(0);
					}
				}
				if (!ID_text.getText().equals("")) {
					for (int i = 0;i < userList.size();i++) {
						if (ID_text.getText().equals(userList.get(i).getID())) 
							addRowUser(userList.get(i));
					}
				} else {
					boolean timThay = false;
					boolean datimthay = false;
					for (int i = 0;i < userList.size();i++) {
						timThay = false;
						if (!Hoten_text.getText().equals("")) {
							if (Hoten_text.getText().equalsIgnoreCase(userList.get(i).getHoten()))
								timThay = true;
						}
						if (!UserName_text.getText().equals("") && !timThay) {
							if (UserName_text.getText().equalsIgnoreCase(userList.get(i).getUsername()))
								timThay = true;
						}
						if (!pass_text.getText().equals("") && !timThay) {
							String p = winBG.Phuongthuckhoitaomatkhautheophuongthucthemkhoangtrongphanduoi(pass_text.getText());
							if (p.equals(userList.get(i).getPassword()))
								timThay = true;
						}
						if (!DiaChi_text.getText().equals("") && !timThay) {
							if (DiaChi_text.getText().equalsIgnoreCase(userList.get(i).getDiachi()))
								timThay = true;
						}
						if (!Email_text.getText().equals("") && !timThay) {
							if (Email_text.getText().equalsIgnoreCase(userList.get(i).getEmail()))
								timThay = true;
						}
						if (timThay) {
							addRowUser(userList.get(i));
							datimthay = true;
						} 
					}
					if (!datimthay && !UserName_text.getText().equals("")) {
						ArrayList<User> A2 = TimkiemGanDung.TimUserGanDung(userList, UserName_text.getText());
						for (int i = 0;i < A2.size();i++) {
							addRowUser(A2.get(i));
						}
						datimthay = true;
					}
					if (!datimthay && !Hoten_text.getText().equals("")) {
						ArrayList<User> A2 = TimkiemGanDung.TimHotenGanDung(userList, Hoten_text.getText());
						for (int i = 0;i < A2.size();i++) {
							addRowUser(A2.get(i));
						}
					}
				}
				btnQuayLi.setVisible(true);
				btnTmKim.setVisible(false);
			}
		});
		btnTmKim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTmKim.setBackground(new Color(223, 239, 255));
		btnTmKim.setBounds(750, 130, 130, 33);
		frame.getContentPane().add(btnTmKim);
		
		JLabel lblNewLabel_1 = new JLabel("Sắp xếp theo:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(616, 174, 116, 30);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
