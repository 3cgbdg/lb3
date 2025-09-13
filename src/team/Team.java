package team;
import droids.Droid;
import java.util.ArrayList;
import java.util.List;
//team class
public class Team {
//    list of droids in the team
    private final List<Droid> droids = new ArrayList<>();
//    getters
    public List<Droid> getDroids() {
        return !droids.isEmpty() ? droids:  null;
    }
    public int getSize (){
        return getDroids()!=null ? getDroids().size() : 0;
    }
//    checkers
//    method for checking if there`s someone in the team who`s still alive
    public boolean isAlive(){
        for(Droid droid:droids){
            if(droid.isAlive()){
                return true;
            }
        }
        return false;
    }
//    method for removing all the dead members after each step in the fight (preventing errors with random idxs of members who`s dead)
    public void removeDead(){
        droids.removeIf(droid -> !droid.isAlive());
    }
//    method for adding droid to the team
    public void addToTeam(Droid dr){
        droids.add(dr);
    }


//    method for clearing al the team after the fight was finished
    public void clearTeam(){
        droids.clear();
    }

}
