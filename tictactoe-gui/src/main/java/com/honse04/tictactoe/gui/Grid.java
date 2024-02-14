/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

import java.util.ArrayList;
import java.util.List;
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
    private final ArrayList<ArrayList<String>> gameBoard;
    private Button clicked = null;
    private int turnNumber = 1;
    private boolean gameOver = false;
    
    public Grid() {  
        this.gameBoard = new ArrayList<>();
        for(int i = 0; i<3; i++) {
            ArrayList<String> temp = new ArrayList<>(List.of("","",""));
            this.gameBoard.add(temp);
        }      
    }
    
    public void init() {
        setGridLinesVisible(true);
        setPrefSize(800, 700);
        setHgap(7);
        setVgap(7);
        
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
                Button button = new Button("");
                button.setStyle("-fx-background-color:  black; -fx-font-size: 60px; -fx-font-family: Calibri; -fx-text-fill: white;");
                button.setId(String.format("%d,%d",i,j));
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                
                button.setOnAction((ActionEvent e) -> {
                    //System.out.println(button.getId());
                    clicked = button;
                    if(!gameOver) {
                       gameLogic(button.getId()); 
                    }                  
                });
                
                add(button,j,i); 
            }
        }
    }
    
    public void gameLogic(String id) {
        System.out.println(id);
        String[] coords = id.split(",");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        
        if(!gameBoard.get(x).get(y).equals("")) {     
            return;
        }
        
        String toPut = this.turnNumber%2 != 0 ? "X" : "O";
        RightPane.changeText(toPut.equalsIgnoreCase("X") ? "O": "X");
        gameBoard.get(x).set(y, toPut);
        clicked.setText(toPut);
        turnNumber++;
        
        if(turnNumber>=5){
            checkState();
        }
  
    }
    
    public void checkState(){
        
        for(ArrayList<String> row: gameBoard) {
            if(!row.get(0).equalsIgnoreCase("") &&
               row.get(0).equalsIgnoreCase(row.get(1)) && row.get(1).equalsIgnoreCase(row.get(2)) &&
                    row.get(0).equalsIgnoreCase(row.get(2))){
                System.out.println(row.get(0));
                gameOver = true;
            }
        }
        
        //need to check the columns
        for(int i = 0; i<3;i++){
            if(!gameBoard.get(0).get(i).equalsIgnoreCase("") &&
                    gameBoard.get(0).get(i).equalsIgnoreCase(gameBoard.get(1).get(i)) &&
                    gameBoard.get(1).get(i).equalsIgnoreCase(gameBoard.get(2).get(i)) &&
                    gameBoard.get(0).get(i).equalsIgnoreCase(gameBoard.get(2).get(i))) {
                gameOver = true;
            }
            
        }
        
        if(!gameBoard.get(0).get(0).equalsIgnoreCase("") &&
                gameBoard.get(0).get(0).equalsIgnoreCase(gameBoard.get(1).get(1))&&
                gameBoard.get(1).get(1).equalsIgnoreCase(gameBoard.get(2).get(2))&&
                gameBoard.get(0).get(0).equalsIgnoreCase(gameBoard.get(2).get(2))) {
            gameOver = true;
        }
        
        if(!gameBoard.get(0).get(2).equalsIgnoreCase("") &&
                gameBoard.get(0).get(2).equalsIgnoreCase(gameBoard.get(1).get(1))&&
                gameBoard.get(1).get(1).equalsIgnoreCase(gameBoard.get(2).get(0))&&
                gameBoard.get(0).get(2).equalsIgnoreCase(gameBoard.get(2).get(0))) {
            gameOver = true;
        }
        
    }
}
