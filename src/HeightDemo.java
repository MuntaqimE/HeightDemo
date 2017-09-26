import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javax.swing.*;
import java.util.Optional;

/**
 * Created by Muntaqim Elahi on 09/19/17
 * Purpose Converting height and displaying it on javafx
 */
public class HeightDemo extends Application {

    //Swing input Dialog
    String height = JOptionPane.showInputDialog("Enter your height");
    @Override
    //javafx input Dialog
    public void start(Stage primaryStage) {
Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        //Swing input dialog
        TextInputDialog textInputDialog = new TextInputDialog("167.6");
        textInputDialog.setTitle("Metrics Converter");
        textInputDialog.setHeaderText("centimeter to feet and inches converter");
        textInputDialog.setContentText("Enter your height in centimeter");
        textInputDialog.setX(150);
        textInputDialog.setY(80);
        Optional<String> result = textInputDialog.showAndWait();

        //swing logic
        double heightincmswing = Double.parseDouble(height);
        double heightininchesswing = heightincmswing * 0.39;
        int heightinfeetswing = (int) (heightininchesswing/12);
        int remainderheightinfeetswing = (int) (heightininchesswing%12);



        //javafx logic
        double heightincm = 167.6;
        double heightininches = heightincm * 0.39;
        int heightinfeet = (int) (heightininches/12);
        int remainderheightininches = (int) (heightininches%12);

//Use swing to display information
        JOptionPane.showMessageDialog(null,"Your height is " + heightinfeetswing + "feet" + remainderheightinfeetswing + "inches");

        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("Height Converter");
        alert.setHeaderText("Your height is");
        alert.getDialogPane().setPrefSize(360, 100);
        alert.setContentText(heightinfeet + "feet" + remainderheightininches + "inches");
        System.out.println(primaryScreenBounds.getWidth());
        System.out.println(primaryScreenBounds.getHeight());



        alert.setX(primaryScreenBounds.getWidth()-alert.getDialogPane().getPrefWidth());
        alert.setY(primaryScreenBounds.getHeight()-alert.getDialogPane().getPrefHeight()); ;
        alert.showAndWait();




    }
}