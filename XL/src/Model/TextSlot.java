package Model;

public class TextSlot implements Slot {
    private String text;

    public TextSlot(String text) {
        this.text = text;
    }

    @Override
    public double value() {
        return 0;
    }

    public String toString(){
        return text;
    }
}