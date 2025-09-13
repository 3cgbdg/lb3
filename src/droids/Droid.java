package droids;

import battlelog.BattleLog;

public abstract class Droid {
      final  String name ;
      String abilityName ;
      float health ;
    float damage;
    float defendDamage;
    float reloadTime ;
     Integer teamIdx= null;
      boolean inTeam = false;
    public String getName (){
        return name;
    }
    public float getHealth (){
        return health;
    }
    public String getAbilityName(){
        return abilityName;
    }
     public boolean isInTeam (){
         return inTeam;
     }
     public void leaveTeam (){
         inTeam  = false;
         teamIdx=null;
     }
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
     public float getDamage (){
        return damage;
    }
    public boolean isAlive(){
        return health>0;
    }

     public float getReloadTime() {
         return reloadTime;
     }



    abstract void  useAbility ();





}
