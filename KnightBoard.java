public class KnightBoard{
  private int startRow;
  private int startCol;
  private int[][] board;
  //helper that clears the board.
  private void clear(){
    for (int x = 0; x < startRow; x++){
      for (int y = 0; y < startCol; y++){
        board[x][y] = 0;
      }
    }
  }

  //constructor
  public KnightBoard(int startingRows, int startingCols){
    //throws exception if row/col less than or equal to zero.
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalArgumentException();
    }
    startRow = startingRow;
    startCol = startingCols;
    //initializes board values to 0.
    clear();
  }board[x][y] = 0;

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
  //helper that checks if board is clear.
  private boolean isClear(){
    for (int x = 0; x < startRow; x++){
      for (int y = 0; y < startCol; y++){
        if (board[x][y] != 0){
          return false;
        }
      }
    }
    return true;
  }
  public boolean solve(int startingRow, int startingCol){
    //is the board clear?
    if (isClear()){
      throw new IllegalStateException();
    }
    //if bad parameter value.
    if (startingRow < 0 || startingCol < 0 ||startingRow > startRow || startingCol > startCol){
      throw new IllegalArgumentException();
    }

  }
}
