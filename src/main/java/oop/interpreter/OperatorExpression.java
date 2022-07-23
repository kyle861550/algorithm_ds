package oop.interpreter;

public abstract class OperatorExpression extends AbstractExpression {
    protected final AbstractExpression a1;
    protected final AbstractExpression a2;

    public OperatorExpression(AbstractExpression a1, AbstractExpression a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

}
