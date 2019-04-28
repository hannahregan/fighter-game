package com.company;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/");
        try {
            AppGameContainer app = new AppGameContainer(new Game());
            app.setDisplayMode(880, 600, false);
            app.start();
        }catch (SlickException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
