package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class Main extends Application {
    public static Label label1;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 260, 450));
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream( "icon.png" )));
        primaryStage.show();
//        label1.textProperty().addListener((observableValue, s, t1) -> {
//            if(label1.getText().length() > 11){
//                double fontSize = label1.getFont().getSize();
//                label1.setFont(Font.font(fontSize-5));
//            }
//        });
    }


    public static void main(String[] args) { launch(args); }
}

