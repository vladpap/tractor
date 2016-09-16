package ru.sbt.test.refactoring;

import static ru.sbt.test.refactoring.Orientation.*;
import static ru.sbt.test.refactoring.TypeMoving.*;

public class Tractor {

    private FarmArea position;
    private Orientation orientation;
    private final FarmArea field;

    public Tractor() {
        this(new FarmArea(0, 0), new FarmArea(5, 5), NORTH);
    }

    public Tractor(Orientation orientation) {
        this(new FarmArea(0, 0), new FarmArea(5, 5), orientation);
    }

    public Tractor(FarmArea position, Orientation orientation) {
        this(position, new FarmArea(5, 5), orientation);
    }

    public Tractor(FarmArea position, FarmArea field, Orientation orientation) {
        this.position = position;
        this.field = field;
        this.orientation = orientation;
    }

    public void move(TypeMoving command) {
        if (command.equals(FORWARD)) {
            moveForwards();
        } else if (command.equals(TURNCLOCKWISE)) {
            turnClockwise();
        }
    }

    private void moveForwards() {
        position = position.movePosition(orientation.moveForvard());
        if (position.isInArea(field)) {
            throw new TractorInDitchException();
        }
    }

    private void turnClockwise() {
        orientation = orientation.turnClockwise();
    }

    public int getPositionX() {
        return position.getX();
    }

    public int getPositionY() {
        return position.getY();
    }

    public Orientation getOrientation() {
        return orientation;
    }

}
