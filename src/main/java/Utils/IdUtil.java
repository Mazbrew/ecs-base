package Utils;

import Enums.EntityType;
import Globals.Global;

public final class IdUtil {
    public static String createEntityId(String entityType, int id){
        return Global.ENTITY_STRING + entityType + Global.SEPARATOR + id;
    }

    public static EntityType idStringToEntityType(String id){
        String entityTypeString = id.split("_")[1];

        return EntityType.getStringToEntityTypeMap().get(entityTypeString);
    }
}
