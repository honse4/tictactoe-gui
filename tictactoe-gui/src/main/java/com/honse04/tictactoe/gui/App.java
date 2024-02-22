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
        //Setting the grid
        Grid grid = new Grid(leftPane);
        grid.init();

        // Right hand side
        RightPane right = new RightPane();
                
        LeftPane left = new LeftPane(grid);
        leftPane.setCenter(left);
        
        mainPane.setCenter(grid);
        mainPane.setRight(right);
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