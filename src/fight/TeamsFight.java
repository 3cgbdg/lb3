package fight;

import droids.Droid;
import interfaces.Fighter;
import interfaces.Healer;
import team.Team;

public class TeamsFight extends Fight{

    public TeamsFight(Team t1, Team t2) {
        super(t1, t2);
    }

    @Override
    public void startFighting () throws InterruptedException {
        int randIdxTeam1 = 0;
        int randIdxTeam2 = 0;
        int turn = 0;
//        if some of the teams are dead -fight ends

        while(team1.isAlive() && team2.isAlive()){
//            turn 0 - team 1 , turn 0 team 2

            turn = (int)(Math.random()*2);
             randIdxTeam1 = (int)(Math.random()* team1.getDroids().size());
             randIdxTeam2 = (int)(Math.random()* team2.getDroids().size());

            Droid activeDroid1= team1.getDroids().get(randIdxTeam1);
            Droid activeDroid2 = team2.getDroids().get(randIdxTeam2);
            if(turn == 0 ){
                while(!activeDroid1.isAlive()){
                    activeDroid1= team1.getDroids().get((int)(Math.random()* team1.getDroids().size()));
                }
                //checking interfaces

                if(activeDroid1 instanceof Healer healer){
                    healer.heal();

                }
                if(activeDroid1 instanceof Fighter fighter){
                    fighter.fight(activeDroid2);

                }
            }else{
                while(!activeDroid2.isAlive()){
                    activeDroid2= team2.getDroids().get((int)(Math.random()* team2.getDroids().size()));
                }
                //checking interfaces
                
                if(activeDroid2 instanceof Healer healer){
                    healer.heal();

                }
                if(activeDroid2 instanceof Fighter fighter){
                    fighter.fight(activeDroid1);
                }

            }
            team1.removeDead();
            team2.removeDead();
            Thread.sleep(500);
        }



    }

}
