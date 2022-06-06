package maze;

public class Mirror {
  private  int[] neighbor=new int[4];
  private int x;
  private int y;

  public void setX(int x) {
    this.x = x;
  }

  public int getX() {
    return x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getY() {
    return y;
  }



  public void addNeighbor(int position,int value)
  {
    this.neighbor[position]=value;
  }
  public int getNeighbor(int position)
  {
    return this.neighbor[position];
  }
}
