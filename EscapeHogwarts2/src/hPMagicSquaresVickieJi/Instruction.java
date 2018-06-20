package hPMagicSquaresVickieJi;

import guiTeacher.userInterfaces.FullFunctionScreen;
import hPStartGame.GuiLoadingVickie;

/*import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.components.ImageTextButton;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextColoredLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hPConnect4Areej.ConnectFourAreej;
import hPStartGame.GuiLoadingVickie;

public class Instruction extends VickieHPFrontEnd{ //FullFunctionScreen{

	private Graphic back;
	private VickieHPFrontEnd magicSquares;
	private Button skip;
	private Button story;
	
	private TextAreaColor t;
	private TextColoredLabel g;
	
	private TextAreaHoverButton[] numberButtons;
	
	private Point b;
	private PointerInfo a;
	
	private boolean gameRunning = true;
	
	private int mouseX;
	private int mouseY;
	private Graphic tB;

	
	//https://www.befunky.com/create/
	
	public Instruction(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	
	/*public void initAllObjects(List<Visible> viewObjects) {
		back = new Graphic(0, 0, getWidth(), getHeight(), "images/MS-instruction.png");
		//viewObjects.add(back);
		
		//timer
		Graphic trans = new Graphic(0,0, 500, 245, "images/transBlack.png");
		//trans.resize(500,500);
		//viewObjects.add(trans);
		
		
		skip = new Button(1000, 50, 100, 100, "Skip", Color.red, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new VickieHPFrontEnd(getWidth(), getHeight()));

			}

		});

		viewObjects.add(skip);

		story = new Button(500, 50, 100, 100, "Story", Color.blue, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new SirCadoganTheMadKnight(getWidth(), getHeight()));

			}

		});

		viewObjects.add(story);
	}*/
	
	/*public void addNecessaryButtons() {
		getMousePosition();
		
		skip = new Button(1000, 50, 100, 100, "Skip", Color.red, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new VickieHPFrontEnd(getWidth(), getHeight()));

			}

		});

		viewObjects.add(skip);

		story = new Button(500, 50, 100, 100, "Story", Color.blue, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new SirCadoganTheMadKnight(getWidth(), getHeight()));

			}

		});

		viewObjects.add(story);
		
		t = new TextAreaColor(600, 600, 100, 100, "IT WORKDDDDDDDDD", trans, null ); //attach image behind it
		viewObjects.add(t);
		t.setVisible(false);
		
		 tB = new Graphic(500,0,300,300,"images/transBlack.png");
		viewObjects.add(tB);
		tB.preserveRatio = false;
		tB.resize(400, 500);
		
		g = new TextColoredLabel(500, 100, 600, 300, "dfwerwerwesderwefs fgdfgsdfhd", null, Color.red);
		viewObjects.add(g);
		
		TextAreaHoverButton te = new TextAreaHoverButton(200,200,500,500,"dfgsfgdfg", trans,g, tB, null) ;
		viewObjects.add(te);
		
		TextColoredLabel tim = new TextColoredLabel(700, 500, 300, 300, "The Timer. You have five minutes to complete the puzzle.", null, Color.red);
		viewObjects.add(tim);
		
		TextAreaHoverButton timer = new TextAreaHoverButton(50, 50, 320, 150,"", null ,tim, tB, null) ;
		viewObjects.add(timer);
	}
	
	
	public void startTimer() {
		//make button over timer graphic so hover action can work
	}*/
	
	/*public void createKeyPadButtons() {
		numberButtons = new TextAreaHoverButton[9];
		for (int i = 0; i < numberButtons.length; i++) {
			if (i == 0 || i < 3) {
				numberButtons[i] = new TextAreaHoverButton(50 + 110 * i, 250, 100, 100, i + 1 + "", trans,g, tB, null);
				viewObjects.add(numberButtons[i]);
			} else if (i == 3 || i < 6) {
				numberButtons[i] = new TextAreaHoverButton(50 + 110 * (i - 3), 360, 100, 100, i + 1 + "", trans,g, tB, null);
				viewObjects.add(numberButtons[i]);
			} else if (i == 6 || i < 9) {
				numberButtons[i] = new TextAreaHoverButton(50 + 110 * (i - 6), 470, 100, 100, i + 1 + "", trans, g, tB,null);
				viewObjects.add(numberButtons[i]);
			}
		}
		

		numberButtons[0].setAction(new Action() {
			public void act() {
				System.out.println("this shit works");
				TextArea t = new TextArea(0,0,500,500,"UIHUIHIIU");
				viewObjects.add(t);
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
		
		for (int i = 0; i < numberButtons.length; i++) {
			int o = Integer.parseInt(numberButtons[i].getText());
			if (o == initNumBackEnd) {
				numberButtons[i].setAction(null);
				numberButtons[i].setBackground(Color.black);
				numberButtons[i].update();
			}
		}
	}

	/*public void getGeneratedNum() {
		// System.out.println("setUpGrid()");
				// Get number from backend
				backend.chooseStartingPoint();
				// stores number from backend
				initNumBackEnd = backend.getInitiateNum();
				if(initNumBackEnd == 5) {
					getGeneratedNum();
				}
				 System.out.println("Initial num from backend = " +backend.getInitiateNum()+ initNumBackEnd);
				// stores initial coordinate from backend
	}}*/

import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextColoredLabel;
import guiTeacher.interfaces.Visible;


public class Instruction extends VickieHPFrontEnd{//FullFunctionScreen implements JiHPSupport {

	

	private VickieHPSupport backend;

	
	private Point b;
	private PointerInfo a;
	
	private int mouseX;
	private int mouseY;

	private TextAreaHoverButton[] numberButtons; // keypad buttons
	private TextAreaHoverButton[] gB;

	private TextArea[] txtAreas; // board txtareas

	private String numClicked; // stored number

	private TextArea error; // error message saying you must click on keypad first

	public Color trans; // transparent white-ish color on keypad buttons

	private Graphic background;
	private Graphic board;

	private TextAreaColor tTimer;

	private int c;

	public int initNumBackEnd; // getInitiateNum()

	private TextAreaHoverButton hOne; // first hint button
	private TextAreaHoverButton hTwo; // second hint button
	private TextAreaHoverButton hThree; // third hint button

	
	private TextAreaColor hintBox;

	private Graphic border;

	private Graphic wood;


	private Graphic tB;

	private TextColoredLabel keyDesc;


	private TextColoredLabel blackedOut;


	private Button skip;


	private Button story;


	private TextAreaColor t;


	private Graphic timerBoard;


	private Graphic tBorder;


	private Graphic hBoard;


	private Graphic hBorder;


	private Graphic hOneBoard;


	private Graphic hintB;


	private TextColoredLabel hint;


	private TextColoredLabel hint1;


	private Graphic gG;


	private TextColoredLabel blackedOut1;


	private TextColoredLabel keyDesc1;


	private TextColoredLabel keyDesc2;


	private Graphic gG1;


	private TextAreaHoverButton timer;


	private TextAreaHoverButton hin;

	public Instruction(int width, int height) {
		super(width, height);

		setVisible(true);
	}

	public void initAllObjects(List<Visible> viewObjects) {
		
		backend = new JiHPBackEnd(this);

		numClicked = "0";
		
		trans = newColorWithAlpha(Color.white, 70);

		txtAreas = new TextArea[9];


		background = new Graphic(0, 0, getWidth(), getHeight(), "images/background3.jpg");
		viewObjects.add(background);

		board = new Graphic(450, 50, 700, 700, "images/mSBoard.jpg");
		board.preserveRatio = false;
		viewObjects.add(board);
		
		border = new Graphic(450, 50, 700, 700, "images/grid.png");
		viewObjects.add(border);
		//
		error = new TextArea(50, 50, 200, 200, "ERROR: \n Please choose a # button");
		viewObjects.add(error);
		error.setVisible(false);
		//
		timerBoard = new Graphic(50, 50, 320, 150, "images/mSBoard320.jpg");
		viewObjects.add(timerBoard);
		
		tBorder = new Graphic(50, 50, 320, 150, "images/grid.png");
		tBorder.preserveRatio=false;
		tBorder.resize(320, 150);
		viewObjects.add(tBorder);

		tTimer = new TextAreaColor(50, 50, 320, 150, "5:00", null, null);
		viewObjects.add(tTimer);
		//
		hBoard = new Graphic(50, 600, 320, 150, "images/mSBoard320.jpg"); 
		viewObjects.add(hBoard);
		
		hBorder = new Graphic(50, 600, 320, 150, "images/grid.png");
		hBorder.preserveRatio=false;
		hBorder.resize(320, 150);
		viewObjects.add(hBorder);

		hintBox = new TextAreaColor(50, 600, 320, 150, "HINTS", null, null);
		viewObjects.add(hintBox);
		//
		createGridButtons();
		createTxtArea();
		
		hintB = new Graphic(500,0,300,300,"images/transBlack.png");
		viewObjects.add(hintB);
		hintB.setVisible(false);
		
		hOneBoard = new Graphic(380, 620, 30, 30, "images/MSboard.jpg");
		viewObjects.add(hOneBoard);

		 hint = new TextColoredLabel(450, 50, 700, 100, "Hint Buttons", null, Color.red);
		viewObjects.add(hint);
		hint.setVisible(false);
		
		 hint1 = new TextColoredLabel(450, 150, 700, 200, "Navigate through hints", null, Color.blue);
		viewObjects.add(hint1);
		hint1.setVisible(false);
		
		
		Graphic h1Border = new Graphic(380, 620, 30, 30, "images/grid.png");
		viewObjects.add(h1Border);

		hOne = new TextAreaHoverButton(380, 620, 30, 30, "1", null, hint, hint1,hintB, null);
		hOne.setCurve(0, 0);
		viewObjects.add(hOne);

		//
		Graphic hTwoBoard = new Graphic(380, 660, 30, 30, "images/MSboard.jpg");
		viewObjects.add(hTwoBoard);

		hTwo = new TextAreaHoverButton(380, 660, 30, 30, "2", null, hint, hint1,hintB, null);
		hTwo.setCurve(0, 0); // 10,20
		viewObjects.add(hTwo);

		Graphic h2Border = new Graphic(380, 660, 30, 30, "images/grid.png");
		viewObjects.add(h2Border);
		//
		
		
		Graphic hThreeBoard = new Graphic(380, 700, 30, 30, "images/MSboard.jpg");
		viewObjects.add(hThreeBoard);
		
		hThree = new TextAreaHoverButton(380, 700, 30, 30, "3",null, hint, hint1,hintB,null);
		hThree.setCurve(0, 0);
		viewObjects.add(hThree);

		Graphic h3Border = new Graphic(380, 700, 30, 30, "images/grid.png");
		viewObjects.add(h3Border);
		//
		
		
		
		Button test = new Button(0,0,50,50,"tesr", new Action() {

			@Override
			public void act() {
				setUpGrid();
				
			}
			
		});
		viewObjects.add(test);
		
		
		
		
		//keyDesc = new TextColoredLabel(500, 100, 600, 300, "White KeyPad Buttons", null, Color.red);
		//viewObjects.add(keyDesc);
		
		//blackedOut = new TextColoredLabel(500, 100, 600, 300, "BLACK KeyPad Buttons", null, Color.red);
		//viewObjects.add(blackedOut);

		// hOne= new Button

		// Test.setBaseFont(f);
		
		
		
		//getMousePosition();
		
		startTimer();
		
		//createKeyPadButtons();
		// keyPadButtonsAction();
		
		
		setUpGrid();
		
		addNecessaryButtons();
		hoverStatus(true);
	}

	public void hoverStatus(boolean b) {
		timer.setEnabled(b);
		hin.setEnabled(b);
		for (int i = 0; i < numberButtons.length; i++) {
			numberButtons[i].setEnabled(b);
		}
		for (int i = 0; i < gB.length; i++) {
			gB[i].setEnabled(b);
		}
		hOne.setEnabled(b);
		hTwo.setEnabled(b);
		hThree.setEnabled(b);
	}

	public void addNecessaryButtons() {
		
		tB = new Graphic(500,0,300,300,"images/transBlack.png");
		viewObjects.add(tB);
		tB.preserveRatio = false;
		tB.resize(400, 500);
		tB.setVisible(false);
		
		Graphic skipp = new Graphic(1000, 25, 700, 700, "images/mSBoard.jpg");
		skipp.preserveRatio = false;
		skipp.resize(150, 60);
		
		
		
		
		
		viewObjects.add(skipp);
		
		skip = new Button(1000, 25, 150, 60, "Skip", new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new VickieHPFrontEnd(getWidth(), getHeight()));

			}

		});
		try {
			File fontFile = new File("images/HARRYP.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

			Font baseFont = font.deriveFont(150f);
			Font a = font.deriveFont(55f);
			Font c = font.deriveFont(38f); // 30 /40
			Font b = font.deriveFont(38f);

			Font question = font.deriveFont(70f);

			Font hB = font.deriveFont(25f);
			
			skip.setFont(b);
		} catch (Exception e) {

			e.printStackTrace();

		}
		viewObjects.add(skip);
		

		story = new Button(500, 50, 100, 100, "Story", Color.blue, new Action() {

			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new SirCadoganTheMadKnight(getWidth(), getHeight()));

			}

		});

		viewObjects.add(story);
		
		t = new TextAreaColor(600, 600, 100, 100, "IT WORKDDDDDDDDD", trans, null ); //attach image behind it
		viewObjects.add(t);
		t.setVisible(false);
		
		/* tB = new Graphic(500,0,300,300,"images/transBlack.png");
		viewObjects.add(tB);
		tB.preserveRatio = false;
		tB.resize(400, 500);*/
		
		//g = new TextColoredLabel(500, 100, 600, 300, "dfwerwerwesderwefs fgdfgsdfhd", null, Color.red);
		//viewObjects.add(g);
		
		//TextAreaHoverButton te = new TextAreaHoverButton(200,200,500,500,"dfgsfgdfg", trans,g, tB, null) ;
		//viewObjects.add(te);
		
		TextColoredLabel tim = new TextColoredLabel(500, 100, 600, 100, "The Timer", null, Color.red);////525, 333, 600, 100,
		viewObjects.add(tim);//. You have five minutes to complete the puzzle.
		tim.setVisible(false);
		
		TextColoredLabel tim1 = new TextColoredLabel(500, 200, 600, 200, "You have five minutes to complete the puzzle", null, Color.blue);
		viewObjects.add(tim1);//. You have five minutes to complete the puzzle.
		tim1.setVisible(false);
		
		 timer = new TextAreaHoverButton(50, 50, 320, 150,"", null ,tim, tim1,tB, null) ;
		viewObjects.add(timer);
		
		TextColoredLabel hi = new TextColoredLabel(500, 100, 600, 100, "Hint Box", null, Color.red);////525, 333, 600, 100,
		viewObjects.add(hi);//. You have five minutes to complete the puzzle.
		hi.setVisible(false);
		
		TextColoredLabel hi1 = new TextColoredLabel(500, 200, 600, 200, "Hints will appear here as timer counts down", null, Color.blue);
		viewObjects.add(hi1);//. You have five minutes to complete the puzzle.
		hi1.setVisible(false);
		
		 hin = new TextAreaHoverButton(50, 600, 320, 150,"", null ,hi, hi1,tB, null) ;
		viewObjects.add(hin);

		//
		gG = new Graphic(500,0,300,300,"images/transBlack.png");
		viewObjects.add(gG);
		gG.setVisible(false);
		
		gG1 = new Graphic(500,0,300,300,"images/transBlack.png");
		viewObjects.add(gG1);
		gG1.setVisible(false);
		
		
		TextColoredLabel gT = new TextColoredLabel(25, 125, 410, 100, "Grid Piece", null, Color.red);////525, 333, 600, 100,
		viewObjects.add(gT);//. You have five minutes to complete the puzzle.
		gT.setVisible(false);
		
		TextColoredLabel gT1 = new TextColoredLabel(25, 225, 410, 400, "First select a number, then click on this piece to put it there", null, Color.blue);
		viewObjects.add(gT1);//. You have five minutes to complete the puzzle.
		gT1.setVisible(false);
		
		TextColoredLabel dG = new TextColoredLabel(25, 125, 410, 100, "Given Number", null, Color.red);////525, 333, 600, 100,
		viewObjects.add(dG);//. You have five minutes to complete the puzzle.
		dG.setVisible(false);
		
		TextColoredLabel dG1 = new TextColoredLabel(25, 225, 410, 200, "Fixed number and cannot be changed", null, Color.blue);
		viewObjects.add(dG1);//. You have five minutes to complete the puzzle.
		dG1.setVisible(false);
		
		TextColoredLabel dG2 = new TextColoredLabel(25, 425, 410, 400, "** Does not mean "+initNumBackEnd+" will always be in this position", null, Color.blue);
		viewObjects.add(dG2);
		dG2.setVisible(false);
		//GRID BUTTONS:
		for (int i = 0; i < gB.length; i++) {
		

			
				if(i!=5) {
				gB[i].setTextLabel(gT,gT1, null);
				gB[i].setGraphic(gG);
				//viewObjects.add(gB[i]);
				// System.out.println("Coords:(" + r + "," + c + ")");
				// System.out.println(gB[i].getCoord());
				}else {
					gB[i].setTextLabel(dG,dG1, dG2);
					gB[i].setGraphic(gG1);
				}
		}
		
	}

	public Point getMousePosition() {
		Timer timer = new Timer();
		TimerTask task;
		task = new TimerTask() {
			@Override
			public void run() { 
				/*if (gameRunning) {
					a = MouseInfo.getPointerInfo();
					b = a.getLocation();
					mouseX = (int) b.getX();
					mouseY = (int) b.getY();
					System.out.println(mouseX + ", " + mouseY);
					
				} else {
					cancel();
				}*/
				a = MouseInfo.getPointerInfo();
				b = a.getLocation();
				mouseX = (int) b.getX();
				mouseY = (int) b.getY();
				System.out.println(mouseX + ", " + mouseY);
			}
		};
		timer.schedule(task, 0, 100);
		return b;
	}

	public void createKeyPadButtons() {
		numberButtons = new TextAreaHoverButton[9];
		Graphic kP = new Graphic(500, 0, 300, 300, "images/transBlack.png");
		viewObjects.add(kP);
		kP.preserveRatio = false;
		kP.resize(400, 500);
		kP.setVisible(false);
		
		keyDesc = new TextColoredLabel(500, 100, 600, 100, "White KeyPad Button", null, Color.red);
		viewObjects.add(keyDesc);
		keyDesc.setVisible(false);
		keyDesc1 = new TextColoredLabel(500, 200, 600, 300, "Choose a number, then click on one of the grid pieces to put your selection there", null, Color.blue);
		viewObjects.add(keyDesc1);
		keyDesc1.setVisible(false);
		keyDesc2 = new TextColoredLabel(500, 500, 600, 100, "Your selection will be highlighted", null, Color.blue);
		viewObjects.add(keyDesc2);
		keyDesc2.setVisible(false);

		blackedOut = new TextColoredLabel(500, 100, 600, 100, "Black KeyPad Button", null, Color.red);
		blackedOut1 = new TextColoredLabel(500, 200, 600, 300, "This number is given to you on the grid, so this button cannot be selected", null, Color.blue);
		//This number is given to you on the grid, so this button cannot be selected
		viewObjects.add(blackedOut1);
		viewObjects.add(blackedOut);
		blackedOut.setVisible(false);
		blackedOut1.setVisible(false);

		for (int i = 0; i < numberButtons.length; i++) {
			if (i == 0 || i < 3) {
				numberButtons[i] = new TextAreaHoverButton(50 + 110 * i, 250, 100, 100, i + 1 + "", trans,keyDesc, keyDesc1,keyDesc2,kP, null);
				viewObjects.add(numberButtons[i]);
			} else if (i == 3 || i < 6) {
				numberButtons[i] = new TextAreaHoverButton(50 + 110 * (i - 3), 360, 100, 100, i + 1 + "", trans,keyDesc,keyDesc1,keyDesc2, kP, null);
				viewObjects.add(numberButtons[i]);
			} else if (i == 6 || i < 9) {
				numberButtons[i] = new TextAreaHoverButton(50 + 110 * (i - 6), 470, 100, 100, i + 1 + "", trans, keyDesc,keyDesc1,keyDesc2, kP,null);
				viewObjects.add(numberButtons[i]);
			}
		}
		

		numberButtons[0].setAction(new Action() {
			public void act() {
				System.out.println("this shit works");
				TextArea t = new TextArea(0,0,500,500,"UIHUIHIIU");
				viewObjects.add(t);
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
		//counter.setText("" + count);

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
		
		//TextColoredLabel gridN = new TextColoredLabel(50, 50, 600, 300, "G KeyPad Buttons", null, Color.red);
		//viewObjects.add(gridN);
		
		gB = new TextAreaHoverButton[9];
		// System.out.println("createGridButtons()");
	

		for (int i = 0; i < gB.length; i++) {
		

			// System.out.println("Coords:(" + r + "," + c + ")");
			if (i == 0 || i < 3) {
				c = c + 1;
				gB[i] = new TextAreaHoverButton(500 + 202 * i, 100, 195, 195, "", trans,null, tB, null);
				viewObjects.add(gB[i]);
				// System.out.println("Coords:(" + r + "," + c + ")");
				// System.out.println(gB[i].getCoord());
				// System.out.println("Gi = " + i);
				if (i == 2) {
					c = -1;
				}
			} else if (i == 3 || i < 6) {
				
				gB[i] = new TextAreaHoverButton(500 + 202 * (i - 3), 302, 195, 195, "",trans,null, tB, null);
				viewObjects.add(gB[i]);
				// System.out.println("Coords:(" + r + "," + c);
				// System.out.println(gB[i].getCoord());
				// System.out.println("Gi = " + i);
				if (i == 5) {
					c = -1;
				}
			} else if (i == 6 || i < 9) {
				
				gB[i] = new TextAreaHoverButton(500 + 202 * (i - 6), 505, 195, 195, "", trans,null, tB, null);
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
						//while(txtAreas[i].getX() != 580 + 203 * i || txtAreas[i].getY() != 150) {
						txtAreas[i].move(580 + 203 * i, 150, 100);
						//System.out.print("loop");
					//	}
						System.out.print(txtAreas[i].getX());
						System.out.print(txtAreas[i].getY());
						//txtAreas[i].setVisible(true);
						//viewObjects.add(txtAreas[i]);
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
		if(initNumBackEnd == 5) {
			backend.chooseStartingPoint();
			initNumBackEnd = backend.getInitiateNum();
		}
		 System.out.println("Initial num from backend = " +backend.getInitiateNum()+ initNumBackEnd);
		// stores initial coordinate from backend
		int r = backend.getRowNum();
		int c = backend.getColNum();
		if(r ==1 && c==1) {
			backend.chooseStartingPoint();
			initNumBackEnd = backend.getInitiateNum();
			 r = backend.getRowNum();
			 c = backend.getColNum();
		}
		String p = r + "," + c;
		// compares initial coordinate with every button coordinate
		//for (int i = 0; i < gB.length; i++) {
			// System.out.println("String p = gB[i].getCoord();" + p);
			//String h = gB[5].getCoord();
			// System.out.println("String h = gB[i].getCoord();" + h);
			// if coordinates are a match, set num to the middle of button and make action
			// null
			//if (p.equals(h)) {
				// System.out.println("THE SAME COORDINATES!!()");
				gB[5].setAction(null);
				//gB[5].setTextLabel(gridB, null,null);
				txtAreas[5].setText("" + initNumBackEnd);
				
				
				
			createKeyPadButtons();

				Color maroon = new Color(182, 47, 32);
				txtAreas[5].setForeground(maroon); // maroon color
				txtAreas[5].move(560 + (203 * (5 - 3)), 308, 100);
				/*if (i == 0 || i < 3) {
					//txtAreas[i].setX(560 + (203 * i));
					//txtAreas[i].setY(100);
					txtAreas[i].move(560 + (203 * i), 105, 100);
				} else if (i == 3 || i < 6) {
					txtAreas[i].move(560 + (203 * (i - 3)), 308, 100);// y+203
				} else if (i == 6 || i < 9) {
					txtAreas[i].move(560 + 203 * (i - 6), 511, 100);
				}*/
				font();
			//}
		//}
		
		// disable number keypad buttons too
		for (int i = 0; i < numberButtons.length; i++) {
			int o = Integer.parseInt(numberButtons[i].getText());
			if (o == initNumBackEnd) {
				numberButtons[i].setTextLabel(blackedOut, blackedOut1, null);
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
			
			
			
			hintBox.setFont(b);//b

			hOne.setFont(hB);
			hTwo.setFont(hB);
			hThree.setFont(hB);
			//skip.setFont(b);
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	

	public Color newColorWithAlpha(Color original, int alpha) {
		// System.out.println("newColorAlpha()");
		return new Color(original.getRed(), original.getGreen(), original.getBlue(), alpha);
	}

	public void setValues(int row, int col) {
		
	}

	public void check() {
		
	}

	public void changeImages() {

	}

	public void startTimer() {
		
	}

	public void hints(int num) {
	}
}


