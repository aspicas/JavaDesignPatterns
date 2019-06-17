package behavioral.state;

class CombinationLock
{
    private int [] combination;
    private int enters = 0;
    public String status;

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        status = "LOCKED";
    }

    public void enterDigit(int digit)
    {
        if (status == "LOCKED") status = "";
        status += digit;
        if (combination[enters] != digit) status = "ERROR";
        else enters++;
        if (combination.length == enters) status = "OPEN";
    }
}

class Demo56 {
    public static void main(String[] args) {
        CombinationLock cl = new CombinationLock(new int[]{1, 2, 3, 4});
        System.out.println(cl.status);

        cl.enterDigit(1);
        System.out.println(cl.status);

        cl.enterDigit(2);
        System.out.println(cl.status);

        cl.enterDigit(5);
        System.out.println(cl.status);

        cl.enterDigit(4);
        System.out.println(cl.status);
    }
}
