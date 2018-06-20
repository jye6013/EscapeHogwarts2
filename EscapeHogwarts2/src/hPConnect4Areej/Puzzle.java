package hPConnect4Areej;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Puzzle extends JPanel {
	Pieces[] segments;
	Image img;
	
	public boolean started = false;
	public boolean mixing = false;
	
	private Button escape = new Button();
	
	public Puzzle(Image img) {
		this.img = img;
		//initialize segments
		segments = new Pieces[9];
		int segmentSize = img.getWidth(null)/3;
		for (int i = 0; i != segments.length; i++) {
			//Pass the Segment the instance of the Game, its position (by the index) and its size
			segments[i] = new Pieces(this, i, segmentSize);
		}
	}
	
	public void start() {
		started = true;
		//remove segment 8 (bottom right)
		segments[8].isEmpty = true;
		mix.start();
	}
	
	//shuffle segments by switching one of the neighboring segments of the empty one with the empty one
	Thread mix = new Thread(new Runnable() {
		public void run() {
			mixing = true;
			while (mixing) {
				ArrayList<Integer> possibleMoves = new ArrayList<Integer>();
				for (Pieces p : segments) {
					if (p.getPosition().x == segments[8].getPosition().x+1 && p.getPosition().y == segments[8].getPosition().y) {
						possibleMoves.add(p.getPieceNum());
					}
					if (p.getPosition().x == segments[8].getPosition().x-1 && p.getPosition().y == segments[8].getPosition().y) {
						possibleMoves.add(p.getPieceNum());
					}
					if (p.getPosition().x == segments[8].getPosition().x && p.getPosition().y == segments[8].getPosition().y-1) {
						possibleMoves.add(p.getPieceNum());
					}
					if (p.getPosition().x == segments[8].getPosition().x && p.getPosition().y == segments[8].getPosition().y+1) {
						possibleMoves.add(p.getPieceNum());
					}
				}
				
				int moves = (int) ((Math.random()*possibleMoves.size()));
				try {
					Point tmp = segments[possibleMoves.get(moves)].getPosition();
					segments[possibleMoves.get(moves)].setPosition(segments[8].getPosition());
					segments[8].setPosition(tmp);
				} catch (Exception e) {}
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {}
			}
		}
	});
	
	//Check if the user clicked onto a segment and if possible move it onto the empty one
	public void onClick(MouseEvent e) {
		for (Pieces s : segments) {
			if (s.hitten(e.getPoint())) {
				Point tmp = s.getPosition();
				if (s.move(segments[8].getPosition())) {
					segments[8].setPosition(tmp);
					
					//Check if user is done by comparing it's position with the one it should have
					boolean done = true;
					for (int i = 0; i != 9; i++) {
						if (segments[i].getPosition().x == ((i <= 2)? i:(i <= 5)? (i-3):(i-6)) && segments[i].getPosition().y == (int) Math.ceil((i/3))) {
							
						} else {
							
							done = false;
						}
					}
					
					if (done) {
						started = false;
						segments[8].isEmpty = false;
					}
				}
			}
		}
		repaint();
		
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i != segments.length; i++) {
			
			segments[i].paint(g);
		}
	}
	
}
