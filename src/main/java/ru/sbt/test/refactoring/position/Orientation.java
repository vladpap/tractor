/*                    North
                        |
                 West -----East
                        |
                      South
*/
package ru.sbt.test.refactoring.position;

public enum Orientation {
    
    NORTH {
        @Override
        public Orientation rotateClockwise() {
            return EAST;
        }

        @Override
        public Orientation rotateCounterClockwise() {
            return WEST;
        }

        @Override
        public Orientation rotate180() {
            return SOUTH;
        }
    },
    
    EAST {
        @Override
        public Orientation rotateClockwise() {
            return SOUTH;
        }

        @Override
        public Orientation rotateCounterClockwise() {
            return NORTH;
        }

        @Override
        public Orientation rotate180() {
            return WEST;
        }
    },
    
    SOUTH {
        @Override
        public Orientation rotateClockwise() {
            return WEST;
        }

        @Override
        public Orientation rotateCounterClockwise() {
            return EAST;
        }

        @Override
        public Orientation rotate180() {
            return NORTH;
        }
    },
    
    WEST {
        public Orientation rotateClockwise() {
            return NORTH;
        }

        public Orientation rotateCounterClockwise() {
            return SOUTH;
        }

        public Orientation rotate180() {
            return EAST;
        }
    };

    public abstract Orientation rotateClockwise();
    public abstract Orientation rotateCounterClockwise();
    public abstract Orientation rotate180();
}

/*
    NORTH {
        @Override
        public Orientation turnClockwise() {
            return EAST;
        }

        @Override
        public PositionInArea moveForvard() {
            return new PositionInArea(0, 1);
        }
    },
    WEST {
        @Override
        public Orientation turnClockwise() {
            return NORTH;
        }

        @Override
        public PositionInArea moveForvard() {
            return new PositionInArea(-1, 0);
        }
    },
    SOUTH {
        @Override
        public Orientation turnClockwise() {
            return WEST;
        }

        @Override
        public PositionInArea moveForvard() {
            return new PositionInArea(0, -1);
        }
    },
    EAST {
        @Override
        public Orientation turnClockwise() {
            return SOUTH;
        }

        @Override
        public PositionInArea moveForvard() {
            return new PositionInArea(1, 0);
        }
    };

    public abstract Orientation turnClockwise();

    public abstract PositionInArea moveForvard();
}
    */