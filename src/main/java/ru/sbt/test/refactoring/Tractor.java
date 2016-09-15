package ru.sbt.test.refactoring;

import static ru.sbt.test.refactoring.Orientation.*;
import static ru.sbt.test.refactoring.TypeMoving.*;

public class Tractor {

    private final FarmArea position;
    private final FarmArea field;
    private final Orientation orientation;

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
        if (orientation == NORTH) {
            this = new Tractor(new FarmArea(getPositionX(), getPositionY() + 1), field, orientation);
        } else if (orientation == EAST) {
            this = new Tractor(new FarmArea(getPositionX()+1, getPositionY()), field, orientation);
        } else if (orientation == SOUTH) {
            this = new Tractor(new FarmArea(getPositionX(), getPositionY() - 1), field, orientation);
        } else if (orientation == WEST) {
            this = new Tractor(new FarmArea(getPositionX()-1, getPositionY()), field, orientation);
        }
        if (getPositionX() > field.getX() || getPositionY() > field.getY()) {
            throw new TractorInDitchException();
        }
    }

    private void turnClockwise() {
//        orientation = orientation.turnClockwise();
        if (orientation == NORTH) {
            this = new Tractor(position, field, EAST);
        } else if (orientation == EAST) {
            this = new Tractor(position, field, SOUTH);
        } else if (orientation == SOUTH) {
            this = new Tractor(position, field, WEST);
        } else if (orientation == WEST) {
            this = new Tractor(position, field, NORTH);
        }
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
