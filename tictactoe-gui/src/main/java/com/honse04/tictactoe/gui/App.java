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
        
        //Setting the grid
        Grid grid = new Grid();
        grid.init();

        // Right hand side
        RightPane right = new RightPane();
                
        LeftPane left = new LeftPane(grid);
        
        mainPane.setCenter(grid);
        mainPane.setRight(right);
        mainPane.setLeft(left);
        mainPane.setStyle("-fx-background-color: #F5F5F5;");
        
        Scene scene = new Scene(mainPane, 1100, 700);
        
        stage.setTitle("TicTacToe");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}