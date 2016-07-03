/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Game;
import controller.GameManager;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import view.GUIManager;

/**
 *
 * @author jb
 */
public class IO {
    
    static String gamesFile;
    private static  int gamesFileNumberOfLines;
    private static ArrayList<Game> games = new ArrayList<>();
    
    public static void initIO(){
        gamesFile = "games.properties";
        loadGamesFile(gamesFile); 
    }

    /**
    *Chargement des données des jeux précedents
    * au format .properties
    * <p>
    * 
    * 
    * @version %v%
    * @param name
    * @return 
    */
    public static Game loadGamesFile(String name){
        Properties p = new Properties();
        InputStream input = null;
        Game tmp = null;
        String line;
        String[] s = null;

        try {
            input = new FileInputStream(name);
            p.load(input);
            setGamesFileNumberOfLines(Integer.valueOf(p.getProperty("s0")));
            
            int k=getGamesFileNumberOfLines();
            int i;
            for (i=1;i<k+1;i++){
                line = p.getProperty("s"+i);
                s = line.split("\\s+");
                int tmpSc = Integer.decode(s[0]);
                String tmpP = s[1];
                Game.Level tmpL = Game.Level.valueOf(s[2]);
                tmp = new Game();
                tmp.setScore(tmpSc);
                tmp.setPlayer(tmpP);
                tmp.setLevel(tmpL);
                games.add(tmp);
                
            }
        } catch (IOException ex) {
            GameManager.alertMsg(ex.getMessage());
        } finally {
            if (input != null) {
                    try {
                            input.close();
                    } catch (IOException e) {
                    }
            }
        }
        return tmp; 
    }
    
    /**
    *Sauvegarde des données du jeu
    * au format .properties
    * <p>
    * 
    * @author jb
    * @version %v%
    */
    public static void saveGamesFile(){
        Properties p = new Properties();
	OutputStream output = null;
        //gameFileNumberOfLines = 2;//(int)games.size();

	try {
            output = new FileOutputStream("games.properties");
            //p.setProperty("s0", Integer.toString(gameFileNumberOfLines));
            int i ;
            String line;
            i=0;
            line = ""+games.size();
            p.setProperty("s"+i,line );
            Collections.sort(games);
            Collections.reverse(games);
                
            for(Game gm : games){
                i++;
                line = (gm.getScore()+" "+gm.getPlayer()+" "+gm.getLevel());
                p.setProperty("s"+i, line);
            }
            
            p.store(output, null);
	} catch (IOException io) {
	} finally {
            if (output != null) {
                    try {
                            output.close();
                    } catch (IOException e) {
                    }
            }
	}
    }
    
    public static String getGamesFile() {
        return gamesFile;
    }

    public static void setGamesFile(String gamesFile) {
        IO.gamesFile = gamesFile;
    }

    public static int getGamesFileNumberOfLines() {
        return gamesFileNumberOfLines;
    }

    public static void setGamesFileNumberOfLines(int gamesFileNumberOfLines) {
        IO.gamesFileNumberOfLines = gamesFileNumberOfLines;
    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    public static void setGames(ArrayList<Game> games) {
        IO.games = games;
    }
    
}
