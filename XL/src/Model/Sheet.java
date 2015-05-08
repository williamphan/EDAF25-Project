package Model;

import expr.Environment;

import java.util.HashMap;
import java.util.Observable;

import util.XLException;

public class Sheet extends Observable implements Environment {
	private HashMap<String, Slot> map;

	public Sheet() {
		map = new HashMap<String, Slot>();
	}

	/**
	 * @return True if slot was added, false otherwise.
	 */
	public boolean addSlot(String key, Slot value) {
		if (checkCircular(key, value))
			return false;

		map.put(key, value);
		// Notify?

		return true;
	}

	public boolean removeSlot(String key) {
		return false;
	}

	/**
	 * @return True if circular dependency is detected, false otherwise.
	 */
	private boolean checkCircular(String key, Slot value) {
		return false;
	}

	// Plats för fler metoder

	@Override
	public double value(String name) {
		if (map.get(name) == null) 
			throw new XLException(name + " does not exist in the sheet.");
		
		return map.get(name).value(this);
	}
}
