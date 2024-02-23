package com.honse04.tictactoe.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) {

        BorderPane mainPane = new BorderPane();
        BorderPane leftPane = new BorderPane();
        BorderPane rightPane = new BorderPane();

        Grid grid = new Grid(leftPane, rightPane);
        grid.init();

        RightPane right = new RightPane();
        rightPane.setCenter(right);
        
        LeftPane left = new LeftPane(grid);
        leftPane.setCenter(left);
        
        mainPane.setCenter(grid);
        mainPane.setRight(rightPane);
        mainPane.setLeft(leftPane);
        mainPane.setStyle("-fx-background-color: #2a2a2a;");
        
        Scene scene = new Scene(mainPane, 1100, 700);
        
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}