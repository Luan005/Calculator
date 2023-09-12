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
import java.math.BigDecimal;


public class Calculator extends JPanel implements ActionListener{
	
	MyFrame frame;
	static JTextField t;
	double currentResult = 0; 
	
	
	//Alle Buttons erstellen
	JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bMinus, bPlus, bMultiply, bDivides, bEquals, bDelete, bComma;
	
	
	
	//s1 ist die Zahl vor der Operation, s2 ist die Zahl nach der Operation
	String s1 = "";
	String s2 = "";
	
	
	//Speichert die aktuelle Operation, sodass nach der Eingabe von 2 Zahlen die adäquate Operation ausgeführt wird
	String currentOperation;
	
	
	public Calculator(MyFrame frame) {
		
		this.frame = frame;
		this.setMinimumSize(new Dimension(500, 500));
		this.setLayout(new BorderLayout());
		
		
		
		currentOperation = "";
		
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
		
		
		
		//Buttons für die Zahlen initialisieren
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
		
		
		

		//Buttons für die Operationen initialisieren
		bEquals = new JButton("=");
		bEquals.setPreferredSize(new Dimension(80, 50)); 
		
		bDelete = new JButton("C");
		bDelete.setPreferredSize(new Dimension(80, 50)); 
		
		bPlus = new JButton("+");
		bPlus.setPreferredSize(new Dimension(80, 50)); 
		
		bMinus = new JButton("-");
		bMinus.setPreferredSize(new Dimension(80, 50)); 
		
		bMultiply = new JButton("*");
		bMultiply.setPreferredSize(new Dimension(80, 50)); 
		
		
		bDivides = new JButton("/");
		bDivides.setPreferredSize(new Dimension(80, 50)); 		
		
		bComma = new JButton(".");

		
		
		
		
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
		
		
		
		bComma.addActionListener(this);

		

		/*
		 * Nächste Schritte:
		 * 1. Delete Button für nur eine Zahl
		 * 2. Boundary hinzufügen sodass Abstand zwischen allen buttons herrscht
		 * 3. , Zahl einfügen
		 * 4. Klammern machen
		 */
		


		
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
		numbers.add(bComma);

		
		
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
			
		
			//Je nach Button wird die adäquate Operation ausgeführt
			switch(buttonName)  {
			
			case "C":
				currentOperation = "";
				t.setText("");
				s1 = s2 = "";
				break;
				
			case "+":
			    currentOperation = "+";
			    t.setText(t.getText().concat("+"));
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    currentOperation = "+";
			    
			    break;
			 
			    
			case "-":
			    currentOperation = "-";
			    t.setText(t.getText().concat("-"));
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    currentOperation = "-";
			    break;
			    
			 
			case "*":
			    currentOperation = "*";
			    t.setText(t.getText().concat("*"));
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    currentOperation = "*";
			    break;
			    
			    
			case "/":
			    currentOperation = "/";
			    t.setText(t.getText().concat("/"));
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    currentOperation = "/";
			    
			    break;
			    
			    
			case "=":
				computeResult(currentOperation);
				
				/*
				 * Hier prüfe ich ob das Ergebnis eine Ganzzahl ist oder eine Kommazahl(zwischen 0 und 1 als Nachkommastelle)
				 * Falls es eine Nachkommastelle ist, so wird diese exakt so ausgegeben.
				 * Falls es keine Nachkommastelle ist, so wird dieses als int ausgegeben, also ohne ein Komma
				 */
				
				if(currentResult % 1 == 0) {
				    t.setText(String.valueOf((int)currentResult));
				} else {
					t.setText(String.valueOf(currentResult));
				}
				
				
				//Das Ergebnis wird dann in s1 gespeichert, sodass die nächste Zahl, die man eintippt, zu s2 dazugezählt wird
			    s1 = String.valueOf(currentResult);
			    s2 = "";
			    
			    
			    //Setze das aktuelle Ergebnis wieder auf Null, um mit ihr weiterzurechnen
			    currentResult = 0;
			    
			    System.out.println("S1: " + s1);
			    System.out.println("S2: " + s2);

			    break;
			    
			 
			case ".":
			    t.setText(t.getText().concat("."));
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    			    
			    if(!currentOperation.equals("")) {
			    	s2+=buttonName;
			    } else {
			    	s1+=buttonName;
			    }
			    
			    break;
			    
			    
			    
			
			//Der Fall, wenn keine Operation, sondern eine Zahl eingegeben wird
			default:
			    t.setText(t.getText().concat(buttonName));
			    t.setFont(new Font("Arial", Font.BOLD, 45));
			    
			    
			    
			    //Wenn eine Operation eingegeben wurde: Zahl gehört zu s2, sonst zu s1
			    if(!currentOperation.equals("")) {
			    	s2+=buttonName;
			    } else {
			    	s1+=buttonName;
			    }
			    
			
			
		}
		
	
				
				
				
				
			}
			
			
			
	


	//Mit dieser Methode wird das Endergebnis je nach Operation berechnet
	public double computeResult(String operation) {
		
		
		
		switch(currentOperation) {
		
		case "+":
			
			
			//Speichere beide Variablen als BigDecimal Variable, damit keine langen Nachkommastellen enstehen
			BigDecimal num1 = new BigDecimal(s1);
	        BigDecimal num2 = new BigDecimal(s2);

	        
	        //Ergebnis der Addition der beiden Variablen
	        BigDecimal result = num1.add(num2);
			
			
	        //Wandle das aktuelle Ergebnis in eine BigDecimal um, damit das aktuelle Ergebnis mit den beiden variablen addiert werden kann
	        BigDecimal currentResultBigDecimal = BigDecimal.valueOf(currentResult);
	        
	        
	        //Addiere das aktuelle Ergebnis mit den beiden Variablen
	        currentResultBigDecimal.add(result);
	        
	        
	        //Weise das Ergebnis einer double variable zu, um diese danach der ursprünglichen currentResult Variable zuzuweisen
	        double endResult = result.add(BigDecimal.valueOf(currentResult)).doubleValue();

			currentResult = endResult;
	        
			break;
			
		case "-":
			currentResult+=Double.parseDouble(s1)-Double.parseDouble((s2));
			break;
		
		case "*":
			currentResult+=Double.parseDouble(s1)*Double.parseDouble((s2));
			break;
			
		case "/":
			currentResult+=Double.parseDouble(s1)/Double.parseDouble((s2));
			break;
		
			
			
		}
		
		t.setText(t.getText().concat(String.valueOf(currentResult)));
		return currentResult;

	
	}
}
		
		
	
	
	
