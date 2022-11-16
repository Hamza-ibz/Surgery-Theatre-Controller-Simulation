/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.business;

import java.io.File;
import java.nio.file.Paths;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author hamza
 */
public class Pressure {

    private PNumbers num;
    private BorderPane border = new BorderPane();

    public class PNumbers extends Label {

        Text view;

        public PNumbers(Text view) {
            this.view = view;
        }

        public void increase() {
//            this.view.getText();
            int dnum = Integer.parseInt(this.view.getText());
            dnum = dnum + 10;
            this.view.setText("" + dnum);
//            System.out.println(this.view);
        }

        public void decrease() {
//            this.view.getText();
            int dnum = Integer.parseInt(this.view.getText());
            dnum = dnum - 10;
            this.view.setText("" + dnum);
//            System.out.println(this.view);
        }

        public Text getView() {
            return this.view;
        }

    }

    public Pane PressureLayout() {

        StackPane clock = new StackPane();
        clock.setPadding(new Insets(10, 10, 10, 12));
//        clock.getChildren().add(Pressure());
//        clock.setStyle("-fx-border-color: white;");

        Label title = new Label("Pressure Control");
        title.setTranslateX(8);
        title.setTranslateY(-8);
        StackPane.setAlignment(title, Pos.TOP_LEFT);

        title.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: white;");
//        clock.setStyle("-fx-border-color: white;"+"-fx-border-radius: 6;");

        title.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        clock.getChildren().addAll(Prsr(), title);

        return clock;

    }

    public Pane Prsr() {

        StackPane pressure = new StackPane();
        pressure.setPadding(new Insets(10, 15, 10, 10));
        pressure.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        pressure.getChildren().add(preBoreder());

        return pressure;
    }

    public Pane preBoreder() {

        border = new BorderPane();
        num = new PNumbers(new Text("80"));
        Label kpa = new Label("kPa");

        border.setPadding(new Insets(5, 5, 5, 5));
        kpa.setPadding(new Insets(35, 5, 5, 5));
        num.setPadding(new Insets(5, 5, 5, 23));

//        border.getChildren().add(imageView);
        border.setBottom(PreHbox());
        border.setCenter(num.getView());
        border.setLeft(PreHbox2("pressure-icon.png", 70, 70, 10, 10, 10, 10));
        border.setRight(kpa);
//        border.setCenter(title);
        num.getView().setFill(Color.RED);
        num.getView().setFont(Font.font("verdana", FontWeight.MEDIUM, 50));
//        num.setStyle("-fx-text-fill: red;");
//        num.setFont(Font.font("verdana", FontWeight.MEDIUM, 50));

        kpa.setStyle("-fx-text-fill: white;");
        kpa.setFont(Font.font("verdana", FontWeight.LIGHT, 22));
//        border.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");
        return border;
    }

    public Pane PreHbox() {
        HBox up_down = new HBox();
//    HBox up =new HBox();

        up_down.setPadding(new Insets(10, 15, 10, 10));
        up_down.getChildren().add(PreHbox2("up-icon.png", 50, 50, 1, 10, 10, 75));
        up_down.getChildren().add(PreHbox2("down-icon.png", 50, 50, 1, 10, 10, 10));
//        up_down.getChildren().add(pics("up-icon.png", 50, 50));
//        up_down.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        return up_down;
    }

    public Pane PreHbox2(String pic, int h, int w, int t, int r, int b, int l) {
        HBox up_down = new HBox();
//    HBox up =new HBox();

        up_down.setPadding(new Insets(t, r, b, l));

        up_down.getChildren().add(pics(pic, h, w));
//        up_down.getChildren().add(pics("up-icon.png", 50, 50));
//        up_down.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        return up_down;
    }

    ImageView pics(String img, int h, int w) {
        String imgPath = System.getProperty("user.dir")
                + File.separator + "images"
                + File.separator + img;
        String imageURI = Paths.get(imgPath).toUri().toString();
        ImageView imageView = new ImageView(new Image(imageURI));
        imageView.setFitHeight(h);
        imageView.setFitWidth(w);
        imageView.setPreserveRatio(true);
                if (img.equals("up-icon.png")) {
//        increase n = new increase();
//            if (num.getView().getText().equals("20.1")) {
//                imageView.disableProperty();
//                System.out.println("hh");
//            }
            imageView.setOnMouseClicked((MouseEvent e) -> {
                if (num.getView().getText().equals("120")) {
                    imageView.disableProperty();
                    System.out.println("Pressure cannot go over 55");
                    return;
                }
                num.increase();
                border.setCenter(num.getView());
                num.getView().setStyle("-fx-text-fill: red;");
                num.getView().setFont(Font.font("verdana", FontWeight.MEDIUM, 50));

            });
        } else if (img.equals("down-icon.png")) {
            imageView.setOnMouseClicked((MouseEvent e) -> {
                if (num.getView().getText().equals("50")) {
                    imageView.disableProperty();
                    System.out.println("Pressure cannot go under 30");
                    return;
                }
                num.decrease();
                border.setCenter(num.getView());
                num.getView().setStyle("-fx-text-fill: red;");
                num.getView().setFont(Font.font("verdana", FontWeight.MEDIUM, 50));
            });
        }

        return imageView;

    }

}

