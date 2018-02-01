import java.util.LinkedList;

class PuzzleAgent extends SearchAgent {

    void showSolution() {

    }

    void showTree() {

    }

    void insertFringe(Node nd, LinkedList<Node> ll) {
        if (nd.state instanceof Board) {
            Board board = nd.state;
            for (int i = 0; i < ll.size(); i++) {
                Node current = ll.get(i);
                if (current.state instanceof Baord) {
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