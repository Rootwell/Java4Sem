package company.statemachine;

public class Assign extends State {
    private Task task;
    public Assign(Task task) {
        this.task = task;
    }

    @Override
    public Task getTask() {
        return super.getTask();
    }

    @Override
    public void setTask(Task task) {
        super.setTask(task);
    }

    @Override
    public void up(Object ... args) {
        task.setState(new InProgress(task));
        task.setError("No Error");
    }

    @Override
    public void down(Object... args){
        task.setState(new Open(task));
        task.setDeveloperId(null);
    }
}
