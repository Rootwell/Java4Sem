package company.statemachine;

public class Task implements Taskable{
    private int id;
    private Integer developerId;
    private int testerId;
    private String text;
    private String error;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    private State state;

    public Task(String text) {
        this.id = GeneratorId.generate();
        this.text = text;
        this.state = new Draft(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Integer developerId) {
        this.developerId = developerId;
    }

    public int getTesterId() {
        return testerId;
    }

    public void setTesterId(int testerId) {
        this.testerId = testerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void up(Object... args) {
        state.up(args);
    }

    public void down(Object... args) {
        state.down(args);
    }
//Prototype
    @Override
    protected Object clone() {
        Task task = new Task(text);
        task.setError(error);
        task.setDeveloperId(developerId);
        task.setTesterId(testerId);
        task.setId(id);
        try {
            State newInstance = state.getClass().newInstance();
            newInstance.setTask(task);
            task.setState(newInstance);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return task;
    }
}
