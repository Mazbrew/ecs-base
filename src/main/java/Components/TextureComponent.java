package Components;

import Enums.ComponentEnum;

public class TextureComponent implements IComponent{
    private final ComponentEnum componentEnum = ComponentEnum.TEXTURE;

    @Override
    public ComponentEnum getComponentEnum() {
        return componentEnum;
    }

}
