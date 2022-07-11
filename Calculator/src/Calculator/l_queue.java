package Calculator;
public class l_queue{
    class node {
        int data;
        node next;

        node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public node rear = null;
    public node front = null;
    public int size = 0;

    void enqueue(int el) {
        node temp = new node(el);
        if (front == null) {
            rear = temp;
            front = temp;
        } else {
            rear.next = temp;
            rear = temp;
        }
        size++;
    }

    void print() {
        node current = front;
        System.out.println("[front]");
        while (current != null) {
            System.out.print(current.data + "\n");
            current = current.next;
        }
        System.out.println("[rear]");
        System.out.println();
    }

    int dequeue() {


        if (front == null) {
            return -1;
        }
        int temp=front.data;
        if (rear == front) {
            front = null;
            rear = null;
        } else {
            front=front.next;
        }
        size--;
        return temp;

    }
    //isEmpty
    boolean isEmpty() {
        return front == null;
    }
}
