/**
 * Created by will on 2015-02-20.
 */
public class Copy implements Instruction {
    public Copy(LongWord lw, Address address) {
        address.set(lw);
    }
}
