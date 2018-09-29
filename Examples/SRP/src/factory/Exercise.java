package factory;

class Person {
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class PersonFactory {
    private int id = -1;

    public Person createPerson(String name) {
        return new Person(id++, name);
    }
}

class Demo11 {
    public static void main(String[] args) {
        PersonFactory pf = new PersonFactory();
        Person person = pf.createPerson("Luis");
        Person person1 = pf.createPerson("Pepe");

        System.out.println(person);
        System.out.println(person1);
    }
}