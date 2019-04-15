package structural.proxy;

class Person2
{
    private int age;

    public Person2(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String drink() { return "drinking"; }
    public String drive() { return "driving"; }
    public String drinkAndDrive() { return "driving while drunk"; }
}

class ResponsiblePerson
{
    private Person2 person;

    public ResponsiblePerson(Person2 person)
    {
        this.person = person;
    }

    public int getAge() { return person.getAge(); }

    public void setAge(int age){
        person.setAge(age);
    }

    public String drink() { return person.getAge() < 18 ? "too young" : person.drink(); }
    public String drive() { return person.getAge() < 16 ? "too young" : person.drive(); }
    public String drinkAndDrive() { return "dead"; }
}

class Demo32 {
    public static void main(String[] args) {
        Person2 person = new Person2(10);
        ResponsiblePerson rp = new ResponsiblePerson(person);
        System.out.println(rp.drink());
        System.out.println(rp.drive());
        System.out.println(rp.drinkAndDrive());

        rp.setAge(20);
        System.out.println(rp.drink());
        System.out.println(rp.drive());
        System.out.println(rp.drinkAndDrive());
    }
}