package _2AbstractFactory;

/**
 * Created by Зая on 21.05.2016.
 */
public class AbstractFactoryApp {
    public static void main(String[] args) {
DeviceFactory factory=getFactoryByCountryCode("EN");
        Mouse m=factory.getMouse();
        KeyBoard k=factory.getKeyboard();
        TouchPad t=factory.getTouchPad();
        m.click();
        k.print();
        k.println();
        t.track(10,35);
    }
    private static DeviceFactory getFactoryByCountryCode(String lang){
        switch (lang){
            case "RU":
                return new RuDeviceFactory();
            case "EN":
                return new EnDeviceFactory();
            default:
        throw new RuntimeException("Unsupported Country Code: "+ lang);
        }
    }
}

interface Mouse {
    void click();

    void dbClick();

    void scroll(int direction);
}

interface KeyBoard {
    void print();

    void println();
}

interface TouchPad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();

    KeyBoard getKeyboard();

    TouchPad getTouchPad();
}

class RuMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Щелчок мышью");
    }

    @Override
    public void dbClick() {
        System.out.println("Двойной щелчок мышью");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Скролим вверх");
        } else if (direction < 0) {
            System.out.println("Скролим вниз");
        } else {
            System.out.println("Не скролим");
        }
    }
}
class RuKeyboard implements KeyBoard{

    @Override
    public void print() {
        System.out.println("Печатаем строку");
    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переводом строки");
    }
}
class RuTouchPad implements TouchPad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s= (int) Math.sqrt( Math.pow(deltaX,2)+Math.pow(deltaY,2));
        System.out.println("Передвинулась на"+s+"пикселей");
    }
}
class EnMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void dbClick() {
        System.out.println("Mouse doouble click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Scroll Up");
        } else if (direction < 0) {
            System.out.println("Scroll Down");
        } else {
            System.out.println("No scrolling");
        }
    }
}
class EnKeyboard implements KeyBoard{

    @Override
    public void print() {
        System.out.println("Print");
    }

    @Override
    public void println() {
        System.out.println("Print line");
    }
}
class EnTouchPad implements TouchPad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s= (int) Math.sqrt( Math.pow(deltaX,2)+Math.pow(deltaY,2));
        System.out.println("Moved "+s+ " pixels");
    }
}
class EnDeviceFactory implements DeviceFactory{

    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public KeyBoard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EnTouchPad();
    }
}
class RuDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public KeyBoard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}