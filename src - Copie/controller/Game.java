
package controller;

import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import view.GUIManager;

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
    
    private int id=0;
    private String player;
    private Status status;
    private Level level;
    private int runningFrog;
    private int score;
    int gameTime;

    Number n = 0;
    Number o = 0;
    public int frogTimeLimit  = 60;
    int gameTimeLimit  = 4*frogTimeLimit;
    
    /**
    *Constructeur avec paramètre Level
    * 
    * @author jb
    * @version %v%
    */
    public Game(Level l) {
        id++;
        level=l;
        status=Status.RUNNING;
        score = 0;

    }

    /**
    *Mise en place de grenouille courante
    *avec mise à jour chronomètre
    * 
    * @author jb
    * @version %v%
    */
    public void setNextFrog() {    //  !!!   doublon runninfrog dans Game   !!!
//        if (frogPool.getChildren().size()>0){
//            Fucked.setRunningFrog(Frog.);
//            frogTime=0;
//            //compensation
//            gameTime--;
//        }
        updateFrogManagement();
    }

//    public int getFrogTime() {
//        //return frogTime;
//    }

    public void setFrogTime(int frogTime) {
        //this.frogTime = frogTime;
    }
    
    /**
    *Gestion générale des grenouilles
    * 
    * @author jb
    * @version %v%
    */
    void updateFrogManagement(){
        
//        if (frogTime<frogTimeLimit){
//            frogTime++;
//            n = (Number)frogTime;
//            
//            gameTime++;
//            o = (Number)gameTime;
//            
//        }else{ 
//            
//                int lastIndex = root.getChildren().size()-1;
//                Frog latestFrog = (Frog)root.getChildren().get(lastIndex);
//                
//                //GameManager.alertMsg ("----> "+f);
//
//                if (latestFrog.status!=Frog.Status.POOL && latestFrog.status!=Frog.Status.HOME) { 
//                    root.getChildren().remove(latestFrog);
//                } 
//
//                if(frogPool.getChildren().isEmpty()){
//                    centerDashboard.getChildren().clear();
//                    mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//                    centerDashboard.getChildren().add(mainMsg);
//                    mainMsg.setText("GAME\nOVER");
//                    tl.stop();
//                }else{
//                    int k = frogPool.getChildren().size();
//                    setNextFrog();
//                }
//
//            //if (frogTime<frogTimeLimit){
//            //frogTime++;
//            //n = (Number)frogTime;
//            gameTime++;
//            o = (Number)gameTime;
//        }
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
    

     /**
    **Mise à jour du temps passé avec affichage
    * 
    * @author jb
    * @version %v%
    */
    
    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        //this.gameTime = gameTime;
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

    public int getRunningFrog() {
        return runningFrog;
    }

    public void setRunningFrog(int runningFrog) {
        this.runningFrog = runningFrog;
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

}