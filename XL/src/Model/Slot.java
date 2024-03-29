package Model;

import expr.Environment;

public interface Slot {
    public double value(Environment env);
    public String toString();
    public String print(Environment env);
}
