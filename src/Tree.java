import static java.lang.Math.max;

public class Tree {

    Node root;

    private Node buildTree(Node curNode, int value) {
        if(curNode == null) {
            return new Node(value);
        }
        if(curNode.value > value) {
            curNode.left = buildTree(curNode.left, value);
        } else if (curNode.value < value) {
            curNode.right = buildTree(curNode.right, value);
        } else {
            return curNode;
        }
        return curNode;
    }

    public void addNode(int value) {
        this.root = buildTree(this.root, value);
    }

    protected int numLevels(Node curNode){
        if(curNode == null) {
            return 0;
        } else {
            return max(numLevels(curNode.left), numLevels(curNode.right)) + 1;
        }

    }

    private void printSpaces(int numSpaces) {
        for(int i = 0; i < numSpaces; i++) {
            System.out.print(" ");
        }
    }
    public int COUNT = 10;
    protected void printTree(Node curNode, int spaces) {
        if(curNode == null){
            return;
        }
        spaces += COUNT;
        printTree(curNode.right, spaces);
        printSpaces(spaces);
        System.out.println(curNode.value);
        printTree(curNode.left, spaces);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(4);
        tree.addNode(5);
        tree.addNode(3);
        tree.addNode(8);
        tree.addNode(7);
        System.out.println("Num levels " + tree.numLevels(tree.root));
        tree.printTree(tree.root, 0);
    }
}
