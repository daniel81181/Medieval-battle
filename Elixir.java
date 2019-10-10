public class Elixir{
private int pX;
private int pY;
private float heal;


public Elixir(){
pX=(int)(Math.random()*100);
pY=(int)(Math.random()*100);
heal=.5f;


}

public float getHeal(float dR){
  heal=heal*dR;
  return heal;
  }

public int getPX(){
  return pX;

}
public int getPY(){
  return pY;
}

}
