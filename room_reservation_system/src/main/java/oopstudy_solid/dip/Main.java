package oopstudy_solid.dip;

public class Main {
    public static void main(String[] args) {
        Switchable bulb = new LightBulb();
        ElectricSwitch bulbSwitch = new ElectricSwitch(bulb);
        bulbSwitch.press(); // 불을 켭니다.
        bulbSwitch.press(); // 불을 끕니다.

        Switchable fan = new Fan();
        ElectricSwitch fanSwitch = new ElectricSwitch(fan);
        fanSwitch.press(); // 팬을 켭니다.
        fanSwitch.press(); // 팬을 끕니다.
    }
}