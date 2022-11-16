/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafxapplication1.data.DAO;
import javafxapplication1.data.DAOImplementation;

/**
 *
 * @author hamza
 */
public class JavaFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(getStackPane());
//        ,Color.rgb(120, 64, 44, 1)

        primaryStage.setTitle("Surgery Control Panel");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
//        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    DAO dao = new DAOImplementation();
   
    Pane getCompositeLayout1() {
        VBox vBox = new VBox(5);
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.getChildren().add(dao.getLayer1());
        vBox.getChildren().add(dao.getLayer2());
        vBox.getChildren().add(dao.getLayer3());
        return vBox;
    }

    Pane getStackPane() {

        StackPane s = new StackPane();

        s.getChildren().add(getCompositeLayout1());
        s.setStyle("-fx-background-color:rgb(102,67,29);");

        return s;
    }

}
