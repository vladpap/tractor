package ru.sbt.test.refactoring;

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

    public FarmArea movePosition(FarmArea farmArea) {
        return new FarmArea(this.x + farmArea.getX(), this.y + farmArea.getY());
    }

    public boolean isInArea(FarmArea area) {
        return (this.x > area.getX() || this.y > area.getY());
    }
}