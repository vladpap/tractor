package ru.sbt.test.refactoring.position;

public class FarmArea {
    private final int x;
    private final int y;

    public FarmArea(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}