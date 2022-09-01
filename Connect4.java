public class Connect4{
  private int[][] board; //instance fields are private, not static. give it a type, give it a name. initialize in constructor
  private int turn;

  public static final int P1 = 1;
  public static final int P2 = -1;

  public Connect4() {
    this.board = new int[6][7];
    this.turn = P1;
  }

  public String getGameOver(){
    //vertical win
    for(int col = 0; col < board[0].length; col++){
      for(int row = 0; row < 3; row++){
        int sum = board[row][col] + board[row+1][col] + board[row+2][col] + board[row+3][col];
        if(sum == 4 * P1) return "Player 1 wins";//4
        if(sum == 4 * P2) return "Player 2 wins";//-1
      }
    }
    //horizontal win
    for(int[] row : board){
      for(int col = 0; col < 4; col++){
        int sum = row[col] + row[col + 1] + row[col + 2] + row[col+3];
        if(sum == 4) return "Player 1 wins";
        if(sum == -4) return "Player 2 wins";
      }
    }
    //diagonal win
    for(int row = 0; row < 3; row++){
      for (int col = 0; col < 4; col++){
        //INCOMPLETE

      }
    }
    //fill up board
    return "draw";
  }

  public String getTurnPrompt(){
    int player = turn;
    if(player == P2) player = 2;
    return "Player " + player + " please enter a column from 1-7 that has space available";
  }

  public static String getDirections(){
    return "Connect Four is a game... I didn't go to wikipedia like I was supposed to. I hope you know how to play. Get 4 in a row.";
  }

  //we want a column number 1-7 and we start at bottom of the column and loop towards the top to find the first empty spot to put token in
  public void takeTurn(String input){
    if(input.compareTo("1") < 0 || input.compareTo("7") > 0 || input.length() != 1){
      return;
    }
    int col = Integer.parseInt(input) -1;//bc user is operating 1-7 not 0-6
    for(int row = board.length - 1; row > -1; row--){
      if(board[row][col] == 0){
        board[row][col] = turn;
        turn *= -1;
        return;
      }
    } 
    

  }

  public String getBoard(){
    //insert joke about connect 4 getting you bored
    String toReturn = "";
    for(int[] row : board){
      toReturn += "------------------------------\n| ";
      for(int token : row){
        if(token == -1) token = 2;
        toReturn += token + " | ";
      }
      toReturn += "\n";
    }
    toReturn += "------------------------------\n\n";
    return toReturn;
  }



}