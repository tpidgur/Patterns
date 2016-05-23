package _3Builder_2;

/**
 * Created by Зая on 21.05.2016.
 */
public class BuilderApp {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Car car=director.buildCar();
        System.out.println(car);
    }}

    enum Transmission {
        MANUAL, AUTO
    }

    class Car {
        String make;
        Transmission transmission;
        int maxSpeed;

        public void setMake(String make) {
            this.make = make;
        }

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

    abstract class CarBuilder {
        Car car;

        void createCar() {
            car = new Car();
        }

        abstract void buildMake();

        abstract void buildTransmission();

        abstract void buildSpeed();

        Car getCar() {
            return car;
        }
    }

    class FordMondeoBuilder extends CarBuilder {

        @Override
        void buildMake() {
            car.setMake("Ford Mondeo");
        }

        @Override
        void buildTransmission() {
            car.setTransmission(Transmission.AUTO);
        }

        @Override
        void buildSpeed() {
            car.setMaxSpeed(260);
        }
    }

    class SubaruBuilder extends CarBuilder {

        @Override
        void buildMake() {
            car.setMake("Subaru");
        }

        @Override
        void buildTransmission() {
            car.setTransmission(Transmission.MANUAL);
        }

        @Override
        void buildSpeed() {
            car.setMaxSpeed(320);
        }
    }

    class Director {
        CarBuilder builder;

        void setBuilder(CarBuilder b) {
            builder = b;
        }

        Car buildCar() {
            builder.createCar();
            builder.buildMake();
            builder.buildTransmission();
            builder.buildSpeed();
            Car car = builder.getCar();
            return car;
        }
    }


