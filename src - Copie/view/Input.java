///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package view;
//
//import java.util.Optional;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.HPos;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.control.TextInputDialog;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.StackPane;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import javafx.stage.Modality;
//import controller.GameManager;
//import controller.Handler;
//import view.CustomFont;
//
///**
// *
// * @author jb
// */
//public class Input {
//    
//    CustomFont font = new CustomFont();
//    StackPane stp = new StackPane();
//    GridPane userInputGrid;
//    Label topLabel;
//    Button OKButt = new Button("OK");
//    
//    Handler handler = new Handler();
//    
//    void setUserInputGrid() {
//
//        userInputGrid = new GridPane();
//        userInputGrid.getStyleClass().add("menuGrid");
//        userInputGrid.setHgap(60);
//        userInputGrid.setVgap(5);
//        userInputGrid.setPadding(new Insets(15, 10, 15, 10));
//        userInputGrid.setMaxWidth(500);
//        userInputGrid.setMaxHeight(300);
//        userInputGrid.setAlignment(Pos.CENTER);
//
//        topLabel = new Label("3 ponds !\nPlease enter your name :");
//        topLabel.setFont(Font.font(font.fontFamily_0, FontWeight.BOLD, 22));
//        topLabel.setTextFill(Color.web("#80ff00"));
//        topLabel.setPadding(new Insets(10, 10, 10, 10));
//
//        Text empty_1 = new Text("");
//        TextField userInput = new TextField("");
//        Text empty_2 = new Text("");
//
//        OKButt.getStyleClass().add("ipad-dark-grey");
//        int w = 85;
//        int h = 33;
//        OKButt.setPrefSize(w, h);
//        OKButt.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                //handler.okButtHandler();
//            }
//        });
//        
//        userInput.getStyleClass().add("userInput");
//        userInput.setFont(Font.font(font.fontFamily_0, FontWeight.BOLD, 16));
//        userInput.setMinWidth(280);
//        userInputGrid.add(topLabel, 0, 0);
//        userInputGrid.add(userInput, 0, 1);
//        userInputGrid.add(empty_1, 0, 2);
//        userInputGrid.add(OKButt, 0, 3);
//        //playButt.setAlignment(Pos.CENTER_RIGHT);
//        userInputGrid.add(empty_2, 0, 4);
//        
//        userInputGrid.setMinWidth(500);
//        userInputGrid.setMinHeight(368);
//
//        GridPane.setHalignment(topLabel, HPos.CENTER);
//        GridPane.setHalignment(userInput, HPos.CENTER);
//        GridPane.setHalignment(OKButt, HPos.CENTER);
//
//        stp.getChildren().add(GameManager.gr.menuBackground);
//        stp.getChildren().get(0).setScaleX(.8);
//        stp.getChildren().get(0).setScaleY(.8);
//        stp.getChildren().get(0).setOpacity(.8);
//        stp.getChildren().add(userInputGrid);
//        
////        root.getChildren().add(stp);
////        GameManager.gr.menuBackground.getFitHeight();
////
////        stp.setLayoutX(root.getWidth()/2);
////        stp.setLayoutY(root.getHeight()/2);
//        
//    }
//
//    public void getUserInput(String s){
//
//            TextInputDialog dialog = new TextInputDialog(" ");
//            dialog.initModality(Modality.NONE);
//            dialog.setTitle("Name Input Dialog");
//            //dialog.setHeaderText("Three froggin' ponds ! ");
//            dialog.setContentText("Please enter your name: ");
//            Optional<String> result = dialog.showAndWait();
//            
//            result.ifPresent(name -> {
//                System.out.println("Your name: " + name);
//                GameManager.layout.playerLabel.setText("Player: ");
//                GameManager.layout.playerText.setText(result.get());
//            });
//        }
//    
//}