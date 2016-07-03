/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author jb
 */
public class Frog extends Mobile{
 
    enum Status {
        POOL,RUNNING,MOWED,DROWNED,FLOATING,HOME
    }
    
    Status status, previousStatus;
    static double frogLeap=50;
 
    Frog(Image i) {  
        setStatus(Status.POOL);
        setPreviousStatus(this.getStatus());
        setImage(i);
    }

    Frog(Image i,Status s) {
        setStatus(s);
        setPreviousStatus(this.getStatus());
        setImage(i);
    }
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(Status previousStatus) {
        this.previousStatus = previousStatus;
    }
    
    public static double getFrogLeap() {
        return frogLeap;
    }

    public static void setFrogLeap(double frogLeap) {
        Frog.frogLeap = frogLeap;
    }
    
}
    

