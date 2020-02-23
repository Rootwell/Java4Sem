package company.statemachine;

import sun.plugin.dom.exception.InvalidStateException;

public class Interpreter {
    private Taskable task;

    public Interpreter(Task task) {
        this.task = task;
    }

    public void interpret(String command) throws NoSuchMethodException {
        if (command.startsWith("create Task")) {
            task = new Task(command.split(" ")[2]);
        }
        if (command.startsWith("up")) {
            if (task == null) {
                throw new InvalidStateException("Task is not initialized");
            } else {
                task.up((Object[]) command.substring(1).split(" "));
            }
        }
        if (command.startsWith("down")) {
            if (task == null) {
                throw new InvalidStateException("Task is not initialized");
            } else {
                task.down((Object[]) command.substring(1).split(" "));
            }
        }

        throw new NoSuchMethodException("AI not recognized command");
    }
}
