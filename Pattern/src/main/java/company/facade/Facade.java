package company.facade;

import java.io.IOException;

public interface Facade<T> {
    T readTree(String filpath) throws IOException;
    void writeTree(T tree, String filepath) throws IOException;
}
