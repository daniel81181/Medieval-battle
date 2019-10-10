public class Item{

  public int pX;
  public int pY;
  public int strength;
  public int magic;
  public boolean alive;

public Item(){
  pX=(int)(Math.random()*100);
  pY=(int)(Math.random()*100);
  strength=0;
  magic=0;
  alive=true;

}
public void setStrength(int m){
  strength=m;
}
public void setMagic(int ma){
  magic=ma;
}
public int getPX(){
  return pX;
}
public int getPY(){
  return pY;
}

public boolean isAlive(){
  if (alive==true){
    return true;
  }
  magic=0;
return false;

 }
 public int getMagicElf(){
   alive=false;
   return magic;

 }
 public void setMagicOrch(){
 magic=0;
 alive=false;
 }
 public int getStrengthOrch(){
    alive=false;
   return strength;

 }
 public int getStrengtheElf(){
 strength=strength-20;
 alive=false;
 return strength;
 }
}
