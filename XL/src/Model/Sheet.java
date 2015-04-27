package Model;


import expr.Environment;

import java.util.HashMap;
import java.util.Observable;

public class Sheet extends Observable implements Environment {
    private HashMap<String, Slot> map;

    public Sheet() {
        map = new HashMap<>();
    }

    public boolean addSlot(String key, Slot value) {
        return false;
    }

    public boolean removeSlot(String key) {
        return false;
    }

    private boolean checkCircular() {
        return false;
    }

    //Plats för fler metoder

    @Override
    public double value(String name) {
        return 0;
    }
}
