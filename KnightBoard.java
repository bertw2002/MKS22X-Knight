public class KnightBoard{
  private int startRow;
  private int startCol;
  private int[][] board;
  private int[] direction1;
  private int[] direction2;
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
    direction1 = new int[] {2,2,1,-1,1,-2,-2,-2};
    direction2 = new int[] {1,-1,2,2,-2,-2,-1,1};
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
    if (isClear()){
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
    }
    else{
      for (int x = 0; x < startRow; x++){
        for (int y = 0; y < startCol; y++){
          str += " " + board[x][y];
        }
        str += "\n";
      }
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
    if (!isClear()){
      throw new IllegalStateException();
    }
    //if bad parameter value.
    if (startingRow < 0 || startingCol < 0 ||startingRow > startRow || startingCol > startCol){
      throw new IllegalArgumentException();
    }
    return solveHelper(startingRow, startingCol, 1);
  }
  //checks if move isn't out of bounds.
  public boolean addKnight(int row, int col, int level){
    if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != 0){
      return false;
    }
    board[row][col] = level;
    return true;
  }

  //helper for solve.
  public boolean solveHelper(int startingRow, int startingCol, int level){
    if (level > startingRow * startingCol){
      return true;
    }
    if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[0].length){
      return false;
    }
    for (int x = 0; x < direction1.length; x++){
      if (addKnight(startingRow, startingCol, level)){
        if (solveHelper(startingRow + direction1[x], startingCol + direction2[x], level + 1)){
          return true;
        }
        board[startingRow][startingCol] = 0;
      }
    }

    return false;
  }


}
