package company.statemachine;

public class Testing extends State {
    Task task;
    public Testing(Task task) {
        super(task);
    }

    @Override
    public void up(Object... args) {
        task.setState(new Closed(task));
    }

    @Override
    public void down(Object... args) {
        task.setState(new Assign(task));
        task.setError((String) args[0]);
    }
}
