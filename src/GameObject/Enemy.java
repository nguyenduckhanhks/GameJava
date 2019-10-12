package GameObject;

import effect.FrameImage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Enemy extends GameEntity{

    private int currentLocation = 0;

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Enemy(String fileName) throws IOException {
        super(fileName);
    }

    public void move(Graphics2D g2) throws IOException {
        if(this.getFrameImage() != null)
        {
            getFrameImage().setLocation(Constants.Instance().getEnemyLine().get(currentLocation).getX()+20,Constants.Instance().getEnemyLine().get(currentLocation).getY()+20);
            getFrameImage().draw(g2);
            currentLocation++;
        }
        if(currentLocation >= Constants.Instance().getEnemyLine().size()) this.setFrameImage(null);
    }
}
