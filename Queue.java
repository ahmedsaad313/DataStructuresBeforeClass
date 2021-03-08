public class Queue <T>{
  int size = 0;
  Node <T> head, tail = null;
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
  public void enqueue(T data){
    if (size > 0){
      tail.next = new Node <T> (data, tail, null);
      tail = tail.next;
    }
    else{
      head = tail = new Node <T> (data, null, null);
    }
    size++;
  }
  public T dequeue(){
    if (size > 0){
      Node <T> temp = head;
      head = head.next;
      head.prev = null;
      return temp.data;
    }
    return null;
  }
  public void printQueue(){
    Node <T> trav = head;
    while(trav!= null){
      System.out.println(trav.toString());
      trav = trav.next;
    }
  }
  public static void main (String[] args){
    Queue <Integer> x = new Queue <Integer>();
    x.enqueue(1);
    x.enqueue(2);
    x.enqueue(3);
    x.enqueue(4);
    x.enqueue(500);
    System.out.println("deque " + x.dequeue());
    x.enqueue(6);
    System.out.println("deque " + x.dequeue());
    x.printQueue();
  }
}