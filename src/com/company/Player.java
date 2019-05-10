package com.company;

import java.awt.*;

public class Player {
    //the player played by the person using this client
    public int xpos, ypos, jumpTimer, health, abilityTimer, punchTimer, kickTimer;
    public Rectangle playerHitBox, punchHitBox, blockHitBox, kickHitBox;
    public Boolean jumping, onground, punching, faceLeft, blocking, kicking;

    public Player(String type) {
        //positionss
        this.xpos = 100;
        this.ypos = 100;

        //timers
        this.jumpTimer = 0;
        this.punchTimer = 0;
        this.kickTimer = 0;

        //jumping shite
        this.setFaceLeft(false);
        this.setPunching(false);
        this.setOnground(false);
        this.setJumping(false);
        this.setBlocking(false);
        this.setKicking(false);

        //hitboxes
        playerHitBox = new Rectangle(this.xpos, this.ypos, 70, 100);
        punchHitBox = new Rectangle(this.xpos, this.ypos, 0, 0);
        blockHitBox = new Rectangle(this.xpos, this.ypos, 0, 0);
        kickHitBox = new Rectangle(this.xpos, this.ypos, 0, 0);

        //health ect
        this.health = 100;
        this.abilityTimer = 50; //halfway

        //type passed from select player screen
        switch (type) {
            case "1":
                //statements
                break;
            case "2":
                //statements
                break;
            case "3":

                break;
            case "4":

                break;
            case "5":

                break;
            case "6":

                break;
            default:
                break;

        }
        //switch ends

    }

    public void update(int delta) {
        //keeps the hitbox at the player && may soon do other stuff
        playerHitBox.setLocation(this.xpos, this.ypos);

        //jumping
        if (this.jumpTimer > 0) {
            this.ypos -= delta;
            this.setOnground(false);
            this.jumpTimer -= 1;
        } else if (this.jumpTimer == 0) {
            this.setJumping(false);
        }

        if (this.getPunchTimer() > 50) {
            //punching out
            ///CANT PUNCH LEFT
            if (this.getFaceLeft()) {
                punchHitBox.setBounds((int) (this.xpos - (punchHitBox.getWidth() + 1)), this.ypos + 50, (int) (punchHitBox.getWidth() + 1), 10);
            } else {
                punchHitBox.setBounds(this.xpos + 70, this.ypos + 50, (int) punchHitBox.getWidth() + 1, 10);
            }
            this.setPunchTimer(this.getPunchTimer() - 1);
        } else if (this.getPunchTimer() > 1) {
            //punching in
            if (this.getFaceLeft()) {
                punchHitBox.setBounds((int) (this.xpos - (punchHitBox.getWidth() - 1)), this.ypos + 50, (int) (punchHitBox.getWidth() - 1), 10);
            } else {
                punchHitBox.setBounds(this.xpos + 70, this.ypos + 50, (int) punchHitBox.getWidth() - 1, 10);
            }
            this.setPunchTimer(this.getPunchTimer() - 1);
        } else {
            this.setPunching(false);
            punchHitBox.setBounds(this.xpos, this.ypos, 0, 0);
        }

        //blocking
        if(this.getBlocking()){
            if(this.getFaceLeft()){
                blockHitBox.setBounds(this.xpos - 10, this.ypos, 10, 50);
            }else {
                blockHitBox.setBounds(this.xpos + 70, this.ypos, 10, 50);
            }
        }else{
            blockHitBox.setBounds(this.xpos, this.ypos, 0, 0);
        }

        //kicking (HB like punch i guess)
        if (this.getKickTimer() > 35) {
            //kicking out
            if (this.getFaceLeft()) {
                kickHitBox.setBounds((int) (this.xpos - (kickHitBox.getWidth() + 1)), this.ypos + 70, (int) (kickHitBox.getWidth() + 1), 20);
            } else {
                kickHitBox.setBounds(this.xpos + 70, this.ypos + 70, (int) kickHitBox.getWidth() + 1, 20);
            }
            this.setKickTimer(this.getKickTimer() - 1);
        } else if (this.getKickTimer() > 1) {
            //kicking in
            if (this.getFaceLeft()) {
                kickHitBox.setBounds((int) (this.xpos - (kickHitBox.getWidth() - 1)), this.ypos + 70, (int) (kickHitBox.getWidth() - 1), 20);
            } else {
                kickHitBox.setBounds(this.xpos + 70, this.ypos + 70, (int) kickHitBox.getWidth() - 1, 20);
            }
            this.setKickTimer(this.getPunchTimer() - 1);
        } else {
            this.setKicking(false);
            kickHitBox.setBounds(this.xpos, this.ypos, 0, 0);
        }

    }

    public int jump(int delta) {
        this.setJumping(true);
        //returns jumping timers
        this.jumpTimer = 200;
        return this.jumpTimer;
    }

    public void punch() {
        //punching
        this.setPunching(true);
        this.setPunchTimer(100);
    }

    public void block() {
        //blocking
        this.setBlocking(true);
    }

    public void kick(){
        this.setKicking(true);
        this.setKickTimer(70);
    }

    public int move_left(int delta){
        //takes the delta of the game and moves the player left by that much
        this.xpos -= delta;
        this.setFaceLeft(true);
        //returns the xpos for checking collisions ect
        return xpos;
    }

    public int move_right(int delta){
        //takes delta and move the player right by that much
        this.xpos += delta;
        //returns xpos for collision detection
        this.setFaceLeft(false);
        return xpos;
    }

    public int fall(int delta){
        //makes the player fall, only called if not intersecting
        this.ypos += delta;
        return this.ypos;
    }








    public Boolean getBlocking() {
        return blocking;
    }

    public void setBlocking(Boolean blocking) {
        this.blocking = blocking;
    }

    public int getXpos() {
        return xpos;
    }

    public Rectangle getBlockHitBox() {
        return blockHitBox;
    }

    public void setBlockHitBox(Rectangle blockHitBox) {
        this.blockHitBox = blockHitBox;
    }

    public Boolean getFaceLeft() {
        return faceLeft;
    }

    public void setFaceLeft(Boolean faceLeft) {
        this.faceLeft = faceLeft;
    }

    public Rectangle getPunchHitBox() {
        return punchHitBox;
    }

    public Boolean getKicking() {
        return kicking;
    }

    public void setKicking(Boolean kicking) {
        this.kicking = kicking;
    }

    public int getKickTimer() {
        return kickTimer;
    }

    public void setKickTimer(int kickTimer) {
        this.kickTimer = kickTimer;
    }

    public Rectangle getKickHitBox() {
        return kickHitBox;
    }

    public void setKickHitBox(Rectangle kickHitBox) {
        this.kickHitBox = kickHitBox;
    }

    public void setPunchHitBox(Rectangle punchHitBox) {
        this.punchHitBox = punchHitBox;
    }

    public Boolean getPunching() {
        return punching;
    }

    public int getPunchTimer() {
        return punchTimer;
    }

    public void setPunchTimer(int punchTimer) {
        this.punchTimer = punchTimer;
    }

    public void setPunching(Boolean punching) {
        this.punching = punching;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public int getJumpTimer() {
        return jumpTimer;
    }

    public void setJumpTimer(int jumpTimer) {
        this.jumpTimer = jumpTimer;
    }

    public Boolean getOnground() {
        return onground;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAbilityTimer() {
        return abilityTimer;
    }

    public void setAbilityTimer(int abilityTimer) {
        this.abilityTimer = abilityTimer;
    }

    public void setOnground(Boolean onground) {
        this.onground = onground;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public Rectangle getPlayerHitBox() {
        return playerHitBox;
    }

    public void setPlayerHitBox(Rectangle playerHitBox) {
        this.playerHitBox = playerHitBox;
    }

    public Boolean getJumping() {
        return jumping;
    }

    public void setJumping(Boolean jumping) {
        this.jumping = jumping;
    }

}
