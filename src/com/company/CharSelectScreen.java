package com.company;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;
import java.awt.Font;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.Input;
import org.newdawn.slick.Color;

import static org.newdawn.slick.Color.orange;

public class CharSelectScreen extends BasicGameState {

    public CharSelectScreen(int gameState){

    }

    private Image bgImage;
    private Image title;
    private Image[] characterImages = new Image[6];

    private int charImageX = 100;
    private int charImageY = 250;

    private Font font;
    private Font test;
    private String[] characterOptions = new String[7];
    private TrueTypeFont characterOptionsFont, foo, testFont;
    private int playerChoice = 0;
    private boolean exit;
    private Color notChosen = new Color(153, 204, 255);

    private int time = 30;

    private String confirm = "Ready?";

    private static final int C1 = 0;
    private static final int C2 = 1;
    private static final int C3 = 2;
    private static final int C4 = 3;
    private static final int C5 = 4;
    private static final int C6 = 5;
    private static final int QUIT = 6;


    StartScreen startScreen = new StartScreen(0);
    GameScreen gameScreen = new GameScreen(2);


    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        bgImage = new Image("res/test/charSelectBG.jpg");
        title = new Image("res/charScreen/title.png");

        font = new Font("Verdana", Font.BOLD, 40);
        characterOptionsFont = new TrueTypeFont(font, true);
        font = new Font ("Verdana", Font.PLAIN, 20);
        foo = new TrueTypeFont(font, true);
        font = new Font("Verdana", Font.BOLD, 40);
        test = new Font("Verdana", Font.BOLD, 60);
        testFont = new TrueTypeFont(test, true);

        characterOptions[0] = "William Williams";
        characterOptions[1] = "Jesus";
        characterOptions[2] = "Angry Bear";
        characterOptions[3] = "Baby Roo";
        characterOptions[4] = "Gunslinger";
        characterOptions[5] = "Lava Boy";
        characterOptions[6] = "Back";

        characterImages[0] = new Image("res/test/playerdown.png");
        characterImages[1] = new Image("res/test/playerleft.png");
        characterImages[2] = new Image("res/test/playerright.png");
        characterImages[3] = new Image("res/test/enemy.png");
        characterImages[4] = new Image("res/test/playerup.png");
        characterImages[5] = new Image("res/test/enemy.png");


        time = 30;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        graphics.drawImage(bgImage,0, 0, null);
        graphics.drawImage(title, 100, 20);

        int i = 0;
        while (i < characterOptions.length) {
            if (playerChoice == i) {
                characterOptionsFont.drawString((8 * 50), ((i * 50) + 200), characterOptions[i]);
            } else {
                characterOptionsFont.drawString((8 * 50), ((i * 50) + 200), characterOptions[i], notChosen);
            }
            i++;
        }

        int j = 0;
        while (j < characterImages.length) {
            if (playerChoice == j) {
                graphics.drawImage(characterImages[j], charImageX, charImageY);
            }
            j++;
        }

        graphics.drawString(confirm, 650, 500);

        String timeString = Integer.toString(Math.round(time/1000));
        graphics.drawString(timeString, 700, 100);
    }


    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        //TODO: Add timer functionality
        time += i;

        if (time != 0) { // If time > 30 seconds

            Input input = gameContainer.getInput();

            // Navigating menu via arrow keys
            if (input.isKeyPressed(Input.KEY_DOWN)) {
                if (playerChoice == characterOptions.length - 1) {
                    playerChoice = 0;

                } else {
                    playerChoice++;
                }
            }
            if (input.isKeyPressed(Input.KEY_UP)) {
                if (playerChoice == 0) {
                    playerChoice = characterOptions.length - 1;
                } else {
                    playerChoice--;
                }
            }

            // Might want to do String.format for the cases
            if (input.isKeyPressed(Input.KEY_ENTER)) {
                input.clearKeyPressedRecord();
                switch (playerChoice) {
                    case C1:
                        confirm = "William Williams is selected!\n Prepare for battle...";
                        break;
                    case C2:
                        confirm = "Jesus is selected!\n Prepare for battle...";
                        break;
                    case C3:
                        confirm = "Angry Bear is selected!\n Prepare for battle...";
                        break;
                    case C4:
                        confirm = "Baby Roo is selected!\n Prepare for battle...";
                        break;
                    case C5:
                        confirm = "Gunslinger is selected!\n Prepare for battle...";
                        break;
                    case C6:
                        confirm = "Lava Boy is selected!\n Prepare for battle...";
                        break;
                    case QUIT:
                        // TODO: Get this working
                        exit = true;
                        if (exit) {
                            stateBasedGame.enterState(startScreen.getID());
                        }
                        break;
                }
            }
        } else {
            exit = true;
            confirm = "Out of time!";
            stateBasedGame.enterState(gameScreen.getID());

        }
    }

}