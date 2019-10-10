public class Prueba{
Creature[] elfsAl=new Elf[3];
Item[] amuletal=new Amulet[2];
HordeCreatures[] helfs= new HordeCreatures[3];

public void gettingHordes(HordeCreatures a,HordeCreatures d,Creature b, Creature c){
a.setMembers(c);

int cX=c.getPX();
int cY=c.getPY();

a.setcentroidpX(cX);
a.setcentroidpY(cY);
d.setExist(false);

b.setPX(a.getPX());c.setPX(a.getPX());
b.setPY(a.getPY());c.setPY(a.getPY());

}
public float distancebwCreatures(Creature a,Creature b){
  int x =a.getPX()-b.getPX();
  int y =a.getPY()-b.getPY();
  return (int)(Math.sqrt((x*x)+(y*y)));

}
  public void printmn(){
    int mx=elfsAl[0].getPX();
    int my=elfsAl[0].getPY();
System.out.println(mx+","+my);
    elfsAl[1].setPX(mx-1);
    elfsAl[1].setPY(my-1);
    elfsAl[2].setPX(mx+2);
    elfsAl[2].setPY(my+2);

    System.out.println(elfsAl[1].getPX()+","+elfsAl[1].getPY());
    System.out.println(elfsAl[2].getPX()+","+elfsAl[2].getPY());


    for(int i=0;i<elfsAl.length-1;i++){
      for(int j=i+1;j<elfsAl.length;j++){
     float d= distancebwCreatures(elfsAl[i],elfsAl[j]);

    if(d<5)
    {     System.out.println(i+","+j);
    int horda=elfsAl[i].getHord();
    int h=elfsAl[j].getHord();
    gettingHordes(helfs[horda],helfs[h],elfsAl[i],elfsAl[j]);
    elfsAl[j].setHord(horda);
System.out.println(elfsAl[j].getHord());

      }

    }
  }
  System.out.println(helfs[0].getNMembers());
  System.out.println(elfsAl[0].getPX()+","+elfsAl[0].getPY());
  System.out.println(elfsAl[1].getPX()+","+elfsAl[1].getPY());


  }




  public void battle(){
    for(int i=0;i<helfs.length;i++){
    helfs[i]=new HordeCreatures();
    }
  for(int i=0;i<elfsAl.length;i++){elfsAl[i]=new Elf();
  elfsAl[i].setHord(i);
  helfs[i].setMembers(elfsAl[i]);
  helfs[i].setcentroidpX(elfsAl[i].getPX());
  helfs[i].setcentroidpY(elfsAl[i].getPY());

  }
printmn();
  }
  public static void main(String args[]){
    Prueba c = new Prueba();
    c.battle();
  }

}
