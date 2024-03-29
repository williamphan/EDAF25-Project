package gui.menu;

import Model.Slot;
import gui.StatusLabel;
import gui.XL;
import util.XLBufferedReader;
import util.XLException;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class LoadMenuItem extends OpenMenuItem {

    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
    }

    protected void action(String path) throws FileNotFoundException {
        XLBufferedReader buffer = null;
        Map<String, Slot> map = new HashMap<String, Slot>();
        try {
            buffer = new XLBufferedReader(path);
        } catch (FileNotFoundException exe) {
            statusLabel.setText(exe.getMessage());
        }
        try {
            Set<Map.Entry<String, Slot>> set = xl.getData();
            for (Map.Entry<String, Slot> entry : set) {
                map.put(entry.getKey(), entry.getValue());
            }
            buffer.load(map);
        } catch (XLException exe) {
            statusLabel.setText("Could not load file: " + exe.getMessage());
        }
        xl.setData(map);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}
