/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1.data;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafxapplication1.business.Gas;
import javafxapplication1.business.Lights;
import javafxapplication1.business.Humidity;
import javafxapplication1.business.Pressure;
import javafxapplication1.business.Temperatures;
import javafxapplication1.business.Clock;
import javafxapplication1.business.Timer;

/**
 *
 * @author hamza
 */
public class DAOImplementation implements DAO{
    
    public Pane getLayer1(){
    HBox vBox = new HBox(5);
        Clock clock = new Clock();
        Timer timer = new Timer();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.getChildren().add(clock.ClockLayout());
        vBox.getChildren().add(timer.TimerLayout());
        return vBox;
    }
    public Pane getLayer2(){
    HBox hBox = new HBox(5);
        Temperatures temp = new Temperatures();
        Humidity humid = new Humidity();
        Pressure pre = new Pressure();
        hBox.setPadding(new Insets(5, 5, 5, 5));
        hBox.getChildren().add(temp.TemperatureLayout());
        hBox.getChildren().add(humid.HumidityLayout());
        hBox.getChildren().add(pre.PressureLayout());
        HBox.setMargin(hBox, new Insets(50, 50, 50, 50));
        return hBox;
    }
    public Pane getLayer3(){
        HBox vBox = new HBox(5);
        Gas gas = new Gas();
        Lights light = new Lights();
        vBox.setPadding(new Insets(5, 5, 5, 5));
        vBox.getChildren().add(light.LightLayout());
        vBox.getChildren().add(gas.GassLayout());
        return vBox;
    }
}
