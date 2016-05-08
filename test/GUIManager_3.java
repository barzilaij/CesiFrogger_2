///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
//import frogger.*;
//import java.io.File;
//import java.util.ArrayList;
//import javafx.animation.AnimationTimer;
//import javafx.application.Application;
//import javafx.beans.property.ReadOnlyDoubleProperty;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.SubScene;
//import javafx.scene.control.Alert;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.Background;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.StackPane;
//import javafx.scene.layout.VBox;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.stage.Stage;
//import javafx.application.Platform;
//import javafx.collections.ObservableList;
//import javafx.event.EventType;
//import javafx.geometry.HPos;
//import javafx.geometry.Rectangle2D;
//import javafx.geometry.VPos;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.control.Label;
//import javafx.scene.control.ProgressBar;
//import javafx.scene.control.RadioButton;
//import javafx.scene.control.TextField;
//import javafx.scene.control.Toggle;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.ColumnConstraints;
//import javafx.scene.layout.GridPane;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Rectangle;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import javafx.stage.Screen;
//import javafx.stage.WindowEvent;
//import javax.swing.event.DocumentEvent;
//import frogger.Game.*;
//import java.time.Duration;
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.Timeline;
//import frogger.Frog.*;
//import frogger.Game.*;
//import frogger.GameManager.*;
//import frogger.Images.*;
//import static frogger.GameManager.currentGame;
//import static javafx.application.Application.launch;
//import javafx.concurrent.Task;
//import javafx.concurrent.WorkerStateEvent;
//import static javafx.application.Application.launch;
//
///**
// * @author jb
// */
//public class GUIManager_3 extends Application {
//
//    //graphics
//    Image splash_Img = new Image("img/splash.png");
//
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
//    Image rdLane_U = new Image("img/lanes/road1_H100_upperhalf.png");
//    Image rdLane_L = new Image("img/lanes/road1_H100_lowerhalf.png");
//    Image rdLane_M = new Image("img/lanes/road1_H100_midhalf.png");
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
//    //fixed graphics nodes
//    ImageView splash = new ImageView(splash_Img);
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
//    ImageView mawer = new ImageView(mwer);
//
//    final Label[] menuLabels = new Label[6];
//    static ProgressBar pBar1 = new ProgressBar();
//    static ProgressBar pBar2 = new ProgressBar();
//    final ToggleGroup levelSelector = new ToggleGroup();
//    RadioButton rb1, rb2, rb3;
//
//    double pondWidth;
//    double rootMid, rootQuarter, rootFifth;
//    public static double frogStartPos_X, frogStartPos_Y;
//    double space, tmp;
//    byte lanesMode;
//    double carMinY, carMaxY, pondsOffset, bumperOffset;
//    double speedLimit, initIndividualSpeed, individualSpeedIncr;
//    //int score = 0;
//
//    String fontFamily_0 = "Arial";
//    String fontFamily_1 = "Chiller";
//    String fontFamily_2 = "Courier New";
//    String fontFamily_3 = "OCR A Extended";
//
//    double frogLeap = 50;
//    static double smallFrogOffset = 7;
//
//    public enum GUIMode {
//        MENU, GAME, OUTRO
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
//    HBox menuButts = new HBox();
//    Button playButt;
//    Button goButt;
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
//    Game runningGame = null;
//    GUIMode GMode = GUIMode.MENU;
//
//    public double updateScoreDisplay(double i) {
//        currentGame.score.score = currentGame.score.score + i;
//        scoreText.setText(""+currentGame.score.score);
//        return currentGame.score.score;
//    }
//
//    void setButts() {
//
//        playButt = new Button("Play");
//        goButt = new Button("Go");
//        quitButt = new Button("Quit");
//        playButt.getStyleClass().add("ipad-dark-grey");
//        goButt.getStyleClass().add("ipad-dark-grey");
//        quitButt.getStyleClass().add("ipad-dark-grey");
//
//        int bw = 100;
//        int bh = 30;
//        playButt.setPrefSize(bw, bh);
//        goButt.setPrefSize(bw, bh);
//        quitButt.setPrefSize(bw, bh);
//        playButt.setMinSize(bw, bh);
//        goButt.setMinSize(bw, bh);
//        quitButt.setMinSize(bw, bh);
//        playButt.setMaxSize(bw, bh);
//        goButt.setMaxSize(bw, bh);
//        quitButt.setMaxSize(bw, bh);
//
//        playButt.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                GMode = GUIMode.GAME;
//                setGUI(null, GMode);
//                runningGame = GameManager.initGame((Level) levelSelector.getSelectedToggle().getUserData());
//            }
//        });
//
//        goButt.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                centerDashboard.getChildren().clear();
//                //centerDashboard.getChildren().add(quitButt);
//                try {
//                    setRunningFrog();
//                    runningGame.setDashboardUpdater();
//
//                } catch (Error e2) {
//                    GameManager.alertMsg("" + e.getSource());
//                }
//                //setRunningFrog(0);
//                //GameManager.alertMsg ("hi");
//                //setRunningFrog(0);
//                //GameManager.alertMsg ("hi");
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
//    void setRadioButts() {
//
//        rb1 = new RadioButton("Beginner");
//        rb1.setToggleGroup(levelSelector);
//        rb1.setUserData(Game.Level.BEGINNER);
//        rb1.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 14));
//        rb1.setTextFill(Color.web("#0f0"));
//        rb1.setSelected(true);
//
//        rb2 = new RadioButton("Confirmed");
//        rb2.setToggleGroup(levelSelector);
//        rb2.setUserData(Game.Level.CONFIRMED);
//        rb2.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 14));
//        rb2.setTextFill(Color.web("#0f0"));
//
//        rb3 = new RadioButton("Expert");
//        rb3.setToggleGroup(levelSelector);
//        rb3.setUserData(Game.Level.EXPERT);
//        rb3.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 14));
//        rb3.setTextFill(Color.web("#0f0"));
//
//        levelSelector.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
//            @Override
//            public void changed(ObservableValue<? extends Toggle> ov,
//                    Toggle old_toggle, Toggle new_toggle) {
//                if (levelSelector.getSelectedToggle() != null) {
//                    GameManager.alertMsg(levelSelector.getSelectedToggle().getUserData().toString());
//                }
//            }
//        });
//
//    }
//
//    void setMenuGrid() {
//
//        menuGrid = new GridPane();
//        menuGrid.getStyleClass().add("menuGrid");
//        menuGrid.setHgap(60);
//        menuGrid.setVgap(5);
//        menuGrid.setPadding(new Insets(15, 15, 15, 15));
//        menuGrid.setMaxWidth(500);
//        menuGrid.setMaxHeight(300);
//        //menuGrid.setGridLinesVisible(true);
//        menuGrid.setAlignment(Pos.CENTER);
//
//        setRadioButts();
//
//        Label topLabel = new Label("FROGGER 16");
//        topLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 52));
//        topLabel.setTextFill(Color.web("#f00"));
//        //topLabel.setFont(new Font("Arial", 16));
//        topLabel.setPadding(new Insets(10, 10, 10, 10));
//        topLabel.setStyle("menuGrid");
//        menuGrid.add(topLabel, 0, 0, 2, 1);
//
//        //ImageView imageHouse = new ImageView(
//        //new Image(LayoutSample.class.getResourceAsStream("graphics/house.png")));
//        Label leftLabel = new Label("Highest scores:");
//        leftLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 40));
//        leftLabel.setTextFill(Color.web("#0f0"));
//        leftLabel.setPadding(new Insets(10, 10, 10, 0));
//        menuGrid.add(leftLabel, 0, 1);
//        Label rightLabel = new Label("Options:");
//        rightLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 40));
//        rightLabel.setTextFill(Color.web("#0f0"));
//        rightLabel.setPadding(new Insets(10, 10, 10, 0));
//        menuGrid.add(rightLabel, 1, 1);
//
//        score1.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 18));
//        score1.setFill(Color.rgb(0, 255, 0));
//        menuGrid.add(score1, 0, 2);
//        score2.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 18));
//        score2.setFill(Color.rgb(0, 255, 0));
//        menuGrid.add(score2, 0, 3);
//        score3.setFont(Font.font(fontFamily_0, FontWeight.BOLD, 18));
//        score3.setFill(Color.rgb(0, 255, 0));
//        menuGrid.add(score3, 0, 4);
//
//        GameManager.loadScores();
//
//        Text empty_1 = new Text("");
//        Text empty_2 = new Text("");
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
//        GridPane.setHalignment(quitButt, HPos.CENTER);
//
//        hbMid.setAlignment(Pos.CENTER);
//        hbMid.getChildren().clear();
//        hbMid.getChildren().add(menuGrid);
//
//    }
//
//    double getPondSpace() {
//        return (root.getWidth() - 5 * pondWidth) / 10;
//    }
//
//    void initPonds() {
//
//        pondWidth = pnd_Img.getWidth();
//
//        Pond pond1 = new Pond(pnd_Img);
//        Pond pond2 = new Pond(pnd_Img);
//        Pond pond3 = new Pond(pnd_Img);
//        Pond pond4 = new Pond(pnd_Img);
//        Pond pond5 = new Pond(pnd_Img);
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
//    }
//
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
//
//    private void initLanesArrays() {
//
//        waterLane_1 = new ImageView(wtrLane);
//        waterLane_2 = new ImageView(wtrLane);
//        waterLane_3 = new ImageView(wtrLane);
//        waterLane_4 = new ImageView(wtrLane);
//        waterLane_5 = new ImageView(wtrLane);
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
//    }
//
//    private void setMainLanesArray() {
//
//        initLanesArrays();
//
//        lanes.add(waterLanes.get(0));
//        lanes.add(waterLanes.get(1));
//        lanes.add(waterLanes.get(2));
//        lanes.add(waterLanes.get(3));
//        //lanes.add(waterLanes.get(4));
//        lanes.add(lawnLane);
//        lanes.add(roadLanes.get(0));
//        lanes.add(roadLanes.get(1));
//        lanes.add(roadLanes.get(2));
//        lanes.add(roadLanes.get(3));
//        lanes.add(roadLanes.get(4));
//
//    }
//
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
//    public static void setRunningFrog() {
//
//        int frogNumber;
//        int q = frogPool.getChildren().size() - 1;
//        frogs.get(q).status = Frog.Status.RUNNING;
//        runningFrog = frogs.get(q);
//
//        frogNumber = 4 - q;
//
//        centerDashboard.getChildren().clear();
//        mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 60));
//        centerDashboard.getChildren().add(mainMsg);
//        //mainMsg.setText(""+frogNumber);
//
//        root.getChildren().add(runningFrog);
//
//        getFrogStartPos();
//        runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
//        updateFrogPool();
//
//    }
//
//    static void getFrogStartPos() {
//        if (runningFrog != null) {
//            frogStartPos_X = root.getWidth() / 2 - (runningFrog.getLayoutBounds().getWidth() / 2);
//            frogStartPos_Y = hbBot.getLayoutY() + 12 + smallFrogOffset;
//        }
//    }
//
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
//        sc.setOnKeyPressed((KeyEvent e) -> {
//
//            if (runningFrog.status == Frog.Status.RUNNING) {
//
//                String code = e.getCode().toString();
//
//                if (null != code) {
//
//                    switch (code) {
//                        case "UP":
//
//                            updateScoreDisplay(10);
//
//                            if (runningFrog.getLayoutY() == frogStartPos_Y) {
//                                runningFrog.relocate(runningFrog.getLayoutX(), hbTop.getLayoutY() + lanesMode * 50 + 27 + smallFrogOffset);
//                            } else {
//                                runningFrog.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY() - frogLeap);
//                            }
//
//                            //FROG/POND INTERSECT
//                            if (runningFrog != null && runningFrog.status != Frog.Status.HOME) {
//
//                                try {
//
//                                    int p;
//                                    Pond currentPond;
//                                    for (p = 0; p < ponds.size(); p++) {
//                                        currentPond = ponds.get(p);
//
//                                        if (currentPond.getBoundsInParent().intersects(runningFrog.getBoundsInParent())) {
//
//                                            double x = currentPond.getBoundsInParent().getMinX();
//                                            double y = currentPond.getBoundsInParent().getMinY();
//
//                                            if (currentPond.status == Pond.Status.EMPTY) {
//                                                    
//                                                //pond dispo
//                                                runningFrog.relocate(x + 20, y + 15);
//                                                runningFrog.status = Frog.Status.HOME;
//                                                currentPond.status = Pond.Status.FROGGED;
//                                                Pond.froggedTotal++;
//
//                                                //option bonus
//                                                double s = currentGame.score.score * (runningGame.frogTimeLimit - runningGame.frogTime);
//                                                updateScoreDisplay(s);
//                                                
//                                                //game over, gagné
//                                                if (frogPool.getChildren().isEmpty()) {
//                                                    centerDashboard.getChildren().clear();
//                                                    mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//                                                    centerDashboard.getChildren().add(mainMsg);
//                                                    mainMsg.setText("GAME\nOVER");
//                                                    runningGame.tl.stop();
//                                                    
//                                                //au suivant    
//                                                } else {
//
//                                                    if (Pond.froggedTotal==3){
//                                                        GameManager.getUserInput("hey");
//                                                    }
//                                                    
//                                                    int k = frogPool.getChildren().size();
//                                                    runningGame.setNextFrog(k);
//                                                    
//                                                }
//
//                                            } else {
//
//                                                runningFrog.relocate(x + 20, y + 65);
//
//                                            }
//                                        }
//                                    }
//                                } catch (Error e2) {
//                                    GameManager.alertMsg(e2.getMessage());
//                                }
//
//                                break;
//                            }
//
//                        case "DOWN":
//
//                            updateScoreDisplay(-10);
//
//                            if (runningFrog.getLayoutY() < frogStartPos_Y) {
//
//                                //GET BACK FROM LOWEST LANE
//                                if (runningFrog.getLayoutY() == hbTop.getLayoutY() + lanesMode * 50 + 27 + smallFrogOffset) {
//                                    //frogStartPos_Y=hbBot.getLayoutY()+12;
//                                    //runningFrog.relocate(runningFrog.getLayoutX(), frogStartPos_Y);
//
//                                    getFrogStartPos();
//                                    runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
//                                    //JUMP DOWN
//                                } else {
//                                    runningFrog.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY() + frogLeap);
//                                }
//                            }
//                            break;
//                        case "LEFT":
//                            runningFrog.relocate(runningFrog.getLayoutX() - frogLeap, runningFrog.getLayoutY());
//                            break;
//                        case "RIGHT":
//                            runningFrog.relocate(runningFrog.getLayoutX() + frogLeap, runningFrog.getLayoutY());
//                            break;
//                        default:
//                            break;
//                    }
//                }
//
//                // only add once... prevent duplicates
//                if (!input.contains(code)) {
//                    input.add(code);
//                }
//            }
//
//        }
//        );
//
//        sc.setOnKeyReleased((KeyEvent e) -> {
//            String code = e.getCode().toString();
//            input.remove(code);
//
//        });
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
//        initIndividualSpeed = 7;
//        individualSpeedIncr = 1; //tricky value
//        speedLimit = 10;//15
//        bumperOffset = 250;
//
//        int i, j; //cars array
//        for (i = 0; i < cars.size(); i++) {
//            j = i + 1;
//            cars.get(i).setSpeed(initIndividualSpeed);
//            cars.get(i).relocate((-i * bumperOffset) - 400, 325);
//            initIndividualSpeed = initIndividualSpeed + individualSpeedIncr;
//        }
//    }
//    
//        private void initJunk() {
//
//        Junk wheel = new Junk(whl);
//        Junk tyre = new Junk(tre);
//        Junk bottle1 = new Junk(bttl1);
//        Junk bottle2 = new Junk(bttl2);
//        Junk bottle3 = new Junk(bttl3);
//
//        junk.add(wheel);
//        junk.add(tyre);
//        junk.add(bottle1);
//        junk.add(bottle2);
//        junk.add(bottle3);
//
//        setJunkParameters();
//
//    }
//
//    private void setJunkParameters() {
//
//        //       A T T E N T I O N       //
//        //todo junk params
//        
//        initIndividualSpeed = 7;
//        individualSpeedIncr = 1; //tricky value
//        speedLimit = 10;//15
//        bumperOffset = 250;
//
//        int i, j; //junk array
//        for (i = 0; i < junk.size(); i++) {
//            j = i + 1;
//            junk.get(i).setSpeed(initIndividualSpeed);
//            junk.get(i).relocate((-i * bumperOffset) - 400, 325);
//            initIndividualSpeed = initIndividualSpeed + individualSpeedIncr;
//        }
//    }
//
//    void initDashboard() {
//
//        /*double w= 30;
//        frog_1.setPreserveRatio(true);
//        frog_1.setFitHeight(w);*/
//
//        playerText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        playerText.setFill(Color.rgb(0, 255, 0));
//        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
//        scoreText.setFill(Color.rgb(0, 255, 0));
//        
//        
//        
//        mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//        mainMsg.setFill(Color.rgb(255, 0, 0));
//        
//        frogCounterLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 30));
//        frogCounterLabel.setFill(Color.rgb(0, 255, 0));
//        gameCounterLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 30));
//        gameCounterLabel.setFill(Color.rgb(0, 255, 0));
//        playerLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 30));
//        playerLabel.setFill(Color.rgb(0, 255, 0));
//        scoreLabel.setFont(Font.font(fontFamily_1, FontWeight.BOLD, 30));
//        scoreLabel.setFill(Color.rgb(0, 255, 0));
//        
//        playerLabel.setText("");
//        scoreLabel.setText("Score: ");
//        frogCounterLabel.setText("FrogTime: ");
//        gameCounterLabel.setText("GameTime: ");
//        
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
//        centerDashboard.getChildren().add(goButt);
//        rightDashboard.getChildren().addAll(rightLabelsMain, progressBars);
//
//        hbBot.getChildren().clear();
//        hbBot.getChildren().addAll(leftDashboard, centerDashboard, rightDashboard);
//
//    }
//
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
//    void setStage(Stage s) {
//
//        s.setMinHeight(300);
//        s.setMinWidth(800);
//        s.setScene(sc);
//        s.setTitle("F R O G G E R  16");
//
//        s.setFullScreen(true);      //CHECK LATER  nodes pos bug
//        s.setFullScreenExitHint("");
//        //CHECK LATER
//        /*Rectangle2D primaryScreenBounds = Screen.getPrimary().getBounds();
//            s.setX(primaryScreenBounds.getMinX());
//            s.setY(primaryScreenBounds.getMinY());
//            s.setWidth(primaryScreenBounds.getWidth());
//            s.setHeight(primaryScreenBounds.getHeight());
//            s.show();  */
//    }
//
//    void addCars() {
//        int i;
//        for (i = 0; i < cars.size(); i++) {
//            root.getChildren().add(cars.get(i));
//        }
//
//        root.getChildren().add(mawer);
//    }
//
//    void setSound() {
//        String a = "StayTheNight.mp3";
//        Media m = new Media(new File(a).toURI().toString());
//        MediaPlayer mp = new MediaPlayer(m);
//        mp.play();
//    }
//
//    void setGUI(Scene s, GUIMode gm) {
//
//        if (GMode == GUIMode.MENU) {
//
//            setButts();
//            setMenuGrid();
//
//        } else if (GMode == GUIMode.GAME) {
//
//            initPonds();
//            initLanes(s);
//            initDashboard();
//            initCars();
//            addCars();
//            initFrogs();
//
//        }
//
//    }
//
//    @Override //Application start
//    public void start(Stage st) throws InterruptedException {
//
//        initScene(st);
//        setStage(st);
//        
//        hbMid.setAlignment(Pos.CENTER);
//        hbMid.getChildren().add(splash);
//
//        Task<Void> sleeper = new Task<Void>() {
//            @Override
//            protected Void call() throws Exception {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                }
//                return null;
//            }
//        };
//
//        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                hbMid.getChildren().remove(splash);
//                setGUI(sc, GMode);
//
//                //setStage(st);
//            }
//        });
//        
//        new Thread(sleeper).start();
//        new AnimationTimer() {
//
//            @Override
//
//            // change currentNT name 
//            public void handle(long currentNT) {
//
//                if (GMode == GUIMode.GAME) {
//
//                    //set lanesMode
//                    switch (lanesMode) {
//                        case 2:
//                            carMinY = 126;
//                            carMaxY = 126;
//                            break;
//                        case 4:
//                            carMinY = 176;
//                            carMaxY = 226;
//                            break;
//                        case 6:
//                            carMinY = 226;
//                            carMaxY = 326;
//                            break;
//                        case 8:
//                            carMinY = 276;
//                            carMaxY = 426;
//                            break;
//                        case 10:
//                            carMinY = 326;
//                            carMaxY = 526;
//                            break;
//                        default:
//                            break;
//                    }
//
//                    //car management
//                    int a, b;
//                    for (a = 0; a < cars.size(); a++) {
//
//                        b = a + 1;
//
//                        //LEFT RIGHT   
//                        if (cars.get(a).getLayoutX() > sc.getWidth() + 600) {//2000
//                            cars.get(a).setLayoutX(-600);
//                            cars.get(a).setLayoutY(cars.get(a).getLayoutY() + 50);
//                        }
//
//                        //UP DOWN tricky values ! x steps -250                           
//                        if (cars.get(a).getLayoutY() > carMaxY) {
//                            cars.get(a).setLayoutY(carMinY);
//                            cars.get(a).setLayoutX(-b * bumperOffset);
//                        }
//
//                    }
//
//                    if (mawer.getLayoutX() > sc.getWidth() + 600) {//2000
//                        mawer.setLayoutX(-600);
//                    } else {
//                        mawer.setLayoutX(mawer.getLayoutX() + 5);
//                        mawer.setLayoutY(carMinY - 40);
//                    }
//
//                    //SPEED X
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
//                                    if (cars.get(i).getSpeed() > speedLimit) {
//                                        cars.get(i).setSpeed(cars.get(i).getSpeed() - 7);
//                                    } else {
//                                        cars.get(j).setSpeed(cars.get(i).getSpeed() + 1);
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                    int r;
//                    for (r = 0; r < cars.size(); r++) {
//                        cars.get(r).relocate(cars.get(r).getLayoutX() + cars.get(r).getSpeed(), cars.get(r).getLayoutY());
//
//                        //FROG/CAR INTERSECT
//                        if (runningFrog != null) {
//                            try {
//                                if (cars.get(r).getBoundsInParent().intersects(runningFrog.getBoundsInParent())) {
//                                    System.out.println("c:  " + cars.get(r).getBoundsInParent());
//                                    System.out.println("f:  " + runningFrog.getBoundsInParent());
//                                    root.getChildren().remove(frogOutline);
//                                    root.getChildren().add(3, frogOutline);
//                                    //root.getChildren().get(3).setRotate(30);
//                                    //root.getChildren().get(3).applyCss(-fx-background-color: rgba(255, 255, 255, .4);
//
//                                    frogOutline.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY());
//                                    //frogStartPos_Y=hbBot.getLayoutY()+12;
//                                    getFrogStartPos();
//                                    runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
//                                    //frogStartPos_X = root.getWidth()/2-(runningFrog.getLayoutBounds().getWidth()/2);
//
//                                    runningFrog.setLayoutY(frogStartPos_Y);
//                                }
//                            } catch (Error e) {
//                                GameManager.alertMsg(e.getMessage());
//                            }
//                        }
//                    }
//                }
//            }
//        }     
//        .start();
//        st.show();
//        //Thread.sleep(2000);
//        //hbMid.getChildren().remove(splash);
//
//    }
//
//    private void updateDraw(Stage st) {
//
//        if (GMode == GUIMode.MENU) {
//            //
//        } else if (GMode == GUIMode.GAME) {
//
//            hbTop.setSpacing(getPondSpace());
//            setLanesViewports(sc);
//
//            rootMid = root.getWidth() / 2;
//            rootQuarter = root.getWidth() / 4;
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
//                    for (f = 0; f < cars.size(); f++) {
//                        cars.get(f).relocate(cars.get(f).getLayoutX(), 125);
//                    }
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
//                for (f = 0; f < cars.size(); f++) {
//                    cars.get(f).relocate(cars.get(f).getLayoutX(), 175);
//                }
//
//            } else if (st.getHeight() < 485) {
//
//                if (lanesMode == 6) {
//
//                    lanesMode = 4;
//                    hbMid.getChildren().remove(1);
//                    hbMid.getChildren().remove(3);
//
//                    for (f = 0; f < cars.size(); f++) {
//                        cars.get(f).relocate(cars.get(f).getLayoutX(), 175);
//                    }
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
//                for (f = 0; f < cars.size(); f++) {
//                    cars.get(f).relocate(cars.get(f).getLayoutX(), 225);
//                }
//
//            } else if (st.getHeight() < 585) {
//
//                if (lanesMode == 8) {
//
//                    hbMid.getChildren().remove(1);
//                    hbMid.getChildren().remove(4);
//                    lanesMode = 6;
//
//                    for (f = 0; f < cars.size(); f++) {
//                        cars.get(f).relocate(cars.get(f).getLayoutX(), 225);
//                    }
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
//                for (f = 0; f < cars.size(); f++) {
//                    cars.get(f).relocate(cars.get(f).getLayoutX(), 275);
//                }
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
//                    for (f = 0; f < cars.size(); f++) {
//                        cars.get(f).relocate(cars.get(f).getLayoutX(), 275);
//                    }
//                }
//            } else {
//
//                hbMid.getChildren().clear();
//                int i;
//                for (i = 0; i < lanesMode + 2; i++) {
//                    hbMid.getChildren().add(lanes.get(i));
//                }
//                lanesMode = 10;
//
//                for (f = 0; f < cars.size(); f++) {
//                    cars.get(f).relocate(cars.get(f).getLayoutX(), 325);
//                }
//            }
//        }
//    }
//    
//        public static void main(String[] args) {
//        
//        launch();//frogger.GUIManager.class,args
//        
//    }
//}
