//
//
//import view.*;
//import java.util.ArrayList;
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.stage.Stage;
//import javafx.geometry.Rectangle2D;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.concurrent.Task;
//import javafx.concurrent.WorkerStateEvent;
//import javafx.animation.FadeTransition;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.ParallelTransition;
//import javafx.animation.RotateTransition;
//import javafx.animation.ScaleTransition;
//import javafx.animation.Timeline;
//import javafx.scene.Group;
//import javafx.scene.Node;
//import javafx.scene.effect.BoxBlur;
//import javafx.scene.shape.Circle;
//import javafx.util.Duration;
//import controller.GameManager;
//import controller.Game;
//import model.Graphics;
//
///**
// *Gestionnaire de l'IHM qui permet notamment:
// *<ul> 
// *<li>
// *<li>Son initialisation
// *<li>La mise en place des zones du terrein de jeu
// *<li>La création des objets animés
// *<li>La création des objets graphiques
// *<li>L'animation des objets
// * </ul>
// * <p>
// * La version est indiquée par une variable %v% reconnu par CVS
// * 
// * @author jb
// * @version %v%
// */
//public class GUIManagerDNU_40 extends Application {
//    
//    BorderPane root = new BorderPane();
//    Scene sc = new Scene(root);
//
//    CustomFont font;
//    Graphics gr;
//    Layout layout;
//    GameManager gm;
//    
//    Boolean arrowKeysEnabled=true;
//    long lastUpdate = 0 ;
//    int candidate=0;
//    int refTime=1;
//    ParallelTransition pt;
//    FadeTransition ft1,ft2;
//    double rootCenter, rootMid, rootQuarter, rootFifth;
//    double frogStartPos_X, frogStartPos_Y;
//    double space, tmp;
//    double carMinY, carMaxY, pondsOffset; 
//    double mowerOffsetL;
//    double mowerOffsetR;
//    double mowerRange;
//    double smallFrogOffset = 7;
//    char mowerDir;
//    double junkMinY, junkMaxY;
//    byte lanesMode;
//    byte laneHeight = 50;
//
//    //layout nodes 
//    public Frog runningFrog = null;
//
////    void initBg() {
////        StackPane sp = new StackPane();
////        sp.getChildren().add(gr.roadLane_M3);
////        sp.getChildren().add(layout.hbMid);
////        root.setCenter(sp);   
////    }
//
//    double getPondSpace() {
//        return (root.getWidth() - 5 * Pond.getWidth()) / 10;
//    }
//
//    /**
//    * Calcul de l'affichage des voies d'eau
//    * en fonction de la largeur d'écran
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void setLanesViewports(Scene s) {
//
//        tmp = sc.getWidth();
//
//        Rectangle2D v0 = new Rectangle2D(0, 0, tmp, 50);
//        Rectangle2D v1 = new Rectangle2D(0, 0, tmp, 50);
//        Rectangle2D v2 = new Rectangle2D(0, 0, tmp, 50);
//        Rectangle2D v3 = new Rectangle2D(0, 0, tmp, 50);
//        Rectangle2D v4 = new Rectangle2D(0, 0, tmp, 50);
//        Rectangle2D v5 = new Rectangle2D(0, 0, tmp, 50);
//        Rectangle2D v6 = new Rectangle2D(0, 0, tmp, 50);
//        Rectangle2D v7 = new Rectangle2D(0, 0, tmp, 50);
//        Rectangle2D v8 = new Rectangle2D(0, 0, tmp, 50);
//        Rectangle2D v9 = new Rectangle2D(0, 0, tmp, 50);
//
//        ArrayList<ImageView> l = gr.lanes;
//        l.get(0).setFitWidth(tmp);
//        l.get(0).setViewport(v0);
//        l.get(1).setFitWidth(tmp);
//        l.get(1).setViewport(v1);
//        l.get(2).setFitWidth(tmp);
//        l.get(2).setViewport(v2);
//        l.get(3).setFitWidth(tmp);
//        l.get(3).setViewport(v3);
//        l.get(4).setFitWidth(tmp);
//        l.get(4).setViewport(v4);
//        l.get(5).setFitWidth(tmp);
//        l.get(5).setViewport(v5);
//        l.get(6).setFitWidth(tmp);
//        l.get(6).setViewport(v6);
//        l.get(7).setFitWidth(tmp);
//        l.get(7).setViewport(v7);
//        l.get(8).setFitWidth(tmp);
//        l.get(8).setViewport(v8);
//        l.get(9).setFitWidth(tmp);
//        l.get(9).setViewport(v9);
//        
//    }
//
//    /**
//    * Mise en place des voies
//    * 
//    * @author jb
//    * @version %v%
//    */
//    @SuppressWarnings("empty-statement")
//    void initLanes(Scene s) {
//        
//        layout.hbMid.setAlignment(Pos.TOP_LEFT);
//        layout.hbMid.getChildren().clear();
//        int i;
//        for (i=0;i<gr.lanes.size();i++){
//            layout.hbMid.getChildren().add(gr.lanes.get(i));
//        }
//        setLanesViewports(s);
//        lanesMode = 10;
//    }
//
//    /**
//    * Calcul du nombre de grenouilles disponibles
//    * 
//    * @author jb
//    * @version %v%
//    */
//    public void updateFrogPool() {
////        frogPool.getChildren().clear();
////        int i = 0;
////        for (i = 0; i < frogs.size(); i++) {
////            if (frogs.get(i).status == Frog.Status.POOL) {
////                frogPool.getChildren().add(frogs.get(i));
////            }
////        }
//    }
//
//     /**
//    * Fonction clé:
//    * Mise en place de la grenouille courante
//    * avec task et déclaration de thread
//    * 
//    * @author jb
//    * @version %v%
//    */
//    public void setRunningFrog(Frog.Status fst) {
//        
////        audio.carsMix_mp.stop();
////        arrowKeysEnabled = false;
////        int q = frogPool.getChildren().size() - 1;
////        frogs.get(q).status = fst;
////        runningFrog = frogs.get(q);
////        runningFrog.setIndex((byte) (4 - (byte)q));
////
////        centerDashboard.getChildren().clear();
////        mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 60));
////        centerDashboard.getChildren().add(mainMsg);
////        mainMsg.setText(""+runningFrog.getIndex());
////        greatbell1Sound.play();
////        
////        transitScale(mainMsg, 5,5,1, Duration.millis(500));
////        
////        Task<Void> goFroggy = new Task<Void>() {
////            @Override
////            protected Void call() throws Exception {
////                try {
////                    Thread.sleep(400);//2000
////                } catch (InterruptedException e) {
////                }
////                return null;
////            }
////        };
////        goFroggy.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
////            
////            @Override
////            public void handle(WorkerStateEvent event) {
////
////                root.getChildren().add(runningFrog);
////                getFrogStartPos();
////                runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
////                RotateTransition rt=new RotateTransition(Duration.millis(150),runningFrog);
////                rt.setByAngle(360f);
////                runningFrog.setScaleX(2);
////                runningFrog.setScaleY(2);
////                ScaleTransition st = new ScaleTransition(Duration.millis(1000),runningFrog);
////                st.setToX(1);
////                st.setToY(1);
////                ParallelTransition pt = new ParallelTransition();
////                pt.getChildren().addAll(rt,st);
////                pt.play();
////                
////                pt.setOnFinished(new EventHandler<ActionEvent>(){
////                    @Override
////                    public void handle(ActionEvent e) {
////                        arrowKeysEnabled=true;
////                    }
////                });
////
////                updateFrogPool();
////                audio.background_mp.play();    
////
////            }
////        });
////        new Thread(goFroggy).start();
//  
//    }
//
//    void transitScale(Node n, int inX,int inY,int out, Duration d){
//
//        n.setScaleX(inX);
//        n.setScaleY(inY);
//        ScaleTransition st = new ScaleTransition(d,n);
//        st.setToX(out);
//        st.setToY(out);
//        st.play();
//        
// }
//
//    void getFrogStartPos() {
//        if (runningFrog != null) {
//            frogStartPos_X = root.getWidth() / 2 - (runningFrog.getLayoutBounds().getWidth() / 2);
//            frogStartPos_Y = layout.hbBot.getLayoutY() + 12 + smallFrogOffset;
//        }
//    }
//    
//    /**
//    * Aspect visuel noyade grenouille
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void drown(Frog f){
//        
////        f.setStatus(Frog.Status.DROWNED);
////        ft2 = new FadeTransition(Duration.millis(750),f);
////        ft2.setFromValue(1.0);
////        ft2.setToValue(0.0);
////        ft2.play();
////        ft2.setOnFinished(new EventHandler<ActionEvent>(){
////            @Override
////            public void handle(ActionEvent e) {
////                root.getChildren().remove(f);
////                gm.getCurrentGame().setNextFrog();
////
////                //PATCH
////                if(frogPool.getChildren().isEmpty()){
////                    audio.background_mp.stop();
////                    audio.mower_mp.stop();
////                    audio.carsMix_mp.stop();
////                    audio.bugSound.setVolume(0);
////                    layout.centerDashboard.getChildren().clear();
////                    mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
////                    layout.centerDashboard.getChildren().add(mainMsg);
////                    mainMsg.setText("GAME\nOVER");
////                    root.getChildren().removeAll(cars);
////                    root.getChildren().removeAll(junk);
////                    root.getChildren().removeAll(mower,runningFrog,bug);
////                }
////            }
////        });
//
//    }
//    
//    /**
//    * Aspect visuel grenouille tondue
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void mow(Stage s, Frog f){
//        
////        audio.n2Sound.play();
////
////        f.setStatus(Frog.Status.MOWED);
////        RotateTransition rt=new RotateTransition(Duration.millis(500),f);
////                rt.setByAngle(240f);
////                f.setScaleX(.5);
////                f.setScaleY(1);
////                f.setLayoutY(f.getLayoutY()-8);
////                ScaleTransition st = new ScaleTransition(Duration.millis(500),f);
////                st.setToX(1);
////                st.setToY(1);
////                ParallelTransition pt = new ParallelTransition();
////                pt.getChildren().addAll(rt,st);
////                pt.play();
////                
////                pt.setOnFinished(new EventHandler<ActionEvent>(){
////                    @Override
////                    public void handle(ActionEvent e) {
////                        root.getChildren().remove(runningFrog);
////                        
////                        //PATCH
////                        if(frogPool.getChildren().isEmpty()){
////                            audio.background_mp.stop();
////                            audio.mower_mp.stop();
////                            audio.carsMix_mp.stop();
////                            audio.bugSound.setVolume(0);
////                            layout.centerDashboard.getChildren().clear();
////                            mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
////                            layout.centerDashboard.getChildren().add(mainMsg);
////                            mainMsg.setText("GAME\nOVER");
////                            root.getChildren().removeAll(cars);
////                            root.getChildren().removeAll(junk);
////                            root.getChildren().removeAll(mower,runningFrog,bug);
////                        }else{
////                            gm.getCurrentGame().setNextFrog();
////                        }
////                    }
////                });
//
//    }
//
//    /**
//    * Fonction clé:
//    * Mouvements par flèches clavier
//    * Gestion intersection
//    * 
//    * @author jb
//    * @version %v%
//    */
//    private void initFrogs() {
//
////        Frog frog1 = new Frog(gr.frog4_Img);
////        Frog frog2 = new Frog(gr.frog3_Img);
////        Frog frog3 = new Frog(gr.frog2_Img);
////        Frog frog4 = new Frog(gr.frog1_Img);
////
////        frogs.add(frog1);
////        frogs.add(frog2);
////        frogs.add(frog3);
////        frogs.add(frog4);
////
////        updateFrogPool();
////
////        gr.frogOutline.getStyleClass().add("frogOutline");
////
////        //KEY EVENTS
////        ArrayList<String> input = new ArrayList<>();
////
////        sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
////            
////            @Override
////            public void handle(KeyEvent e) {
////                
////                    
////                    int c;
////                    for (c = 0; c < junk.size(); c++) {
////                        if (junk.get(c).getBoundsInParent().intersects(runningFrog.getBoundsInParent())){
////                               audio.yeehawSound.play();
////                        }else if(runningFrog.getLayoutY() < 250){
////                            //yeehawSound.play(); 
////                    }
////                    }
//// 
////            //alertMsg("***"+arrowKeysEnabled);
////            if (arrowKeysEnabled){
////
////                if (runningFrog.getStatus() == Frog.Status.DROWNED){
////                    //avoid action on fading frog
////                    
////                }else if (runningFrog.getStatus() == Frog.Status.RUNNING  || runningFrog.getStatus() == Frog.Status.FLOATING) {
////
////                    String code = e.getCode().toString();   
////                    if (null != code) {
////                        switch (code) {
////                            
////                        case "UP":
////
////                                //updateGamesArray(GameManager.getCurrentGame());
////                                //GameManager.saveGamesFile();
////                                
////                                //START
////                                getFrogStartPos();
////                                if (runningFrog.getLayoutY() == frogStartPos_Y) {
////                                    setScore(10);
////                                    runningFrog.relocate(runningFrog.getLayoutX(), hbTop.getLayoutY() + lanesMode * 50 + 27 + smallFrogOffset);
////                                //JUMP TO POND
////                                }else if (runningFrog != null && runningFrog.status != Frog.Status.HOME && runningFrog.getLayoutY() < 151) {
////                                    runningFrog.relocate(runningFrog.getLayoutX(), 0);
////
////                                try {
////        
////                                    int p=0;
////                                    Boolean intersects=false;
////                                    for (p = 0; p < ponds.size(); p++) {
////
////                                        //INTERSECT
////                                        if (  ponds.get(p).getBoundsInParent().intersects(runningFrog.getBoundsInParent())){
////
////                                            intersects=true;
////
////                                            //pond dispo
////                                            if (ponds.get(p).status == Pond.Status.EMPTY) {
////                                                int s = gm.getCurrentGame().getScore() * 
////                                                    (gm.getCurrentGame().frogTimeLimit - gm.getCurrentGame().getFrogTime());
////                                                    setScore(s);
////                                                pondSplashSound.play();
////                                                runningFrog.relocate(ponds.get(p).getLayoutX() + 29, ponds.get(p).getLayoutY()+15);
////                                                runningFrog.status = Frog.Status.HOME;
////                                                ponds.get(p).setStatus(Pond.Status.FROGGED);
////                                                Pond.froggedTotal++;
////
////                                                if (Pond.getFroggedTotal() == 3){
////                                                    setUserInputGrid();
////                                                }
////
////                                            }else{//POND OCCUPIED
////                                                setScore(-2000);
////                                                root.getChildren().remove(runningFrog);
////                                            }
////
////                                        //NO INTERSECT
////                                        } else {
////                                        }
////                                    }
////
////                                    if (!intersects){
////                                        root.getChildren().remove(runningFrog);
////                                    }
////
//////                                    int s = gm.getCurrentGame().getScore() * 
//////                                        (gm.getCurrentGame().frogTimeLimit - gm.getCurrentGame().getFrogTime());
//////                                    setScore(s);
////
////                                    if (frogPool.getChildren().isEmpty()) {
////
////                                        setCenterDashboard("GAME\nOVER");
////                                        gm.getCurrentGame().getTl().stop();
////                                        //userInput
////                                        updateGamesArray(GameManager.getCurrentGame());//player, score, level
////                                        //GameManager.saveScores();
////                                    }else{
////                                        gm.getCurrentGame().setNextFrog();
////                                    }
////
////                                }catch (Error e2) {
////                                    alertMsg(e2.getMessage());
////                                }
////                                
////                                //LEAP OR DROWN
////                                
////                                } else{
////                                    
////                                    //g.setEffect(new BoxBlur(3, 3, 3));//w h iter
////                                    //setParticles(g1);
////                                    runningFrog.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY() - Frog.frogLeap);
////                                    if (runningFrog.getLayoutY()<junkMaxY+50){
////                                        drown(runningFrog);
////                                    }else{
////                                        setScore(10);    
////                                    }
////                                }
////                                    
////                                break;
////
////                            case "DOWN":
////                                if (runningFrog.getLayoutY() != frogStartPos_Y){
////                                    if (runningFrog.getLayoutY() < frogStartPos_Y) {
////                                        //GET BACK FROM LOWEST LANE
////                                        if (runningFrog.getLayoutY() == hbTop.getLayoutY() + lanesMode * 50 + 27 + smallFrogOffset) {
////                                            getFrogStartPos();
////                                            runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
////                                            setScore(-10);
////                                        //JUMP DOWN
////                                        } else {
////                                            runningFrog.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY() + Frog.frogLeap);
////                                            if (runningFrog.getLayoutY()<junkMaxY+50){
////                                                drown(runningFrog);
////                                            }else{
////                                                setScore(-10);    
////                                            }   
////                                        }
////                                    }
////                                }
////                                break;
////                                
////                            case "LEFT":   
////                                if (runningFrog.getLayoutY() != frogStartPos_Y && runningFrog.getLayoutX()>50){
////                                //LEAP OR DROWN
////                                    runningFrog.relocate(runningFrog.getLayoutX() - Frog.frogLeap, runningFrog.getLayoutY());
////                                    //System.out.println("---------"+runningFrog.getStatus());
////                                    if (runningFrog.getLayoutY()<junkMaxY+50){
////                                        drown(runningFrog);
////                                    }
////                                }
////                                break;
////                                
////                            case "RIGHT":
////                                if (runningFrog.getLayoutY() != frogStartPos_Y && runningFrog.getLayoutX()<sc.getWidth()-100){
////                                    runningFrog.relocate(runningFrog.getLayoutX() + Frog.frogLeap, runningFrog.getLayoutY());
////                                    //System.out.println("---------"+runningFrog.getStatus());
////                                    if (runningFrog.getLayoutY()<junkMaxY+50){
////                                        drown(runningFrog);
////                                    }
////                                }
////                                break;
////                            default:
////                                break;
////                        }
////                        
////                    }
////
////                    // only add once... prevent key ip duplicates
////                    if (!input.contains(code)) {
////                        input.add(code);
////                    }  
////                }
////            }
////        }
////        });
////
////        sc.setOnKeyReleased((KeyEvent e) -> {
////            String code = e.getCode().toString();
////            input.remove(code);
////        });
//
//    }
//    
//    public void setCounterDisplays(int fTime,int gTime){
//        //frogCounterText.setText("0'"+fTime);
//        //gameCounterText.setText("0'"+gTime);    
//    }
//    
//    public void setScoreDisplay(int s){
//        //scoreText.setText(Integer.toString(s));  
//    }
//
//    public void setCenterDashboard(String s){
////
////        audio.background_mp.stop();
////        audio.carsMix_mp.stop();
////        audio.mower_mp.stop();
////        audio.bugSound.setVolume(0);
////        audio.gameoverSound.play();
////        layout.centerDashboard.getChildren().clear();
////        mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
////        layout.centerDashboard.getChildren().add(mainMsg);
////        mainMsg.setText("GAME\nOVER");
//
//    }
//
//    
//
//    private void initCars() {
//
//        Car redCar = new Car(gr.rdCar);
//        Car whiteCar = new Car(gr.whteBeetle);
//        Car redPickup = new Car(gr.rdPckup);
//        Car yellowCab = new Car(gr.yllwCab);
//        Car police2 = new Car(gr.plice2);
//        Car police3 = new Car(gr.plice3);
//        Car UKmini = new Car(gr.UKmni);
//        Car ambu2 = new Car(gr.mblance2);
//        Car cementMixer = new Car(gr.cmntMixer);
//        Car policeBlack = new Car(gr.pliceBlack);
//        Car orangeBeetle = new Car(gr.rngBeetle);
//        Car blueConvertible = new Car(gr.blcnv);
//        Car largePickup = new Car(gr.lrgPickup);
//
////        cars.add(redCar);
////        cars.add(whiteCar);
////        cars.add(redPickup);
////        cars.add(yellowCab);
////        cars.add(police2);
////        cars.add(police3);
////        cars.add(UKmini);
//        //cars.add(largePickup);
//        //cars.add(blueConvertible);
//        //cars.add(orangeBeetle);
//        //cars.add(cementMixer);
//
//        setCarsParameters();
//
//    }
//
//    private void setCarsParameters() {
//
////        Car.initCarIndividualSpeed = 7;
////        Car.individualCarSpeedIncr = 1; //tricky value
////        Car.carSpeedLimit = 10;//15
////
////        int i, j; //cars array
////        for (i = 0; i < cars.size(); i++) {
////            j = i + 1;
////            cars.get(i).setSpeed(Car.initCarIndividualSpeed);
////            //revoir
////            cars.get(i).relocate((-i * Car.bumperOffset) - 400, 325);
////            Car.initCarIndividualSpeed = Car.initCarIndividualSpeed + Car.individualCarSpeedIncr;
////        }
//    }
//    
//    private void initJunk() {
//
////        Junk wheel = new Junk(gr.whl);
////        Junk tyre = new Junk(gr.tre);
////        Junk bottle1 = new Junk(gr.bttl1);
////        Junk bottle2 = new Junk(gr.bttl2);
////        Junk bottle3 = new Junk(gr.bttl3);
////        Junk wheel2 = new Junk(gr.whl);
////        Junk tyre2 = new Junk(gr.tre);
////        Junk bg1 = new Junk(gr.bag1);
////        Junk bg2 = new Junk(gr.bag2);
////        Junk cd2 = new Junk(gr.cad2);
////        Junk cn = new Junk(gr.can);
////
////        junk.add(bottle1);
////        junk.add(bottle2);
////        junk.add(bottle3);
////        //junk.add(tyre2);
////        junk.add(bg1);
////        junk.add(bg2);
////        junk.add(cn);
////        //junk.add(wheel);
////        junk.add(tyre);
////        junk.add(wheel2);
////        
////        junkRotateValue=1;
//
//    }
//
//    /**
//    *Paramétrage stage
//    * <p>
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void setStage(Stage s) {
//
//        s.setMinHeight(490);
//        s.setMinWidth(800);
//        s.setScene(sc);
//        s.setTitle("F R O G G E R  16");
//        s.setFullScreen(true);      //CHECK LATER  nodes pos bug
//        s.setFullScreenExitHint("");
////        hbMid.setAlignment(Pos.CENTER);
////        hbMid.getChildren().add(splash);
//
//    }
//
//    void addCars() {
////        int i;
////        for (i = 0; i < cars.size(); i++) {
////            root.getChildren().add(cars.get(i));
////        }
//// 
//    }
//    
//    void addJunk() {
////        int i;
////        for (i = 0; i < junk.size(); i++) {
////            //junk.get(i).setOpacity(0.6);
////            root.getChildren().add(junk.get(i));
////            
////        }
//    }
//    
//    /**
//    *Paramétrage audio:
//    *TODO: migration mediaClip
//    * <p>
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void setSound() {
//        
//        
//        
//        //dplash2_mp.play();
//
//    }
//    
//    void setParticles(Group g, double d, double o ,double dur, double s){
//        
//        g = new Group();
//        for (int i = 0; i < 1; i++) {
//           Circle circle = new Circle(d, Color.web("black", 1));
//           circle.setCenterX(0f);
//            circle.setCenterY(300.0f);
//            circle.setOpacity(o);
//           g.getChildren().add(circle);
//        }
//
//        root.getChildren().add(g);
//        g.setEffect(new BoxBlur(5, 5, 3));//w h iter
//        Timeline timeline = new Timeline();
//        
//        for (Node circle: g.getChildren()) {
//            
////            timeline.getKeyFrames().addAll(
////                new KeyFrame(Duration.ZERO, // set start position at 0
////                    new KeyValue(circle.translateXProperty(), random() * 1400),
////                    new KeyValue(circle.translateYProperty(), random() * 300)//10
////                ),
////                new KeyFrame(new Duration(dur), // set end position at 40s
////                    new KeyValue(circle.translateXProperty(), random() * 1400),
////                    new KeyValue(circle.translateYProperty(), random() * s)
////                )
////            );
////            
//        }
//        
//        //play 40s of animation
//        timeline.play();
//
//    }
//    
//    /**
//    *Mise en place contenus:
//    *<ul>
//    * <li>du menu (boutons, labels, ...
//    * <li>du terrain de jeu (voitures, grenouilles, voies, ...)
//    * </ul>
//    * <p>
//    * 
//    * @author jb
//    * @version %v%
//    */
//    //void setGUI(Scene s, GUIMode gmo) {     //virer gmo param?
//
////        if (GMode == GUIMode.MENU) {
////
////            setButts();
////            setMenuGrid();
////
////        } else if (GMode == GUIMode.GAME) {
////
//////            String image = JavaFXApplication9.class.getResource("/img/junk/junkBg4.png").toExternalForm();
//////            hbMid.setStyle("-fx-background-image: url('" + image + "'); " +
//////           "-fx-background-position: left top; " +
//////           "-fx-background-size:   2500,200  ; " +
//////           "-fx-background-repeat: stretch;");
////
////            initPonds();
////            initLanes(s);
////            initDashboard();
////            initCars();
////            initJunk();
////            addCars();
////            
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
//        //}
//
//    //}
//
//    /**
//    *Terrain de jeu:
//    *<ul>
//    * <li>Initialisation GUI
//    * <li>Paramétrage stage
//    * <li>Paramétrage audio
//    * <li>Lancement thread intro 
//    * </ul>
//    * <p>
//    * 
//    * @author jb
//    * @version %v%
//    */
//    @Override //Application start
//    public void start(Stage st) throws InterruptedException {
//        layout.initScene(st);
//        setStage(st);
//        //setSound();
//        Thread.sleep(500);
//        Task<Void> intro = new Task<Void>() {
//            @Override
//            protected Void call() throws Exception {
//                try {
//                    Thread.sleep(500);//2000
//                } catch (InterruptedException e) {
//                }
//                return null;
//            }
//        };
//        intro.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
////                setGUI(sc, GMode);
////                initGame((Game.Level)(Object)levelSelector.getSelectedToggle().getUserData());
////                gm = new GameManager();
//                
//            }
//        });
//        
//        new Thread(intro).start();
//    
//        //playMowerOnce(root);    
//
//        /**
//        *Gestion objets / mouvements
//        * <ul>
//        * <li>Mare previousCandidate, tmpPond
//        * <li>Placement aléatoire bug
//        * <li>Statut mares
//        * <li>Paramétrage selon nombre de voies
//        * <li>Tondeuse
//        * <li>Cadrage voitures
//        * <li>Interaction voitures et vitesse voitures
//        * <li>Mouvements voitures
//        * <li>Intersection voiture/grenouille
//        * <li>Gestion ordures
//        * <li>Intersection ordure/grenouille
//        * </ul>
//        * <p>
//        * 
//        * @author jb
//        * @version %v%
//        */
//        new AnimationTimer() {
//            
//            Pond tmpPond = new Pond();
//            Pond.Status previousStatus;
//            Pond previousCandidate = new Pond();
//
//            
//            @Override
//            public void handle(long now) {
//
////                if (GMode == GUIMode.GAME) {
////                    
////                    if (gm.getCurrentGame().getLevel()==Game.Level.EXPERT){
////                        if (gm.getCurrentGame().getGameTime()==2.0000000){
////                            setParticles(g1,10,0.3,12000,300);
////                        }else if (gm.getCurrentGame().getGameTime()==6.0000000){
////                            setParticles(g2,15,0.4,10000,300);
////                        }else if (gm.getCurrentGame().getGameTime()==8.0000000){
////                            setParticles(g3,20,0.5,15000,300);
////                        }else if (gm.getCurrentGame().getGameTime()==12.0000000){
////                            setParticles(g4,25,0.6,5000,300);
////                        }else if (gm.getCurrentGame().getGameTime()==16.0000000){
////                            setParticles(g5,40,0.7,10000,300);
////                        }else if (gm.getCurrentGame().getGameTime()==20.0000000){
////                            setParticles(g6,50,0.7,30000,300);
////                        }
////                        //g6.relocate(0, 0);
////                        
////                }
////
////                    //gestion du bug
////                    if (gm.getCurrentGame().getGameTime()==refTime/10){
////                        int b;
////                        for(b=0;b<ponds.size();b++){
////                            if (ponds.get(b).getStatus()==Pond.Status.BUGGED){
////                            ponds.get(b).setStatus(Pond.Status.EMPTY);
////                            }
////                        }
////
////                        Pond.candidate = (int) Math.round(Math.random()*10);
////                        if (Pond.candidate<5){
////
////                            tmpPond = ponds.get(Pond.candidate);
////
////                            if (tmpPond.getStatus()!=Pond.Status.FROGGED){
////                                tmpPond.setStatus(Pond.Status.BUGGED);
////                                bugSound.play();
////                                bug.relocate(tmpPond.getLayoutX()+37,bug.getLayoutY());    
////                            }
////                        }
////                        
////                        //checkBug();
////                        refTime+=5;
////   
////                    }
////                    
////                    switch (lanesMode) {
////                        case 2:
////                            carMinY = 126;
////                            carMaxY = 126;
////                            junkMaxY = 80;
////                            break;
////                        case 4:
////                            carMinY = 176;
////                            carMaxY = 226;
////                            junkMaxY = 80;
////                            break;
////                        case 6:
////                            carMinY = 226;
////                            carMaxY = 326;
////                            junkMaxY = 80+laneHeight;
////                            break;
////                        case 8:
////                            carMinY = 276;
////                            carMaxY = 426;
////                            junkMaxY = 80+2*laneHeight;
////                            break;
////                        case 10:
////                            carMinY = 326;
////                            carMaxY = 526;
////                            junkMaxY = 80+3*laneHeight;
////                            break;
////                        default:
////                            break;
////                    }
////                    
////                    junkMinY = 85;
////                    
////                    
////                    //MOWER
////                    mowerOffsetL--;
////                    mowerOffsetR--;
////                    
////                    if (mower.getLayoutX() < -50) {//2000    
////                        mowerOffsetL = 700;
////                        mowerOffsetR = mowerOffsetL+mowerRange;
////                        mower.setLayoutX(sc.getWidth() + 50);
////                    }else if (mower.getLayoutX() < 400) {
////                        mower.setLayoutX(mower.getLayoutX()-mowerSpeed); 
////                    }else {
////                        if (mowerDir=='L'){
////                            if (mower.getLayoutX()>mowerOffsetL && mower.getLayoutX()>mowerOffsetR){
////                                mower.setLayoutX(mower.getLayoutX()-mowerSpeed);
////                                mower.setLayoutY(carMinY - 40);
////                            }else if(mower.getLayoutX()>mowerOffsetL && mower.getLayoutX()<mowerOffsetR){
////                                mower.setLayoutX(mower.getLayoutX()-5);
////                            }else if (mower.getLayoutX()<mowerOffsetL && mower.getLayoutX()<mowerOffsetR){
////                                mower.setLayoutX(mower.getLayoutX()+5);
////                                mowerDir='R';
////                            }
////                        }else{
////                            if (mower.getLayoutX()<mowerOffsetR){
////                                mower.setLayoutX(mower.getLayoutX()+5);
////                            }else if (mower.getLayoutX()>mowerOffsetR){
////                                mower.setLayoutX(mower.getLayoutX()-5);
////                                mowerDir='L';
////                            }
////                        }   
////                    }
////
////                    //cadrage XY voitures
////                    int a, b;
////                    for (a = 0; a < cars.size(); a++) {
////
////                        b = a + 1;
////
////                        //reset to left and to lower lane
////                        if (cars.get(a).getLayoutX() > sc.getWidth() + 600) {//2000
////                            cars.get(a).relocate(-600, cars.get(a).getLayoutY() + 50);
////                        }
////
////                        //if lower limit: get back to top                        
////                        if (cars.get(a).getLayoutY() > carMaxY) {
////                            cars.get(a).relocate(-b * Car.bumperOffset, carMinY);
////                        }
////                    }
////
////                    //interaction voitures et vitesse voitures
////                    int i, j, k;
////                    k = cars.size() - 1;
////
////                    for (i = 0; i < cars.size(); i++) {
////
////                        for (j = k; j > -1; j--) {
////
////                            if (cars.get(i).getLayoutY() == cars.get(j).getLayoutY()) {
////
////                                if (cars.get(j).getSpeed() > cars.get(i).getSpeed()
////                                        && cars.get(j).getLayoutX() < cars.get(i).getLayoutX() - 60
////                                        && cars.get(j).getLayoutX() > cars.get(i).getLayoutX() - 160) {
////                                    cars.get(j).setSpeed(cars.get(i).getSpeed() - 1);
////
////                                } else if (cars.get(j).getSpeed() < cars.get(i).getSpeed()
////                                        && cars.get(j).getLayoutX() > cars.get(i).getLayoutX() + 150
////                                        && cars.get(j).getLayoutX() < cars.get(i).getLayoutX() + 250) //speed limit
////                                {
////                                    if (cars.get(i).getSpeed() > carSpeedLimit) {
////                                        cars.get(i).setSpeed(cars.get(i).getSpeed() - 7);
////                                    } else {
////                                        cars.get(j).setSpeed(cars.get(i).getSpeed() + 1);
////                                    }
////                                }
////                            }
////                        }
////                    
////                    }
////
////                    //mouvements voitures
////                    int r;
////                    for (r = 0; r < cars.size(); r++) {
////                        cars.get(r).relocate(cars.get(r).getLayoutX() + cars.get(r).getSpeed(), cars.get(r).getLayoutY());
////                        
////                        //intersection voiture/grenouille
////                        if (runningFrog != null) {
////                            try {
////                                if (cars.get(r).getBoundsInParent().intersects(runningFrog.getBoundsInParent())) {
////                                
////                                    impactSound.play();
////                                    root.getChildren().remove(frogOutline);
////                                    root.getChildren().add(3, frogOutline);
////                                    frogOutline.setOpacity(1);
////                                    frogOutline.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY());
////                                    
////                                    if (gm.getCurrentGame().getLevel()==Game.Level.BEGINNER){
////                                        getFrogStartPos();
////                                        runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
////                                        runningFrog.setLayoutY(frogStartPos_Y);
////                                        setScore(-50);
////                                    }else{
////                                        
////                                        root.getChildren().remove(runningFrog);
////                        
////                                        //PATCH
////                                        if(frogPool.getChildren().isEmpty()){
////                                            background_mp.stop();
////                                            mower_mp.stop();
////                                            carsMix_mp.stop();
////                                            bugSound.setVolume(0);
////                                            centerDashboard.getChildren().clear();
////                                            mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
////                                            centerDashboard.getChildren().add(mainMsg);
////                                            mainMsg.setText("GAME\nOVER");
////                                            root.getChildren().removeAll(cars);
////                                            root.getChildren().removeAll(junk);
////                                            root.getChildren().removeAll(mower,runningFrog,bug);
////                                        }else{
////                                            gm.getCurrentGame().setNextFrog();
////                                        }
////                                        
////                                    }
////                                    //gm.getCurrentGame().updateFrogManagement();
////                                }
////                            } catch (Error e) {
////                                GameManager.alertMsg(e.getMessage());
////                            }
////                        }
////                    }
////                    
////                    //gestion tondeuse
////                    if (gm.getCurrentGame().getLevel()!=Game.Level.BEGINNER 
////                            && mower.getBoundsInParent().intersects(runningFrog.getBoundsInParent())) {
////                        mow(st, runningFrog); 
////                        //root.getChildren().remove(frogOutline);
////                        //root.getChildren().remove(runningFrog);
////                                    //root.getChildren().add(3, frogOutline);
////                                    //frogOutline.setOpacity(1);
////                    }
////                    
////                    
////                    //gestion ordures
////                    junkRotateValue++;
////                    double d;
////                    int c,g;
////                    for (c = 0; c < junk.size(); c++) {
////                        g=c+1;
////                        d = ((double)g)/5;
////                        junk.get(c).setRotate(junkRotateValue+50*c);
////                        
////                        //JUNK X LIMITS
////                        if ((c % 2) == 0){//GOES LEFT
////                            if (junk.get(c).getLayoutX() <= 0) {  //2000
////                                junk.get(c).setLayoutX(sc.getWidth()-10);
////                            }
////                            
////                            //junk.get(c).relocate(junk.get(c).getLayoutX() - (junk.get(c).getSpeed()+(g-Junk.speedFactor)), junk.get(c).getLayoutY());
////                            junk.get(c).relocate(junk.get(c).getLayoutX() - g/Junk.speedFactor, junk.get(c).getLayoutY());
////                               
////                        }else{//GOES RIGHT
////                            if (junk.get(c).getLayoutX() >= sc.getWidth()-10) {  //2000
////                                junk.get(c).setLayoutX(0);
////                            }
////                            junk.get(c).relocate(junk.get(c).getLayoutX() + g/Junk.speedFactor, junk.get(c).getLayoutY());
////                            //junk.get(c).relocate(junk.get(c).getLayoutX() + (junk.get(c).getSpeed()+(g-Junk.speedFactor)), junk.get(c).getLayoutY());   
////                        }
////
////
////                        //intersection ordure/grenouille
////                        if (runningFrog != null) {
////                            try {
////                                if (junk.get(c).getBoundsInParent().intersects(runningFrog.getBoundsInParent())) {
////                                    ft2.stop();
////                                    runningFrog.setStatus(Frog.Status.FLOATING);
////                                    runningFrog.relocate(junk.get(c).getLayoutX(), junk.get(c).getLayoutY());
////                                 }
////                            } catch (Error e) {
////                                GameManager.alertMsg(e.getMessage());
////                            }
////                        }
////
////                        //JUNK Y LIMITS  
////                        if (junk.get(c).getLayoutY() >= junkMaxY+1+bumpFactor) {
////                            junk.get(c).setDirection(Junk.Direction.UP);
////                        }else if (junk.get(c).getLayoutY() <= junkMinY-1-bumpFactor) {
////                            junk.get(c).setDirection(Junk.Direction.DOWN);
////                        }
////                        if (junk.get(c).getDirection()==Junk.Direction.UP){
////                            junk.get(c).setLayoutY(junk.get(c).getLayoutY()-d-bumpFactor); 
////                        }else if (junk.get(c).getDirection()==Junk.Direction.DOWN){
////                            junk.get(c).setLayoutY(junk.get(c).getLayoutY()+d+bumpFactor);
////                        }
////
////                    }
////
////                    eraseFrog();
////                }
//            }
//        } 
//             
//        .start();
//        st.show();
//        //Thread.sleep(2000);
//        //hbMid.getChildren().remove(splash);
//
//    }
//    
//    /**
//    *Aller retour simple tondeuse
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void playMowerOnce(BorderPane bp){      
////       
////        final Timeline timeline = new Timeline();
////        timeline.setCycleCount(Timeline.INDEFINITE);
////        timeline.setAutoReverse(true);
////        final KeyValue kv = new KeyValue(mower.xProperty(),1500 );
////        final KeyFrame kf = new KeyFrame(Duration.millis(8000), kv);
////        timeline.getKeyFrames().add(kf);
////        timeline.play();
//        
//    }
//    
//    /**
//    *Effacement grenouille sur la route
//    * <p>
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void eraseFrog(){
////        frogOutline.setOpacity((frogOutline.getOpacity())-(0.007));
////        if (frogOutline.getOpacity()==0){
////            root.getChildren().remove(frogOutline);
////        }
//    }
//    
//    /**
//    *Test développement
//    * <p>
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void checkBug(){
////        int b;
////        System.out.println("");
////        for(b=0;b<ponds.size();b++){
////            System.out.println("bug "+ponds.get(b).getStatus());
////        }
////        System.out.println("");
//    }
//
//    public void updateDraw(Stage st) {
////        try{
////        //NODES TO LANES MANAGEMENT
////        if (GMode == GUIMode.MENU) {
////            //
////        } else if (GMode == GUIMode.GAME) {
////
////            hbTop.setSpacing(getPondSpace());
////
////            setLanesViewports(sc);
////
////            rootMid = root.getWidth() / 2;
////            rootQuarter = root.getWidth() / 4;
////            rootCenter=root.getHeight() / 2;
////            
////            bug.relocate(hbTop.getChildren().get(2).getLayoutX()+19, hbTop.getChildren().get(2).getLayoutY()+23);
////            
////            //FROG
////            frogStartPos_X = root.getWidth() / 2 - (runningFrog.getLayoutBounds().getWidth() / 2);
////            frogStartPos_Y = hbBot.getLayoutY() + 12;
////            runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
////
////            //LANES & CARS
////            int f;
////
////            if (hbMid.getChildren().isEmpty()) {
////
////            } else if (st.getHeight() < 385) {
////
////                if (lanesMode == 4) {
////
////                    lanesMode = 2;
////                    hbMid.getChildren().clear();
////                    hbMid.getChildren().add(lanes.get(0));
////                    hbMid.getChildren().add(lanes.get(6));
////
////                }
////
////            } else if (lanesMode == 2) {
////
////                hbMid.getChildren().clear();
////                hbMid.getChildren().add(lanes.get(0));
////                hbMid.getChildren().add(lanes.get(4));
////                hbMid.getChildren().add(lanes.get(5));
////                hbMid.getChildren().add(lanes.get(9));
////                lanesMode = 4;
////
////            } else if (st.getHeight() < 485) {
////
////                if (lanesMode == 6) {
////
////                    lanesMode = 4;
////                    hbMid.getChildren().remove(1);
////                    hbMid.getChildren().remove(3);
////
////                }
////
////            } else if (lanesMode == 4) {
////
////                hbMid.getChildren().clear();
////                hbMid.getChildren().add(lanes.get(0));
////                hbMid.getChildren().add(lanes.get(1));
////                hbMid.getChildren().add(lanes.get(4));
////                hbMid.getChildren().add(lanes.get(5));
////                hbMid.getChildren().add(lanes.get(6));
////                hbMid.getChildren().add(lanes.get(9));
////                lanesMode = 6;
////
////            } else if (st.getHeight() < 585) {
////
////                if (lanesMode == 8) {
////
////                    hbMid.getChildren().remove(1);
////                    hbMid.getChildren().remove(4);
////                    lanesMode = 6;
////
////                }
////
////            } else if (lanesMode == 6) {
////
////                hbMid.getChildren().clear();
////                int i, k;
////                for (i = 0; i < 3; i++) {
////                    hbMid.getChildren().add(lanes.get(i));
////                }
////                hbMid.getChildren().add(lanes.get(5));
////                //hbMid.getChildren().add(lanes.get(6));
////                hbMid.getChildren().add(3, lanes.get(4));
////                hbMid.getChildren().add(lanes.get(7));
////                hbMid.getChildren().add(lanes.get(8));
////                hbMid.getChildren().add(lanes.get(9));
////                lanesMode = 8;
////
////            } else if (st.getHeight() < 685) {
////
////                if (lanesMode == 10) {
////
////                    hbMid.getChildren().remove(4);
////                    hbMid.getChildren().remove(3);
////                    hbMid.getChildren().add(3, lanes.get(4));
////                    hbMid.getChildren().remove(7);
////                    lanesMode = 8;
////
////                }
////                
////              //lanesMode = 8;
////            } else if (lanesMode == 8){
////
////                hbMid.getChildren().clear();
////                int i;
////                for (i = 0; i < lanesMode + 2; i++) {
////                    hbMid.getChildren().add(lanes.get(i));
////                }
////                lanesMode = 10;
////            }
////
////            //RELOCATES
////
////            for (f = 0; f < cars.size(); f++) {
////                cars.get(f).relocate(cars.get(f).getLayoutX(), carMinY-1);
////            }
////            
////            // CODE OK
////            for (f = 0; f < junk.size(); f++) {
////                junk.get(f).relocate(junk.get(f).getLayoutX(), junkMinY);
////            }
////
////        }    
////        }catch(Error e){
////                
////            }
//    }
//    
////    public void main(String[] args) {
////        System.out.println("launching");
////            launch();
////    }
//
//}
