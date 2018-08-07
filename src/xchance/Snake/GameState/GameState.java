package xchance.Snake.GameState;

import java.awt.*;

public abstract class GameState {

    protected GameStateManager gsm;

    public GameState(GameStateManager gsm){
        this.gsm = gsm;
        init();
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract void handleInput();

}
