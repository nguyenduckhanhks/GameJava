package GameObject;

import effect.FrameImage;
import effect.Point;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class Tower extends GameEntity {

    public Tower(String filename)throws IOException
    {
        super(filename);
    }

    public boolean isPress(int x, int y)
    {
        if((x-this.getFrameImage().getLocation().getX()) < 64 && (y -this.getFrameImage().getLocation().getY()) < 64)
        {
            return true;
        }
        return false;
    }

    public static boolean isCreateTower(MouseEvent mouseEvent)
    {
        if(mouseEvent.getX() - 704 < 64 && mouseEvent.getX() - 704 >= 0 && mouseEvent.getY() < 64 && mouseEvent.getY() >= 0) return true;
        return false;
    }

    public static Tower createTower(MouseEvent mouseEvent) throws IOException {
        boolean test = true;
        Tower tower = null;
        for (int i = Constants.Instance().getMaps().size()-1; i >=0;i--) {
            if(Constants.Instance().getMapsIndex().get(i) == 1)
            {
                Point point = Constants.Instance().getMaps().get(i).getLocation();
                if(mouseEvent.getX() - point.getX() < 64 && mouseEvent.getX() - point.getX() >= 0 && mouseEvent.getY() - point.getY() < 64 && mouseEvent.getY() - point.getY() >= 0)
                {
                    test = false;
                    break;
                }
            }
        }
        if(test)
        {
            tower = new Tower("data/towerDefense_tile249.png");
            tower.getFrameImage().setLocation(mouseEvent.getX(),mouseEvent.getY());   
        }
        return tower;
    }
}
