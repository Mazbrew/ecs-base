package Components;

import java.util.Random;

import Enums.ComponentEnum;
import Globals.Global;

public class SpeedComponent implements IComponent{
    private final ComponentEnum componentEnum = ComponentEnum.SPEED;
    private final Random rand = new Random();

    private float speed;

    public SpeedComponent(){
        this.speed = rand.nextFloat(Global.BASE_SPEED); 
    }

    public SpeedComponent(float speed){
        this.speed = speed;
    }

    @Override
    public ComponentEnum getComponentEnum() {
        return componentEnum;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
