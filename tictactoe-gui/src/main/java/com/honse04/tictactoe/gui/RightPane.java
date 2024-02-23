/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author vasav
 */
public class RightPane extends VBox {
    static Label MainLabel = new Label();
    
    public RightPane() {
        setPrefWidth(250);
        setSpacing(2);
        setAlignment(Pos.CENTER);
        
        VBox card = new Card();
           
        Label turnLabel = new Label("Current Turn");
        turnLabel.setAlignment(Pos.CENTER);
        turnLabel.setFont(new Font("Arial", 24));
        turnLabel.setStyle("-fx-text-fill: #E0E0E0;");
               
        Label turn = new Label("X");
        RightPane.MainLabel = turn;
        turn.setAlignment(Pos.CENTER);
        turn.setFont(new Font("Arial", 60));
        turn.setStyle("-fx-text-fill: #E0E0E0;");
        
        card.getChildren().addAll(turnLabel, turn);
        
        getChildren().addAll(card);
    }
    
    public static void changeText(String text) {
        MainLabel.setText(text);
    }
    
}
