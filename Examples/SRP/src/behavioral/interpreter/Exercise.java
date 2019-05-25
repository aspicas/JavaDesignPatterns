package behavioral.interpreter;

import com.sun.jdi.Value;

import java.util.HashMap;
import java.util.Map;

class ExpressionProcessor
{
    enum Operator {
        NOTHING,
        PLUS,
        MINUS
    }

    public Map<Character, java.lang.Integer> variables = new HashMap<>();

    public java.lang.Integer parse(String text) {
        try {
            return java.lang.Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public int calculate(String expression) {
        int current = 0;
        Operator op = Operator.NOTHING;

        String[] parts = expression.split("(?<=[+-])");
        for (String part : parts) {
            String[] noOp = part.split("[+-]");
            String first = noOp[0];
            int value;

            java.lang.Integer parse = parse(first);
            if (parse != null) {
                value = parse.intValue();
            } else if (first.length() == 1 && variables.containsKey(first.charAt(0))) {
                value = variables.get(first.charAt(0));
            } else return 0;

            switch (op) {
                case NOTHING:
                    current = value;
                    break;
                case PLUS:
                    current += value;
                    break;
                case MINUS:
                    current -= value;
                    break;
            }

            if (part.endsWith("+")) op = Operator.PLUS;
            else if (part.endsWith("-")) op = Operator.MINUS;
        }
        return current;
    }
}

class Demo39 {
    public static void main(String[] args) {
        ExpressionProcessor ep = new ExpressionProcessor();
        ep.variables.put('x', 5);

        System.out.println(ep.calculate("1"));
        System.out.println(ep.calculate("1+2"));
        System.out.println(ep.calculate("1+x"));
        System.out.println(ep.calculate("1+yx"));
    }
}
