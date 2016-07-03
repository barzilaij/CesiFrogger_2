///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//
//import view.*;
//import javafx.beans.value.ObservableValue;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.ProgressBar;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import controller.Handler;
//import java.util.ArrayList;
//import javafx.geometry.Rectangle2D;
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.Priority;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import model.Graphics;
//
///**
// *
// * @author jb
// */
//public class Design_1 {
//
//    Handler handler = new Handler();
//    CustomFont font = new CustomFont();
//    Graphics gr = new Graphics();
//    //Graphics gr = Singleton.getGr();
//    
//    public ArrayList<Car> cars = new ArrayList<>();
//    public ArrayList<Frog> frogs = new ArrayList<>();
//    public ArrayList<Junk> junk = new ArrayList<>();
//    public ArrayList<Pond> ponds = new ArrayList<>();
//    public ArrayList<ImageView> lanes = new ArrayList<>();
//    public ArrayList<ImageView> waterLanes = new ArrayList<>();
//    public ArrayList<ImageView> roadLanes = new ArrayList<>();
//    
//    //main boxes
//    HBox hbTop = new HBox();
//    VBox hbMid = new VBox();
//    HBox hbBot = new HBox();
//    VBox hbLeft = new VBox();
//    VBox hbRight = new VBox();
//    
//    //sub boxes
//    HBox frogPool = new HBox();
//    HBox leftDashboard = new HBox();
//    HBox centerDashboard = new HBox();
//    HBox rightDashboard = new HBox();
//    HBox leftLabelsMain = new HBox();
//    HBox rightLabelsMain = new HBox();
//    VBox progressBars = new VBox();
//    VBox leftLabelsSubL = new VBox();
//    VBox leftLabelsSubR = new VBox();
//    VBox rightLabelsSubL = new VBox();
//    VBox rightLabelsSubR = new VBox();
//    
//    //labels
//    public Text playerLabel = new Text();
//    public Text scoreLabel = new Text();
//    public Text playerText = new Text();
//    public Text scoreText = new Text();
//    Text mainMsg = new Text();
//    Text frogCounterLabel = new Text();
//    Text gameCounterLabel = new Text();
//    Text frogCounterText = new Text();
//    Text gameCounterText = new Text();
//    
//    //progressbars
//    ProgressBar pBar1 = new ProgressBar();
//    ProgressBar pBar2 = new ProgressBar();
//    
//    //particles
//    Group g1,g2,g3,g4,g5,g6;
//    
//    //lanes
//    private int laneHeight;
//    private int lanesMode;
//    
//    public Design_1(){
//    }
//
//    void setGameSubBoxes(){
//        
//        leftLabelsSubL.getChildren().addAll(playerLabel,scoreLabel);
//        leftLabelsSubR.getChildren().addAll(playerText,scoreText);
//        rightLabelsSubL.getChildren().addAll(frogCounterLabel,gameCounterLabel);
//        rightLabelsSubR.getChildren().addAll(frogCounterText,gameCounterText);
//        leftLabelsSubR.setAlignment(Pos.TOP_LEFT);
//        rightLabelsSubR.setAlignment(Pos.TOP_LEFT);
//        leftLabelsSubL.setMaxWidth(150);
//        leftLabelsSubR.setMaxWidth(150);
//        rightLabelsSubL.setMaxWidth(150);
//        rightLabelsSubR.setMaxWidth(150);
//        
//        leftLabelsMain.setPrefWidth(200);
//        leftLabelsMain.setAlignment(Pos.CENTER_LEFT);
//        leftLabelsMain.setPadding(new Insets(0, 10, 0, 10));
//        rightLabelsMain.setPrefWidth(200);
//        rightLabelsMain.setAlignment(Pos.CENTER_LEFT);
//        rightLabelsMain.setPadding(new Insets(0, 10, 0, 10));
//        leftLabelsMain.getChildren().addAll(leftLabelsSubL,leftLabelsSubR);
//        rightLabelsMain.getChildren().addAll(rightLabelsSubL,rightLabelsSubR);
//
//     }
//
//    /**
//    *Initialisation GUI des 3 zones principales du terrain de jeu 
//    * <p>
//    * 
//    * @author jb
//    * @version %v%
//    */
//    public void initScene(BorderPane root, Scene sc, Stage st) {
//
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
//        hbTop.setPrefHeight(75);
//        hbTop.setMinHeight(75);
//
//        root.setTop(hbTop);
//        root.setCenter(hbMid);
//        root.setBottom(hbBot);
//        root.setLeft(hbLeft);
//        root.setRight(hbRight);
//        root.setPrefSize(1024, 650);
//        
//        sc.getStylesheets().add("view/style.css");
//        sc.widthProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) -> {
//            handler.updateSceneWidth(st);
//        });
//
//        sc.heightProperty().addListener((ObservableValue<? extends Number> observableValue, Number oldSceneHeight, Number newSceneHeight) -> {
//            handler.updateSceneHeight(st);
//        });
//    }
//    
//    public void initStage(Stage st, Scene sc) {
//        st.setMinHeight(490);
//        st.setMinWidth(800);
//        st.setScene(sc);
//        st.setTitle("F R O G G E R  16");
//        st.setFullScreen(true);      //CHECK LATER  nodes pos bug
//        st.setFullScreenExitHint("");
//        st.show();
//    }
//    
//    /**
//    * Mise en place des mares
//    * 
//    * @author jb
//    * @version %v%
//     * @param hb
//    */
//    public void setPonds(BorderPane root, HBox hb) {
//        
//        Pond pond1 = new Pond(gr.pond_Img);
//        Pond pond2 = new Pond(gr.pond_Img);
//        Pond pond3 = new Pond(gr.pond_Img);
//        Pond pond4 = new Pond(gr.pond_Img);
//        Pond pond5 = new Pond(gr.pond_Img);
//        ponds.add(pond1);
//        ponds.add(pond2);
//        ponds.add(pond3);
//        ponds.add(pond4);
//        ponds.add(pond5);
//        hb.getChildren().clear();
//        hb.getChildren().add(ponds.get(0));
//        hb.getChildren().add(ponds.get(1));
//        hb.getChildren().add(ponds.get(2));
//        hb.getChildren().add(ponds.get(3));
//        hb.getChildren().add(ponds.get(4));
//
//        hb.setAlignment(Pos.CENTER);
//        hb.setSpacing(Pond.getPondSpace(root));
//        
//    }
//
//    void setLanes(Scene sc) {
//        
//        waterLanes.add(gr.waterLane_1);
//        waterLanes.add(gr.waterLane_2);
//        waterLanes.add(gr.waterLane_3);
//        waterLanes.add(gr.waterLane_4);
//        
//        roadLanes.add(gr.roadLane_U);
//        roadLanes.add(gr.roadLane_M1);
//        roadLanes.add(gr.roadLane_M2);
//        roadLanes.add(gr.roadLane_M3);
//        roadLanes.add(gr.roadLane_L);
//        
//        lanes.add(waterLanes.get(0));
//        lanes.add(waterLanes.get(1));
//        lanes.add(waterLanes.get(2));
//        lanes.add(waterLanes.get(3));
//        lanes.add(gr.lawnLane);
//        lanes.add(roadLanes.get(0));
//        lanes.add(roadLanes.get(1));
//        lanes.add(roadLanes.get(2));
//        lanes.add(roadLanes.get(3));
//        lanes.add(roadLanes.get(4));
//        
//        hbMid.setAlignment(Pos.TOP_LEFT);
//        hbMid.getChildren().clear();
//
//        int i;
//        for (i=0;i<lanes.size();i++){
//            hbMid.getChildren().add(lanes.get(i));
//        }
//        
//        lanesMode = 10;
//        setLanesViewports(sc);
//    }
//    
//    /**
//    * Calcul de l'affichage des voies
//    * en fonction de la largeur d'écran
//    * 
//    * @author jb
//    * @version %v%
//    */
//    void setLanesViewports(Scene sc) {
//
//        int i;
//        double w = sc.getWidth();
//        double h = this.getLaneHeight();
//        Rectangle2D r = new Rectangle2D(0, 0, w, h);
//        //Rectangle2D junkBackground = new Rectangle2D(0, 0, w, lanesMode*h);
//
//        for (i=0;i<lanes.size();i++){
//            lanes.get(i).setFitWidth(w);
//            lanes.get(i).setViewport(r);
//        }
//    }
//    
//    void setCars(BorderPane root) {
//
//        cars.add(new Car(gr.redCar_Img));
//        cars.add(new Car(gr.whiteBeetle_Img));
//        cars.add(new Car(gr.redPickup_Img));
//        cars.add(new Car(gr.yellowCab_Img));
//        cars.add(new Car(gr.police2_Img));
//        cars.add(new Car(gr.police3_Img));
//        cars.add(new Car(gr.UKmini_Img));
//        cars.add(new Car(gr.largePickup_Img));
//        cars.add(new Car(gr.blueConv_Img));
//        cars.add(new Car(gr.orangeBeetle_Img));
//        cars.add(new Car(gr.cementMixer_Img));
//
//        //initCarsPosition();
//        addCars(root);
//
//    }
//
////    void initCarsPosition() {
////
////        int i;
////        //10 lanes
////        Car.minY = 326;
////        Car.maxY = 526;
////        for (i = 0; i < cars.size(); i++) {
////            cars.get(i).setLayoutX(-i * Car.bumperOffset);
////        }
////    }
//    
//    void addCars(BorderPane root) {
//        
//        int i;
//        for (i = 0; i < cars.size(); i++) {
//            root.getChildren().add(cars.get(i));
//        }
//    }
//    
////    private void initJunk() {
////
//////        Junk wheel = new Junk(gr.whl);
//////        Junk tyre = new Junk(gr.tre);
//////        Junk bottle1 = new Junk(gr.bttl1);
//////        Junk bottle2 = new Junk(gr.bttl2);
//////        Junk bottle3 = new Junk(gr.bttl3);
//////        Junk wheel2 = new Junk(gr.whl);
//////        Junk tyre2 = new Junk(gr.tre);
//////        Junk bg1 = new Junk(gr.bag1);
//////        Junk bg2 = new Junk(gr.bag2);
//////        Junk cd2 = new Junk(gr.cad2);
//////        Junk cn = new Junk(gr.can);
//////
//////        junk.add(bottle1);
//////        junk.add(bottle2);
//////        junk.add(bottle3);
//////        //junk.add(tyre2);
//////        junk.add(bg1);
//////        junk.add(bg2);
//////        junk.add(cn);
//////        //junk.add(wheel);
//////        junk.add(tyre);
//////        junk.add(wheel2);
//////        
//////        junkRotateValue=1;
////
////    }
////
////    /**
////    *Paramétrage stage
////    * <p>
////    * 
////    * @author jb
////    * @version %v%
////    */
////
////
//
////    
////    void addJunk() {
//////        int i;
//////        for (i = 0; i < junk.size(); i++) {
//////            //junk.get(i).setOpacity(0.6);
//////            root.getChildren().add(junk.get(i));
//////            
//////        }
////    }
//
////        void initDashboard() {
////        
////        playerText.setFont(Font.font("Arial", FontWeight.BOLD, 18));
////        playerText.setFill(Color.web("#80ff00"));
////        scoreText.setFont(Font.font("Arial", FontWeight.BOLD, 18));
////        scoreText.setFill(Color.web("#80ff00"));
////
////        mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
////        mainMsg.setFill(Color.rgb(255, 0, 0));
////        
////        frogCounterLabel.setFont(Font.font(font.fontFamily_1, FontWeight.BOLD, 20));
////        frogCounterLabel.setFill(Color.web("#80ff00"));
////        gameCounterLabel.setFont(Font.font(font.fontFamily_1, FontWeight.BOLD, 20));
////        gameCounterLabel.setFill(Color.web("#80ff00"));
////        playerLabel.setFont(Font.font(font.fontFamily_1, FontWeight.BOLD, 20));
////        playerLabel.setFill(Color.web("#80ff00"));
////        scoreLabel.setFont(Font.font(font.fontFamily_1, FontWeight.BOLD, 20));
////        scoreLabel.setFill(Color.web("#80ff00"));
////        
////        playerLabel.setText("");
////        scoreLabel.setText("Score  : ");
////        frogCounterLabel.setText("FrogTime: ");
////        gameCounterLabel.setText("GameTime: ");
////        
////        frogCounterText.setFont(Font.font("Arial", FontWeight.BOLD, 18));
////        frogCounterText.setFill(Color.web("#80ff00"));
////        gameCounterText.setFont(Font.font("Arial", FontWeight.BOLD, 18));
////        gameCounterText.setFill(Color.web("#80ff00"));
////        
////        pBar1.setMinWidth(200);
////        pBar2.setMinWidth(200);
////        pBar1.setProgress(0);
////        pBar2.setProgress(0);
////
////        frogPool.setAlignment(Pos.CENTER);
////        frogPool.setPadding(new Insets(0, 15, 0, 15));
////        frogPool.setPrefWidth(200);
////
////        progressBars.setAlignment(Pos.TOP_CENTER);
////        progressBars.setPadding(new Insets(0, 15, 0, 15));
////        progressBars.setPrefWidth(200);
////
////        frogCounterText.getStyleClass().add("labels");
////        gameCounterText.getStyleClass().add("labels");
////
////        progressBars.getChildren().add(pBar1);
////        progressBars.getChildren().add(pBar2);
////
////        leftDashboard.setPrefWidth(600);
////        leftDashboard.setAlignment(Pos.CENTER_LEFT);
////        centerDashboard.setStyle("-fx-border-color: red;-fx-background-color: #030");
////        centerDashboard.setMinWidth(75);
////        centerDashboard.setAlignment(Pos.CENTER);
////        HBox.setHgrow(centerDashboard, Priority.ALWAYS);
////        rightDashboard.setPrefWidth(600);
////        rightDashboard.setAlignment(Pos.CENTER_RIGHT);
////        
////        leftDashboard.getChildren().addAll(frogPool, leftLabelsMain);
////        rightDashboard.getChildren().addAll(rightLabelsMain, progressBars);
////        hbBot.getChildren().clear();
////        hbBot.getChildren().addAll(leftDashboard, centerDashboard, rightDashboard);
////
////    }
//
//    public int getLaneHeight() {
//        return laneHeight;
//    }
//
//    public void setLaneHeight(int laneHeight) {
//        this.laneHeight = laneHeight;
//    }
//
//    public int getLanesMode() {
//        return lanesMode;
//    }
//
//    public void setLanesMode(int lanesMode) {
//        this.lanesMode = lanesMode;
//    }
//
//        
//}