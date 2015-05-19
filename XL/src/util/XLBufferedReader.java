package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import Model.Slot;
import Model.SlotFactory;

//TODO move to another package
//Kanske till menu, men kanske model
public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String fileName) throws FileNotFoundException {
        super(new FileReader(fileName));
    }

    // TODO Change Object to something appropriate
    //F�rmodligen Slot
    public void load(Map<String, Slot> map) {
        try {
            while (ready()) {
                String string = readLine();
//                int i = string.indexOf('=');
                String[] token = string.split("=");
                String name = token[0];
                String content = token[1];
                map.put(name, SlotFactory.create(content));
                // TODO
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
