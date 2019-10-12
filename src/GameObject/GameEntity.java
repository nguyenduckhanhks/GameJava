package GameObject;

import effect.FrameImage;
import effect.Point;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class GameEntity {
    private String imagePath;
    private FrameImage frameImage;

    public FrameImage getFrameImage() {
        return frameImage;
    }

    public void setFrameImage(FrameImage frameImage) {
        this.frameImage = frameImage;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public GameEntity(String fileName) throws IOException {
        imagePath = fileName;
        BufferedImage image = ImageIO.read(new File(imagePath));
        frameImage = new FrameImage("1",image);
    }

}
