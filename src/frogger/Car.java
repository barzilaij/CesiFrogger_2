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
*Voiture avec vitesse
* 
* @author jb
* @version %v%
*/
public class Car extends ImageView{
    
    double speed;
    static double bumperOffset;
    //static int carDisplayLeftLimit;
    //static int carDisplayRightLimit;
    
    static{
        bumperOffset = 250;
    }
    
    Car(Image i) {
    
        setImage(i);
        
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

 
}
