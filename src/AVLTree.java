public class AVLTree {

    private Node root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int value) {
        System.out.println("Insertando nodo: " + value);
        root = insertRec(root, value);
    }

    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node padre) {
        if (padre == null) {
            return 0;
        }
        int leftHeight = getHeightRec(padre.getLeft());
        int rightHeight = getHeightRec(padre.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

     public int getBalance (Node node){
    if (node == null) {
      return 0;
    }
    return node.getHeight();
  }

    private int height(Node node) {
        return (node == null) ? 0 : node.getHeight();
    }

    private Node insertRec(Node node, int value) {
    if (node == null) {
      Node newNode = new Node (value);
      newNode.setHeight(1);
      System.out.println("Nodo insertado =" + newNode.getValue() +"Balance al insertar =" + getBalance(newNode));
      return newNode;

    }

    if (value < node.getValue()) {
        node.setLeft(insertRec(node.getLeft(), value));
    } else if (value > node.getValue()) {
        node.setRight(insertRec(node.getRight(), value));
    } else {
        return node; 
    }

    
    node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    System.out.println("(\t Valance =" + node.getHeight());

    int balance = getBalance(node);
    System.out.println("t Valance =" + balance);

    // Rotaciones
    // Caso izquierda - izquierda
    if (balance > 1 && value < node.getLeft().getValue()) {
        System.out.println("Rotacion derecha");
    }

    // Caso derecha - derecha
    if (balance < -1 && value > node.getRight().getValue()) {
        System.out.println("Rotacion izquierda");
    }

    // Caso izquierda - derecha
    if (balance > 1 && value > node.getLeft().getValue()) {
      System.out.println("Cambio");
        System.out.println("Rotacion izquierda");
    }

    // Caso derecha - izquierda
    if (balance < -1 && value < node.getRight().getValue()) {
        System.out.println("Cambio");
        System.out.println("Rotacion derecha");
    }

    return node;
}

 

  
}
