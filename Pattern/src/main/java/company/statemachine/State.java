package company.statemachine;

public abstract class State {
    public Task getTask() {
        return task;
    }

    public State(){}

    public void setTask(Task task) {
    }

    private Task task;

    public State(Task task) {
        this.task = task;
    }

    public void up(Object ... args) {

    }

    public void down(Object ... args) {

    }
}
