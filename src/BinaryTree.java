import java.util.Stack;
/**
 *
 * @author DanielPb05
 */

public class BinaryTree {
    private Node root;

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    // Crea un árbol binario
    // Presidencia
    // / \
    // Dir. G Dir. S
    // / \ / \
    // Dir. RH Dir. F Dir. M Dir. S
    // / \
    // Dir. M Ing. Soft
    // / \
    // Analista Programador

    public Node initial() {
        Node N = new Node("Analista");
        Node M = new Node("Programador");
        Node I = new Node("Ingeniero de software", N, M);
        Node H = new Node("Direccion Marketing");
        Node D = new Node("Direccion recursos humanos");
        Node E = new Node("Direccion financiero", H, null);
        Node F = new Node("Direccion de mantenimiento");
        Node G = new Node("Direccion de software", null, I);
        Node B = new Node("Direccion general", D, E);
        Node C = new Node("Direccion de sistemas", F, G);
        Node A = new Node("Presidencia", B, C);
        return A; // root
    }
    // Mostrar raiz
    public void showRoot(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(root.getN());
    }

    // Realización recursiva [recorrido previo al pedido] "raíz izquierda y derecha"
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getN() + " ");
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());
    }

    // Realización recursiva [transversal en orden] "raíz izquierda derecha"
    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild());
        System.out.print(node.getN() + " ");
        inOrder(node.getRightChild());
    }

    // Realización recursiva [recorrido posterior al pedido] "raíz izquierda y
    // derecha"
    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.print(node.getN() + " ");
    }

    // Realización no recursiva [recorrido previo al pedido] "raíz izquierda y
    // derecha"
    
    public void iterativePreOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            // Presione todos los nodos secundarios izquierdos, visítelo antes de presionar
            
            while (node != null) {
                System.out.print(node.getN() + " ");
                stack.push(node);
                node = node.getLeftChild();
            }
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.getRightChild();
            }
        }
    }

    // Realización no recursiva [transversal en orden] "raíz izquierda derecha"
    
    public void iterativeInOrder(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null || stack.size() > 0) {
            // Presione todos los nodos secundarios izquierdos, temporalmente no visite
            
            while (node != null) {
                stack.push(node);
                node = node.getLeftChild();
            }
            if (stack.size() > 0) {
                node = stack.pop();
                System.out.print(node.getN() + " ");
                node = node.getRightChild();
            }
        }
    }

    // Método de doble pila de realización no recursiva [recorrido posterior al
    // pedido] "raíz izquierda y derecha"
    
    public void iterativePostOrder(Node node) {
       
        Stack<Node> stack = new Stack<>();
        Stack<Node> temp = new Stack<>();
        while (node != null || stack.size() > 0) {
            
            
            // Presione todos los nodos secundarios correctos, temporalmente no visite
            while (node != null) {
                temp.push(node);
                stack.push(node);
                node = node.getRightChild();
            }
            if (stack.size() > 0) {
                node = stack.pop();
                node = node.getLeftChild();
            }
        }
        while (temp.size() > 0) {
            node = temp.pop();
            System.out.print(node.getN() + " ");
        }
    }

    public int getTreeDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int left = getTreeDepth(node.getLeftChild());
        int right = getTreeDepth(node.getRightChild());
        return (left < right) ? (right + 1) : (left + 1);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.setRoot(bt.initial());

        System.out.println("Raiz del arbol: ");
        bt.showRoot(bt.getRoot());
        System.out.println();

        System.out.println("preOrder arbol binario: ");
        bt.preOrder(bt.getRoot());
        System.out.println();
        bt.iterativePreOrder(bt.getRoot());
        System.out.println();

        System.out.println("inOrder arbol binario: ");
        bt.inOrder(bt.getRoot());
        System.out.println();
        bt.iterativeInOrder(bt.getRoot());
        System.out.println();

        System.out.println("postOrder arbol binario: ");
        bt.postOrder(bt.getRoot());
        System.out.println();
        bt.iterativePostOrder(bt.getRoot());
        System.out.println();

        System.out.print("El arbol tiene ");
        System.out.print(bt.getTreeDepth(bt.getRoot()));
        System.out.println(" niveles");


    }


}