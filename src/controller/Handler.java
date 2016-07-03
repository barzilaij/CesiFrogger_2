/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Platform;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Graphics;
import model.IO;
import view.Frog;
import view.GUIDesign;
import view.GUIManager;

/**
 *
 * @author jb
 */
public class Handler {
    
    private final GUIDesign design = Singleton.getDs();
    private final GameManager gma = Singleton.getGma();
    private final Graphics gr = Singleton.getGr();
    private final IO io = Singleton.getIo();

    //menu
    public void toggleHandler(ToggleGroup tg){
        if (tg.getSelectedToggle() != null) {
            gma.getCurrentGame().setLevel((Game.Level)tg.getSelectedToggle().getUserData());
            gma.alertMsg(gma.getCurrentGame().getLevel().toString());
        }
    }
                    
    public void playButtHandler(GUIManager GUIMan, ToggleGroup tg){
        try {
            GUIMan.setGUI(gma.GMode = GameManager.GUIMode.GAME);
//            gm.getCurrentGame().setDashboardUpdater(currentFrog);   
//            au.carsMix_mp.setVolume(0.8);
//            au.carsMix_mp.setCycleCount(20);
//            au.carsMix_mp.play();s
        } catch (Error e) {
            //gm.alertMsg("L 1159");
        } 
    }
    
    public void quitButtHandler(){
                Platform.exit();
    }
    
    public void countersHandler(Number n, Number o){
            design.getFrogCounterText().setText(""+n);
            design.getGameCounterText().setText(""+o);
            design.getpBar1().setProgress(n.doubleValue()/Frog.getTimeLimit());
            design.getpBar2().setProgress(o.doubleValue()/Game.getTimeLimit());
    }
    
    //INPUT
//    public void okButtHandler(){
//        if (userInput.getText().length()>1){
//            gm.getCurrentGame().setPlayer(userInput.getText());
//            updateGamesArray(GameManager.getCurrentGame());
//            GameManager.saveGamesFile();
//            playerLabel.setText("Player : ");
//            playerText.setText(gm.getCurrentGame().getPlayer());
//            root.getChildren().remove(stp);
//        }
//    }
//    
    //GAME
    public void updateSceneWidth(Stage st){
        //layout.updateDraw(st);    
    }
    
    public void updateSceneHeight(Stage st){
        //layout.updateDraw(st);    
    }

}