package userInterface;

import GameObject.Reponsitory;
import GameObject.Tower;
import effect.FrameImage;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.IOException;


public class InputManger{
    private boolean isCreateTower ;
    public void processmouseClicked(MouseEvent mouseEvent)
    {

    }

    public void processmousePressed(MouseEvent mouseEvent) throws IOException {
        isCreateTower =  Tower.isCreateTower(mouseEvent);
    }

    public void processmouseReleased(MouseEvent mouseEvent) throws IOException {
        if(isCreateTower)
        {
            if(Tower.createTower(mouseEvent) != null)
            {
                Tower tower = Tower.createTower(mouseEvent);
                Reponsitory.Instance().addTower(tower);
            }
        }

    }

    public void processmouseEntered(MouseEvent mouseEvent)
    {

    }

    public void processmouseExited(MouseEvent mouseEvent)
    {

    }

}
