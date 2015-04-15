package Instruction;

import Data.Memory;

public interface Instruction {
    public int run(Memory memory, int counter);

    public String toString();
}
