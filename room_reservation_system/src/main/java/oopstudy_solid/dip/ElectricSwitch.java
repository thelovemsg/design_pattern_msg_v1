package oopstudy_solid.dip;

public class ElectricSwitch {
    public Switchable device;
    public boolean on;

    public ElectricSwitch(Switchable device) {
        this.device = device;
        this.on = false;
    }

    public void press() {
        if (on) {
            device.turnOff();
            on = false;
        } else {
            device.turnOn();
            on = true;
        }
    }

}
