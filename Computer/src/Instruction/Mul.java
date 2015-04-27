package Instruction;

import Data.Address;
import Data.Data;
import Data.Word;

public class Mul extends Expression {

    public Mul(Data data1, Data data2, Address address) {
        super(data1, data2, address);
    }

    @Override
    protected void op(Word w1, Word w2, Word address) {
        address.mul(w1, w2);
    }

    public String toString() {
        return "MUL " + data1 + " " + data2 + " " + address;
    }
}
