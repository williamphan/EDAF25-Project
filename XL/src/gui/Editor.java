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
        addActionListener(this);
        this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
        this.sheet = sheet;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String key = this.getText();

        if(key.equals("")){
            System.out.println("woohoo");
            sheet.removeSlot(key);
            return;
        }

        try {
            sheet.addSlot(currentSlot.toString(), key);
        } catch (Exception e) {
            System.out.println("Edtior ERROR: " + e.getMessage());
            //TODO Error message here
        }
    }

    @Override
    public void update(Observable o, Object arg) {
//        currentSlot.toString()
//        setText();
    }
}