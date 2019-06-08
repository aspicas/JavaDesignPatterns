package behavioral.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Token
{
    public int value = 0;

    public Token(int value)
    {
        this.value = value;
    }
}

class Memento2
{
    public List<Token> tokens = new ArrayList<>();

    public Memento2(List<Token> tokens) {
        for (Token token: tokens)
            this.tokens.add(token);
    }
}

class TokenMachine
{
    public List<Token> tokens = new ArrayList<>();

    public Memento2 addToken(int value)
    {
        Token token = new Token(value);
        tokens.add(token);
        return new Memento2(tokens);
    }

    public Memento2 addToken(Token token)
    {
        Token t = new Token(token.value);
        tokens.add(t);
        return new Memento2(tokens);
    }

    public void revert(Memento2 m)
    {
        tokens = m.tokens;
    }
}

class Demo47 {
    public static void main(String[] args) {
        TokenMachine tm = new TokenMachine();
        Memento2 m = tm.addToken(123);
        tm.addToken(456);
        tm.revert(m);

        System.out.println(tm.tokens.size()); // 1
        System.out.println(tm.tokens.get(0).value); // 123

        TokenMachine tm2 = new TokenMachine();
        tm2.addToken(1);
        Memento2 m2 = tm2.addToken(2);
        tm2.addToken(3);
        tm2.revert(m2);
        System.out.println(tm2.tokens.size());//2
        System.out.println(tm2.tokens.get(0).value);//1
        System.out.println(tm2.tokens.get(1).value);//2

        TokenMachine tm3 = new TokenMachine();
        System.out.println("Made a token with value 111 and kept a reference");
        Token token = new Token(111);
        System.out.println("Added this token to the list");
        tm3.addToken(token);
        Memento2 m3 = tm3.addToken(222);
        System.out.println("Changed this token's value to 333 :)");
        token.value = 333;
        tm3.revert(m3);

        System.out.println("At this point, token machine should have exactly two tokens, "
                        + "but you got " + tm3.tokens.size()); // 2

        System.out.println(tm3.tokens.get(0).value); // 111
    }
}