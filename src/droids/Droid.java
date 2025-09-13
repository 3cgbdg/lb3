package droids;

import battlelog.BattleLog;
//abstract class for Droids
public abstract class Droid {
      final  String name ;
      String abilityName ;
      float health ;
    float damage;
    float defendDamage;

     Integer teamIdx= null;
      boolean inTeam = false;
//      getters
    public String getName (){
        return name;
    }
    public float getHealth (){
        return health;
    }
    public String getAbilityName(){
        return abilityName;
    }
    public float getDamage (){
        return damage;
    }

    //checkers
     public boolean isInTeam (){
         return inTeam;
     }
    public boolean isAlive(){
        return health>0;
    }
     //method for leaving team after fight
     public void leaveTeam (){
         inTeam  = false;
         teamIdx=null;
     }
     //joining team
    public void joinTeam (int idx){
        teamIdx=idx;
        inTeam=true;
    }
    Droid(String name,String abilityName,float health,float damage,float defendDamage){
        this.name=name;
        this.abilityName=abilityName;
        this.health=health;
        this.damage=damage;

        this.defendDamage=defendDamage;
    };




    abstract void  useAbility ();



}
