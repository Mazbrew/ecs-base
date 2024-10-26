package Enums;

import java.util.HashMap;

public enum EntityType {
    CIRCLE;

    private static final HashMap<String, EntityType> stringToEntityTypeMap = new HashMap<>();

    static{
        for(EntityType value : EntityType.values()){
            stringToEntityTypeMap.put(value.name(), value);
        }
    }

    public static HashMap<String, EntityType> getStringToEntityTypeMap(){
        return stringToEntityTypeMap;
    }
}
