package behavioral.interpreter;

import java.util.Stack;

interface IExpression {
	public int interpret();
}

class NumberExpression implements IExpression {
	private int number;

	public NumberExpression(int number) {
		this.number = number;
	}

	public NumberExpression(String s) {
		number = Integer.parseInt(s);
	}

	@Override
	public int interpret() {
		return number;
	}
}

class MultiplyExpression implements IExpression {
	private IExpression leftExpression;
	private IExpression rightExpresion;

	public MultiplyExpression(IExpression leftExpression,
			IExpression rightExpresion) {
		this.leftExpression = leftExpression;
		this.rightExpresion = rightExpresion;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() * rightExpresion.interpret();
	}
}

class PlusExpression implements IExpression {
	private IExpression leftExpression;
	private IExpression rightExpresion;

	public PlusExpression(IExpression leftExpression, IExpression rightExpresion) {
		this.leftExpression = leftExpression;
		this.rightExpresion = rightExpresion;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() + rightExpresion.interpret();
	}
}

class MinusExpression implements IExpression {
	private IExpression leftExpression;
	private IExpression rightExpresion;

	public MinusExpression(IExpression leftExpression,
			IExpression rightExpresion) {
		this.leftExpression = leftExpression;
		this.rightExpresion = rightExpresion;
	}

	@Override
	public int interpret() {
		return leftExpression.interpret() - rightExpresion.interpret();
	}
}

public class DemoInterpreter {
	public static boolean isOperator(String s) {
		if (s.equals("+") || s.equals("-") || s.equals("*")) {
			return true;
		} else {
			return false;
		}
	}

	public static IExpression getOperatorInstance(String s, IExpression left,
			IExpression right) {
		switch (s.charAt(0)) {
		case '+':
			return new PlusExpression(left, right);
		case '-':
			return new MinusExpression(left, right);
		case '*':
			return new MultiplyExpression(left, right);
		}
		return null;
	}

	public static void main(String[] args) {
		String tokenString = "4 3 2 - 1 + *";
		Stack<IExpression> stack = new Stack<IExpression>();

		String[] tokenList = tokenString.split(" ");
		for (String s : tokenList) {
			if (isOperator(s)) {
				IExpression rightExpression = stack.pop();
				IExpression leftExpression = stack.pop();
				IExpression operator = getOperatorInstance(s, leftExpression,
						rightExpression);
				int result = operator.interpret();
				stack.push(new NumberExpression(result));
			} else {
				IExpression i = new NumberExpression(s);
				stack.push(i);
			}
		}
		System.out.println("Result: " + stack.pop().interpret());
	}
}
