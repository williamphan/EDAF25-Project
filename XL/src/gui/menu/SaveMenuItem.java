package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import util.XLPrintStream;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
        XLPrintStream print = new XLPrintStream(path);
       // print.save(xl.getData());
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}