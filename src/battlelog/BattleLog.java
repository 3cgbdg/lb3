package battlelog;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
//battle log class
public class BattleLog {
    private static List<String> logs = new ArrayList<>();
    //adding all battle logs through this method
    public static void add(String log){
        System.out.println(log);
        logs.add(log);
    }
    //creating or pushing logs to battle.txt
    public static void  pushToFile(){
        //using BufferedWriter + File Writer
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("battle.txt"))) {
            for (String line : logs) {
                writer.write(line);
                writer.newLine();
            }
            logs.clear();
        } catch (IOException e) {
            //dropping error
            e.printStackTrace();
        }
    }

    public static void  readBattle(){
        //using BufferedReader + File Reader
        try (BufferedReader reader = new BufferedReader(new FileReader("battle.txt"))) {
            String line=null;
            while((line=reader.readLine())!=null){
                System.out.println(line);
                Thread.sleep(500);
            }

        } catch(IOException | InterruptedException e) {
            //dropping error
            e.printStackTrace();
        }
    }
}
