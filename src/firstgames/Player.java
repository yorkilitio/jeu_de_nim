package firstgames;

public class Player{
  String name;


  public Player(String name){
    this.name = name;
  }

  public String toString(){
    return "["+this.name+"]";
  }

  public String getName(){
    return this.name;
  }
}
