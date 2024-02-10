package com.honse04.tictactoe.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//      var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        BorderPane mainPane = new BorderPane();
        
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setPrefSize(800, 700);
        
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
                Button button = new Button("Button");
                button.setId(String.format("%d,%d",i,j));
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                
                button.setOnAction((ActionEvent e) -> {
                    System.out.println(button.getId());
                });
                
                grid.add(button,j,i); 
            }
        }
        
        VBox right = new VBox();
        right.setPrefWidth(250);
        right.setSpacing(15);
        
        VBox left = new VBox();
        left.setPrefWidth(250);
        left.setSpacing(15);
        
        Label turn = new Label("Current turn: ");
        turn.setFont(new Font("Arial", 24));
        VBox spacing = new VBox();
        spacing.setPrefHeight(150);
        right.getChildren().addAll(spacing,turn);
        
        mainPane.setCenter(grid);
        mainPane.setRight(right);
        mainPane.setLeft(left);
        
        Scene scene = new Scene(mainPane, 1200, 700);
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}