/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

/**
 *
 * @author vasav
 */
public class Card extends VBox{
   
    public Card(){
        setAlignment(Pos.CENTER);
        setSpacing(1);
        setMaxWidth(235);
        setStyle("-fx-background-color: #303030; -fx-padding: 14 0 6 0; -fx-background-radius: 10;");
    }
}
