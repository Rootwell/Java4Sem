package company.statemachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

//Proxy
public class TaskLogger implements Taskable {
    private Task task;
    private File file;

    public TaskLogger(Task task) {
        this.task = task;
        File file = new File("log.txt");
    }

    private void log(String message) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printWriter.println(message + " happens at " + new SimpleDateFormat().toString());
        printWriter.flush();
    }

    public void up(Object... args) {
        task.up(args);
        log("UP");
    }

    public void down(Object... args) {
        task.down(args);
        log("DOWN");
    }

    @Override
    public State getState() {
        log("METHOD: getState");
        return task.getState();
    }

    @Override
    public void setState(State state) {
        task.setState(state);
        log("METHOD: setState");
    }

    @Override
    public int getId() {
        log("METHOD: getId");
        return task.getId();
    }

    @Override
    public void setId(int id) {
        task.setId(id);
        log("METHOD: setId");
    }

    @Override
    public int getDeveloperId() {
        log("METHOD: getDeveloperId");
        return task.getDeveloperId();
    }

    @Override
    public void setDeveloperId(Integer developerId) {
        task.setDeveloperId(developerId);
        log("METHOD: setDeveloperId");
    }

    @Override
    public int getTesterId() {
        log("METHOD: getTesterId");
        return task.getTesterId();
    }

    @Override
    public void setTesterId(int testerId) {
        task.setTesterId(testerId);
        log("METHOD: setTesterId");
    }

    @Override
    public String getText() {
        log("METHOD: getText");
        return task.getText();
    }

    @Override
    public void setText(String text) {
        task.setText(text);
        log("METHOD: setText");
    }

    @Override
    public String getError() {
        log("METHOD: getError");
        return task.getError();
    }

    @Override
    public void setError(String error) {
        task.setError(error);
        log("METHOD: setError");
    }
}
