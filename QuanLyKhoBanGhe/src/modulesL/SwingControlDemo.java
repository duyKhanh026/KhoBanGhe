package modulesL;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingControlDemo {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	public SwingControlDemo(){
	prepareGUI();
	}
	public static void main(String[] args){
		SwingControlDemo swingControlDemo = new SwingControlDemo();
		swingControlDemo.showCheckBoxDemo();
	}
	private void prepareGUI(){
		mainFrame = new JFrame("Vi du Java Swing");
		mainFrame.setSize(400,181);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		headerLabel = new JLabel("", JLabel.CENTER);
		headerLabel.setBounds(0, 0, 384, 77);
		statusLabel = new JLabel("",JLabel.CENTER);
		statusLabel.setLocation(0, 186);
		statusLabel.setSize(384,64);
		controlPanel = new JPanel();
		controlPanel.setBounds(0, 75, 384, 64);
		controlPanel.setLayout(new FlowLayout());
		mainFrame.getContentPane().setLayout(null);
		mainFrame.getContentPane().add(headerLabel);
		mainFrame.getContentPane().add(controlPanel);
		mainFrame.getContentPane().add(statusLabel);
		mainFrame.setVisible(true);
	}
	private void showCheckBoxDemo(){
		headerLabel.setText("Control in action: CheckBox");
		final JCheckBox chkApple = new JCheckBox("Apple");
		final JCheckBox chkMango = new JCheckBox("Mango");
		final JCheckBox chkPeer = new JCheckBox("Peer");
		chkApple.setMnemonic(KeyEvent.VK_C);
		chkMango.setMnemonic(KeyEvent.VK_M);
		chkPeer.setMnemonic(KeyEvent.VK_P);
		chkApple.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Apple Checkbox: "
				+ (e.getStateChange()==1?"checked":"unchecked"));
			}
		});
		chkMango.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Mango Checkbox: "
				+ (e.getStateChange()==1?"checked":"unchecked"));
			}
		});
		chkPeer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				statusLabel.setText("Peer Checkbox: "
				+ (e.getStateChange()==1?"checked":"unchecked"));
			}
		});
		controlPanel.add(chkApple);
		controlPanel.add(chkMango);
		controlPanel.add(chkPeer);
		mainFrame.setVisible(true);
	}
}
