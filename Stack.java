public class Stack <T>{
    int size = 0;
    Node <T> head;
    private class Node <T>{
        T data;
        Node <T> prev,next;
        public Node(T data, Node <T> prev, Node <T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        @Override public String toString(){
            return data.toString();
        } 
    }
    public T pop(){
        if (size >= 1){
            Node <T> temp = head;
            head = head.prev;
            head.next = null;
            size--;
            return temp.data;
        }
        return null;
    }
    public void push(T elem){
        Node <T> x = new Node <T> (elem, null, null);
        if (size == 0){
            head = x; 
        }
        else{
            head.next = x;
            x.prev = head;
            head = x;
        }
        size++;
    }
    public void printStack(){
        Node <T> trav = head;
        while(trav != null){
            System.out.println(trav.toString());
            trav = trav.prev;
        }
    }
    public static void main (String[] args) {
        Stack <Integer> x = new Stack <Integer>();
        x.push(3);
        x.push(1);
        x.push(5);
        x.push(4);
        x.push(9);
<<<<<<< HEAD
=======
        x.push(2);
>>>>>>> 35734aa9ef5d6f96eab94fec24c72c15f228ed32
        x.pop();
        x.push(7);
        x.printStack();
    }
}