import java.util.*;
public class BinarySearchTree <T extends Comparable<T>>{
  private int nodeCount = 0;
  private Node root = null;
  private class Node{
    T data;
    Node left, right;
    public Node(Node left, Node right, T data){
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }
  public void add(T data){
    Node x = new Node(null, null, data);
    Node check = root;
    while(check != null){
      if (x.data.compareTo(check.data)>0){
        if(check.right == null){
          check.right = x;
          break;
        }
        check = check.right;
      }
      else{
        if(check.left == null){
          check.left = x;
          break;
        }
        check = check.left;
      }
    }
   nodeCount++;
  }
  public Node remove(T data){
    return remove(data, root);
  }
  public Node remove(T data, Node node){
    if (node == null){return null;}
    else if (data.compareTo(node.data) > 0){
      node.right = remove(data, node.right);
    }
    else if (data.compareTo(node.data) < 0){
      node.left = remove(data, node.left);
    }
    else{
      if (node.right == null){
        node = node.left;
      }
      else if(node.left == null){
        node = node.right;
      }
      else{
        //2 kids present
      }
    }
    return node;
  }
  public static void main(String[] args){
    BinarySearchTree <Integer> x = new BinarySearchTree <>();
    x.add(6);
    x.add(7);
  }
  
}