import java.util.Arrays;
import java.util.List;

public enum RulesSet {
    DEFAULT,
    CITY,
    CORAL,
    CUSTOMA,
    CUSTOMB,
    CUSTOMC;

    // Possible values to make a dead cell alive
    public static List<Integer> getDeadRules(RulesSet ruleSet) {
        switch (ruleSet) {
            case CITY: return Arrays.asList(4, 5, 6, 7, 8);
            case CORAL: return Arrays.asList(3);
            case CUSTOMA: return Arrays.asList(1, 2, 7, 8);
            case CUSTOMB: return Arrays.asList(4, 5);
            case CUSTOMC: return Arrays.asList(2, 6);
        }
        return Arrays.asList(3); // DEFAULT
    }

    // Possible values to keep an alive cell alive
    public static List<Integer> getAliveRules(RulesSet ruleSet) {
        switch (ruleSet) {
            case CITY: return Arrays.asList(2, 3, 4, 5);
            case CORAL: return Arrays.asList(4, 5, 6, 7, 8);
            case CUSTOMA: return Arrays.asList(3, 4, 5, 6);
            case CUSTOMB: return Arrays.asList(2, 3, 6);
            case CUSTOMC: return Arrays.asList(4);
        }
        return Arrays.asList(2, 3); // DEFAULT
    }
}
