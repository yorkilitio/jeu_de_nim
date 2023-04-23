package firstgames;
import java.util.Scanner;

public class Nim{
  int startSize;
  int maxNum;
  Player player1;
  Player player2;
  int liveNum;
  Player liveplayer;
  Scanner scanner = new Scanner(System.in);


  public Nim(int startSize, int maxNum, Player player1, Player player2){
    this.startSize = startSize;
    this.maxNum = maxNum;
    this.player1 = player1;
    this.player2 = player2;
    this.liveNum = startSize;
    this.liveplayer = player1;
  }

  public String toString(){
    String res=  "taille initiale du tas: "+this.startSize+ "\nnombre maximal d'allumettes: "+this.maxNum+ "\njoueur 1: "+this.player1+ "\njoueur 2: "+this.player2;
    res +=  "\nnombre courant d'allumettes: "+this.liveNum+ "\nle joueur courant: "+this.liveplayer.getName();
    return res+"\n";

  }

  public  int getInitailNbMatches(){
    return this.startSize;
  }

  public  int getCurrentNbMatches(){
    return this.liveNum;
  }

  public  String getCurrentPlayer(){
    return "c'est le tour de "+this.liveplayer.getName();
  }

  public String situationToString(){
    return "il reste "+this.liveNum+" allumettes";
  }

  public void removeMatches( int num){
    if (num <= this.maxNum){
      this.liveNum = this.liveNum-num;
      if (this.liveplayer == this.player1){
        this.liveplayer = this.player2;
      } else{
        this.liveplayer = this.player1;
      }
    }

  }

  public boolean isValid(int num){
    return (num <= this.maxNum && num <= this.liveNum);
  }

  public boolean isOver(){
    return(this.liveNum == 0);
  }

  public String getWinner(){
    if(this.isOver()){
      if(this.liveplayer == this.player1){
        return this.player2.getName()+" a gagné";
      }
      else{
        return this.player1.getName()+" a gagné";
      }
    }
    else {
      return null;
    }
  }


public int saisirCoup(){
  System.out.println("saisir un coup:");
  int coup = Integer.parseInt(scanner.next());
  while(!this.isValid(coup)){
    System.out.println("le coup est invalide, saisir un autre coup:");
    coup = Integer.parseInt(scanner.next());
  }
  return coup;
}

  public void jouer(){
    System.out.println(this);
    while(!this.isOver()){
      int num = saisirCoup();
      this.removeMatches(num);
      System.out.println(this.getCurrentPlayer()+"\n");
    }
    System.out.println(this.getWinner());
    System.out.println(this.situationToString());
  }

}
