public class Protagonist{
  private int health; //just a default num
  private int str;
  private int precision;
  private String heroName;
  private int ac;
  private boolean special;

  public Protagonist(String name){
    heroName = name;
    str = modifier();
    precision = modifier();
    health = 30 + modifier();
    ac = 14 + modifier();
  }

  public String getName(){
    return heroName;
  }

  public int rollDie(int sideNum){
    return (int) (Math.random() * sideNum) + 1;
  }

  public int modifier(){
    return (int) (Math.random() * 5);
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

  public int getAC(){
    return ac;
  }

  public boolean specialize(){
    special = true;
    return special;
  }

  public boolean normalize(){
    special = false;
    return special;
  }

  public int attack(Monster m){
    int damage = 0;
    if (!special){
      if (rollDie(20) > m.getAC()){
        damage = rollDie(10) + str;
      }
    } else{
      if (rollDie(20) > m.getAC()){
        damage = (rollDie(10) + str) * 2;
      }
    }
    m.takeDamage(damage);
    return damage;
  }


}
