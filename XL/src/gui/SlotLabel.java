package gui;

import Model.Sheet;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
    private CurrentSlot currentSlot;
    private String position;
    private Sheet sheet;

    public SlotLabel(String position, CurrentSlot currentSlot, Sheet sheet) {
        super("                    ", Color.WHITE, RIGHT);
        addMouseListener(this);
        this.currentSlot = currentSlot;
        this.position = position;
        this.sheet = sheet;
        sheet.addObserver(this);

    }

    @Override
    public void update(Observable o, Object arg) {
        this.setText(sheet.print(position));
//        System.out.println("Observers: " + currentSlot.countObservers());
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