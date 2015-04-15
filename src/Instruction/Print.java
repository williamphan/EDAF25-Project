package Instruction;

import Data.Memory;
import Data.Data;

/**
 * Created by will on 2015-02-20.
 */
public class Print implements Instruction {

    private Data data;

    public Print(Data data) {
        this.data = data;
    }

    @Override
    public int run(Memory memory, int counter) {
        //TODO
    	return counter++;
    }

    public String toString() {
        //TODO
        return null;
    }
}
