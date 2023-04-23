package firstgames;
import java.util.List;
import java.util.ArrayList;


public class TicTacToe{
  Player player1;
  Player player2;
  Player liveplayer;
  int player1moves;
  int player2moves;
  Player tab[][];

  public TicTacToe(Player player1, Player player2){
    this.player1 = player1;
    this.player2 = player2;
    this.liveplayer = player1;

    tab = new Player[3][3];

  }

  public String toString(){
    String res = "";
    for(int lig = 0; lig < 3; lig++){
      for(int col = 0; col < 3; col++){
        res+=" "+tab[lig][col];

      }
        res = res + "\n";
    }
    return res;
  }

  public String getCurrentPlayer(){
    return this.liveplayer.getName();
  }

  public void execute(int n){
    int ligne = n/3;
    int col = n-(ligne*3);
    tab[ligne][col] = this.liveplayer;

    if(this.liveplayer == this.player1){
      this.liveplayer = this.player2;
    }
    else{
      this.liveplayer = this.player1;
    }

  }

  public Boolean isValid(int n){
    int ligne = n/3;
    int col = n-(ligne*3);
    return (tab[ligne][col] == null);

  }

  public Integer returnCoup(int lig, int col){
    if(lig == 0 && col == 0){
      return 0;
    }
    else if(lig == 0 && col == 1){
      return 1;
    }
    else if(lig == 0 && col == 2){
      return 2;
    }
    else if(lig == 1 && col == 0){
      return 3;
    }
    else if(lig == 1 && col == 1){
      return 4;
    }
    else if(lig == 1 && col == 2){
      return 5;
    }
    else if(lig == 2 && col == 0){
      return 6;
    }
    else if(lig == 2 && col == 1){
      return 7;
    }
    else if(lig == 2 && col == 2){
      return 8;
    }else{
      return null;
    }
  }


  public ArrayList<Integer> validMoves(){
    ArrayList<Integer> list1 = new ArrayList<Integer>();

    for(int lig = 0 ;lig < 3;lig++){
      for(int col = 0;col < 3;col++){
        if(this.isValid(this.returnCoup(lig,col))){
          list1.add(this.returnCoup(lig,col));
        }
      }
    }
    return list1;
  }

  public Boolean wins(Player player, int row, int column, int deltaRow, int deltaColumn){
    return (this.tab[row][column]== player && this.tab[row+deltaRow][column+deltaColumn] == player && this.tab[row+(2*deltaRow)][column+(2*deltaColumn)] == player);
  }

  public Player getWinner(){
    Player winner;

    for (int row = 0;row <3;row++){
      if(this.wins(this.player1,row,0,0,1)){
        winner = this.player1;
      }
      else if(this.wins(this.player2,row,0,0,1)){
        winner = this.player2;
      }
      else{
        winner = null;
      }
    }

    for (int col = 0;col <3;col++){
      if(this.wins(this.player1,0,col,1,0)){
        winner = this.player1;
      }
      else if(this.wins(this.player2,0,col,1,0)){
        winner = this.player2;
      }
      else{
        winner = null;
      }
    }


    if(this.wins(this.player1,0,0,1,1)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,0,0,1,1)){
      winner = this.player2;
    }
    else{
      winner = null;
    }


    if(this.wins(this.player1,0,2,1,-1)){
      winner = this.player1;
    }
    else if(this.wins(this.player2,0,2,1,-1)){
      winner = this.player2;
    }
    else{
      winner = null;
    }

    return winner;

  }
}
