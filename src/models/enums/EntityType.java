package models.enums;

import models.herbivores.*;
import models.plants.Grass;
import models.predators.*;

public enum EntityType {

    GRASS("grass", Grass.class),
    WOLF("wolf", Wolf.class),
    MOUSE("mouse", Mouse.class),
    BOAR("boar", Boar.class),
    BUFFALO("buffalo", Buffalo.class),
    CATERPILLAR("caterpillar", Caterpillar.class),
    DEER("deer", Deer.class),
    DUCK("duck", Duck.class),
    GOAT("goat", Goat.class),
    HORSE("horse", Horse.class),
    RABBIT("rabbit", Rabbit.class),
    SHEEP("sheep", Sheep.class),
    BEAR("bear", Bear.class),
    BOA("boa", Boa.class),
    EAGLE("eagle", Eagle.class),
    FOX("fox", Fox.class);


    private String type;
    private Class clazz;

    EntityType(String type, Class clazz) {
        this.type = type;
        this.clazz = clazz;
    }
    public Class<?> getClazz() {
        return clazz;
    }

}
