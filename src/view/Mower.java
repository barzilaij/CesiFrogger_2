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
public class Mower extends Mobile{
    
    double mowerOffsetL;
    double mowerOffsetR;
    double mowerRange;
    char mowerDir;
    
    Mower(Image i) {
        setImage(i);
    }
    
}