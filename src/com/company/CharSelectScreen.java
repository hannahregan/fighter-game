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

    //private Image bgImage;
    private Font font;
    private String[] characterOptions = new String[7];
    private TrueTypeFont characterOptionsFont, foo;
    private int playerChoice = 0;
    private boolean exit;
    private Color notChosen = new Color(153, 204, 255);

    private String confirm = "Ready?";

    private static final int C1 = 0;
    private static final int C2 = 1;
    private static final int C3 = 2;
    private static final int C4 = 3;
    private static final int C5 = 4;
    private static final int C6 = 5;
    private static final int QUIT = 6;



    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        //bgImage = new Image("res/charSelectBG.jpg");
        font = new Font("Verdana", Font.BOLD, 40);
        characterOptionsFont = new TrueTypeFont(font, true);
        font = new Font ("Verdana", Font.PLAIN, 20);
        foo = new TrueTypeFont(font, true);
        font = new Font("Verdana", Font.BOLD, 40);

        characterOptions[0] = "Character 1";
        characterOptions[1] = "Character 2";
        characterOptions[2] = "Character 3";
        characterOptions[3] = "Character 4";
        characterOptions[4] = "Character 5";
        characterOptions[5] = "Character 6";
        characterOptions[6] = "Quit";

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        //graphics.drawImage(bgImage,0, 0, null);
        graphics.setBackground(orange);
        int i = 0;
        while (i < characterOptions.length) {
            if (playerChoice == i) {
                characterOptionsFont.drawString((i * 50), (i * 50), characterOptions[i]);
            } else {
                characterOptionsFont.drawString((i * 50), (i * 50), characterOptions[i], notChosen);
            }
            i++;
        }

        graphics.drawString(confirm, 500, 400);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

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

        if (input.isKeyPressed(Input.KEY_ENTER)) {
            switch (playerChoice) {
                case C1:
                    confirm = "Character 1 is selected!\n Prepare for battle...";
                    exit = true;
                    break;
            }
        }

    }

}