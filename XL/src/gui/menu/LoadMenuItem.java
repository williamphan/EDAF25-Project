package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

class LoadMenuItem extends OpenMenuItem {
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Load");
    }

    protected void action(String path) throws FileNotFoundException {
        // TODO
    	FileReader fr = new FileReader(path);
    	BufferedReader br = new BufferedReader(fr);
    	String line;
    	int current = 0;
    	try{
    		while((line = br.readLine()) != null){
    			///////
    			
    			current++;
    		}
    	}
    	catch(IOException ex){
    		System.err.println(ex.getMessage());
    	}
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}