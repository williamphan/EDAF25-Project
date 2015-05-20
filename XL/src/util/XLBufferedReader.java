package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import Model.Slot;
import Model.SlotFactory;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String fileName) throws FileNotFoundException {
        super(new FileReader(fileName));
    }

    public void load(Map<String, Slot> map) {
        try {
            while (ready()) {
                String string = readLine();
                String[] token = string.split("=");
                String name = token[0];
                String content = token[1];
                map.put(name, SlotFactory.create(content));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
