package Computer;

import java.util.ArrayList;

import Instruction.Instruction;

public class Program extends ArrayList<Instruction> {
    public Program() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (Instruction instruction : this) {
            sb.append(index + " " + instruction.toString() + "\n");
            index++;
        }
        sb.append("\n");
        return sb.toString();
    }
}
