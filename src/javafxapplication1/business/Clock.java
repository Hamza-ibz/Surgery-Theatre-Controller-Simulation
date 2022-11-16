/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.business;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author hamza
 */
public class Clock {
    
        public Pane ClockLayout() {

        StackPane clock = new StackPane();
        clock.setPadding(new Insets(10, 10, 10, 10));
        Label title = new Label("Day Time Clock");
        title.setTranslateX(8);
        title.setTranslateY(-8);
        StackPane.setAlignment(title, Pos.TOP_LEFT);

        Label main_clock_lb = new Label();
        main_clock_lb.setFont(Font.font("verdana", FontWeight.MEDIUM, 65));

        StackPane.setAlignment(main_clock_lb, Pos.CENTER);

        main_clock_lb.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: rgb(0,129,0);");
        Thread timerThread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                try {
                    Thread.sleep(1000); //1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String time = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    main_clock_lb.setText(time);

                });
            }
        });
        timerThread.start();//start the thread and its ok
        clock.getChildren().addAll(Clok(), main_clock_lb);

        title.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: white;");
//        clock.setStyle("-fx-border-color: white;"+"-fx-border-radius: 6;");

        title.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        clock.getChildren().addAll(Clok(), title);
//        clock.getChildren().add(Clock());
//        clock.setStyle("-fx-border-color: white;");

        return clock;

    }

    public Pane Clok() {

        StackPane clock = new StackPane();
        clock.setPadding(new Insets(80, 185, 80, 185));

        clock.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        return clock;

    }
}
