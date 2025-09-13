package fight;

import droids.Droid;
import team.Team;
//abstracts for Fights
public abstract class Fight {
     Team team1;
     Team team2;

    public  Fight(Team t1,Team t2){
        this.team1=t1;
        this.team2=t2;
    }
    public abstract void startFighting () throws InterruptedException;


}
