import java.lang.*;

class ExpToCnf {

    private static String OR = " v ";
    private static String AND = " ^ ";
    private static String NOT = "~";
    private static String IMP = " => ";
    private static String IFF = " <-> ";
    private static String OPEN = "(";
    private static String CLOSE = ")";

    private static String[] OPS = [OR, AND, IMP, IFF]

    
    String iffElimination(String p, String q) {
        return OPEN + p + AND + q + CLOSE + OR + OPEN + NOT + p + AND + NOT + q + CLOSE;
    }

    String impElimination(String p, String q) {
        return NOT + p + OR + q;
    }

    String convertToCNF(String s) {
        int opIndex = evaluateSentence(s);
        String op = "";
        String p;
        String q;

        if (opIndex != -1) {
            p = s.substring(0, opIndex-1);
            s = s.substring(opIndex);
            for (String item : OPS) {
                if s.startsWith(item) {
                    op = item;
                    break;
                }
            }
            q = s.substring(op.length());
        }
        
        if (op == "" && isVariable(s)) { // is variable
            return s;

        } else if (op == AND) { // and clause

        } else if (op == OR) { // or clause

        } else if (op == "" && isNegation(s)) { // is negated
            if (s.length == 2) {  // is variable
                return s;
            } else if ()

        } else if (op == IMP) { // implication
            return impElimination(p, q);
        } else if (op == IFF) { // iff 
            return iffElimination(p, q);
        } 

    }

    boolean isVariable(String s) {
        return s.length() == 1 && Character.isLetter(s.charAt(0));
    }

    boolean isNegation(String s) {
        return s.startsWith(NOT);
    }

    int evaluateSentence(String s) {
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth ++;
            } else if (s.charAt(i) == ')') {
                depth --;
            } else if (s.charAt(i) == ' ' && depth == 0) {
                return i;
            }
        }

        return -1;
    }

}

