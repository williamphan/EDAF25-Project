package Instruction;

import Data.Memory;

/**
 * Created by will on 2015-02-20.
 */
public class Halt implements Instruction {
    @Override
    public int run(Memory memory, int counter) {
        //TODO
    	return -1;
    }

    public String toString() {
        return "HLT";
    }
}
