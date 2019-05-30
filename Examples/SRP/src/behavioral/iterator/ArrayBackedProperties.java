package behavioral.iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

class SimpleCreature {
    private int strength, ability, intelligence;

    public int max() {
        return Math.max(strength,
                Math.max(ability, intelligence));
    }

    public int sum() {
        return strength + ability + intelligence;
    }

    public double average() {
        return sum() / 3.0;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAbility() {
        return ability;
    }

    public void setAbility(int ability) {
        this.ability = ability;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
}

class Creature implements Iterable<Integer> {
    private int [] stats = new int[3];

    public int getStrength() { return stats[0]; }
    public void setStrength(int value) { stats[0] = value; }
    public int getAbility() { return stats[1]; }
    public void setAbility(int value) { stats[1] = value; }
    public int getIntelligence() { return stats[2]; }
    public void setIntelligence(int value) { stats[2] = value; }

    public int sum() {
        return IntStream.of(stats).sum();
    }

    public int max() {
        return IntStream.of(stats).max().getAsInt();
    }

    public double average() {
        return IntStream.of(stats).average().getAsDouble();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        for (int x: stats)
            action.accept(x);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return IntStream.of(stats).spliterator();
    }

    @Override
    public Iterator<Integer> iterator() {
        return IntStream.of(stats).iterator();
    }
}

class Demo41 {
    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.setAbility(12);
        creature.setIntelligence(13);
        creature.setStrength(17);
        System.out.println("Creature has a max stat of " + creature.max()
                + ", total stats = " + creature.sum()
                + ", average stat = " + creature.average());
    }
}
