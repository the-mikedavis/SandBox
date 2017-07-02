import java.util.HashSet;

public class Collatz {
    private Long root = new Node(1L);
    private Set<Node> numbers = new HashSet<Node>();
    private Queue<Node> queue = new ArrayDeque<Node>();    

    public static void main (String[] args) {

    }

    public Set<Node> solve (int limit) {
        //Do this by queue.
        //Do not solve by recursion
        for (int i = 0; i < limit; i++) {

        }
    }

    private class Node {
        private Long number;
        private Node left, right;

        public Node (Long number) {
            number = number;
            left = left;
            right = right;
        }

        public getNumber () { return number; }

        public getLeft () { return left; }

        public getRight () { return right; }

        public setLeft (Node node) { 
            Node previous = left;
            left = node;
            return previous;
        }

        public setRight (Node node) {
            Node previous = right;
            right = node;
            return previous;
        }
    }
}
