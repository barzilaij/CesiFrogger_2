
package controller;

import static controller.Game.setTimeLimit;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import model.Audio;
import view.CustomFont;
import view.Frog;
import view.GUIDesign;
import view.GUIManager;

/**
 *Gestionnaire de jeu qui permet notamment:
 * @version %v%
 */
public class GameManager {
    
    public enum GUIMode {
        SPLASH, MENU, GAME, OUTRO;
        GUIMode(){
        }
    }
    
    private final GUIDesign design = Singleton.getDs();
    private Audio audio = new Audio();
    private CustomFont font = new CustomFont();
    private final Handler handler = new Handler();
    
    public static GUIMode GMode;
    private Game currentGame;
    private Timeline counters;
    private byte poolSize;
    private String[] s;
    private Number a = 0;
    private Number b = 0;

    /**
    *Initialisation d'un jeu:
    *<ul> 
    *<li>Instanciation jeu
    *<li>Son initialisation (level, score)
    *<li>Le chargement des données des jeux précedents
    * </ul>
    * <p>
    * 
    * @author jb
    * @version %v%
    */
    public GameManager(){
    }
    
//    public GameManager(String s){
//    }
    
//    public GameManager(){
//          initIO();
//          setCounters();
//      }

    public void manageCounters(GUIManager gm){
        counters = new Timeline(new KeyFrame(
                javafx.util.Duration.millis(1000), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent ae) {
                        Game.setTimeLimit(4*Frog.getTimeLimit());
                        //update counters
                        if (Frog.getRunningFrog().getTime()<Frog.getTimeLimit()){
                            Frog.getRunningFrog().setTime(Frog.getRunningFrog().getTime()+1);
                            a = (Number)Frog.getRunningFrog().getTime(); 
                            getCurrentGame().setTime(getCurrentGame().getTime()+1);
                            b = (Number)getCurrentGame().getTime();
                            handler.countersHandler(a,b); 
                        //next frog
                        }else{ 

                            
                            
                            gm.setRunningFrog();
                            
//                            System.out.println(""+gm.root.getChildren().indexOf(Frog.getRunningFrog()));
//                            if (Frog.getRunningFrog().getStatus()==Frog.Status.RUNNING) { 
//                                gm.root.getChildren().remove(Frog.getRunningFrog());
//                            } 

                            if(design.getFrogPool().getChildren().isEmpty()){
//                                gm.setCenterDashboard(GUIManager.MessageType.GAME_OVER, 
//                                        "GAMEn/OVER",24);
                                counters.stop();
                            }
                        }
                    }
        }));
        counters.setCycleCount(5*Frog.getTimeLimit());
        counters.play();
    }  

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    public byte getPoolSize() {
        return poolSize;
    }

    public void setPoolSize(byte poolSize) {
        this.poolSize = poolSize;
    }
    
    /**
    *Boîte de dialogue pour utilisation générale
    * <p>
    * 
    * @author jb
    * @version %v%
    */
    public static void alertMsg(String s){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.setTitle(""); 
        alert.setHeaderText("Information Alert"); 
        alert.setContentText(s); 
        alert.show();
    }

    public static GUIMode getGMode() {
        return GMode;
    }

    public static void setGMode(GUIMode GMode) {
        GameManager.GMode = GMode;
    }

    public String[] getS() {
        return s;
    }

    public void setS(String[] s) {
        this.s = s;
    }

    public Audio getAudio() {
        return audio;
    }

    public void setAudio(Audio audio) {
        this.audio = audio;
    }

    public CustomFont getFont() {
        return font;
    }

    public void setFont(CustomFont font) {
        this.font = font;
    }
    
    public Timeline getCounters() {
        return counters;
    }

    public void setCounters(Timeline counters) {
        this.counters = counters;
    }

}