import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;


public class TypeAndAddress extends JPanel implements ActionListener{
	private JRadioButton r1,r2,r3;
	private ButtonGroup group,group2;
	private JLabel l,l1,ll;
	private JTextArea area;
	private JButton b;
	private JTextField t1;
	private JRadioButton s1,s2;
	private JPanel p3,pp,pn,pa5,p6;
	private String address;
	private double rate;
	private String type;
	private String name;
	private String password;
	JComboBox<String> tyB;

	
	public TypeAndAddress(){
		setLayout(new BorderLayout());
		JPanel p = new JPanel();
		p.setBackground(new Color (18, 86, 136));
		l = new JLabel("Choose type of habitations");
		l.setForeground(Color.white);
		Font font = new Font("Century Gothic", 0, 18);
		l.setFont(new Font("Courier New", 1, 26));
		p.add(l);
		JPanel p1 = new JPanel();
		p1.setBackground(new Color (18, 86, 136));
		tyB = new JComboBox<String>();
		tyB.addItem("Home/Condominium");
		tyB.addItem("Dormitories inside Thammasat University");
		tyB.addItem("Dormitories outside Thammasat University");
		//tyB.setBackground(new Color (18, 86, 136));
		//tyB.setForeground(new Color(208,32,144));
		//(255,130,171)
		tyB.setFont(new Font("Century Gothic", 0, 16));
		tyB.addActionListener(this);
		p1.add(tyB);
		
		JPanel p4 = new JPanel();
		p4.setBackground(new Color (18, 86, 136));
		p4.setLayout(new BorderLayout());
		p4.add(p,BorderLayout.NORTH);
		p4.add(p1);
		
		p6 = new JPanel();
		p6.setBackground(new Color (18, 86, 136));
		p6.setLayout(new BorderLayout());
		p6.add(p4,BorderLayout.NORTH);
		
		JPanel pa1 = new JPanel();
		pa1.setBackground(new Color (18, 86, 136));
		l1 = new JLabel("Address: (Enter your address)");
		l1.setFont(new Font("Courier New", 1, 26));
		l1.setForeground(Color.white);
		pa1.add(l1);
		
		JPanel pa2 = new JPanel();
		pa2.setBackground(new Color (18, 86, 136));
		area = new JTextArea(10,20);
		area.setWrapStyleWord(true);
		area.setLineWrap(true);
		//area.setBackground(new Color(18, 86, 136));
		//area.setForeground(new Color(95,158,160));
		area.setFont(font);
		area.setBorder(new EtchedBorder());
		pa2.add(area);
		
		JPanel pa3 = new JPanel();
		pa3.setBackground(new Color (18, 86, 136));
		pa3.setLayout(new BorderLayout());
		pa3.add(pa1,BorderLayout.NORTH);
		pa3.add(pa2);

		JPanel pa4 = new JPanel();
		pa4.setBackground(new Color (18, 86, 136));
		b = new JButton("NEXT");
		b.setBackground(Color.WHITE);
		b.setFont(new Font("Century Gothic", 0, 14));
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					if(tyB.getSelectedIndex()==2&&t1.getText().equalsIgnoreCase("")){
		
					 JOptionPane.showMessageDialog(null, "Please enter Rate/Unit (BAHT)");
				}
					 
				else if(area.getText().equalsIgnoreCase("")){
				
					JOptionPane.showMessageDialog(null, "Please enter your address");
				}
				else if(tyB.getSelectedIndex()==2&&Integer.valueOf(t1.getText())<0){
					JOptionPane o = new JOptionPane();
					o.showMessageDialog(null, "!!Rate must be only positive number");
				}
							
				else{
					
						address = area.getText();
						InputMiter in =  new InputMiter();
						in.setName(name);
						in.setPassword(password);
						if(tyB.getSelectedIndex()==0){
							type = "Home/Condominium";
							in.setData(address, type);
							
							remove(p6);
							remove(pp);
							remove(pa5);
							add(in);
						}
						else if(tyB.getSelectedIndex()==1){
							if(s1.isSelected()){
								type = "Dormitory B/M(Khu Dome)/F(Keang Dome)";
								in.setData(address, type);
								remove(p6);
								remove(pp);
								remove(pa5);
								add(in);
							}
							else if(s2.isSelected()){
								type = "A/C/E/Dormitory Thammasat Hospital Dormitory";
								in.setData(address, type);
								remove(p6);
								remove(pp);
								remove(pa5);
								add(in);
							}
						}
						else if(tyB.getSelectedIndex()==2){
							try {// if is number
								rate = Double.valueOf(t1.getText());
								type = "Dormitories outside Thammasat University";
								in.setData(rate, address, type);
								remove(p6);
								remove(pp);
								remove(pa5);
								add(in);
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "Invalid data!! Please enter value of Rate/Unit(Baht)");
							}
							
						}

					}
					
				validate();
			}catch(Exception e){
							JOptionPane.showMessageDialog(null, "Invalid data");
							
						}
						
				}
		});
		pa4.add(b);
		
		pa5 = new JPanel();
		pa5.setBackground(new Color (18, 86, 136));
		pa5.setLayout(new BorderLayout());
		pa5.add(pa3,BorderLayout.NORTH);
		pa5.add(pa4);
		
		
		pp = new JPanel(new BorderLayout());
		pp.setBackground(new Color (18, 86, 136));
		s1 = new JRadioButton("Dormitory B/M(Khu Dome)/F(Keang Dome)");
		s1.setFont(new Font("Century Gothic", 0, 16));
		s1.setForeground(Color.white);
		s1.setBackground(new Color (18, 86, 136));
		s1.setSelected(true);
		s2 = new JRadioButton("A/C/E/Dormitory Thammasat Hospital Dormitory");	
		s2.setFont(new Font("Century Gothic", 0, 16));
		s2.setForeground(Color.white);
		s2.setBackground(new Color (18, 86, 136));
		group2 = new ButtonGroup();
		group2.add(s1);
		group2.add(s2);
		pp.add(s1,BorderLayout.NORTH);
		pp.add(s2);
		pp.setVisible(false);
		pn = new JPanel();
		pn.setBackground(new Color (18, 86, 136));
		ll = new JLabel("Rate/Unit (BAHT):");
		
		ll.setFont(font);
		ll.setForeground(Color.white);
		t1 = new JTextField(10);
		t1.setFont(font);
		pn.add(ll);
		pn.add(t1);
		pn.setVisible(false);
		pp.add(pn,BorderLayout.SOUTH);
		add(p6,BorderLayout.NORTH);
		pa5.setVisible(false);
		add(pp);
		add(pa5,BorderLayout.SOUTH);	

	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tyB){
			if(tyB.getSelectedIndex()==0){
				pp.setVisible(false);
				pa5.setVisible(true);
				
				type = "Home/Condominium";
			}else if(tyB.getSelectedIndex()==1){
				
				pp.setVisible(true);
				s1.setVisible(true);
				s2.setVisible(true);
				pn.setVisible(false);
				pa5.setVisible(true);
				type = "";
			}else if(tyB.getSelectedIndex()==2){
				
				pp.setVisible(true);
				s1.setVisible(false);
				s2.setVisible(false);
				pn.setVisible(true);
				pa5.setVisible(true);
				type = "Dormitories outside Thammasat University";
			}
		}
		
	}

}
