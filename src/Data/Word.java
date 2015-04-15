package Data;

public abstract class Word<T> implements Data {

    protected T word;

    public Word(T word) {
        this.word = word;
    }

    public abstract T getValue();

    public abstract void add(Word w1, Word w2);

    public abstract void mul(Word w1, Word w2);

    public abstract String toString();
}
