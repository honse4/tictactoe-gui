package com.honse04.tictactoe.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
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
        
        VBox left = new VBox();
        left.setPrefWidth(250);
        left.setSpacing(15);
        
        mainPane.setCenter(grid);
        mainPane.setRight(right);
        mainPane.setLeft(left);
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