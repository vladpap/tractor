package ru.sbt.test.refactoring;

public enum Orientation {

    NORTH {
        @Override
        public Orientation turnClockwise() {
            return EAST;
        }

        @Override
        public FarmArea moveForvard() {
            return new FarmArea(0, 1);
        }
    },
    WEST {
        @Override
        public Orientation turnClockwise() {
            return NORTH;
        }

        @Override
        public FarmArea moveForvard() {
            return new FarmArea(-1, 0);
        }
    },
    SOUTH {
        @Override
        public Orientation turnClockwise() {
            return WEST;
        }

        @Override
        public FarmArea moveForvard() {
            return new FarmArea(0, -1);
        }
    },
    EAST {
        @Override
        public Orientation turnClockwise() {
            return SOUTH;
        }

        @Override
        public FarmArea moveForvard() {
            return new FarmArea(1, 0);
        }
    };

    public abstract Orientation turnClockwise();

    public abstract FarmArea moveForvard();
}