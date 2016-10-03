package ru.sbt.test.refactoring.command;

import ru.sbt.test.refactoring.position.Position;

public class MoveBackward implements Command{

    public void executed(Position position) {
        position.movePosition(position.getOrientation().moveForvard());
    }
}
