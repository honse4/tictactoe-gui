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
           
        Label turnLabel = new Label("   Current Turn   ");
        turnLabel.setFont(new Font("Calibri", 30));
        turnLabel.setStyle("-fx-text-fill: black;"
                + " -fx-background-color: #F3F8FF; -fx-font-family: Calibri;"
                + " -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, black, 10, 0.5, 1, 1);" );
        
        
        Label turn = new Label("X");
        RightPane.MainLabel = turn;
        turn.setMinWidth(190);
        turn.setAlignment(Pos.CENTER);
        turn.setFont(new Font("Arial", 70));
        turn.setStyle("-fx-text-fill: black; -fx-background-color: #F3F8FF; -fx-background-radius: 10px;"
                + " -fx-effect: dropshadow(three-pass-box, black, 10, 0.5, 1, 1);");
        
        //Vertical Spacing
        VBox spacing = new VBox();
        spacing.setPrefHeight(250);
        
        getChildren().addAll(turnLabel, turn);
    }
    
    public static void changeText(String text) {
        MainLabel.setText(text);
    }
    
}
