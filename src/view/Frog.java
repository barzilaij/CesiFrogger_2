/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.Image;

/**
 *
 * @author jb
 */
public class Frog extends Mobile{
 
    public enum Status {
        POOL,RUNNING,MOWED,DROWNED,FLOATING,HOME
    }
    public static int TIME_LIMIT = 3;
    
    private Status status, previousStatus;
    private static double frogLeap=50;
    private static Frog runningFrog;
 
    Frog(Image i) {  
        setStatus(Status.POOL);
        setPreviousStatus(this.getStatus());
        setImage(i);
        setTime(0);
        setTimeLimit(TIME_LIMIT);
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
    
    public static Frog getRunningFrog() {
        return runningFrog;
    }

    public static void setRunningFrog(Frog runningFrog) {
        Frog.runningFrog = runningFrog;
    }
    
    
}
    

