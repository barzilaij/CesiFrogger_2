/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GameManager;
import controller.Singleton;
import javafx.scene.Scene;
import model.Graphics;
import model.IO;

/**
 *
 * @author jb
 */
public class Animator {
    
    Design design = Singleton.getDs();
    GameManager gma = Singleton.getGma();
    Graphics gr = Singleton.getGr();
    IO io = Singleton.getIo();
    
    Scene sc;

    public Animator(Scene scene){
        this.sc = scene;
        design.setLanesMode(10);
        
        setCarAndJunkGraphicLimits(design.getLanesMode());
        //initCarsPosition();
    }

    public void animate(){
        setJunkAnimation();
        setCarAnimation();
    }
    
    void setCarAndJunkGraphicLimits(int lanesMode){
        
        design.setLaneHeight(50);
        int h=design.getLaneHeight();
        
        switch (lanesMode) {

            case 2:
                Car.minY = 126;
                Car.maxY = 126;
                Junk.maxY = 80;
                break;
            case 4:
                Car.minY = 176;
                Car.maxY = 226;
                Junk.maxY = 80;
                break;
            case 6:
                Car.minY = 226;
                Car.maxY = 326;
                Junk.maxY = 80+h;
                break;
            case 8:
                Car.minY = 276;
                Car.maxY = 426;
                Junk.maxY = 80+2*h;
                break;
            case 10:
                Car.minY = 326;
                Car.maxY = 526;
                Junk.maxY = 80+3*h;
                break;
            default:
                break;
            }
        
        Junk.minY = 85;
        
        }
    
    void setJunkAnimation(){     

        Junk.setRotation(Junk.getRotation()+1);
        double d;
        int c,g;
        for (c = 0; c < design.junk.size(); c++) {
            g=c+1;
            d = ((double)g)/5;
            design.junk.get(c).setRotate(Junk.getRotation()+50*c);

            //JUNK X LIMITS
            if ((c % 2) == 0){//GOES LEFT
                if (design.junk.get(c).getLayoutX() <= 0) {  //2000
                    design.junk.get(c).setLayoutX(sc.getWidth()-10);
                }
                design.junk.get(c).relocate(design.junk.get(c).getLayoutX() - 
                        g/Junk.speedFactor, design.junk.get(c).getLayoutY());
            }else{//GOES RIGHT
                if (design.junk.get(c).getLayoutX() >= sc.getWidth()-10) {  //2000
                    design.junk.get(c).setLayoutX(0);
                }
                design.junk.get(c).relocate(design.junk.get(c).getLayoutX() 
                        + g/Junk.speedFactor, design.junk.get(c).getLayoutY());  
            }
            System.out.println(""+Junk.getMaxY());
            //cadrage Y 
            if (design.junk.get(c).getLayoutY() >= Junk.maxY+1+Junk.bumpFactor) {
                design.junk.get(c).setDirection(Junk.Direction.UP);
            }else if (design.junk.get(c).getLayoutY() <= Junk.minY-1-Junk.bumpFactor) {
                design.junk.get(c).setDirection(Junk.Direction.DOWN);
            }
            if (design.junk.get(c).getDirection()==Junk.Direction.UP){
                design.junk.get(c).setLayoutY(design.junk.get(c).getLayoutY()-d-Junk.bumpFactor); 
            }else if (design.junk.get(c).getDirection()==Junk.Direction.DOWN){
                design.junk.get(c).setLayoutY(design.junk.get(c).getLayoutY()+d+Junk.bumpFactor);
            }

//intersection ordure/grenouille
//            if (runningFrog != null) {
//                try {
//                    if (design.junk.get(c).getBoundsInParent().intersects(runningFrog.getBoundsInParent())) {
//                        ft2.stop();
//                        runningFrog.setStatus(Frog.Status.FLOATING);
//                        runningFrog.relocate(design.junk.get(c).getLayoutX(), design.junk.get(c).getLayoutY());
//                     }
//                } catch (Error e) {
//                    GameManager.alertMsg(e.getMessage());
//                }
//            }

        }
    }
    
    void setCarAnimation(){

        //cadrage XY
        int a;
        int margin = 200;
        for (a = 0; a < design.cars.size(); a++) {

        //reset to left lower lane
        if (design.cars.get(a).getLayoutX() > sc.getWidth() +margin) {//2000
            design.cars.get(a).relocate(-margin, design.cars.get(a).getLayoutY() + 50);
        }else
        //if lower limit: get back to top                        
        if (design.cars.get(a).getLayoutY() > 526) {
            design.cars.get(a).relocate(-a * Car.bumperOffset, 326);
        }

        else if (design.cars.get(a).getLayoutY() < 326) {
            design.cars.get(a).relocate(-a * Car.bumperOffset, 326);
        }else
            design.cars.get(a).relocate(design.cars.get(a).getLayoutX() + 10, design.cars.get(a).getLayoutY());
        }

//        //interaction voitures et vitesse voitures
//        int i, j, k;
//        k = design.cars.size() - 1;
//        for (i = 0; i < design.cars.size(); i++) {
//            for (j = k; j > -1; j--) {
//                if (design.cars.get(i).getLayoutY() == design.cars.get(j).getLayoutY()) {
//                    if (design.cars.get(j).getSpeed() > design.cars.get(i).getSpeed()
//                            && design.cars.get(j).getLayoutX() < design.cars.get(i).getLayoutX() - 60
//                            && design.cars.get(j).getLayoutX() > design.cars.get(i).getLayoutX() - 160) {
//                        design.cars.get(j).setSpeed(design.cars.get(i).getSpeed() - 1);
//                    } else if (design.cars.get(j).getSpeed() < design.cars.get(i).getSpeed()
//                            && design.cars.get(j).getLayoutX() > design.cars.get(i).getLayoutX() + 150
//                            && design.cars.get(j).getLayoutX() < design.cars.get(i).getLayoutX() + 250) //speed limit
//                    {
//                        if (design.cars.get(i).getSpeed() > Car.getSpeedlimit()) {
//                            design.cars.get(i).setSpeed(design.cars.get(i).getSpeed() - 7);
//                        } else {
//                            design.cars.get(j).setSpeed(design.cars.get(i).getSpeed() + 1);
//                        }
//                    }
//                }
//            }
//
//        }

        //int r;
        //for (r = 0; r < design.cars.size(); r++) {
            //design.cars.get(r).relocate(400,400);
            //design.cars.get(r).relocate(design.cars.get(r).getLayoutX() + 50, design.cars.get(r).getLayoutY());
            //intersection voiture/grenouille
//            if (runningFrog != null) {
//                try {
//                    if (design.cars.get(r).getBoundsInParent().intersects(runningFrog.getBoundsInParent())) {
//
//                        impactSound.play();
//                        root.getChildren().remove(frogOutline);
//                        root.getChildren().add(3, frogOutline);
//                        frogOutline.setOpacity(1);
//                        frogOutline.relocate(runningFrog.getLayoutX(), runningFrog.getLayoutY());
//
//                        if (gm.getCurrentGame().getLevel()==Game.Level.BEGINNER){
//                            getFrogStartPos();
//                            runningFrog.relocate(frogStartPos_X, frogStartPos_Y);
//                            runningFrog.setLayoutY(frogStartPos_Y);
//                            setScore(-50);
//                        }else{
//
//                            root.getChildren().remove(runningFrog);
//
//                            //PATCH
//                            if(frogPool.getChildren().isEmpty()){
//                                background_mp.stop();
//                                mower_mp.stop();
//                                carsMix_mp.stop();
//                                bugSound.setVolume(0);
//                                centerDashboard.getChildren().clear();
//                                mainMsg.setFont(Font.font("Arial", FontWeight.BOLD, 24));
//                                centerDashboard.getChildren().add(mainMsg);
//                                mainMsg.setText("GAME\nOVER");
//                                root.getChildren().removeAll(design.cars);
//                                root.getChildren().removeAll(junk);
//                                root.getChildren().removeAll(mower,runningFrog,bug);
//                            }else{
//                                gm.getCurrentGame().setNextFrog();
//                            }
//
//                        }
//                        //gm.getCurrentGame().updateFrogManagement();
//                    }
//                } catch (Error e) {
//                    GameManager.alertMsg(e.getMessage());
//                }
//            }
        //}
        
    }
}
