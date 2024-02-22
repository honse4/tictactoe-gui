/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
        card.setSpacing(3);        
        
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
    
    public void disable(boolean disable) {
        Card card = (Card) getChildren().get(0);
        for(Node nd : card.getChildren()) {
            //System.out.println(nd.getClass().getSimpleName());
            if (nd instanceof Button){
                Button btn = (Button) nd;
                btn.setDisable(disable);
            }
        }
    }
}
