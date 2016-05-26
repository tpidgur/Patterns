package _15Visitor;

/**
 * дослушать особенности шабл
 */
public class VisitorApp {
    public static void main(String[] args) {
//        Element body = new BodyElement();
//        Element engine = new EngineElement();
//        Visitor hooligan = new HooliganVisitor();
//
//        body.accept(hooligan);
//        engine.accept(hooligan);
//
//        Visitor mechanic = new HMechanicalVisitor();
//
//        body.accept(mechanic);
//        engine.accept(mechanic);
        Element car=new CarElement();
        car.accept(new HooliganVisitor());
        System.out.println();
        car.accept(new HMechanicalVisitor());

    }
}

interface Visitor {
    void visit(EngineElement engine);

    void visit(BodyElement body);

    void visit(CarElement car);

    void visit(WheelElement wheel);
}

interface Element {
    void accept(Visitor visitor);
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);

    }
}

class EngineElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class WheelElement implements Element {
    private String name;

    public WheelElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {
    Element[] elements;

    public CarElement() {
        this.elements = new Element[]{new WheelElement("переднее левое"),
                new WheelElement("переднее правое"), new WheelElement("заднее левое"),
                new WheelElement("заднее правое"), new BodyElement(), new EngineElement()};
    }


    @Override
    public void accept(Visitor visitor) {
        for (Element elem:elements){
            elem.accept(visitor);
        }
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Постучал по корпусу");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Покурил внутири машины");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Пнул "+wheel.getName()+" колесо");
    }
}

class HMechanicalVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Отполировал кузов");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Прверил внешний вид автомобиля");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Подкачал " +wheel.getName()+"колесо");
    }
}
