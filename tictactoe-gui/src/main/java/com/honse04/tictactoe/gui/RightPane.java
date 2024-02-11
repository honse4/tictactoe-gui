/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

/**
 *
 * @author vasav
 */
public class RightPane extends VBox {
    
    public RightPane() {
        setPrefWidth(250);
        setSpacing(5);
        
        // Horizontal Spacing for the label(right)    
        HBox labelContainer = new HBox();
        labelContainer.setSpacing(20);
        HBox labelSpacing = new HBox();
        labelSpacing.setPrefWidth(10);
        
        Label turnLabel = new Label("   Current Turn   ");
        turnLabel.setFont(new Font("Calibri", 30));
        turnLabel.setStyle("-fx-background-color: #333333; -fx-background-radius: 20; -fx-text-fill: white");
        labelContainer.getChildren().addAll(labelSpacing, turnLabel);
        
        // Horizontal Spacing for turn display(right)
        HBox turnContainer = new HBox();
        turnContainer.setSpacing(20);

//        turnContainer.setStyle("-fx-background-color: #2F4F4F;");
        
        HBox turnLabelSpacing = new HBox();
        turnLabelSpacing.setPrefWidth(80);
        
        Label turn = new Label("X");
        turn.setFont(new Font("Arial", 70));
//        turn.setStyle("-fx-background-color: #2F4F4F;");
        turnContainer.getChildren().addAll(turnLabelSpacing, turn);
        
        //Vertical Spacing
        VBox spacing = new VBox();
        spacing.setPrefHeight(200);
        
        getChildren().addAll(spacing,labelContainer, turnContainer);
    }
    
}