package gui.menu;

import Model.Sheet;
import gui.CurrentSlot;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClearMenuItem extends JMenuItem implements ActionListener {

    private Sheet sheet;
    private CurrentSlot currentSlot;

    public ClearMenuItem(Sheet sheet, CurrentSlot currentSlot) {
        super("Clear");
        this.sheet = sheet;
        this.currentSlot = currentSlot;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        sheet.removeSlot(currentSlot.toString());
    }
}