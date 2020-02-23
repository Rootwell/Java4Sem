package company.statemachine;

public class GeneratorId {
    private static int id = 0;

    public static int generate() {
        return id++;
    }
}
