package gui;

import Model.Sheet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

public class Editor extends JTextField implements ActionListener, Observer {
    private CurrentSlot currentSlot;
    private Sheet sheet;

    public Editor(CurrentSlot currentSlot, Sheet sheet) {
        setBackground(Color.WHITE);
        setText(currentSlot.toString());
        addActionListener(this);
        this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
        this.sheet = sheet;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO Error message, "remove"
        if(!sheet.addSlot(currentSlot.toString(), this.getText())){
        //ERROR ERROR
        }
    }

    @Override
    public void update(Observable o, Object arg) {
//        currentSlot.toString()
//        setText();
    }
}