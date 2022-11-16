/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.business;

import java.io.File;
import java.nio.file.Paths;
import javafx.event.EventHandler;
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
public class Temperatures {

    private TNumbers num;
    private BorderPane border = new BorderPane();

    public Pane TemperatureLayout() {

        StackPane clock = new StackPane();
        clock.setPadding(new Insets(10, 12, 10, 10));
//        clock.getChildren().add(Temperature());
//        clock.setStyle("-fx-border-color: white;");

        Label title = new Label("Temperature Control");
        title.setTranslateX(8);
        title.setTranslateY(-8);
        StackPane.setAlignment(title, Pos.TOP_LEFT);

        title.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: white;");
//        clock.setStyle("-fx-border-color: white;"+"-fx-border-radius: 6;");

        title.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        clock.getChildren().addAll(Temperature(), title);

        return clock;

    }

    public Pane Temperature() {

        StackPane Temperature = new StackPane();
        Temperature.setPadding(new Insets(10, 15, 10, 9));
        Temperature.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        Temperature.getChildren().add(TempBoreder());

        return Temperature;

    }

    public Pane TempBoreder() {

//        BorderPane border = new BorderPane();
//        Button b = new Button();
        num = new TNumbers(new Text("20.0"));
//        System.out.println(num);
        Label cel = new Label("°C");
//        b.setOnMouseClicked((MouseEvent e) -> {
//            num.setImage(new Label("go"));
//            border.setCenter(num.getView());
//            num.getView().setStyle("-fx-text-fill: red;");
//            num.getView().setFont(Font.font("verdana", FontWeight.MEDIUM, 50));
////            System.out.println(num.getView());
//        });
//        num = new Label("6");

        border.setPadding(new Insets(5, 5, 5, 5));
        cel.setPadding(new Insets(27, 5, 5, 5));

//        border.getChildren().add(imageView);
        border.setBottom(TempHbox());
        border.setCenter(num.getView());
        border.setLeft(TempHbox2("thermometer-icon.png", 70, 70, 10, 10, 10, 10));
        border.setRight(cel);
//        border.setCenter(title);

        num.getView().setFill(Color.RED);
        num.getView().setFont(Font.font("verdana", FontWeight.MEDIUM, 50));

        cel.setStyle("-fx-text-fill: white;");
//        cel.setFill(Color.WHITE);
        cel.setFont(Font.font("verdana", FontWeight.LIGHT, 30));
//        border.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");
        return border;
    }

    public class TNumbers extends Label {

        Text view;

        public TNumbers(Text view) {
            this.view = view;
        }

        public void increase() {
//            this.view.getText();
            double dnum = Double.parseDouble(this.view.getText());
            dnum = dnum + 0.1;
            this.view.setText("" + round(dnum, 1));
//            System.out.println(this.view);
        }

        public void decrease() {
//            this.view.getText();
            double dnum = Double.parseDouble(this.view.getText());
            dnum = dnum - 0.1;
            this.view.setText("" + round(dnum, 1));
//            System.out.println(this.view);
        }

        public Text getView() {
            return this.view;
        }

    }

    private static double round(double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

    public Pane TempHbox() {
        HBox up_down = new HBox();
//        Button button = new Button();
//        button.setPrefSize(80, 80);
//        button.setGraphic(pics("up-icon.png",50,50));

        up_down.setPadding(new Insets(10, 10, 10, 10));
        up_down.getChildren().add(TempHbox2("up-icon.png", 50, 50, 1, 10, 10, 75));
//        up_down.getChildren().add(button);
        up_down.getChildren().add(TempHbox2("down-icon.png", 50, 50, 1, 10, 10, 10));
//        up_down.getChildren().add(pics("up-icon.png", 50, 50));
//        up_down.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        return up_down;
    }

    public Pane TempHbox2(String pic, int h, int w, int t, int r, int b, int l) {
        HBox up_down = new HBox();
//        pic p = new pic();
//    HBox up =new HBox();
        up_down.setPadding(new Insets(t, r, b, l));

        up_down.getChildren().add(pics(pic, h, w));
//        up_down.getChildren().add(pics("up-icon.png", 50, 50));
//        up_down.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        return up_down;
    }

//    class pic{
//        String s;
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
            if (num.getView().getText().equals("20.1")) {
                imageView.disableProperty();
                System.out.println("hh");
            }
            imageView.setOnMouseClicked((MouseEvent e) -> {
                if (num.getView().getText().equals("27.5")) {
                    imageView.disableProperty();
                    System.out.println("Temperature cannot go over 27.5");
                    return;
                }
                num.increase();
                border.setCenter(num.getView());
                num.getView().setStyle("-fx-text-fill: red;");
                num.getView().setFont(Font.font("verdana", FontWeight.MEDIUM, 50));

            });
        } else if (img.equals("down-icon.png")) {
            imageView.setOnMouseClicked((MouseEvent e) -> {
                if (num.getView().getText().equals("10.0")) {
                    imageView.disableProperty();
                    System.out.println("Temperature cannot go under 10.0");
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

//        public String getS() {
//            return this.s;
//        }
//    }
    class increase implements EventHandler<MouseEvent> {
//        String s;
//        String d;

        @Override
        public void handle(MouseEvent event) {
            System.out.println("increase");
        }
//        public increase(String s) {
//            this.s=s;
//        }
//        
//        @Override
//        public void handle(MouseEvent event) {
////           System.out.println("increase");
//            double num = Double.parseDouble(this.s);
//            String d;
////            double d;
//            num=num +0.1;
//            d = ""+num;
//            this.d=d;
//            System.out.println(this.d);
//        }
//
//        public String getD() {
//            return this.d;
//        }

    }

    class decrease implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            System.out.println("decrease");
        }

    }
}

