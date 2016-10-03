package ru.sbt.test.refactoring.position;

public class Position {
    private PositionInArea positionInArea;
    private Orientation orientation;

    public Position(PositionInArea positionInArea, Orientation orientation) {
        this.positionInArea = positionInArea;
        this.orientation = orientation;
    }

    public void movePosition(PositionInArea newPositionInArea) {
        this.positionInArea = positionInArea.movePosition(newPositionInArea);
    }

    public void changeOrientation(Orientation newOrientation) {
        this.orientation = newOrientation;
    }

    public PositionInArea getPositionInArea() {
        return positionInArea;
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
