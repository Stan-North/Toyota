package factory;

import car_components.CarComponent;


public class ElementsGeneric<Wheel extends CarComponent, wheel2 extends CarComponent, wheel3 extends CarComponent,
        wheel4 extends CarComponent, electrics extends CarComponent, engine extends CarComponent,
        fuelTank extends CarComponent, headlight extends CarComponent> {
    private Wheel wheel1;
    private wheel2 wheel2;
    private wheel3 wheel3;
    private wheel4 wheel4;
    private electrics electrics;
    private engine engine;
    private fuelTank fuelTank;
    private headlight headlight;

    public ElementsGeneric(Wheel wheel1, wheel2 wheel2, wheel3 wheel3, wheel4 wheel4, electrics electrics,
                           engine engine, fuelTank fuelTank, headlight headlight) {
        this.wheel1 = wheel1;
        this.wheel2 = wheel2;
        this.wheel3 = wheel3;
        this.wheel4 = wheel4;
        this.electrics = electrics;
        this.engine = engine;
        this.fuelTank = fuelTank;
        this.headlight = headlight;
    }

    public Wheel getWheel1() {
        return wheel1;
    }

    public wheel2 getWheel2() {
        return wheel2;
    }

    public wheel3 getWheel3() {
        return wheel3;
    }

    public wheel4 getWheel4() {
        return wheel4;
    }

    public electrics getElectrics() {
        return electrics;
    }

    public engine getEngine() {
        return engine;
    }

    public fuelTank getFuelTank() {
        return fuelTank;
    }

    public headlight getHeadlight() {
        return headlight;
    }
}