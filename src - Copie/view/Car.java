/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;

/**
*Voiture avec vitesse
* 
* @author jb
* @version %v%
*/
public class Car extends Mobile{

    Car(Image i) {
        setImage(i);
        this.setBumperOffset(250);
        this.setSpeed(7);
        this.setSpeedlimit(10);
        this.setSpeedIncr(1);
    }
}