package com.dev.practice.test;
 enum Color{
    RED, BLUE;
}

class Rectangle{
    Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
public class EnumDemo1 {
    public static void main(String[] args) {
        Rectangle r1=new Rectangle();
        r1.setColor(Color.BLUE);
        Rectangle r2=r1;
        r2.setColor(Color.RED);

        System.out.println(r1.getColor());
        System.out.println(r2.getColor());


    }

}
