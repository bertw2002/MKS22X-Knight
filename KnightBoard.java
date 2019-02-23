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
    direction1 = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
    direction2 = new int[] {2, -2, 2, -2, 1, -1, 1, -1};
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
          if (board[x][y] < 10) str += "  " + board[x][y];
          else str += " " + board[x][y];
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
    board[startingRow][startingCol] = 1;
    return solveHelper(startingRow, startingCol, 2);
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
  private boolean solveHelper(int startingRow, int startingCol, int level){
    if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[0].length){
      return false;
    }
    if (level > board.length * board[0].length){
      return true;
    }
    for (int x = 0; x < direction1.length; x++){
      if (addKnight(startingRow + direction1[x], startingCol + direction2[x], level)){
        if (solveHelper(startingRow + direction1[x], startingCol + direction2[x], level + 1)){
          return true;
        }
        board[startingRow + direction1[x]][startingCol + direction2[x]] = 0;
      }
    }
    return false;
  }

  public int countSolutions(int startingRow, int startingCol){
    if (!isClear()) throw new IllegalStateException();
    if (startingRow < 0 || startingCol < 0 ||startingRow > startRow || startingCol > startCol){
      throw new IllegalArgumentException();
    }
    int sols = countHelper(startingRow, startingCol, 1);
    clear(); //clears before returning
    return sols;
  }
  private int countHelper(int startingRow, int startingCol, int level){
    //if index bad.
    if (startingRow < 0 || startingCol < 0 || startingRow >= board.length || startingCol >= board[0].length){
      return 0;
    }
    //not supposed to backtrack, return 0.
    if (board[startingRow][startingCol] != 0){
      return 0;
    }
    //if solved, return 1.
    if (level == board.length * board[0].length){
      return 1;
    }

    int solutions = 0;
    for (int x = 0; x < direction1.length; x++){
      board[startingRow][startingCol] = level;
      solutions += countHelper(startingRow + direction1[x], startingCol + direction2[x], level + 1);
      board[startingRow][startingCol] = 0;
    }

    return solutions;
  }
}
