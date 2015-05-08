package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
    private CurrentSlot currentSlot;
    private String position;

    public SlotLabel(String position, CurrentSlot currentSlot) {
        super("        "+position+"          ", Color.WHITE, RIGHT);
        addMouseListener(this);
        this.currentSlot = currentSlot;
        this.position = position;

        //Observer till sheet

    }

    @Override
    public void update(Observable o, Object arg) {
        // setText()
        System.out.println(currentSlot.countObservers());
        currentSlot.deleteObserver(this);

    }

    public String toString() {
        return position;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        currentSlot.resetLabel();
        this.setBackground(Color.YELLOW);
        currentSlot.set(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }


}