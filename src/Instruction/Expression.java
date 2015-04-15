package Instruction;

import Data.*;

/**
 * Created by will on 4/14/15.
 */
public abstract class Expression implements Instruction {

    protected Data data1;
    protected Data data2;
    protected Address address;

    public Expression(Data data1, Data data2, Address address) {
        this.data1 = data1;
        this.data2 = data2;
        this.address = address;
    }

    protected abstract void op(Word w1, Word w2, Address address);

    public int run(Memory memory, int counter) {
        op(data1.getValue(memory), data2.getValue(memory), address);
        return counter++;
    }

    public String toString() {
        //TODO
        return null;
    }

}
