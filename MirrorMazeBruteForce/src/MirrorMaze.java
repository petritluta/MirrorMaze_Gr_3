import java.io.Serializable;

public class MirrorMaze implements Serializable {
    private final int width;
    private final int height;

    private final char[][] maze;

    private int startingPositionX;
    private int startingPositionY;

    private Direction direction;

    public MirrorMaze(int width, int height, char[][] maze) {
        this.width = width;
        this.height = height;
        this.maze = maze;

        getStartingPosition();
    }
    public char[][] getSolution() {
        for (int Y = startingPositionY; Y < height; Y++) {
            char[][] randomMaze = maze;
            for (int X = startingPositionX; X < width; X++) {
                if (randomMaze[Y][X] == '/') {

                } else if (randomMaze[Y][X] == '\\') {

                }
                checkSolution(randomMaze, direction);
            }
        }
        return null;
    }

    private boolean checkSolution(char[][] maze, Direction direction) {
        int X = startingPositionX;
        int Y = startingPositionY;

        while (maze[Y][X] != '*') {
            switch (direction) {
                case UP -> Y--;
                case DOWN -> Y++;
                case RIGHT -> X++;
                case LEFT -> X--;
            }
            if (maze[Y][X] == '/') {
                switch (direction) {
                    case UP -> direction = Direction.RIGHT;
                    case DOWN -> direction = Direction.LEFT;
                    case LEFT -> direction = Direction.DOWN;
                    case RIGHT -> direction = Direction.UP;
                }
            } else if (maze[Y][X] == '\\') {
                switch (direction) {
                    case UP -> direction = Direction.LEFT;
                    case DOWN -> direction = Direction.RIGHT;
                    case LEFT -> direction = Direction.UP;
                    case RIGHT -> direction = Direction.DOWN;
                }
            }
            if ((X == 0 || X == width - 1 || Y == 0 || Y == height - 1) && maze[Y][X] == '.') {
                return true;
            }
        }
        return false;
    }

    private void getStartingPosition() {
        startingPositionX = 0;

        for (startingPositionY = 1; startingPositionY < height - 1; startingPositionY++) {
            if (maze[startingPositionY][startingPositionX] == '.') {
                direction = Direction.RIGHT;
                return;
            }
        }

        startingPositionX = width - 1;

        for (startingPositionY = 1; startingPositionY < height - 1; startingPositionY++) {
            if (maze[startingPositionY][startingPositionX] == '.') {
                direction = Direction.LEFT;
                return;
            }
        }

        startingPositionY = 0;

        for (startingPositionX = 1; startingPositionX < width - 1; startingPositionX++) {
            if (maze[startingPositionY][startingPositionX] == '.') {
                direction = Direction.DOWN;
                return;
            }
        }

        startingPositionY = height - 1;

        for (startingPositionX = 1; startingPositionX < width - 1; startingPositionX++) {
            if (maze[startingPositionY][startingPositionX] == '.') {
                direction = Direction.UP;
                return;
            }
        }

    }


    //toString Functions


    public static String toString(char[][] maze) {
        StringBuilder mazeString = new StringBuilder();
        for (char[] chars : maze) {
            for (char aChar : chars) {
                mazeString.append(aChar);
            }
            mazeString.append('\n');
        }
        return mazeString.toString();
    }

    @Override
    public String toString() {
        StringBuilder mazeString = new StringBuilder();
        for (char[] chars : maze) {
            for (char aChar : chars) {
                mazeString.append(aChar);
            }
            mazeString.append('\n');
        }
        return mazeString.toString();
    }

}
