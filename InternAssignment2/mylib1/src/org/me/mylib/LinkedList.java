/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Delmira
 * @since 09-07-2013 This class represents linked list objects its operations
 * include insertion and deletion its a singly linked list
 */
package org.me.mylib;

public class LinkedList {

    private Node head;
    private Node tail;

    //Constructor
    public LinkedList() {
        head = null;
        tail = null;
    }

    //Returns true for empty list
    public boolean isEmpty() {
        return head == null;
    }

    //Insert at beginning
    public void insert(Object data) {
        Node n = new Node(data);
        n.setNextNode(head);
        head = n;
    }

    //Remove first Node
    public Node delete() {
        Node temp = head;
        head = head.getNextNode();
        return temp;
    }

    //Function inserts node at end
    public void addNode(Object obj) {
        Node node = new Node(obj);
        if (this.isEmpty()) {
            this.head = node;
        }
        if (this.tail != null) {
            this.tail.setNextNode(node);
        }
        this.tail = node;
    }

    //Function removes node
    public void removeAt(int index) {
        Node temp = null;
        Node node = this.head;
        int i = 0;
        while (node != null && i++ < index) {
            
                temp = node;
                node = node.getNextNode();
            
             
        }
        if (temp == null) {
            this.head = node.getNextNode();
        } else {
            temp.setNextNode(node.getNextNode());
        }
    }

    public boolean deleteNode(int index) {
        if (isEmpty()) {
            return false;
        }
        Node prevNode = this.head;
        for (int i = 1; i <= index; ++i) {
            Node currentNode = prevNode.getNextNode();
            Node nextNode = currentNode.getNextNode();
            if (i == index) {
                prevNode.setNextNode(nextNode);
            } else {
                prevNode = currentNode;
            }
        }
        return true;
    }

    //Displays the list
    public void displayList() {
        Node currentNode = head;
        System.out.println("The list: ");
        while (currentNode != null) {
            currentNode.displayNode();
            currentNode = currentNode.getNextNode();
        }
        System.out.println("");
    }
    /**
     * public void insertNode(Object newObj, Node n){ Node temp=new
     * Node(newObj,n.getNextNode()); temp.setNextNode(n); }
     */
    /**
     * public void deleteNode(Node n){ if(this.head==n){ head=n.getNextNode();
     * }else{ Node temp=head; while(temp.getNextNode()!=n){
     * temp=temp.getNextNode(); } temp.setNextNode(n.getNextNode()); } }
     */
}
