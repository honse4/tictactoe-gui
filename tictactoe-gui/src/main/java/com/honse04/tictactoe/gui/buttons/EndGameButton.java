/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui.buttons;

import javafx.scene.control.Button;

/**
 *
 * @author vasav
 */
public class EndGameButton extends Button{
    
    public EndGameButton(String title) {
        super(title);
        setStyle("-fx-background-color: transparent; -fx-border-color: transparent;-fx-text-fill: white;");
        setOnMouseEntered(e -> setStyle("-fx-background-color: #888888; -fx-text-fill: white;"));
        setOnMouseExited(e -> setStyle("-fx-background-color: transparent; -fx-text-fill: white;"));
    }
    
}
