package Instruction;

import Data.Data;
import Data.Memory;

/**
 * Created by will on 2015-02-20.
 */
public class JumpEq implements Instruction {

    private Data data1, data2;
    int jump;

    public JumpEq(int jump, Data data1, Data data2) {
        this.data1 = data1;
        this.data2 = data2;
        this.jump = jump;
    }

    @Override
    public void run(Memory memory, int counter) {
        //TODO
    }

    public String toString() {
        //TODO
        return null;
    }
}
