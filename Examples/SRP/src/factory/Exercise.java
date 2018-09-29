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
    private static int id = -1;

    public static Person createPerson(String name) {
        ++id;
        return new Person(id, name);
    }
}

class Demo11 {
    public static void main(String[] args) {
        Person person = PersonFactory.createPerson("Luis");
        Person person1 = PersonFactory.createPerson("Pepe");

        System.out.println(person);
        System.out.println(person1);
    }
}