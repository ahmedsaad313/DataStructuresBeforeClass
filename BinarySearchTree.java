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
    if (check == null){
      root = x;
    }
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
      //move right
      node.right = remove(data, node.right);
    }
    //move left
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
        Node trav = node.right;
        while(trav.left != null){
          trav = trav.left;
        }
        T copiedData = trav.data;
        remove(trav.data, root);
        node.data = copiedData;
      }
    }
    return node;
  }

  public void invertTree(){
    invertNode(root);
  }

  public void invertNode(Node node){
    if (node == null){
      return;
    }
    Node temp = node.right;
    node.right = node.left;
    node.left = temp;
    invertNode(node.left);
    invertNode(node.right);
  }

  public void printTree(){
    if (root == null){
      return;
    }
    ArrayList<Node> dataList = new ArrayList<Node>();
    dataList.add(root);
    printhelper(dataList, root);
  }

  public void printhelper(ArrayList<Node> dataList, Node current){
    if (current == null){
      dataList.remove(0);
      if (dataList.size() > 0){
        printhelper(dataList, dataList.get(0));
      }
      return;
    }
    System.out.println(dataList.get(0).data);
    dataList.add(current.left);
    dataList.add(current.right);
    dataList.remove(0);
    printhelper(dataList, dataList.get(0));
  }

  public void printFancy(){
    int height = getHeight(root);
    int array[Math.pow(2,height)-1];
    for(int i = 0; i < height; i++){
      for (int j = 0; j < Math.pow(2,height)-1; j++){
        
      }
    }
  }

  public int getHeight(Node node){
    if (node == null){
      return 0;
    }
    int rightSide = getHeight(node.right);
    int leftSide = getHeight(node.left);
    if (getHeight(node.right) >= getHeight(node.left)){
      return 1 + rightSide;
    }
    else{
      return 1 + leftSide;
    }
  }

  public static void main(String[] args){
    BinarySearchTree <Integer> x = new BinarySearchTree <>();
    x.add(10);
    x.add(7);
    x.add(8);
    x.add(12);
    x.add(13);
    x.add(6);
    x.add(8);
    x.add(11);
    x.remove(10);
    x.remove(12);
    x.remove(6); 
    x.invertTree();
    x.printTree();
   // x.printFancy(); 
   //comment
  }
  
}