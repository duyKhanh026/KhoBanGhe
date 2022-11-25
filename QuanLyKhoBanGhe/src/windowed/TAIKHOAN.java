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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class TAIKHOAN {

	private JFrame frame;
	private JTextField ID_text;
	private JTextField UserName_text;
	private JTextField pass_text;
	private JTextField Hoten_text;
	private JTextField DiaChi_text;
	private JTable table;
	DefaultTableModel model;
	static public ArrayList<User> userList;
	static private DataSQL sql;

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

	/**
	 * Create the application.
	 */
	public TAIKHOAN() {
		initialize();
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
		lblNewLabel.setBounds(10, 11, 74, 45);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 75, 100, 45);
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 145, 100, 45);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblPassword);
		
		JLabel lblHVTn = new JLabel("Họ và tên");
		lblHVTn.setBounds(396, 11, 100, 45);
		lblHVTn.setForeground(new Color(255, 255, 255));
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblHVTn);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setBounds(396, 145, 100, 45);
		lblGiiTnh.setForeground(new Color(255, 255, 255));
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblGiiTnh);
		
		JLabel lblaCh = new JLabel("Địa chỉ");
		lblaCh.setBounds(396, 75, 100, 45);
		lblaCh.setForeground(new Color(255, 255, 255));
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(lblaCh);
		
		ID_text = new JTextField();
		ID_text.setBounds(131, 11, 227, 45);
		ID_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(ID_text);
		ID_text.setColumns(10);
		
		UserName_text = new JTextField();
		UserName_text.setBounds(131, 75, 227, 45);
		UserName_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserName_text.setColumns(10);
		frame.getContentPane().add(UserName_text);
		
		pass_text = new JTextField();
		pass_text.setBounds(131, 145, 227, 45);
		pass_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pass_text.setColumns(10);
		frame.getContentPane().add(pass_text);
		
		Hoten_text = new JTextField();
		Hoten_text.setBounds(513, 11, 227, 45);
		Hoten_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Hoten_text.setColumns(10);
		frame.getContentPane().add(Hoten_text);
		
		DiaChi_text = new JTextField();
		DiaChi_text.setBounds(513, 75, 227, 45);
		DiaChi_text.setFont(new Font("Tahoma", Font.PLAIN, 20));
		DiaChi_text.setColumns(10);
		frame.getContentPane().add(DiaChi_text);
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = {"ID" , "Tên Đăng Nhập", "Password","Họ và tên", "Địa Chỉ", "Giới Tính"};
 		
		Object[] row = new Object[6];

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
				model.addRow(row);
			}
		}


		JRadioButton rdbtnNewRadioButton = new JRadioButton("Nam");
		rdbtnNewRadioButton.setBounds(513, 145, 103, 45);
		rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		rdbtnNewRadioButton.setBackground(new Color(0, 128, 255));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnN = new JRadioButton("Nữ");
		rdbtnN.setBounds(626, 145, 103, 45);
		rdbtnN.setForeground(new Color(255, 255, 255));
		rdbtnN.setBackground(new Color(0, 128, 255));
		rdbtnN.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(rdbtnN);
		
		
		ButtonGroup B1 = new ButtonGroup();
		B1.add(rdbtnN);
		B1.add(rdbtnNewRadioButton);
		

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
					
			}
		});
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBounds(750, 11, 130, 45);
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
					if (ID_text.getText().equals("") || UserName_text.getText().equals("") || DiaChi_text.getText().equals("") || pass_text.getText().equals("") || Hoten_text.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Vui Lòng Điền Đầy Đủ Thông Tin! ! ! ! !");
					} else {
						row[0] = ID_text.getText();
						row[1] = UserName_text.getText();
						row[2] = pass_text.getText();
						row[3] = Hoten_text.getText();
						row[4] = DiaChi_text.getText();
						boolean gtinh = true;
				        if (rdbtnNewRadioButton.isSelected()) 
				        	row[5] = "Nam"; 
				        else if (rdbtnN.isSelected()){
				            row[5] = "Nữ";
				            gtinh = false;
				        }
						model.addRow(row);
						
						User t = new User();
						t.setID(ID_text.getText());
						t.setUsername(UserName_text.getText());
						t.setPassword(pass_text.getText());
						t.setDiachi(DiaChi_text.getText());
						t.setHoten(Hoten_text.getText());
						t.setGioiTinh(gtinh);
						sql.addUser(t);
						userList.add(t);
					
						ID_text.setText("");
						UserName_text.setText("");
						pass_text.setText("");
						Hoten_text.setText("");
						DiaChi_text.setText("");
						rdbtnNewRadioButton.setSelected(false);
						rdbtnN.setSelected(false);
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
					}		
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setBounds(750, 60, 130, 45);
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnSa);
		
		JButton btnXa = new JButton("Xóa");
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
		btnXa.setBounds(750, 110, 130, 45);
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnXa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 214, 868, 310);
		frame.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnDn = new JButton("Dọn");
		btnDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ID_text.setText("");
				UserName_text.setText("");
				pass_text.setText("");
				Hoten_text.setText("");
				DiaChi_text.setText("");
				rdbtnNewRadioButton.setSelected(false);
				rdbtnN.setSelected(false);
			}
		});
		btnDn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDn.setBounds(750, 160, 130, 45);
		frame.getContentPane().add(btnDn);
		
	}
}
