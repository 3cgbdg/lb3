package droids;

import game.Game;
import interfaces.Fighter;
import interfaces.Healer;
import team.Team;

import java.util.List;

public class MedicDroid extends Droid implements Healer {
   public MedicDroid(String name){
        super(name,"Heal Splash",100f,0f,0f);
    };
    @Override
    void useAbility() {
        double randomNum = Math.random();
        if(randomNum>= 0.90f){
            List<Droid> team = Game.getTeams()[teamIdx].getDroids();
            int randIdx = (int)(Math.random() * (team.size()-1));
            team.get(randIdx).health +=500;
            System.out.format("%s Used ability '%s'\n",name,abilityName);

        }
    }

    public void heal(){
        List<Droid> team = Game.getTeams()[teamIdx].getDroids();
        int randIdx = (int)(Math.random() * (team.size()-1));
        useAbility();
        team.get(randIdx).health +=50;
    }
}
