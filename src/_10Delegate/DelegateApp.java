package _10Delegate;

/**
 * Created by Зая on 23.05.2016.
 */
public class DelegateApp {
    public static void main(String[] args) {
//A a=new A();
//        a.f();
        Painter painter=new Painter();
        painter.setGraphics(new Square());
        painter.draw();
        painter.setGraphics(new Circle());
        painter.draw();
        painter.setGraphics(new Triangle());
        painter.draw();
    }
}
class A{
    void f(){
        System.out.println("f()");
        /*
        *
        * *
        * *
        * *
        * *
        *
         */
    }
}
class B{
    A a=new A();
    void f(){
        a.f();
    }
}
interface Graphics{
    void draw();
}

class Triangle implements Graphics{

    @Override
    public void draw() {
        System.out.println("We are drawing a triangle");
    }
}
class Square implements Graphics{

    @Override
    public void draw() {
        System.out.println("We are drawing a square");
    }
}
class Circle implements Graphics{

    @Override
    public void draw() {
        System.out.println("We are drawing a circle");
    }
}
class Painter {
    Graphics graphics;
    void setGraphics(Graphics g){
        graphics=g;
    }
    void draw(){
        graphics.draw();
    }
}