public class KnightBoard{
  private int startRow;
  private int startCol;
  private int[][] board;
  public KnightBoard(int startingRows, int startingCols){
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalArgumentException();
    }
    startRow = startingRow;
    startCol = startingCols;
    for (int x = 0; x < startRow; x++){
      for (int y = 0; y < startCol; y++){
        board[x][y] = 0;
      }
    }
  }
  public String toString(){
    String str = "";
    for (int x = 0; x < startRow; x++){
      for (int y = 0; y < startCol; y++){
        if (board[x][y] == 0){
          str += " _";
        }else{
          str += " " + board[x][y];
        }
      }
      str += "\n";
    }
    return str;
  }
}
