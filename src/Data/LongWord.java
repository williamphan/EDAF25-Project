package Data;

public class LongWord extends Word<Long> {

    public LongWord(long word) {
        super(word);
    }

    @Override
    public void add(Word w1, Word w2) {
        word = ((LongWord) w1).getValue() + ((LongWord) w2).getValue();
    }

    @Override
    public void mul(Word w1, Word w2) {
        word = ((LongWord) w1).getValue() * ((LongWord) w2).getValue();
    }

    @Override
    public Word getValue(Memory memory) {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(word);
    }

    public Long getValue() {
        return word;
    }
}
