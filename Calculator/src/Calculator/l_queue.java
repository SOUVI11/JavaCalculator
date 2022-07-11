package Calculator;

public class l_queue{
    class node {
        String data;
        node next;

        node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node rear = null;
    public static node front = null;
    public static int size = 0;

    void enqueue(String el) {
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
    String dequeue() {
        if (front == null) {
            return null;
        }
       String temp=front.data;
        if (rear == front) {
            front = null;
            rear = null;
        } else {
            front=front.next;
        }
        size--;
        return temp;
    } 
    //isempty
    boolean isEmpty(){
        if (front==null&rear==null){
            return true;
        }
        return false;

    }




}
