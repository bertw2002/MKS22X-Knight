public class driver{
  public static void main(String[] args){
    KnightBoard board = new KnightBoard(10, 10);
    System.out.println(board);
    System.out.println(board.solve(0, 0));
  }
}
