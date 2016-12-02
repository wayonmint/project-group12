

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class FrameTest extends JFrame{
	public void refresh(){
		this.validate();
	}
	public FrameTest(){

//		Login login = new Login();
//		add(login);
		firstPage f = new firstPage();
		this.setContentPane(f);
		//this.setBackground(new Color(255,192,203));
		setResizable(true);
		
		setSize(650, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new FrameTest();

	}
}
