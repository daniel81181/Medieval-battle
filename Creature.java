import javax.swing.*;
public class  Creature{
  private int pX;
  private int pY;
  private int strength;
  private int magic;
  private float life;
  private boolean alive;
  private float damageDone;
  private float damageReceived;
  private int hord;

  public Creature(){
    pX=(int)(Math.random()*100);
    pY=(int)(Math.random()*100);
    strength=0;
    magic= 0;
    life=0;
    alive=true;
    damageDone=0f;
    damageReceived=0f;
    hord=0;

  }
  public void setDD(float m){
   damageDone=m;
  }
public void setLi(float l){
  life=l;
}

  public int getPX(){
    return pX;}


  public int getPY(){
    return pY;
  }

  public int getStrength(){

    return strength;
  }
public void setStrength(int k){
  strength=k;
}
  public int getMagic( ){
    return magic;
  }
  public void setMagic(int l ){
    magic=l;
  }
  public float getLife(){
    return life;
  }

public void setPX(int n){
  pX=n;

}
public void setPY(int n){
  pY=n;


}
  public float getDamageDone(){
   return damageDone;
   }
   public void setLife(float n){
    damageReceived= life-n;
     life=n;

   }
   public float getDamageReceived(){
     return damageReceived;
   }
   public void setDamageReceived(float d){
     damageReceived=d;

   }
public boolean isAlive(){
  if(life<=0){
    alive=false;
    return false;
}
return true;

}

public void movePX(){
  int x=(int)(Math.random()*4+2);
 if((pX+x)> 100){pX=pX-x;}
  else{if((pX-x)<0 ||(pX+x)<=100){pX=pX+x;}
  }
}
public void movePY(){
  int y=(int)(Math.random()*4+2);
  if((pY+y)> 100){pY=pY-y;}
  else{if((pY-y)<0 ||(pY+y)<=100){pY=pY+y;}

   }
}

public void setHord(int h){
  hord=h;
}
public int  getHord(){
  return hord;
}
}
