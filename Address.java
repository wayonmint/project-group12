

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class Address extends JPanel{
	private JTextArea area;
	private JLabel l,l1;
	private JButton b;
	private JPanel panel;
	private JRadioButton r1,r2,r3;
	public Address(){
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		l1 = new JLabel("Choose type of habitations");
		p1.add(l1);
		
		r1 = new JRadioButton("Home/Condominium");
		r2 = new JRadioButton("Dormitories inside Thammasat University");
		r3 = new JRadioButton("Dormitories outside Thammasat University");
		
		JPanel pn = new JPanel();
		pn.setLayout(new GridLayout(3,1));
		pn.add(r1);
		pn.add(r2);
		pn.add(r3);
		
		JPanel jpan = new JPanel();
		jpan.setLayout(new BorderLayout());
		jpan.add(p1,BorderLayout.NORTH);
		jpan.add(pn,BorderLayout.CENTER);
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		l = new JLabel("Address: ");
		p.add(l);
		
		JPanel pp = new JPanel();
		
		area = new JTextArea(10,20);
		area.setBorder(new EtchedBorder());
		pp.add(area);
		
		JPanel ppp = new JPanel();
		ppp.setLayout(new BorderLayout());
		ppp.add(p,BorderLayout.NORTH);
		ppp.add(pp);
		
		JPanel j = new JPanel();
		b = new JButton("Finish");
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(panel);
				remove(j);
				add(new InputMiter());
				validate();
			}
		});
		
		j.add(b);
		
		panel = new JPanel();
		panel.add(ppp);
		
		add(jpan,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		add(j,BorderLayout.SOUTH);
	}
}
