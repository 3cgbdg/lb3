package game;

import battlelog.BattleLog;
import droids.AssaultDroid;
import droids.Droid;
import droids.MedicDroid;
import droids.SniperDroid;
import fight.Fight1V1;
import fight.TeamsFight;
import interfaces.Healer;
import menu.Menu;
import team.Team;

import java.util.*;

public class Game {

    private static List <Droid> droids = new ArrayList<>();
    private static Team[] teams = {new Team(),new Team()};
    public static void createDroid(String name, String type){
        switch (type){
            case "Assault":
                droids.add(new AssaultDroid(name));
                break;
            case "Sniper":
                droids.add(new SniperDroid(name));
                break;
            case "Medic":
                droids.add(new MedicDroid(name));
                break;
        }

    }

    public static List<Droid> getDroids() {
        return droids;
    }

    public static Team[] getTeams() {
        return teams;
    }
    public static void run () throws InterruptedException {
        Menu.runMenu();
    }

    public static void startFight(int option) throws InterruptedException {
        final Team team1  =teams[0];
        final Team team2  =teams[1];
        if(Arrays.asList(team1,team2).contains(null)) {
            System.out.println("\nFirstly create two teams to start fighting!");
           return;
        }
        if(option==1){
            final Fight1V1 fight = new Fight1V1(team1, team2);
            fight.startFighting();

        }else{
            final TeamsFight fight = new TeamsFight(team1, team2);
            fight.startFighting();
        }

        if(team1.isAlive()){
            BattleLog.add("Team 1 won!!!");
        }else{
            BattleLog.add("Team 2 won!!!");
        }

//        ending the fight
        team1.clearTeam();
        team2.clearTeam();
        Iterator<Droid> iterator  = droids.iterator();
        while(iterator.hasNext()){
            Droid item = iterator.next();
            if(!item.isAlive()){
                iterator.remove();
                continue;
        }
            item.leaveTeam();
        }
        BattleLog.pushToFile();

    }
    public static void end(){
        System.out.println("Game Over!");
        System.exit(0);
    }
    public static void createTeams(int option){
        String name = null;
        Scanner sc = new Scanner(System.in);
        int teamIdx = 0;
        int count = 0;
        while (!Objects.equals(name, "exit")){
            if(count == droids.size() || (option==1 && count==2))break;
            System.out.printf("Write name of droid to team %d (to exit type 'exit'):",teamIdx+1);
            name = sc.nextLine();
            int mergedIdx = option==2 ? droids.size()/2:1;
           for(Droid dr:droids){
                if(Objects.equals(name, dr.getName())){
                    if(dr.isInTeam()){
                        System.out.println("It`s in team already");
                        break;
                    }
                    if(dr instanceof Healer){
                        if(Arrays.stream(teams[teamIdx].getDroids().toArray()).anyMatch(n ->n instanceof Healer));
                        System.out.println("You already have one medic in your team (max:1)");
                        break;
                    }
                    dr.joinTeam(teamIdx);
                    teams[teamIdx].addToTeam(dr);
                    break;

                }
            }
            if(teams[0].getSize() == mergedIdx)teamIdx=1;
            count++;
        }
    }


}
