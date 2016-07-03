package controller;

import javafx.animation.Animation;
import view.Design;
import model.Graphics;
import model.IO;
import view.Animator;

public class Singleton {
    
    private Singleton()
    {}
    
    private static class SingletonHolder
    {
        private static final Design design = new Design();
        private static final GameManager gma = new GameManager();
        private static final Graphics gr = new Graphics();
        private static final IO io = new IO();
        private static final Singleton instance = new Singleton();
    }
    
    public static Design getDs() {
        return SingletonHolder.design;
    }
    
    public static GameManager getGma() {
        return SingletonHolder.gma;
    }
    
    public static Graphics getGr() {
        return SingletonHolder.gr;
    }
        
    public static IO getIo() {
        return SingletonHolder.io;
    }

//    public static Singleton getInstance()
//    {
//        return SingletonHolder.instance;
//    }

}