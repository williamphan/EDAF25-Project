package Data;

/**
 * Created by will on 2015-02-20.
 */
public abstract class Word<T> implements Data {

    protected T word;

    public Word(T word){
        this.word = word;
    }

    public abstract T getValue();

    public abstract void copy(Word w1);

    public abstract void add(Word w1, Word w2);

    public abstract void mul(Word w1, Word w2);

    public abstract String toString();
}
