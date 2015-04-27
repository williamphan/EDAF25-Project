package Model;

import expr.Expr;

public class ExprSlot implements Slot {
    private Expr expr;

    public ExprSlot(Expr expr) {
        this.expr = expr;
    }

    @Override
    public double value() {
        return 0;
    }

    public String toString() {
        return expr.toString();
    }
}
