package controller;

import javafx.animation.Animation;
import view.GUIDesign;
import model.Graphics;
import model.IO;
import view.Animator;

public class Singleton {
    
    private Singleton()
    {}
    
    private static class SingletonHolder
    {
        private static final GUIDesign design = new GUIDesign();
        private static final GameManager gma = new GameManager();
        private static final Graphics gr = new Graphics();
        private static final IO io = new IO();
        private static final Singleton instance = new Singleton();
    }
    
    public static GUIDesign getDs() {
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