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
		setChanged();
		notifyObservers();

		return true;
	}

	/**
	 * @return True if slot was removed, false otherwise.
	 */
	public boolean removeSlot(String key) {
		Slot currentSlot = map.get(key);
		
		try {
			// något
		} catch (XLException e) {
			// något annat
			
			return false;
		}
		
		map.remove(key);
		setChanged();
		notifyObservers();
		
		return true;
	}

	/**
	 * @return True if circular dependency is detected, false otherwise.
	 */
	private boolean checkCircular(String key, Slot value) {
		Slot currentSlot = map.get(key);

		FakeSlot fakeSlot = new FakeSlot();
		map.put(key, fakeSlot);

		try {
			value.value(this);
		} catch (XLException e) {
			System.out.println(e.toString());
			return true;
		}

		map.put(key, currentSlot);

		return false;
	}

	// Plats fÃ¶r fler metoder

	@Override
	public double value(String name) {
		if (map.get(name) == null)
			throw new XLException(name + " does not exist in the sheet.");

		return map.get(name).value(this);
	}
}
