package gui;

import java.awt.*;
import java.util.Observable;

public class CurrentSlot extends Observable {
    private SlotLabel currentLabel;

    public void set(SlotLabel slotLabel) {
        currentLabel = slotLabel;
        setChanged();
        notifyObservers();
        addObserver(slotLabel);
    }

    public void resetLabel(){
        currentLabel.setBackground(Color.white);
    }

    public String toString(){
        return null;
    }

}
