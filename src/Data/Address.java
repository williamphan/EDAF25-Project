package Data;
/**
 * Created by will on 2015-02-20.
 */
public class Address implements Data {
    private int index;

    public Address(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public Word getValue(Memory memory){
        return memory.read(index);
    }

    public String toString(){
        return String.valueOf(index);
    }
}
