/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 *
 * @author vasav
 */
public class LeftPane extends VBox{
    private Grid mainGrid;
    
    public LeftPane(Grid grid) {
        setAlignment(Pos.CENTER);
        this.mainGrid = grid;
        setPrefWidth(250);
        
        VBox card = new Card();
        
        Button resetButton = new Button("Reset");
        resetButton.setOnAction((ActionEvent e) -> {
            mainGrid.reset();
        });
        
        Button undoButton = new Button("Undo");
        undoButton.setOnAction((ActionEvent e) -> {
            mainGrid.undo();
        });
        
        Button redoButton = new Button("Redo");
        redoButton.setOnAction((ActionEvent e) -> {
            mainGrid.redo();
        });
        
        card.getChildren().addAll(resetButton, undoButton, redoButton);
        
        getChildren().add(card);
        
    }
}
