package BanGhe1_2;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class DSBanGheTrongPhieu {

	private JFrame frame;
	private JTable table;
	public static String MaP;
	static public ArrayList<Phieu> PhieuSP;
	static public ArrayList<Phieu> PhieuHienCO;
	static public DataSQL sql;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void setMaP(String m) {
		MaP = m;
		System.out.print(MaP + "|");
	}
	public static void Run() {
		try {
			sql = new DataSQL();
			PhieuSP = sql.getListLuuLS();
			for (int i = 0;i < PhieuSP.size();i++) {
				System.out.println(PhieuSP.get(i).getMaPhieu());
			}
			PhieuHienCO = new ArrayList<Phieu>();
			System.out.println("Phieu nhap: " + MaP);
			for (int i = 0;i < PhieuSP.size();i++) {
				System.out.print("Nhan");
				if (PhieuSP.get(i).getMaPhieu().equals(MaP)) {
					PhieuHienCO.add(PhieuSP.get(i));		
				}
			}
			DSBanGheTrongPhieu window = new DSBanGheTrongPhieu();
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
	public DSBanGheTrongPhieu() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 465);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //đóng các frame liên quan
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //chỉ đóng chính nó
		frame.getContentPane().setLayout(null);
		
		
		
		model = new DefaultTableModel();
		
		Object[] column = { "Mã Bàn Ghế", "Số Lượng"}; 
 		
		Object[] row = new Object[2];

		model.setColumnIdentifiers(column);
		if (PhieuHienCO != null) {
			for (int i = 0;i < PhieuHienCO.size();i++) {
				row[0] = PhieuHienCO.get(i).getMaBG();
				row[1] = PhieuHienCO.get(i).getSoluong();
				model.addRow(row);
			}
		}

		

		table = new JTable();
		table.setModel(model);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 404);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);
	}

}
