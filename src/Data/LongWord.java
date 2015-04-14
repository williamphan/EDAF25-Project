package Data;

/**
 * Created by will on 2015-02-20.
 */
public class LongWord extends Word<Long> {

    private long word;

    public LongWord(long word) {
        this.word = word;
    }

    @Override
    public void cpy(Word w1) {
        //TODO
    }

    @Override
    public void add(Word w1, Word w2) {
        //TODO
    }

    @Override
    public void mul(Word w1, Word w2) {
        //TODO
    }

    @Override
    public Word getValue(Memory memory) {
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(word);
    }

    //Hittade inget bra sätt att tvinga på den här metoden (funkar just nu ej med primitiva typer)
    //Alt 1: Returnera en string för alla typer
    //Alt 2: Ta bort den från abstrakta klassen, fast då kanske man glömmer att implementera metoden här
    //Alt 3: ???
    public Long getValue(){
        return word;
    }
}
