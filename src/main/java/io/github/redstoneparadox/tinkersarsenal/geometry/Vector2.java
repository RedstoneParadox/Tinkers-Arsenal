package io.github.redstoneparadox.tinkersarsenal.geometry;

public class Vector2 {
    private int x;
    private int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXLength() {
        return this.x;
    }

    public int getYLength() {
        return this.y;
    }

    public double getLength() {
        double length = Math.sqrt((double)(this.x * this.x + this.y * this.y));
        return length;
    }

    public double angleTo(Vector2 vector) {
        int toa1 = this.y / this.x;
        double angle1 = Math.atan((double)toa1);
        int toa2 = vector.getYLength() / vector.getXLength();
        double angle2 = Math.atan((double)toa2);
        return angle2 - angle1;
    }

    public Vector2 addVector(Vector2 vector) {
        int xNew = this.x + vector.getXLength();
        int yNew = this.y + vector.getYLength();
        return new Vector2(xNew, yNew);
    }

    public Vector2 subtractVector(Vector2 vector) {
        int xNew = this.x - vector.getXLength();
        int yNew = this.y - vector.getYLength();
        return new Vector2(xNew, yNew);
    }
}
