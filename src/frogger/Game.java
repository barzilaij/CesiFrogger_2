/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import static frogger.GUIManager.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

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
    private  int frogTime,gameTime;
    private int runningFrog;
    private int landedFrogsTotal;
    private int score;
    private  Timeline tl = null;
    
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
    Game(Level l) {
        
        id++;
        level=l;
        score = 0;
        
    }
    
    public Timeline getTl(){ 
        return tl;
    }

//    public String getPlayer() {
    public void setTl(Timeline tl) {
        this.tl = tl;
    }

    /**
    *Mise en place de grenouille courante
    *avec mise à jour chronomètre
    * 
    * @author jb
    * @version %v%
    */
    public void setNextFrog() {    //  !!!   doublon runninfrog dans Game   !!!
        GUIManager.setRunningFrog(Frog.Status.RUNNING);
        frogTime=0;
        //compensation
        gameTime--;
    }

    public int getFrogTime() {
        return frogTime;
    }

    public void setFrogTime(int frogTime) {
        this.frogTime = frogTime;
    }
    
    /**
    *Gestion générale des grenouilles
    * 
    * @author jb
    * @version %v%
    */
    void updateFrogManagement(){
        
        if (frogTime<frogTimeLimit){
            frogTime++;
            n = (Number)frogTime;
            
        }else{ 

                int lastIndex = root.getChildren().size()-1;
                Frog latestFrog = (Frog)root.getChildren().get(lastIndex);

                if (latestFrog.status==Frog.Status.RUNNING) { 
                    root.getChildren().remove(latestFrog);
                } 

                if(frogPool.getChildren().isEmpty()){
                    centerDashboard.getChildren().clear();
                    mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
                    centerDashboard.getChildren().add(mainMsg);
                    mainMsg.setText("GAME\nOVER");
                    tl.stop();
                }else{
                    int k = frogPool.getChildren().size();
                    setNextFrog();
                }

            }

        gameTime++;
        o = (Number)gameTime;
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
        for (j=0;j<frogs.size();j++){
            if (frogs.get(j).status==Frog.Status.HOME)
                landedFrogsTotal++;
        }
        return landedFrogsTotal;
    }
    

     /**
    **Mise à jour du temps passé avec affichage
    * 
    * @author jb
    * @version %v%
    */
    public void setDashboardUpdater(){

        this.frogTime = 0;
        gameTime = 0;
        status=Status.RUNNING;
       
        Timeline tl = null;
        tl = new Timeline(new KeyFrame(
                
                javafx.util.Duration.millis(1000), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent ae) {
                        frogCounterText.setText("0'"+frogTime);
                        gameCounterText.setText("0'"+gameTime);
                        pBar1.setProgress(n.doubleValue()/frogTimeLimit);
                        pBar2.setProgress(o.doubleValue()/gameTimeLimit);
                        
                        updateFrogManagement();
                        
                    }
                }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
        
    }  
    
    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
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

    public void setScore(int score) {
        this.score = score;
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