package GameObject;

import effect.FrameImage;
import userInterface.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMap {
    private List<FrameImage> maps = new ArrayList<FrameImage>();

    public GameMap() throws IOException {
        maps = Constants.Instance().getMaps();
    }

    public void draw(Graphics2D g2) throws IOException {
        for (int i = 0; i < maps.size(); i++)
        {
            maps.get(i).setLocation(Constants.Instance().getImageSide()*(i % Constants.Instance().getMapWidth()),Constants.Instance().getImageSide()*(i / Constants.Instance().getMapWidth()));
            maps.get(i).draw(g2);
        }
    }
}
