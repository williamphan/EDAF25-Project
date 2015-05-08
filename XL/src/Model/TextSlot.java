package Model;

import expr.Environment;

public class TextSlot implements Slot {
	private String text;

	public TextSlot(String text) {
		this.text = text;
	}

	@Override
	public double value(Environment env) {
		return 0;
	}

	@Override
	public String toString() {
		return text;
	}

	@Override
	public String print(Environment env) {
		return toString();
	}
}