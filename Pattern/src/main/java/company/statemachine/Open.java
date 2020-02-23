package company.statemachine;

public class Open extends State {
    private Task task;

    @Override
    public Task getTask() {
        return task;
    }

    @Override
    public void setTask(Task task) {
        this.task = task;
    }

    public Open(Task task) {
        super(task);
    }

    @Override
    public void up(Object... args) {
       task.setState(new Assign(task));
       task.setDeveloperId((Integer) args[0]);
    }

    @Override
    public void down(Object... args) {
        task.setState(new BackLog(task));
    }
}
