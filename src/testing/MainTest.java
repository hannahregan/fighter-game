package testing;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import com.company.Game;

public class MainTest {
    public static void main(String[] args) {
        System.setProperty("org.lwjgl.librarypath",System.getProperty("user.dir") + "/lib/");
        try {
            AppGameContainer app = new AppGameContainer(new GameTest());
            app.setDisplayMode(880, 600, false);
            app.start();
        }catch (SlickException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
