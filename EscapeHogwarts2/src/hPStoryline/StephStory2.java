package hPStoryline;

import java.awt.Color;
import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.components.TextArea;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class StephStory2 extends FullFunctionScreen {

	private Graphic background;
	private Graphic chatbox;
	private Graphic switchImg;
	private TextArea narrator;
	private TextArea name;
	private TextArea dialogue;
	private ClickableGraphic nextB;
	private ClickableGraphic prevB; 
	private Button choice1; 
	private Button choice2; 
	private int clicks;
	private String[] quotes = {"Where are you going Harry? Class is the other way.","Lets just leave him, "
			+ "Mcgonagall will kill us if we're late.","...","Potter! Weasley! Granger! Why are you late to my class again?!",
			"We got lost.", "Moving on, today's lesson will be about potions, gather your things and follow me.", "Choose a partner and we'll begin."};
	private String[] matchName = {"Hermione","Ron", "Harry","Mcgonagall", "Hermione", "Mcgonagall", "Mcgonagall"};
	private String[] imagesList = {"simg/emma.png", "simg/ron.jpg", "simg/harry.jpg"};
	private String[] bgList = {"simg/classroom.jpg", "simg/class.jpg", "simg/class2.jpg", "simg/teaching.jpg"};
	
	public StephStory2(int width, int height) {
		super(width, height);
		clicks = 0;
		name.setSize(40);
		dialogue.setSize(35);
		dialogue.setForeground(Color.WHITE);
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		background = new Graphic(0, 0, getWidth(), getHeight(), "simg/background.jpg");
		viewObjects.add(background);
		
		chatbox = new Graphic(80,80,1200,700, "simg/textbox.png");
		viewObjects.add(chatbox);
		
		nextB = new ClickableGraphic(1100, 700, 50, 50, "simg/symbol.png");
		nextB.setAction(new Action() {
			
			@Override
			public void act() {
				clicks++;
				storyline();
			}
		});
		viewObjects.add(nextB);
		
		prevB = new ClickableGraphic(65, 700, 50, 50, "simg/symbol.png");
		prevB.setAction(new Action() {
			
			@Override
			public void act() {
				clicks--;
				storyline();
			}
		});
		viewObjects.add(prevB);
		
		switchImg = new Graphic(700,260,400,400,"simg/emma.png");
		viewObjects.add(switchImg);
		
		name = new TextArea(220,530,200,200,"Hermione");
		viewObjects.add(name);
		
		dialogue = new TextArea(180,590,1000,500,"Where are you going Harry? Class is the other way.");
		viewObjects.add(dialogue);
		
		choice1 = new Button(200, 600, 100, 50, "Hermione", Color.darkGray, new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
		
		choice2 = new Button(800, 600, 100, 50, "Ron", Color.darkGray, new Action() {
			
			@Override
			public void act() {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	public void storyline() {
		String r = quotes[clicks];
		dialogue.setText(r);
		dialogue.update();
		String f = matchName[clicks];
		name.setText(f);
		name.update();	
		if(clicks == 3) {
			switchImg.setVisible(false);
			background.loadImages("simg/classroom.jpg", 1200, 800);		
		}
		if(clicks == 4) {
			switchImg.setVisible(false);
			background.loadImages("simg/class.jpg", 1200, 800);		
		}
		if(clicks == 5) {
			switchImg.setVisible(false);
			background.loadImages("simg/classroom.jpg", 1200, 800);		
		}
		if(clicks > 5) {
			switchImg.setVisible(false);
			background.loadImages("simg/teaching.jpg", 1200, 800);		
		}
	}
}
