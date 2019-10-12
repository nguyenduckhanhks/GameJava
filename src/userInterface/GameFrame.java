package userInterface;

import GameObject.Constants;
import GameObject.GameMap;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameFrame extends JFrame {
    public  static  final int SCREEN_WIDTH = 1000;
    public  static  final int SCREEN_HEIGHT = 600;
    GamePanel gamePanel;

    public GameFrame() throws IOException {
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        this.setBounds((dimension.width - SCREEN_WIDTH)/2,(dimension.height-SCREEN_HEIGHT)/2,SCREEN_WIDTH,SCREEN_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gamePanel = new GamePanel();
        add(gamePanel);

        this.addMouseListener(gamePanel);
    }

    public void startgame()
    {
        gamePanel.startGame();
    }

    public static void main(String[] args) throws IOException {
        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);
        gameFrame.startgame();
    }
}
