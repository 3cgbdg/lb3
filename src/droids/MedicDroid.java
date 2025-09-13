package droids;

import game.Game;
import interfaces.Fighter;
import interfaces.Healer;
import team.Team;

import java.util.List;
//medic interface + abstract droid

public class MedicDroid extends Droid implements Healer {
   public MedicDroid(String name){
        super(name,"Heal Splash",100f,0f,0f);
    };
    @Override
        //method for using ability
    void useAbility() {
        double randomNum = Math.random();
        //<10% to use this ability
        if(randomNum>= 0.90f){
            List<Droid> team = Game.getTeams()[teamIdx].getDroids();
            int randIdx = (int)(Math.random() * (team.size()-1));
            team.get(randIdx).health +=500;
            System.out.format("%s Used ability '%s'\n",name,abilityName);

        }
    }
//    healing ur teamate - +50hp
    public void heal(){
        List<Droid> team = Game.getTeams()[teamIdx].getDroids();
        //getting random idx of teammember to heal
        int randIdx = (int)(Math.random() * (team.size()-1));
        useAbility();
        team.get(randIdx).health +=50;
    }
}
