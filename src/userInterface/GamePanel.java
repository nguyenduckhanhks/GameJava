package userInterface;

import GameObject.*;
import GameObject.Menu;
import effect.FrameImage;
import effect.Point;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GamePanel extends JPanel implements Runnable, MouseListener{
    private Thread thread;
    private boolean isRunning;
    private InputManger inputManger;

    private Enemy enemys = new Enemy("data/towerDefense_tile291.png");

    public  GamePanel() throws IOException {
        inputManger = new InputManger();
    }
    @Override
    public void paint(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(0,0,GameFrame.SCREEN_WIDTH,GameFrame.SCREEN_HEIGHT);
        Graphics2D g2 = (Graphics2D)g;

        try {
            Reponsitory.Instance().getGameMap().draw(g2);
            enemys.move(g2);
            for (int i = 0; i < Reponsitory.Instance().getTowers().size(); i++)
            {
                Reponsitory.Instance().getTowers().get(i).getFrameImage().draw(g2);
            }
            Menu.drawMenu(g2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame()
    {
        if(thread == null)
        {
            isRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run()
    {
        long FPS = 10;
        long period = 1000*1000000/FPS;
        long sleepTime;
        long beginTime = System.nanoTime();

        while (isRunning)
        {
            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;

            repaint();
            try {
                if(sleepTime > 0) {
                    Thread.sleep(sleepTime / 1000000);
                }else Thread.sleep(period/2000000);

            } catch (InterruptedException e) {}
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        inputManger.processmouseClicked(mouseEvent);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        try {
            inputManger.processmousePressed(mouseEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        try {
            inputManger.processmouseReleased(mouseEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        inputManger.processmouseEntered(mouseEvent);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        inputManger.processmouseExited(mouseEvent);
    }
}
