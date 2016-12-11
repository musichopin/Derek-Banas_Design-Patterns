// The Flyweight design pattern is used when you need to
// create a large number of similar objects

// **To reduce memory this pattern shares Objects that are 
// the same rather than creating new ones**

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FlyWeightTest extends JFrame{

	private static final long serialVersionUID = 1L;

	JButton startDrawing;
	
	int windowWidth = 1200;
	int windowHeight = 700;
	
	// A new rectangle is created only if a new color is needed
	
	Color[] shapeColor = {Color.orange, Color.red, Color.yellow,
			Color.blue, Color.pink, Color.cyan, Color.magenta,
			Color.black, Color.gray};
	
	public static void main(String[] args){
		
		new FlyWeightTest();
		
	}
	
	public FlyWeightTest(){
		
		// Create the frame, position it and handle closing it
		
		this.setSize(windowWidth,windowHeight);
		this.setLocationRelativeTo(null); // frame is located in the centre of the screen
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Flyweight Test");
		
//		this jpanel contains both jbutton and another jpanel on which graphics are drawn
		JPanel contentPane = new JPanel();
		
		contentPane.setLayout(new BorderLayout());
		
		final JPanel drawingPanel = new JPanel();
		
		startDrawing = new JButton("Button 1");
		
		contentPane.add(drawingPanel,  BorderLayout.CENTER);
		
		contentPane.add(startDrawing, BorderLayout.SOUTH);
		
		startDrawing.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {

//				drawingPanel is where we start drawing inside of
				Graphics g = drawingPanel.getGraphics();
	            
	            long startTime = System.currentTimeMillis();
	            
//	            ***bu patternin etkili olmasý için min 10 milyon iteration olmasý lazým***
	            for(int i=0; i < 100000; ++i) {
	            	
	            	// *****//////////3. FlyweightTest, MyRect ve RectFactory classlarýnýn 3 ü de varken///////////*****
	            	// Uses rectangles stored in the HashMap to
	            	// speed up the program
	            	
//	            	**RectFactory.getRect(getRandColor()) returns a new rectangle object only if
//	            	a color we specify with getRandColor() hasnt already been created now**
	            	MyRect rect = RectFactory.getRect(getRandColor());
	                rect.draw(g, getRandX(), getRandY(),
	                		getRandX(), getRandY());
	                
	            	// *****/////////2. RectFactory class yokken/////////*****
	            	/*
	            	MyRect rect = new MyRect(getRandColor(), getRandX(), getRandY(), getRandX(), getRandY());
	            	rect.draw(g);
	            	*/
	            	

	            	// *****//////////1. sadece FlyWeightTest classý varken///////////*****
	            	/*
	            	g.setColor(getRandColor());
	            	g.fillRect(getRandX(), getRandY(), getRandX(), getRandY());
	            	*/
	            	
	            	
	            }
	            
	            long endTime = System.currentTimeMillis();

	            System.out.println("That took " + (endTime - startTime) + " milliseconds");
	            
	         }
	      });
		
		this.add(contentPane);
		
		this.setVisible(true);
		
	}
	
	// Picks random x & y coordinates
	
	private int getRandX(){ return (int)(Math.random()*windowWidth); }
//	alt:
//  private int getRandX(){
//		Random randomGenerator = new Random(); 
//		int randInt = randomGenerator.nextInt(windowWidth); 
//		return randInt; 
//	}
	
	private int getRandY(){ return (int)(Math.random()*windowHeight); }
	
	// Picks a random Color from the 9 available
	
	private Color getRandColor(){
		Random randomGenerator = new Random();
		
		int randInt = randomGenerator.nextInt(9);
//		alt:
//		int randInt = (int) (Math.random() * 9);
		
		return shapeColor[randInt]; 
		
	}
	
}