class Person2 {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<SELF extends PersonBuilder<SELF>> {
    protected Person2 person = new Person2();

    public SELF withName(String name) {
        person.name = name;
        return self();
    }

    public Person2 build() {
        return person;
    }

    protected SELF self() {
        return (SELF) this;
    }
}

class EmployeeBuilder
        extends PersonBuilder<EmployeeBuilder> {
    public EmployeeBuilder worksAt(String position) {
        person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}

class Demo6 {
    public static void main(String[] args) {
        EmployeeBuilder pb = new EmployeeBuilder();
        Person2 david = pb
                .withName("David")
                .worksAt("Developer")
                .build();
        System.out.println(david);
    }
}