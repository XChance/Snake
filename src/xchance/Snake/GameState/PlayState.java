package xchance.Snake.GameState;

import xchance.Snake.Cherry.Cherry;
import xchance.Snake.Game.GamePanel;
import xchance.Snake.Game.Keys;
import xchance.Snake.Snake.Snake;

import javax.swing.*;
import java.awt.*;

public class PlayState extends GameState {

    private Snake snake;
    private Cherry cherry;

    private String scoreStr = "Score: ";
    private int score;
    private Font scoreFont = new Font(new JEditorPane().getFont().getFamily(), Font.PLAIN, 28);

    private Color background;
    private Color scoreColor;

    public PlayState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        snake = new Snake();
        cherry = new Cherry();

        score = snake.getSnakeSize().size();

        background = new Color(20, 55, 110);
        scoreColor = new Color(133, 115, 143);
    }

    @Override
    public void update() {
        snake.update();
        cherry.checkCollision(snake);
        if(snake.getGrow()) {
            snake.checkGrowth();
            score = snake.getSnakeSize().size();
        }
        if(!snake.isAlive()){
            gsm.setState(GameStateManager.GAMEOVER);
        }
        handleInput();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(background);
        g.fillRect(0,0, GamePanel.WIDTH, GamePanel.HEIGHT);
        g.setColor(scoreColor);
        g.setFont(scoreFont);
        g.drawString(scoreStr, 5, 25);
        g.drawString(String.valueOf(score), 90, 25);
        cherry.draw(g);
        snake.draw(g);
    }

    @Override
    public void handleInput() {
        if(Keys.isPressed(Keys.ESCAPE)){
            gsm.setPaused(true);
        }
        if(Keys.isPressed(Keys.UP) && snake.getyDir() != 1){
            snake.setyDir(-1);
            snake.setxDir(0);
        }
        if(Keys.isPressed(Keys.DOWN) && snake.getyDir() != -1){
            snake.setyDir(1);
            snake.setxDir(0);
        }
        if(Keys.isPressed(Keys.RIGHT) && snake.getxDir() != -1){
            snake.setyDir(0);
            snake.setxDir(1);
        }
        if(Keys.isPressed(Keys.LEFT) && snake.getxDir() != 1){
            snake.setyDir(0);
            snake.setxDir(-1);
        }

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
