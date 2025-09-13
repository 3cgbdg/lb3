package droids;

import battlelog.BattleLog;
import fight.Fight;
import interfaces.Fighter;
//fighter interface + abstract droid
public class AssaultDroid extends Droid implements Fighter {
    final private float accuracy = .7f ;
    public AssaultDroid(String name){
        super(name,"Berserk",600f,75f,25f);

    };
    //method for using ability
    @Override
    void useAbility() {
        if(health < 180){
        damage*= 1.5f;
        System.out.format("%s Used ability '%s'\n",name,abilityName);
        }
    }
//    method to fight
    public void fight(Droid droid){
//         checking available abilities
        droid.useAbility();
        this.useAbility();
        boolean isShot = Math.random() <accuracy;
        //if not missed shot making logic
        if(isShot){
            //if less than 0 than 0
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
