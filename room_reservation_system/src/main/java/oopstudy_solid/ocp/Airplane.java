package oopstudy_solid.ocp;

public class Airplane implements Vehicle{

    @Override
    public void move() {
        System.out.println("Fly to the sky! Infinity and beyond!");
    }

    @Override
    public void fix() {
        System.out.println("fix the blade!");
    }
}
