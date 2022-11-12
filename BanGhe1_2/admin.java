package BanGhe1_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin {

	private JFrame frame;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin window = new admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public admin() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Admin");
		frame.setBounds(100, 100, 886, 303);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Đóng toàn bộ các frame liên quan
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //ko đóng các frame liên quan 
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 870, 457);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("ADMIN");
		lblNewLabel_2_1.setBounds(378, 59, 92, 37);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel_2_1);
		
		JButton btnQunLXut_1 = new JButton("Quản lý Kho");
		btnQunLXut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				winBG.setAdminP(true);
				winBG.Run();
			}
		});
		btnQunLXut_1.setBounds(492, 141, 230, 75);
		btnQunLXut_1.setForeground(Color.WHITE);
		btnQunLXut_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnQunLXut_1.setBackground(Color.BLUE);
		panel.add(btnQunLXut_1);
		
		JButton btnQunLTi_1 = new JButton("Quản lý tài khoản");
		btnQunLTi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TAIKHOAN.Run();
			}
		});
		btnQunLTi_1.setBounds(128, 141, 230, 74);
		btnQunLTi_1.setForeground(Color.WHITE);
		btnQunLTi_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnQunLTi_1.setBackground(Color.BLUE);
		panel.add(btnQunLTi_1);
	}
}
