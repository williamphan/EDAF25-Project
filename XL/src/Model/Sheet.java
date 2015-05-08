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
	public boolean addSlot(String key, String text) {
		Slot value = new Slot();
		if (checkCircular(key, value))
			return false;

		map.put(key, value);
		setChanged();
		notifyObservers();

		return true;
	}

	/**
	 * @return True if slot was removed, false otherwise.
	 */
	public boolean removeSlot(String key) {
		if (addSlot(key, new FakeSlot())) {
			map.remove(key);
			setChanged();
			notifyObservers();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return True if circular dependency is detected, false otherwise.
	 */
	private boolean checkCircular(String key, Slot value) {
		Slot currentSlot = map.get(key);

		map.put(key, new FakeSlot());

		try {
			value.value(this);
		} catch (XLException e) {
			return true;
		}

		map.put(key, currentSlot);

		return false;
	}

	public String print(String key) {
		Slot slot = map.get(key);
		if (slot == null)
			return "";

		return slot.print(this);
	}

	public double value(String name) {
		if (map.get(name) == null)
			throw new XLException(name + " does not exist in the sheet.");

		return map.get(name).value(this);
	}

	public void clear() {
		map = new HashMap<String, Slot>();
		setChanged();
		notifyObservers();
	}
}