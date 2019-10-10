import javax.swing.*;
public class Elf extends Creature{


  public Elf(){
    int s=(int)(Math.random()*30+20);
    int m=(int)(Math.random()*60+60);
this.setStrength(s);
this.setMagic(m);
this.setLi((int)(Math.random()*500+1500));
this.setDD((s*.8f )+ (m*.2f));
  }


}
