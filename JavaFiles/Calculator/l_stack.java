package Calculator;
public class l_stack {
    // Define Node of LinkedList 
    private class Node { 
        int data; // node data 
        Node nlink;
        // Node link 
    } 
    // top of the stack 
    Node top; 
    // stack class Constructor 
    Linked_stack()  { 
        this.top = null; 
    } 
   
    // push () operation 
    public void push(int val)  { 
        // create a new node 
        Node temp = new Node(); 
   
        // checks if the stack is full 
        // if (temp == null) { 
        //     return; 
        // } 
   
        // assign val to node 
        temp.data = val; 
   
        // set top of the stack to node link
        temp.nlink = top; 
   
        // update top 
        top = temp; 
    }   
      // isEmpty () operation
    public boolean isEmpty()  { 
        return top == null; 
    } 
 
  // peek () operation 
    public int peek()  { 
        // check if the stack is empty 
        if (!isEmpty()) { 
            return top.data; 
        } 
        else { 
            return -1; 
        } 
    } 
   
    // pop () operation 
    public void pop() { 
        // check if stack is out of elements 
        if (top == null) { 

            return; 
        } 
        // set top to point to next node 
        top = (top).nlink; 
    }

}