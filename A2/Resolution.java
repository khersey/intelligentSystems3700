import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

static String OR = " v ";
static String NOT = "~";

class Resolution {
    public static void main(String[] args) {
        

    }


}

class Literal {
    // public cuz I aint writin' no setters or getters
    public String value;
    public boolean isNegative;

    public Literal (String value, boolean isNegative) {
        this.value = value;
        this.isNegative = isNegative;
    }
}

class Clause {
    static String OR = " v ";
    static String NOT = "~";
    // public cuz I aint writin' no setters or getters
    public ArrayList<Literal> literals;

    public Clause () {
        literals = new ArrayList<Literal>();
    }

    public Clause (ArrayList<Literal> literals) {
        this.literals = literals;
    }

    public Clause (String s) {
        literals = new ArrayList<Literal>(5);
        parseSentence(s);
    }

    protected parseSentence(String s) {
        
    }

    // split on OR
    private LinkedList<String> getLiteralList(String clause) {
        LinkedList<String> list = new LinkedList<String>();

        while(clause.contains(OR)) {
            int pos = clause.indexOf(OR);
            String temp = clause.substring(0,pos);
            clause = clause.substring(pos + AND.length());
            list.add(temp);
        }
        list.add(clause);

        return list;
    }
}

class ClauseBase {
    // public cuz I aint writin' no setters or getters
    public ArrayList<Clause> clauses;

    public ClauseBase () {
        clauses = new ArrayList<Clause>();
    }

    public ClauseBase (ArrayList<Clause> clauses) {
        this.clauses = clauses;
    }

    public mergeWith(ClauseBase other) {
        this.clauses.addAll(other.clauses);
    }

    public loadClauseFile(String fileName) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for(String line; (line = br.readLine()) != null; ) {
                String exp = new String(line);
                String cnf = converter.reduce(converter.convert(OPEN + line + CLOSE));
                cnfList.add(cnf);
                System.out.println("Exp: " + exp);
                System.out.println("CNF: " + cnf);
            }
            // line is not visible here.
        } catch (IOException e) {
            System.out.println("ERROR: something went wrong opening file: " + fileName);
            e.printStackTrace();
        }
    }

}