package Model;

import expr.Environment;
import expr.Expr;

public class ExprSlot implements Slot {
    private Expr expr;

    public ExprSlot(Expr expr) {
        this.expr = expr;
    }

    @Override
    public double value(Environment env) {
        return expr.value(env);
    }

    @Override
    public String toString() {
        return expr.toString();
    }
    
    @Override
    public String print(Environment env) {
    	return Double.toString(value(env));
    }
}