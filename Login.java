import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

public class Login extends JPanel implements ActionListener{
	private String username;
	private String password;
	private JTextField fUser;
	private JPasswordField fPass;
	private JPanel pan,m,pl;
	JLabel lUser,lPass;
	JButton btn;
	public Login(){
		Font f = new Font("Century Gothic", 0, 18);
		//setFont(f);
		setLayout(new BorderLayout());
		pl = new JPanel();
		pl.setBackground(new Color (18, 86, 136));
		JLabel l = new JLabel("TARIFF");
		l.setFont(new Font("Pennellino", 1, 72));
		pl.add(l);
		l.setForeground(Color.white);
		m = new JPanel();
		m.setBackground(new Color (18, 86, 136));
		JLabel ll=new JLabel("LogIn");
		ll.setForeground(Color.white);
		ll.setFont(new Font("Courier New", 1, 32));
		m.add(ll);
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,1));
		
		lUser = new JLabel("Username: ");	
		lUser.setForeground(Color.white);
		lUser.setFont(new Font("Century Gothic", 0, 20));
		fUser = new JTextField(10);	
		fUser.setFont(f);
		p.add(lUser);
		p.add(fUser);
		
		lPass = new JLabel("Password: ");	
		lPass.setForeground(Color.white);
		lPass.setFont(new Font("Century Gothic", 0, 20));
		fPass = new JPasswordField(10);	
		fPass.setFont(f);
		
	//add
		
		
		p.add(lPass);
		p.add(fPass);
		
		JPanel pp = new JPanel();
		pp.setBackground(new Color (18, 86, 136));
		JButton b = new JButton("Log in");
		b.setBackground(Color.white);
		b.setFont(f);
		pp.add(b);
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
//				String queryString = "SELECT * FROM user=? password=?";
//				ResultSet results = ps.
				
//				if(fUser.getText().equalsIgnoreCase("")&&fPass.getText().equalsIgnoreCase("")){
//					JOptionPane o = new JOptionPane();
//					o.showMessageDialog(null, "!! Input Username and Password");
//				}
				if(fUser.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(null, "Please enter your username");
					lUser.setForeground(Color.RED);
				}
				else if(fPass.getPassword().length==0){
					lUser.setForeground(Color.white);
					lPass.setForeground(Color.red);
					JOptionPane.showMessageDialog(null, "Please enter your password");
				}
//				else if(fUser.getText().equals(arg0))
//				
				else{
					AuthenticationController authen = new AuthenticationController();
					try {
						if(authen.login(fUser.getText(), fPass.getText())){
							username = fUser.getText();
//							password = fPass.getPassword().toString();
							password = fPass.getText();
							remove(pan);
							TypeAndAddress t = new TypeAndAddress();
							t.setName(username);
							t.setPassword(password);
							add(t);
							validate();
						}
						else JOptionPane.showMessageDialog(null, "Wrong ID or Password. Please check again.");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		JPanel jp = new JPanel();
		jp.add(p);
		jp.setBackground(new Color (18, 86, 136));
	
		JPanel pa = new JPanel();
		pa.setLayout(new BorderLayout());
		pa.add(m,BorderLayout.NORTH);
		pa.add(jp,BorderLayout.CENTER);
		pa.setBackground(new Color (18, 86, 136));
		pan = new JPanel();
		pan.setBackground(new Color (18, 86, 136));
		pan.setLayout(new BorderLayout());
		pan.add(pa,BorderLayout.NORTH);
		pan.add(pp);
		btn = new JButton("BACK");
		btn.setBackground(Color.white);
		btn.setFont(f);
		btn.addActionListener(this);
		btn.setVisible(false);
		add(pl,BorderLayout.NORTH);
		add(pan);
		add(btn,BorderLayout.SOUTH);
		this.setBackground(new Color (18, 86, 136));
		p.setBackground(new Color (18, 86, 136));
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn){
			removeAll();
			firstPage r = new firstPage();
			remove(pl);
			remove(pan);
			remove(btn);
			add(r);
			validate();
			repaint();
		}
		
	}
}

