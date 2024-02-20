/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui.data;

/**
 *
 * @author vasav
 * @param <E>
 */
public class Node<E> {
        private E value;
        private Node next;
    
        public Node(E val) {
            this.value = val;
        }
        
        public E getValue() {
            return this.value;
        }
        
        public Node getNext() {
            return this.next;
        }
        
        public void setValue(E val) {
            this.value = val;
        }
        
        public void setNext(Node next){
            this.next = next;
        }
}
