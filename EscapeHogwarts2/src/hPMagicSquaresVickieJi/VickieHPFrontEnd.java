package hPMagicSquaresVickieJi;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class VickieHPFrontEnd extends FullFunctionScreen implements JiHPSupport {

	private VickieHPSupport backend;

	private Button[] numberButtons;
	private MagicSquareGridButtons[] gB;
	private TextArea[] txtAreas;

	private String numClicked;

	private TextArea error;
	private TextArea counter; // testing purposes
	private TextArea hint1;

	private int count; // testing purposes

	private Color trans;

	private int c;

	private int[][] magicSquares;

	private int initNumBackEnd; // getInitiateNum()

	private TextAreaColor bTimer;
	private TextAreaColor tTimer;

	// private TextAreaColor hint;

	private int minutes;
	private int seconds;
	
	private int g;

	private int h;

	private Timer timer;

	private TimerTask complete;

	private TextArea hint3;

	private TextArea hint2;

	private Button font1plus;
	private Button font1sub;
	private Button font2plus;
	private Button font2sub;
	private Button font3plus;
	private Button font3sub;

	private Button hOne;
	private Button hTwo;
	private Button hThree;

	private TextAreaColor hintBox;

	private int goldI;

	private Graphic board;

	public VickieHPFrontEnd(int width, int height) {
		super(width, height);

		setVisible(true);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		backend = new JiHPBackEnd(this);

		minutes = 4;
		seconds = 60;
		numClicked = "0";

		trans = newColorWithAlpha(Color.white, 70);

		numberButtons = new Button[9];
		gB = new MagicSquareGridButtons[9];
		txtAreas = new TextArea[9];

		count = 0; // testing purposes
		// if(count == 0)backend.chooseStartingPoint();

		Graphic background = new Graphic(0, 0, getWidth(), getHeight(), "images/background3.jpg");
		viewObjects.add(background);

		board = new Graphic(450, 50, 700, 700, "images/mSBoard.jpg");
		board.preserveRatio = false;
		viewObjects.add(board);
		

		Graphic border = new Graphic(450, 50, 700, 700, "images/grid.png");
		viewObjects.add(border);

		error = new TextArea(50, 50, 200, 200, "ERROR: \n Please choose a # button");
		viewObjects.add(error);
		error.setVisible(false);

		counter = new TextArea(50, 50, 700, 700, "" + count); // testing purposes
		viewObjects.add(counter);

		// Graphic textb = new Graphic(50, 50, 500, 100, "images/textbox2.png");
		// viewObjects.add(textb);

		/*
		 * bTimer = new TextAreaColor(50, 50, 320, 150, "Timer:        .", trans, null);
		 * viewObjects.add(bTimer);
		 */

		Graphic wood = new Graphic(50, 50, 320, 150, "images/mSBoard320.jpg");
		viewObjects.add(wood);

		tTimer = new TextAreaColor(50, 50, 320, 150, "5:00", null, null);
		viewObjects.add(tTimer);
		
		Graphic hwood = new Graphic(50, 600, 320, 150, "images/mSBoard320.jpg");
		viewObjects.add(hwood);

		hintBox = new TextAreaColor(50, 600, 320, 150, "HINTS", null, null);
		viewObjects.add(hintBox);

		hOne = new Button(380, 635, 25, 25, "1", Color.blue, new Action() {

			@Override
			public void act() {
				//goldI++;
				//txtAreas[goldI].setForeground(Color.yellow);
				if (minutes  < 4) {
					hintBox.setText("");
					//hintBox.setText("The '5' is always in the middle");
					hint3.setVisible(false);
					hint2.setVisible(false);
					hint1.setVisible(true);
				}else {
					hintBox.setText("Unlocked at 4:00");
				}
				
			}
			
		});
		hOne.setCurve(10, 20);
		viewObjects.add(hOne);
		
		ClickableGraphic tr = new ClickableGraphic(380, 665, 25, 25, "images/MSboard.jpg");
		viewObjects.add(tr);
		
		hTwo = new Button(380, 665, 30, 30, "2", Color.blue,new Action() {

			@Override
			public void act() {
				if (minutes < 3) {
					hintBox.setText("");
					//hintBox.setText("The numbers opposite the '5' in a column/row/ diagonal has to add up to ten");
					hint3.setVisible(false);
					hint1.setVisible(false);
					hint2.setVisible(true);
				}else {
					hintBox.setText("Unlocked at 3:00");
					hint1.setVisible(false);
				}
			}
			
		});
		//hTwo.setCurve(10, 20);
		viewObjects.add(hTwo);
		
		hThree = new Button(380, 695, 25, 25, "3", Color.blue,new Action() {

			@Override
			public void act() {
				if (minutes < 2) {
					hintBox.setText("");
					//hintBox.setText("Besides the 5, odd numbers are never adjacent to even numbers and vice versa");
					hint2.setVisible(false);
					hint1.setVisible(false);
					hint3.setVisible(true);
					
				}else {
					hintBox.setText("Unlocked at 2:00");
					hint2.setVisible(false);
					hint1.setVisible(false);
				}
			}
			
		});
		hThree.setCurve(10,20);
		viewObjects.add(hThree);

		hint1 = new TextArea(55, 600, 320, 500, "The '5' is always    in the middle");
		hint1.setForeground(Color.red);
		viewObjects.add(hint1);

		hint2 = new TextArea(50, 600, 320, 500,
				"The numbers opposite the 5  in a column/row/diagonal    has to add up to ten");
		hint2.setForeground(Color.orange);
		viewObjects.add(hint2);

		hint3 = new TextArea(50, 600, 320, 500,
				" Besides the 5, odd numbers are NEVER adjacent to even    numbers and vice versa");
		hint3.setForeground(Color.yellow);
		viewObjects.add(hint3);
		
		hint1.setVisible(false);
		hint3.setVisible(false);
		hint2.setVisible(false);
		

		// hOne= new Button

		// Test.setBaseFont(f);
		startTimer();
		createKeyPadButtons();
		createGridButtons();
		createTxtArea();
		setUpGrid();

	}

	public void createKeyPadButtons() {
		// System.out.println("createKeyPadButtons()");
		// create buttons
		for (int i = 0; i < numberButtons.length; i++) {
			if (i == 0 || i < 3) {
				numberButtons[i] = new Button(50 + 110 * i, 250, 100, 100, i + 1 + "", trans, null);
				viewObjects.add(numberButtons[i]);
			} else if (i == 3 || i < 6) {
				numberButtons[i] = new Button(50 + 110 * (i - 3), 360, 100, 100, i + 1 + "", trans, null);
				viewObjects.add(numberButtons[i]);
			} else if (i == 6 || i < 9) {
				numberButtons[i] = new Button(50 + 110 * (i - 6), 470, 100, 100, i + 1 + "", trans, null);
				viewObjects.add(numberButtons[i]);
			}
		}

		numberButtons[0].setAction(new Action() {
			public void act() {
				numButtonAction(0);
			}
		});
		numberButtons[1].setAction(new Action() {
			public void act() {
				numButtonAction(1);
			}
		});
		numberButtons[2].setAction(new Action() {
			public void act() {
				numButtonAction(2);
			}
		});
		numberButtons[3].setAction(new Action() {
			public void act() {
				numButtonAction(3);
			}
		});
		numberButtons[4].setAction(new Action() {
			public void act() {
				numButtonAction(4);
			}
		});
		numberButtons[5].setAction(new Action() {
			public void act() {
				numButtonAction(5);
			}
		});
		numberButtons[6].setAction(new Action() {
			public void act() {
				numButtonAction(6);
			}
		});
		numberButtons[7].setAction(new Action() {
			public void act() {
				numButtonAction(7);
			}
		});
		numberButtons[8].setAction(new Action() {
			public void act() {
				numButtonAction(8);
			}
		});
	}

	public void numButtonAction(int num) {
		// System.out.println("numButtonAction(int num)");
		numClicked = numberButtons[num].getText();
		count++;
		counter.setText("" + count);

		changeButtonColor(num, initNumBackEnd);

		numberButtons[num].setVisible(false);

		numberButtons[num].setBackground(Color.white);

		numberButtons[num].setVisible(true);
		error.setVisible(false);
	}

	public void changeButtonColor(int num, int initial) {
		// System.out.println("changenumberButton()");
		// System.out.println("Initial num from method = " + initial);
		for (int i = 0; i < 9; i++) {
			if (i != initial - 1) {
				numberButtons[i].setVisible(false);
				numberButtons[i].setBackground(null);
				numberButtons[i].setVisible(true);
				numberButtons[i].setVisible(false);
				numberButtons[i].setBackground(newColorWithAlpha(Color.white, 120));
				numberButtons[i].setVisible(true);
			} else {
				numberButtons[initial - 1].setVisible(false);
				numberButtons[initial - 1].setBackground(null);
				numberButtons[initial - 1].setVisible(true);
				numberButtons[initial - 1].setVisible(false);
				numberButtons[initial - 1].setBackground(Color.black);
				numberButtons[initial - 1].setVisible(true);
			}
		}
	}

	public void createGridButtons() {
		// System.out.println("createGridButtons()");
		c = -1;

		for (int i = 0; i < gB.length; i++) {
			int r = 0;

			// System.out.println("Coords:(" + r + "," + c + ")");
			if (i == 0 || i < 3) {
				c = c + 1;
				gB[i] = new MagicSquareGridButtons(500 + 202 * i, 100, 195, 195, "", trans, null, r, c);
				viewObjects.add(gB[i]);
				// System.out.println("Coords:(" + r + "," + c + ")");
				// System.out.println(gB[i].getCoord());
				// System.out.println("Gi = " + i);
				if (i == 2) {
					c = -1;
				}
			} else if (i == 3 || i < 6) {
				r = 1;
				c = c + 1;
				gB[i] = new MagicSquareGridButtons(500 + 202 * (i - 3), 302, 195, 195, "", trans, null, r, c);
				viewObjects.add(gB[i]);
				// System.out.println("Coords:(" + r + "," + c);
				// System.out.println(gB[i].getCoord());
				// System.out.println("Gi = " + i);
				if (i == 5) {
					c = -1;
				}
			} else if (i == 6 || i < 9) {
				r = 2;
				c = c + 1;
				gB[i] = new MagicSquareGridButtons(500 + 202 * (i - 6), 505, 195, 195, "", trans, null, r, c);
				viewObjects.add(gB[i]);
				// System.out.println("Coords:(" + r + "," + c);
				// System.out.println(gB[i].getCoord());
				// System.out.println("Gi = " + i);

			}
		}

		gB[0].setAction(new Action() { // (0,0)
			public void act() {
				updateGrid(0);
				backend.resetMultiples(Integer.parseInt(numClicked));
				setValues(0, 0);

			}
		});
		gB[1].setAction(new Action() { // (0,1)
			public void act() {
				updateGrid(1);
				backend.resetMultiples(Integer.parseInt(numClicked));
				setValues(0, 1);
			}
		});
		gB[2].setAction(new Action() { // (0,2)
			public void act() {
				updateGrid(2);
				backend.resetMultiples(Integer.parseInt(numClicked));
				setValues(0, 2);
			}
		});
		gB[3].setAction(new Action() { // (1,0)
			public void act() {
				updateGrid(3);
				backend.resetMultiples(Integer.parseInt(numClicked));
				setValues(1, 0);
			}
		});
		gB[4].setAction(new Action() { // (1,1)
			public void act() {
				updateGrid(4);
				backend.resetMultiples(Integer.parseInt(numClicked));
				setValues(1, 1);

			}
		});
		gB[5].setAction(new Action() { // (1,2)
			public void act() {
				updateGrid(5);
				backend.resetMultiples(Integer.parseInt(numClicked));
				setValues(1, 2);

			}
		});
		gB[6].setAction(new Action() { // (2,0)
			public void act() {
				updateGrid(6);
				backend.resetMultiples(Integer.parseInt(numClicked));
				setValues(2, 0);

			}
		});
		gB[7].setAction(new Action() { // (2,1)
			public void act() {
				updateGrid(7);
				backend.resetMultiples(Integer.parseInt(numClicked));
				setValues(2, 1);

			}
		});
		gB[8].setAction(new Action() { // (2,2)
			public void act() {
				updateGrid(8);
				backend.resetMultiples(Integer.parseInt(numClicked));
				setValues(2, 2);

			}
		});

	}

	public void updateGrid(int num) {
		// System.out.println("updateGrid()");
		if (numClicked.equals("0")) {
			error.setVisible(true);
		} else {
			for (int i = 0; i < txtAreas.length; i++) {
				// font();
				// String nC = numClicked + "";
				String n = txtAreas[i].getText();
				if (numClicked.equals(n)) {
					// font();
					txtAreas[i].setText("?");

					if (i == 0 || i < 3) {
						txtAreas[i].move(580 + 203 * i, 150, 100);
						viewObjects.add(txtAreas[i]);
					} else if (i == 3 || i < 6) {
						txtAreas[i].move(580 + 203 * (i - 3), 350, 100);// y+203
						viewObjects.add(txtAreas[i]);
					} else if (i == 6 || i < 9) {
						txtAreas[i].move(580 + 203 * (i - 6), 562, 100);
						viewObjects.add(txtAreas[i]);
					}
				}

				txtAreas[num].update();
				// font();
			}

			if (num == 0 || num < 3) {
				txtAreas[num].move(560 + (203 * num), 105, 100);
			} else if (num == 3 || num < 6) {
				txtAreas[num].move(560 + (203 * (num - 3)), 308, 100);// y+203
			} else if (num == 6 || num < 9) {
				txtAreas[num].move(560 + 203 * (num - 6), 511, 100);
			}

			txtAreas[num].setText(numClicked);
			font();
		}

	}

	public void createTxtArea() {
		// System.out.println("createTxtArea()");
		for (int i = 0; i < txtAreas.length; i++) {
			if (i == 0 || i < 3) {
				txtAreas[i] = new TextArea(580 + 203 * i, 150, 195, 195, "?");
				viewObjects.add(txtAreas[i]);
			} else if (i == 3 || i < 6) {
				txtAreas[i] = new TextArea(580 + 203 * (i - 3), 350, 195, 195, "?");// y+203
				viewObjects.add(txtAreas[i]);
			} else if (i == 6 || i < 9) {
				txtAreas[i] = new TextArea(580 + 203 * (i - 6), 562, 195, 195, "?");
				viewObjects.add(txtAreas[i]);
			}
		}
	}

	public void setUpGrid() {
		// System.out.println("setUpGrid()");
		// Get number from backend
		backend.chooseStartingPoint();
		// stores number from backend
		initNumBackEnd = backend.getInitiateNum();
		// System.out.println("Initial num from backend = " + initNumBackEnd);
		// stores initial coordinate from backend
		int r = backend.getRowNum();
		int c = backend.getColNum();
		String p = r + "," + c;

		// compares initial coordinate with every button coordinate
		for (int i = 0; i < gB.length; i++) {
			// System.out.println("String p = gB[i].getCoord();" + p);
			String h = gB[i].getCoord();
			// System.out.println("String h = gB[i].getCoord();" + h);
			// if coordinates are a match, set num to the middle of button and make action
			// null
			if (p.equals(h)) {
				// System.out.println("THE SAME COORDINATES!!()");
				gB[i].setAction(null);
				txtAreas[i].setText("" + initNumBackEnd);
				
				Color maroon = new Color(182,47,32);
				txtAreas[i].setForeground(maroon); // maroon color
				
				if (i == 0 || i < 3) {
					txtAreas[i].move(560 + (203 * i), 105, 100);
				} else if (i == 3 || i < 6) {
					txtAreas[i].move(560 + (203 * (i - 3)), 308, 100);// y+203
				} else if (i == 6 || i < 9) {
					txtAreas[i].move(560 + 203 * (i - 6), 511, 100);
				}
				font();
			}
		}

		// disable number keypad buttons too
		for (int i = 0; i < numberButtons.length; i++) {
			int o = Integer.parseInt(numberButtons[i].getText());
			if (o == initNumBackEnd) {
				numberButtons[i].setAction(null);
				numberButtons[i].setBackground(Color.black);
				numberButtons[i].update();
			}
		}
	}

	public void font() {
		// System.out.println("font()");
		try {
			File fontFile = new File("images/HARRYP.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			Font baseFont = font.deriveFont(150f);
			Font a = font.deriveFont(55f);
			Font c = font.deriveFont(38f); // 30 /40
			Font b = font.deriveFont(38f);
			
			Font question = font.deriveFont(70f);
			
			Font hB = font.deriveFont(25f);
			for (int i = 0; i < txtAreas.length; i++) {

				String q = txtAreas[i].getText();
				if (q.equals("?")) {
					txtAreas[i].setFont(question);
				} else {
					txtAreas[i].setFont(baseFont);
				}

			}
			hint1.setFont(a);
			hint2.setFont(b);
			hint3.setFont(c);

			hintBox.setFont(b);
			
			hOne.setFont(hB);
			hTwo.setFont(hB);
			hThree.setFont(hB);
			

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	/*
	 * public void font(int num) { try { File fontFile = new
	 * File("images/HARRYP.ttf"); Font font = Font.createFont(Font.TRUETYPE_FONT,
	 * fontFile);
	 * 
	 * Font baseFont = font.deriveFont(150f); // default Font b =
	 * font.deriveFont(70f);
	 * 
	 * if(start == false) { start = true;
	 * 
	 * } txtAreas[num].setFont(baseFont); for (int i = 0; i < txtAreas.length; i++)
	 * { if (i != num) { String q = txtAreas[i].getText(); if (q.equals("?")) {
	 * txtAreas[i].setFont(b);
	 * 
	 * // txtAreas[i].move(newX, newY, durationMS); } else {
	 * txtAreas[i].setFont(baseFont); } } }
	 * 
	 * } catch (Exception e) {
	 * 
	 * e.printStackTrace();
	 * 
	 * } }
	 */

	public Color newColorWithAlpha(Color original, int alpha) {
		// System.out.println("newColorAlpha()");
		return new Color(original.getRed(), original.getGreen(), original.getBlue(), alpha);
	}

	public void setValues(int row, int col) {
		// System.out.print("------------------------------------------------------------------------------------------\n");
		// System.out.println("setValues()");
		magicSquares = backend.getBoxes();

		magicSquares[row][col] = Integer.parseInt(numClicked);
		// make method so backend can get new updated magicsquares
		// check by printing it out.
		// System.out.println("SET THE FING VALUES IN 2D ARRAY!! ");

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				System.out.println(r + "," + c + ":" + magicSquares[r][c]);
			}

		}
		// System.out.print("------------------------------------------------------------------------------------------\n");
		backend.setArr(magicSquares);
		check();
	}

	public void check() {
		int count = 0;
		boolean x;
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				if (magicSquares[row][col] != 0) {
					count++;
				}
			}
		}
		if (count == 9) {
			x = backend.checkTotal();
			if (x) {
				
				System.out.println("WINNNERNENRNENRNERNNENR!!!");
				
				//disable timer
				timer.cancel();
				
				//make gold
				 goldI = -1;
				Timer gold = new Timer();
				TimerTask y = new TimerTask() {
					@Override
					public void run() {
						goldI++;
						txtAreas[goldI].setForeground(Color.yellow);
						
						if(goldI ==8) {
							
						gold.cancel();
							
							
							//width = 2 Math.pi/2
							
							changeImages();
							//method call for resize
						}
					}
				};
				
				gold.schedule(y, 0, 500);
					
				//disable all buttons
			}
			else {
				System.out.println("WRONGNGNGNGNGNGNGNGNGNGNGN!!");
			}
		}
	}

	public void changeImages() {
		
		//width = 2 Math.cosine/2 double 
		
		
		Timer r = new Timer();
		TimerTask x = new TimerTask() {
			double rotation = 0;
			int counter = 0;
			@Override
			public void run() {
				counter++;
				if (rotation >= Math.PI * 2) {
					rotation = 0;
				}
				rotation += Math.PI/30;
				board.resize((int)(Math.abs(700*Math.cos(rotation))), board.getHeight());
				board.setX(450 + (350 - board.getWidth()/2));
				
				if(counter == 10) {
					 r.cancel();
				}
				
				
			}
		};
		
		r.schedule(x, 0, 60);
		
	}
	
	public void startTimer() {
		//g = 5;
		timer = new Timer();
		complete = new TimerTask() {
			@Override
			public void run() {
				if (minutes == 0 && seconds == 1) { //closeset is -1 and 60
					System.out.println(minutes + ":" + seconds);
					timer.cancel();
				}
				
			//	g--;
				seconds--;
				//hints(g);
				//if(g ==2) {
				//	g = 4;
				//}
				if (minutes == 4 && seconds == 0) {
					hints(minutes);
				}

				if (minutes == 3 && seconds == 0) {
					hints(minutes);
				}

				if (minutes == 2 && seconds == 0) {
					hints(minutes);
				}
				changeTimerFont();

				// tTimer

				if (seconds <= 9 && seconds >= 1) {
					tTimer.setText(minutes + ":0" + seconds); // 4:59
					tTimer.update();
				} else if (seconds == 0) {
					tTimer.setText(minutes-- + ":00");
					seconds = 60;
				} else {
					tTimer.setText(minutes + ":" + seconds); // 4:59
					tTimer.update(); // tTimer
				}

				/*
				 * Change color of text when minutes
				 */

			}

			public void changeTimerFont() {
				System.out.println("CHANGETIMERFONT:  " + minutes + ":" + seconds);
				try {
					File fontFile = new File("images/HARRYP.ttf");
					Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

					Font baseFont = font.deriveFont(150f);
					Font b = font.deriveFont(70f);

					if ((minutes == 0 && seconds == 0) || (minutes == 1 && seconds == 0)
							|| (minutes == 2 && seconds == 0) || (minutes == 3 && seconds == 0)
							|| (minutes == 4 && seconds == 0)) {
						System.out.println("CHANGETIMERFONT2:  " + minutes + ":" + seconds);
						tTimer.setFont(baseFont);
						// tTimer.setText(minutes--+":00");
					} else {
						tTimer.setFont(b);
						System.out.println("CHANGETIMERFONT3:  " + minutes + ":" + seconds);
					}

				} catch (Exception e) {

					e.printStackTrace();

				}
			}
		};
		timer.schedule(complete, 1000, 500);
	}

	public void hints(int num) {
		// @ 4:00: the 5 is always in the midfdle
		// @3:00: the numbers opposite the five in a column/row/diagonal has to add up
		// to 10
		// @2:00: Besides the 5, odd numbers are never adjacent to even numbers and vice
		// veras

		if (num == 4) {
			hintBox.setText("");
			hint1.setVisible(true);
		}

		if (num == 3) {
			hintBox.setText("");
			hint2.setVisible(true);
			hint1.setVisible(false);
			//hintBox.setText("The numbers opposite the '5' in a column/row/ diagonal has to add up to ten");
		}

		if (num == 2) {
			hintBox.setText("");
			hint3.setVisible(true);
			hint1.setVisible(false);
			hint2.setVisible(false);
			//hintBox.setText("Besides the 5, odd numbers are never adjacent to even numbers and vice versa");
		}
		
		
	}

}
