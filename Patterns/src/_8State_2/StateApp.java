package _8State_2;

/**
 * Created by Зая on 23.05.2016.
 */
public class StateApp {
    public static void main(String[] args) {
Human human=new Human();
        Activity work=new Work();
        human.setState(work);
        for (int i=0;i<6;i++) {
            human.doSomething();
        }
    }
}

class Human {
    private Activity state;

    public void setState(Activity s) {
        this.state = s;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}

interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {

    @Override
    public void doSomething(Human context) {
        System.out.println("Работаем!");
        context.setState(new Weekend());
    }
}

class Weekend implements Activity {
    private int count = 0;

    @Override
    public void doSomething(Human context) {
        if (count < 3) {
            System.out.println("Отдыхаем (Zzz)");
            count++;
        } else {
            context.setState(new Work());
        }
    }
}