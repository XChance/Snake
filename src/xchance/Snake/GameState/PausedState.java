package xchance.Snake.GameState;

import xchance.Snake.Game.Keys;

import javax.swing.*;
import java.awt.*;

public class PausedState extends GameState {

    private Font scoreFont = new Font(new JEditorPane().getFont().getFamily(), Font.PLAIN, 24);
    private Color fontColor = new Color(235, 200, 145);

    public PausedState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(fontColor);
        g.setFont(scoreFont);
        g.drawString("Paused", 280, 120);
    }

    @Override
    public void handleInput() {
        if(Keys.isPressed(Keys.ESCAPE)){
            gsm.setPaused(false);
        }
    }
}
