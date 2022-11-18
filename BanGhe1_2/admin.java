package BanGhe1_2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Lab9.SwingControlDemo;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin {

	private JFrame frame;
	private final JPanel panel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void Run() {
		try {
			admin window = new admin();
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
	public admin() {
		initialize();
	}
	private ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = SwingControlDemo.class.getResource(path);
	      
	    if (imgURL != null) {
	    	return new ImageIcon(imgURL, description);
	    } else {            
	    	System.err.println("Couldn't find file: " + path);
	      	return null;
	    }
	}

	private void initialize() {
		frame = new JFrame("Admin");
		frame.setBounds(100, 100, 886, 303);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Đóng toàn bộ các frame liên quan
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //ko đóng các frame liên quan 
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		panel.setBounds(0, 0, 870, 264);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		ImageIcon icon = createImageIcon("/group.png","Java");
		ImageIcon icon1 = createImageIcon("/wholesale.png","Java");
		
		JLabel lblNewLabel_2_1 = new JLabel("ADMIN");
		lblNewLabel_2_1.setBounds(378, 59, 92, 37);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel_2_1);
		
		JButton btnQunLXut_1 = new JButton("Quản lý Kho", icon1);
		btnQunLXut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				winBG.setAdminP(true);
				winBG.Run();
			}
		});
		btnQunLXut_1.setBounds(492, 141, 280, 75);
		btnQunLXut_1.setForeground(new Color(0, 0, 0));
		btnQunLXut_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnQunLXut_1.setBackground(new Color(202, 255, 255));
		panel.add(btnQunLXut_1);
		
		JButton btnQunLTi_1 = new JButton("Quản lý tài khoản", icon);
		btnQunLTi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TAIKHOAN.Run();
			}
		});
		btnQunLTi_1.setBounds(93, 141, 265, 74);
		btnQunLTi_1.setForeground(new Color(0, 0, 0));
		btnQunLTi_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnQunLTi_1.setBackground(new Color(202, 255, 255));
		panel.add(btnQunLTi_1);
	}

	
}
