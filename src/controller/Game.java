
package controller;

import view.Frog;

/**
*Création d'objets jeu avec paramètres
* 
* @author jb
* @version %v%
*/
public class Game implements Comparable<Game>{
    
    static public enum Level {
        BEGINNER,CONFIRMED,EXPERT
    }
    
    static public enum Status {
        RUNNING,OVER
    }

    private String player;
    private Status status;
    private Level level;
    private int score, time;
    private static int timeLimit;
    private static int id = 0;
    Number n = 0;
    Number o = 0;

    /**
    *Constructeur avec paramètre Level
    * 
    * @author jb
    * @version %v%
    */
    public Game() {
        //to check
        id++;
        setStatus(Status.RUNNING);
        setTime(0);
    }
    
    /**
    *Donnée calculée: nombre total grenouilles dans les mares
    * 
    * @author jb
    * @version %v%
    */
    int getLandedFrogsTotal(){
        
        int j;
        int landedFrogsTotal=0;
//        for (j=0;j<frogs.size();j++){
//            if (frogs.get(j).status==Frog.Status.HOME)
//                landedFrogsTotal++;
//        }
        return landedFrogsTotal;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public int setScore(int i) {      
        int update = this.getScore()+i;
        if (update<0){
            update=0;  
        }
        this.score=update;
        //GUIManager.setScoreDisplay(this.getScore());
        return this.getScore();
    }
    
    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
    
    /**
    *Comparaison des scores
    * 
    * @author jb
    * @version %v%
    */
    @Override
    public int compareTo(Game other) {
        return Integer.valueOf(score).compareTo(Integer.valueOf(other.score));
    }
    
    public static int getTimeLimit() {
        return timeLimit;
    }

    public static void setTimeLimit(int timeLimit) {
        Game.timeLimit = timeLimit;
    }
    

}