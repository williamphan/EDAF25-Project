import Computer.Factorial;
import Computer.Program;
import Data.LongMemory;
import Computer.Computer;

/**
 * Created by will on 2015-02-20.
 */
public class Main {
    public static void main(String[] args) {
        Program factorial = new Factorial();
        System.out.println(factorial);
        Computer computer = new Computer(new LongMemory(1024));
        computer.load(factorial);
        computer.run();
    }
}
