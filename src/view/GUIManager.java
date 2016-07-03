/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Game;
import controller.GameManager;
import static controller.GameManager.setGMode;
import controller.Singleton;
import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.animation.FadeTransition;
import javafx.util.Duration;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import model.Graphics;
import model.IO;

/**
 *
 * @author jb
 */
public class GUIManager extends Application {

    private final GUIDesign design = Singleton.getDs();
    private final GameManager gma = Singleton.getGma();
    private final Graphics gr = Singleton.getGr();
    private final IO io = Singleton.getIo();
    public enum MessageType {
        FROG_INDEX,GAME_OVER
    }
    Animator animator;
    public BorderPane root;
    public Scene sc;
    public Menu mn;
    private Boolean arrowKeysEnabled;
    private long lastUpdate = 0 ;
    private double rootCenter, rootMid, rootQuarter, rootFifth;
    private double frogStartPos_X, frogStartPos_Y;
    private int candidate=0;
    private int refTime=1;
    private ParallelTransition pt;
    private FadeTransition ft1,ft2;

    @Override
    public void start(Stage st)throws InterruptedException {
        
        //System.out.println(""+System.getProperty("java.class.path"));
        //getHostServices().getDocumentBase();
        root = new BorderPane();
        sc = new Scene(root);
        design.initScene(root, sc, st);
        design.initStage(st, sc);
        design.getHbMid().setAlignment(Pos.CENTER);
        design.getHbMid().getChildren().add(gr.splash);
        arrowKeysEnabled=false;
        setGMode(GameManager.GUIMode.SPLASH);

        Task<Void> intro = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(500);//2000
                } catch (InterruptedException e) {
                    //GameManager.alertMsg(e.getMessage());
                }
                return null;
            }
        };
        
        intro.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                gma.setGMode(GameManager.GUIMode.MENU);
                gma.setCurrentGame(new Game());
                setGUI(GameManager.getGMode());
                io.loadGamesFile("file:games.properties");
                mn.setScoresDisplay(IO.getGames());
                //initGame((Game.Level)(Object)levelSelector.getSelectedToggle().getUserData());
                
            }
        });
        new Thread(intro).start();
        animator = new Animator(sc);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                animator.animate();
            }
        }
        .start();
    }
    
    void setMenu(){
        mn = new Menu(this,design,gr);
        StackPane stp = mn.setMenuPanel();
        design.getHbMid().getChildren().clear();
        design.getHbMid().getChildren().add(stp);
        mn.fadeIn(stp,Duration.millis(1000));
    }
  
    public void setGUI(GameManager.GUIMode gm) {    

        switch (gm) {
                
            case MENU:
                setMenu();
                break;
            case GAME: 
                design.getHbMid().getChildren().clear();
                //gma.gr.setBackground(design.hbMid, "/img/junk/junkBg4.png");
                design.setPonds(root);
                design.setLanes(sc);
                design.setJunk(root);
                design.setCars(root);
                design.setFrogs();
                design.setDashboard();
                updateFrogPool();
                updateScore(gma.getCurrentGame().setScore(0));
                updateFrogTimeDisplay(0);
                updateGameTimeDisplay(0);
                gma.manageCounters(this);
                setRunningFrog();
                setKeyEvents();
                break;
            default:
                break;
        }
    }

//            if (gm.getCurrentGame().getLevel()!=Game.Level.BEGINNER){
//                mower_mp.play();
//            }
//            if (gm.getCurrentGame().getLevel()==Game.Level.CONFIRMED){
//                root.getChildren().add(mower);
//                mowerSpeed=11;
//                mower.setLayoutX(sc.getWidth() + 700);
//                mowerRange=300;
//                mowerOffsetL = 700;
//
//            }else if (gm.getCurrentGame().getLevel()==Game.Level.EXPERT){
//                
//                Junk.speedFactor=1;
//   
//                root.getChildren().add(mower);
//                mowerSpeed=15;
//                mower.setLayoutX(sc.getWidth() + 700);
//                mowerRange=200;
//                mowerOffsetL = 700;
//            }
//                mowerOffsetR = mowerOffsetL+mowerRange;
//                mowerDir = 'L';
//                
//            addJunk();
//
//            initFrogs();
//
//            //bug.setRotate(90);
//            bug.setLayoutY(25);
//            root.getChildren().add(bug);

    
    public void setRunningFrog() {
        
        if (Frog.getRunningFrog()!=null){
            System.out.println(""+root.getChildren().indexOf(Frog.getRunningFrog()));
            if (Frog.getRunningFrog().getStatus()==Frog.Status.RUNNING) { 
            root.getChildren().remove(Frog.getRunningFrog());
                                } 
        }
        
        if (!design.getFrogPool().getChildren().isEmpty()){
            arrowKeysEnabled=false;  
            int q = design.getFrogPool().getChildren().size() - 1;
            design.frogs.get(q).setStatus(Frog.Status.RUNNING);
            Frog.setRunningFrog(design.frogs.get(q));
            Frog.getRunningFrog().setIndex((byte) (4 - (byte)q));
            setCenterDashboard(MessageType.FROG_INDEX, ""+Frog.getRunningFrog().getIndex(),60);
            transitScale(design.getMainMsg(), 5,5,1, Duration.millis(500));
            
            Task<Void> goFroggy = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(400);//2000
                    } catch (InterruptedException e) {
                    }
                    return null;
                }
            };
            goFroggy.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                @Override
                public void handle(WorkerStateEvent event) {
                    root.getChildren().add(Frog.getRunningFrog());
                    getFrogStartPos();
                    Frog.getRunningFrog().relocate(frogStartPos_X, frogStartPos_Y);
                    RotateTransition rt=new RotateTransition(Duration.millis(150),Frog.getRunningFrog());
                    rt.setByAngle(360f);
                    Frog.getRunningFrog().setScaleX(2);
                    Frog.getRunningFrog().setScaleY(2);
                    ScaleTransition st = new ScaleTransition(Duration.millis(1000),Frog.getRunningFrog());
                    st.setToX(1);
                    st.setToY(1);
                    ParallelTransition pt = new ParallelTransition();
                    pt.getChildren().addAll(rt,st);
                    pt.play();
                    pt.setOnFinished(new EventHandler<ActionEvent>(){
                        @Override
                        public void handle(ActionEvent e) {
                            arrowKeysEnabled=true;
                        }
                    });
                    Frog.getRunningFrog().setTime(0);
                    updateFrogPool();
                    //audio.background_mp.play();    
                }
            });
            new Thread(goFroggy).start();
        }
    }
    
    /**
    * màj GUI avec nombre de grenouilles disponibles
    * 
    * @author jb
    * @version %v%
    */
    void updateFrogPool() {
        design.getFrogPool().getChildren().clear();
        int i;
        for (i = 0; i < design.frogs.size(); i++) {
            if (design.frogs.get(i).getStatus() == Frog.Status.POOL) {
                design.getFrogPool().getChildren().add(design.frogs.get(i));
            }
        }
    }
    
    void getFrogStartPos() {
        if (Frog.getRunningFrog() != null) {
            frogStartPos_X = root.getWidth() / 2 - (Frog.getRunningFrog().getLayoutBounds().getWidth() / 2);
            frogStartPos_Y = design.getHbBot().getLayoutY() + 12 + design.smallFrogOffset;
        }
    }
    
    public void setCenterDashboard(MessageType mt,String s, int fontSize){
        design.centerDashboard.getChildren().clear();
        Text t = design.getMainMsg();
        t.setFont(Font.font("Arial", FontWeight.BOLD, fontSize));
        t.setText(s);
        design.centerDashboard.getChildren().add(t);
        if (mt == MessageType.FROG_INDEX){
//        greatbell1Sound.play();
        }else{
//        audio.background_mp.stop();
//        audio.carsMix_mp.stop();
//        audio.mower_mp.stop();
//        audio.bugSound.setVolume(0);
//        audio.gameoverSound.play();
        }
    }
    
    void transitScale(Node n, int inX,int inY,int out, Duration d){
        n.setScaleX(inX);
        n.setScaleY(inY);
        ScaleTransition st = new ScaleTransition(d,n);
        st.setToX(out);
        st.setToY(out);
        st.play();
    }
    
    void setKeyEvents(){
        ArrayList<String> input = new ArrayList<>();
        Frog rf = Frog.getRunningFrog();

        sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                int c;
                for (c = 0; c < design.junk.size(); c++) {
                    if (design.junk.get(c).getBoundsInParent().intersects(rf.getBoundsInParent())){
                           //audio.yeehawSound.play();
                    }else if(rf.getLayoutY() < 250){
                        //yeehawSound.play(); 
                    }
                }
             //alertMsg("***"+arrowKeysEnabled);
            if (arrowKeysEnabled){

                if (rf.getStatus() == Frog.Status.DROWNED){
                    //avoid action on fading frog
                    
                }else if (rf.getStatus() == Frog.Status.RUNNING  || rf.getStatus() == Frog.Status.FLOATING) {

                    String code = e.getCode().toString();   
                    if (null != code) {
                        switch (code) {
                            
                        case "UP":

                                //updateGamesArray(GameManager.getCurrentGame());
                                //GameManager.saveGamesFile();
                                
                                //START
                                getFrogStartPos();
                                if (rf.getLayoutY() == frogStartPos_Y) {
                                    updateScore(gma.getCurrentGame().setScore(10));
                                    rf.relocate(rf.getLayoutX(), design.getHbTop().getLayoutY() + gr.getLanesMode() * 50 + 27 + design.smallFrogOffset);
                                //JUMP TO POND
                                }else if (rf != null && rf.getStatus() != Frog.Status.HOME && rf.getLayoutY() < 151) {
                                    rf.relocate(rf.getLayoutX(), 0);

                                try {
        
                                    int p=0;
                                    Boolean intersects=false;
                                    for (p = 0; p < design.ponds.size(); p++) {

                                        //INTERSECT
                                        if (  design.ponds.get(p).getBoundsInParent().intersects(rf.getBoundsInParent())){

                                            intersects=true;

                                            //pond dispo
                                            if (design.ponds.get(p).status == Pond.Status.EMPTY) {
                                                int s = gma.getCurrentGame().getScore() * 
                                                    (Frog.getTimeLimit() - gma.getCurrentGame().getTime());
                                                    updateScore(gma.getCurrentGame().setScore(s));
                                                //pondSplashSound.play();
                                                rf.relocate(design.ponds.get(p).getLayoutX() + 29, design.ponds.get(p).getLayoutY()+15);
                                                rf.setStatus(Frog.Status.HOME);
                                                design.ponds.get(p).setStatus(Pond.Status.FROGGED);
                                                Pond.froggedTotal++;

                                                if (Pond.getFroggedTotal() == 3){
                                                    //setUserInputGrid();
                                                }

                                            }else{//POND OCCUPIED
                                                updateScore(gma.getCurrentGame().setScore(-2000));
                                                root.getChildren().remove(rf);
                                            }

                                        //NO INTERSECT
                                        } else {
                                        }
                                    }

                                    if (!intersects){
                                        root.getChildren().remove(rf);
                                    }

//                                    int s = gm.getCurrentGame().getScore() * 
//                                        (gm.getCurrentGame().frogTimeLimit - gm.getCurrentGame().getFrogTime());
//                                    setScore(s);

//                                    if (design.frogPool.getChildren().isEmpty()) {
//
//                                        setCenterDashboard("GAME\nOVER");
//                                        gma.getCurrentGame().getTl().stop();
//                                        //userInput
//                                        updateGamesArray(GameManager.getCurrentGame());//player, score, level
//                                        //GameManager.saveScores();
//                                    }else{
//                                        gm.getCurrentGame().setNextFrog();
//                                    }

                                }catch (Error e2) {
                                    //alertMsg(e2.getMessage());
                                }
                                
                                //LEAP OR DROWN
                                
                                } else{
                                    
                                    //g.setEffect(new BoxBlur(3, 3, 3));//w h iter
                                    //setParticles(g1);
                                    rf.relocate(rf.getLayoutX(), rf.getLayoutY() - Frog.getFrogLeap());
                                    if (rf.getLayoutY()<Junk.getMaxY()+50){
                                        drown(rf);
                                    }else{
                                        updateScore(gma.getCurrentGame().setScore(10));
                                    }
                                }
                                    
                                break;

                            case "DOWN":
                                if (rf.getLayoutY() != frogStartPos_Y){
                                    if (rf.getLayoutY() < frogStartPos_Y) {
                                        //GET BACK FROM LOWEST LANE
                                        if (rf.getLayoutY() == design.getHbTop().getLayoutY() + design.getLanesMode() * 50 + 27 + design.smallFrogOffset) {
                                            getFrogStartPos();
                                            rf.relocate(frogStartPos_X, frogStartPos_Y);
                                            updateScore(gma.getCurrentGame().setScore(-10));
                                        //JUMP DOWN
                                        } else {
                                            rf.relocate(rf.getLayoutX(), rf.getLayoutY() + Frog.getFrogLeap());
                                            if (rf.getLayoutY()<Junk.getMaxY()+50){
                                                drown(rf);
                                            }else{
                                                updateScore(gma.getCurrentGame().setScore(-10));
                                            }   
                                        }
                                    }
                                }
                                break;
                                
                            case "LEFT":   
                                if (rf.getLayoutY() != frogStartPos_Y && rf.getLayoutX()>50){
                                //LEAP OR DROWN
                                    rf.relocate(rf.getLayoutX() - Frog.getFrogLeap(), rf.getLayoutY());
                                    //System.out.println("---------"+rf.getStatus());
                                    if (rf.getLayoutY()<Junk.getMaxY()+50){
                                        drown(rf);
                                    }
                                }
                                break;
                                
                            case "RIGHT":
                                if (rf.getLayoutY() != frogStartPos_Y && rf.getLayoutX()<sc.getWidth()-100){
                                    rf.relocate(rf.getLayoutX() + Frog.getFrogLeap(), rf.getLayoutY());
                                    //System.out.println("---------"+rf.getStatus());
                                    if (rf.getLayoutY()<Junk.getMaxY()+50){
                                        drown(rf);
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                        
                    }

                    // only add once... prevent key ip duplicates
                    if (!input.contains(code)) {
                        input.add(code);
                    }  
                }
            }
        }
        });

        sc.setOnKeyReleased((KeyEvent e) -> {
            String code = e.getCode().toString();
            input.remove(code);
        });
        
    }
    
    /**
    * Aspect visuel noyade grenouille
    * 
    * @author jb
    * @version %v%
    */
    void drown(Frog f){
        
        f.setStatus(Frog.Status.DROWNED);
        ft2 = new FadeTransition(Duration.millis(750),f);
        ft2.setFromValue(1.0);
        ft2.setToValue(0.0);
        ft2.play();
        ft2.setOnFinished(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e) {
                root.getChildren().remove(f);
//                gm.getCurrentGame().setNextFrog();
//
//                //PATCH
//                if(frogPool.getChildren().isEmpty()){
//                    audio.background_mp.stop();
//                    audio.mower_mp.stop();
//                    audio.carsMix_mp.stop();
//                    audio.bugSound.setVolume(0);
//                    layout.centerDashboard.getChildren().clear();
//                    mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//                    layout.centerDashboard.getChildren().add(mainMsg);
//                    mainMsg.setText("GAME\nOVER");
//                    root.getChildren().removeAll(cars);
//                    root.getChildren().removeAll(junk);
//                    root.getChildren().removeAll(mower,runningFrog,bug);
                }
            
        });

    }
     
    void updateScore(int s){
        design.getScoreText().setText(Integer.toString(s));
    }
    
    void updatePlayerDisplay(int s){
        design.getPlayerText().setText(Integer.toString(s));
    }
        
    void updateFrogTimeDisplay(int s){
        design.getFrogCounterText().setText(Integer.toString(s));
    }
    
    void updateGameTimeDisplay(int s){
        design.getGameCounterText().setText(Integer.toString(s));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}