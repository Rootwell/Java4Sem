package company.statemachine;

public interface Taskable {
    void up(Object ... args);
    void down(Object ... args);
    State getState();
    void setState(State state);
    int getId();
    void setId(int id);
    int getDeveloperId();
    void setDeveloperId(Integer developerId);
    int getTesterId();
    void setTesterId(int testerId);
    String getText();
    void setText(String text);
    String getError();
    void setError(String error);
}
