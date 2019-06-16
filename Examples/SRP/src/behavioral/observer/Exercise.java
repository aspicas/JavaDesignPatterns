package behavioral.observer;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

class Event2<T> {
    private List<BiConsumer<Object, T>> consumers = new ArrayList<>();

    public void subscribe(BiConsumer<Object, T> consumer) {
        consumers.add(consumer);
    }

    public void invoke(Object sender, T args) {
        for (BiConsumer<Object, T> o: consumers)
            o.accept(sender, args);
    }
}

class Game
{
    public Event2<Void> ratEnters = new Event2<>();
    public Event2<Void> ratDies = new Event2<>();
    public Event2<Rat> notifyRat = new Event2<>();
}

class Rat implements Closeable
{
    private Game game;
    public int attack = 1;

    public Rat(Game game)
    {
        this.game = game;
        game.ratEnters.subscribe((sender, args) -> {
            if (sender != this) {
                ++attack;
                game.notifyRat.invoke(this, (Rat) sender);
            }
        });
        game.notifyRat.subscribe((sender, rat) -> {
            if (rat == this) ++attack;
        });
        game.ratDies.subscribe((sender, arg) -> --attack);
        game.ratEnters.invoke(this, null);
    }

    @Override
    public void close() throws IOException
    {
        game.ratDies.invoke(this, null);
    }
}

class Demo52 {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        Rat rat = new Rat(game);
        System.out.println("rat attack: " + rat.attack);

        Rat rat2 = new Rat(game);
        System.out.println("rat attack: " + rat.attack);
        System.out.println("rat2 attack: " + rat2.attack);

        try (Rat rat3 = new Rat(game)) {
            System.out.println("rat attack: " + rat.attack);
            System.out.println("rat2 attack: " + rat2.attack);
            System.out.println("rat3 attack: " + rat3.attack);
        }

        System.out.println("rat attack: " + rat.attack);
        System.out.println("rat2 attack: " + rat2.attack);
    }
}