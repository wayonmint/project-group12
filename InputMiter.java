
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class InputMiter extends JPanel {
	private JLabel l;
	private JLabel first;
	private JLabel last;
	private JTextField ff;
	private JTextField fl;
	private JButton b;
	private double rate;
	private double fmiter;
	private double lmiter;
	private String address;
	private String type;
	private JPanel jp,p;
	private String name;
	private String password;
	
	public InputMiter() {
		setLayout(new BorderLayout());
		p = new JPanel();
		p.setBackground(new Color(18, 86, 136));
		Font font = (new Font("Century Gothic", Font.TRUETYPE_FONT, 18));
		l = new JLabel("Input Start/End meter "); 
		l.setForeground(Color.white);
		l.setFont(new Font("Courier New", 1, 32));
		p.add(l);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 1));
		p2.setBackground(new Color(18, 86, 136));
		first = new JLabel("Meter start at :");
		first.setForeground(Color.white);
		first.setFont(new Font("Century Gothic",0, 16));
		
		first.setFont(font);
		ff = new JTextField(15);
		ff.setFont(new Font("Century Gothic",0, 16));
		last = new JLabel("Meter end at :");
		last.setForeground(Color.white);
		last.setFont(font);
		fl = new JTextField(15);
		fl.setFont(new Font("Century Gothic",0, 16));

		p2.add(first);
		p2.add(ff);
		p2.add(last);
		p2.add(fl);

		JPanel pp = new JPanel();
		pp.setBackground(new Color(18, 86, 136));
		pp.add(p2);

		JPanel ppp = new JPanel();
		ppp.setBackground(new Color(18, 86, 136));
		b = new JButton("Calculate");
		b.setFont(new Font("Century Gothic",0, 15));
		b.setBackground(Color.white);
		ppp.add(b);
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ff.getText().equalsIgnoreCase("")
						&& fl.getText().equalsIgnoreCase("")) {
					JOptionPane o = new JOptionPane();
					o.showMessageDialog(null,
							"!! Input Start/End meter");
				} else if (ff.getText().equalsIgnoreCase("")) {
					JOptionPane o = new JOptionPane();
					o.showMessageDialog(null, "!! Input start meter");
				} else if (fl.getText().equalsIgnoreCase("")) {
					JOptionPane o = new JOptionPane();
					o.showMessageDialog(null, "!! Input end meter");
				}
				else if(Integer.valueOf(ff.getText())<0||Integer.valueOf(fl.getText())<0){
					JOptionPane o = new JOptionPane();
					o.showMessageDialog(null, "!!Meter must be only positive number");
				}
				else if(Integer.valueOf(ff.getText())>Integer.valueOf(fl.getText())){
					JOptionPane o = new JOptionPane();
					o.showMessageDialog(null, "!!Firstmeter must be less than Endmeter");
				}

				else {
					try {
						fmiter = Double.valueOf(ff.getText());
						lmiter = Double.valueOf(fl.getText());
//						System.out.println("fmiter = "+fmiter);
//						System.out.println("lmiter = "+lmiter);
						if (fmiter < 0 || lmiter < 0) {
							System.out.println("FUcking THROW!!");
							throw new Exception();
						}
						
						if (type.equalsIgnoreCase("Home/Condominium")) {
							remove(p);
							remove(jp);
							CalculateHome o = new CalculateHome(fmiter, lmiter);
							
							add(new ShowData(name, address, type, fmiter, lmiter,o.toString(),o.getResults(),password));
//							add(new ShowData(name, add, type, fmiter, lmiter, rate, result, pass))
							revalidate();
							
						} 
						else if (type.equalsIgnoreCase("Dormitory B/M(Khu Dome)/F(Keang Dome)")) {
							remove(p);
							remove(jp);
							CalculateBFM o = new CalculateBFM(fmiter, lmiter);
							add(new ShowData(name, address, type, fmiter, lmiter,o.toString(),o.getResults(),password));
							revalidate();
						} 
						else if (type.equalsIgnoreCase("A/C/E/Dormitory Thammasat Hospital Dormitory")) {
							remove(p);
							remove(jp);
							CalculateACE o = new CalculateACE(fmiter, lmiter);
							add(new ShowData(name, address, type, fmiter, lmiter,o.toString(),o.getResults(),password));
							revalidate();
						} 
						else if (type.equalsIgnoreCase("Dormitories outside Thammasat University")) {
							remove(p);
							remove(jp);
							CalculateOut o = new CalculateOut(fmiter, lmiter, Double.valueOf(rate));						
							add(new ShowData(name, address, type, fmiter, lmiter,rate+"",o.getResults(),password));
							revalidate();
						}

					} catch (Exception ex) {
						JOptionPane o = new JOptionPane();
						o.showMessageDialog(null, "!! Invalid Data");
					}
				}

			}
		});

		jp = new JPanel();
		jp.setBackground(new Color(18, 86, 136));
		jp.setLayout(new BorderLayout());
		jp.add(pp, BorderLayout.NORTH);
		jp.add(ppp);
		
		

		add(p, BorderLayout.NORTH);
		add(jp);
		setEnabled(true);

	}

	public void setData(double rate, String address, String typs) {
		this.rate = rate;
		this.address = address;
		this.type = typs;
	}

	public void setData(String address, String typs) {
		
		this.address = address;
		this.type = typs;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
}
