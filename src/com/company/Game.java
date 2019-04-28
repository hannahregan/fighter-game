package com.company;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.awt.Dimension;
import java.awt.Toolkit;
import org.newdawn.slick.AppGameContainer;



public class Game extends BasicGame
{
    private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public Game()
    {
        super("Game");
    }

    public static void main(String[] arguments)
    {
        try
        {
            AppGameContainer app = new AppGameContainer(new Game());
            // app.setDisplayMode(screenSize.width, screenSize.height, true); => Full screen
            app.setDisplayMode(640, 480, false);
            app.setShowFPS(false); // true for display the numbers of FPS
            app.setVSync(true); // false for disable the FPS synchronize
            app.start();
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

    public void init(GameContainer container) throws SlickException
    {

    }

    public void update(GameContainer container, int delta) throws SlickException
    {

    }

    public void render(GameContainer container, Graphics g) throws SlickException
    {

    }
}
