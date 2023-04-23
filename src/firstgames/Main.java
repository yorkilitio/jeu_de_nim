package firstgames;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main{
  public static void main(String []args){

    Player player1 = new Player("Samuel");
    Player player2 = new Player("Fred");

    TicTacToe game1 = new TicTacToe(player1,player2);

    game1.execute(0);
    game1.execute(2);
    game1.execute(4);
    game1.execute(1);
    game1.execute(8);

    System.out.println(game1.getWinner());
  }
}
