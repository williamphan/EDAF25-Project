package Instruction;

import Data.Memory;

public class Halt implements Instruction {
    @Override
    public int run(Memory memory, int counter) {
        return -1;
    }

    public String toString() {
        return "HLT";
    }
}
