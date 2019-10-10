public class Daniel{
Creature[] elfsAll=new Elf[5];
Creature[] orchsAll=new Orch[5];
Elixir[] elixirAll=new Elixir[3];
Item[] amuletAll=new Amulet[3];
Item[] weaponAll=new Weapon[3];
HordeCreatures[] hordesElfs= new HordeCreatures[5];
HordeCreatures[] hordesOrchs= new HordeCreatures[5];

//elixir Creaturas
public boolean elixirCreatures(Creature a,Elixir b){
  if(a.getPX()==b.getPX() && a.getPY()==b.getPY()){
  return true;}
  return false;
}
//pelea uno a uno
public void fightOnebyOne(Creature a,Creature b,int c,int d){
if(a.isAlive()==true && b.isAlive()==true){
  float le= a.getLife()-b.getDamageDone();
  float lo= b.getLife()-a.getDamageDone();
  a.setLife(le);
  b.setLife(lo);
  if(le>lo){System.out.println("El elfo"+(c+1)+"gano la pelea");}
  if(lo>le){System.out.println("El orco"+(d+1)+"gano la pelea");}

  a.isAlive();
  b.isAlive();

}}
//verificar que minimo vive uno de cada uno
public boolean isCreaturesAlive(){
  int lo=0;
  int l=0;
for(int i=0;i<elfsAll.length;i++){
 if(elfsAll[i].isAlive()==true){lo+=1;}}
for(int j=0;j<orchsAll.length;j++){
  if(orchsAll[j].isAlive()==true){l+=1;}}
  if(l>0 && lo>0 ){return true;}
  return false;
}
//si hay cualquier item
public int isThereItem(Creature a, Item b){
  int x =a.getPX()-b.getPX();
  int y =a.getPY()-b.getPY();
  return (int)(Math.sqrt((x*x)+(y*y)));
}//distancia de creaturas
public float distancebwCreatures(Creature a,Creature b){
  int x =a.getPX()-b.getPX();
  int y =a.getPY()-b.getPY();
  return (int)(Math.sqrt((x*x)+(y*y)));

}
//imprimir posiciones
public void printPos(){
  for(int i=0;i<elfsAll.length;i++){
      int l= elfsAll[i].getPX();
      int m=elfsAll[i].getPY();
      System.out.println("El elfo "+(i+1)+" x en "+l+" y y en "+m);
    }
    for(int i=0;i<orchsAll.length;i++){
      int l= orchsAll[i].getPX();
      int m=orchsAll[i].getPY();
      System.out.println("El orco "+(i+1)+" x en "+l+" y y en "+m);
    }
}
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
public void moveHordes(){
  for(int i=0;i<hordesElfs.length;i++){
    int m=hordesElfs[i].getNMembers();
    for(int j=0;j<m;j++){
      (hordesElfs[i].getPlayer(j)).movePX();
      (hordesElfs[i].getPlayer(j)).movePY();

    }
  }
for(int i=0;i<hordesOrchs.length;i++){
    int m=hordesOrchs[i].getNMembers();
    for(int j=0;j<m;j++){
      (hordesOrchs[i].getPlayer(j)).movePX();
      (hordesOrchs[i].getPlayer(j)).movePY();

    }
  }
}

public void fight(){

  if(isCreaturesAlive()==true){
     printPos();
  //por si un elfo lo encuentra un amuleto
  for(int i=0;i<elfsAll.length;i++){
    for(int j=0;j<amuletAll.length;j++){
          float fE= isThereItem(elfsAll[i],amuletAll[j]);
          if(fE<=5 && amuletAll[j].isAlive()==true){
            int m =elfsAll[i].getMagic()+amuletAll[j].getMagicElf();
            elfsAll[i].setMagic(m);
          System.out.println("El elfo"+(i+1)+"encontro un amuleto y su magia aumento en"+elfsAll[i].getMagic());}}}

  //por si un orco encuentra un amuleto
  for(int i=0;i<orchsAll.length;i++){
    for(int j=0;j<amuletAll.length;j++){
      float fO= isThereItem(orchsAll[i],amuletAll[j]);
      if(fO<=5 && amuletAll[j].isAlive()==true){
        amuletAll[j].setMagicOrch();
        System.out.println("El orco"+(i+1)+"encontro un amuleto y lo destruyo");
      }
    }
  }

  //por si un orco encuentra una arma
  for(int i=0;i<orchsAll.length;i++){
    for(int j=0;j<weaponAll.length;j++){
    float fO= isThereItem(orchsAll[i],weaponAll[j]);
    if(fO<=5 &&weaponAll[j].isAlive()==true){
      int sO = weaponAll[j].getStrengthOrch()+orchsAll[i].getStrength();
      orchsAll[i].setStrength(sO);
      System.out.println("El orco"+(i+1)+"encontro una arma  y su fuerza aumento"+orchsAll[i].getStrength());
    }
  }
}

//por si un elfo encuentra una arma
for(int i=0;i<elfsAll.length;i++){
  for(int j=0;j<weaponAll.length;j++){
  float fO= isThereItem(elfsAll[i],weaponAll[j]);
  if(fO<=5 &&weaponAll[j].isAlive()==true){
    int sO = weaponAll[j].getStrengtheElf()+elfsAll[i].getStrength();
    elfsAll[i].setStrength(sO);
    System.out.println("El elfo"+(i+1)+"encontro una arma  y su fuerza aumento"+elfsAll[i].getStrength());
  }
}
}

//PARA ENCONTRAR HORDAS DE ELFOS


for(int i=0;i<elfsAll.length-1;i++){
  for(int j=i+1;j<elfsAll.length;j++){
 float d= distancebwCreatures(elfsAll[i],elfsAll[j]);
if(d<5)
{
int horda=elfsAll[i].getHord();
int h=elfsAll[j].getHord();
gettingHordes(hordesElfs[horda],hordesElfs[h],elfsAll[i],elfsAll[j]);
elfsAll[j].setHord(horda);
System.out.println("Se forma con la horda"+(horda+1)+"del elfo"+(i+1)+"con el elfo"+(j+1));
  }
}
}



//Para encontar hordas de  Orcos
for(int i=0;i<orchsAll.length-1;i++){
  for(int j=i+1;j<orchsAll.length;j++){
float d= distancebwCreatures(orchsAll[i],orchsAll[j]);
if(d<=5){
    int horda=orchsAll[i].getHord();
    int h=orchsAll[j].getHord();
     gettingHordes(hordesOrchs[horda],hordesOrchs[h],orchsAll[i],orchsAll[j]);
    orchsAll[j].setHord(horda);
    System.out.println("Se forma con la horda"+(horda+1)+"del orco"+(i+1)+"con el orco"+(j+1));

 }
}
}

   //peleas en todos los casos
  for(int i=0;i<elfsAll.length;i++){
    for(int j=0;j<orchsAll.length;j++){
      float distFig=distancebwCreatures(elfsAll[i],orchsAll[j]);
      if(distFig<=5){
        int hOrdE=elfsAll[i].getHord();
        int hOrdO=orchsAll[j].getHord();
          int mE= hordesElfs[hOrdE].getNMembers();
          int mO= hordesElfs[hOrdE].getNMembers();
          if(mE==mO){
            for(int l=0;l<mE;l++){
              fightOnebyOne(elfsAll[l],orchsAll[l],i,j);
            }
          }
          if(mE<mO){
            int restaMo=mO-mE;
            for(int l=0;l<restaMo;l++){
              fightOnebyOne(elfsAll[l],orchsAll[l],i,j);
            }
          }

          if(mO<mE){
            int restaMe=mE-mO;
            for(int l=0;l<restaMe;l++){
              fightOnebyOne(elfsAll[l],orchsAll[l],i,j);
            }
          }
      }
    }
  }

//Elixir si lo encuentra un elfo
for(int i=0;i<elfsAll.length;i++){
 for(int l=0;l<elixirAll.length;l++){
       boolean eL= elixirCreatures(elfsAll[i],elixirAll[l]);
       if(eL==true){
         float k = elfsAll[i].getDamageReceived();
          float o=elixirAll[l].getHeal(k);
         float lR= elfsAll[i].getLife()+o;
         elfsAll[i].setLife(lR);
         System.out.println("El elfo "+(i+1)+" encontro un elixir");}}}
//Elixir si lo encuentra un orco
for(int i=0;i<orchsAll.length;i++){
for(int l=0; l<elixirAll.length;l++){
  boolean oL= elixirCreatures(orchsAll[i],elixirAll[l]);
  if(oL==true){
    float k = elfsAll[i].getDamageReceived();
    float o=elixirAll[l].getHeal(k);
    float lR= elfsAll[i].getLife()+o;
    elfsAll[i].setLife(lR);
    System.out.println("El orco "+(i+1)+" encontro un elixir");}}}


moveHordes();

fight();

}


else{System.out.println("EL JUEGO TERMINO!!!");}
}

public void battle(){
  for(int i=0;i<hordesElfs.length;i++){hordesElfs[i]=new HordeCreatures();}
  for(int i=0;i<hordesOrchs.length;i++){hordesOrchs[i]=new HordeCreatures();}
for(int i=0;i<elfsAll.length;i++){elfsAll[i]=new Elf();
  elfsAll[i].setHord(i);
  hordesElfs[i].setMembers(elfsAll[i]);
}
for(int i=0;i<orchsAll.length;i++){orchsAll[i]=new Orch();
  orchsAll[i].setHord(i);hordesOrchs[i].setMembers(orchsAll[i]);}
for(int i=0;i<elixirAll.length;i++){elixirAll[i]=new Elixir();}
for(int i=0;i<amuletAll.length;i++){amuletAll[i]=new Amulet();}
for(int i=0;i<weaponAll.length;i++){weaponAll[i]=new Weapon();}

for(int i=0;i<elfsAll.length;i++){
  hordesElfs[i].setcentroidpX(elfsAll[i].getPX());
  System.out.println(hordesElfs[i].getPX());
  System.out.println(hordesElfs[i].getNMembers());

  hordesElfs[i].setcentroidpY(elfsAll[i].getPY());
}
for(int i =0;i<orchsAll.length;i++){
  hordesOrchs[i].setcentroidpX(orchsAll[i].getPX());
  hordesOrchs[i].setcentroidpY(orchsAll[i].getPY());
}
fight();

}
public static void main(String args[]){
  Daniel c = new Daniel();
  c.battle();
}
 }
