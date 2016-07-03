//
//
//import frogger.*;
//import java.io.File;
//import java.util.ArrayList;
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.SubScene;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.stage.Stage;
//import javafx.application.Platform;
//import javafx.geometry.HPos;
//import javafx.geometry.Rectangle2D;
//import javafx.geometry.VPos;
//import javafx.scene.control.Label;
//import javafx.scene.control.ProgressBar;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Toggle;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.GridPane;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import javafx.concurrent.Task;
//import javafx.concurrent.WorkerStateEvent;
//import javafx.scene.media.AudioClip;
//import static frogger.GameManager.*;
//import static frogger.Junk.bumpFactor;
//import static java.lang.Math.random;
//import java.nio.file.Paths;
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
//public class GUIManager_24 extends Application {
//
//    //graphics
//    Image splash_Img = new Image("img/splash.png");
//
//    Image menu_Img = new Image("img/frogs/niceIntro.jpg");
//    Image frog_Img = new Image("img/frogs/frog30_4.png");
//    Image frog1_Img = new Image("img/frogs/frog30_1.png");
//    Image frog2_Img = new Image("img/frogs/frog30_2.png");
//    Image frog3_Img = new Image("img/frogs/frog30_3.png");
//    Image frog4_Img = new Image("img/frogs/frog30_4.png");
//    Image frgtline_Img = new Image("img/frogs/transpWhiteOutline_30.png");
//    Image pnd_Img = new Image("img/frogs/pondAndLily.png");
//    Image lily = new Image("img/frogs/lily.jpg");
//
//    Image wtrLane = new Image("img/lanes/waterstrand.png");
//    Image lwnLane_Img = new Image("img/lanes/lawnstrand3.png");
//    Image rdLane_U = new Image("img/lanes/road1_H50_upperhalf.png");
//    Image rdLane_L = new Image("img/lanes/road1_H50_lowerhalf.png");
//    Image rdLane_M = new Image("img/lanes/road1_H50_midhalf.png");
//
//    Image rdCar = new Image("img/cars/redcar.png");
//    Image whteBeetle = new Image("img/cars/whiteBeetle.png");
//    Image rdPckup = new Image("img/cars/redPickup.png");
//    Image yllwCab = new Image("img/cars/yellowCab.png");
//    Image plice2 = new Image("img/cars/police2.png");
//    Image plice3 = new Image("img/cars/police3.png");
//    Image UKmni = new Image("img/cars/UKmini.png");
//    Image mblance2 = new Image("img/cars/ambulance2.png");
//    Image cmntMixer = new Image("img/cars/cementMixer.png");
//    Image pliceBlack = new Image("img/cars/policeBlack.png");
//
//    Image rngBeetle = new Image("img/cars/orangeBeetle.png");
//    Image blcnv = new Image("img/cars/blueConvertible.png");
//    Image lrgPickup = new Image("img/cars/largePickup.png");
//
//    Image mwer = new Image("img/cars/smallhusq2.png");
//
//    Image whl = new Image("img/junk/wheel.png");
//    Image tre = new Image("img/junk/tyre.png");
//    Image bttl1 = new Image("img/junk/bottle1.png");
//    Image bttl2 = new Image("img/junk/bottle2.png");
//    Image bttl3 = new Image("img/junk/bottle3.png");
//    
//    Image bag1 = new Image("img/junk/bag1.png");
//    Image bag2 = new Image("img/junk/bag2.png");
//    Image cad2 = new Image("img/junk/cadillac2.png");
//    Image can = new Image("img/junk/can.png");
//    
//    Image bug_Img = new Image("img/bug2.png");
//
//    static Boolean arrowKeysEnabled=true;
//    
//    static Pond pond1;
//    static Pond pond2;
//    static Pond pond3;
//    static Pond pond4;
//    static Pond pond5;
//
//    //fixed graphics nodes
//    ImageView splash = new ImageView(splash_Img);
//    ImageView bug = new ImageView(bug_Img);
//    
//    ImageView menuBackground = new ImageView(menu_Img);
//
//    ImageView frog_1 = new ImageView(frog1_Img);
//    ImageView frog_2 = new ImageView(frog2_Img);
//    ImageView frog_3 = new ImageView(frog3_Img);
//    ImageView frog_4 = new ImageView(frog4_Img);
//    ImageView frogOutline = new ImageView(frgtline_Img);
//
//    ImageView waterLane_1, waterLane_2, waterLane_3, waterLane_4, waterLane_5;
//    ImageView lawnLane = new ImageView(lwnLane_Img);
//    ImageView roadLane_U = new ImageView(rdLane_U);
//    ImageView roadLane_L = new ImageView(rdLane_L);
//    ImageView roadLane_M1 = new ImageView(rdLane_M);
//    ImageView roadLane_M2 = new ImageView(rdLane_M);
//    ImageView roadLane_M3 = new ImageView(rdLane_M);
//
//    ImageView mower = new ImageView(mwer);
//    
//    static MediaPlayer background_mp;
//    static MediaPlayer funnyimact_mp;
//    static MediaPlayer dplash2_mp;
//    static MediaPlayer carsMix_mp;
//    static MediaPlayer bug_mp;
//    //static MediaPlayer yeehaw_mp;
//    static MediaPlayer mower_mp;
//    
//    static AudioClip greatbell1Sound;
//    static AudioClip yeehawSound;
//    
//    long lastUpdate = 0 ;
//    
//    static int candidate=0;
//    static int refTime=1;
//
//    final Label[] menuLabels = new Label[6];
//    static ProgressBar pBar1 = new ProgressBar();
//    static ProgressBar pBar2 = new ProgressBar();
//    final ToggleGroup levelSelector = new ToggleGroup();
//    RadioButton rb1, rb2, rb3;
//    
//    ParallelTransition pt;
//    FadeTransition ft;
//    
//    double pondWidth;
//    double rootCenter, rootMid, rootQuarter, rootFifth;
//    public static double frogStartPos_X, frogStartPos_Y;
//    double space, tmp;
//    
//    double carMinY, carMaxY, pondsOffset;
//    
//    double junkMinY, junkMaxY;
//    double carSpeedLimit, initCarIndividualSpeed, individualCarSpeedIncr;
//    byte lanesMode;
//    byte laneHeight;
//    double junkRotateValue=1;
//
//    String fontFamily_0 = "Arial";
//    String fontFamily_1 = "OCR A Extended";
//    String fontFamily_2 = "Courier New";
//    String fontFamily_3 = "OCR A Extended";
//
//    //double frogLeap = 50;
//    static double smallFrogOffset = 7;
//
//    public enum GUIMode {
//        SPLASH, MENU, GAME, OUTRO
//    }
//
//    static public Text score1 = new Text("");
//    static public Text score2 = new Text("");
//    static public Text score3 = new Text("");
//
//    //layout nodes 
//    Scene sc;
//    public static BorderPane menu, root;
//    public static Frog runningFrog = null;
//    SubScene menuSc;
//
//    public static HBox hbTop, hbBot;
//    VBox hbMid, hbLeft, hbRight;
//
//    HBox leftDashboard = new HBox();
//    public static HBox centerDashboard = new HBox();
//    HBox rightDashboard = new HBox();
//    
//    public static HBox frogPool = new HBox();
//    HBox leftLabelsMain = new HBox();
//    HBox rightLabelsMain = new HBox();
//    VBox progressBars = new VBox();
//    
//    VBox leftLabelsSubL = new VBox();
//    VBox leftLabelsSubR = new VBox();
//    VBox rightLabelsSubL = new VBox();
//    VBox rightLabelsSubR = new VBox();
//    
//    static Group g1,g2,g3,g4,g5;
//    
//    static public Text playerLabel = new Text();
//    static public Text scoreLabel = new Text();
//    static public Text playerText = new Text();
//    static public Text scoreText = new Text();
//    static public Text mainMsg = new Text();
//    static public Text frogCounterLabel = new Text();
//    static public Text gameCounterLabel = new Text();
//    static public Text frogCounterText = new Text();
//    static public Text gameCounterText = new Text();
//
//    VBox leftMenu, rightMenu = new VBox();
//    HBox topMenu, BotMenu = new HBox();
//
//    GridPane menuGrid;
//    GridPane userInputGrid;
//    HBox menuButts = new HBox();
//    Button playButt;
//    //Button goButt;
//    Button OKButt;
//    Button quitButt;
//
//    //organize ponds, lanes, cars
//    ArrayList<ImageView> waterLanes = new ArrayList<>();
//    ArrayList<ImageView> roadLanes = new ArrayList<>();
//    ArrayList<ImageView> lanes = new ArrayList<>();
//    ArrayList<Car> cars = new ArrayList<>();
//    ArrayList<Junk> junk = new ArrayList<>();
//    public static ArrayList<Pond> ponds = new ArrayList<>();
//    public static ArrayList<Frog> frogs = new ArrayList<>();
//
//   //Game runningGame = null;
//    GUIMode GMode = GUIMode.MENU;
//
//    /**
//    * Mise en place des boutons play/quit
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void setButts() {
//
//        playButt = new Button("Play");
//        //goButt = new Button("Go");
//        quitButt = new Button("Quit");
//        playButt.getStyleClass().add("ipad-dark-grey");
//        //goButt.getStyleClass().add("ipad-dark-grey");
//        quitButt.getStyleClass().add("ipad-dark-grey");
//
//        int bw = 85;
//        int bh = 33;
//        playButt.setPrefSize(bw, bh);
//        //goButt.setPrefSize(bw, bh);
//        quitButt.setPrefSize(bw, bh);
//        playButt.setMinSize(bw, bh);
//        //goButt.setMinSize(bw, bh);
//        quitButt.setMinSize(bw, bh);
//        playButt.setMaxSize(bw, bh);
//        //goButt.setMaxSize(bw, bh);
//        quitButt.setMaxSize(bw, bh);
//
//        playButt.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                GMode = GUIMode.GAME;
//                setGUI(null, GMode);
//                
//                try {
//                    centerDashboard.getChildren().clear();
//                    setRunningFrog(Frog.Status.RUNNING);
//                    GameManager.getCurrentGame().setDashboardUpdater();
////                    
//                    carsMix_mp.setVolume(0.8);
//                    carsMix_mp.setCycleCount(20);
//                    carsMix_mp.play();
//
//                } catch (Error e2) {
//                    GameManager.alertMsg("L 1159");
//                }
//                
//            }
//        });
//
//        quitButt.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                Platform.exit();
//            }
//        });
//
//    }
//
//    /**
//    * Mise en place des boutons 
//    * des choix de niveau de jeu
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void setRadioButts() {
//
//        rb1 = new RadioButton("Beginner");
//        rb1.setToggleGroup(levelSelector);
//        rb1.setUserData(Game.Level.BEGINNER);
//        rb1.setFont(Font.font(fontFamily_1, FontWeight.EXTRA_BOLD, 14));
//        rb1.setTextFill(Color.web("#fff"));
//        rb1.setSelected(true);
//
//        rb2 = new RadioButton("Confirmed");
//        rb2.setToggleGroup(levelSelector);
//        rb2.setUserData(Game.Level.CONFIRMED);
//        rb2.setFont(Font.font(fontFamily_1, FontWeight.EXTRA_BOLD, 14));
//        rb2.setTextFill(Color.web("#fff"));
//
//        rb3 = new RadioButton("Expert");
//        rb3.setToggleGroup(levelSelector);
//        rb3.setUserData(Game.Level.EXPERT);
//        rb3.setFont(Font.font(fontFamily_1, FontWeight.EXTRA_BOLD, 14));
//        rb3.setTextFill(Color.web("#fff"));
//
//        levelSelector.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//            @Override
//            public void changed(ObservableValue<? extends Toggle> ov,
//                    Toggle old_toggle, Toggle new_toggle) {
//                if (levelSelector.getSelectedToggle() != null) {
//                    GameManager.getCurrentGame().setLevel((Game.Level)levelSelector.getSelectedToggle().getUserData());
//                    //GameManager.alertMsg(GameManager.getCurrentGame().getLevel().toString());
//                }
//            }
//        });
//
//    }
//
//    /**
//    * Mise en place du tableau de bord
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void setMenuGrid() {
//
//        menuGrid = new GridPane();
//        menuGrid.getStyleClass().add("menuGrid");
//        menuGrid.setHgap(60);
//        menuGrid.setVgap(5);
//        menuGrid.setPadding(new Insets(40, 15, 40, 15));
//        menuGrid.setMaxWidth(500);
//        menuGrid.setMaxHeight(300);
//        //menuGrid.setGridLinesVisible(true);
//        menuGrid.setAlignment(Pos.CENTER);
//
//        setRadioButts();
//
//        Label topLabel = new Label("FROGGER 16");
//        topLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 36));
//        topLabel.setTextFill(Color.web("#80ff00"));
//        topLabel.setPadding(new Insets(10, 10, 10, 10));
//        menuGrid.add(topLabel, 0, 0, 2, 1);
//
//        Label leftLabel = new Label("Highest \nscores:");
//        leftLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 24));
//        leftLabel.setTextFill(Color.web("#80ff00"));
//        leftLabel.setPadding(new Insets(0, 0, 5, 0));
//        menuGrid.add(leftLabel, 0, 1);
//        
//        Label rightLabel = new Label("Options:");
//        rightLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 24));
//        rightLabel.setTextFill(Color.web("#80ff00"));
//        rightLabel.setPadding(new Insets(10, 0, 20, 0));
//        menuGrid.add(rightLabel, 1, 1);
//
//        score1.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 14));
//        score1.setFill(Color.web("#fff"));
//        menuGrid.add(score1, 0, 2);
//        score2.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 14));
//        score2.setFill(Color.web("#fff"));
//        menuGrid.add(score2, 0, 3);
//        score3.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 14));
//        score3.setFill(Color.web("#fff"));
//        menuGrid.add(score3, 0, 4);
//
////        playButt.setPadding(new Insets(100, 0, 0, 0));
////        quitButt.setPadding(new Insets(100, 0, 0, 0));
//        
//        Text empty_1 = new Text("");
//        Text empty_2 = new Text("");
//        //empty_2.setStyle("height:200px");
//        menuGrid.add(empty_1, 0, 5, 2, 1);
//        menuGrid.add(playButt, 0, 6);
//        menuGrid.add(rb1, 1, 2);
//        menuGrid.add(rb2, 1, 3);
//        menuGrid.add(rb3, 1, 4);
//        menuGrid.add(quitButt, 1, 6);
//        menuGrid.add(empty_2, 0, 7, 2, 1);
//
//        GridPane.setHalignment(topLabel, HPos.CENTER);
//        GridPane.setHalignment(playButt, HPos.CENTER);
//        GridPane.setValignment(playButt, VPos.BOTTOM);
//        GridPane.setValignment(quitButt, VPos.BOTTOM);
//        GridPane.setHalignment(quitButt, HPos.LEFT);
//
//        hbMid.setAlignment(Pos.CENTER);
//        hbMid.getChildren().clear();
//        StackPane stp = new StackPane();
//
//        stp.getChildren().add(menuBackground);
//        stp.getChildren().get(0).setScaleX(.82);
//        stp.getChildren().get(0).setScaleY(.8);
//        stp.getChildren().get(0).setOpacity(.5);
//        stp.getChildren().add(menuGrid);
//        
//        hbMid.getChildren().add(stp);
//        fadeIn(stp,Duration.millis(500));
//
//    }
//    
//    void fadeIn(Node n,Duration d){
//        FadeTransition ft = new FadeTransition(d,n);
//        ft.setFromValue(0.0);
//        ft.setToValue(1.0);
//        ft.play();
//    }
//    
//    void initBg() {
//        StackPane sp = new StackPane();
//        sp.getChildren().add(roadLane_M3);
//        sp.getChildren().add(hbMid);
//
//        root.setCenter(sp);   
//    }
//
//    double getPondSpace() {
//        return (root.getWidth() - 5 * pondWidth) / 10;
//    }
//
//    /**
//    * Mise en place des mares
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void initPonds() {
//
//        pondWidth = pnd_Img.getWidth();
//
//        pond1 = new Pond(pnd_Img);
//        pond2 = new Pond(pnd_Img);
//        pond3 = new Pond(pnd_Img);
//        pond4 = new Pond(pnd_Img);
//        pond5 = new Pond(pnd_Img);
//
//        ponds.add(pond1);
//        ponds.add(pond2);
//        ponds.add(pond3);
//        ponds.add(pond4);
//        ponds.add(pond5);
//
//        hbTop.getChildren().clear();
//        hbTop.getChildren().add(ponds.get(0));
//        hbTop.getChildren().add(ponds.get(1));
//        hbTop.getChildren().add(ponds.get(2));
//        hbTop.getChildren().add(ponds.get(3));
//        hbTop.getChildren().add(ponds.get(4));
//
//        hbTop.setAlignment(Pos.CENTER);
//        //hbTop.setPadding(new Insets(0, 50, 0, 50));
//        hbTop.setSpacing(getPondSpace());
//        
//
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
//        //Rectangle2D junkBackground = new Rectangle2D(0, 0, tmp, lanesMode*50);
//
//        lanes.get(0).setFitWidth(tmp);
//        lanes.get(0).setViewport(v0);
//        lanes.get(1).setFitWidth(tmp);
//        lanes.get(1).setViewport(v1);
//        lanes.get(2).setFitWidth(tmp);
//        lanes.get(2).setViewport(v2);
//        lanes.get(3).setFitWidth(tmp);
//        lanes.get(3).setViewport(v3);
//        lanes.get(4).setFitWidth(tmp);
//        lanes.get(4).setViewport(v4);
//        lanes.get(5).setFitWidth(tmp);
//        lanes.get(5).setViewport(v5);
//        lanes.get(6).setFitWidth(tmp);
//        lanes.get(6).setViewport(v6);
//        lanes.get(7).setFitWidth(tmp);
//        lanes.get(7).setViewport(v7);
//        lanes.get(8).setFitWidth(tmp);
//        lanes.get(8).setViewport(v8);
//        lanes.get(9).setFitWidth(tmp);
//        lanes.get(9).setViewport(v9);
//    }
//    /**
//    * Création du tableau des voies
//    * 
//    * @author jb
//    * @version %v%
//    */
//    private void initLanesArrays() {
//
//        waterLane_1 = new ImageView(wtrLane);
//        waterLane_2 = new ImageView(wtrLane);
//        waterLane_3 = new ImageView(wtrLane);
//        waterLane_4 = new ImageView(wtrLane);
//        waterLane_5 = new ImageView(wtrLane);
//
//        waterLane_1.setOpacity(0);
//        waterLane_2.setOpacity(0);
//        waterLane_3.setOpacity(0);
//        waterLane_4.setOpacity(0);
//        waterLane_5.setOpacity(0);
//                
//        waterLanes.add(waterLane_1);
//        waterLanes.add(waterLane_2);
//        waterLanes.add(waterLane_3);
//        waterLanes.add(waterLane_4);
//        waterLanes.add(waterLane_5);
//        roadLanes.add(roadLane_U);
//        roadLanes.add(roadLane_M1);
//        roadLanes.add(roadLane_M2);
//        roadLanes.add(roadLane_M3);
//        roadLanes.add(roadLane_L);
//
//        laneHeight = 50;//(byte)waterLane_1.getImage().getHeight();
//
//    }
//
//    /**
//    * Mise en place du tableau de gestion dynamique des voies
//    * pour le redimensionnement
//    * @author jb
//    * @version %v%
//    */
//    private void setMainLanesArray() {
//
//        initLanesArrays();
//
//        lanes.add(waterLanes.get(0));
//        lanes.add(waterLanes.get(1));
//        lanes.add(waterLanes.get(2));
//        lanes.add(waterLanes.get(3));
//        
//        if (GameManager.getCurrentGame().getLevel()==Game.Level.BEGINNER){
//            lanes.add(waterLanes.get(4));
//        }else{
//            lanes.add(lawnLane);
//        }
//        
//        lanes.add(roadLanes.get(0));
//        lanes.add(roadLanes.get(1));
//        lanes.add(roadLanes.get(2));
//        lanes.add(roadLanes.get(3));
//        lanes.add(roadLanes.get(4));
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
//        setMainLanesArray();
//
//        hbMid.setAlignment(Pos.TOP_LEFT);
//        hbMid.getChildren().clear();
//        hbMid.getChildren().add(lanes.get(0));
//        hbMid.getChildren().add(lanes.get(1));
//        hbMid.getChildren().add(lanes.get(2));
//        hbMid.getChildren().add(lanes.get(3));
//        hbMid.getChildren().add(lanes.get(4));
//        hbMid.getChildren().add(lanes.get(5));
//        hbMid.getChildren().add(lanes.get(6));
//        hbMid.getChildren().add(lanes.get(7));
//        hbMid.getChildren().add(lanes.get(8));
//        hbMid.getChildren().add(lanes.get(9));
//
//        setLanesViewports(s);
//        lanesMode = 10;
//
//    }
//
//    /**
//    * Calcul du nombre de grenouilles disponibles
//    * 
//    * @author jb
//    * @version %v%
//    */
//    public static void updateFrogPool() {
//
//        frogPool.getChildren().clear();
//        int i = 0;
//        for (i = 0; i < frogs.size(); i++) {
//            if (frogs.get(i).status == Frog.Status.POOL) {
//                frogPool.getChildren().add(frogs.get(i));
//            }
//        }
//
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
//    public static void setRunningFrog(Frog.Status fst) {
//        
//        arrowKeysEnabled = false;
//        
//        try{
//            background_mp.stop();
//            //greatbell1_mp.stop();
//        }catch(Error e){
//            
//        }
//        
//        if (frogPool.getChildren().size()==0){
//            setCenterDashboard("GAME\nOVER");    
//        }
//
//        int q = frogPool.getChildren().size() - 1;
//        frogs.get(q).status = fst;
//        runningFrog = frogs.get(q);
//
//        runningFrog.setIndex((byte) (4 - (byte)q));
//
//        centerDashboard.getChildren().clear();
//        mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 60));
//        centerDashboard.getChildren().add(mainMsg);
//        mainMsg.setText(""+runningFrog.getIndex());
//        greatbell1Sound.play();
//        
//        transitScale(mainMsg, 5,5,1, Duration.millis(500));
//        
//        Task<Void> goFroggy = new Task<Void>() {
//            @Override
//            protected Void call() throws Exception {
//                try {
//                    Thread.sleep(400);//2000
//                } catch (InterruptedException e) {
//                }
//                return null;
//            }
//        };
//        goFroggy.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            
//            @Override
//            public void handle(WorkerStateEvent event) {
//
//                root.getChildren().add(runningFrog);
//                getFrogStartPos();
//                runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
//                RotateTransition rt=new RotateTransition(Duration.millis(150),runningFrog);
//                rt.setByAngle(360f);
//                runningFrog.setScaleX(2);
//                runningFrog.setScaleY(2);
//                ScaleTransition st = new ScaleTransition(Duration.millis(1000),runningFrog);
//                st.setToX(1);
//                st.setToY(1);
//                ParallelTransition pt = new ParallelTransition();
//                pt.getChildren().addAll(rt,st);
//                pt.play();
//                
//                pt.setOnFinished(new EventHandler<ActionEvent>(){
//                    @Override
//                    public void handle(ActionEvent e) {
//                        arrowKeysEnabled=true;
//                    }
//                });
//
//                updateFrogPool();
//                background_mp.play();    
//
//            }
//        });
//        new Thread(goFroggy).start();
//  
//    }
//
//    static void transitScale(Node n, int inX,int inY,int out, Duration d){
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
//    static void getFrogStartPos() {
//        if (runningFrog != null) {
//            frogStartPos_X = root.getWidth() / 2 - (runningFrog.getLayoutBounds().getWidth() / 2);
//            frogStartPos_Y = hbBot.getLayoutY() + 12 + smallFrogOffset;
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
//        //if (f.getStatus()!=Frog.Status.HOME && f.getStatus()!=Frog.Status.FLOATING){
//        f.setStatus(Frog.Status.DROWNED);
//        ft = new FadeTransition(Duration.millis(1000),f);
//        ft.setFromValue(1.0);
//        ft.setToValue(0.0);
//        ft.play();
//        ft.setOnFinished(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent e) {
//                root.getChildren().remove(f);
//                GameManager.getCurrentGame().setNextFrog();
//            }
//        });
//        //}
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
//        Frog frog1 = new Frog(frog4_Img);
//        Frog frog2 = new Frog(frog3_Img);
//        Frog frog3 = new Frog(frog2_Img);
//        Frog frog4 = new Frog(frog1_Img);
//
//        frogs.add(frog1);
//        frogs.add(frog2);
//        frogs.add(frog3);
//        frogs.add(frog4);
//
//        updateFrogPool();
//
//        frogOutline.getStyleClass().add("frogOutline");
//
//        //KEY EVENTS
//        ArrayList<String> input = new ArrayList<>();
//
//        sc.setOnKeyPressed(new EventHandler<KeyEvent>() {
//            
//            @Override
//            public void handle(KeyEvent e) {
//                
//                    
//                    int c;
//                    for (c = 0; c < junk.size(); c++) {
//                        if (junk.get(c).getBoundsInParent().intersects(runningFrog.getBoundsInParent())){
//                               yeehawSound.play();
//                        }else if(runningFrog.getLayoutY() < 250){
//                            //yeehawSound.play(); 
//                    }
//                    }
// 
//            //alertMsg("***"+arrowKeysEnabled);
//            if (arrowKeysEnabled){
//
//                if (runningFrog.getStatus() == Frog.Status.DROWNED){
//                    //avoid action on fading frog
//                    
//                }else if (runningFrog.getStatus() == Frog.Status.RUNNING  || runningFrog.getStatus() == Frog.Status.FLOATING) {
//
//                    String code = e.getCode().toString();   
//                    if (null != code) {
//                        switch (code) {
//                            
//                        case "UP":
//
//                                //updateGamesArray(GameManager.getCurrentGame());
//                                //GameManager.saveGamesFile();
//                                
//                                //START
//                                getFrogStartPos();
//                                if (runningFrog.getLayoutY() == frogStartPos_Y) {
//                                    updateScore(10);
//                                    runningFrog.relocate(runningFrog.getLayoutX(), hbTop.getLayoutY() + lanesMode * 50 + 27 + smallFrogOffset);
//                                //JUMP TO POND
//                                }else if (runningFrog != null && runningFrog.status != Frog.Status.HOME && runningFrog.getLayoutY() < 151) {
//                                    runningFrog.relocate(runningFrog.getLayoutX(), 0);
//
//                                try {
//        
//                                    int p=0;
//                                    Boolean intersects=false;
//                                    for (p = 0; p < ponds.size(); p++) {
//
//                                        //INTERSECT
//                                        if (  ponds.get(p).getBoundsInParent().intersects(runningFrog.getBoundsInParent())){
//
//                                            intersects=true;
//
//                                            //pond dispo
//                                            if (ponds.get(p).status == Pond.Status.EMPTY) {
//
//                                                System.out.println("$  OK");
//
//                                                //runningFrog.relocate(ponds.get(p).getLayoutX()+30, 0);
//                                                runningFrog.relocate(ponds.get(p).getLayoutX() + 29, ponds.get(p).getLayoutY()+15);
//                                                runningFrog.status = Frog.Status.HOME;
//                                                ponds.get(p).setStatus(Pond.Status.FROGGED);
//                                                Pond.froggedTotal++;
//
//                                                if (Pond.getFroggedTotal() == 3){
//                                                    setUserInputGrid();
//                                                }
//
//                                            }else{//POND OCCUPIED
//                                                root.getChildren().remove(runningFrog);
//                                            }
//
//                                        //NO INTERSECT
//                                        } else {
//                                        }
//                                    }
//
//                                    if (!intersects){
//                                        root.getChildren().remove(runningFrog);
//                                    }
//
//                                    int s = GameManager.getCurrentGame().getScore() * 
//                                        (GameManager.getCurrentGame().frogTimeLimit - GameManager.getCurrentGame().getFrogTime());
//                                    updateScore(s);
//
//                                    if (frogPool.getChildren().isEmpty()) {
//
//                                        setCenterDashboard("GAME\nOVER");
//                                        GameManager.getCurrentGame().getTl().stop();
//                                        //userInput
//                                        updateGamesArray(GameManager.getCurrentGame());//player, score, level
//                                        //GameManager.saveScores();
//                                    }else{
//                                        GameManager.getCurrentGame().setNextFrog();
//                                    }
//
//                                }catch (Error e2) {
//                                    alertMsg(e2.getMessage());
//                                }
//                                
//                                //LEAP OR DROWN
//                                
//                                } else{
//                                    
//                                    //g.setEffect(new BoxBlur(3, 3, 3));//w h iter
//                                    //setParticles(g1);
//                                    runningFrog.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY() - Frog.frogLeap);
//                                    if (runningFrog.getLayoutY()<junkMaxY+50){
//                                        drown(runningFrog);
//                                    }else{
//                                        updateScore(10);    
//                                    }
//                                }
//                                    
//                                break;
//
//                            case "DOWN":
//                                if (runningFrog.getLayoutY() < frogStartPos_Y) {
//                                    //GET BACK FROM LOWEST LANE
//                                    if (runningFrog.getLayoutY() == hbTop.getLayoutY() + lanesMode * 50 + 27 + smallFrogOffset) {
//                                        getFrogStartPos();
//                                        runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
//                                        updateScore(-10);
//                                    //JUMP DOWN
//                                    } else {
//                                        runningFrog.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY() + Frog.frogLeap);
//                                        if (runningFrog.getLayoutY()<junkMaxY+50){
//                                            drown(runningFrog);
//                                        }else{
//                                            updateScore(-10);    
//                                        }   
//                                    }
//                                }
//                                break;
//                                
//                            case "LEFT":                            
//                                //LEAP OR DROWN
//                                runningFrog.relocate(runningFrog.getLayoutX() - Frog.frogLeap, runningFrog.getLayoutY());
//                                //System.out.println("---------"+runningFrog.getStatus());
//                                if (runningFrog.getLayoutY()<junkMaxY+50){
//                                    drown(runningFrog);
//                                }
//                                break;
//                                
//                            case "RIGHT":
//                                runningFrog.relocate(runningFrog.getLayoutX() + Frog.frogLeap, runningFrog.getLayoutY());
//                                //System.out.println("---------"+runningFrog.getStatus());
//                                if (runningFrog.getLayoutY()<junkMaxY+50){
//                                    drown(runningFrog);
//                                }
//                                break;
//                            default:
//                                break;
//                        }
//                        
//                    }
//
//                    // only add once... prevent key ip duplicates
//                    if (!input.contains(code)) {
//                        input.add(code);
//                    }  
//                }
//            }
//        }
//        });
//
//        sc.setOnKeyReleased((KeyEvent e) -> {
//            String code = e.getCode().toString();
//            input.remove(code);
//
//        });
//        
//        //setUserInputGrid();
//    }
//    
//    public double updateScore(int i) {
//        //System.out.println(">>>"+i);    
//        int tmpSc = GameManager.getCurrentGame().getScore();    
//        int update = tmpSc+i;
//        //System.out.println(">>>"+update);
//        if (update<0){
//            update=0;  
//        }
//        //System.out.println(">>>"+update);
//        GameManager.getCurrentGame().setScore(update);
//        scoreText.setText(""+GameManager.getCurrentGame().getScore());
//        return GameManager.getCurrentGame().getScore();
//        
//    }
//    
//    public static void setCenterDashboard(String s){
//        
//        centerDashboard.getChildren().clear();
//        mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//        centerDashboard.getChildren().add(mainMsg);
//        mainMsg.setText("GAME\nOVER");
//
//    }
//
//    void setUserInputGrid() {
//
//        userInputGrid = new GridPane();
//        userInputGrid.getStyleClass().add("menuGrid");
//        userInputGrid.setHgap(60);
//        userInputGrid.setVgap(5);
//        userInputGrid.setPadding(new Insets(15, 15, 15, 15));
//        userInputGrid.setMaxWidth(500);
//        userInputGrid.setMaxHeight(300);
//        userInputGrid.setAlignment(Pos.CENTER);
//
//        Label topLabel = new Label("3 ponds !\nPlease enter your name :");
//        topLabel.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 22));
//        topLabel.setTextFill(Color.web("#80ff00"));
//        topLabel.setPadding(new Insets(10, 10, 10, 10));
//
//        //ImageView imageHouse = new ImageView(
//        //new Image(LayoutSample.class.getResourceAsStream("graphics/house.png")));
//
//        Text empty_1 = new Text("");
//        TextField userInput = new TextField("");
//        //userInput.getStyleClass().add(userInput);
//        Text empty_2 = new Text("");
//        
//        
//        StackPane stp = new StackPane();
//        
//        OKButt = new Button("OK");
//        OKButt.getStyleClass().add("ipad-dark-grey");
//        int bw = 85;
//        int bh = 33;
//        OKButt.setPrefSize(bw, bh);
//        OKButt.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                GameManager.getCurrentGame().setPlayer(userInput.getText());
//                updateGamesArray(GameManager.getCurrentGame());
//                GameManager.saveGamesFile();
//                root.getChildren().remove(stp);
//            }
//        });
//        
//        userInput.getStyleClass().add("userInput");
//        userInput.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 16));
//        userInput.setMinWidth(280);
//        userInputGrid.add(topLabel, 0, 0);
//        userInputGrid.add(userInput, 0, 1);
//        userInputGrid.add(empty_1, 0, 2);
//        userInputGrid.add(OKButt, 0, 3);
//        //playButt.setAlignment(Pos.CENTER_RIGHT);
//        userInputGrid.add(empty_2, 0, 4);
//        
//        userInputGrid.setMinWidth(500);
//        userInputGrid.setMinHeight(368);
//
//        GridPane.setHalignment(topLabel, HPos.CENTER);
//        GridPane.setHalignment(userInput, HPos.CENTER);
//        GridPane.setHalignment(OKButt, HPos.CENTER);
//
//        //hbMid.setAlignment(Pos.CENTER);
//        //hbMid.getChildren().clear();
//        
//        
//        stp.getChildren().add(menuBackground);
//        stp.getChildren().get(0).setScaleX(.8);
//        stp.getChildren().get(0).setScaleY(.8);
//        stp.getChildren().get(0).setOpacity(.8);
//        stp.getChildren().add(userInputGrid);
//        
//        root.getChildren().add(stp);
//        
//        
//        menuBackground.getFitHeight();
//        
//        stp.setLayoutX(root.getWidth()/2);
//        stp.setLayoutY(root.getHeight()/2);
//        
//    }
//
//    private void initCars() {
//
//        Car redCar = new Car(rdCar);
//        Car whiteCar = new Car(whteBeetle);
//        Car redPickup = new Car(rdPckup);
//        Car yellowCab = new Car(yllwCab);
//        Car police2 = new Car(plice2);
//        Car police3 = new Car(plice3);
//        Car UKmini = new Car(UKmni);
//        Car ambu2 = new Car(mblance2);
//        Car cementMixer = new Car(cmntMixer);
//        Car policeBlack = new Car(pliceBlack);
//        Car orangeBeetle = new Car(rngBeetle);
//        Car blueConvertible = new Car(blcnv);
//        Car largePickup = new Car(lrgPickup);
//
//        cars.add(redCar);
//        cars.add(whiteCar);
//        cars.add(redPickup);
//        cars.add(yellowCab);
//        cars.add(police2);
//        cars.add(police3);
//        cars.add(UKmini);
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
//        initCarIndividualSpeed = 7;
//        individualCarSpeedIncr = 1; //tricky value
//        carSpeedLimit = 10;//15
//
//        int i, j; //cars array
//        for (i = 0; i < cars.size(); i++) {
//            j = i + 1;
//            cars.get(i).setSpeed(initCarIndividualSpeed);
//            //revoir
//            cars.get(i).relocate((-i * Car.bumperOffset) - 400, 325);
//            initCarIndividualSpeed = initCarIndividualSpeed + individualCarSpeedIncr;
//        }
//    }
//    
//    private void initJunk() {
//
//        Junk wheel = new Junk(whl);
//        Junk tyre = new Junk(tre);
//        Junk bottle1 = new Junk(bttl1);
//        Junk bottle2 = new Junk(bttl2);
//        Junk bottle3 = new Junk(bttl3);
//        Junk wheel2 = new Junk(whl);
//        Junk tyre2 = new Junk(tre);
//        Junk bg1 = new Junk(bag1);
//        Junk bg2 = new Junk(bag2);
//        Junk cd2 = new Junk(cad2);
//        Junk cn = new Junk(can);
//
//        junk.add(bottle1);
//        junk.add(bottle2);
//        junk.add(bottle3);
//        //junk.add(tyre2);
//        junk.add(bg1);
//        junk.add(bg2);
//        junk.add(cn);
//        //junk.add(wheel);
//        junk.add(tyre);
//        junk.add(wheel2);
//
//    }
//
//
//    void initDashboard() {
//        
//        playerText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        playerText.setFill(Color.rgb(0, 255, 0));
//        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        scoreText.setFill(Color.rgb(0, 255, 0));
//
//        mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//        mainMsg.setFill(Color.rgb(255, 0, 0));
//        
//        frogCounterLabel.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 20));
//        frogCounterLabel.setFill(Color.rgb(0, 255, 0));
//        gameCounterLabel.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 20));
//        gameCounterLabel.setFill(Color.rgb(0, 255, 0));
//        playerLabel.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 20));
//        playerLabel.setFill(Color.rgb(0, 255, 0));
//        scoreLabel.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 20));
//        scoreLabel.setFill(Color.rgb(0, 255, 0));
//        
//        playerLabel.setText("");
//        scoreLabel.setText("Score: ");
//        frogCounterLabel.setText("FrogTime: ");
//        gameCounterLabel.setText("GameTime: ");
//        
//        frogCounterText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        frogCounterText.setFill(Color.rgb(0, 255, 0));
//        gameCounterText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        gameCounterText.setFill(Color.rgb(0, 255, 0));
//        
//        pBar1.setMinWidth(200);
//        pBar2.setMinWidth(200);
//        pBar1.setProgress(0);
//        pBar2.setProgress(0);
//
//        frogPool.setAlignment(Pos.CENTER);
//        frogPool.setPadding(new Insets(0, 15, 0, 15));
//        frogPool.setPrefWidth(200);
//        leftLabelsMain.setPrefWidth(200);
//        leftLabelsMain.setAlignment(Pos.CENTER_LEFT);
//        leftLabelsMain.setPadding(new Insets(0, 10, 0, 10));
//        rightLabelsMain.setPrefWidth(200);
//        rightLabelsMain.setAlignment(Pos.CENTER_LEFT);
//        rightLabelsMain.setPadding(new Insets(0, 10, 0, 10));
//        
//        progressBars.setAlignment(Pos.CENTER);
//        progressBars.setPadding(new Insets(0, 15, 0, 15));
//        progressBars.setPrefWidth(200);
//
//        leftLabelsMain.getChildren().addAll(leftLabelsSubL,leftLabelsSubR);
//        rightLabelsMain.getChildren().addAll(rightLabelsSubL,rightLabelsSubR);
//        rightLabelsMain.setStyle("-fx-border-color: blue;");
//        leftLabelsSubL.getChildren().addAll(playerLabel,scoreLabel);
//        leftLabelsSubR.getChildren().addAll(playerText,scoreText);
//        rightLabelsSubL.getChildren().addAll(frogCounterLabel,gameCounterLabel);
//        rightLabelsSubR.getChildren().addAll(frogCounterText,gameCounterText);
//        
//        //leftLabelsSubR.setPadding(new Insets(5, 0, 5, 0));
//        //rightLabelsSubR.setPadding(new Insets(5, 0, 5, 0));
//        leftLabelsSubR.setAlignment(Pos.CENTER);
//        rightLabelsSubR.setAlignment(Pos.CENTER);
//
//        frogCounterText.getStyleClass().add("labels");
//        gameCounterText.getStyleClass().add("labels");
//        
//        leftLabelsSubL.setMaxWidth(150);
//        leftLabelsSubR.setMaxWidth(150);
//        rightLabelsSubL.setMaxWidth(150);
//        rightLabelsSubR.setMaxWidth(150);
//        
//        progressBars.getChildren().add(pBar1);
//        progressBars.getChildren().add(pBar2);
//
//        leftDashboard.setPrefWidth(600);
//        leftDashboard.setAlignment(Pos.CENTER_LEFT);
//        centerDashboard.setStyle("-fx-border-color: red;");
//        centerDashboard.setMinWidth(75);
//        centerDashboard.setAlignment(Pos.CENTER);
//        HBox.setHgrow(centerDashboard, Priority.ALWAYS);
//        rightDashboard.setPrefWidth(600);
//        rightDashboard.setAlignment(Pos.CENTER_RIGHT);
//        
//        leftDashboard.getChildren().addAll(frogPool, leftLabelsMain);
//        //centerDashboard.getChildren().add(goButt);
//        rightDashboard.getChildren().addAll(rightLabelsMain, progressBars);
//
//        hbBot.getChildren().clear();
//        hbBot.getChildren().addAll(leftDashboard, centerDashboard, rightDashboard);
//
//    }
//
//    /**
//    *Initialisation GUI des 3 zones principales du terrain de jeu 
//    * <p>
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void initScene(Stage s) {
//
//        hbTop = new HBox();
//        hbMid = new VBox();
//        hbBot = new HBox();
//        hbLeft = new VBox();
//        hbRight = new VBox();
//        hbTop.getStyleClass().add("hbTop");
//        hbMid.getStyleClass().add("hbMid");
//        hbBot.getStyleClass().add("hbBot");
//        hbLeft.getStyleClass().add("hbLeft");
//        hbRight.getStyleClass().add("hbRIght");
//        hbTop.setPrefHeight(75);
//        hbTop.setMinHeight(75);
//        hbTop.setMaxHeight(75);
//        hbBot.setPrefHeight(75);
//        hbBot.setMinHeight(75);
//        hbBot.setMaxHeight(75);
//
//        root = new BorderPane();
//        root.setTop(hbTop);
//        root.setCenter(hbMid);
//        root.setBottom(hbBot);
//        root.setLeft(hbLeft);
//        root.setRight(hbRight);
//        rootMid = root.getWidth() / 2;
//        rootCenter = root.getHeight() / 2;
//        rootQuarter = root.getWidth() / 4;
//        rootFifth = root.getWidth() / 5;
//
//        root.setPrefSize(1024, 650);
//        sc = new Scene(root);
//        sc.getStylesheets().add("frogger/backdrop.css");
//
//        sc.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
//            updateDraw(s);
//            //System.out.println("Width: " + newSceneWidth);
//        });
//
//        sc.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
//            updateDraw(s);
//        });
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
//        hbMid.setAlignment(Pos.CENTER);
//        hbMid.getChildren().add(splash);
//
//    }
//
//    void addCars() {
//        int i;
//        for (i = 0; i < cars.size(); i++) {
//            root.getChildren().add(cars.get(i));
//        }
// 
//    }
//    
//    void addJunk() {
//        int i;
//        for (i = 0; i < junk.size(); i++) {
//            //junk.get(i).setOpacity(0.6);
//            root.getChildren().add(junk.get(i));
//            
//        }
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
//    static void setSound() {
//        
//        String dplash2 = "src/audio/mp3/pondAmbi.mp3"; 
//        Media dplash2_m = new Media(new File(dplash2).toURI().toString());
//        dplash2_mp = new MediaPlayer(dplash2_m);
//        
//        String funnyimact = "src/audio/mp3/funnyimact.mp3";
//        Media funnyimact_m = new Media(new File(funnyimact).toURI().toString());
//        funnyimact_mp = new MediaPlayer(funnyimact_m);
//
//        String background = "src/audio/mp3/background.mp3";
//        Media background_m = new Media(new File(background).toURI().toString());
//        background_mp = new MediaPlayer(background_m);
//
//        String carsMix = "src/audio/mp3/carsMix.mp3";
//        Media carsMix_m = new Media(new File(carsMix).toURI().toString());
//        carsMix_mp = new MediaPlayer(carsMix_m);
//        
//        String bug = "src/audio/mp3/nice.mp3";
//        Media bug_m = new Media(new File(bug).toURI().toString());
//        //bug_mp = new MediaPlayer(bug_m);
//        
//        String mower = "src/audio/mp3/mower.mp3"; 
//        Media mower_m = new Media(new File(mower).toURI().toString());
//        mower_mp = new MediaPlayer(mower_m);
//        mower_mp.setCycleCount(1000);
//
//        greatbell1Sound = new AudioClip(Paths.get("src/audio/mp3/greatbell1.mp3").toUri().toString());
//        yeehawSound = new AudioClip(Paths.get("src/audio/mp3/yeehawCut.mp3").toUri().toString());
//        
//        dplash2_mp.play();
//
//    }
//    
//    static void setParticles(Group g, double d, double o ){
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
//            timeline.getKeyFrames().addAll(
//                new KeyFrame(Duration.ZERO, // set start position at 0
//                    new KeyValue(circle.translateXProperty(), random() * 1400),
//                    new KeyValue(circle.translateYProperty(), random() * 300)//10
//                ),
//                new KeyFrame(new Duration(40000), // set end position at 40s
//                    new KeyValue(circle.translateXProperty(), random() * 1400),
//                    new KeyValue(circle.translateYProperty(), random() * 300)
//                )
//            );
//            
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
//    void setGUI(Scene s, GUIMode gm) {
//
//        if (GMode == GUIMode.MENU) {
//
//            setButts();
//            setMenuGrid();
//
//        } else if (GMode == GUIMode.GAME) {
//
//            String image = JavaFXApplication9.class.getResource("/img/junk/junkBg4.png").toExternalForm();
//            hbMid.setStyle("-fx-background-image: url('" + image + "'); " +
//           "-fx-background-position: left top; " +
//           "-fx-background-size:   2500,200  ; " +
//           "-fx-background-repeat: stretch;");
//
//            initPonds();
//            initLanes(s);
//            initDashboard();
//            initCars();
//            initJunk();
//            addCars();
//            if (GameManager.getCurrentGame().getLevel()!=Game.Level.BEGINNER){
//                root.getChildren().add(mower);
//            }
//            addJunk();
//            //setParticles(g1,20,0.2);
//
//            initFrogs();
//
//            //bug.setRotate(90);
//            bug.setLayoutY(25);
//            root.getChildren().add(bug);
//            
//        }
//
//    }
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
//
//        initScene(st);
//        setStage(st);
//        setSound();
//
//        Thread.sleep(500);
//
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
//
//        intro.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            
//            @Override
//            public void handle(WorkerStateEvent event) {
//                setGUI(sc, GMode);
//                initGame((Game.Level)(Object)levelSelector.getSelectedToggle().getUserData());
//            }
//        });
//        
//        new Thread(intro).start();
//        
//        
//final Timeline timeline = new Timeline();
//timeline.setCycleCount(Timeline.INDEFINITE);
//timeline.setAutoReverse(true);
//final KeyValue kv = new KeyValue(mower.xProperty(), 500);
//final KeyFrame kf = new KeyFrame(Duration.millis(2000), kv);
//timeline.getKeyFrames().add(kf);
//
//timeline.play();
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
//                if (GMode == GUIMode.GAME) {
//                    if (GameManager.getCurrentGame().getLevel()==Game.Level.EXPERT
//                       && GameManager.getCurrentGame().getGameTime()==2.0000000){
//                        setParticles(g1,20,0.5);
//                    }
//
//                    //gestion du bug
//                    if (GameManager.getCurrentGame().getGameTime()==refTime/10){
//                        int b;
//                        for(b=0;b<ponds.size();b++){
//                            if (ponds.get(b).getStatus()==Pond.Status.BUGGED){
//                            ponds.get(b).setStatus(Pond.Status.EMPTY);
//                            }
//                        }
//
//                        Pond.candidate = (int) Math.round(Math.random()*10);
//                        if (Pond.candidate<5){
//
//                            tmpPond = ponds.get(Pond.candidate);
//
//                            if (tmpPond.getStatus()!=Pond.Status.FROGGED){
//                                tmpPond.setStatus(Pond.Status.BUGGED);
//                                bug.relocate(tmpPond.getLayoutX()+37,bug.getLayoutY());    
//                            }
//                        }
//                        
//                        //checkBug();
//                        refTime+=5;
//   
//                    }
//
////           if (now - lastUpdate >= 140_000_000) {
////       
////                g.getChildren().stream().forEach((circle) -> {
////                    circle.setLayoutX(random() * sc.getWidth());
////                    //circle.setTranslateX(random() * sc.getWidth());
////                    //circle.setTranslateY(sc.getHeight()-75));
////                    //circle.translateXProperty(random() * sc.getWidth());
////                    circle.setLayoutY(75+random() * (sc.getHeight()-75)); 
////                });
////                lastUpdate = now ;
////            }
//
//                    //paramétrage selon nombre de voies
//                    double lawnMargin=0;
////                    if (GameManager.getCurrentGame().getLevel()==Game.Level.BEGINNER){
////                        lawnMargin = 50; 
////                    }
//                    
//                    switch (lanesMode) {
//                        case 2:
//                            carMinY = 126;
//                            carMaxY = 126;
//                            junkMaxY = 80+lawnMargin;
//                            break;
//                        case 4:
//                            carMinY = 176;
//                            carMaxY = 226;
//                            junkMaxY = 80+lawnMargin;
//                            break;
//                        case 6:
//                            carMinY = 226;
//                            carMaxY = 326;
//                            junkMaxY = 80+lawnMargin+laneHeight;
//                            break;
//                        case 8:
//                            carMinY = 276;
//                            carMaxY = 426;
//                            junkMaxY = 80+lawnMargin+2*laneHeight;
//                            break;
//                        case 10:
//                            carMinY = 326;
//                            carMaxY = 526;
//                            junkMaxY = 80+lawnMargin+3*laneHeight;
//                            break;
//                        default:
//                            break;
//                    }
//                    
//                    junkMinY = 85;
//                    
//                    
//                    //gestion tondeuse
//                    mower_mp.play();
//                    //if (mower.getLayoutX() > sc.getWidth() + 600) {//2000
//                    if (mower.getLayoutX() < -600) {//2000
//                        //mower.setLayoutX(sc.getWidth() + 600);
//                        
//                    } else {
//                        //mower.setLayoutX(mower.getLayoutX() - 5);
//                        mower.setLayoutY(carMinY - 40);
//                    }
//                    
//                    if  (mower.getLayoutX()<0 || mower.getLayoutX()>sc.getWidth()){
//                        mower_mp.setVolume(0);
//                    }else{
//                        mower_mp.setVolume(1);   
//                        //mower_mp.setBalance(sc.getWidth()/(mower.getLayoutX()*2));
//                        //System.out.println("'''"+mower_mp.getBalance());  
//                    }
//
//                    //cadrage XY voitures
//                    int a, b;
//                    for (a = 0; a < cars.size(); a++) {
//
//                        b = a + 1;
//
//                        //reset to left and to lower lane
//                        if (cars.get(a).getLayoutX() > sc.getWidth() + 600) {//2000
//                            cars.get(a).relocate(-600, cars.get(a).getLayoutY() + 50);
//                        }
//
//                        //if lower limit: get back to top                        
//                        if (cars.get(a).getLayoutY() > carMaxY) {
//                            cars.get(a).relocate(-b * Car.bumperOffset, carMinY);
//                        }
//                    }
//
//                    //interaction voitures et vitesse voitures
//                    int i, j, k;
//                    k = cars.size() - 1;
//
//                    for (i = 0; i < cars.size(); i++) {
//
//                        for (j = k; j > -1; j--) {
//
//                            if (cars.get(i).getLayoutY() == cars.get(j).getLayoutY()) {
//
//                                if (cars.get(j).getSpeed() > cars.get(i).getSpeed()
//                                        && cars.get(j).getLayoutX() < cars.get(i).getLayoutX() - 60
//                                        && cars.get(j).getLayoutX() > cars.get(i).getLayoutX() - 160) {
//                                    cars.get(j).setSpeed(cars.get(i).getSpeed() - 1);
//
//                                } else if (cars.get(j).getSpeed() < cars.get(i).getSpeed()
//                                        && cars.get(j).getLayoutX() > cars.get(i).getLayoutX() + 150
//                                        && cars.get(j).getLayoutX() < cars.get(i).getLayoutX() + 250) //speed limit
//                                {
//                                    if (cars.get(i).getSpeed() > carSpeedLimit) {
//                                        cars.get(i).setSpeed(cars.get(i).getSpeed() - 7);
//                                    } else {
//                                        cars.get(j).setSpeed(cars.get(i).getSpeed() + 1);
//                                    }
//                                }
//                            }
//                        }
//                    
//                    }
//
//                    //mouvements voitures
//                    int r;
//                    for (r = 0; r < cars.size(); r++) {
//                        cars.get(r).relocate(cars.get(r).getLayoutX() + cars.get(r).getSpeed(), cars.get(r).getLayoutY());
//                        
//                        //intersection voiture/grenouille
//                        if (runningFrog != null) {
//                            try {
//                                if (cars.get(r).getBoundsInParent().intersects(runningFrog.getBoundsInParent())) {
//                                    //funnyimact_mp.setCycleCount(10);
//                                try{
//                                        funnyimact_mp.stop();
//                                }catch(Error e){
//
//                                }
//                                    funnyimact_mp.play();
//                                    //System.out.println("c:  " + cars.get(r).getBoundsInParent());
//                                    //System.out.println("f:  " + runningFrog.getBoundsInParent());
//                                    root.getChildren().remove(frogOutline);
//                                    root.getChildren().add(3, frogOutline);
//                                    frogOutline.setOpacity(1);
//                                    frogOutline.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY());
//                                    getFrogStartPos();
//                                    runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
//                                    runningFrog.setLayoutY(frogStartPos_Y);
//                                }
//                            } catch (Error e) {
//                                GameManager.alertMsg(e.getMessage());
//                            }
//                        }
//                    }
//                    
//                    //gestion ordures
//                    junkRotateValue++;
//                    double d;
//                    int c,g;
//                    for (c = 0; c < junk.size(); c++) {
//                        g=c+1;
//                        d = ((double)g)/5;
//                        junk.get(c).setRotate(junkRotateValue+50*c);
//                        
//                        //JUNK X LIMITS
//                        if ((c % 2) == 0){//GOES LEFT
//                            if (junk.get(c).getLayoutX() <= 0) {  //2000
//                                junk.get(c).setLayoutX(sc.getWidth()-10);
//                            }
//                            
//                            //junk.get(c).relocate(junk.get(c).getLayoutX() - (junk.get(c).getSpeed()+(g-Junk.speedFactor)), junk.get(c).getLayoutY());
//                            junk.get(c).relocate(junk.get(c).getLayoutX() - g/Junk.speedFactor, junk.get(c).getLayoutY());
//                               
//                        }else{//GOES RIGHT
//                            if (junk.get(c).getLayoutX() >= sc.getWidth()-10) {  //2000
//                                junk.get(c).setLayoutX(0);
//                            }
//                            junk.get(c).relocate(junk.get(c).getLayoutX() + g/Junk.speedFactor, junk.get(c).getLayoutY());
//                            //junk.get(c).relocate(junk.get(c).getLayoutX() + (junk.get(c).getSpeed()+(g-Junk.speedFactor)), junk.get(c).getLayoutY());   
//                        }
//
//
//                        //intersection ordure/grenouille
//                        if (runningFrog != null) {
//                            try {
//                                if (junk.get(c).getBoundsInParent().intersects(runningFrog.getBoundsInParent())) {
//                                    ft.stop();
//                                    runningFrog.setStatus(Frog.Status.FLOATING);
//                                    runningFrog.relocate(junk.get(c).getLayoutX(), junk.get(c).getLayoutY());
//                                 }
//                            } catch (Error e) {
//                                GameManager.alertMsg(e.getMessage());
//                            }
//                        }
//
//                        //JUNK Y LIMITS  
//                        if (junk.get(c).getLayoutY() >= junkMaxY+1+bumpFactor) {
//                            junk.get(c).setDirection(Junk.Direction.UP);
//                        }else if (junk.get(c).getLayoutY() <= junkMinY-1-bumpFactor) {
//                            junk.get(c).setDirection(Junk.Direction.DOWN);
//                        }
//                        if (junk.get(c).getDirection()==Junk.Direction.UP){
//                            junk.get(c).setLayoutY(junk.get(c).getLayoutY()-d-bumpFactor); 
//                        }else if (junk.get(c).getDirection()==Junk.Direction.DOWN){
//                            junk.get(c).setLayoutY(junk.get(c).getLayoutY()+d+bumpFactor);
//                        }
//
//                    }
//
//                    eraseFrog();
//                }
//            }
//        } 
//                
//                
//                
//        .start();
//        st.show();
//        //Thread.sleep(2000);
//        //hbMid.getChildren().remove(splash);
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
//        frogOutline.setOpacity((frogOutline.getOpacity())-(0.007));
//        if (frogOutline.getOpacity()==0){
//            root.getChildren().remove(frogOutline);
//        }
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
//        int b;
//        System.out.println("");
//        for(b=0;b<ponds.size();b++){
//            System.out.println("bug "+ponds.get(b).getStatus());
//        }
//        System.out.println("");
//    }
//
//    private void updateDraw(Stage st) {
//        try{
//        //NODES TO LANES MANAGEMENT
//        if (GMode == GUIMode.MENU) {
//            //
//        } else if (GMode == GUIMode.GAME) {
//
//            hbTop.setSpacing(getPondSpace());
//
//            setLanesViewports(sc);
//
//            rootMid = root.getWidth() / 2;
//            rootQuarter = root.getWidth() / 4;
//            rootCenter=root.getHeight() / 2;
//            
//            bug.relocate(hbTop.getChildren().get(2).getLayoutX()+19, hbTop.getChildren().get(2).getLayoutY()+23);
//            
//            //FROG
//            frogStartPos_X = root.getWidth() / 2 - (runningFrog.getLayoutBounds().getWidth() / 2);
//            frogStartPos_Y = hbBot.getLayoutY() + 12;
//            runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
//
//            //LANES & CARS
//            int f;
//
//            if (hbMid.getChildren().isEmpty()) {
//
//            } else if (st.getHeight() < 385) {
//
//                if (lanesMode == 4) {
//
//                    lanesMode = 2;
//                    hbMid.getChildren().clear();
//                    hbMid.getChildren().add(lanes.get(0));
//                    hbMid.getChildren().add(lanes.get(6));
//
//                }
//
//            } else if (lanesMode == 2) {
//
//                hbMid.getChildren().clear();
//                hbMid.getChildren().add(lanes.get(0));
//                hbMid.getChildren().add(lanes.get(4));
//                hbMid.getChildren().add(lanes.get(5));
//                hbMid.getChildren().add(lanes.get(9));
//                lanesMode = 4;
//
//            } else if (st.getHeight() < 485) {
//
//                if (lanesMode == 6) {
//
//                    lanesMode = 4;
//                    hbMid.getChildren().remove(1);
//                    hbMid.getChildren().remove(3);
//
//                }
//
//            } else if (lanesMode == 4) {
//
//                hbMid.getChildren().clear();
//                hbMid.getChildren().add(lanes.get(0));
//                hbMid.getChildren().add(lanes.get(1));
//                hbMid.getChildren().add(lanes.get(4));
//                hbMid.getChildren().add(lanes.get(5));
//                hbMid.getChildren().add(lanes.get(6));
//                hbMid.getChildren().add(lanes.get(9));
//                lanesMode = 6;
//
//            } else if (st.getHeight() < 585) {
//
//                if (lanesMode == 8) {
//
//                    hbMid.getChildren().remove(1);
//                    hbMid.getChildren().remove(4);
//                    lanesMode = 6;
//
//                }
//
//            } else if (lanesMode == 6) {
//
//                hbMid.getChildren().clear();
//                int i, k;
//                for (i = 0; i < 3; i++) {
//                    hbMid.getChildren().add(lanes.get(i));
//                }
//                hbMid.getChildren().add(lanes.get(5));
//                //hbMid.getChildren().add(lanes.get(6));
//                hbMid.getChildren().add(3, lanes.get(4));
//                hbMid.getChildren().add(lanes.get(7));
//                hbMid.getChildren().add(lanes.get(8));
//                hbMid.getChildren().add(lanes.get(9));
//                lanesMode = 8;
//
//            } else if (st.getHeight() < 685) {
//
//                if (lanesMode == 10) {
//
//                    hbMid.getChildren().remove(4);
//                    hbMid.getChildren().remove(3);
//                    hbMid.getChildren().add(3, lanes.get(4));
//                    hbMid.getChildren().remove(7);
//                    lanesMode = 8;
//
//                }
//                
//              //lanesMode = 8;
//            } else if (lanesMode == 8){
//
//                hbMid.getChildren().clear();
//                int i;
//                for (i = 0; i < lanesMode + 2; i++) {
//                    hbMid.getChildren().add(lanes.get(i));
//                }
//                lanesMode = 10;
//            }
//
//            //RELOCATES
//
//            for (f = 0; f < cars.size(); f++) {
//                cars.get(f).relocate(cars.get(f).getLayoutX(), carMinY-1);
//            }
//            
//            // CODE OK
//            for (f = 0; f < junk.size(); f++) {
//                junk.get(f).relocate(junk.get(f).getLayoutX(), junkMinY);
//            }
//
//        }    
//        }catch(Error e){
//                
//            }
//    }
//
//}
