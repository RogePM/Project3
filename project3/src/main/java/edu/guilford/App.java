package edu.guilford;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import edu.guilford.CalPane.NumberFormatException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException, NumberFormatException {
        VBox root = new VBox();
        // add a title to the window
        stage.setTitle("Tipping Calculator!");
        // instantiate an object and add it root node
       //instantiage a default calculate object
       Calculate calculate  = new Calculate();
       root.getChildren().add(new CalPane(calculate));
        
        //Calculate calculate = new Calculate();


        // root.getChildren().add(new CalPane(calculate));

        scene = new Scene(root, 600, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}