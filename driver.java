public class driver{
  public static void main(String[] args){
    KnightBoard board = new KnightBoard(5, 5);
    System.out.println(board.solve(0, 1));
    System.out.println(board);
    KnightBoard board1 = new KnightBoard(3, 4);
    System.out.println(board1.countSolutions(0, 0));
  }
}
