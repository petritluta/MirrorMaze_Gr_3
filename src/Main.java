import maze.Maze;

public class Main {


  public static void main(String [] args){
      Maze maze=new Maze("./config/maze.txt");
      maze.printMaze();
      System.out.println();
      maze.solve();
  }
}
