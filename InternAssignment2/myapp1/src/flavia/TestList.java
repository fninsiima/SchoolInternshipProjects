/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Delmira
 * @since 09-07-2013
 * this class tests the operations of the linked list class
 */
package flavia;
import org.me.mylib.LinkedList;
import org.me.mylib.Node;
public class TestList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList myList=new LinkedList();
        myList.addNode(4444);
        myList.addNode("yeah");
        myList.insert("the beginning");
        myList.addNode(0000);
        
        myList.displayList();
        
        myList.removeAt(2);
        myList.displayList();
       
        while(!myList.isEmpty()) {
		    Node deletedNode = myList.delete();
		    System.out.print("deleted: ");
		    deletedNode.displayNode();
		    
	    }
        System.out.println("");
	myList.displayList();
    }
}
