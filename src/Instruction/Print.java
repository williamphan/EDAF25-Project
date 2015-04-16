package Instruction;

import Data.Memory;
import Data.Data;

public class Print implements Instruction {

    private Data data;

    public Print(Data data) {
        this.data = data;
    }

    @Override
    public int run(Memory memory, int counter) {
        return counter++;
    }

    public String toString() {
        return "PRT " + data;
    }
}
