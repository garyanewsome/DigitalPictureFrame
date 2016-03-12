/*
 * Gary A. Newsome
 * CPT 213 WA Java Programming II
 * Westmoreland County Community College
 * Janet Powell
 */
package digitalpictureframe;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Chapter 15 Programming Challenge 9 Digital Picture Frame
 * @author garyanewsome
 */
public class DigitalPictureFrame extends Application {
  String[] picName = {"blue.png", "green.png", "red.png"};
  int n = picName.length;
  int img = 1;

  @Override
  public void start(Stage stage) throws Exception {
    ImageView iv = new ImageView();
    // create label
    Label imgLabel = new Label();
    // create a pane
    VBox pane = new VBox();
    pane.setAlignment(Pos.CENTER);
    
    // keyframe handler
    EventHandler<ActionEvent>handler = event->{
  //imgLabel.setText("Image " + img);
  //pane.getChildren().addAll(imgLabel, new ImageView(picName[img]));
      img++;
    };
    // build the keyframe
    Duration sec = new Duration(500);
    KeyFrame keyFrame = new KeyFrame(sec, handler);
    // build timeline animation
    Timeline timeline = new Timeline(keyFrame);
    timeline.setCycleCount(Animation.INDEFINITE);
    
// add the image from the array to the pane
  pane.getChildren().addAll(imgLabel, new ImageView(picName[img-1]));
  imgLabel.setText("Image " + img);
  
    // set the stage and show
    Scene scene = new Scene(pane);
    stage.setTitle("Digital Picture Frame");
    stage.setScene(scene);
    stage.show();
    timeline.playFromStart();
  }  
}
