/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.business;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.rgb;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author hamza
 */
public class Lights {

    int count;
    int count1;
    int count2;
    int count3;
    GridPane grid = new GridPane();

    public Pane LightLayout() {

        StackPane clock = new StackPane();
        clock.setPadding(new Insets(10, 10, 10, 10));
//        clock.getChildren().add(Light());
//        clock.setStyle("-fx-border-color: white;");

        Label title = new Label("Light Control");
        title.setTranslateX(8);
        title.setTranslateY(-8);
        StackPane.setAlignment(title, Pos.TOP_LEFT);

        title.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: white;");
//        clock.setStyle("-fx-border-color: white;"+"-fx-border-radius: 6;");

        title.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        clock.getChildren().addAll(Light(), title);
        return clock;

    }

    public Pane Light() {

        StackPane light = new StackPane();
        light.setPadding(new Insets(20, 17, 20, 17));
        light.getChildren().add(LightGrid());
        light.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");

        return light;

    }

    public Pane LightGrid() {

//        Lit c = new Lit(Color.rgb(51, 51, 0));
//        Rectangle r1 = new Rectangle(40, 20);
//        r1.setFill(Color.rgb(51, 51, 0));
//        CustomButton2 n = new CustomButton2("s",10,10);
        grid.add(LightButton("-", 0), 0, 0);
        grid.add(Lightblocks(rgb(51, 51, 0)), 1, 0);
        grid.add(Lightblocks(rgb(51, 51, 0)), 2, 0);
        grid.add(Lightblocks(rgb(51, 51, 0)), 3, 0);
        grid.add(Lightblocks(rgb(51, 51, 0)), 4, 0);
        grid.add(Lightblocks(rgb(51, 51, 0)), 5, 0);
        grid.add(Lightblocks(rgb(51, 51, 0)), 6, 0);
        grid.add(LightButton("+", 0), 7, 0);

        grid.add(LightButton("-", 1), 0, 1);
        grid.add(Lightblocks(rgb(51, 51, 0)), 1, 1);
        grid.add(Lightblocks(rgb(51, 51, 0)), 2, 1);
        grid.add(Lightblocks(rgb(51, 51, 0)), 3, 1);
        grid.add(Lightblocks(rgb(51, 51, 0)), 4, 1);
        grid.add(Lightblocks(rgb(51, 51, 0)), 5, 1);
        grid.add(Lightblocks(rgb(51, 51, 0)), 6, 1);
        grid.add(LightButton("+", 1), 7, 1);

        grid.add(LightButton("-", 2), 0, 2);
        grid.add(Lightblocks(rgb(51, 51, 0)), 1, 2);
        grid.add(Lightblocks(rgb(51, 51, 0)), 2, 2);
        grid.add(Lightblocks(rgb(51, 51, 0)), 3, 2);
        grid.add(Lightblocks(rgb(51, 51, 0)), 4, 2);
        grid.add(Lightblocks(rgb(51, 51, 0)), 5, 2);
        grid.add(Lightblocks(rgb(51, 51, 0)), 6, 2);
        grid.add(LightButton("+", 2), 7, 2);

//        LightButton(" - ").setOnMouseClicked((MouseEvent e) -> {
//            
//            count++;
//                    if (count == 1) {
////            grid.getChildren().remove(getNodeByRowColumnIndex(0, 0, grid));
//            grid.add(LightButton("-"), 1, 0);
//        }
//            System.out.println(count);
//        });
//        grid.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");
//System.out.println(count);
        return grid;

    }

    public Node getNodeByRowColumnIndex(final int row, final int column, GridPane gridPane) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if (gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
                result = node;
                break;
            }
        }

        return result;
    }

//     class Lit{
//         private Color c;
//
//        public Lit(Color c) {
//            this.c = c;
//        }
    public Pane LightButton(String sign, int p) {

        HBox hbox = new HBox();
        CustomButton2 butn = new CustomButton2(sign, 40, 30);

//        if (p == 0 || p == 1 || p == 2) {
//            System.out.println("sss");
//            count = 0;
//        }
        if (sign.equals("+")) {
            butn.setOnAction((ActionEvent e) -> {

                if (p == 0) {
                    count1++;
                    count = count1;

                }
                if (p == 1) {
                    count2++;
                    count = count2;
                }
                if (p == 2) {
                    count3++;
                    count = count3;
                }

                if (count >= 7) {
                    count = 6;
//                    return;
                }

//                count++;
//                System.out.println(count);
//                count++;
                switch (count) {
                    case 1:
                        grid.add(Lightblocks(rgb(102, 103, 0)), 1, p);
                        return;
                    case 2:
                        grid.add(Lightblocks(rgb(153, 154, 0)), 2, p);
                        return;
                    case 3:
                        grid.add(Lightblocks(rgb(204, 205, 0)), 3, p);
                        return;
                    case 4:
                        grid.add(Lightblocks(rgb(255, 255, 0)), 4, p);
                        return;
                    case 5:
                        grid.add(Lightblocks(rgb(255, 255, 146)), 5, p);
                        return;
                    case 6:
                        grid.add(Lightblocks(rgb(255, 255, 201)), 6, p);
                        return;
                    default:
                        System.out.println(count);
                        return;
                }
            });
        }

        if (sign.equals("-")) {
            butn.setOnAction((ActionEvent e) -> {

                if (p == 0) {

                    count1--;

                    if (count1 <= -1) {
                        count1 = 0;
//                    return;
                    }
                    if (count1 >= 7) {
                        count1 = 5;
//                    return;
                    }
                    count = count1;
                }
                if (p == 1) {
                    count2--;

                    if (count2 <= -1) {
                        count2 = 0;
//                    return;
                    }
                    if (count2 >= 7) {
                        count2 = 5;
//                    return;
                    }
                    count = count2;
                }
                if (p == 2) {
                    count3--;
                    if (count3 <= -1) {
                        count3 = 0;
//                    return;
                    }
                    if (count3 >= 7) {
                        count3 = 5;
//                    return;
                    }
                    count = count3;
                }

                if (count <= -1) {
                    count = 0;
//                    return;
                }
                if (count >= 7) {
                    count = 5;
//                    return;
                }

//                count--;
//                System.out.println(count);

                switch (count) {
                    case 0:
                        grid.add(Lightblocks(rgb(51, 51, 0)), 1, p);
                        return;
                    case 1:
                        grid.add(Lightblocks(rgb(51, 51, 0)), 2, p);
                        return;
                    case 2:
                        grid.add(Lightblocks(rgb(51, 51, 0)), 3, p);
                        return;
                    case 3:
                        grid.add(Lightblocks(rgb(51, 51, 0)), 4, p);
                        return;
                    case 4:
                        grid.add(Lightblocks(rgb(51, 51, 0)), 5, p);
                        return;
                    case 5:
                        grid.add(Lightblocks(rgb(51, 51, 0)), 6, p);
                        return;
                    default:
                        System.out.println(count);
                        return;
                }

            });
        }
        butn.setStyle("-fx-background-color:rgb(102,67,29);" + "-fx-text-fill: white;" + "-fx-border-color: white;" + "-fx-border-radius: 3;" + "-fx-border-width: 1.5;");
        butn.setFont(Font.font("verdana", FontWeight.BOLD, 12));
        hbox.setPadding(new Insets(3, 2, 3, 2));
        hbox.getChildren().add(butn);

//        hbox.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");
        return hbox;

    }

//        @Override
//        public String toString() {
//            return "" + c ;
//        }
    public Pane Lightblocks(Color c) {

        HBox hbox = new HBox();

        hbox.setPadding(new Insets(1, 1, 1, 1));

        hbox.getChildren().add(Lightblock(c));

//        hbox.setStyle("-fx-border-color: white;" + "-fx-border-radius: 6;" + "-fx-border-width: 1.7;");
        return hbox;

    }

    public Pane Lightblock(Color c) {
        HBox hbox = new HBox();
        Rectangle c1 = new Rectangle(47, 20);
        c1.setFill(c);
//rgb(51, 51, 0)
        hbox.setPadding(new Insets(7, 0, 0, 0));
        hbox.getChildren().add(c1);

//        hbox.setStyle("-fx-background-color: black;");
        return hbox;

    }
//     }

    public class CustomButton2 extends Button {

        public CustomButton2(String label, double w, double h) {
            super(label);
            this.setMinWidth(w);
            this.setMinHeight(h);
            this.setMaxWidth(w);
            this.setMaxHeight(h);
            this.setPrefWidth(w);
            this.setPrefHeight(h);
//            this.label=label;
        }

    }

}

