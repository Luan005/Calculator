package logic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.*;

public class Calculator extends JPanel{
	
	MyFrame frame;
	
	
	
	static JTextField t;
	
	
	public Calculator(MyFrame frame) {
		
		this.frame = frame;
		this.setMinimumSize(new Dimension(500, 500));
		this.setLayout(new BorderLayout());
		
		
		
//		Screen steht für die Anzeige der Zahlen, keyBoard für die Tastatur
		JPanel screen = new JPanel();
		JPanel keyBoard = new JPanel();
		
		
		
//		Setze die Größe für die Tastatur und die Anzeige
		keyBoard.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()/4*3));
		screen.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()/4));
		
		
		
		keyBoard.setLayout(new BorderLayout());
		
		
//		Keyboard in 2 Teile aufteilen: Einmal Zahlen und einmal die Operationen
		JPanel numbers = new JPanel();
		JPanel operations = new JPanel();
		
		
		
		
//		Die Nummern sollen 3 Mal so viel Platz einnehmen wie Operanden
		numbers.setPreferredSize(new Dimension(frame.getWidth()/4*3,frame.getHeight()));
		operations.setPreferredSize(new Dimension(frame.getWidth()/4,frame.getHeight()));

		
		
		
		
		//Setze das Layout für die numbers, sodass ein 3x3 Feld an Zahlen zu sehen ist
        GridLayout gridLayout = new GridLayout(4, 4);
		numbers.setLayout(gridLayout);
		gridLayout.setHgap(5);
	    gridLayout.setVgap(5);
		
		
	    
		//Setze das Layout für die operations, sodass ein 3x3 Feld an Zahlen zu sehen ist
	    GridLayout gridLayoutOperations = new GridLayout(4, 1);
	    gridLayoutOperations.setHgap(5);
	    gridLayoutOperations.setVgap(5);
	    operations.setLayout(gridLayoutOperations);


		

		
		//Erstelle alle Buttons des Taschenrechners
	    createAndAddButtons(numbers, operations);
		
	    
	    
	    
	    t = new JTextField(20);
	    t.setEditable(false);
	    
	    	    
	    
		
	    screen.setLayout(new BorderLayout());
		
	    screen.add(t,BorderLayout.CENTER);
	    
		
		
		keyBoard.add(operations,BorderLayout.EAST);
		keyBoard.add(numbers,BorderLayout.CENTER);
		
		
		this.add(screen,BorderLayout.NORTH);
		this.add(keyBoard,BorderLayout.CENTER);

		
	}
	
	
	public void createAndAddButtons(JPanel numbers, JPanel operations) {
		
		//Allgemein: Setze Größe von jedem Button auf 80x50
		
		JButton nullButton = new JButton("0");
		nullButton.setPreferredSize(new Dimension(80, 50));
		JButton einsButton = new JButton("1");
		einsButton.setPreferredSize(new Dimension(80, 50));
		JButton zweiButton = new JButton("2");
		zweiButton.setPreferredSize(new Dimension(80, 50));
		JButton dreiButton = new JButton("3");
		dreiButton.setPreferredSize(new Dimension(80, 50));
		JButton vierButton = new JButton("4");
		vierButton.setPreferredSize(new Dimension(80, 50)); 
		JButton fünfButton = new JButton("5");
		fünfButton.setPreferredSize(new Dimension(80, 50));
		JButton sechsButton = new JButton("6");
		sechsButton.setPreferredSize(new Dimension(80, 50));
		JButton siebenButton = new JButton("7");
		siebenButton.setPreferredSize(new Dimension(80, 50));
		JButton achtButton = new JButton("8");
		achtButton.setPreferredSize(new Dimension(80, 50));
		JButton neunButton = new JButton("9");
		neunButton.setPreferredSize(new Dimension(80, 50));
		JButton gleichButton = new JButton("=");
		gleichButton.setPreferredSize(new Dimension(80, 50)); 
		JButton löschButton = new JButton("C");
		löschButton.setPreferredSize(new Dimension(80, 50)); 
		JButton kommaButton = new JButton(",");
		kommaButton.setPreferredSize(new Dimension(80, 50));
		
		JButton plusButton = new JButton("+");
		plusButton.setPreferredSize(new Dimension(50, 50)); 
		JButton minusButton = new JButton("-");
		minusButton.setPreferredSize(new Dimension(50, 50)); 
		JButton malButton = new JButton("*");
		malButton.setPreferredSize(new Dimension(50, 50)); 
		JButton geteiltButton = new JButton("/");


		
		numbers.add(siebenButton);
		numbers.add(achtButton);
		numbers.add(neunButton);
		numbers.add(vierButton);
		numbers.add(fünfButton);
		numbers.add(sechsButton);
		numbers.add(einsButton);
		numbers.add(zweiButton);
		numbers.add(dreiButton);
		numbers.add(kommaButton);
		numbers.add(nullButton);
		numbers.add(gleichButton);
		
		
		operations.add(plusButton);
		operations.add(minusButton);
		operations.add(malButton);
		operations.add(geteiltButton);

		
	}

}
