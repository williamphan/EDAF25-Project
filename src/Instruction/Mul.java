package Instruction;

import Data.Address;
import Data.Data;
import Data.Word;

/**
 * Created by will on 2015-02-20.
 */
public class Mul extends Expression {

    public Mul(Data data1, Data data2, Address address) {
        super(data1, data2, address);
    }

    @Override
    protected void op(Word w1, Word w2, Address address) {
        //TODO
    }

    public String toString() {
        //TODO
        return null;
    }
}
