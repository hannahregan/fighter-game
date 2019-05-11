package com.company;

import java.awt.*;

public class PunchingBag {
    //punching bag to test physics
    public Rectangle bagHitBox;
    public int xpos, ypos, punchCounter, LeftRight, kickCounter;
    public boolean onGround, punched, kicked;

    public PunchingBag(){
        this.xpos = 300;
        this.ypos = 50;


        this.punchCounter = 0;
        this.kickCounter = 0;

        //0 is left, 1 is right
        this.LeftRight = 0;

        this.onGround = false;
        this.punched = false;
        this.kicked = false;

        bagHitBox = new Rectangle(this.xpos, this.ypos,70, 100);
    }

    public void update(int delta, Player player){
        bagHitBox.setLocation(this.xpos, this.ypos);


        //falling
        if(this.isOnGround() == false){
            ypos += delta;
        }


        //got punched
        if(this.isPunched()){
            //punch counter and move back that much
            if(player.getFaceLeft()){
                this.setLeftRight(0);
            }else{
                this.setLeftRight(1);
            }
            this.setPunchCounter(50);
            this.setPunched(false);
        }

        //got kicked
        if(this.isKicked()){
            //kick counter, kicks hit harder
            if(player.getFaceLeft()){
                this.setLeftRight(0);
            }else{
                this.setLeftRight(1);
            }
            this.setKickCounter(30);
            this.setKicked(false);
        }

        //punch counter ( 0 is left, 1 is right

        if(this.getPunchCounter() > 0){
            //only works left???
            if(this.getLeftRight() == 0) {
                this.xpos -= delta;
            }else{
                this.xpos += delta;
            }
            this.setPunchCounter(this.getPunchCounter() - 1);
        }


        //kick counter

        if(this.getKickCounter() > 0){
            if(this.getLeftRight() == 0) {
                this.xpos -= delta*2;
            }else{
                this.xpos += delta*2;
            }

            //vertical shit
            if(this.getKickCounter() > 15){
                this.ypos -= delta*2;
            }

            this.setKickCounter(this.getKickCounter() - 1);
        }
    }












    public Rectangle getBagHitBox() {
        return bagHitBox;
    }

    public boolean isOnGround() {
        return onGround;
    }

    public int getLeftRight() {
        return LeftRight;
    }

    public void setLeftRight(int leftRight) {
        LeftRight = leftRight;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public int getKickCounter() {
        return kickCounter;
    }

    public void setKickCounter(int kickCounter) {
        this.kickCounter = kickCounter;
    }

    public boolean isKicked() {
        return kicked;
    }

    public void setKicked(boolean kicked) {
        this.kicked = kicked;
    }

    public boolean isPunched() {
        return punched;
    }

    public int getPunchCounter() {
        return punchCounter;
    }

    public void setPunchCounter(int punchCounter) {
        this.punchCounter = punchCounter;
    }

    public void setPunched(boolean punched) {
        this.punched = punched;
    }

    public void setBagHitBox(Rectangle bagHitBox) {
        this.bagHitBox = bagHitBox;
    }

    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
}
