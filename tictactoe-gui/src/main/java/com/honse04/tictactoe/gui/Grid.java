/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

import com.honse04.tictactoe.gui.data.DoublyLinkedList;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author vasav
 */
public class Grid extends StackPane {
    private final ArrayList<ArrayList<String>> gameBoard;
    private Button clicked = null;
    private int turnNumber = 1;
    private boolean isGameOver = false;
    private GridPane grid;
    private final DoublyLinkedList<ArrayList<ArrayList<String>>> gameData;
    
    public Grid() {  
        this.grid = new GridPane();
        this.gameBoard = new ArrayList<>();
        this.gameData = new DoublyLinkedList();
        
        ArrayList<ArrayList<String>> addBase = new ArrayList<>();
        
        for(int i = 0; i<3; i++) {
            ArrayList<String> temp = new ArrayList<>(List.of("","",""));
            this.gameBoard.add(temp);
            
            ArrayList<String> temp2 = new ArrayList<>(List.of("","",""));
            addBase.add(temp2);
        }      
        gameData.push(addBase);
    }
    
    public void init() {
        grid.setGridLinesVisible(true);
        grid.setPrefSize(800, 700);
        grid.setHgap(7);
        grid.setVgap(7);
        
        isGameOver = false;
        
        for (int i = 0; i < 3; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(33.3);
            grid.getRowConstraints().add(rowConstraints);

            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(33.3); 
            grid.getColumnConstraints().add(columnConstraints);
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button("");
                button.setStyle("-fx-background-color:  #2a2a2a; -fx-font-size: 60px; -fx-font-family: Calibri; -fx-text-fill: white;");
                button.setId(String.format("%d,%d",i,j));
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                
                button.setOnAction((ActionEvent e) -> {
                    //System.out.println(button.getId());
                    clicked = button;
                    if(!isGameOver) {
                       gameLogic(button.getId()); 
                    }                  
                });
                
                GridPane.setRowIndex(button, i);
                GridPane.setColumnIndex(button, j);
                grid.add(button,j,i); 
            }
        }
        getChildren().add(grid);
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
        
        ArrayList<ArrayList<String>> copy = new ArrayList<>();
        for(ArrayList<String> ar: gameBoard) {
            ArrayList<String> newRow = new ArrayList<>(ar);
            copy.add(newRow);
        }
        gameData.push(copy);
        
        if(turnNumber >= 10){
            gameOver();
            return;
        }
        
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
                isGameOver = true;
            }
        }
        
        for(int i = 0; i<3;i++){
            if(!gameBoard.get(0).get(i).equalsIgnoreCase("") &&
                    gameBoard.get(0).get(i).equalsIgnoreCase(gameBoard.get(1).get(i)) &&
                    gameBoard.get(1).get(i).equalsIgnoreCase(gameBoard.get(2).get(i)) &&
                    gameBoard.get(0).get(i).equalsIgnoreCase(gameBoard.get(2).get(i))) {
                isGameOver = true;
            }
            
        }
        
        if(!gameBoard.get(0).get(0).equalsIgnoreCase("") &&
                gameBoard.get(0).get(0).equalsIgnoreCase(gameBoard.get(1).get(1))&&
                gameBoard.get(1).get(1).equalsIgnoreCase(gameBoard.get(2).get(2))&&
                gameBoard.get(0).get(0).equalsIgnoreCase(gameBoard.get(2).get(2))) {
            isGameOver = true;
        }
        
        if(!gameBoard.get(0).get(2).equalsIgnoreCase("") &&
                gameBoard.get(0).get(2).equalsIgnoreCase(gameBoard.get(1).get(1))&&
                gameBoard.get(1).get(1).equalsIgnoreCase(gameBoard.get(2).get(0))&&
                gameBoard.get(0).get(2).equalsIgnoreCase(gameBoard.get(2).get(0))) {
            isGameOver = true;
        }
        
        if(isGameOver){
            gameOver();
        }       
    }
    
    public void gameOver() {
        BoxBlur blur = new BoxBlur(5,5,1);
        grid.setEffect(blur);
        
        VBox alert = new VBox();
        alert.setMaxSize(275, 175);
        alert.setStyle("-fx-background-color: #777777;-fx-background-radius: 10px;");
        alert.setAlignment(Pos.CENTER);
        alert.setOpacity(0);
         
        Button reset = new Button("Play again");
        reset.setOnAction((ActionEvent e) -> {
            reset();
            getChildren().remove(alert);
            grid.setEffect(null);
        });
        
         
        // changes to the blurring area, and scaling/opacity for the animatio
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(alert.opacityProperty(),0)),
                new KeyFrame(Duration.seconds(1), new KeyValue(alert.opacityProperty(), 1))
        );
        
        alert.getChildren().add(reset);
        getChildren().add(alert);
        timeline.play();
    }
    
    public void reset() {
        this.grid = new GridPane();
        init();
            
        for(int i = 0; i<3; i++) {
            for(int j =0; j<3; j++) {
               gameBoard.get(i).set(j, "");
            }
        }
        turnNumber = 1;
        RightPane.changeText("X");
        gameData.clear();
    }
    
    public void undo() {
        
        if(gameData.getSize() == 1) {
            return;
        }
        
        DoublyLinkedList.DoubleNode dn = gameData.getTop().getNext();
        
        gameData.getList();
        gameData.setTop(dn);
        turnNumber--;
        
        ArrayList<ArrayList<String>> previous  = (ArrayList<ArrayList<String>>) dn.getValue();
     
        for(Node nd: grid.getChildren()) {
            if (nd instanceof Button) {
              Integer row = GridPane.getRowIndex(nd);
              Integer column = GridPane.getColumnIndex(nd);

              Button button = (Button) nd;
              button.setText(previous.get(row).get(column));
             gameBoard.get(row).set(column, previous.get(row).get(column));
            }                    
        }
        gameData.setSize(-1);
        String toPut = this.turnNumber%2 != 0 ? "X" : "O";
        RightPane.changeText(toPut);
             
    }
    
    public void redo() {
        
        DoublyLinkedList.DoubleNode dn = gameData.getTop().getPrevious();
        
        if(dn == null) {
            return;
        }
        
        gameData.setTop(dn);
        gameData.getList();
        ArrayList<ArrayList<String>> prev = (ArrayList<ArrayList<String>>) dn.getValue();
        
        for(Node nd: grid.getChildren()) {
            if(nd instanceof Button) {
                Button btn = (Button) nd;
                
                Integer row = GridPane.getRowIndex(nd);
                Integer col = GridPane.getColumnIndex(nd);
                
                btn.setText(prev.get(row).get(col));
                gameBoard.get(row).set(col, prev.get(row).get(col));
            }
        }
        turnNumber++;
        gameData.setSize(1);
        String toPut = this.turnNumber%2 != 0 ? "X" : "O";
        RightPane.changeText(toPut);
        
    }
}
