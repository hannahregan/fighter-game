package testing;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class TestMenus extends StateBasedGame{

	public static final String gamename = "ACID LABS";
	public static final int menu = 0;
	public static final int play = 1;
	public static final int gameover = 2;
	
	public TestMenus(String gamename) {
		super(gamename);
		// TODO Auto-generated constructor stub
		this.addState(new Menu(menu));
		this.addState(new GameTest(play));
		this.addState(new GameOver(gameover));
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/");
		try {
			appgc = new AppGameContainer(new TestMenus(gamename));
			appgc.setDisplayMode(880, 600, false);
			appgc.start();
		}catch(SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(play).init(gc, this);
		this.getState(gameover).init(gc, this);
		this.enterState(menu);
	}

}
