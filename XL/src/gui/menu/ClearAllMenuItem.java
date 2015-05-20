package gui.menu;

import Model.Sheet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ClearAllMenuItem extends JMenuItem implements ActionListener {

    private Sheet sheet;

    public ClearAllMenuItem(Sheet sheet) {
        super("Clear all");
        this.sheet = sheet;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clear();
    }
}