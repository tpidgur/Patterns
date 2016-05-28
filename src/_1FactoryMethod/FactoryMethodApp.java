package _1FactoryMethod;

import java.util.Date;

/**
 * Created by Зая on 21.05.2016.
 */
public class FactoryMethodApp {
    public static void main(String[] args) {
        Watch watch = new DigitalWatch();
        watch.showTime();
        watch = new RomeWatch();
        watch.showTime();

        WatchMaker maker = new RomeWatchMaker();//new DigitalWatchMaker();
        Watch watch2 = maker.createWatch();
        watch2.showTime();

        WatchMaker maker2 = getMakerByName("Rome");
        Watch watch3 = maker.createWatch();
        watch3.showTime();
    }

    public static WatchMaker getMakerByName(String maker) {
        if (maker.equals("Digital"))
            return new DigitalWatchMaker();
        else if (maker.equals("Rome"))
            return new RomeWatchMaker();
        throw new RuntimeException("The manufacturing line is not supported now" + maker);
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("VII-XX");
    }
}

interface WatchMaker {
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker {
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}