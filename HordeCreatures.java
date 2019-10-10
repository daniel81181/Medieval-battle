import javax.swing.*;
public class HordeCreatures{

Creature[] members=new Creature[5];

  private int pX;
  private int pY;
  private int nMembers;
  private boolean exist;



  public HordeCreatures(){
    pX=0;
    pY=0;
    nMembers=0;
    exist=true;

}

public void setMembers(Creature l){
  for(int i=0;i<members.length;i++){
     if(null == members[i]){
       members[i]=l;
       nMembers+=1;
       return;
     }
}
}

public boolean isIthere(Creature a){
for(int i=0;i<members.length;i++){
  if(a==members[i]){
    return true;
  }
}
  return false;
}
public int getNMembers(){
  return nMembers;
}
public void setNMembers(int l){
  nMembers=nMembers-l;
}
public void setcentroidpX(int m){
pX=pX+m;
pX=(int)(pX/nMembers);

}
public void setcentroidpY(int j){
  pY=pY+j;
  pY=(int)(pY/nMembers);


}
public void setExist(boolean a){
  exist=a;
}



public Creature getPlayer(int m){

  return members[m];
}
public Creature lastMember(){
  return members[nMembers];
 }
public int getPX(){
  return pX;
}
public int getPY(){
  return pY;
}
}
