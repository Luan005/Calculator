package logic;

import java.awt.Dimension;
import javax.swing.*;



public class MyFrame extends JFrame{
	
	Calculator c;
	
	
	public MyFrame() {
		
		this.setMinimumSize(new Dimension(400,400));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		

		c = new Calculator(this);

		this.add(c);

		
		this.setVisible(true);
		
		
		
	}

}
