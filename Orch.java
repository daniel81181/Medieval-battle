
  import javax.swing.*;

  public class Orch extends Creature{


    public Orch(){
      int s=(int)(Math.random()*90+50);
      int m=(int)(Math.random()*9+1);
  this.setStrength(s);
  this.setMagic(m);
  this.setLi((int)(Math.random()*500+1500));
  this.setDD((s*.8f )+ (m*.2f));
    }

}
