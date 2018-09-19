class Document {

}

class OldFashionedPrinter implements Printer {
    @Override
    public void print(Document d) {
        //
    }
}

interface Printer {
    void print(Document d);
}

interface Scanner {
    void scan(Document d);
}

class JustAPrinter implements Printer {
    @Override
    public void print(Document d) {
        //
    }
}

class Photocopier implements Printer, Scanner {
    @Override
    public void print(Document d) {

    }

    @Override
    public void scan(Document d) {

    }
}

interface MultiFunctionDevice extends Printer, Scanner {}

class MultiFunctionMachine implements MultiFunctionDevice {

    private Printer printer;
    private Scanner scanner;

    @Override
    public void print(Document d) {
        printer.print(d);
    }

    @Override
    public void scan(Document d) {
        scanner.scan(d);
    }
}

class Demo3 {

    public static void main(String[] args) {

    }
}