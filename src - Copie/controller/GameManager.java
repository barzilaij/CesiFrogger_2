
package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import model.Audio;
import static model.IO.initIO;
import view.CustomFont;

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
        
    public Audio audio = new Audio();
    public CustomFont font = new CustomFont();
    
    public static GUIMode GMode = null;
    public static Game currentGame = null;
    int frogTime,gameTime;
    String[] s;

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

    public void setCounters(){
        frogTime = 0;
        gameTime = 0;
        Timeline tl = new Timeline(new KeyFrame(
                javafx.util.Duration.millis(1000), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent ae) {
                    //setCounterDisplays(frogTime, gameTime);
//                      pBar1.setProgress(n.doubleValue()/frogTimeLimit);
//                      pBar2.setProgress(o.doubleValue()/gameTimeLimit);
                    }
                }));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.play();
    }  

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game cg) {
        currentGame = cg;
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
        //System.out.println(s); 
    }

    public static GUIMode getGMode() {
        return GMode;
    }

    public static void setGMode(GUIMode GMode) {
        GameManager.GMode = GMode;
    }

    public int getFrogTime() {
        return frogTime;
    }

    public void setFrogTime(int frogTime) {
        this.frogTime = frogTime;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
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

}