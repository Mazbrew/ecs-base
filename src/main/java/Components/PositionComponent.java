package Components;

import java.util.Random;

import Enums.ComponentEnum;
import Globals.Global;

public class PositionComponent implements IComponent{
    private final ComponentEnum componentEnum = ComponentEnum.POSITION; 
    private final Random rand = new Random();

    private float x;
    private float y;

    public PositionComponent(){
       this.x = rand.nextFloat(Global.SCREEN_WIDTH + 1);
       this.y = rand.nextFloat(Global.SCREEN_HEIGHT + 1); 
    }

    public PositionComponent(float x, float y){
        this.x = x;
        this.y = y;
    }

    @Override
    public ComponentEnum getComponentEnum() {
        return componentEnum;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
