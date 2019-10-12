package effect;

public class Point {
    private int X;
    private int Y;

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public Point(int x, int y) {
        X = x;
        Y = y;
    }

    public  Point()
    {
        X = 0; Y = 0;
    }
}
