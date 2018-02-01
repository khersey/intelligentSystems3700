import java.lang.Math;

class Board extends ObjectPlus {
    private int state[];
    /////////////////
    // [ 0, 1, 2,  //
    //   3, 4, 5,  //
    //   6, 7, 8 ] //
    /////////////////
    private int position;
    private char lastMove;
    private PuzzleProblem problem;
    private int hVal;
    private int gVal;
    private int fVal;
    
    // describes the state of 8-puzzle problem. 
    // It maintains the 8-puzzle board configuration, the
    // move that leads to this state, and the heuristic function 
    // value of the state relative to a goal. As Board is an
    // object whose configuration needs to be shown, it should be 
    // implemented as a subclass of ObjectPlus.
    // Board should include methods that test whether a state is the
    // goal, test whether a move is legal, determine the new state
    // from a legal move, and determine the heuristic function value of a state

    Board(int state[], char lastMove, PuzzleProblem problem, int oldGVal) {
        this.state = state;
        this.lastMove = lastMove;
        this.problem = problem;
        this.gVal = oldGVal + 1;
        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) {
                this.position = i;
                break;
            }
        }
        calculateHVal();
    }

    void show() {

    }

    void showPart(int index) {

    }

    int getFVal() {
        return fVal;
    }

    boolean isGoalState() {
        return state == problem.getGoal();
    }

    Board makeMove(char move) {
        int newState[] = this.state;

        int swap = -1;
        switch(move) {
            case 'L':
                swap = position - 1;
                break;
            case 'R':
                swap = position + 1;
                break;
            case 'U':
                swap = position - 3;
                break;
            case 'D':
                swap = position + 3;
                break;
        }

        int temp = newState[position];
        newState[position] = newState[swap];
        newState[swap] = temp;



        return new Board(newState, move, this.problem);
    }

    boolean isMoveValid(char move) {
        if (move == this.lastMove) return false;

        switch(move) {
            case 'L':
                if (position == 0 || position == 3 || position == 6) {
                    return false;
                } else {
                    return true;
                }
            case 'R':
                if (position == 2 || position == 5 || position == 8) {
                    return false;
                } else {
                    return true;
                }
            case 'U':
                if (position > 2) {
                    return false;
                } else {
                    return true;
                }
            case 'D':
                if (position < 6) {
                    return false;
                } else {
                    return true;
                }
        }

        return false;
    }

    private calculateHVal() {
        int goalState[] = this.problem.goalState.state;

        int val = 0;
        int x1 = 0;
        int y1 = 0;
        int j = 0;
        int x2 = 0;
        int y2 = 0;
        int h = 0;

        for (int i = 0; i < 9; i++) {
            val = this.state[i];
            if (val != 0) {
                while (goalState[j] != val && j < 9) {
                    j += 1;
                } 
                x1 = i % 3;
                x2 = j % 3;
                y1 = i / 3;
                y2 = j / 3;
                h += Math.abs(x1 - x2) + Math.abs(y1 - y2);
            }
        }

        this.hVal = h;
        this.fVal = hVal + gVal;
    }

}