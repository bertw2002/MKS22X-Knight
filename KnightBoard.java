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
  //checks if move isn't out of bounds.
  public boolean isValid(int row, int col){
    if (row < 0 || col < 0 || row > startingRow || col > startingCol){
      return false;
    }
    return true;
  }
  //helper for solve.
  public boolean solveHelper(int startingRow, int startingCol, int level){
    if (level == startingRow * startingCol){
      return true;
    }
    board[startingRow][startingCol] = level;
    //sets the next spot where the knight is going to go.
    int x = -1;
    int y = -1;
    if (isValid(startingRow + 2, startingCol + 1)){
      x = startingRow + 2;
      y = startingCol + 1;
    }
    //if nothing valid, backtrack.
    if (x == -1){
      board[startingRow][startingCol] = 0;
      //figure out how to not repeat the last step again.
      return solveHelper(startingRow, startingCol, level);
    }

    )
  }
}
