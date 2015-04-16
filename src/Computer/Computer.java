package Computer;

import Data.Memory;

public class Computer {
    int counter = 0;
    Program program;
    Memory memory;

    public Computer(Memory memory) {
        this.memory = memory;
    }

    public void load(Program program) {
        this.program = program;
    }

    public void run() {
        while (counter != -1) {
            counter = program.get(counter).run(memory, counter);
        }
    }
}
