package Entities;

import Enums.EntityType;
import Globals.Global;

public class CircleEntity implements IEntity{
    private int rollingId = 0;

    @Override
    public String getId() {
        rollingId ++;
        return Global.ENTITY_STRING + EntityType.CIRCLE + "_" + rollingId; 
    }
}
