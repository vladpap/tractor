package ru.sbt.test.refactoring;

import ru.sbt.test.refactoring.command.Command;
import ru.sbt.test.refactoring.position.FarmArea;
import ru.sbt.test.refactoring.position.Orientation;
import ru.sbt.test.refactoring.position.Position;
import ru.sbt.test.refactoring.position.PositionInArea;

import static ru.sbt.test.refactoring.position.Orientation.NORTH;

public class Tractor {

    private Position position;
    private final FarmArea field;

    public Tractor() {
        this(new PositionInArea(0, 0), new FarmArea(5, 5), NORTH);
    }

    public Tractor(Orientation orientation) {
        this(new PositionInArea(0, 0), new FarmArea(5, 5), orientation);
    }

    public Tractor(PositionInArea position, Orientation orientation) {
        this(position, new FarmArea(5, 5), orientation);
    }

    public Tractor(PositionInArea position, FarmArea field, Orientation orientation) {
        this.position = new Position(position, orientation);
        this.field = field;
    }

    public void move(Command command) {
        command.executed(position);
        if (position.getPositionInArea().isInArea(field)) {
            throw new TractorInDitchException();
        }
    }

    public int getPositionX() {
        return position.getPositionInArea().getX();
    }

    public int getPositionY() {
        return position.getPositionInArea().getY();
    }

    public Orientation getOrientation() {
        return position.getOrientation();
    }

}