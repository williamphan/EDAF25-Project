package Computer;

import java.util.ArrayList;
import Instruction.Instruction;
/**
 * Created by will on 2015-02-20.
 */
public class Program extends ArrayList<Instruction> {
    public Program() {

    }
    public String toString(){
    	String returnString = "";
    	int index = 0;
    	for (Instruction instruction : this) {
    		returnString += index + " " + instruction.toString() + "\n";
    		index++;
    	}
    	returnString += "\n";
    	//TODO: returnString += resultatet??
        return returnString;
    }
}
