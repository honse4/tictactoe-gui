/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

import com.honse04.tictactoe.gui.buttons.StateButton;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
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
        card.setSpacing(10);     
        
         HBox bottom = new HBox();
        bottom.setSpacing(3);
        bottom.setAlignment(Pos.CENTER);
        
        StateButton resetButton = new StateButton("Reset");
        resetButton.setOnAction((ActionEvent e) -> {
            mainGrid.reset();
        });
        
        StateButton undoButton = new StateButton("Undo");
        undoButton.setOnAction((ActionEvent e) -> {
            mainGrid.undo();
        });
        
        StateButton redoButton = new StateButton("Redo");
        redoButton.setOnAction((ActionEvent e) -> {
            mainGrid.redo();
        });
        
        bottom.getChildren().addAll(undoButton, redoButton);      
        card.getChildren().addAll(resetButton, bottom);
        
        getChildren().add(card);
        
    }
    
    public void disable(boolean disable) {
        Card card = (Card) getChildren().get(0);
        StateButton btn = (StateButton) card.getChildren().get(0);
        btn.setDisable(disable);
        
        HBox box = (HBox) card.getChildren().get(1);
        
        for(Node nd : box.getChildren()) {
            //System.out.println(nd.getClass().getSimpleName());
            if (nd instanceof StateButton){
                StateButton btns = (StateButton) nd;
                btns.setDisable(disable);
            }
        }
    }
}
