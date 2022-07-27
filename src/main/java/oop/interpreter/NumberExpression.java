package oop.interpreter;

public class NumberExpression extends AbstractExpression {

    private final int num;

    public NumberExpression(int num) {
        this.num = num;
    }

    @Override
    public int interpreter() {
        return num;
    }
}
