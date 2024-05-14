package models.island;

public class Field {
    private int x;
    private int y;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Сделал сам сеттеры
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Field{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
