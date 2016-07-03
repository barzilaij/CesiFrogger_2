/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;

/**
*Ordure avec données de vitesse et de positionnement
* 
* @author jb
* @version %v%
*/
public class Junk extends Mobile{

    Boolean isSunken;
    
    Junk(Image i) {
        setImage(i);
        setLayoutX(500);
        setLayoutY(100);
        setDirection(Direction.DOWN);
        setRotation(1);
        setSpeedFactor(5);  
        setBumpFactor(getSpeedFactor()/2); 
    }

    public Boolean getIsSunken() {
        return isSunken;
    }

    public void setIsSunken(Boolean isSunken) {
        this.isSunken = isSunken;
    }

}
