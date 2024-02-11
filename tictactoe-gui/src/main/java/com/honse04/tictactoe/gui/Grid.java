/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author vasav
 */
public class Grid extends GridPane {
    
    public Grid() {
        setGridLinesVisible(true);
        setPrefSize(800, 700);
        setHgap(5);
        setVgap(5);
        
        for (int i = 0; i < 3; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(33.3);
            getRowConstraints().add(rowConstraints);

            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(33.3); 
            getColumnConstraints().add(columnConstraints);
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button("Button");
                button.setStyle("-fx-background-color: black; -fx-font-size: 20px; -fx-font-family: Calibri; -fx-text-fill: white;");
                button.setId(String.format("%d,%d",i,j));
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                
                button.setOnAction((ActionEvent e) -> {
                    System.out.println(button.getId());
                });
                
                add(button,j,i); 
            }
        }

    }
}
