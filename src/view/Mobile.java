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
    
    private String position;
    private Direction direction;
    private double speed, speedIncr;

    private int time;
    private byte index;
    private static int minX = 0;
    private static int minY = 0;
    private static int maxX = 0;
    private static int maxY = 0;
    private static double bumperOffset, bumpFactor, speedlimit, speedFactor;
    private static int rotation,timeLimit;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }   

    public static double getSpeedFactor() {
        return speedFactor;
    }

    public static void setSpeedFactor(double speedFactor) {
        Mobile.speedFactor = speedFactor;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static int getTimeLimit() {
        return timeLimit;
    }

    public static void setTimeLimit(int timeLimit) {
        Mobile.timeLimit = timeLimit;
    }

}