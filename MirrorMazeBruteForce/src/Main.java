import InputOutput.Reader;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        char[][] mazeArray = Reader.read("maze.txt").get(0);

        MirrorMaze maze = new MirrorMaze(mazeArray[0].length, mazeArray.length, mazeArray);
        
        System.out.println(maze);
        System.out.println(MirrorMaze.toString(maze.getSolution()));
    }
}
