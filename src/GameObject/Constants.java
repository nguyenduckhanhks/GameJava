package GameObject;

import effect.FrameImage;
import effect.Point;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Constants {
    private static Constants instance;
    public static Constants Instance() throws IOException {

        if(instance == null) instance = new Constants();
        return instance;
    }

    private String MapFile = "data/Map.txt";
    private String EnemyLineFile = "data/EnemyLine.txt";
    private String MapsIndex = "data/MapsIndex.txt";
    private String ItemsMenu = "data/ItemsMenu.txt";

    private int ImageSide  =  64;
    private int mapWidth = 11;
    private int mapHeight = 8;
    private ArrayList<Integer> mapsIndex = new ArrayList<Integer>();
    private ArrayList<Point> enemyLine = new ArrayList<Point>();
    private List<FrameImage> maps = new ArrayList<FrameImage>();
    private List<FrameImage> itemsMenu = new ArrayList<FrameImage>();

    public String getMapFile() {
        return MapFile;
    }

    public int getImageSide() {
        return ImageSide;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public ArrayList<Integer> getMapsIndex() {
        return mapsIndex;
    }

    public ArrayList<Point> getEnemyLine() {
        return enemyLine;
    }

    public List<FrameImage> getMaps() {
        return maps;
    }

    public List<FrameImage> getItemsMenu() {
        return itemsMenu;
    }

    public Constants() throws IOException {

        Scanner scanner = new Scanner(new File(MapFile));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            BufferedImage image = ImageIO.read(new File(line));
            FrameImage frameImage = new FrameImage("1",image);
            maps.add(frameImage);
        }

        scanner = new Scanner(new File(EnemyLineFile));
        while ((scanner.hasNextLine())){
            String line = scanner.nextLine();
            String[] str = line.split(" ");
            enemyLine.add(new Point(Integer.parseInt(str[0]),Integer.parseInt(str[1])));
        }

        scanner = new Scanner(new File(MapsIndex));
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            mapsIndex.add(n);
        }

        scanner = new Scanner(new File(ItemsMenu));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            String[] str = line.split(" ");
            BufferedImage image = ImageIO.read(new File(str[0]));
            FrameImage frameImage = new FrameImage("1",image);
            frameImage.setLocation(Integer.parseInt(str[1]), Integer.parseInt(str[2]));
            itemsMenu.add(frameImage);
        }
    }
}
