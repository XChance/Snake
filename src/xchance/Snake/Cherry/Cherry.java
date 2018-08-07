package xchance.Snake.Cherry;

import xchance.Snake.Game.GamePanel;
import xchance.Snake.GameState.PlayState;
import xchance.Snake.Snake.Point;
import xchance.Snake.Snake.Snake;

import java.awt.*;
import java.util.Random;

public class Cherry {
    protected static final int WIDTH = 8;
    protected static final int HEIGHT = 8;
    protected static final int MAX_X = GamePanel.WIDTH - WIDTH;
    protected static final int MAX_Y = GamePanel.HEIGHT - HEIGHT;

    protected Point cherry;
    protected Color cherryColor = new Color(170, 35, 10);
    protected Random rd;

    public Cherry(){
        cherry = new Point(0, 0);
        rd = new Random();
        setPos();
    }

    public void setPos(){
        int tempX = rd.nextInt(MAX_X/WIDTH);
        int tempY = rd.nextInt(MAX_Y/HEIGHT);

        tempX *= WIDTH;
        tempY *= HEIGHT;

        cherry.setX(tempX);
        cherry.setY(tempY);
    }

    public void checkCollision(Snake snake){
        if(snake.getSnakeSize().get(0).getX() == cherry.getX() &&
                snake.getSnakeSize().get(0).getY() == cherry.getY()){
            snake.setGrow(true);
            setPos();
        }
    }

    public void draw(Graphics g){
        g.setColor(cherryColor);
        g.fillRect(cherry.getX(), cherry.getY(), WIDTH, HEIGHT);
    }

}
