package Model;

import util.XLException;
import expr.Environment;

public class FakeSlot implements Slot {

	@Override
	public double value(Environment env) throws XLException {
		throw new XLException("Circular dependency");
	}

	@Override
	public String print() {
		throw new XLException("The fake slot has nothing to print");
	}
}
