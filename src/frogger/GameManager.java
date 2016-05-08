
package frogger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Properties;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Modality;
import static frogger.GUIManager.*;
import static javafx.application.Application.launch;

/**
 *Gestionnaire de jeu qui permet notamment:
 *<ul> 
 *<li>Le lancement d'un jeu
 *<li>Son initialisation
 *<li>La gestion de la persistance des données
 *<li>l'Obtention des données joueur
 * </ul>
 * <p>
 * La version est indiquée par une variable %v% reconnu par CVS
 * 
 * @author jb
 * @version %v%
 */
public class GameManager {
    
    private static ArrayList<Game> games = new ArrayList<>();
    private static Game currentGame;
    private static Properties gamesFile;
    private static int gameFileNumberOfLines;
    private static String[] s;

    /**
    *Initialisation d'un jeu:
    *<ul> 
    *<li>Instanciation jeu
    *<li>Son initialisation (level, score)
    *<li>Le chargement des données des jeux précedents
    * </ul>
    * <p>
    * 
    * @author jb
    * @version %v%
    */
    static void initGame(Game.Level l){

        currentGame = new Game(l); 
        loadGamesFile();
 
    }
    
    public static void updateGamesArray(Game g){
        games.add(g);        
    }
    
    /**
    *Chargement des données des jeux précedents
    * au format .properties
    * <p>
    * 
    * @author jb
    * @version %v%
    */
    public static String[] loadGamesFile(){
        
        Properties p = new Properties();
        InputStream input = null;
        String line;

        try {

            input = new FileInputStream("games.properties");
            p.load(input);
  
            setGameFileNumberOfLines(Integer.valueOf(p.getProperty("s0")));
            int k=getGameFileNumberOfLines();
            //System.out.println(">>>nb "+k);
            
            int i;
            for (i=1;i<k+1;i++){
                
                //System.out.println(">>>i "+i);
                line = p.getProperty("s"+i);
                //System.out.println(">>> "+line);
                s = line.split("\\s+");
                int tmpSc = Integer.decode(s[0]);
                String tmpP = s[1];
                Game.Level tmpL = Game.Level.valueOf(s[2]);
                
                Game tmp = new Game(tmpL);
                tmp.setScore(tmpSc);
                tmp.setPlayer(tmpP);
                tmp.setLevel(tmpL);

                updateGamesArray(tmp);
                //setMenuGridData(games);
                
        if(i==1)score1.setText(Integer.toString(tmp.getScore())+"   ("+tmp.getPlayer()+")");
        if(i==2)score2.setText(Integer.toString(tmp.getScore())+"   ("+tmp.getPlayer()+")");
        if(i==3)score3.setText(Integer.toString(tmp.getScore())+"   ("+tmp.getPlayer()+")");

            }

            //Collections.sort(games);

        } catch (IOException ex) {
        } finally {
            if (input != null) {
                    try {
                            input.close();
                    } catch (IOException e) {
                    }
            }
        }
        return s; 
    }
    
    /**
    *Chargement des données du jeu
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
            
		io.printStackTrace();
                
	} finally {
            
            if (output != null) {
                    try {
                            output.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            }
	}
    }
 
    /**
    *Obtention du nom du joueur
    * <p>
    * 
    * @author jb
    * @version %v%
    */
    public static void getUserInput(String s){
        
        TextInputDialog dialog = new TextInputDialog(" ");
        dialog.initModality(Modality.NONE);
        dialog.setTitle("Name Input Dialog");
        dialog.setHeaderText("Three froggin' ponds ! ");
        dialog.setContentText("Please enter your name: ");
        Optional<String> result = dialog.showAndWait();
        
        if (result.isPresent()){
            
            System.out.println("Your name: " + result.get());
            GUIManager.playerLabel.setText("Player: ");
            GUIManager.playerText.setText(result.get());
        }
        // The Java 8 way to get the response value (with lambda expression).
        //result.ifPresent(name -> System.out.println("Your name: " + name));

    }
    
    public static ArrayList<Game> getGames() {
        return games;
    }
    
    public static void setGames(ArrayList<Game> games) {
        GameManager.games = games;
    }
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        GameManager.currentGame = currentGame;
    }
    
    public static int getGameFileNumberOfLines() {
        return gameFileNumberOfLines;
    }

    public static void setGameFileNumberOfLines(int gameFileNumberOfLines) {
        GameManager.gameFileNumberOfLines = gameFileNumberOfLines;
    }
    
    /**
    *Boîte de dialogue pour utilisation générale
    * <p>
    * 
    * @author jb
    * @version %v%
    */
    public static void alertMsg(String s){
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.setTitle(""); 
        alert.setHeaderText("Information Alert"); 
        //String s = Double.toString(p);
        alert.setContentText(s); 
        alert.show();
        //System.out.println(s); 
    }
    
    /**
    *Classe main pour lancement programme
    * <p>
    * 
    * @author jb
    * @version %v%
    * @param args liste arguments ligne de commande
    */
    public static void main(String[] args) {
        
        launch(frogger.GUIManager.class,args);
        
    }

}
