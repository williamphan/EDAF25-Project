package gui.menu;

import gui.CurrentSlot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import Model.Sheet;

class ClearMenuItem extends JMenuItem implements ActionListener {
   
	private Sheet sheet;
	private CurrentSlot currentSlot;
	
	public ClearMenuItem() {
    	super("Clear");
    	this.sheet=sheet;
    	this.currentSlot=currentSlot;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        //sheet.removeSlot(currentSlot.getName());
    }
}