package Instruction;

import Data.Address;
import Data.Data;
import Data.Word;

public class Add extends Expression {

    public Add(Data data1, Data data2, Address address) {
        super(data1, data2, address);
    }

    protected void op(Word w1, Word w2, Word address) {
        address.add(w1, w2);
    }

    public String toString() {
        return "ADD " + data1 + " " + data2 + " " + address;
    }
}
