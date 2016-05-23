package _3Builder;

/**
 * Created by Зая on 21.05.2016.
 */
public class BuilderApp {
    public static void main(String[] args) {
Car car=new CarBuilder()
        .buildMake("Mercedes")
        .buildTransmission(Transmission.MANUAL)
        .buildMaxSpeed(280)
        .build();
        System.out.println(car);
    }
}
enum Transmission{
    MANUAL,AUTO
}
class Car{
    String make;
    Transmission transmission;
    int maxSpeed;
    public void setMake (String make){this.make=make;}

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
class CarBuilder{
    String make="default";
    Transmission transmission=Transmission.AUTO;
    int s=120;

    CarBuilder buildMake(String make){
        this.make=make;
        return this;
    }
    CarBuilder buildTransmission (Transmission transmission){
        this.transmission=transmission;
        return this;
    }
    CarBuilder buildMaxSpeed (int s){
        this.s=s;
        return this;
    }
    Car build(){
        Car car=new Car();
        car.setMake(make);
        car.setTransmission(transmission);
        car.setMaxSpeed(s);
        return car;
    }


}