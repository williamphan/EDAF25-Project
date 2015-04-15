package Instruction;

import Data.Address;
import Data.Data;
import Data.Word;

/**
 * Created by will on 2015-02-20.
 */
public class Mul extends Expression {
	Word w1;
	Word w2;

    public Mul(Data data1, Data data2, Address address) {
        super(data1, data2, address);
    }

    @Override
    protected void op(Word w1, Word w2, Address address) {
    	this.w1 = w1;
		this.w2 = w2;
		// TODO: The mul operation...
    }

    public String toString() {
        return "MUL " + w1.toString() + " " + w2.toString() + " " + address.toString();
    }
}
