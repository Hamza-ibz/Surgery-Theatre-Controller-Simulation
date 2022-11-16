/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.business;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author hamza
 */
public class Timer {

    int hours = 0, mins = 0, secs = 0;
    boolean sos = true;
    Text text;
    Timeline timeline;

    void change(Text text) {
        if (secs == 60) {
            mins++;
            secs = 0;
        }
        if (mins == 60) {
            hours++;
            mins = 0;
        }
        text.setText((((hours / 10) == 0) ? "0" : "") + hours + ":"
                + (((mins / 10) == 0) ? "0" : "") + mins + ":"
                + (((secs / 10) == 0) ? "0" : "") + secs++);
    }

    public Pane TimerLayout() {

        StackPane timer = new StackPane();
        timer.setPadding(new Insets(10, 10, 10, 10));
//        clock.getChildren().add(Timer());
//        clock.setStyle("-fx-border-color: white;");
        Label title = new Label("Elapsed Time");
        title.setTranslateX(8);
        title.setTranslateY(-8);
        StackPane.setAlignment(title, Pos.TOP_LEFT);

        title.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: white;");
//        clock.setStyle("-fx-border-color: white;"+"-fx-border-radius: 6;");

        title.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        timer.getChildren().addAll(Timer(), title);

        return timer;

    }

    public Pane Timer() {
        StackPane timer = new StackPane();
        timer.setPadding(new Insets(5, 5, 5, 20));
        timer.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        timer.getChildren().add(TimeBorder());

        return timer;

    }

    public Pane TimeBorder() {

        BorderPane border = new BorderPane();
        text = new Text("00:00:00");
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change(text);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
//        text.setPadding(new Insets(5, 5, 5, 5));

        border.setPadding(new Insets(5, 5, 5, 5));
        border.setCenter(text);
        border.setRight(TimerVBox());

        text.setStyle("-fx-text-fill: red;");
        text.setFill(Color.RED);
        text.setFont(Font.font("verdana", FontWeight.MEDIUM, 65));
//        border.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");
        return border;
    }

    public Pane TimerVBox() {

        VBox buttons = new VBox();

//        CustomButton1 start = new CustomButton1("START", 40, 80);
//
//        start.setPadding(new Insets(15, 15, 15, 15));
//
//        start.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        buttons.getChildren().add(TimerVBox2("START", 40, 80, 5, 20, 2, 20));
        buttons.getChildren().add(TimerVBox2("STOP", 40, 80, 2, 20, 2, 20));
        buttons.getChildren().add(TimerVBox2("RESET", 40, 80, 2, 20, 2, 20));

        return buttons;
    }

    public Pane TimerVBox2(String label, int h, int w, int t, int r, int b, int l) {

        VBox buttons = new VBox();

        CustomButton1 start = new CustomButton1(label, w, h);
        
        if(label.equals("START")){
//            System.out.println("vvv");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (sos) {
                    timeline.play();
                    sos = false;
//                    start.setText("Stop");
                } 
//                else {
//                    timeline.pause();
//                    sos = true;
//                    start.setText("Start");
//                }
            }
        });
        }
                if(label.equals("STOP")){
//            System.out.println("vvv");
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                if (sos) {
//                    timeline.play();
//                    sos = false;
////                    start.setText("Stop");
//                } 
                if(!sos) {
                    timeline.pause();
                    sos = true;
//                    start.setText("Start");
                }
            }
        });
        }
                if(label.equals("RESET"))
                		start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	hours = 0;
            	mins = 0;
            	secs = 0;
            	timeline.pause();
            	text.setText("00:00:00");
            	if(!sos) {
            		sos = true;
//            		sButton.setText("Start");
            	}
            }
        });
                

        start.setStyle("-fx-background-color:rgb(0,0,255);" + "-fx-text-fill: white;" + "-fx-border-color: white;" + "-fx-border-width: 1.7;" + "-fx-border-radius: 2;");
        start.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, 13));

        buttons.setPadding(new Insets(t, r, b, l));

//        buttons.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");
        buttons.getChildren().add(start);

        return buttons;
    }

    public class CustomButton1 extends Button {

        public CustomButton1(String label, double w, double h) {
            super(label);
            this.setMinWidth(w);
            this.setMinHeight(h);
            this.setMaxWidth(w);
            this.setMaxHeight(h);
            this.setPrefWidth(w);
            this.setPrefHeight(h);
        }
    }
}

