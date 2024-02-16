/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.honse04.tictactoe.gui;

/**
 *
 * @author vasav
 * @param <T>
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



public class DoublyLinkedList<T> {
    
    public static class DoubleNode<E> extends Node<E> {
        DoubleNode next;
        DoubleNode previous;
    
        public DoubleNode(E val) {
            super(val);
        }
        @Override
        public DoubleNode getNext() {
            return next;
        }
        
        public void setNext(DoubleNode next) {
            this.next = next;
        }
                
        public DoubleNode getPrevious() {
            return this.previous;
        }
              
        void setPrevious(DoubleNode prev) {
            this.previous = prev;
        }
    }
    
    private DoubleNode top = null;
    private DoubleNode bottom = null;
    private int size = 0;
    
    public void setTop(DoubleNode dn) {
        this.top = dn;
    }
    
    public DoubleNode getTop() {
        if(top == null || bottom == null){
            System.out.println("No values in the list");        
            return null;
        }
        return top;
    }
    
    public void getBottom() {
        if(top == null || bottom == null){
            System.out.println("No values in the list");           
            return;
        }
        System.out.println("Bottom is : " + bottom.getValue());
    }
    
    public void getSize() {
        System.out.println("Size is: " + size);
    }
    
    public void push(T val) {
        DoubleNode<T> newNode = new DoubleNode(val);
        
        if(top == null) {
            newNode.setNext(null);
            newNode.setPrevious(null);
            top = newNode;
            bottom = newNode;
        }else {
            top.setPrevious(newNode);
            newNode.setNext(top);
            newNode.setPrevious(null);
            top = newNode;
        }
        size++;
    }
    
    public void pop() {
        if(top!=null) {
            System.out.println("Popped: "+ top.getValue());
            top = top.getNext();
            top.setPrevious(null);
            size--;
            
            return;
        }   
        System.out.println("No values in the list");
    }
    
    public void pushBack(T val) {
        DoubleNode newNode = new DoubleNode(val);
        newNode.setNext(null);
        size++;
        
        if(top == null) {
            top = newNode;
            bottom = newNode;
            return;
        }
        
        bottom.setNext(newNode);
        newNode.setPrevious(bottom);
        bottom = newNode;
           
    }
    
    
    public void popBack() {
        if (bottom == null) {
            System.out.println("No items in list");
            return;
        }
        
        System.out.println("Popped item: " + bottom.getValue());
        bottom = bottom.getPrevious();
        bottom.setNext(null);
        
        size--;
    }
    
    public void getList() {
        DoubleNode<T> newNode = top;
        if(newNode!=null){
            System.out.println("Values in the list:");
            while(newNode!=null){
                
                System.out.println("  " + newNode.getValue());
                newNode = newNode.getNext(); 
            }
        }
    }
    
    
}
