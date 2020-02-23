package company.statemachine;

public class Draft extends State {
    private Task task;
    @Override
    public Task getTask() {
        return task;
    }

    @Override
    public void setTask(Task task) {
        this.task = task;
    }

    public Draft(Task task) {
        super(task);
    }

    @Override
    public void up(Object... args) {
        task.setState(new Open(task));
    }

    @Override
    public void down(Object... args) {}
}
