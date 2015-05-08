package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;

public class Editor extends JTextField implements ActionListener, Observer{
    CurrentSlot currentSlot;

    public Editor(CurrentSlot currentSlot) {
        setBackground(Color.WHITE);
        setText(currentSlot.toString());
        addActionListener(this);
        this.currentSlot = currentSlot;
        currentSlot.addObserver(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(this.getText());

        //TODO Add slot to sheet
    }

    @Override
    public void update(Observable o, Object arg) {
        //Update text
    }
}