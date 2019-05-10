package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;

public class GameScreen extends BasicGameState {

    public Player player;
    public Image playerImg;

    //placeholder
    public Rectangle ground;

    public GameScreen(int gameState){

    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        player = new Player("0");
        playerImg = new Image("/res/gameScreen/playerself.png");

        //placeholder for ground
        ground = new Rectangle(0, 540, 880,40);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        playerImg.draw(player.getXpos(), player.getYpos());
        g.drawRect(player.getPunchHitBox().x, player.getPunchHitBox().y, (float)player.getPunchHitBox().getWidth(), (float)player.getPunchHitBox().getHeight());
        g.drawRect(player.getBlockHitBox().x, player.getBlockHitBox().y, (float)player.getBlockHitBox().getWidth(), (float)player.getBlockHitBox().getHeight());
        g.drawRect(player.getKickHitBox().x, player.getKickHitBox().y, (float)player.getKickHitBox().getWidth(), (float)player.getKickHitBox().getWidth());
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        //getting the input from the keyboard
        Input input = gc.getInput();

        //moving the player
        if(input.isKeyDown(input.KEY_LEFT)) {
            player.move_left(delta);
        }else if(input.isKeyDown(input.KEY_RIGHT)){
            player.move_right(delta);
        }

        //makes the player jump
        if(input.isKeyPressed(input.KEY_UP) && player.getOnground()){
            player.jump(delta);
        }

        //punch
        if(input.isKeyPressed(input.KEY_Q)){
            if(player.getBlocking() == false && player.getKicking() == false) {
                player.punch();
            }
        }

        //block
        if(input.isKeyDown(input.KEY_W)){
            if(player.getPunching() == false && player.getKicking() == false) {
                player.block();
            }
        }else{
            player.setBlocking(false);
        }

        //kick
        if(input.isKeyPressed(input.KEY_E)){
            if(player.getBlocking() == false && player.getPunching() == false){
                //now we can kick
                player.kick();
            }
        }

        //gravity
        if(player.getJumping() == false && player.getPlayerHitBox().intersects(ground) == false){
            player.fall(delta);
            player.setOnground(false);
        }else{
            player.setOnground(true);
        }



        //updating player
        player.update(delta);
    }
}
