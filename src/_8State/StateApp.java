package _8State;

/**
 * Created by Зая on 23.05.2016.
 */
public class StateApp {
    public static void main(String[] args) {
 Station fm=new RadioFM();
        Radio radio=new Radio();
        radio.setStation(fm);
        for (int i=0;i<10;i++){
            radio.play();
            radio.nextStation();
        }
    }
}
interface Station{
    void play();
}
class Radio7 implements Station{

    @Override
    public void play() {
        System.out.println("Радио 7...");
    }
}
class RadioFM implements Station{

    @Override
    public void play() {
        System.out.println("Радио FM...");
    }
}
class RadioVesti implements Station{

    @Override
    public void play() {
        System.out.println("Радио Vesti...");
    }
}
//Context
class Radio{
    Station station;
    void setStation(Station st){
        station=st;
    }
    void nextStation(){
        if (station instanceof Radio7){
            setStation(new RadioFM());
        }else if (station instanceof RadioFM)
            setStation(new RadioVesti());
        else if (station instanceof RadioVesti)
            setStation(new Radio7());
    }
    void play(){
        station.play();
    }
}