/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.business;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author hamza
 */
public class Gas {


    public Gas() {
        
    }
    
     public Pane GasBoreder(String color, String header, String HL) {

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(5, 5, 5, 5));
        Label title = new Label(header);
        border.setPrefHeight(90);
        border.setPrefWidth(75);
        title.setPrefHeight(30);
        title.setTranslateX(17);
//        title.setTranslateY(0);
//        BorderPane.setAlignment(title, Pos.TOP_LEFT);
        //        border.setLeft(getGridLayout());
        //        border.setBottom(getGridLayout());
        border.setCenter(GasLayout(color, HL));
//        border.setTop(getGridLayout());
//        border.setStyle("-fx-border-color: white;" + "-fx-border-width: 1.7;");
        title.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: yellow;");
//        clock.setStyle("-fx-border-color: white;"+"-fx-border-radius: 6;");

        title.setFont(Font.font("verdana", FontWeight.LIGHT, 15));
        border.setTop(title);

        return border;
    }

    public Pane GasHBox() {

        HBox hBox = new HBox(5);
        hBox.setPadding(new Insets(5, 3, 5, 3));
//         HBox hhBox = new HBox(5);
//        hhBox.setPadding(new Insets(5, 5, 5, 5));
//        CustomButton btn1 = new CustomButton("Apples", 100, 100);
//        CustomButton btn2 = new CustomButton("Oranges", 100, 100);
//        CustomButton btn3 = new CustomButton("Kiwi", 100, 100);
        hBox.getChildren().add(GasBoreder("rgb(255,67,0)", " O2", " Low"));
        hBox.getChildren().add(GasBoreder("rgb(141,239,140)", "N20", " High"));
        hBox.getChildren().add(GasBoreder("rgb(141,239,140)", "AIR1", "Norm"));
        hBox.getChildren().add(GasBoreder("rgb(255,67,0)", "CO2", "Norm"));
        hBox.getChildren().add(GasBoreder("rgb(255,67,0)", "VAC", " High"));
//        hBox.getChildren().add(hhBox);
//        hBox.getChildren().add(btn3);
//        hBox.setStyle("-fx-border-color: white;" + "-fx-border-width: 1.7;");
//        hhBox.setStyle("-fx-border-color: white;" + "-fx-border-width: 1.7;");
        return hBox;
    }


    public Pane GasLayout(String color, String HL) {
        StackPane hBox = new StackPane();
        Label title = new Label(HL);
        hBox.setPadding(new Insets(5, 14, 5, 14));

        hBox.setStyle("-fx-background-color: " + color + ";");
        title.setStyle("-fx-background-color: " + color + ";" + "-fx-text-fill: black;");
        title.setFont(Font.font("verdana", FontWeight.MEDIUM, 13));
        hBox.setAlignment(title, Pos.CENTER_LEFT);
        hBox.getChildren().add(title);
        return hBox;
    }
    
    public Pane GassLayout() {

        StackPane clock = new StackPane();
        clock.setPadding(new Insets(10, 10, 10, 10));
//        clock.getChildren().add(Gass());
//        clock.setStyle("-fx-border-color: white;");

        Label title = new Label("Medical gases");
        title.setTranslateX(8);
        title.setTranslateY(-8);
        StackPane.setAlignment(title, Pos.TOP_LEFT);

        title.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: white;");
//        clock.setStyle("-fx-border-color: white;"+"-fx-border-radius: 6;");

        title.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        clock.getChildren().addAll(Gass(), title);
        return clock;

    }

    public Pane Gass() {

        HBox gass = new HBox();
        gass.setPadding(new Insets(15, 7, 15, 7));
        gass.getChildren().add(GasHBox());
        gass.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        return gass;

    }
    
}
