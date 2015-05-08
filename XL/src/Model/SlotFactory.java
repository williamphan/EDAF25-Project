package Model;

import expr.ExprParser;

public class SlotFactory {
	public static Slot create(String text) {
		if (text.length() > 0 && text.charAt(0) == '#') {
			return new TextSlot(text);
		}

		ExprParser parser = new ExprParser();
		try {
			return new ExprSlot(parser.build(text));
		} catch (Exception e) {
			return null;
		}
	}
}