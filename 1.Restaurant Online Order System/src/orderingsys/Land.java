package orderingsys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Land {
	private JFrame jf;
	
	private JPanel jp1;
	private JPanel jp2;
	private JPanel jp3;
	
	private JTextField jtf1;
	private JPasswordField jpf1;
	
	private JLabel jl1;
	private JLabel jl2;
	
	private JButton jb1;
	private JButton jb2;
	
	public void init() {
	jf = new JFrame("Login Account");
	
	jp1 = new JPanel();
	jp2 = new JPanel();
	jp3 = new JPanel();
	
	jtf1 = new JTextField(15);
	jpf1 = new JPasswordField (15);
	jpf1.setEchoChar('*');
	
	jl1 = new JLabel("Username");
	jl2 = new JLabel("Password");
	
	jb1 = new JButton("Login");
	jb2 = new JButton("Reset");
	
	jf.setLayout(new GridLayout(3,1));
	jf.add(jp1);
	jf.add(jp2);
	jf.add(jp3);
	
	jp1.add(jl1);
	jp1.add(jtf1);
	
	jp2.add(jl2);
	jp2.add(jpf1);
	
	jp3.add(jb1);
	jp3.add(jb2);
	
	jb1.addActionListener(new ButtonListener());
	jb2.addActionListener(new ButtonListener());
	
	jf.pack();
	jf.setLocation(400, 300);
	jf.setLocationRelativeTo(null);
	jf.setVisible(true);
	jf.setAlwaysOnTop(false);
	
}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
			if("Login".equals(command) && jtf1.getText().equals("wzb") && new String(jpf1.getPassword()).equals("123")) {
					new System1().init(jtf1.getText());
					jf.setVisible(false);
				}
			else if("Reset".equals(command)) {
					jtf1.setText("");
					jpf1.setText("");
				}
			else {
				JOptionPane.showMessageDialog(null,"Wrong username or password!","error",0);
				jtf1.setText("");
				jpf1.setText("");
				}
			}
		}
 
public static void showMessageDialog(Component parentComponent,Object message,String title,int messageType,Icon icon) {	
 }
 
public static void main(String[] args) {
		new Land().init();
	}
}