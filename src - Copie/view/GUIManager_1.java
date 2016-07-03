///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package view;
//
//import controller.GameManager;
//import static controller.GameManager.setGMode;
//import controller.Singleton;
//import javafx.scene.layout.StackPane;
//import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.stage.Stage;
//import javafx.concurrent.Task;
//import javafx.concurrent.WorkerStateEvent;
//import javafx.animation.FadeTransition;
//import javafx.util.Duration;
//import javafx.animation.ParallelTransition;
//import model.Graphics;
//import model.IO;
//
///**
// *
// * @author jb
// */
//public class GUIManager extends Application {
//  
//    Design design = Singleton.getDs();
//    GameManager gma = Singleton.getGma();
//    Graphics gr = Singleton.getGr();
//    IO io = Singleton.getIo();
//    
//    public static BorderPane root;
//    public static Scene sc;
//    public static Menu mn;
//    
//    Boolean arrowKeysEnabled=true;
//    long lastUpdate = 0 ;
//    double rootCenter, rootMid, rootQuarter, rootFifth;
//    double frogStartPos_X, frogStartPos_Y;
//    double space, tmp;
//    double carMinY, carMaxY, pondsOffset; 
//
//    double smallFrogOffset = 7;
//    double junkMinY, junkMaxY;
//    int candidate=0;
//    int refTime=1;
//    
//    ParallelTransition pt;
//    FadeTransition ft1,ft2;
//
//    @Override
//    public void start(Stage st)throws InterruptedException {
//
//        root = new BorderPane();
//        sc = new Scene(root);
//        design.initScene(root, sc, st);
//        design.initStage(st, sc);
//
//        setGMode(GameManager.GUIMode.SPLASH);
//        design.hbMid.setAlignment(Pos.CENTER);
//        design.hbMid.getChildren().add(gr.splash);
//
//        Task<Void> intro = new Task<Void>() {
//            @Override
//            protected Void call() throws Exception {
//                try {
//                    Thread.sleep(500);//2000
//                } catch (InterruptedException e) {
//                    //GameManager.alertMsg(e.getMessage());
//                }
//                return null;
//            }
//        };
//        
//        intro.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                GameManager.setGMode(GameManager.GUIMode.MENU);
//                setGUI(GameManager.getGMode());
//                io.loadGamesFile("games.properties");
//                mn.updateScoreDisplay(IO.getGames());
//                
//                //initGame((Game.Level)(Object)levelSelector.getSelectedToggle().getUserData());
//                
//            }
//        });
//        new Thread(intro).start();
//    }
//  
//    public void setGUI(GameManager.GUIMode gm) {    
//
//        switch (gm) {
//            case MENU:
//                setMenu();
//                break;
//            case GAME: {
//
//                design.hbMid.getChildren().clear();
//                //gma.gr.setBackground(design.hbMid, "/img/junk/junkBg4.png");
//                design.initPonds(root,design.hbTop);
//                design.initLanes(sc);
//
////            initDashboard();
////            initCars();
////            initJunk();
////            addCars();
// 
////            if (gm.getCurrentGame().getLevel()!=Game.Level.BEGINNER){
////                mower_mp.play();
////            }
////            if (gm.getCurrentGame().getLevel()==Game.Level.CONFIRMED){
////                root.getChildren().add(mower);
////                mowerSpeed=11;
////                mower.setLayoutX(sc.getWidth() + 700);
////                mowerRange=300;
////                mowerOffsetL = 700;
////
////            }else if (gm.getCurrentGame().getLevel()==Game.Level.EXPERT){
////                
////                Junk.speedFactor=1;
////   
////                root.getChildren().add(mower);
////                mowerSpeed=15;
////                mower.setLayoutX(sc.getWidth() + 700);
////                mowerRange=200;
////                mowerOffsetL = 700;
////            }
////                mowerOffsetR = mowerOffsetL+mowerRange;
////                mowerDir = 'L';
////                
////            addJunk();
////
////            initFrogs();
////
////            //bug.setRotate(90);
////            bug.setLayoutY(25);
////            root.getChildren().add(bug);
//
//        }
//    }
//}
//    
//    void setMenu(){
//        mn = new Menu(this,design,gr);
//        StackPane stp = mn.setMenuPanel();
//        design.hbMid.getChildren().clear();
//        design.hbMid.getChildren().add(stp);
//        mn.fadeIn(stp,Duration.millis(1000));
//    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//}