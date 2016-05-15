/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
*Classe Mare avec flags d'état
* 
* @author jb
* @version %v%
*/
public class Pond extends ImageView{
    
    static public enum Status {
        EMPTY,BUGGED,FROGGED
    }
        
    byte id;
    static byte emptyTotal;
    static int candidate;
    public static int froggedTotal;
    static byte numberOfPonds;
    public Status status;
    
    static{
        
        froggedTotal = 0;
        numberOfPonds = 0;
        
    }
    
    Pond() {
    }

    Pond(Image i) {
    
        status = Status.EMPTY;
        numberOfPonds++;
        setImage(i);
        
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
    
    public static int getFroggedTotal() {
        return froggedTotal;
    }

    public static void setFroggedTotal(int froggedTotal) {
        Pond.froggedTotal = froggedTotal;
    }
    
}
