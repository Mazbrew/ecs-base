package Components;

import java.util.Random;

import com.raylib.Jaylib.Color;

import Enums.ComponentEnum;

public class ColorComponent implements IComponent{
    private final ComponentEnum componentEnum = ComponentEnum.COLOR;
    private final Random rand = new Random();

    private Color color;

    public ColorComponent(){
        this.color = new Color(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256), 50); 
    }

    public ColorComponent(Color color){
        this.color = color;
    }

    public ColorComponent(int r, int g, int b){
        this.color = new Color(r,g,b, 50);
    }

    @Override
    public ComponentEnum getComponentEnum() {
        return componentEnum;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}