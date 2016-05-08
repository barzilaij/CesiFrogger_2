/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
/**
 *
 * @author jb
 */
public final class Junk extends ImageView{
    
    static public enum Direction {
        UP, DOWN
    }
    
    static double speed,speedFactor,bumpFactor;
    Boolean isSunken;
    Direction d;
    
    static{
        speedFactor=5;  //5  
        bumpFactor=speedFactor/2;  
    }
    
    Junk(Image i) {
    
        setImage(i);
        this.setDirection(Direction.DOWN);
        this.setLayoutX(500);
        this.setLayoutY(100);
    }

    public Direction getDirection() {
        return d;
    }

    public void setDirection(Direction d) {
        this.d = d;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

 
}
