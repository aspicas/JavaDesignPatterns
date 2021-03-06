package behavioral.visitor.acyclic;

interface Visitor {} //marker interface

interface ExpressionVisitor extends Visitor {
    void visit(Expression obj);
}

interface DoubleExpressionVisitor extends Visitor {
    void visit(DoubleExpression obj);
}

interface AdditionExpressionVisitor extends Visitor {
    void visit(AdditionExpression obj);
}

abstract class Expression {
    public void accept(Visitor visitor){
        if (visitor instanceof ExpressionVisitor)
            ((ExpressionVisitor) visitor).visit(this);
    }
}

class DoubleExpression extends Expression {
    public double value;

    public DoubleExpression(double value) {
        this.value = value;
    }

    @Override
    public void accept(Visitor visitor){
        if (visitor instanceof DoubleExpressionVisitor)
            ((DoubleExpressionVisitor) visitor).visit(this);
    }
}

class AdditionExpression extends Expression {
    public Expression left, right;

    public AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public void accept(Visitor visitor){
        if (visitor instanceof AdditionExpressionVisitor)
            ((AdditionExpressionVisitor) visitor).visit(this);
    }
}

class ExpressionPrinter implements DoubleExpressionVisitor, AdditionExpressionVisitor {
    private StringBuilder sb = new StringBuilder();

    @Override
    public void visit(DoubleExpression e) {
        sb.append(e.value);
    }

    @Override
    public void visit(AdditionExpression e) {
        sb.append("(");
        e.left.accept(this);
        sb.append("+");
        e.right.accept(this);
        sb.append(")");
    }

    @Override
    public String toString() {
        return sb.toString();
    }
}

class ExpressionCalculator implements DoubleExpressionVisitor, AdditionExpressionVisitor {
    public double result;

    @Override
    public void visit(DoubleExpression e) {
        result = e.value;
    }

    @Override
    public void visit(AdditionExpression e) {
        e.left.accept(this);
        double a = result;
        e.right.accept(this);
        double b = result;
        result = a + b;
    }
}

class Demo65 {
    public static void main(String[] args) {
        //1+(2+3)=6
        AdditionExpression e = new AdditionExpression(
                new DoubleExpression(1),
                new AdditionExpression(
                        new DoubleExpression(2),
                        new DoubleExpression(3)
                )
        );

        ExpressionPrinter ep = new ExpressionPrinter();
        ep.visit(e);
        System.out.println(ep);

        ExpressionCalculator ec = new ExpressionCalculator();
        ec.visit(e);
        System.out.println(ep + " = " + ec.result);
    }
}
