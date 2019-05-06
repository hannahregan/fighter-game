package testing;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class GameTest extends BasicGameState{
	
	private Image background, playerLeft, playerRight, player, enemySpr, bottom, angryFlash1;
	private Image no10, no9, no8, no7, no6, no5, no4, no3, no2, no1;
	
	private Sound backGmusic;
	private int x = 300;
	private int y = 300;
	private int hasJumped, flashTimer = 0;
	private Shape playerHb, bottomHb, screenBoxLeft, screenBoxRight;
	private Circle cirle;
	private int score = 9;
	
	private ArrayList<Enemy> enemies;
	private ArrayList<Image> scoreCd;
	
	Random random = new Random();

	public GameTest(int play) {
		// TODO Auto-generated constructor st
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		score = 9;
		    	enemies = new ArrayList<Enemy>();
		    	enemies.add(new Enemy());
		    	enemies.add(new Enemy());
		    	enemies.add(new Enemy());
		    	
		    	
		    	
		    	playerHb = new Rectangle(x, y, 150 , 150);
		    	bottomHb = new Rectangle(0, 550, 880, 50);
		    	screenBoxLeft = new Rectangle(0, 0, -10, 600);
		    	screenBoxRight = new Rectangle(800, 0, 10, 600);
		    	
		    	background = new Image("res/test/background.png");
		    	bottom = new Image("res/test/bottom.png");
		    	playerLeft = new Image("res/test/playerleft.png");
		    	playerRight = new Image("res/test/playerright.png");
		    	player = new Image("res/test/playerright.png");
		    	enemySpr = new Image("res/test/enemy.png");
		    	angryFlash1 = new Image("res/test/angryflash1.png");
		    	
		    	no10 = new Image("res/test/no10.png");
		    	no9 = new Image("res/test/no9.png");
		    	no8 = new Image("res/test/no8.png");
		    	no7 = new Image("res/test/no7.png");
		    	no6 = new Image("res/test/no6.png");
		    	no5 = new Image("res/test/no5.png");
		    	no4 = new Image("res/test/no4.png");
		    	no3 = new Image("res/test/no3.png");
		    	no2 = new Image("res/test/no2.png");
		    	no1 = new Image("res/test/no1.png");
		    	
		    	scoreCd = new ArrayList<Image>(Arrays.asList(no1, no2, no3, no4, no5, no6, no7, no8, no9, no10));
		    	
		    	
		    	backGmusic = new Sound("res/test/backgmusic.wav");
		    	backGmusic.loop();
		    	//got music an images loaded
		
		
	}

	@Override
	public void leave(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
		score = 9;
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		// TODO Auto-generated method stub
		background.draw(0, 0);
    	if(flashTimer < 300) {
    		angryFlash1.draw();
    		
    	}else {
    		scoreCd.get(score).draw(0, 0);
    	}
    	
    	
    	player.draw(x, y);
    	for(Enemy enemy : enemies){
    		enemySpr.draw(enemy.getX(), enemy.getY());
    		
    	}
    	bottom.draw(0, 550);
		
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
    	
		if(score <= 0) {
			sbg.enterState(2);
		}
		
    	if(flashTimer == 0) {
    		flashTimer = 600;
    	}else {
    		flashTimer -= 1;
    	}
    	
    	
    	
    //handles player
    	Input input = container.getInput();
    	if(input.isKeyDown(Input.KEY_UP)) {
    		if(hasJumped == 0 && playerHb.intersects(bottomHb)) {
    			hasJumped = 300;
    		}
    	}
    	if(input.isKeyDown(Input.KEY_LEFT)) {
    		player = playerLeft;
    		x -= delta;
    	}else if(input.isKeyDown(Input.KEY_RIGHT)) {
    		player = playerRight;
        	x += delta;
    		
    	}
    	playerHb.setLocation(x, y);
    	// makes sure not off screen
    	if(playerHb.intersects(screenBoxRight)) {
    		x -= delta;
		}else if(playerHb.intersects(screenBoxLeft)) {
			x += delta;
		}
    	//handles enemy
    	for(Enemy enemy : enemies) {
    		int currY = enemy.getY();
    		if(enemy.rect.intersects(bottomHb) && enemy.bounce >= 0 && enemy.bounceCount == 0) {
    		enemy.bounceCount = 300;
    		enemy.bounce -= 1;
    		enemy.setY(currY -= delta);
    		}else if(enemy.bounceCount > 0) {
    			enemy.setY(currY -= delta);
    			enemy.bounceCount -= 1;
    		}else {
    			enemy.setY(currY +=delta);
    		}
    		if(currY > 750) {
    			enemy.setY(random.nextInt(300)-550);
    			enemy.setX(random.nextInt(780));
    			enemy.hasKilled = false;
    			enemy.bounce = random.nextInt(3);
    		}
    		enemy.rect.setLocation(enemy.getX() - 50, enemy.getY() - 50);
    		if(playerHb.intersects(enemy.rect)) {
    			System.out.println("Lose Points");
    			if(score != 0 && enemy.hasKilled == false) {
    				score -= 1;
    				enemy.hasKilled = true;
    			}
    		}	
    	}
    	
    	
    	
    	
    	if(hasJumped > 0) {
    		y -= delta;
    		hasJumped -= 1;
    	}else if(playerHb.intersects(bottomHb) == false) {
    		y += delta;
    	}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
}
