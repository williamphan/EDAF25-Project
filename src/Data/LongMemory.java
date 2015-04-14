package Data;

/**
 * Created by will on 2015-02-20.
 */
public class LongMemory implements Memory {
    private Word[] memory;

    //Vet inte hur long kommer in här...
    public LongMemory(int size) {
        memory = new Word[size];
    }

    //Tror han menade såhär när han sa "lägga ihop" aka skriva över
    public void add(int index, Word word) {
        memory[index] = word;
    }

    public Word read(int index) {
        return memory[index];
    }


}