package hPConnect4Areej;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;


public class GamePage {
	private static JFrame game;
	private static Puzzle puzzle;
	
//	private  Timer timer;
//	private TimerTask fin;
//	private TextField clock;
	
//	private int min;
//	private int sec;
	
	
	public static void main(String [] args) {
		game = new JFrame();
		game.setSize(1000, 900);
		
		game.setBackground(Color.darkGray);
		
		puzzle = new Puzzle(new ImageIcon(GamePage.class.getResource("Imagess.jpg")).getImage());
		
		game.setLayout(new BorderLayout());
		game.add(puzzle,BorderLayout.CENTER);
		
		game.setLocationRelativeTo(null);
		
		game.setResizable(false);
		game.setVisible(true);
		
		game.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (!puzzle.started) puzzle.start();
				else if (puzzle.mixing) puzzle.mixing = false;
				else puzzle.onClick(e);
			}
		});
	
	
/*	public void initialize() {
		
		min = 3;
		sec = 60;
		
		clock = new TextField(40,40,200,30,"Text Here","Food");
		
		startClock();
		
	//	timer = new TextField(min + ":" + sec);
	}
	
		*/
	}
}