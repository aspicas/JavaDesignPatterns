package behavioral.nullObject;

interface Log {
    void info(String msg);
    void warn(String msg);
}

class ConsoleLog implements Log {
    @Override
    public void info(String msg) {
        System.out.println(msg);
    }

    @Override
    public void warn(String msg) {
        System.out.println("WARNING: " + msg);
    }
}

final class NullLog implements Log {
    @Override
    public void info(String msg) {

    }

    @Override
    public void warn(String msg) {

    }
}

class BankAccount {
    private Log log;
    private int balance;

    public BankAccount(Log log) {
        this.log = log;
    }

    public void deposit(int amount) {
        balance += amount;

        log.info("Deposited " + amount);
    }
}

class Demo48 {
    public static void main(String[] args) {
        Log log = new NullLog();
        BankAccount account = new BankAccount(log);
        account.deposit(100);
    }
}