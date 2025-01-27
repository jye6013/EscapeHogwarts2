package hpKevStoryLine;

/*
 * There is an issue regarding the disabling of certain ClickableGraphics and the matching of said ClickableGraphics have not been implemented
 * due to a confusion of arrays
 * 
 * You may have to click a card several times to flip it over due to not calculating previously flipped cards into the random int generator
 * 
 * Two cards will always be unable to flip over
 * 
 * Click the top right corner of the screen to continue on
 * 
 */

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import hPStartGame.GuiLoadingVickie;

public class DKKissGame extends FullFunctionScreen{

	private Graphic backgroundImg;
	private ClickableGraphic[] cardArray;
	private int[] numList;
	private String[] cardList;
	private Boolean[] flipList;
	
	private int[] count;
	
	private Button next;
	
	public DKKissGame(int width, int height) {
		super(width, height);
		
		next.setSize(40);
	}

	
	public void initAllObjects(List<Visible> viewObjects) {
		cardArray = new ClickableGraphic[12];
		numList = new int[6];
		cardList = new String[6];
		flipList = new Boolean[12];
		
		backgroundImg = new Graphic(0, 0, getWidth(), getHeight(), "kimg/memoryReel.png");
		viewObjects.add(backgroundImg);
		
		next = new Button(1100, 10, 100, 100, "Pass", new Action() {
			
			@Override
			public void act() {
				GuiLoadingVickie.loading.setScreen(new DKWinGame(getWidth(), getHeight()));
				
			}
		});
		viewObjects.add(next);
		
		for (int j = 0; j < flipList.length; j++) {
			flipList[j] = false;
		}
		
		cardList[0] = "kimg/cardHarry.jpg";
		cardList[1] = "kimg/cardHermione.jpg";
		cardList[2] = "kimg/cardRon.jpg";
		cardList[3] = "kimg/cardPatronus.png";
		cardList[4] = "kimg/cardRemus.jpg";
		cardList[5] = "kimg/cardVoldemort.png";
		
		for (int n = 0; n < numList.length; n++) {
			numList[n] = 0;
		}
		
		for (int i = 0; i < cardArray.length; i++) {
			cardArray[i] = new ClickableGraphic((50 + (i%6)*180),(75 + (i/6)*350), 150, 300, "kimg/cardBack.png");
			viewObjects.add(cardArray[i]);
		}
		
		cardArray[0].setAction(new Action() {
			
			@Override
			public void act() {

				flipCard(cardArray[0]);
				
				
			}
		});
		cardArray[1].setAction(new Action() {
			
			@Override
			public void act() {

				flipCard(cardArray[1]);
				
				
			}
		});
		cardArray[2].setAction(new Action() {
	
			@Override
			public void act() {

				flipCard(cardArray[2]);
				
			
			}
		});
		cardArray[3].setAction(new Action() {
	
			@Override
			public void act() {

				flipCard(cardArray[3]);
				
		
			}
		});
		cardArray[4].setAction(new Action() {
	
			@Override
			public void act() {

				flipCard(cardArray[4]);
				
		
			}
		});
		cardArray[5].setAction(new Action() {
	
			@Override
			public void act() {

				flipCard(cardArray[5]);
				
		
			}
		});
		cardArray[6].setAction(new Action() {
	
			@Override
			public void act() {

				flipCard(cardArray[6]);
				
		
			}
		});
		cardArray[7].setAction(new Action() {
	
			@Override
			public void act() {

				flipCard(cardArray[7]);
				
		
			}
		});
		cardArray[8].setAction(new Action() {
	
			@Override
			public void act() {

				flipCard(cardArray[8]);
				
		
			}
		});
		cardArray[9].setAction(new Action() {
	
			@Override
			public void act() {

				flipCard(cardArray[9]);
				
		
			}
		});
		cardArray[10].setAction(new Action() {
	
			@Override
			public void act() {

				flipCard(cardArray[10]);
				
		
			}
		});
		cardArray[11].setAction(new Action() {
			
			@Override
			public void act() {

				flipCard(cardArray[11]);
				
		
			}
		});
	
	}
	
	public void flipCard(ClickableGraphic cg) {
		int num = (int)(Math.random()*13);
		int temp = num;
		
		if(num == 12 ) {
			temp = num - 6;
		}else if(num > 6) {
			temp = num - 5;
		}
		
		for(int i = 0; i < numList.length; i++) {
			
			if(i == temp && numList[i] < 2) {
				flipList[i] = true;
				numList[i]++;
				cg.loadImages(cardList[i], 150, 300);
				checkPair(flipList);
					
			}
			
			
			if(flipList[num] == true) {
				cardArray[num].setAction(null);
			}
		}
		
		
	}
	
	
	public void checkPair(Boolean[] fList) {
		for (int i = 0; i < fList.length; i++) {
			if (fList[i] == true) {
				for(int n = (i+1); n < fList.length; n++) {
					if(fList[i] == fList[n]) {
						if(compareValues(cardList[i], cardList[n]) == false) {
							fList[i] = false;
							fList[n] = false;
							
							numList[i]--;
							numList[n]--;
						}
					}
				}
			}
		}
	}
	

	
	public boolean compareValues(String card1, String card2) {
		if (card1.equals(card2) != true){
			return false;
		}
		
		return true;
	}
	
	
}
