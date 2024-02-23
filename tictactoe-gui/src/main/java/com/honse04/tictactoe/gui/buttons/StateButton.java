/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui.buttons;


import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

/**
 *
 * @author vasav
 */
public class StateButton extends Button{
    
    public StateButton(String title) {
        super(title);
        
        setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 16;");
        setOnMouseEntered(e -> setStyle("-fx-background-color: #888888; -fx-text-fill: white; -fx-font-size: 16;"));
        setOnMouseExited(e -> setStyle("-fx-background-color: transparent; -fx-text-fill: white; -fx-font-size: 16;"));
        
        ScaleTransition pressed =  new ScaleTransition(Duration.seconds(0.05), this);
        pressed.setToX(0.9);
        pressed.setToY(0.9);
        
        ScaleTransition released = new ScaleTransition(Duration.seconds(0.05), this);
        released.setToX(1);
        released.setToY(1);
        
        setOnMousePressed(e -> pressed.play());
        setOnMouseReleased(e -> released.play());
    }
}
