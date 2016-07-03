
package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import controller.Handler;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;
import controller.Game;
import controller.GameManager;
import controller.Singleton;
import java.util.ArrayList;
import model.Graphics;

/**
 *
 * @author jb
 */
public class Menu {
    
    CustomFont font = new CustomFont();
    //Design design = Singleton.getDs();
    GameManager gma = Singleton.getGma();
    //Graphics gr = Singleton.getGr();
    //IO io = Singleton.getIo();
    BorderPane menu;
    StackPane stp = new StackPane();
    GridPane menuGrid;
    Label topLabel, leftLabel, rightLabel;       
    public Text score1 = new Text("");
    public Text score2 = new Text("");
    public Text score3 = new Text("");
    ArrayList<Text> scores = new ArrayList<>();
    HBox menuButts = new HBox();
    Button playButt = new Button("Play");
    Button quitButt = new Button("Quit");
    final Label[] menuLabels = new Label[6];
    final ToggleGroup tg = new ToggleGroup();
    RadioButton rb1, rb2, rb3;
    
    Handler handler = new Handler();
    Graphics gr;
    GUIManager GUIMan;
    Design layout;

    public Menu(GUIManager gm,Design layout,Graphics gr){
        this.gr=gr;
        this.layout=layout;
        this.GUIMan=gm;
    }
    
    void setScoresList(){
        scores.add(score1);
        scores.add(score2);
        scores.add(score3);
    }
    
    /**
    * Mise en place des boutons 
    * des choix de niveau de jeu
    * 
    * @author jb
    * @version %v%
    */
    void setRadioButts() {

        rb1 = new RadioButton("Beginner");
        rb1.setToggleGroup(tg);
        rb1.setUserData(Game.Level.BEGINNER);
        rb1.setFont(Font.font(font.fontFamily_1, FontWeight.EXTRA_BOLD, 14));
        rb1.setTextFill(Color.web("#fff"));
        rb1.setSelected(true);
        rb2 = new RadioButton("Confirmed");
        rb2.setToggleGroup(tg);
        rb2.setUserData(Game.Level.CONFIRMED);
        rb2.setFont(Font.font(font.fontFamily_1, FontWeight.EXTRA_BOLD, 14));
        rb2.setTextFill(Color.web("#fff"));
        rb3 = new RadioButton("Expert");
        rb3.setToggleGroup(tg);
        rb3.setUserData(Game.Level.EXPERT);
        rb3.setFont(Font.font(font.fontFamily_1, FontWeight.EXTRA_BOLD, 14));
        rb3.setTextFill(Color.web("#fff"));

        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> ov,
                    Toggle old_toggle, Toggle new_toggle) {
                handler.toggleHandler(tg);
            }
        });

    }
    
    /**
    * Mise en place des boutons play/quit
    * 
    * @author jb
    * @version %v%
    */
    void setActionButts() {

        int w = 85;
        int h = 33;
        
        playButt.getStyleClass().add("ipad-dark-grey");
        playButt.setPrefSize(w, h);
        playButt.setMinSize(w, h);
        playButt.setMaxSize(w, h);
        quitButt.getStyleClass().add("ipad-dark-grey");
        quitButt.setPrefSize(w, h);
        quitButt.setMinSize(w, h);
        quitButt.setMaxSize(w, h);

        playButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                handler.playButtHandler(GUIMan,tg);
            }
        });

        quitButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                handler.quitButtHandler();
                Platform.exit();
            }
        });
    }
    
    /**
    * Mise en place du menu
    * 
    * @author jb
    * @version %v%
    */
    public StackPane setMenuPanel() {
        
        setLabels();
        setRadioButts();
        setActionButts();
        setScoresList();

        menuGrid = new GridPane();
        menuGrid.getStyleClass().add("menuGrid");
        menuGrid.setHgap(60);
        menuGrid.setVgap(5);
        menuGrid.setPadding(new Insets(40, 15, 40, 15));
        menuGrid.setMaxWidth(500);
        menuGrid.setMaxHeight(300);
        //menuGrid.setGridLinesVisible(true);
        menuGrid.setAlignment(Pos.CENTER);

        score1.setFont(Font.font(font.fontFamily_0, FontWeight.BOLD, 14));
        score1.setFill(Color.web("#fff"));
        menuGrid.add(score1, 0, 2);
        score2.setFont(Font.font(font.fontFamily_0, FontWeight.BOLD, 14));
        score2.setFill(Color.web("#fff"));
        menuGrid.add(score2, 0, 3);
        score3.setFont(Font.font(font.fontFamily_0, FontWeight.BOLD, 14));
        score3.setFill(Color.web("#fff"));
        menuGrid.add(score3, 0, 4);

        Text empty_1 = new Text("");
        Text empty_2 = new Text("");
        menuGrid.add(empty_1, 0, 5, 2, 1);
        menuGrid.add(playButt, 0, 6);
        menuGrid.add(rb1, 1, 2);
        menuGrid.add(rb2, 1, 3);
        menuGrid.add(rb3, 1, 4);
        menuGrid.add(quitButt, 1, 6);
        menuGrid.add(empty_2, 0, 7, 2, 1);
        
        menuGrid.add(topLabel, 0, 0, 2, 1);
        menuGrid.add(leftLabel, 0, 1);
        menuGrid.add(rightLabel, 1, 1);

        GridPane.setHalignment(topLabel, HPos.CENTER);
        GridPane.setHalignment(playButt, HPos.CENTER);
        GridPane.setValignment(playButt, VPos.BOTTOM);
        GridPane.setValignment(quitButt, VPos.BOTTOM);
        GridPane.setHalignment(quitButt, HPos.LEFT);

        this.layout.hbMid.setAlignment(Pos.CENTER);
        this.layout.hbMid.getChildren().clear();

        stp.getChildren().add(this.gr.menuBackground);
        stp.getChildren().get(0).setScaleX(.82);
        stp.getChildren().get(0).setScaleY(.8);
        stp.getChildren().get(0).setOpacity(.5);
        stp.getChildren().add(menuGrid);

        return stp;
    }
    
    void setLabels(){
        
        topLabel = new Label("FROGGER 16");
        topLabel.setFont(Font.font(font.fontFamily_1, FontWeight.BOLD, 36));
        topLabel.setTextFill(Color.web("#80ff00"));
        topLabel.setPadding(new Insets(10, 10, 10, 10));
        leftLabel = new Label("Highest \nscores:");
        leftLabel.setFont(Font.font(font.fontFamily_1, FontWeight.BOLD, 24));
        leftLabel.setTextFill(Color.web("#80ff00"));
        leftLabel.setPadding(new Insets(0, 0, 5, 0));
        rightLabel = new Label("Options:");
        rightLabel.setFont(Font.font(font.fontFamily_1, FontWeight.BOLD, 24));
        rightLabel.setTextFill(Color.web("#80ff00"));
        rightLabel.setPadding(new Insets(10, 0, 20, 0));
    
    }
    
    public void setScoreDisplay(ArrayList<Game> games){
        for (int i = 0; i < scores.size(); i++) {
            scores.get(i).setText(   Integer.toString(games.get(i).getScore())+"("+games.get(i).getPlayer()+")");
        } 
    }
    
    void fadeIn(Node n,Duration d){
        FadeTransition ft1 = new FadeTransition(d,n);
        ft1.setFromValue(0.0);
        ft1.setToValue(1.0);
        ft1.play();
    }
  
}
