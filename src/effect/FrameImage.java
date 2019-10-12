package effect;

import GameObject.Constants;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FrameImage {
    private String name;
    private BufferedImage image;

    private Point location;

    private long currentTime;
    private long beginTime;


    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public long getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(long beginTime) {
        this.beginTime = beginTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(int X, int Y) {
        this.location.setX(X);
        this.location.setY(Y);
    }

    public FrameImage(String name, BufferedImage image)
    {
        this.name = name;
        this.image = image;
        this.beginTime = 0;
        location = new Point();
        this.currentTime = 500*1000000;
    }


    public FrameImage(FrameImage frameImage)
    {
        image = new BufferedImage(frameImage.getImage().getWidth(), frameImage.getImage().getHeight(),frameImage.getImage().getType());
        Graphics g = image.getGraphics();
        g.drawImage(frameImage.getImage(),0,0,null);
    }

    public boolean IsOverlap(FrameImage image1) throws IOException {
        return(Math.abs(this.location.getX() - image1.location.getX()) < Constants.Instance().getImageSide() && Math.abs(this.location.getY()-image1.location.getY())<Constants.Instance().getImageSide());
    }

    public void  draw(Graphics2D g2)
    {
        g2.drawImage(image,location.getX(),location.getY(),null);
    }


}
