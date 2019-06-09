package behavioral.nullObject;

interface Log2
{
    // max # of elements in the log
    int getRecordLimit();

    // number of elements already in the log
    int getRecordCount();

    // expected to increment record count
    void logInfo(String message);
}

class Account
{
    private Log2 log;

    public Account(Log2 log)
    {
        this.log = log;
    }

    public void someOperation() throws Exception
    {
        int c = log.getRecordCount();
        log.logInfo("Performing an operation");
        if (c+1 != log.getRecordCount())
            throw new Exception();
        if (log.getRecordCount() >= log.getRecordLimit())
            throw new Exception();
    }
}

class NullLog2 implements Log2
{
    private int recordCount = Integer.MIN_VALUE;

    @Override
    public int getRecordLimit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int getRecordCount() {
        return recordCount;
    }

    @Override
    public void logInfo(String message) {
        ++recordCount;
    }
}

class Demo49 {
    public static void main(String[] args) throws Exception {
        Account a = new Account(new NullLog2());
        for (int i = 0; i < 100; ++i)
            a.someOperation();
    }
}
