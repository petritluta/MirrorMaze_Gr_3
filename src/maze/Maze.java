package maze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
  private final int MAX_ROWS = 50;
  private final int MAX_COLS = 50;

  private int M;
  private int N;
  private int mirror_sum;
  private final char[][] grid = new char[MAX_ROWS][MAX_COLS];
  private final Mirror[] mirrors = new Mirror[MAX_ROWS * MAX_COLS];
  private final int[][] mirror_num = new int[MAX_ROWS][MAX_COLS];
  private final boolean[] state = new boolean[MAX_COLS * MAX_ROWS];
  private final boolean[] used = new boolean[MAX_COLS * MAX_ROWS];

  public Maze() {
    try {
      this.constructMaze();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public Maze(String filename) {
    try {
      this.constructMaze(filename);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  private void constructMaze() throws RuntimeException {
    Scanner input = new Scanner(System.in);

    System.out.print("Number of columns:");
    this.setM(input.nextInt());
    System.out.println();
    System.out.print("Number of rows:");
    this.setN(input.nextInt());
    System.out.println();

    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++) {
        grid[i][j] = input.next().charAt(0);
        addInput(grid[i][j], i, j);
      }
    }
  }


  public void printMaze() {
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++)
        if (mirror_num[i][j] == 0 || mirror_num[i][j] == -1) System.out.print(grid[i][j]);
        else System.out.print(state[mirror_num[i][j]] ? '\\' : '/');
      System.out.println();
    }
  }
}

