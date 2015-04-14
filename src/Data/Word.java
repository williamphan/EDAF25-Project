package Data;

/**
 * Created by will on 2015-02-20.
 */
public abstract class Word<T> implements Data {

    protected abstract T getValue();

    protected abstract void cpy(Word w1);

    protected abstract void add(Word w1, Word w2);

    protected abstract void mul(Word w1, Word w2);

    public abstract String toString();
}
