package logic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.*;

public class Calculator extends JPanel{
	
	MyFrame frame;
	static JTextField t;
	int currentResult = 0; 
	
	
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
		
	    
	    
		
	    screen.setLayout(new BorderLayout());
		
	    
	    t = new JTextField();
	    t.setEditable(false);
	    screen.add(t,BorderLayout.CENTER);
	    
	    
	    
	    
		
		
		keyBoard.add(operations,BorderLayout.EAST);
		keyBoard.add(numbers,BorderLayout.CENTER);
		
		
		this.add(screen,BorderLayout.NORTH);
		this.add(keyBoard,BorderLayout.CENTER);

		
	}
	
	
	public void createAndAddButtons(JPanel numbers, JPanel operations) {
		
		
		//Erstelle alle 9 Zahlen als Buttons
		for(int i = 0; i <= 9; i++) {
			JButton zahlButton = new JButton(Integer.toString(i));
			zahlButton.setPreferredSize(new Dimension(80, 50)); //Größe der Buttons setzen
			numbers.add(zahlButton);	//Zur Tastatur hinzufügen
			
			
			
			//Jedem Button eine Funktion beim Klicken geben	
			zahlButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					t.setText(t.getText()+zahlButton.getText());
					
					
				}
				
				
				
			});

		}
		
		
		//Erstelle die Operationen Buttons alle separat und setze die jeweilige Größe
		JButton gleichButton = new JButton("=");
		gleichButton.setPreferredSize(new Dimension(80, 50)); 
		gleichButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.setText(Integer.toString(currentResult));
			}
			
		});
		
		
		JButton löschButton = new JButton("C");
		löschButton.setPreferredSize(new Dimension(80, 50)); 
		löschButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.setText("");
			}
			
		});
		
		JButton kommaButton = new JButton(",");
		kommaButton.setPreferredSize(new Dimension(80, 50));
		
		
		JButton plusButton = new JButton("+");
		plusButton.setPreferredSize(new Dimension(50, 50)); 
		löschButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				t.setText(t.getText()+ "+");
				
				
			}
			
		});
		
		
		JButton minusButton = new JButton("-");
		minusButton.setPreferredSize(new Dimension(50, 50)); 
		JButton malButton = new JButton("*");
		malButton.setPreferredSize(new Dimension(50, 50)); 
		JButton geteiltButton = new JButton("/");


		
	
		numbers.add(kommaButton);
		numbers.add(gleichButton);
		
		operations.add(plusButton);
		operations.add(minusButton);
		operations.add(malButton);
		operations.add(geteiltButton);

		
	}

}
