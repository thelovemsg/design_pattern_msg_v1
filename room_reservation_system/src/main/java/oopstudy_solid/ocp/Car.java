package oopstudy_solid.ocp;

public class Car implements Vehicle{

    @Override
    public void move() {
        System.out.println("drive the road");
    }

    @Override
    public void fix() {
        System.out.println("fix the car!!");
    }
}
