package GameObject;

import effect.FrameImage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    public static void drawMenu(Graphics2D g2) throws IOException {
        g2.setColor(Color.gray);
        g2.drawRect(704,0,200,512);
        g2.fillRect(704,0,200,512);

        List<FrameImage> items = Constants.Instance().getItemsMenu();
        for(int i = items.size() - 1; i >= 0 ;i--)
        {
            items.get(i).draw(g2);
        }
    }


}
