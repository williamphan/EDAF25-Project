package Model;

import expr.Environment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

import util.XLException;

public class Sheet extends Observable implements Environment {
    private HashMap<String, Slot> map;
    private String currentError = "", errorKey = "";

    public Sheet() {
        map = new HashMap<String, Slot>();
    }

    public void addSlot(String key, String text) {
        Slot value = SlotFactory.create(text);
        if (checkCircular(key, value)) {
            errorKey = key;
            currentError += "check " + key;
        } else {
            if (key.equals(errorKey)) {
                currentError = "";
            }
            map.put(key, value);
        }
        setChanged();
        notifyObservers();
    }

    public boolean removeSlot(String key) {
        if (map.containsKey(key)) {
            map.remove(key);
            if (key.equals(errorKey)) {
                currentError = "";
            }
            setChanged();
            notifyObservers();
            return true;
        } else {
            return false;
        }
    }

    private boolean checkCircular(String key, Slot value) {
        Slot currentSlot = map.get(key);

        map.put(key, new FakeSlot());

        try {
            value.value(this);
        } catch (XLException e) {
            currentError = "Bad input, ";
            return true;
        } catch (NullPointerException e) {
            currentError = "Bad input, ";
            return true;
        }

        map.put(key, currentSlot);
        return false;
    }

    public String print(String key) {
        Slot slot = map.get(key);
        if (slot == null) {
            return "";
        }
        try {
            return slot.print(this);
        } catch (XLException e) {
            return "ERROR    ";
        }
    }

    public String printExpr(String key) {
        Slot slot = map.get(key);
        if (slot == null) {
            return "";
        }
        try {
            return slot.toString();
        } catch (XLException e) {
            return "ERROR";
        }
    }


    public double value(String name) {
        if (map.get(name) == null) {
            throw new XLException(name + " does not exist in the sheet.");
        }
        return map.get(name).value(this);

    }

    public void clear() {
        map = new HashMap<String, Slot>();
        setChanged();
        notifyObservers();
    }

    public String getError() {
        return currentError;
    }

    public Set<Entry<String, Slot>> getEntries() {
        return map.entrySet();
    }

    public void loadMap(HashMap<String, Slot> map) {
        HashMap<String, Slot> temp = this.map;
        this.map = map;
        boolean badFile = false;
        Iterator<Entry<String, Slot>> itr = map.entrySet().iterator();
        while (itr.hasNext() && !badFile) {
            Entry<String, Slot> entry = itr.next();
            if (checkCircular(entry.getKey(), entry.getValue())) {
                currentError += "cannot load such files";
                this.map = temp;
                badFile = true;
            }
        }
        setChanged();
        notifyObservers();
        currentError = "";
    }
}
