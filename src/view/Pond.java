/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import model.Graphics;

/**
*Classe Mare avec flags d'état
* 
* @author jb
* @version %v%
*/
public class Pond extends ImageView{
    
    enum Status {
        EMPTY,BUGGED,FROGGED
    }
    
    Graphics gr;
        
    byte id;
    Status status, previousStatus;
    static byte emptyTotal;
    static int candidate;
    static int width;
    static int froggedTotal;
    static byte numberOfPonds;
    
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

    public static double getPondSpace(BorderPane root) {
        return (root.getWidth() - 5 * Pond.getWidth()) / 10;
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

    public static byte getEmptyTotal() {
        return emptyTotal;
    }

    public static void setEmptyTotal(byte emptyTotal) {
        Pond.emptyTotal = emptyTotal;
    }

    public static int getCandidate() {
        return candidate;
    }

    public static void setCandidate(int candidate) {
        Pond.candidate = candidate;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Pond.width = width;
    }

    public static byte getNumberOfPonds() {
        return numberOfPonds;
    }

    public static void setNumberOfPonds(byte numberOfPonds) {
        Pond.numberOfPonds = numberOfPonds;
    }
    
    
    
}
