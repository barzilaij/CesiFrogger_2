/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frogger;

import static frogger.GUIManager.runningFrog;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.VLineTo;
import javafx.util.Duration;

/**
*Classe grenouille avec champs de vitesse, d'état
* 
* @author jb
* @version %v%
*/
public class Frog extends ImageView{
    
    static public enum Status {
        POOL,RUNNING,DROWNED,FLOATING,HOME
    }
    
    double speed;
    public byte index;
    public Status status;
    static double frogLeap;
    public Status previousStatus;
    
    static{
        frogLeap=50;
    }

    Frog(Image i) {
    
        setStatus(Status.POOL);
        setPreviousStatus(Status.POOL);
        setImage(i);
        
    }
    /**
    *Implémentation future
    * 
    * @author jb
    * @version %v%
    */
    public void doJumpVisual(Node n,Duration d){
        
        Path p = new Path();
        p.getElements().add(new MoveTo(0.0f, 0.0f));
        //p.getElements().add(new LineTo(this.getLayoutX(), this.getLayoutY() - frogLeap));
        p.getElements().add(new VLineTo(-frogLeap));

        PathTransition pt = new PathTransition();
        pt.setDuration(d); 
        pt.setPath(p);
        pt.setNode(this);
        //pt.setOrientation(PathTransition.OrientationType.NONE);
        pt.play();
        
//        ScaleTransition st1 = new ScaleTransition(d,this);
//        st1.setToX(1.2);
//        st1.setToY(1.2);
//        
//        ScaleTransition st2 = new ScaleTransition(d,this);
//        st2.setToX(1.0);
//        st2.setToY(1.0);
//        
//        SequentialTransition seq = new SequentialTransition();
//        seq.getChildren().addAll(st1,st2);
//        seq.play();
        //ParallelTransition pt3 = new ParallelTransition();
        //pt3.getChildren().addAll(pt);
        
            //pt3.play();

    }

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
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
    
}
