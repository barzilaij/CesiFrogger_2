/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.scene.image.ImageView;

/**
 *
 * @author jb
 */
public abstract class Mobile extends ImageView{
    
    static public enum Direction {
        UP, DOWN, LEFT,RIGHT
    }
    
    static int minX = 0;
    static int minY = 0;
    static int maxX = 0;
    static int maxY = 0;

    double speed, speedIncr;
    byte index;
    static double bumperOffset, bumpFactor, speedlimit, speedFactor;
    static int rotation;
    String position;
    Direction direction;
    
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }   

    public double getSpeedFactor() {
        return speedFactor;
    }

    public void setSpeedFactor(double speedFactor) {
        this.speedFactor = speedFactor;
    }

    public static double getBumpFactor() {
        return bumpFactor;
    }

    public static void setBumpFactor(double bumpFactor) {
        Mobile.bumpFactor = bumpFactor;
    }

    public byte getIndex() {
        return index;
    }

    public void setIndex(byte index) {
        this.index = index;
    }

    public static int getMinX() {
        return minX;
    }

    public static void setMinX(int minX) {
        Mobile.minX = minX;
    }

    public static int getMinY() {
        return minY;
    }

    public static void setMinY(int minY) {
        Mobile.minY = minY;
    }

    public static int getMaxX() {
        return maxX;
    }

    public static void setMaxX(int maxX) {
        Mobile.maxX = maxX;
    }

    public static int getMaxY() {
        return maxY;
    }

    public static void setMaxY(int maxY) {
        Mobile.maxY = maxY;
    }

    public double getSpeedIncr() {
        return speedIncr;
    }

    public void setSpeedIncr(double speedIncr) {
        this.speedIncr = speedIncr;
    }

    public static double getBumperOffset() {
        return bumperOffset;
    }

    public static void setBumperOffset(double bumperOffset) {
        Mobile.bumperOffset = bumperOffset;
    }

    public static double getSpeedlimit() {
        return speedlimit;
    }

    public static void setSpeedlimit(double speedlimit) {
        Mobile.speedlimit = speedlimit;
    }
        
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public static int getRotation() {
        return rotation;
    }

    public static void setRotation(int rotation) {
        Mobile.rotation = rotation;
    }
    
    
}