package xchance.Snake.Snake;

import xchance.Snake.Game.GamePanel;
import xchance.Snake.GameState.PlayState;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    List<Point> snakeSize;
    protected int xDir, yDir;
    protected static final int WIDTH = 8, HEIGHT = 8;
    protected static final int MAX_X = GamePanel.WIDTH - WIDTH;
    protected static final int MIN_X = 0;
    protected static final int MAX_Y = GamePanel.HEIGHT - HEIGHT;
    protected static final int MIN_Y = 0;
    protected boolean isMoving, grow, isAlive;
    protected int startSize, startX, startY, growthAmt;

    public Snake(){
        init();
    }

    public void init(){
        snakeSize = new ArrayList<Point>();
        xDir = 1;
        yDir = 0;
        isMoving = true;
        isAlive = true;
        grow = false;

        startSize = 3;
        startX = 8;
        startY = 16;

        for(int i = 0; i < startSize; i++) {
            snakeSize.add(new Point(startX - i*WIDTH, startY));
        }
    }

    public void update(){
        move();
        checkCollision();
    }

    public void move(){
        if(isMoving){
            checkWalls();
            Point start = snakeSize.get(0);
            Point newStart = new Point(start.getX() + xDir * WIDTH, start.getY() + yDir * HEIGHT);
            for (int i = snakeSize.size() - 1; i >= 1; i--) {
                snakeSize.set(i, snakeSize.get(i - 1));
            }
            snakeSize.set(0, newStart);
        }
    }

    public void checkGrowth(){
        growthAmt = 3;
        for(int i = 0; i < growthAmt; i++){
            Point last = snakeSize.get(snakeSize.size() - 1);
            snakeSize.add(new Point(last.getX(), last.getY()));
        }
        grow = false;
    }


    public void checkWalls(){
        if(snakeSize.get(0).getX() > MAX_X){
            Point temp = snakeSize.get(0);
            temp.setX(MIN_X);
            snakeSize.set(0, temp);
        }
        if(snakeSize.get(0).getX() < MIN_X){
            Point temp = snakeSize.get(0);
            temp.setX(MAX_X);
            snakeSize.set(0, temp);
        }
        if(snakeSize.get(0).getY() > MAX_Y){
            Point temp = snakeSize.get(0);
            temp.setY(MIN_Y);
            snakeSize.set(0, temp);
        }
        if(snakeSize.get(0).getY() < MIN_Y){
            Point temp = snakeSize.get(0);
            temp.setY(MAX_Y);
            snakeSize.set(0, temp);
        }
    }

    public void checkCollision(){
        for(int i = 1; i < snakeSize.size(); i++){
            if(snakeSize.get(0).getX() == snakeSize.get(i).getX() &&
                    snakeSize.get(0).getY() == snakeSize.get(i).getY()){
                isAlive = false;
            }
        }
    }

    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        for(int i = 0; i < snakeSize.size(); i++){
            g.fillRect(snakeSize.get(i).getX(), snakeSize.get(i).getY(), WIDTH, HEIGHT);
        }
    }

    public List<Point> getSnakeSize() {
        return snakeSize;
    }

    public int getxDir() {
        return xDir;
    }

    public void setxDir(int xDir) {
        this.xDir = xDir;
    }

    public int getyDir() {
        return yDir;
    }

    public void setyDir(int yDir) {
        this.yDir = yDir;
    }

    public boolean getMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean getGrow() {
        return grow;
    }

    public void setGrow(boolean grow) {
        this.grow = grow;
    }

    public int getGrowthAmt() {
        return growthAmt;
    }

    public boolean isAlive() {
        return isAlive;
    }
}