package Instruction;

import Data.Address;
import Data.Data;
import Data.LongWord;
import Data.Memory;

/**
 * Created by will on 2015-02-20.
 */
public class Copy implements Instruction {
    private Data data;
    private Address address;

    public Copy(Data data, Address address) {
        this.address = address;
        this.data = data;
    }

    @Override
    public int run(Memory memory, int counter) {
        memory.add(address.getIndex(), data.getValue(memory));
        return counter++;
    }

    public String toString(){
        //TODO
        return null;
    }
}
