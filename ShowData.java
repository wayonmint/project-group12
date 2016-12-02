
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowData extends JPanel{
	DBConnection dbConn = new DBConnection();
	private JLabel l1,l2,l3,l4,l5;
	public ShowData(String name,String add,String type,double fmiter,double lmiter,String rate,double result,String pass){
		
		dbConn.openConnection();
		String user = "INSERT INTO \"user\"(\"id\", \"password\")VALUES ('"+name+"', '"+pass+"');" ;
		String s = "INSERT INTO data(\"Address\", \"FirstMiter\", \"LastMiter\", \"Result\", \"Type\", \"Rate\")VALUES ('"+add+"', '"+fmiter+"', '"+lmiter+"', '"+result+"', '"+type+"', '"+rate+"');" ;
		
//		System.out.println("Test add "+user);
		
//		String s = "INSERT INTO public.se (\"Address\", firstmiter, lastmiter, password, result, type, username, rate) VALUES ('address', '"+fmiter+"', '"+lmiter+"', '"+pass+"', '"+result+"', '"+type+"', '"+name+"', 'rate');" ;
		
		try{
			System.out.println("Insert Syntax :"+s); //DEBUGGING
			Connection cc = dbConn.openConnection2();
			System.out.println("After conection");
				Statement stm = cc.createStatement() ;
			System.out.println("After statement");
	         
	         stm.execute(user);
	         stm.execute(s);
	         System.out.println("After Execute");
			} catch (SQLException ex) {
				ex.printStackTrace();
	            System.out.println("error");
	      }
//		System.out.println("pass -1");
		setLayout(new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setBackground(new Color (18, 86, 136));
		p1.setLayout(new BorderLayout());
		l1= new JLabel("Name: "+name);
		l1.setForeground(Color.white);
		p1.add(l1);
//		System.out.println("pass 0");
		JPanel p2 = new JPanel();
		p2.setBackground(new Color (18, 86, 136));
		p2.setLayout(new BorderLayout());
		l2= new JLabel("Type: "+type);
		l2.setForeground(Color.white);
		p2.add(l2);
		
		JPanel p3 = new JPanel();
		p3.setBackground(new Color (18, 86, 136));
		p3.setLayout(new BorderLayout());
		l3= new JLabel("Address: "+add);
		l3.setForeground(Color.white);
		p3.add(l3);
		
		JPanel p4 = new JPanel();
		p4.setBackground(new Color (18, 86, 136));
		p4.setLayout(new BorderLayout());
		
		l4= new JLabel("Miter: "+fmiter+" - "+lmiter+" = "+(lmiter-fmiter)+" Units");
		l4.setForeground(Color.white);
		p4.add(l4);
		
		JPanel p5 = new JPanel();
		p5.setBackground(new Color (18, 86, 136));
		p5.setLayout(new BorderLayout());
		
//		System.out.println("Pass 1");
		if(type.equalsIgnoreCase("Home/Condominium")){
			l5= new JLabel("<html>"+"Rate: "+"<br>"+
			"1.Use electricity less than 150 Units"+"<br>"+
			"- Next 10 Units(16-25 Units) 2.9882 Baht/Unit"+"<br>"+
			"- Next 10 Units(26-35 Units) 3.2405 Baht/Unit"+"<br>"+
			"- Next 10 Units(26-35 Units) 3.2405 Baht/Unit"+"<br>"+
			"- Next 65 Units(36-100 Units) 3.6237 Baht/Unit"+"<br>"+
			"- Next 50 Units(101-150 Units) 3.7171 Baht/Unit"+"<br>"+
			"- Next 250 Units(151-400 Units) 4.2218 Baht/Unit"+"<br>"+
			"- More than 400 Units(400 Units or above) 4.4217 Baht/Unit"+"<br>"+
			"2.Use electricity more than 150 Units"+"<br>"+
			"- First 150 Units(0-150 Units) 3.2484 Baht/Unit"+"<br>"+
			"- Next 250 Units(151-400 Units) 4.2218 Baht/Unit"+"<br>"+
			"- More than 400 Units(401 Units or above) 4.4217 Baht/Unit"+"<br>");
			l5.setForeground(Color.white);
		}
		else if(type.equalsIgnoreCase("Dormitory B/M(Khu Dome)/F(Keang Dome)")){
			l5 = new JLabel("<html>"+"Rate: "+"<br>"+"- Tariff"+" 1-300 Units 5 Baht"+"<br>"+"- 301 Units or above 6 Baht"+"</html>");
			l5.setForeground(Color.white);
		}
		else if(type.equalsIgnoreCase("A/C/E/Dormitory Thammasat Hospital Dormitory")){
			l5 = new JLabel("<html>"+"Rate: "+"<br>"+"- Tariff"+" 1-150 Units 5 Baht"+"<br>"+"- 151 Units or above 6 Baht"+"</html>");
			l5.setForeground(Color.white);
		}
		else if(type.equalsIgnoreCase("Dormitories outside Thammasat University")){
			l5 = new JLabel("Rate: "+rate+" Baht");
			l5.setForeground(Color.white);
		}
		
		
		p5.add(l5);
			
		JPanel j = new JPanel();
		j.setBackground(new Color (18, 86, 136));
		j.setLayout(new GridLayout(4,1));
		j.add(p1);
		j.add(p2);
		j.add(p3);
		j.add(p4);
		
		JPanel p7 = new JPanel();
		p7.setBackground(new Color (18, 86, 136));
		p7.add(j);
		
		JPanel p8 = new JPanel();
		p8.setBackground(new Color (18, 86, 136));
		p8.add(p5);
		
		Font f = (new Font("Century Gothic",0, 30));
		setFont(f);
		
		Font font = new Font("Century Gothic", 0,18);
		l1.setFont(font);
		l2.setFont(font);
		l3.setFont(font);
		l4.setFont(font);
		l5.setFont(font);
		l5.setForeground(Color.white);
//		System.out.println("Pass 2");
		JPanel pp1 = new JPanel();
		pp1.setBackground(new Color (18, 86, 136));
		JLabel jj1 = new JLabel("Your Electricity Bill is: ");
		jj1.setFont(new Font("Century Gothic", 1,25));
		jj1.setForeground(new Color( 252, 204, 99));
		pp1.add(jj1);
		
		JPanel pp2 = new JPanel();
		pp2.setBackground(new Color (18, 86, 136));
		String sss = String.format("%.2f", result);
		JLabel jj2 = new JLabel(sss+" Baht");
		
		jj2.setFont(new Font("Century Gothic", 1,30));
		jj2.setForeground(new Color( 252, 204, 99));
		pp2.add(jj2);
		
		JPanel pp3 = new JPanel();
		pp3.setBackground(new Color (18, 86, 136));
		pp3.setLayout(new BorderLayout());
		pp3.add(pp1,BorderLayout.NORTH);
		pp3.add(pp2);
		
		/*JPanel pl = new JPanel();
		pl.setBackground(new Color (18, 86, 136));
		JLabel l = new JLabel("TARIFF");
		l.setFont(new Font("Segoe Marker", 1, 60));
		pl.add(l);
		l.setForeground(Color.white);*/
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color (18, 86, 136));
		panel.setLayout(new BorderLayout());
		//panel.add(pl,BorderLayout.NORTH);
		panel.add(p7,BorderLayout.NORTH);
		panel.add(p8);
		
		JPanel t = new JPanel();
		t.setBackground(new Color (18, 86, 136));
		JButton btn = new JButton("\tOK\t");
		btn.setFont(new Font("Century Gothic", 0,18));
		btn.setBackground(Color.white);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		
//		System.out.println("Pass 3");
		t.add(btn);
		
		setEnabled(true);
		
		add(panel,BorderLayout.NORTH);
		add(pp3);
		add(t,BorderLayout.PAGE_END);
		this.setBackground(new Color (18, 86, 136));
	}
}
