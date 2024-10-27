package Components;

import com.raylib.Jaylib.Rectangle;

import Enums.ComponentEnum;

public class BoundingBoxComponent implements IComponent {
    private final ComponentEnum componentEnum = ComponentEnum.BOUNDING_BOX;

    private Rectangle boundingBox;

    public BoundingBoxComponent(int x, int y, int width, int height) {
        this.boundingBox = new Rectangle(x, y, width, height);
    }

    @Override
    public ComponentEnum getComponentEnum() {
        return componentEnum;
    }

    public Rectangle getBoundingBox() {
        return boundingBox;
    }

    public void setBoundingBox(Rectangle boundingBox) {
        this.boundingBox = boundingBox;
    }
}
