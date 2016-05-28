package _9Decorator;

/**
 * Created by Зая on 23.05.2016.
 */
public class DecoratorApp {
    public static void main(String[] args) {
//        PrinterInterface printerInterface = new Printer("Hello");
//        printerInterface.print();
//
//        PrinterInterface printerInterface1=new QuotesDecorator(new Printer("Hello"));
//        printerInterface1.print();

//        PrinterInterface printerInterface2=new LeftBracketDecorator(new Printer("Hello"));
//        printerInterface2.print();

        PrinterInterface printerInterface3=new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Hello"))));
        printerInterface3.print();
    }
}

interface PrinterInterface {
    void print();
}

class Printer implements PrinterInterface {
    String value;
    public Printer(String value) {
        this.value = value;
    }
    @Override
    public void print() {
        System.out.print(value);
    }
}

abstract class Decorator implements PrinterInterface{
    PrinterInterface component;
    public Decorator( PrinterInterface component ){
       this.component=component;
    }
    public void print() {
        component.print();
    }
}
class QuotesDecorator extends Decorator implements PrinterInterface {
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }
    @Override
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}
class LeftBracketDecorator extends Decorator implements PrinterInterface {
    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }
    @Override
    public void print() {
        System.out.print("[");
        super.print();
    }
}
class RightBracketDecorator extends Decorator implements PrinterInterface {
    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }
    @Override
    public void print() {
        super.print();
        System.out.print("]");
    }
}