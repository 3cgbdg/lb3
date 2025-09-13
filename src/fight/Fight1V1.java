package fight;

import droids.Droid;
import interfaces.Fighter;
import interfaces.Healer;
import team.Team;

public class Fight1V1 extends Fight{

    public Fight1V1(Team t1, Team t2) {
        super(t1, t2);
    }
//    main method for starting fight
    @Override
    public void startFighting () throws InterruptedException {
        int turn =  0;
//        if some of the teams are dead -fight ends
        while(team1.isAlive() && team2.isAlive()){
            turn = (int)(Math.random()*2);
            Droid activeDroid1 = team1.getDroids().get(0);
            Droid activeDroid2 = team2.getDroids().get(0);
//            turn 0 - team 1 , turn 0 team 2
            if(turn == 0 ){
                //checking interfaces
                if(activeDroid1 instanceof Healer healer){
                    healer.heal();

                }
                if(activeDroid1 instanceof Fighter fighter){
                    fighter.fight(activeDroid2);
                }


            }else{
                //checking interfaces

                if(activeDroid2 instanceof Healer healer){
                    healer.heal();
                }
                if(activeDroid2 instanceof Fighter fighter){
                    fighter.fight(activeDroid1);
                }

            }
            Thread.sleep(500);
        }



    }

}
