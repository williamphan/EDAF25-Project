package Instruction;

import Data.Memory;

/**
 * Created by will on 2015-02-20.
 */
public interface Instruction {
    public void run(Memory memory, int counter);
    public String toString();

}
