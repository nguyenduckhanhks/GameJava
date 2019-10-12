package GameObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reponsitory {

    private static Reponsitory instance;

    private List<Tower> towers;
    private GameMap gameMap;

    public static Reponsitory Instance() throws IOException {
        if(instance == null) instance = new Reponsitory();
        return instance;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void addTower(Tower tower)
    {
        towers.add(tower);
    }
    private Reponsitory() throws IOException {
        gameMap = new GameMap();
        towers = new ArrayList<Tower>();
    }
}
