package behavioral.observer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class Event<TArgs> {
    private int count = 0;
    private Map<Integer, Consumer<TArgs>> handlers = new HashMap<>();

    public Subscription addHandler(Consumer<TArgs> handle) {
        int i = count;
        handlers.put(count++, handle);
        return new Subscription(this, i);
    }

    public void fire(TArgs args) {
        for (Consumer<TArgs> handler: handlers.values())
            handler.accept(args);
    }

    public class Subscription implements AutoCloseable {
        private Event<TArgs> event;
        private int id;

        public Subscription(Event<TArgs> event, int id) {
            this.event = event;
            this.id = id;
        }

        @Override
        public void close() {
            event.handlers.remove(id);
        }
    }
}

class PropertyChangedEventArgs2 {
    public Object source;
    public String propertyName;

    public PropertyChangedEventArgs2(Object source, String propertyName) {
        this.source = source;
        this.propertyName = propertyName;
    }
}

class Person2 {
    public Event<PropertyChangedEventArgs2> propertyChanged = new Event<>();

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        propertyChanged.fire(new PropertyChangedEventArgs2(
                this, "age"
        ));
    }
}

class Demo51 {
    public static void main(String[] args) {
        Person2 person = new Person2();
        Event<PropertyChangedEventArgs2>.Subscription sub =
                person.propertyChanged.addHandler(x -> {
                    System.out.println("Person's " + x.propertyName
                            + " has changed");
                });
        person.setAge(17);
        person.setAge(18);
        sub.close();
        person.setAge(19);
    }
}
