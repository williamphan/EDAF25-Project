package Instruction;

import Data.Memory;

/**
 * Created by will on 2015-02-20.
 */
public class Jump implements Instruction {
    int index;
    public Jump(int index){
        this.index = index;
    }

    @Override
    public int run(Memory memory, int counter) {
    	return index;
    }

    public String toString() {
        return "JMP " + index;
    }
}
