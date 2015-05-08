package gui.menu;

import gui.StatusLabel;
import gui.XL;
import gui.XLList;
import gui.CurrentSlot;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import Model.Sheet;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, Sheet sheet, CurrentSlot currentSlot) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel));
        file.add(new LoadMenuItem(xl, statusLabel));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem(sheet, currentSlot));
        edit.add(new ClearAllMenuItem(sheet));
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}