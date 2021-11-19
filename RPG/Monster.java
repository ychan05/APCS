public class Monster{
  private int health; //just a default num
  private int str;
  private int precision;
  private int ac;

  public Monster(){
    str = modifier();
    precision = modifier();
    health = 15 + modifier();
    ac = 10 + modifier();
  }

  public int rollDie(int sideNum){
    return (int) (Math.random() * sideNum) + 1;
  }

  public int modifier(){
    return (int) (Math.random() * 4);
  }

  public int getAC(){
    return ac;
  }

  public boolean isAlive(){
    return health > 0;
  }

  public int getHP(){
    return health;
  }
  public void takeDamage(int d){
    health -= d;
  }

  public int attack(Protagonist p){
    int damage = 0;
    if (p.normalize()){
      if (rollDie(20) > p.getAC()){
        damage = rollDie(6) + str;
      }
    } else if (p.specialize()){
      if (rollDie(20) > p.getAC()){
        damage = (rollDie(6) + str) * 2;
      }
    }
    p.takeDamage(damage);
    return damage;
  }


}
