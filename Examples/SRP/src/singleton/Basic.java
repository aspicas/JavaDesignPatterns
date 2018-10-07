package singleton;

class BasicSingleton {

    private BasicSingleton() {

    }

    private static final BasicSingleton INSTANCE = new BasicSingleton();

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class Demo15 {
    public static void main(String[] args) {
        BasicSingleton singleton = BasicSingleton.getInstance();
        BasicSingleton singleton2 = BasicSingleton.getInstance();
        singleton.setValue(123);
        System.out.println(singleton.getValue());

        singleton2.setValue(1234);
        System.out.println(singleton2.getValue());
        System.out.println(singleton.getValue());
    }
}