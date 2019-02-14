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
    board = new int[startingRows][startingCols];
    //throws exception if row/col less than or equal to zero.
    if (startingRows <= 0 || startingCols <= 0){
      throw new IllegalArgumentException();
    }
    startRow = startingRows;
    startCol = startingCols;
    //initializes board values to 0.
    clear();
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
    return solveHelper(startingRow, startingCol, 1, 0);
  }
  //checks if move isn't out of bounds.
  public boolean isValid(int row, int col){
    if (row < 0 || col < 0 || row > startRow|| col > startCol){
      return false;
    }
    return true;
  }
  //helper for solve.
  //whichMove makes sure knight doesn't repeat the same deadends.
  public boolean solveHelper(int startingRow, int startingCol, int level, int whichMove){
    if (level == startingRow * startingCol + 1){
      return true;
    }
    if (level == 1 && whichMove == 8){
      clear();
      return false;
    }
    board[startingRow][startingCol] = level;
    //sets the next spot where the knight is going to go.
    int x = -1;
    int y = -1;
    if (isValid(startingRow + 2, startingCol + 1)){
      //if this move didn't work before, code makes sure it doesn't happen again.
      if (whichMove < 1){
        x = startingRow + 2;
        y = startingCol + 1;
        board[x][y] = level;
        return solveHelper(x, y, level + 1, 0);
      }

    }
    if (isValid(startingRow - 2, startingCol + 1)){
      if (whichMove < 2){
        x = startingRow - 2;
        y = startingCol + 1;
        board[x][y] = level;
        return solveHelper(x, y, level + 1, 0);
      }

    }
    if (isValid(startingRow + 2, startingCol - 1)){
      if (whichMove < 3){
        x = startingRow + 2;
        y = startingCol - 1;
        board[x][y] = level;
        return solveHelper(x, y, level + 1, 0);
      }

    }
    if (isValid(startingRow - 2, startingCol - 1)){
      if (whichMove < 4){
        x = startingRow - 2;
        y = startingCol - 1;
        board[x][y] = level;
        return solveHelper(x, y, level + 1, 0);
      }

    }
    if (isValid(startingRow + 1, startingCol + 2)){
      if (whichMove < 5){
        x = startingRow + 1;
        y = startingCol + 2;
        board[x][y] = level;
        return solveHelper(x, y, level + 1, 0);
      }

    }
    if (isValid(startingRow - 1, startingCol + 2)){
      if (whichMove < 6){
        x = startingRow - 1;
        y = startingCol + 2;
        board[x][y] = level;
        return solveHelper(x, y, level + 1, 0);
      }

    }
    if (isValid(startingRow + 1, startingCol - 2)){
      if (whichMove < 7){
        x = startingRow + 1;
        y = startingCol - 2;
        board[x][y] = level;
        return solveHelper(x, y, level + 1, 0);
      }

    }
    if (isValid(startingRow - 1, startingCol - 2)){
      if (whichMove < 8){
        x = startingRow - 1;
        y = startingCol - 2;
        board[x][y] = level;
        return solveHelper(x, y, level + 1, 0);
      }

    }
    //if nothing valid, backtrack.
    board[startingRow][startingCol] = 0;
    return solveHelper(startingRow, startingCol, level, whichMove + 1);
  }
}
