package oop.interpreter;

import java.util.Stack;

public class Calculation {
    private final Stack<AbstractExpression> stack = new Stack<>();

    public Calculation(String expression) {
        initExpression(expression.split(" "));
    }

    private void initExpression(String[] symbols) {
        for (int i = 0; i < symbols.length; i++) {
            String symbol = symbols[i];

            switch (symbol) {
                case "+":
                    stack.push(
                        new AddExpression(
                            stack.pop(),
                            new NumberExpression(Integer.parseInt(symbols[++i]))
                        )
                    );
                    break;

                case "-":
                    stack.push(
                            new ReduceExpression(
                                    stack.pop(),
                                    new NumberExpression(Integer.parseInt(symbols[++i]))
                            )
                    );
                    break;

                default:
                    stack.push(new NumberExpression(Integer.parseInt(symbol)));
                    break;
            }
        }
    }

    public int getResult() {
        return stack.isEmpty() ? -1 : stack.pop().interpreter();
    }
}
