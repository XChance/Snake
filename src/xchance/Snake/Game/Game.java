package xchance.Snake.Game;

import javax.swing.*;

public class Game {

    public Game(){
        JFrame frame = new JFrame("Snake");

        frame.add(new GamePanel());
        frame.setResizable(false);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Game game = new Game();
    }

}
