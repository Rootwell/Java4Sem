package company.facade;

import company.iterator.Kladr;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FacadeXML implements Facade<Kladr> {
    private static volatile FacadeXML instance;

    private FacadeXML() {
    }

    @Override
    public Kladr readTree(String filepath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filepath);
        XMLDecoder decoder = new XMLDecoder(fileInputStream);
        Kladr kladr = (Kladr) decoder.readObject();
        decoder.close();
        fileInputStream.close();
        return kladr;
    }

    @Override
    public void writeTree(Kladr kladr, String filepath) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filepath);
        XMLEncoder encoder = new XMLEncoder(fileOutputStream);
        encoder.writeObject(kladr);
        encoder.close();
        fileOutputStream.close();
    }

    public static FacadeXML getInstance() {
        FacadeXML result = instance;
        if (result != null) {
            return result;
        }
        synchronized (FacadeXML.class) {
            if (instance == null) {
                instance = new FacadeXML();
            }
            return instance;
        }
    }
}
