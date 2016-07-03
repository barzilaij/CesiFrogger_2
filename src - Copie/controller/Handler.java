/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.application.Platform;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Graphics;
import model.IO;
import view.Design;
import view.GUIManager;

/**
 *
 * @author jb
 */
public class Handler {
    
    Design design = Singleton.getDs();
    GameManager gma = Singleton.getGma();
    Graphics gr = Singleton.getGr();
    IO io = Singleton.getIo();

    //menu
    public void toggleHandler(ToggleGroup tg){
        if (tg.getSelectedToggle() != null) {
            //gma.alertMsg("qsfsqfqf");
            //gma.getCurrentGame().setLevel((Game.Level)tg.getSelectedToggle().getUserData());

            //gma.alertMsg(gma.getCurrentGame().getLevel().toString());
        }
    }
                    
    public void playButtHandler(GUIManager GUIMan, ToggleGroup tg){
        try {
            Game g = new Game((Game.Level)tg.getSelectedToggle().getUserData());
            gma.setCurrentGame(g);
            GUIMan.setGUI(gma.GMode = GameManager.GUIMode.GAME);
//design.centerDashboard.getChildren().clear();
//            setRunningFrog(Frog.Status.RUNNING);
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