<<<<<<< HEAD
//the error is that you assumed the arrays inside the hashmap are always in order 
import java.util.*;
public class Pqueue <T extends Comparable<T>>{
  ArrayList<T> heap = new ArrayList<>();
  HashMap<T, ArrayList<Integer>> map = new HashMap(); 
  public void add(T data){
    heap.add(data);
    if (!(map.containsKey(data))){
      map.put(data, new ArrayList<Integer>());
      map.get(data).add(heap.size()-1);
    }
    else{
      map.get(data).add(heap.size()-1);
    }
    swim(heap.size()-1);
  }
  public T remove(T data){
    int indexInHeapRemoved = map.get(data).get(0);
    swap(heap.size()-1, indexInHeapRemoved);
    if (map.get(heap.get(heap.size()-1)).size() == 1){
      map.remove(heap.get(heap.size()-1));
    }
    else{
      map.get(heap.get(heap.size()-1)).remove(map.get(heap.get(heap.size()-1)).size()-1);
    }
    heap.remove(heap.size()-1);
    sink(indexInHeapRemoved);
    swim(indexInHeapRemoved);
  }
  private void swim(int k){
=======
import java.util.*;
public class Pqueue <T extends Comparable<T>>{
  int heapCapacity = 0;
  ArrayList<T> heap = new ArrayList<>();
  public void add(T data){
    heap.add(data);
    swim(heap.size()-1);
  }
  public void swim(int k){
>>>>>>> 35734aa9ef5d6f96eab94fec24c72c15f228ed32
    int parent;
    while(k>0){
      if (k % 2 == 0){
        parent = (k-2)/2;
      }
      else{
        parent = (k-1)/2;
      }
      if (heap.get(k).compareTo(heap.get(parent)) < 0){
          swap(k,parent);
          k=parent;
      }
      else{
        break;
      }
    }
  }
  public void poll(){
    swap(0,heap.size()-1);
<<<<<<< HEAD
    if (map.get(heap.get(heap.size()-1)).size() == 1){
      map.remove(heap.get(heap.size()-1));
    }
    else{
      map.get(heap.get(heap.size()-1)).remove(map.get(heap.get(heap.size()-1)).size()-1);
    }
    heap.remove(heap.size()-1);
    sink(0);
  }
  private void sink(int x){
=======
    heap.remove(heap.size()-1);
    sink(0);
  }
  public void sink(int x){
>>>>>>> 35734aa9ef5d6f96eab94fec24c72c15f228ed32
    while (2 * x + 1 < heap.size() - 1){
      int smaller =  2*x+1;
      if (2*x+2 <= heap.size() - 1){
        if (heap.get(2*x+2).compareTo(heap.get(2*x+1)) < 0){
          smaller = 2*x+2;
        }
      }
      if (heap.get(smaller).compareTo(heap.get(x)) < 0){
        swap(smaller, x);  
        x = smaller;    
      }
      else{
        break;
      }
    }
  }
<<<<<<< HEAD
  private void swap(int x, int y){
    T xVal = heap.get(x);
    T yVal = heap.get(y);
    map.get(xVal).remove(map.get(xVal).indexOf(x));
    map.get(xVal).add(y);
    map.get(yVal).remove(map.get(yVal).indexOf(y));
    map.get(yVal).add(x);
=======
  public void swap(int x, int y){
>>>>>>> 35734aa9ef5d6f96eab94fec24c72c15f228ed32
    T temp = heap.get(x);
    heap.set(x, heap.get(y));
    heap.set(y, temp);
  }
<<<<<<< HEAD
  private void printPqueue(){
    System.out.println(heap);
  }
  private void printMap(){
    System.out.println(Collections.singletonList(map)); 
  }
=======
  public void printPqueue(){
    System.out.println(heap);
  }
>>>>>>> 35734aa9ef5d6f96eab94fec24c72c15f228ed32
  public static void main(String[] args){
    Pqueue<Integer> x = new Pqueue<>();
    x.add(5);
    x.add(6);
    x.add(3);
<<<<<<< HEAD
    x.add(6);
    x.poll();
    x.add(2);
    x.add(0);
    x.add(2);
    x.add(4);;
    x.remove(2);
    x.printMap();
    x.printPqueue();
  }
}
=======
    x.add(2);
    x.add(0);
    x.add(1);
    x.add(4);
    x.poll();
    x.printPqueue();
  }
}
>>>>>>> 35734aa9ef5d6f96eab94fec24c72c15f228ed32
