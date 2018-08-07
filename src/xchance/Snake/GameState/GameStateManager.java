package xchance.Snake.GameState;

import java.awt.*;

public class GameStateManager {

    private boolean paused;
    private PausedState pausedState;

    private GameState[] gameStates;
    private int currentState;
    private int previousState;

    public static final int NUM_STATES = 3;
    public static final int MENU = 0;
    public static final int PLAY = 1;
    public static final int GAMEOVER = 2;
    
    public GameStateManager(){
        gameStates = new GameState[NUM_STATES];
        pausedState = new PausedState(this);
        paused = false;
        setState(PLAY);
    }
    
    public void update(){
        if(paused){
           pausedState.update();
        }else {
            gameStates[currentState].update();
        }
    }

    public void draw(Graphics g){
        if(gameStates[currentState] != null){
            gameStates[currentState].draw(g);
        }
        if (paused) {
            pausedState.draw(g);
        }
    }

    public void setState(int i) {
        previousState = currentState;
        unloadState(previousState);
        currentState = i;
        if(i == MENU) {
            gameStates[i] = new MenuState(this);
        }
        else if(i == PLAY) {
            gameStates[i] = new PlayState(this);
        }
        else if(i == GAMEOVER) {
            gameStates[i] = new GameOverState(this);
        }
    }

    public void unloadState(int i){
        gameStates[i] = null;
    }

    public void setPaused(boolean b){
        paused = b;
    }


    
}
