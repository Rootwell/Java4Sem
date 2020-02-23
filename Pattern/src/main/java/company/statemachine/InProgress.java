package company.statemachine;

public class InProgress extends State {
    private Task task;
    public InProgress(Task task) {
        super(task);
    }

    @Override
    public void up(Object... args) {
        task.setState(new Resolved(task));
    }

    @Override
    public void down(Object... args) {
    }
}
