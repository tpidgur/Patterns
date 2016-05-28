package _18Facade;

import org.omg.PortableServer.POA;

/**
 *подобие с делегатом
 */
public class FacadeApp {
    public static void main(String[] args) {
       Computer computer=new Computer();
        computer.copy();
    }
}
class Computer{
    Power power=new Power();
    DVDRom dvdRom=new DVDRom();
    HDD hdd=new HDD();

    void copy(){
        power.on();
        dvdRom.load();
        hdd.copyFromDVD(dvdRom);
    }
}
class Power{
    void on()
    {
        System.out.println("Switch power on");
    }
    void off()
    {
        System.out.println("Switch power off");
    }
}
class DVDRom{
    public boolean data=false;
    public boolean hasData(){
        return data;
    }
    void load (){
        data=true;
    }
    void unload (){
        data=false;
    }
}
class HDD{
    void copyFromDVD(DVDRom dvd){
        if (dvd.hasData()){
            System.out.println("The data are coppied from disk");
        } else {
            System.out.println("Please insert disk with data");
        }
    }
}