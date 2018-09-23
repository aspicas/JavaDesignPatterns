class Person2 {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder {
    protected Person2 person = new Person2();

    public PersonBuilder withName(String name) {
        person.name = name;
        return this;
    }

    public Person2 build() {
        return person;
    }
}

class Demo6 {
    public static void main(String[] args) {
        PersonBuilder pb = new PersonBuilder();
        Person2 david = pb.withName("David").build();
    }
}