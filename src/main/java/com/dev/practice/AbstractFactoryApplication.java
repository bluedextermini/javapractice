package com.dev.practice;

import static java.lang.System.*;

public class AbstractFactoryApplication {

    public static void main(String[] args) {
        //get com.dev.practice.Sofa
        FurnitureFactory factory;
        factory= new MetalFurnitureFactory();
        factory.createChair().seatOnChair();
        factory.createSofa().seatOnSofa();
    }
}
class Chair implements IChair{
      public void seatOnChair(){
          out.println("Chair Seat");
      }

}

class WoodenSofa implements ISofa {

    public WoodenSofa() {

    }
    @Override
    public void seatOnSofa(){
        out.println("WoodenSofa Seat");
    }
}

class MetalSofa implements ISofa {

    public MetalSofa() {

    }
    @Override
    public void seatOnSofa(){
        out.println("MetalSofa Seat");
    }
}

class WoodenChair implements IChair {

    public WoodenChair() {

    }
    @Override
    public void seatOnChair(){
        out.println("WoodenChair Seat");
    }
}

class MetalChair implements IChair {

    public MetalChair() {

    }
    @Override
    public void seatOnChair(){
        out.println("MetalChair Seat");
    }
}



interface FurnitureFactory {

    public ISofa createSofa();

    public IChair createChair();
}

class WoodenFurnitureFactory implements FurnitureFactory{
    public WoodenFurnitureFactory(){

    }
    public ISofa createSofa(){
        return new WoodenSofa();
    }

    public IChair createChair(){
        return new WoodenChair();
    }
}

class MetalFurnitureFactory implements FurnitureFactory{
    public MetalFurnitureFactory(){

    }
    public ISofa createSofa(){
        return new MetalSofa();
    }

    public IChair createChair(){
        return new MetalChair();
    }
}

interface ISofa {
    void seatOnSofa();
}


interface IChair {
    void seatOnChair();
}


