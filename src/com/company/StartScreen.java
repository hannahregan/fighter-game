package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import static org.newdawn.slick.Input.KEY_ENTER;

public class StartScreen extends BasicGameState {

    public Image backgroundStart, logoStart, startBtn, quitBtn, optionsBtn;

    public StartScreen(int gameState) {

    }


    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        //setup

        //background and logo
        backgroundStart = new Image("res/startScreen/backgroundstart.png");
        logoStart = new Image("res/startScreen/logostart.png");

        //buttons
        startBtn = new Image("res/startScreen/startbtn.png");
        quitBtn = new Image("res/startScreen/quitbtn.png");
        optionsBtn = new Image("res/startScreen/optionsbtn.png");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        //draw//images 580 wide (buttons) screen(880, 600)

        //drawring images
        backgroundStart.draw(0,0);

        logoStart.draw(150, 60);

        startBtn.draw(150, 260);
        optionsBtn.draw(150, 360);
        quitBtn.draw(150, 460);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        //stuff happends
        Input input = gc.getInput();
        int xpos = input.getMouseX();
        int ypos = input.getMouseY();
        //now we check if it is clicked
        if(input.isMouseButtonDown(0)){
            //left mouse button

            //now check if within each button bounds
            if(xpos > 150 && xpos < 730 && ypos > 260 && ypos < 330){
                //start
                sbg.enterState(1);
            }

            if(xpos > 150 && xpos < 730 && ypos > 360 && ypos < 430){
                //options
                System.out.println("Not implemeented");
            }

            if(xpos > 150 && xpos < 730 && ypos > 460 && ypos < 530){
                //quit
                gc.exit();
            }
        }


    }
}
