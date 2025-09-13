package battlelog;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BattleLog {
    private static List<String> logs = new ArrayList<>();

    public static void add(String log){
        System.out.println(log);
        logs.add(log);
    }
    public static void  pushToFile(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("battle.txt"))) {
            for (String line : logs) {
                writer.write(line);
                writer.newLine();
            }
            logs.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void  readBattle(){
        try (BufferedReader reader = new BufferedReader(new FileReader("battle.txt"))) {
            String line=null;
            while((line=reader.readLine())!=null){
                System.out.println(line);
                Thread.sleep(500);
            }

        } catch(IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
