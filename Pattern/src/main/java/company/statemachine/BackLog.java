package company.statemachine;

public class BackLog extends State {
    Task task;

    @Override
    public Task getTask() {
        return super.getTask();
    }

    @Override
    public void setTask(Task task) {
        super.setTask(task);
    }

    public BackLog(Task task) {
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
