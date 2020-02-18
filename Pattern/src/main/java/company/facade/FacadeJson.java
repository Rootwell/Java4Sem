package company.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import company.iterator.Kladr;

import java.io.*;

public class FacadeJson implements Facade<Kladr> {
    private static volatile FacadeJson instance;

    private FacadeJson(){

    }
    @Override
    public Kladr readTree(String filepath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Kladr kladr = objectMapper.readValue(new File(filepath +".json"), Kladr.class);
        return kladr;
    }

    @Override
    public void writeTree(Kladr kladr, String filepath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(kladr);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filepath));
        bufferedWriter.write(jsonString);
    }

    public static FacadeJson getInstance() {
        FacadeJson result = instance;
        if (result != null) {
            return result;
        }
        synchronized (FacadeJson.class) {
            if (instance == null) {
                instance = new FacadeJson();
            }
            return instance;
        }
    }
}
