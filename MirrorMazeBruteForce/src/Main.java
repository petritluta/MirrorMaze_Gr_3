import InputOutput.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        char[][] mazeArray = null;
        try {
            mazeArray = Reader.read("maze.txt").get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        MirrorMaze maze = new MirrorMaze(mazeArray[0].length, mazeArray.length, mazeArray);
        System.out.println(maze.toString());
        System.out.println(maze.checkSolution());
    }
}
