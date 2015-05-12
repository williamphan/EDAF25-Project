package gui;

import Model.Sheet;
import util.XLException;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;
// TODO Tror inte denna är färdig då det finns många fel när man gör inmatningat
public class Editor extends JTextField implements ActionListener, Observer {
    private CurrentSlot currentSlot;
    private Sheet sheet;

    public Editor(CurrentSlot currentSlot, Sheet sheet) {
        setBackground(Color.WHITE);
        this.currentSlot = currentSlot;
        this.sheet = sheet;
        addActionListener(this);
        currentSlot.addObserver(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String key = this.getText();

        if (key.equals("")) {
            sheet.removeSlot(currentSlot.toString());
            return;
        }

        sheet.addSlot(currentSlot.toString(), key);

    }

    @Override
    public void update(Observable o, Object arg) {
        setText(sheet.printExpr(currentSlot.toString()));
    }
}