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
public class Humidity {
    
        private HNumbers num;
    private BorderPane border = new BorderPane();
    
    
        public class HNumbers extends Label {

        Text view;

        public HNumbers(Text view) {
            this.view = view;
        }

        public void increase() {
//            this.view.getText();
            int dnum = Integer.parseInt(this.view.getText());
            dnum = dnum + 1;
            this.view.setText("" + dnum);
//            System.out.println(this.view);
        }

        public void decrease() {
//            this.view.getText();
            int dnum = Integer.parseInt(this.view.getText());
            dnum = dnum - 1;
            this.view.setText("" + dnum);
//            System.out.println(this.view);
        }

        public Text getView() {
            return this.view;
        }

    }

//    private static double round(double value, int precision) {
//        int scale = (int) Math.pow(10, precision);
//        return (double) Math.round(value * scale) / scale;
//    }
    
    public Pane HumidityLayout() {

        StackPane clock = new StackPane();
        clock.setPadding(new Insets(10, 12, 10, 12));
//        clock.getChildren().add(Humidity());
//        clock.setStyle("-fx-border-color: white;");

        Label title = new Label("Humidity Control");
        title.setTranslateX(8);
        title.setTranslateY(-8);
        StackPane.setAlignment(title, Pos.TOP_LEFT);

        title.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: white;");
//        clock.setStyle("-fx-border-color: white;"+"-fx-border-radius: 6;");

        title.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        clock.getChildren().addAll(Humid(), title);
        return clock;

    }

    public Pane Humid() {

        StackPane humidity = new StackPane();
        humidity.setPadding(new Insets(10, 15, 10, 9));
        humidity.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");
        
        humidity.getChildren().add(HumBoreder());

        return humidity;

    }
    
    
    public Pane HumBoreder() {

        border = new BorderPane();
        num = new HNumbers(new Text("40"));
        Label per = new Label("%");
        
        border.setPadding(new Insets(5, 5, 5, 5));
        per.setPadding(new Insets(27, 5, 5, 15));
        num.setPadding(new Insets(5, 5, 5,23));

//        border.getChildren().add(imageView);
        border.setBottom(HumHbox());
        border.setCenter(num.getView());
        border.setLeft(HumHbox2("humidity-icon.png", 70, 70,10,10,10,10));
        border.setRight(per);
//        border.setCenter(title);

//        num.setStyle("-fx-text-fill: red;");
//        num.setFont(Font.font("verdana", FontWeight.MEDIUM, 50));

        num.getView().setFill(Color.RED);
        num.getView().setFont(Font.font("verdana", FontWeight.MEDIUM, 50));
        
        per.setStyle("-fx-text-fill: white;");
        per.setFont(Font.font("verdana", FontWeight.LIGHT, 30));
//        border.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");
        return border;
    }

    public Pane HumHbox() {
        HBox up_down = new HBox();
//    HBox up =new HBox();

        up_down.setPadding(new Insets(10, 10, 10, 10));

        up_down.getChildren().add(HumHbox2("up-icon.png",50,50,1,10,10,75));
        up_down.getChildren().add(HumHbox2("down-icon.png",50,50,1,10,10,10));
//        up_down.getChildren().add(pics("up-icon.png", 50, 50));
//        up_down.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        return up_down;
    }

    public Pane HumHbox2(String pic, int h, int w, int t, int r,int b,int l) {
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
                if (num.getView().getText().equals("55")) {
                    imageView.disableProperty();
                    System.out.println("Humidity cannot go over 55");
                    return;
                }
                num.increase();
                border.setCenter(num.getView());
                num.getView().setStyle("-fx-text-fill: red;");
                num.getView().setFont(Font.font("verdana", FontWeight.MEDIUM, 50));

            });
        } else if (img.equals("down-icon.png")) {
            imageView.setOnMouseClicked((MouseEvent e) -> {
                if (num.getView().getText().equals("30")) {
                    imageView.disableProperty();
                    System.out.println("Humidity cannot go under 30");
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
