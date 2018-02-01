import java.util.LinkedList;

class PuzzleAgent extends SearchAgent {

    public static void main(String[] args) {
        
    }

    void showSolution() {
        for (int i = 0; i < solution.size(); i++) {
            Node n = (Node) solution.get(i);
            n.show();
        }
    }

    void showTree() {
        printSubTree(tree.get(0));
    }

    void printSubTree(Node current) {
        if (current.state instanceof Board) {
            Board board = current.state;
            board.treePrint();
        }

        for (Node childNode: current.child) {
            printSubTree(childNode);
        }
    }

    void insertFringe(Node nd, LinkedList<Node> ll) {
        if (nd.state instanceof Board) {
            Board board = nd.state;
            for (int i = 0; i < ll.size(); i++) {
                Node current = ll.get(i);
                if (current.state instanceof Board) {
                    Board currentBoard = current.state;
                    if (board.getFVal() < currentBoard.getFVal()) {
                        ll.add(i, nd);
                        break;
                    }
                }
            }
        }
    }

}