/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author jb
 */
public class Graphics {
    
    byte lanesMode;
    byte laneHeight = 50;

    //graphics
    Image splash_Img = new Image("img/splash.png");
    Image bug_Img = new Image("img/bug2.png");
    Image mower_Img = new Image("img/cars/smallhusq2.png");

    Image menu_Img = new Image("img/frogs/niceIntro.jpg");
    Image frog_Img = new Image("img/frogs/frog30_4.png");
    public Image frog_1_Img = new Image("img/frogs/frog30_1.png");
    public Image frog_2_Img = new Image("img/frogs/frog30_2.png");
    public Image frog_3_Img = new Image("img/frogs/frog30_3.png");
    public Image frog_4_Img = new Image("img/frogs/frog30_4.png");
    Image frogOutline_Img = new Image("img/frogs/transpWhiteOutline_30.png");
    public Image pond_Img = new Image("img/frogs/pondAndLily.png");
    Image lily_Img = new Image("img/frogs/lily.jpg");

    public Image waterLane_Img = new Image("img/lanes/waterstrand.png");
    public Image lawnLane_Img = new Image("img/lanes/lawnstrand3.png");
    public Image roadLane_U_Img = new Image("img/lanes/road1_H50_upperhalf.png");
    public Image roadLane_L_Img = new Image("img/lanes/road1_H50_lowerhalf.png");
    public Image roadLane_M_Img = new Image("img/lanes/road1_H50_midhalf.png");

    public Image redCar_Img = new Image("img/cars/redcar.png");
    public Image whiteBeetle_Img = new Image("img/cars/whiteBeetle.png");
    public Image redPickup_Img = new Image("img/cars/redPickup.png");
    public Image yellowCab_Img = new Image("img/cars/yellowCab.png");
    public Image police_2_Img = new Image("img/cars/police2.png");
    public Image police_3_Img = new Image("img/cars/police3.png");
    public Image UKmini_Img = new Image("img/cars/UKmini.png");
    public Image ambulance2_Img = new Image("img/cars/ambulance2.png");
    public Image cementMixer_Img = new Image("img/cars/cementMixer.png");
    public Image policeBlack_Img = new Image("img/cars/policeBlack.png");
    public Image orangeBeetle_Img = new Image("img/cars/orangeBeetle.png");
    public Image blueConv_Img = new Image("img/cars/blueConvertible.png");
    public Image largePickup_Img = new Image("img/cars/largePickup.png");

    public Image wheel_Img = new Image("img/junk/wheel.png");
    public Image tyre_Img = new Image("img/junk/tyre.png");
    public Image bottle_1_Img = new Image("img/junk/bottle1.png");
    public Image bottle_2_Img = new Image("img/junk/bottle2.png");
    public Image bottle_3_Img = new Image("img/junk/bottle3.png");
    public Image bag_1_Img = new Image("img/junk/bag1.png");
    public Image bag_2_Img = new Image("img/junk/bag2.png");
    public Image cad_2_Img = new Image("img/junk/cadillac2.png");
    public Image can_Img = new Image("img/junk/can.png");

    //fixed graphics nodes
    public ImageView splash = new ImageView(splash_Img);
    public ImageView bug = new ImageView(bug_Img);
    public ImageView mower = new ImageView(mower_Img);
    public ImageView menuBackground = new ImageView(menu_Img);

    public ImageView frog_1 = new ImageView(frog_1_Img);
    public ImageView frog_2 = new ImageView(frog_2_Img);
    public ImageView frog_3 = new ImageView(frog_3_Img);
    public ImageView frog_4 = new ImageView(frog_4_Img);
    public ImageView frogOutline = new ImageView(frogOutline_Img);

    public ImageView lawnLane = new ImageView(lawnLane_Img);
    public ImageView waterLane_1 = new ImageView(waterLane_Img);
    public ImageView waterLane_2 = new ImageView(waterLane_Img);
    public ImageView waterLane_3 = new ImageView(waterLane_Img);
    public ImageView waterLane_4 = new ImageView(waterLane_Img);
    public ImageView waterLane_5 = new ImageView(waterLane_Img);

    public ImageView roadLane_U = new ImageView(roadLane_U_Img);
    public ImageView roadLane_L = new ImageView(roadLane_L_Img);
    public ImageView roadLane_M1 = new ImageView(roadLane_M_Img);
    public ImageView roadLane_M2 = new ImageView(roadLane_M_Img);
    public ImageView roadLane_M3 = new ImageView(roadLane_M_Img);

    public Graphics(){
    }
    
    public void setBackground(VBox vb,String img ){
//            String image = JavaFXApplication9.class.getResource(img).toExternalForm();
//            vb.setStyle("-fx-background-image: url('" + image + "'); " +
//            "-fx-background-position: left top; " +
//            "-fx-background-size:   2500,200  ; " +
//            "-fx-background-repeat: stretch;");
    }
    
    public byte getLanesMode() {
        return lanesMode;
    }

    public void setLanesMode(byte lanesMode) {
        this.lanesMode = lanesMode;
    }

}
