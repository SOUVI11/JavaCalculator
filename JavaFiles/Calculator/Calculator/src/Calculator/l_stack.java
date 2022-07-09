package Calculator;
public class l_stack{
    // Define Node of LinkedList 
    private class Node { 
        String data; // node data 
        Node nlink;
        // Node link 
    } 
    // top of the stack 
    Node top; 
    // stack class Constructor 
    l_stack()  { 
        this.top = null; 
    } 
   
    // push () operation 
    public void push(String val)  { 
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
    public String peek()  { 
        // check if the stack is empty 
        if (!isEmpty()) { 
            return top.data; 
        } 
        return null;
    } 
   
    // pop () operation 
    public  String pop() { 
        // check if stack is out of elements 
        // set top to point to next node 
        if (!isEmpty()) { 
            String temp = top.data; 
            top = top.nlink; 
            return temp; 
        }
        return null; 

    }
}


