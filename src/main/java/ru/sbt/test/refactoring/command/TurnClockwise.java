package ru.sbt.test.refactoring.command;

import ru.sbt.test.refactoring.position.Position;

public class TurnClockwise implements Command{

    public void executed(Position position) {
        position.changeOrientation(position.getOrientation().rotateClockwise());

    }
}
