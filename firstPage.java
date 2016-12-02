
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class firstPage extends JPanel implements ActionListener{
	JPanel name,login,regis,p,p1,panel,p2;
	JLabel NAME;
	JButton Login,Regis;

	public firstPage() {
		
		panel = new JPanel();

		panel.setLayout(new GridLayout(4,0));
		p = new JPanel(new BorderLayout());


		p1 = new JPanel();
		
		p2 = new JPanel();
		
		name = new JPanel();

		login = new JPanel();
		
		regis = new JPanel();
		
		NAME = new JLabel("TARIFF");
		p1.setBackground(new Color (18, 86, 136));
		p2.setBackground(new Color (18, 86, 136));
		p.setBackground(new Color (18, 86, 136));
		regis.setBackground(new Color (18, 86, 136));
		login.setBackground(new Color (18, 86, 136));
		name.setBackground(new Color (18, 86, 136));
		panel.setBackground(new Color (18, 86, 136));
		
		
		NAME.setFont(new Font("Pennellino",1, 92));
		NAME.setForeground(Color.white);
		name.add(NAME);
		Login = new JButton("Login");
		Login.setFont(new Font("Century Gothic", 0, 18));
		Login.setForeground(Color.darkGray);
		Login.setBackground(Color.white);
		//Login.setBackground(new Color(238 ,210, 238));
		Login.addActionListener(this);
		login.add(Login);	
		Regis = new JButton("Register");
		Regis.setFont(new Font("Century Gothic", 0, 18));
		Regis.setForeground(Color.darkGray);
		Regis.setBackground(Color.white);
		//Regis.setBackground(new Color(238 ,210, 2389));
		
		Regis.addActionListener(this);
		regis.add(Regis);
		panel.add(p1);
		panel.add(name);
		panel.add(p2);
		p.add(login,BorderLayout.NORTH);
		p.add(regis);
		panel.add(p);
		this.setBackground(new Color (18, 86, 136));
		this.add(panel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Login){
			removeAll();
			p.setVisible(false);
			Login l = new Login();
			remove(panel);
			this.add(l);
			this.validate();
			this.repaint();
			return ;
		}else if(e.getSource()==Regis){
	        removeAll();
			register r = new register();
			//remove(panel);
			add(r);
//			r.repaint();
//			this.validate();
			this.revalidate();
			this.repaint();
			return ;
		}		
	}

}

