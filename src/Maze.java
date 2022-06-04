

public class Maze {
  private int boardSize;
  private int startPosition;
  private String mirrorPositions;
  private int[][] board;



  public Maze(int boardSize,int startPosition)
  {
    this.boardSize=boardSize;
    this.startPosition=startPosition;
  }


  public void setBoardSize(int boardSize) {
    this.boardSize = boardSize;
  }

  public void setStartPosition(int startPosition) {
    this.startPosition = startPosition;
  }

  public int getBoardSize() {
    return boardSize;
  }

  public int getStartPosition() {
    return startPosition;
  }
}
