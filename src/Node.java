/**
 *
 * @author DanielPb05
 */
public class Node{
    private String n;
    private Node leftChild;
    private Node rightChild;
 
    public Node(String n){
        this(n, null, null);
    }
    public Node(String n2, Node leftChild, Node rightChild){
        this.n = n2;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
 
    public String getN() {
        return n;
    }
 
    public Node getLeftChild() {
        return leftChild;
    }
 
    public Node getRightChild() {
        return rightChild;
    }
}