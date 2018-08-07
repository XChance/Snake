package xchance.Snake.Game;

import xchance.Snake.GameState.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements Runnable, KeyListener {

    public static final int WIDTH = 640;
    public static final int HEIGHT = 360;

    private boolean running;
    private Thread thread;

    private GameStateManager gsm;

    public GamePanel(){
        init();
    }

    public void init(){
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);
        addKeyListener(this);
        gsm = new GameStateManager();
        requestFocus();
        running = true;
        thread = new Thread(this, "Game");
        thread.start();
    }

    @Override
    public void run() {
        while(running){

            update();
            repaint();

            try {
                thread.sleep(32);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        gsm.update();
        Keys.update();
    }

    protected void paintComponent(Graphics g){
        gsm.draw(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        Keys.keySet(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Keys.keySet(e.getKeyCode(), false);
    }
}
