package Instruction;

import Data.Address;
import Data.Data;
import Data.Word;

/**
 * Created by will on 2015-02-20.
 */
public class Add extends Expression {
	private Word w1;
	private Word w2;

	public Add(Data data1, Data data2, Address address) {
		super(data1, data2, address);
	}

	protected void op(Word w1, Word w2, Address address) {
		this.w1 = w1;
		this.w2 = w2;
		// TODO: The add operation...
	}

	public String toString() {
		return "ADD " + w1.toString() + " " + w2.toString() + " " + address.toString();
	}
}
