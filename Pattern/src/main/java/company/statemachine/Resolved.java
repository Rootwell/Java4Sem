package company.statemachine;

public class Resolved extends State{
    Task task;

    public Resolved(Task task) {
        super(task);
    }

    @Override
    public void up(Object... args) {
        task.setState(new Testing(task));
    }

    @Override
    public void down(Object... args) {
    }
}
