package ru.sbt.test.refactoring.position;

public class PositionInArea extends FarmArea {
    public PositionInArea(int x, int y) {
        super(x, y);
    }
    public PositionInArea movePosition(PositionInArea positionInArea) {
        return new PositionInArea(super.getX() + positionInArea.getX(), super.getY() + positionInArea.getY());
    }

    public boolean isInArea(FarmArea area) {
        return (super.getX() > area.getX() || super.getY() > area.getY());
    }
}
