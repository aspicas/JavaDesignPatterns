package behavioral.chainOfResponsability;

import java.util.ArrayList;
import java.util.List;

abstract class Creature3
{
    protected Game2 game;
    protected int attack, defense;

    public Creature3(Game2 game, int attack, int defense) {
        this.game = game;
        this.attack = attack;
        this.defense = defense;
    }

    public abstract int getAttack();
    public abstract int getDefense();
    public abstract void query(Object source, StatQuery sq);

    @Override
    public String toString() {
        return "Creature3{" +
                "game=" + game +
                ", attack=" + attack +
                ", defense=" + defense +
                '}';
    }
}

class Goblin extends Creature3
{
    protected  Goblin(Game2 game, int attack, int defense) {
        super(game, attack, defense);
    }

    public Goblin(Game2 game)
    {
        super(game, 1, 1);
    }

    @Override
    public int getAttack()
    {
        StatQuery q = new StatQuery(Statistic.ATTACK);
        for (Creature3 c: game.creatures)
            c.query(this, q);
        return q.result;
    }

    @Override
    public int getDefense()
    {
        StatQuery q = new StatQuery(Statistic.DEFENSE);
        for (Creature3 c: game.creatures)
            c.query(this, q);
        return q.result;
    }

    @Override
    public void query(Object source, StatQuery sq) {
        if (source == this) {
            switch (sq.statistic) {
                case ATTACK:
                    sq.result += attack;
                    break;
                case DEFENSE:
                    sq.result += defense;
                    break;
            }
        } else if (sq.statistic == Statistic.DEFENSE) {
            sq.result++;
        }
    }
}

class GoblinKing extends Goblin
{
    public GoblinKing(Game2 game)
    {
        super(game, 3, 3);
    }

    @Override
    public void query(Object source, StatQuery sq) {
        if (source != this && sq.statistic == Statistic.ATTACK) {
            sq.result++; // every goblin gets +1 attack
        } else super.query(source, sq);
    }
}

enum Statistic
{
    ATTACK, DEFENSE
}

class Game2
{
    public List<Creature3> creatures = new ArrayList<>();
}

class StatQuery
{
    public Statistic statistic;
    public int result;

    public StatQuery(Statistic statistic)
    {
        this.statistic = statistic;
    }
}

class Demo35 {
    public static void main(String[] args) {
        Game2 game = new Game2();
        Goblin goblin1 = new Goblin(game);
        game.creatures.add(goblin1);

        System.out.println("---------------------");
        System.out.println("Goblin1");
        System.out.println("Attack: " + goblin1.getAttack());
        System.out.println("Defense: " + goblin1.getDefense());

        Goblin goblin2 = new Goblin(game);
        game.creatures.add(goblin2);

        System.out.println("---------------------");
        System.out.println("Goblin1");
        System.out.println("Attack: " + goblin1.getAttack());
        System.out.println("Defense: " + goblin1.getDefense());
        System.out.println("Goblin2");
        System.out.println("Attack: " + goblin2.getAttack());
        System.out.println("Defense: " + goblin2.getDefense());

        GoblinKing goblinKing = new GoblinKing(game);
        game.creatures.add(goblinKing);
        System.out.println("---------------------");
        System.out.println("Goblin1");
        System.out.println("Attack: " + goblin1.getAttack());
        System.out.println("Defense: " + goblin1.getDefense());
        System.out.println("Goblin2");
        System.out.println("Attack: " + goblin2.getAttack());
        System.out.println("Defense: " + goblin2.getDefense());
        System.out.println("GoblinK");
        System.out.println(goblinKing);

    }
}