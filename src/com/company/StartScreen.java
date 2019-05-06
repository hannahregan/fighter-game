package com.company;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static org.newdawn.slick.Input.KEY_ENTER;

public class StartScreen extends BasicGameState {

    public Circle circle;

    public StartScreen(int gameState) {

    }


    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //setup
        circle = new Circle(100, 100, 50);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //draw
        g.draw(circle);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        //stuff happends
        Input input = gc.getInput();
        if(input.isKeyPressed(input.KEY_ENTER)){
            sbg.enterState(1);
        }
    }
}
