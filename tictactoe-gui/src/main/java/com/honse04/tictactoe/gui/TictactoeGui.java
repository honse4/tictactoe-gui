/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.honse04.tictactoe.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author vasav
 */
public class TictactoeGui {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("TicTacToe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        JPanel panel = new JPanel(new FlowLayout());
        panel.setLayout(new GridLayout(3, 3));
        
        for(int i = 0; i<9; i++) {
            JButton button = new JButton("hi");
            button.setPreferredSize(new Dimension(200, 200));
            panel.add(button);
        }
        panel.setSize(600,600);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy=0;
        
        frame.add(panel, gbc);
        
//        JButton button = new JButton("floom");
//        button.setPreferredSize(new Dimension(100, 100));
//        frame.add(button);

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
