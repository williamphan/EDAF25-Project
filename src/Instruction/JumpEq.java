package Instruction;

import Data.Data;
import Data.Memory;

public class JumpEq implements Instruction {

    private Data data1, data2;
    private int jump;

    public JumpEq(int jump, Data data1, Data data2) {
        this.data1 = data1;
        this.data2 = data2;
        this.jump = jump;
    }

    @Override
    public int run(Memory memory, int counter) {
        if (data1.getValue(memory) == data2.getValue(memory)) {
            return jump;
        } else {
            return counter + 1;
        }
    }

    public String toString() {
        return "JEQ " + jump + " " + data1 + " " + data2;
    }
}
