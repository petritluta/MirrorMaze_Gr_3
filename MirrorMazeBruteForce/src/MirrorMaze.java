public class MirrorMaze {
    private final int width;
    private final int height;

    private final char[][] maze;

    private int startingPositionX;
    private int startingPositionY;

    public MirrorMaze(int width, int height, char[][] maze) {
        this.width = width;
        this.height = height;
        this.maze = maze;
    }

    public char[][] getSolution() {

        return null;
    }

    private boolean checkSolution() {

        return false;
    }

    private void getStartingPosition() {
        startingPositionX = 0;

        for (int startingPositionY = 1; startingPositionY < height - 1; startingPositionY++) {
            if (maze[startingPositionX][startingPositionY] == '.') {
                return;
            }
        }

        startingPositionX = width - 1;

        for (int startingPositionY = 1; startingPositionY < height - 1; startingPositionY++) {
            if (maze[startingPositionX][startingPositionY] == '.') {
                return;
            }
        }

        startingPositionY = 0;

        for (int startingPositionX = 1; startingPositionX < width - 1; startingPositionX++) {
            if (maze[startingPositionX][startingPositionY] == '.') {
                return;
            }
        }

        startingPositionY = height - 1;

        for (int startingPositionX = 1; startingPositionX < width - 1; startingPositionX++) {
            if (maze[startingPositionX][startingPositionY] == '.') {
                return;
            }
        }

    }

}
