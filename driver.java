public class driver{
  public static void main(String[] args){
    KnightBoard board = new KnightBoard(5, 5);
    System.out.println(board);
    System.out.println(board.solve(3, 3));
    System.out.println(board);
  }
}
