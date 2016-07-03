/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.nio.file.Paths;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author jb
 */
public class Audio {
    
    String dplash2 = "src/audio/mp3/pondAmbi.mp3"; 
    String background = "src/audio/mp3/background.mp3";
    String carsMix = "src/audio/mp3/carsMix.mp3";
    String mower = "src/audio/mp3/mower.mp3"; 

    Media dplash2_m = new Media(new File(dplash2).toURI().toString());
    Media background_m = new Media(new File(background).toURI().toString());
    Media carsMix_m = new Media(new File(carsMix).toURI().toString());
    Media mower_m = new Media(new File(mower).toURI().toString());
    
    public MediaPlayer dplash2_mp = new MediaPlayer(dplash2_m);
    public MediaPlayer background_mp = new MediaPlayer(background_m);
    public MediaPlayer carsMix_mp = new MediaPlayer(carsMix_m);
    public MediaPlayer mower_mp = new MediaPlayer(mower_m);

    public AudioClip greatbell1Sound = new AudioClip(Paths.get("src/audio/mp3/greatbell1.mp3").toUri().toString());
    public AudioClip impactSound = new AudioClip(Paths.get("src/audio/mp3/impact.mp3").toUri().toString());
    public AudioClip duck1Sound = new AudioClip(Paths.get("src/audio/mp3/duck1.mp3").toUri().toString());
    public AudioClip n2Sound = new AudioClip(Paths.get("src/audio/mp3/n2.mp3").toUri().toString());
    public AudioClip yeehawSound = new AudioClip(Paths.get("src/audio/mp3/yeehaw.mp3").toUri().toString());
    public AudioClip bugSound = new AudioClip(Paths.get("src/audio/mp3/n4.mp3").toUri().toString());
    public AudioClip pondSplashSound = new AudioClip(Paths.get("src/audio/mp3/pondSplash.mp3").toUri().toString());
    public AudioClip gameoverSound = new AudioClip(Paths.get("src/audio/mp3/gameover.mp3").toUri().toString());
  
}