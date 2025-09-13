package droids;

import battlelog.BattleLog;
import interfaces.Fighter;

public class SniperDroid extends Droid implements Fighter {
    final private float  accuracy = .9f;
   public  SniperDroid(String name){
        super(name,"Critical shot",450f,125f,40f);
    };
    @Override
    void useAbility() {
        double randomNum = Math.random();
        if(randomNum>= 0.90f){
            damage = 175f;
            System.out.format("%s Used ability '%s'\n",name,abilityName);

        }
    }
     public void fight(Droid droid){
//         checking available abilities
        droid.useAbility();
        this.useAbility();
        boolean isShot = Math.random() <accuracy;
        if(isShot){
            health=Math.max(0, health-droid.defendDamage);
            droid.health =Math.max(0, droid.health-damage);
            BattleLog.add(String.format("[%s: -%.2f  | %s: -%.2f]---REMAINED HP[%s:%.2f, %s:%.2f]  %s",
                    this.name,this.damage,droid.name,droid.defendDamage ,name,health,droid.name,droid.health,(droid.health==0 ? "KILLED":"")));
        }else{
            BattleLog.add(String.format("%s missed the shot at %s",
                    this.name,droid.name));
        }


    }
}
