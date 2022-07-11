package Calculator;
public class l_stack {
    class node {
        String data;
        node next;

        node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public node top = null;
    public node bottom = null;
    

    void push(String data) {
        if (bottom == null) {
            bottom = new node(data);
            top = bottom;
        } else {
            node temp = new node(data);
            top.next = temp;
            top = temp;
        }
    }

    String pop() {
        if (top == bottom) {
            String temp=top.data;
            bottom=null;
            top = null;
            return temp;
        } else {
            String temp=top.data;
            node current = bottom;
            
            for (;;) {
                if (current.next == top)
                    break;
                current = current.next;
            }
            top = current;
            top.next = null;
            return temp;
        }

    }
    //peek
    String peek() {
        return top.data;
    }
    //isempty
    boolean isEmpty() {
        if (top == null)
            return true;
        else
            return false;
    }
}