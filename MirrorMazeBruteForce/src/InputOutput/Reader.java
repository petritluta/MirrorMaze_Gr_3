package InputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {

    public static List<char[][]> read(String path) throws IOException {
        List<char[][]> mazes = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(path));
            while (true) {
                String line = reader.readLine();

                List<Integer> ints = Arrays.stream(line.split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

                if (ints.get(0) == -1 || ints.get(1) == -1)
                    break;
                mazes.add(readMaze(reader, ints.get(0), ints.get(1)));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mazes;
    }

    private static char[][] readMaze(BufferedReader reader, int width, int height) throws IOException {
        char[][] maze = new char[width][height];
        String line = reader.readLine();
        int lineIndex = 0;
        while (line != null) {
            maze[lineIndex++] = line.toCharArray();
            line = reader.readLine();
        }
        return maze;
    }
}
