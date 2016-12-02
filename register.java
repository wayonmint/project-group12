
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class register extends JPanel implements ActionListener{
	JPanel p,p1,p2,p3,p4,p5,p7,p6,pp,p9;
	String username,password;
	JLabel pic,user,pass,pasC;
	ImageIcon m,f;
	JButton back,reg;
	JComboBox<String> box;
	JTextField u;
	JPasswordField pa,paC;
	public register() {
		pp=new JPanel(new GridLayout(4,1));
		m = new ImageIcon("Male-icon.png");
		f = new ImageIcon("Female-icon.png");
		p = new JPanel(new GridLayout(4,0));
		p1 = new JPanel();
		JLabel l = new JLabel("User Register");
		p1.add(l);
		l.setFont(new Font("Courier New", 1, 48));
		l.setForeground(Color.white);
		p2 = new JPanel();
		pic = new JLabel(m);
		pic.setSize(120, 120);
		p2.add(pic);
		p3 = new JPanel();
		user = new JLabel("Username: ");
		user.setForeground(Color.white);
		user.setFont(new Font("Century Gothic", 0, 18));
		user.setHorizontalAlignment ( SwingConstants.LEFT );
		p3.add(user);
		u = new JTextField(10);
		u.setFont(new Font("Century Gothic",0,16));
		p3.add(u);
		p4 = new JPanel();
		pass = new JLabel("Password: ");
		pass.setForeground(Color.white);
		pass.setFont(new Font("Century Gothic", 0, 18));
		pass.setHorizontalAlignment ( SwingConstants.LEFT );
		p4.add(pass);
		pa = new JPasswordField(10);
		pa.setFont(new Font("Century Gothic",0,16));
		pa.setEchoChar('*');
		p4.add(pa);
		p5 = new JPanel();
		JLabel gen = new JLabel("Gender: ");
		gen.setFont(new Font("Century Gothic",0, 18));
		gen.setForeground(Color.white);
		p5.add(gen);
		box = new JComboBox<String>();
		box.addItem("Male");
		//box.setForeground(new Color (100,149,237));
		box.setFont(new Font("Century Gothic", 0, 15));
		box.addItem("Female");
		box.addActionListener(this);
		p5.add(box);
		p6 = new JPanel(new BorderLayout());
		p7 = new JPanel();
		JPanel p8 = new JPanel();
		back = new JButton("BACK");
		back.setBackground(Color.white);
		back.setFont(new Font("Century Gothic",0,15));
		back.addActionListener(this);
		reg = new JButton("REGISTER");
		reg.setBackground(Color.white);
		reg.setFont(new Font("Century Gothic",0,15));
		reg.addActionListener(this);
		p9 = new JPanel();
		pasC = new JLabel("Confirm Password: ");
		pasC.setForeground(Color.white);
		pasC.setFont(new Font("Century Gothic", 0, 18));
		pasC.setHorizontalAlignment ( SwingConstants.LEFT);
		p9.add(pasC);
		paC = new JPasswordField(10);
		paC.setFont(new Font("Century Gothic",0,16));
		paC.setEchoChar('*');
		p9.add(paC);
		p7.add(back);
		p8.add(reg);
		p.add(p1);
		p.add(p2);
		pp.add(p3,BorderLayout.WEST);
		pp.add(p4,BorderLayout.CENTER);
		pp.add(p9);
		pp.add(p5,BorderLayout.SOUTH);
		p.add(pp);
		p6.add(p8,BorderLayout.EAST);
		p6.add(p7,BorderLayout.WEST);
		p.add(p6);
		p1.setBackground(new Color (18, 86, 136));
		p2.setBackground(new Color (18, 86, 136));
		p3.setBackground(new Color (18, 86, 136));
		p4.setBackground(new Color (18, 86, 136));
		p5.setBackground(new Color (18, 86, 136));
		p6.setBackground(new Color (18, 86, 136));
		p7.setBackground(new Color (18, 86, 136));
		pp.setBackground(new Color (18, 86, 136));
		p9.setBackground(new Color (18, 86, 136));
		p8.setBackground(new Color (18, 86, 136));
		this.setBackground(new Color (18, 86, 136));
		p.setBackground(new Color (18, 86, 136));
		add(p);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==box){
			if(box.getSelectedIndex()==0){
				pic.setIcon(m);
			}else if (box.getSelectedIndex()==1){
				pic.setIcon(f);
			}
		}
		if(e.getSource()==back){
			removeAll();
			remove(p);
			firstPage f = new firstPage();
			add(f);
			validate();
			repaint();

		}else if(e.getSource()==reg){
			if(u.getText().isEmpty()==true){
				JOptionPane.showMessageDialog(null, "Please enter your username");
				user.setText("*Username: ");
				user.setForeground(Color.red);
			}
			else if(u.getText().length()<4){
				JOptionPane.showMessageDialog(null, "Please enter a username at least 4 to 10 characters");
				user.setText("*Username: ");
				user.setForeground(Color.red);
			}
			else if(pa.getPassword().length==0){
				user.setText("Username: ");
				user.setForeground(Color.white);
				JOptionPane.showMessageDialog(null, "Please enter your password");
				pass.setText("*Password: ");
				pass.setForeground(Color.red);
			}
			else if(pa.getPassword().length<4){
				JOptionPane.showMessageDialog(null, "Please enter a password at least 4 to 10 characters");
				pass.setText("*Password: ");
				pass.setForeground(Color.red);
			}else if(paC.getPassword().length==0){
				user.setText("Username: ");
				user.setForeground(Color.white);
				pass.setText("Password: ");
				pass.setForeground(Color.white);
				JOptionPane.showMessageDialog(null, "Please confirm your password");
				pasC.setText("*Confirm Password: ");
				pasC.setForeground(Color.red);
			}else if(!(Arrays.equals(pa.getPassword(), paC.getPassword()))){
				pasC.setText("Confirm Password: ");
				pass.setText("Password: ");
				JOptionPane.showMessageDialog(null, "Password and Confirm password is not match!");
				pass.setForeground(Color.red);
				pasC.setForeground(Color.red);
			}
			else{
				username = u.getText();
				System.out.println("register username " + username);
//				password = pa.getPassword().toString();
				password = pa.getText();
				System.out.println("register password"  + password);
				remove(p);
				TypeAndAddress t = new TypeAndAddress();
				t.setName(username);
				t.setPassword(password);
				add(t);
				validate();
				repaint();
			}
		}
		
	}
}

