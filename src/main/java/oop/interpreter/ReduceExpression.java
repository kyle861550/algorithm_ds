package oop.interpreter;

public class ReduceExpression extends OperatorExpression {

    public ReduceExpression(AbstractExpression a1, AbstractExpression a2) {
        super(a1, a2);
    }

    @Override
    public int interpreter() {
        return a1.interpreter() - a2.interpreter();
    }
}
