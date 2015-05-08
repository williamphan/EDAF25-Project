package gui;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;

public class SlotLabels extends GridPanel {
    private List<SlotLabel> labelList;

    public SlotLabels(int rows, int cols, CurrentSlot currentSlot) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                String position = ch+String.valueOf(row);
                SlotLabel label = new SlotLabel(position, currentSlot);
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel currentLabel= labelList.get(0);
        currentLabel.setBackground(Color.YELLOW);
        currentSlot.set(currentLabel);
    }
}
