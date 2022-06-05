import InputOutput.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        for (char[][] mazeArray : Reader.read("maze.txt")) {
            MirrorMaze maze = new MirrorMaze(mazeArray[0].length, mazeArray.length, mazeArray);

            System.out.println(maze);
            //TODO: print this to a file
            System.out.println(MirrorMaze.toString(maze.getSolution()));

        }
    }
}
