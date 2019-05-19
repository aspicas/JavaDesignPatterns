package behavioral.command;

class Command2
{
    enum Action
    {
        DEPOSIT, WITHDRAW
    }

    public Action action;
    public int amount;
    public boolean success;

    public Command2(Action action, int amount)
    {
        this.action = action;
        this.amount = amount;
    }
}

class Account
{
    public int balance;

    public void process(Command2 c)
    {
        switch (c.action) {
            case DEPOSIT:
                balance += c.amount;
                c.success = true;
                break;
            case WITHDRAW:
                c.success = balance >= c.amount;
                if (c.success) balance -= c.amount;
                break;
        }
    }
}

class Demo37 {
    public static void main(String[] args) {
        Account account = new Account();

        Command2 command = new Command2(Command2.Action.DEPOSIT, 100);
        account.process(command);
        System.out.println(account.balance);

        command = new Command2(Command2.Action.WITHDRAW, 50);
        account.process(command);
        System.out.println(account.balance);

        command = new Command2(Command2.Action.WITHDRAW, 150);
        account.process(command);
        System.out.println(account.balance);
    }
}