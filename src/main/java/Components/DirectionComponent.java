package Components;

import java.util.Random;

import Enums.ComponentEnum;

public class DirectionComponent implements IComponent{
    private final ComponentEnum componentEnum = ComponentEnum.DIRECTION;
    private final Random rand = new Random();

    private float direction;

    public DirectionComponent(){
        direction = (float) (rand.nextFloat() * 2 * Math.PI);
    }

    public DirectionComponent(float direction){
        this.direction = direction;
    }

    @Override
    public ComponentEnum getComponentEnum() {
        return componentEnum;
    }

    public float getDirection() {
        return direction;
    }

    public void setDirection(float direction) {
        this.direction = direction;
    }
}
