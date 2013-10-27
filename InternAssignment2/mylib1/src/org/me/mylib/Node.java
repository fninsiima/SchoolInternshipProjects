/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Delmira
 * @since 09-07-2013 This class creates a node of a linked list the node has
 * data and a link to its neighbor
 */
package org.me.mylib;

public class Node {

    private Object data;
    private Node nextNode;

    //Constructor
    public Node(Object data) {
        this(data, null);
    }

    //Another constructor
    public Node(Object data, Node nextNode) {
        this.data = data;
        this.nextNode = nextNode;
    }

    /**
     * Getters
     */
    public Object getObj() {
        return this.data;
    }

    public Node getNextNode() {
        return this.nextNode;
    }

    /**
     * Setters
     */
    public void setObj(Object i) {
        this.data = i;
    }

    public void setNextNode(Node n) {
        this.nextNode = n;
    }

    //Displays a node
    public void displayNode() {
        System.out.println("{" + this.data + "}");
    }
}
