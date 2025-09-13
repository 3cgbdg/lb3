package menu;
import battlelog.BattleLog;
import droids.Droid;
import game.Game;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private static int choice ;
    private static void showMenu() {
        System.out.println("\n" + "=".repeat(30));
        System.out.println("Menu:");
        System.out.println("1. Create droid");
        System.out.println("2. Show list of droids");
        System.out.println("3. Start fight (1v1)");
        System.out.println("4. Start fight (teams)");
        System.out.println("5. Get last fight logs from .txt file");
        System.out.println("6. Leave a Game");
    }

    public static void runMenu() throws InterruptedException {
        Scanner sc= new Scanner(System.in);
        while(choice != 6){
            showMenu();
            System.out.print("Choose command:");
            choice  = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    final String[] arr  = sc.nextLine().split(" ");
                    Game.createDroid(arr[0],arr[1]);
                    break;
                case 2:
                    final List<Droid> listOfDroids =  Game.getDroids();
                    if(listOfDroids.isEmpty()){
                        System.out.println("\nList is empty!");
                        break;
                    };
                    for(Droid dr : listOfDroids){
                        System.out.printf("Droid \"%s\" health -- [%.2f]hp, ability -- %s, damage -- %.2f \n",dr.getName(),dr.getHealth(),dr.getAbilityName(),dr.getDamage());
                    }
                    break;
                case 3:
                    if(Game.getDroids().size()<=1)break;
                    Game.createTeams(1);
                    Game.startFight(1);
                    break;
                case 4 :
                    if(Game.getDroids().size()<=1)break;
                    Game.createTeams(2);
                    Game.startFight(2);
                    break;
                case 5:
                    BattleLog.readBattle();
                    break;
                case 6:
                    Game.end();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + choice);
            }
        }
        sc.close();
    }



}
