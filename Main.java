import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner SCAN = new Scanner(System.in);
    System.out.println(Connect4.getDirections());//static
    Connect4 c4 = new Connect4();
    while(true){
      System.out.println(c4.getBoard());
      System.out.println(c4.getTurnPrompt());
      c4.takeTurn(SCAN.nextLine());
      String gameOverCheck = c4.getGameOver();
      if(gameOverCheck != null){
        System.out.println(c4.getBoard());
        System.out.println(gameOverCheck);
        System.out.println("Would you like to play again? Enter Q to quit or anything else to play again.");
        if(SCAN.nextLine().equalsIgnoreCase("Q")){
          return;
        }
        c4 = new Connect4();
      }
    }
  }
}