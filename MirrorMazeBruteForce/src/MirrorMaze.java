import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MirrorMaze implements Serializable {
    private final int width;
    private final int height;

    private char[][] maze;

    private int startingPositionX;
    private int startingPositionY;

    private Direction direction;

    public MirrorMaze(int width, int height, char[][] maze) {
        this.width = width;
        this.height = height;
        this.maze = maze;

    }

    private String[] getCombinations(int length) {
        List<String> combinations = new ArrayList<>();
        for (int i=0; i < Math.pow(2, length); i++) {
            combinations.add(padLeftZeros(Integer.toBinaryString(i),length)); // hapsinori: 2^(numri i pasqyrave)
        }

        return combinations.toArray(new String[0]);
    }

    public String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    public char[][] getSolution() {
        getStartingPosition();          //2*height + 2*width - 8 = 2(height + width) - 8 : O(1)
        Point[] mirrors = getMirrorPositions(maze); // height*width + builtIn funksioni toArray : Gjith njejet
        String[] combinations = getCombinations(mirrors.length);    //2^(numri i pasqyrave)*(numri i pasqyrave) : gjith njejt


        //Best case: 2^(numri i pasqyrave)*((numri i pasqyrave) + konstant)
        for(int i = 0; i < combinations.length; i++) {          //Worst case: 2^(numri i pasqyrave)*((numri i pasqyrave) + (height-2)*(width-2) + 2)
            for(int mirrorIndex = 0; mirrorIndex < mirrors.length; mirrorIndex++) {
                maze[mirrors[mirrorIndex].y][mirrors[mirrorIndex].x] = combinations[i].charAt(mirrorIndex) == '0' ? '/' : '\\';
            }

            if(checkSolution(maze, direction)) {
                return maze;
            }
        }

        return null;
    }

    private boolean checkSolution(char[][] maze, Direction direction) {                 //Best case eshte O(1)
                                                                                        //Worst case eshte
        int X = startingPositionX;
        int Y = startingPositionY;

        while (maze[Y][X] != '*') {
            switch (direction) {
                case UP : Y--; break;
                case DOWN : Y++; break;
                case RIGHT : X++; break;
                case LEFT : X--; break;
            }
            if (maze[Y][X] == '/') {
                switch (direction) {
                    case UP : direction = Direction.RIGHT; break;
                    case DOWN : direction = Direction.LEFT; break;
                    case LEFT : direction = Direction.DOWN; break;
                    case RIGHT : direction = Direction.UP; break;
                }
            } else if (maze[Y][X] == '\\') {
                switch (direction) {
                    case UP : direction = Direction.LEFT; break;
                    case DOWN : direction = Direction.RIGHT; break;
                    case LEFT : direction = Direction.UP; break;
                    case RIGHT : direction = Direction.DOWN; break;
                }
            } else if ((X == 0 || X == width - 1 || Y == 0 || Y == height - 1) && maze[Y][X] == '.') {
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

    private Point[] getMirrorPositions(char[][] maze) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == '/' || maze[i][j] == '\\') {
                    points.add(new Point(j, i));                //pointa sa ka pasqyra, hapsinori O(nr pasqyrave)
                }
            }
        }

        return points.toArray(new Point[0]);
    }

    //toString Functions


    public static String toString(char[][] maze) {
        if (maze == null) {
            return "No solution!";
        }
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
        if (maze == null) {
            return "No solution!";
        }
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
