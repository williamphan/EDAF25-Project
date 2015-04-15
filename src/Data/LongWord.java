package Data;

/**
 * Created by will on 2015-02-20.
 */
public class LongWord extends Word<Long> {

    public LongWord(long word){
        super(word);
    }

    @Override
    public void copy(Word w1) {
        word =  ((LongWord)w1).getValue();
    }

    @Override
    public void add(Word w1, Word w2) {
        word = ((LongWord)w1).getValue() + ((LongWord)w2).getValue();
    }

    @Override
    public void mul(Word w1, Word w2) {
        word = ((LongWord)w1).getValue() * ((LongWord)w2).getValue();
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
