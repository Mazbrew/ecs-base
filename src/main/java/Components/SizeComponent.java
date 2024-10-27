package Components;

import Enums.ComponentEnum;
import Enums.EntityType;
import Globals.Global;

public class SizeComponent implements IComponent{
    private final ComponentEnum componentEnum = ComponentEnum.SIZE;

    private int width;
    private int height;

    public SizeComponent(int width, int height){
        this.width = width;
        this.height = height;
    }

    public SizeComponent(EntityType entityType){
        switch(entityType){
            case CIRCLE:
                this.width = this.height = Global.CIRCLE_SIZE;
                break;
        }
    }

    @Override
    public ComponentEnum getComponentEnum() {
        return componentEnum;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
