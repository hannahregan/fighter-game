package com.company;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame {

    public static final int startScreen = 0;
    public static final int charSelectScreen = 1;
    public static final int gameScreen = 2;
    public static final int pauseMenuScreen = 3;
    public static final int gameOverScreen = 4;

    public Main(String name) {
        super(name);
        this.addState(new StartScreen(startScreen));
        this.addState(new CharSelectScreen(charSelectScreen));
        this.addState(new GameScreen(gameScreen));
        this.addState(new PauseMenuScreen(pauseMenuScreen));
        this.addState(new GameOverScreen(gameOverScreen));
    }

    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/");
        try {
            AppGameContainer app = new AppGameContainer(new Main("GAME"));
            app.setDisplayMode(880, 600, false);
            app.start();
        }catch (SlickException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(startScreen).init(gc, this);
        this.getState(charSelectScreen).init(gc, this);
        this.getState(gameScreen).init(gc, this);
        this.getState(pauseMenuScreen).init(gc, this);
        this.getState(gameOverScreen).init(gc, this);
        this.enterState(gameScreen);
    }
}
