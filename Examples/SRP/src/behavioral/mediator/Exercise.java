package behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

class Participant
{
    public int value;
    private Mediator mediator;

    public Participant(Mediator mediator)
    {
        value = 0;
        mediator.participants.add(this);
        this.mediator = mediator;
    }

    public void say(int n)
    {
        mediator.broadcast(this, n);
    }
}

class Mediator
{
    public List<Participant> participants = new ArrayList<>();

    public void broadcast(Participant participant, int value) {
        for (Participant p : participants)
            if (!p.equals(participant)) p.value = value;
    }
}

class Demo45 {
    public static void main(String[] args) {
        Mediator mediator = new Mediator();
        Participant p1 = new Participant(mediator);
        Participant p2 = new Participant(mediator);

        System.out.println(p1.value);
        System.out.println(p2.value);

        p1.say(2);

        System.out.println(p1.value);
        System.out.println(p2.value);

        p2.say(4);

        System.out.println(p1.value);
        System.out.println(p2.value);
    }
}