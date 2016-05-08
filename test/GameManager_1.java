///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//import frogger.*;
//import static frogger.GUIManager.setRunningFrog;
//import javafx.scene.control.Toggle;
//import frogger.GUIManager.*;
////import static frogger.GUIManager.scores;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Optional;
//import java.util.Properties;
//import static javafx.application.Application.launch;
//import javafx.scene.control.Alert;
//import javafx.stage.Stage;
//import static javafx.application.Application.launch;
//import static javafx.application.Application.launch;
//import static javafx.application.Application.launch;
//import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.TextInputDialog;
//import javafx.stage.Modality;
//import static javafx.application.Application.launch;
//import static javafx.application.Application.launch;
//import static javafx.application.Application.launch;
//import static javafx.application.Application.launch;
//
//
//
///**
// *
// * @author jb
// */
//public class GameManager_1 {
//    
//    static ArrayList<jet_Score> scores = new ArrayList<>();
//    static Game currentGame;
//
//    static Game initGame(Game.Level l){
//       
//        currentGame = new Game(l);  
//        loadScores();
//        return currentGame;
//        
//        //test
//        //scores.add(e)
//
//    }
//    
//    public static void loadScores(){
//        
//        /*Properties prop = new Properties();
//        InputStream input = null;
//
//        try {
//
//            input = new FileInputStream("scores.properties");
//            prop.load(input);
//
//            scores.add(currentGame.score);
//            scores.add(prop.getProperty("first"));
//            scores.add(prop.getProperty("second"));
//            scores.add(prop.getProperty("third"));
//            Collections.sort(scores);
//            GUIManager.score1.setText(scores.get(0));
//            GUIManager.score2.setText(scores.get(1));
//            GUIManager.score3.setText(scores.get(2));
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        } finally {
//            if (input != null) {
//                    try {
//                            input.close();
//                    } catch (IOException e) {
//                            e.printStackTrace();
//                    }
//            }
//        }*/
//    }
//    
//    public static void saveScores(){
//        
//        Properties prop = new Properties();
//	OutputStream output = null;
//
//	try {
//
//            output = new FileOutputStream("scores.properties");
//
//            prop.setProperty("database", "localhost");
//            prop.setProperty("dbuser", "mkyong");
//            prop.setProperty("dbpassword", "password");
//
//            // save properties to project root folder
//            prop.store(output, null);
//
//	} catch (IOException io) {
//            
//		io.printStackTrace();
//                
//	} finally {
//            
//            if (output != null) {
//                    try {
//                            output.close();
//                    } catch (IOException e) {
//                            e.printStackTrace();
//                    }
//            }
//	}
//    }
//    
//    public static void alertMsg(String s){
//        
//        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
//        alert.setTitle(""); 
//        alert.setHeaderText("Information Alert"); 
//        //String s = Double.toString(p);
//        alert.setContentText(s); 
//        alert.show();
//        System.out.println(s); 
//    }
//    
//    public static void getUserInput(String s){
//        
//        TextInputDialog dialog = new TextInputDialog("");
//        dialog.initModality(Modality.NONE);
//        dialog.setTitle("Name Input Dialog");
//        dialog.setHeaderText("Three froggin' ponds ! ");
//        dialog.setContentText("Please enter your name: ");
//        //dialog.setGraphic(AlertType.CONFIRMATION);
//
//        // Traditional way to get the response value.
//        //Optional<String> result = dialog.showAndWait();
//        Optional<String> result = dialog.showAndWait();
//        if (result.isPresent()){
//            
//            System.out.println("Your name: " + result.get());
//            GUIManager.playerLabel.setText("Player: ");
//            GUIManager.playerText.setText(result.get());
//        }
//
//        // The Java 8 way to get the response value (with lambda expression).
//        //result.ifPresent(name -> System.out.println("Your name: " + name));
//
//    }
//    
//        /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        
//        launch(frogger.GUIManager.class,args);
//        
//    }
//
//}
