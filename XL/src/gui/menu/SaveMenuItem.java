package gui.menu;

import gui.StatusLabel;
import gui.XL;
import util.XLPrintStream;

import javax.swing.*;
import java.io.FileNotFoundException;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
        XLPrintStream print = new XLPrintStream(path);
        print.save(xl.getData());
        print.close();
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}