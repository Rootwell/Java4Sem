package company.statemachine;

public class Closed extends State{
    public Closed(Task task) {
        super(task);
    }

    @Override
    public void up(Object... args) {
        super.up(args);
    }

    @Override
    public void down(Object... args) {
        super.down(args);
    }
}
