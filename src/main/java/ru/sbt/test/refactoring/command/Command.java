package ru.sbt.test.refactoring.command;

import ru.sbt.test.refactoring.position.Position;

public interface Command {
    void executed(Position position);
}