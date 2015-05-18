package Model;

import expr.Environment;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

import util.XLException;

public class Sheet extends Observable implements Environment {
    private HashMap<String, Slot> map;
    private String currentError = "", errorKey = "";

    //TODO: Fixa error vid borttagning av ett beroende
    //TODO: Cirkulärt = röda rutor?
    //TODO: Exception vid felinmatning
    //TODO: Menu, load, save osv.


    public Sheet() {
        map = new HashMap<String, Slot>();
    }

    /**
     * @return True if slot was added, false otherwise.
     */
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

    /**
     * @return True if slot was removed, false otherwise.
     */
    public boolean removeSlot(String key) {
        if (map.containsKey(key)) {
            map.remove(key);
            setChanged();
            notifyObservers();
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return True if circular dependency is detected, false otherwise.
     */
    private boolean checkCircular(String key, Slot value) {
        Slot currentSlot = map.get(key);

        map.put(key, new FakeSlot());

        try {
            value.value(this);
        } catch (XLException e) {
            map.put(key, currentSlot);
            currentError = "Circular error, ";
            return true;
        } catch (NullPointerException e) {
            System.out.println("Null");
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
            return "ERROR: " + e.getLocalizedMessage();
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
        // TODO Auto-generated method stub
        return map.entrySet();
    }

    public void loadMap(HashMap<String, Slot> map) {
        this.map = map;
        setChanged();
        notifyObservers();
    }
}
