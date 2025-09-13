package team;
import droids.Droid;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private final List<Droid> droids = new ArrayList<>();
    public List<Droid> getDroids() {
        return !droids.isEmpty() ? droids:  null;
    }

    public boolean isAlive(){
        for(Droid droid:droids){
            if(droid.isAlive()){
                return true;
            }
        }
        return false;
    }

    public void removeDead(){
        droids.removeIf(droid -> !droid.isAlive());
    }


    public void addToTeam(Droid dr){
        droids.add(dr);
    }

    public int getSize (){
        return getDroids().size();
    }

    public void clearTeam(){
        droids.clear();
    }

}
