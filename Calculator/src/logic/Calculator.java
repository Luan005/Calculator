package logic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JPanel implements ActionListener{
	
	MyFrame frame;
	static JTextField t;
	int currentResult = 0; 
	
	JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bMinus, bPlus, bMultiply, bDivides, bEquals, bDelete;
	
	
	
	//s1 ist die Zahl vor der Operation, s2 ist die Zahl nach der Operation
	String s1, s2 = "";
	
	
	//Speichert die aktuelle Operation, sodass nach der Eingabe von 2 Zahlen die adäquate Operation ausgeführt wird
	String currentOperation;
	
	
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
		
		
		
		
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");
		
		
		

		
		bEquals = new JButton("=");
		bEquals.setPreferredSize(new Dimension(80, 50)); 
		bEquals.addActionListener(this);
		
		bDelete = new JButton("C");
		bDelete.setPreferredSize(new Dimension(80, 50)); 
		bDelete.addActionListener(this);

		
		bPlus = new JButton("+");
		bPlus.setPreferredSize(new Dimension(80, 50)); 
		bPlus.addActionListener(this);
		
		bMinus = new JButton("-");
		bMinus.setPreferredSize(new Dimension(80, 50)); 
		bMinus.addActionListener(this);

		
		
		bMultiply = new JButton("*");
		bMultiply.setPreferredSize(new Dimension(80, 50)); 
		bMultiply.addActionListener(this);

		
		bDivides = new JButton("/");
		bDivides.setPreferredSize(new Dimension(80, 50)); 
		bDivides.addActionListener(this);
		
		
		
		
		
		//Für jeden Button ActionListener hinzufügen, damit diese beim klicken reagieren
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		bEquals.addActionListener(this);
		bDelete.addActionListener(this);
		bPlus.addActionListener(this);
		bMinus.addActionListener(this);
		bMultiply.addActionListener(this);
		bDivides.addActionListener(this);
		


		


		
		numbers.add(b0);
		numbers.add(b1);
		numbers.add(b2);
		numbers.add(b3);
		numbers.add(b4);
		numbers.add(b5);
		numbers.add(b6);
		numbers.add(b7);
		numbers.add(b8);
		numbers.add(b9);

		numbers.add(bEquals);
		numbers.add(bDelete);

		
		
		operations.add(bPlus);
		operations.add(bMinus);
		operations.add(bMultiply);
		operations.add(bDivides);

		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Zuerst gucken, was für ein Button das ist und dann adäquate Reaktion einbauen
		
		JButton b = (JButton) e.getSource();
		String buttonName = b.getText();		
		
	
		//Idee: Nur 2 zahlen speichern, s1 und s2. nachdem man s2 eingegeben hat, wird s1 gelöscht und s2 wird zu s1 und das spiel geht von vorne los
			
			switch(buttonName)  {
			
			case "C":
				t.setText("");
				currentOperation = "";
				s1 = s2 = "";
				break;
				
			case "+":
				t.setText(t.getText()+ "+");
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    currentOperation = "+";
			    break;
			 
			    
			case "-":
				t.setText(t.getText()+ "-");
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    currentOperation = "-";
			    break;
			    
			 
			case "*":
				t.setText(t.getText()+ "*");
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    currentOperation = "*";
			    break;
			    
			    
			case "/":
				t.setText(t.getText()+ "/");
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    currentOperation = "/";
			    break;
			    
			    
			
			    
			default:
				t.setText(t.getText()+buttonName);
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    
			    if(!s1.equals("")) {
			    	s2+=buttonName;
			    } else {
			    	s1+=buttonName;
			    }
			    
			   
			
			
		}
		
	
				
				
				
				
			}
			
			
			
		}
		
		
	
	
	
