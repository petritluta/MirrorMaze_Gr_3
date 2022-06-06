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

  private void addInput(char symbol,int i,int j)
  {
    grid[i][j]=symbol;
    if(symbol == '/' || symbol=='\\')
    {
      this.mirror_sum++;
      mirror_num[i][j]=mirror_sum;
      mirrors[mirror_sum]=new Mirror();
      mirrors[mirror_sum].setX(i);
      mirrors[mirror_sum].setY(j);
      state[mirror_sum]=(grid[i][j]=='\\');
    }
    else if ((i == N || j == M || i== 1 || j == 1) && symbol == '.')
    {
      mirror_num[i][j]=-1;
    }
  }


  public void solve()
  {
    final int[] dx={-1,0,1,0};
    final int[] dy={0,-1,0,1};
    int  first_mirror=-1,first_direction=-1;

    for (int i = 1,x,y; i <=mirror_sum ; i++) {
      for (int j = 0; j <=3 ; j++) {
        if (mirrors[i].getNeighbor(j) != 0) continue;


        x=mirrors[i].getX();
        y=mirrors[i].getY();


        while (true)
        {
          x=x+dx[j];
          y=y+dy[j];
          assert(x >= 1 && x <= N && y >= 1 && y <= M);
          if(grid[x][y]=='*')break;
          if(mirror_num[x][y] == -1)
          {
            mirrors[i].addNeighbor(j, -1);
            first_mirror=i;
            first_direction=j;
            break;
          }
          if(mirror_num[x][y] > 0)
          {
            mirrors[i].addNeighbor(j,mirror_num[x][y]);
            mirrors[mirror_num[x][y]].addNeighbor((j+2)%4,i);
            break;
          }
        }
      }
    }

    if (first_direction !=-1 && first_mirror!=-1)
    {
      boolean flag= depthFirstSearch(first_mirror,first_direction);
      assert flag;
    }

    printMaze();

  }




  public int[] getNext(int i,int j)
  {

    int[] d=new int[4];

    if(!state[i])
    {
      d[0]=1;
      d[1]=0;
      d[2]=3;
      d[3]=2;
    }
    else{
      d[0]=3;
      d[1]=2;
      d[2]=1;
      d[3]=0;
    }

    int[] next=new int[2];

    next[1]=(d[j]+2)%4;
    next[0]=mirrors[i].getNeighbor(d[j]);


    return  next;
  }


  public void printMaze() {
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= M; j++)
        if (mirror_num[i][j] == 0 || mirror_num[i][j] == -1) System.out.print(grid[i][j]);
        else System.out.print(state[mirror_num[i][j]] ? '\\' : '/');
      System.out.println();
    }
  }
  public void setM(int m) throws  RuntimeException {
    if(m <=MAX_COLS)
      this.M = m;
    else
      throw new RuntimeException("Invalid input");
  }

  public void setN(int n) {
    if(n <= MAX_ROWS)
      this.N=n;
    else
      throw new RuntimeException("Invalid input");
  }

}

