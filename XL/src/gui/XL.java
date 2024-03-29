package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import Model.Sheet;
import Model.Slot;
import gui.menu.XLMenuBar;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private StatusLabel statusLabel;
    private XLList xlList;
    private Sheet sheet;

    public XL(XL oldXL) {
        this(oldXL.xlList, oldXL.counter);
    }
    
    public XL(XLList xlList, XLCounter counter) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        xlList.add(this);
        counter.increment();
        sheet = new Sheet();
        CurrentSlot currentSlot = new CurrentSlot();
        statusLabel = new StatusLabel(sheet);
        JPanel statusPanel = new StatusPanel(statusLabel, currentSlot);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, currentSlot, sheet);
        Editor editor = new Editor(currentSlot, sheet);
        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, sheet, currentSlot));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public int print(Graphics g, PageFormat pageFormat, int page) {
        if (page > 0)
            return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(g2d);
        return PAGE_EXISTS;
    }

    public void rename(String title) {
        setTitle(title);
        xlList.setChanged();
    }

    public static void main(String[] args) {
        new XL(new XLList(), new XLCounter());
    }

	public Set<Entry<String, Slot>> getData() {
		return sheet.getEntries();
	}
	
	public void setData(Map<String, Slot> map) {
		sheet.loadMap((HashMap<String, Slot>) map);
	}
}
