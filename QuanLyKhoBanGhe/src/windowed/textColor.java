package windowed;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class textColor {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public static int red;
	public static int green;
	public static int blue;

	/**
	 * Launch the application.
	 */
	public static void Run() {
		try {
			textColor window = new textColor();
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
	public textColor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Text Color");
		frame.setBounds(100, 100, 290, 266);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//chỉ đóng frame này
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Red:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 11, 55, 34);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(90, 11, 166, 34);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblBlue = new JLabel("Green:");
		lblBlue.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBlue.setBounds(10, 56, 80, 34);
		frame.getContentPane().add(lblBlue);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 56, 166, 34);
		frame.getContentPane().add(textField_1);
		
		JLabel lblBlue_1 = new JLabel("Blue:");
		lblBlue_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBlue_1.setBounds(10, 101, 55, 34);
		frame.getContentPane().add(lblBlue_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 101, 166, 34);
		frame.getContentPane().add(textField_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 145, 246, 34);
		frame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().equals(""))
					textField.setText("0");
				if (textField_1.getText().equals(""))
					textField_1.setText("0");
				if (textField_2.getText().equals(""))
					textField_2.setText("0");
				int red1  = Integer.parseInt(textField.getText());
				int green1  = Integer.parseInt(textField_1.getText());
				int blue1  = Integer.parseInt(textField_2.getText());
				panel.setBackground(new Color(red1, green1, blue1));
			}
		});
		btnNewButton.setBounds(10, 190, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				red  = Integer.parseInt(textField.getText());
				green  = Integer.parseInt(textField_1.getText());
				blue  = Integer.parseInt(textField_2.getText());
				winBG.changeC();
			}
		});
		btnEnter.setBounds(167, 190, 89, 23);
		frame.getContentPane().add(btnEnter);
		
		
		
	}
}
