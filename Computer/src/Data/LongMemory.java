package Data;

public class LongMemory implements Memory {
    private Word[] memory;

    public LongMemory(int size) {
        memory = new Word[size];
    }

    public void add(int index, Word word) {
        memory[index] = word;
    }

    public Word read(int index) {
        return memory[index];
    }


}